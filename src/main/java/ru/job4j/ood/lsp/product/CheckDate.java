package ru.job4j.ood.lsp.product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckDate {

    public static List<Food> calculatingRemainingExpirationDate(List<Food> foodsList) {
        List<Food> result = new ArrayList<>();
        for (Food food : foodsList) {
            Calendar currentTime = Calendar.getInstance();
            long currentDate = currentTime.getTimeInMillis();
            long createDate = food.getCreateDate().getTimeInMillis();
            long expiryDate = food.getExpiryDate().getTimeInMillis();
            long numberOfDaysPassedInMill = currentDate - createDate;
            long numberOfDaysToStoreInMill = expiryDate - createDate;
            long numberOfDaysPassedInDays = TimeUnit.MILLISECONDS.toDays(numberOfDaysPassedInMill);
            long numberOfDaysToStoreInDays = TimeUnit.MILLISECONDS.toDays(numberOfDaysToStoreInMill);
            int expirationDatePercentage = (int) (numberOfDaysPassedInDays / numberOfDaysToStoreInDays) * 100;
            food.setRemainingShelfLife(expirationDatePercentage);
            result.add(food);
        }
        return result;
    }
}