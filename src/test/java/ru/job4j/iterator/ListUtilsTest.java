package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 5, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void removeWhenNumbersLessThanFive() {
        input.add(6);
        input.add(5);
        input.add(0);
        input.add(7);
        input.add(4);
        Predicate<Integer> predicate = s -> s > 5;
        ListUtils.removeIf(input, predicate);
        assertThat(input).containsSequence(6, 7);
    }

    @Test
    void removeIfNotEqualToSeven() {
        input.add(7);
        input.add(7);
        input.add(4);
        Predicate<Integer> predicate = s -> s == 7;
        ListUtils.removeIf(input, predicate);
        assertThat(input).containsSequence(7, 7);
    }

    @Test
    void replaceIfValueIsNotEqual95() {
        input.add(95);
        input.add(56);
        input.add(5);
        Predicate<Integer> predicate = s -> s != 95;
        ListUtils.replaceIf(input, predicate, 55);
        assertThat(input).containsSequence(1, 3, 55, 56, 5);
    }

    @Test
    void removeFromCollectionElementsThatInSecondCollection() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 2, 3));
        List<Integer> elements = new ArrayList<>(Arrays.asList(2, 5, 6));
        ListUtils.removeAll(list, elements);
        assertThat(list).containsSequence(4, 3);
    }
}