package ru.job4j.ood.lsp.product;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CheckDate {

    public static List<Food> calculatingRemainingExpirationDate(List<Food> foodsList, LocalDate now) {
        List<Food> result = new ArrayList<>();
        for (Food food : foodsList) {
            long numberOfDaysPassed = Math.abs(ChronoUnit.DAYS.between(food.getCreateDate(), now));
            long numberOfDaysToStore = Math.abs(ChronoUnit.DAYS.between(food.getExpiryDate(), food.getCreateDate()));
            long expirationDatePercentage = (100 * numberOfDaysPassed) / numberOfDaysToStore;
            food.setRemainingShelfLife((int) expirationDatePercentage);
            result.add(food);
        }
        return result;
    }
}