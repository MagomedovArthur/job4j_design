package ru.job4j.ood.dip.factory;

public class Machine {
    private String name;
    private Electricity electricity;

    public Machine(String name, Electricity electricity) {
        this.name = name;
        this.electricity = electricity;
    }
}