package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private List<String> answers;
    private List<String> log = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<String> phrases = readPhrases();
        boolean switchLoop = true;
        while (switchLoop) {
            String userInput = scanner.nextLine();
            log.add(userInput);
            if (userInput.equals(OUT)) {
                switchLoop = false;
            } else if (userInput.equals(STOP)) {
                while (!userInput.equals(CONTINUE)) {
                    String str = scanner.nextLine();
                    log.add(str);
                    if (str.equals(OUT)) {
                        switchLoop = false;
                        break;
                    }
                    if (str.equals(CONTINUE)) {
                        break;
                    }
                }
            } else {
                String list = phrases.get(new Random().nextInt(phrases.size()));
                System.out.println(list);
                log.add(list);
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                answers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(botAnswers,
                Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/answers.txt", "./data/log2.txt");
        cc.run();
    }
}