package ru.job4j.ood.dip.factory;

public class Employees {
    private String firstName;
    private Machine machine;

    public Employees(String firstName, Machine machine) {
        this.firstName = firstName;
        this.machine = machine;
    }
}