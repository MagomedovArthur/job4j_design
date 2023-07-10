package ru.job4j.ood.lsp.product;

import java.time.LocalDate;
import java.util.List;

import static ru.job4j.ood.lsp.product.CheckDate.calculatingRemainingExpirationDate;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distribution(List<Food> foodsList, List<Store> storeList, LocalDate now) {
        List<Food> food = calculatingRemainingExpirationDate(foodsList, now);
        for (Store store : storeList) {
            for (Food foods : food) {
                store.add(foods, false);
            }
        }
    }

    public void resort(LocalDate now, List<Food> foodsList, List<Store> storeList) {
        for (Store store : storeList) {
            store.clear();
        }
        distribution(foodsList, storeList, now);
    }
}