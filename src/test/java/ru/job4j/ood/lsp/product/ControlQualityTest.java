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
        ControlQuality controlQuality = new ControlQuality();
        Calendar createDate = Calendar.getInstance();
        createDate.set(2023, Calendar.MAY, 1);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(2023, Calendar.JUNE, 5);
        Food cake = new Food("Titamisu", createDate, expiryDate, 700, 35);
        controlQuality.foodDistribution(cake);
        List<Food> shopFood = new Shop().findAll();
        List<Food> expected = List.of(new Food("Titamisu", createDate, expiryDate, 700, 35));
        assertThat(shopFood).isEqualTo(expected);
    }
}