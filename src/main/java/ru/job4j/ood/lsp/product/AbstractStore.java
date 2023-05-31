package ru.job4j.ood.lsp.product;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected final List<Food> foodsList = new ArrayList<>();

    @Override
    public Food add(Food food, boolean condition) {
        if (condition) {
            foodsList.add(food);
        }
        return food;
    }

    @Override
    public List<Food> findAll() {
        List<Food> result = new ArrayList<>();
        for (Food food : foodsList) {
            result.add(food);
        }
        return result;
    }
}