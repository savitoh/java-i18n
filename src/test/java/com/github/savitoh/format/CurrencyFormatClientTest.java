package com.github.savitoh.format;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CurrencyFormatClientTest {

  @ParameterizedTest
  @MethodSource("numberToMonth")
  void testFormat(BigDecimal amount, Locale locale, String expectedFormattedValue) {
    final var currencyFormatClient = new CurrencyFormatClient();

    final String formattedValue = currencyFormatClient.format(amount, locale);

    assertEquals(expectedFormattedValue, formattedValue);
  }

  private static Stream<Arguments> numberToMonth() {
    return Stream.of(
        arguments(new BigDecimal("25.87"), Locale.US, "$25.87"),
        arguments(new BigDecimal("25.87"), new Locale("pt", "BR"), "R$ 25,87"),
        arguments(new BigDecimal("25.87"), Locale.FRANCE, "25,87 €"));
  }
}
