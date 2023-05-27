package ru.job4j.ood.srp;

public interface Actions<T> {

    boolean deleteItem(String nameItem);

    boolean addItem(String nameItem);

    void showAllItems();
}
