package ru.job4j.ood.lsp.product;

import java.util.List;

public class Warehouse extends AbstractStore {
    @Override
    public boolean add(Food food, boolean condition) {
        boolean result = false;
        condition = food.getRemainingShelfLife() < 25;
        if (condition) {
            result = foodsList.add(food);
        }
        return result;
    }

    @Override
    public List<Food> findAll() {
        return foodsList;
    }
}