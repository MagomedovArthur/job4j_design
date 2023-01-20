package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        String pathTarget = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String outPath = argsName.get("out");
        String filter = argsName.get("filter");
        List<String> dataFromFile = readFile(pathTarget);
        writeFilteredData(dataFromFile, filter, outPath, delimiter, outPath);
    }

    private static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void writeFilteredData(List<String> data, String filter,
                                          String targetFile, String delimiter, String out) {
        List<String> filteredData = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        String[] filterField = filter.split(",");
        String[] firstLine = data.get(0).split(delimiter);
        for (int i = 0; i < filterField.length; i++) {
            for (int j = 0; j < firstLine.length; j++) {
                if (filterField[i].equals(firstLine[j])) {
                    indices.add(j);
                }
            }
        }
        for (String strings : data) {
            String[] line = strings.split(delimiter);
            StringBuilder temp = new StringBuilder();
            for (int index : indices) {
                temp.append(line[index]).append(delimiter);
            }
            String filteredStrings = String.valueOf(temp);
            if (String.valueOf(temp).endsWith(delimiter)) {
                filteredStrings = String.valueOf(temp).substring(0, String.valueOf(temp).length() - 1);
            }
            filteredData.add(filteredStrings);
        }

        if ("stdout".equals(out)) {
            for (String list : filteredData) {
                System.out.println(list);
            }
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(targetFile))) {
                filteredData.forEach(pw::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void validationArgs(ArgsName argsName) {
        File fileIn = new File(argsName.get("path"));
        if (!fileIn.exists()) {
            throw new IllegalArgumentException("File not found.");
        }
        File fileOut = new File(argsName.get("out"));
        if (!"stdout".equals(argsName.get("out")) && !fileOut.exists()) {
            throw new IllegalArgumentException("File not found.");
        }
        if (!";".equals(argsName.get("delimiter")) && !",".equals(argsName.get("delimiter"))) {
            throw new IllegalArgumentException("Incorrect csv file format");
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        validationArgs(argsName);
        handle(argsName);
    }
}