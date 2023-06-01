package ru.job4j.ood.lsp.product;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenFoodEndedUpInTrash() {
        List<Store> storage = List.of(
                new Warehouse(),
                new Trash(),
                new Shop()
        );
        Calendar createDateTiramisu = Calendar.getInstance();
        createDateTiramisu.set(2023, Calendar.MAY, 1);
        Calendar expiryDateTiramisu = Calendar.getInstance();
        expiryDateTiramisu.set(2023, Calendar.MAY, 25);

        Calendar createDateIceCream = Calendar.getInstance();
        createDateIceCream.set(2023, Calendar.MAY, 16);
        Calendar expiryDateIceCream = Calendar.getInstance();
        expiryDateIceCream.set(2023, Calendar.MAY, 28);

        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Tiramisu", createDateTiramisu, expiryDateTiramisu, 700, 30));
        foods.add(new Food("IceCream", createDateIceCream, expiryDateIceCream, 230, 10));
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distribution(foods, storage);
        List<Food> expected = List.of(
                new Food("Tiramisu", createDateTiramisu, expiryDateTiramisu, 700, 30),
                new Food("IceCream", createDateIceCream, expiryDateIceCream, 230, 10)
        );
        List<Food> actual = storage.get(1).findAll();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void whenFoodEndedUpInWarehouse() {
        List<Store> storage = List.of(
                new Warehouse(),
                new Trash(),
                new Shop()
        );
        Calendar createDateTiramisu = Calendar.getInstance();
        createDateTiramisu.set(2023, Calendar.MAY, 30);
        Calendar expiryDateTiramisu = Calendar.getInstance();
        expiryDateTiramisu.set(2023, Calendar.JUNE, 30);

        Calendar createDateIceCream = Calendar.getInstance();
        createDateIceCream.set(2023, Calendar.MAY, 16);
        Calendar expiryDateIceCream = Calendar.getInstance();
        expiryDateIceCream.set(2023, Calendar.MAY, 28);

        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Tiramisu", createDateTiramisu, expiryDateTiramisu, 700, 30));
        foods.add(new Food("IceCream", createDateIceCream, expiryDateIceCream, 230, 10));
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distribution(foods, storage);
        List<Food> expected = List.of(
                new Food("Tiramisu", createDateTiramisu, expiryDateTiramisu, 700, 30)
        );
        List<Food> actual = storage.get(0).findAll();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void whenFoodEndedUpInShop() {
        List<Store> storage = List.of(
                new Warehouse(),
                new Trash(),
                new Shop()
        );
        Calendar createDateTiramisu = Calendar.getInstance();
        createDateTiramisu.set(2023, Calendar.MAY, 20);
        Calendar expiryDateTiramisu = Calendar.getInstance();
        expiryDateTiramisu.set(2023, Calendar.JUNE, 20);

        Calendar createDateIceCream = Calendar.getInstance();
        createDateIceCream.set(2023, Calendar.MAY, 16);
        Calendar expiryDateIceCream = Calendar.getInstance();
        expiryDateIceCream.set(2023, Calendar.MAY, 28);

        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Tiramisu", createDateTiramisu, expiryDateTiramisu, 700, 30));
        foods.add(new Food("IceCream", createDateIceCream, expiryDateIceCream, 230, 10));
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distribution(foods, storage);
        List<Food> expected = List.of(
                new Food("Tiramisu", createDateTiramisu, expiryDateTiramisu, 700, 30)
        );
        List<Food> actual = storage.get(2).findAll();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void whenFoodEndedUpInShopWithALowPrice() {
        List<Store> storage = List.of(
                new Warehouse(),
                new Trash(),
                new Shop()
        );
        Calendar createDateTiramisu = Calendar.getInstance();
        createDateTiramisu.set(2023, Calendar.MAY, 17);
        Calendar expiryDateTiramisu = Calendar.getInstance();
        expiryDateTiramisu.set(2023, Calendar.JUNE, 5);

        Calendar createDateIceCream = Calendar.getInstance();
        createDateIceCream.set(2023, Calendar.MAY, 16);
        Calendar expiryDateIceCream = Calendar.getInstance();
        expiryDateIceCream.set(2023, Calendar.MAY, 28);

        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Tiramisu", createDateTiramisu, expiryDateTiramisu, 700, 30));
        foods.add(new Food("IceCream", createDateIceCream, expiryDateIceCream, 230, 10));
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distribution(foods, storage);
        List<Food> expected = List.of(
                new Food("Tiramisu", createDateTiramisu, expiryDateTiramisu, 490.0D, 30)
        );
        List<Food> actual = storage.get(2).findAll();
        assertThat(actual).isEqualTo(expected);
    }
}