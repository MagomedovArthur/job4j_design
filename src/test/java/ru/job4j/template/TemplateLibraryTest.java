package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты временно отключены.")
class TemplateLibraryTest {

    @Test
    void whenGeneratorReturnedExpectedString() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> keys = new HashMap<>();
        keys.put("name", "Petr Arsentev");
        keys.put("subject", "you");
        String result = new TemplateLibrary().produce(template, keys);
        assertThat(result).isEqualTo("I am a Petr Arsentev, Who are you? ");
    }

    @Test
    void whenMapDoesNotHaveAllKeys() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> keys = new HashMap<>();
        keys.put("name", "Petr Arsentev");
        assertThatThrownBy(() -> new TemplateLibrary().produce(template, keys))
                .isInstanceOf(Exception.class);
    }

    @Test
    void whenThereAreExtraKeysInTheMap() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> keys = new HashMap<>();
        keys.put("name", "Petr Arsentev");
        keys.put("subject", "you");
        keys.put("address", "address");
        assertThatThrownBy(() -> new TemplateLibrary().produce(template, keys))
                .isInstanceOf(Exception.class);
    }
}