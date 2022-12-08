package ru.job4j.io;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class MultiplicationTable {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("matrix.txt")) {
            for (byte i = 0; i < 9; i++) {
                for (byte j = 0; j < 9; j++) {
                    String str = String.valueOf(((i + 1) * (j + 1)));
                    out.write(str.getBytes(StandardCharsets.UTF_8));
                    out.write("  ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}