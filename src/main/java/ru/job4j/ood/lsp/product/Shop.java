package ru.job4j.ood.lsp.product;

import java.util.List;

public class Shop extends AbstractStore {
    AbstractStore abstractStore = new AbstractStore() {
        @Override
        public Food add(Food food, boolean condition) {
            condition = food.getRemainingShelfLife() >= 25
                    && food.getRemainingShelfLife() <= 75;
            if (food.getRemainingShelfLife() > 75
                    && food.getRemainingShelfLife() < 100) {
                double newPrice = food.getPrice() * (food.getDiscount() / 100);
                food = new Food(
                        food.getName(),
                        food.getCreateDate(),
                        food.getExpiryDate(),
                        newPrice,
                        food.getDiscount()
                );
                condition = true;
            }
            return super.add(food, condition);
        }

        @Override
        public List<Food> findAll() {
            return super.findAll();
        }
    };
}