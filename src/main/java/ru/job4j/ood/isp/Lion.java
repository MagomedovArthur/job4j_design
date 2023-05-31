package ru.job4j.ood.isp;

public class Lion implements Animals {

    private String name = "Lion";

    @Override
    public void walk(String name) {
        System.out.println(name + " walks...");
    }

    @Override
    public void fly(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void swim(String name) {
        System.out.println(name + " swims...");
    }
}
