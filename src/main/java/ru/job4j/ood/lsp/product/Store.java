package ru.job4j.ood.lsp.product;

import java.util.List;

public interface Store {

    boolean add(Food food, boolean condition);

    List<Food> findAll();
}