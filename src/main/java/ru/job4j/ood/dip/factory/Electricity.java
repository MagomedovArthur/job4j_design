package ru.job4j.ood.dip.factory;

public class Electricity {
    private int volt;

    public Electricity(int volt) {
        this.volt = volt;
    }

    public int getVolt() {
        return volt;
    }

    public void setVolt(int volt) {
        this.volt = volt;
    }
}