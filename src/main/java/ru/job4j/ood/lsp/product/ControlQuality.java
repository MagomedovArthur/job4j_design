package ru.job4j.ood.lsp.product;

import java.util.List;

import static ru.job4j.ood.lsp.product.CheckDate.calculatingRemainingExpirationDate;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distribution(List<Food> foodsList, List<Store> storeList) {
        List<Food> food = calculatingRemainingExpirationDate(foodsList);
        for (Store store : storeList) {
            for (Food foods : food) {
                store.add(foods, false);
            }
        }
    }
}