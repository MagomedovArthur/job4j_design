package ru.job4j.ood.isp;

public class Eagle implements Animals {

    private String name = "Eangle";

    @Override
    public void walk(String name) {
        System.out.println(name + " walks...");
    }

    @Override
    public void fly(String name) {
        System.out.println(name + " flies...");
    }

    @Override
    public void swim(String name) {
        throw new UnsupportedOperationException();
    }
}
