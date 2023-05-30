package ru.job4j.ood.lsp.product;

import java.util.List;

public class Trash extends AbstractStore {
    AbstractStore abstractStore = new AbstractStore() {
        @Override
        public Food add(Food food) {
            return super.add(food);
        }

        @Override
        public List<Food> findAll() {
            return super.findAll();
        }
    };
}