package ru.job4j.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.url")).isEqualTo("jdbc:postgresql");
    }

    @Test
    void whenNotContainsKey() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    String path = "./data/pair_not_contains_key.properties";
                    Config config = new Config(path);
                    config.load();
                }
        );
        assertThat(exception.getMessage());
    }

    @Test
    void whenNotContainsEqualsSign() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    String path = "./data/pair_does_not contain_equals_sign.properties";
                    Config config = new Config(path);
                    config.load();
                }
        );
        assertThat(exception.getMessage());
    }

    @Test
    void whenNotContainsKeyAndValue() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    String path = "./data/pair_not_contains_key_and_value.properties";
                    Config config = new Config(path);
                    config.load();
                }
        );
        assertThat(exception.getMessage());
    }
}