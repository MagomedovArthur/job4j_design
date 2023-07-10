package ru.job4j.ood.lsp.product;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected final List<Food> foodsList = new ArrayList<>();

    @Override
    public boolean add(Food food, boolean condition) {
        boolean result = false;
        if (condition) {
            result = foodsList.add(food);
        }
        return result;
    }

    @Override
    public List<Food> findAll() {
        return foodsList;
    }

    @Override
    public void clear() {
        foodsList.clear();
    }
}