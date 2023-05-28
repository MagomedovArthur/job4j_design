package ru.job4j.ood.ocp;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("This is rectangle...");
    }

    public void drawRiangle() {
        System.out.println("This is triangle...");
    }
}
