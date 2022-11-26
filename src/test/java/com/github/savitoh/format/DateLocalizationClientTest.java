package com.github.savitoh.format;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DateLocalizationClientTest {

  @ParameterizedTest
  @MethodSource("localDateToFormattedValue")
  void testFormat(LocalDate localDateTime, Locale locale, String formattedValue) {
    var dateLocalizationClient = new DateLocalizationClient();

    var result = dateLocalizationClient.format(localDateTime, locale);

    assertEquals(formattedValue, result);
  }

  private static Stream<Arguments> localDateToFormattedValue() {
    return Stream.of(
        arguments(LocalDate.of(2022, 11, 26), Locale.US, "11/26/22"),
        arguments(LocalDate.of(2022, 11, 26), new Locale("pt", "BR"), "26/11/2022"),
        arguments(LocalDate.of(2022, 11, 26), Locale.JAPAN, "2022/11/26"));
  }
}
