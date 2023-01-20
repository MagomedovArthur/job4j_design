package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int one = 25;
        byte two = 20;
        short three = 90;
        long four = 32;
        float five = 23.3F;
        double six = 95.05;
        boolean seven = true;
        char eight = 222;
        LOG.debug("These are Java primitive types: "
                        + "int = {},  byte = {}, short = {}, long = {},"
                        + " float = {}, double = {}, boolean = {},  char = {}",
                one, two, three, four, five, six, seven, eight);
    }
}