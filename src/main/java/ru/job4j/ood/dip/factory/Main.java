package ru.job4j.ood.dip.factory;

public class Main {

    public static void main(String[] args) {
        Employees ivan = new Employees(
                "Ivan", new Machine("mach", new Electricity(220)));
        Employees artur = new Employees(
                "Artur", new Machine("mach", new Electricity(200)));
    }
}