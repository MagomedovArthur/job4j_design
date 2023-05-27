package ru.job4j.ood.srp;

import java.util.ArrayList;
import java.util.List;

public class UserActions implements Actions {

    List<Item> items = new ArrayList<>();

    @Override
    public boolean deleteItem(String nameItem) {
        return items.remove(nameItem);
    }

    @Override
    public boolean addItem(String nameItem) {
        return items.add(new Item());
    }

    @Override
    public void showAllItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    class Item {
        private int id;
        private String name;
    }
}
