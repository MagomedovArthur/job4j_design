package ru.job4j.ood.lsp.product;

import java.util.List;

public class Trash extends AbstractStore {
    AbstractStore abstractStore = new AbstractStore() {
        @Override
        public Food add(Food food, boolean condition) {
            condition = food.getRemainingShelfLife() == 100;
            return super.add(food, condition);
        }

        @Override
        public List<Food> findAll() {
            return super.findAll();
        }
    };
}