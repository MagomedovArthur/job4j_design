package ru.job4j.ood.lsp.product;

import java.util.List;

public interface Store {

    Food add(Food food);

    List<Food> findAll();
}