package com.github.savitoh.format;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OrdinalFormatClientTest {

  @ParameterizedTest
  @MethodSource("numberToOrdinalFormat")
  void testFormat(int value, Locale locale, String expectedFormattedValue) {
    final var ordinalFormatClient = new OrdinalFormatClient();

    final String formattedValue = ordinalFormatClient.format(value, locale);

    assertEquals(expectedFormattedValue, formattedValue);
  }

  private static Stream<Arguments> numberToOrdinalFormat() {
    return Stream.of(
        arguments(12, Locale.US, "12th"),
        arguments(3, new Locale("pt", "BR"), "3º"),
        arguments(21, Locale.JAPAN, "第21"));
  }
}
