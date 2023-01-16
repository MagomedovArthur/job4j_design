package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Key not found");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i].replaceFirst("-", "");
            String[] array = arg.split("=", 2);
            validate(array, args);
            values.put(array[0], array[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    private void validate(String[] array, String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (!args[i].startsWith("-")) {
                throw new IllegalArgumentException("Missing hyphen sign");
            }
        }
        if (array.length < 2) {
            throw new IllegalArgumentException("Missing equals sign");
        }
        if (array[0].isEmpty()) {
            throw new IllegalArgumentException("Key not found");
        }
        if (array[1].isEmpty()) {
            throw new IllegalArgumentException("Value not found");
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}