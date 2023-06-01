package ru.job4j.ood.lsp.product;

import java.util.List;

public class Shop extends AbstractStore {
    @Override
    public boolean add(Food food, boolean condition) {
        boolean result = false;
        boolean checkingFirstCondition = food.getRemainingShelfLife() >= 25
                && food.getRemainingShelfLife() <= 75;
        boolean checkingSecondCondition = food.getRemainingShelfLife() > 75
                && food.getRemainingShelfLife() <= 100;
        if (checkingFirstCondition) {
            condition = true;
            result = foodsList.add(food);
        } else if (checkingSecondCondition) {
            condition = true;
            double newPrice = food.getPrice() - ((food.getPrice() * food.getDiscount()) / 100);
            food = new Food(
                    food.getName(),
                    food.getCreateDate(),
                    food.getExpiryDate(),
                    newPrice,
                    food.getDiscount()
            );
            result = foodsList.add(food);
        }
        return result;
    }

    @Override
    public List<Food> findAll() {
        return foodsList;
    }
}