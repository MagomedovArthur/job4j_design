package ru.job4j.ood.lsp.product;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ControlQualityTest {

    @Test
    void foodDistribution() {
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
        expiryDateIceCream.set(2023, Calendar.JUNE, 18);

        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Tiramisu", createDateTiramisu, expiryDateTiramisu, 700, 30));
        foods.add(new Food("IceCream", createDateIceCream, expiryDateIceCream, 230, 10));

        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distribution(foods, storage);
        List<Food> warehouse = List.of(
                new Food("Tiramisu", createDateTiramisu, expiryDateTiramisu, 700, 30));
        List<Food> res = new Warehouse().findAll();

        assertThat(warehouse).isEqualTo(res);
    }
}