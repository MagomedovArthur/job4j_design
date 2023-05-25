package ru.job4j.kiss;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MaxMinTest {

    @Test
    void findMaxValue() {
        List<Integer> list = List.of(5, 5, 3, 7, 78, 67, 2, 5, 3, 87654, 76);
        int expected = 87654;
        assertThat(new MaxMin().max(list, Integer::compareTo)).isEqualTo(expected);
    }

    @Test
    void findMinValue() {
        List<Integer> list = List.of(5, 5, 3, 7, 78, 67, 2, 5, 3, 87654, 76);
        int expected = 2;
        assertThat(new MaxMin().min(list, Integer::compareTo)).isEqualTo(expected);
    }
}