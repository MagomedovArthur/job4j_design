package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findMaxOrMin(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findMaxOrMin(value, comparator.reversed());
    }

    private <T> T findMaxOrMin(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (T nextElement : value) {
            result = comparator.compare(result, nextElement) >= 0 ? result : nextElement;
        }
        return result;
    }
}