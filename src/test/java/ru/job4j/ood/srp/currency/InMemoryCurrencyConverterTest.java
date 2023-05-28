package ru.job4j.ood.srp.currency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InMemoryCurrencyConverterTest {

    @Test
    void whenConvertingFromRublesToDollars() {
        InMemoryCurrencyConverter currencyConverter = new InMemoryCurrencyConverter();
        double rubleToDollars = currencyConverter.convert(Currency.RUB, 700, Currency.USD);
        assertThat(rubleToDollars).isEqualTo(11.34D);
    }

    @Test
    void whenConvertingFromEuroToDollars() {
        InMemoryCurrencyConverter currencyConverter = new InMemoryCurrencyConverter();
        double euroToDollars = currencyConverter.convert(Currency.EUR, 100, Currency.USD);
        assertThat(euroToDollars).isEqualTo(97.86D);
    }

    @Test
    void whenConvertingFromEuroToRuble() {
        InMemoryCurrencyConverter currencyConverter = new InMemoryCurrencyConverter();
        double euroToRuble = currencyConverter.convert(Currency.EUR, 100, Currency.RUB);
        assertThat(euroToRuble).isEqualTo(6300D);
    }
}