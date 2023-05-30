package ru.job4j.ood.lsp.product;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ControlQuality {
  //  Store store;

    public ControlQuality() {
        Store trashStore = new Trash();
        Store shopStore = new Shop();
        Store warehouseStore = new Warehouse();
    }

    public void foodDistribution(Food food) {
        if (food.getExpiryDate().compareTo(Calendar.getInstance()) < 0) {
            new Trash().add(food);
            return;
        }
        long diffInMillis = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long numberOfDaysOfStorage = TimeUnit.MILLISECONDS.toDays(diffInMillis);
        int twentyFivePercent = (int) (numberOfDaysOfStorage * 0.25);
        long diff = Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        int numberOfDaysPassed = (int) TimeUnit.MILLISECONDS.toDays(diff);
        if (numberOfDaysPassed < twentyFivePercent) {
            new Warehouse().add(food);
            return;
        }
        int seventyFivePercent = (int) (numberOfDaysOfStorage * 0.75);
        if (numberOfDaysPassed >= twentyFivePercent && numberOfDaysPassed <= seventyFivePercent) {
            new Shop().add(food);
            return;
        }
        if (numberOfDaysPassed > seventyFivePercent) {
            double discount = food.getDiscount() / 100;
            double newPrice = food.getPrice() * discount;
            Food newPriceFood = new Food(
                    food.getName(),
                    food.getCreateDate(),
                    food.getExpiryDate(),
                    newPrice,
                    food.getDiscount()
            );
            new Shop().add(newPriceFood);
        }
    }
}