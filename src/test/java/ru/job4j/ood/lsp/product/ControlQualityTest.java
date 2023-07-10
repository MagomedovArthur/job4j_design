package ru.job4j.ood.lsp.product;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
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
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Tiramisu", LocalDate.parse("2023-05-01"),
                LocalDate.parse("2023-05-25"), 700, 30));
        foods.add(new Food("IceCream", LocalDate.parse("2023-05-16"),
                LocalDate.parse("2023-05-28"), 230, 10));
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distribution(foods, storage, LocalDate.parse("2023-05-31"));
        List<Food> expected = List.of(
                new Food("Tiramisu", LocalDate.parse("2023-05-01"),
                        LocalDate.parse("2023-05-25"), 700, 30),
                new Food("IceCream", LocalDate.parse("2023-05-16"),
                        LocalDate.parse("2023-05-28"), 230, 10)
        );
        List<Food> actual = storage.get(1).findAll();
        assertThat(actual).isEqualTo(expected);
        controlQuality.resort(LocalDate.parse("2023-07-10"), foods, storage);
        assertThat(storage.get(1).findAll()).contains(new Food("Tiramisu", LocalDate.parse("2023-05-01"),
                LocalDate.parse("2023-05-25"), 700, 30));
    }

    @Test
    void whenFoodEndedUpInWarehouse() {
        List<Store> storage = List.of(
                new Warehouse(),
                new Trash(),
                new Shop()
        );
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Tiramisu", LocalDate.parse("2023-05-30"),
                LocalDate.parse("2023-06-30"), 700, 30));
        foods.add(new Food("IceCream", LocalDate.parse("2023-05-16"),
                LocalDate.parse("2023-05-28"), 230, 10));
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distribution(foods, storage, LocalDate.parse("2023-05-31"));
        List<Food> expected = List.of(
                new Food("Tiramisu", LocalDate.parse("2023-05-30"),
                        LocalDate.parse("2023-06-30"), 700, 30)
        );
        List<Food> actual = storage.get(0).findAll();
        assertThat(actual).isEqualTo(expected);
        controlQuality.resort(LocalDate.parse("2023-07-10"), foods, storage);
        assertThat(storage.get(1).findAll()).isEqualTo(foods);
        assertThat(storage.get(0).findAll()).isEmpty();
    }

    @Test
    void whenFoodEndedUpInShop() {
        List<Store> storage = List.of(
                new Warehouse(),
                new Trash(),
                new Shop()
        );
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Tiramisu", LocalDate.parse("2023-05-20"),
                LocalDate.parse("2023-06-20"), 700, 30));
        foods.add(new Food("IceCream", LocalDate.parse("2023-05-16"),
                LocalDate.parse("2023-05-28"), 230, 10));
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distribution(foods, storage, LocalDate.parse("2023-05-31"));
        List<Food> expected = List.of(
                new Food("Tiramisu", LocalDate.parse("2023-05-20"),
                        LocalDate.parse("2023-06-20"), 700, 30)
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
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Tiramisu", LocalDate.parse("2023-05-17"),
                LocalDate.parse("2023-06-05"), 700, 30));
        foods.add(new Food("IceCream", LocalDate.parse("2023-05-16"),
                LocalDate.parse("2023-05-28"), 230, 10));
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distribution(foods, storage, LocalDate.parse("2023-06-02"));
        List<Food> expected = List.of(
                new Food("Tiramisu", LocalDate.parse("2023-05-17"),
                        LocalDate.parse("2023-06-05"), 490.0D, 30)
        );
        List<Food> actual = storage.get(2).findAll();
        assertThat(actual).isEqualTo(expected);
    }
}