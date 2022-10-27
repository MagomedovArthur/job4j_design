package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("one", "two", "three", "four");
        assertThat(list).hasSize(4)
                .contains("four", "one")
                .containsAnyOf("three")
                .startsWith("one");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("12", "32", "32", "211");
        assertThat(set).hasSize(3)
                .containsAnyOf("211")
                .containsExactlyInAnyOrder("211", "32", "12");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap(
                "un", "deux", "trois", "quatre", "cinq", "six");
        assertThat(map).hasSize(6)
                .doesNotContainKey("one")
                .doesNotContainValue(7)
                .containsEntry("un", 0);
    }
}