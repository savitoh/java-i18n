package com.github.savitoh.format;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DateTimeFormatTest {

  @ParameterizedTest
  @MethodSource("localDateTimeToFormattedValue")
  void testFormat(LocalDateTime localDateTime, Locale locale, String formattedValue) {
    var dateTimeFormatClient = new DateTimeFormatClient();

    var result = dateTimeFormatClient.format(localDateTime, locale);

    assertEquals(formattedValue, result);
  }

  private static Stream<Arguments> localDateTimeToFormattedValue() {
    return Stream.of(
        arguments(LocalDateTime.of(2022, 11, 26, 5, 26, 30), Locale.US, "Nov 26, 2022, 5:26:30 AM"),
        arguments(
            LocalDateTime.of(2022, 11, 26, 5, 26, 30),
            new Locale("pt", "BR"),
            "26 de nov. de 2022 05:26:30"),
        arguments(
            LocalDateTime.of(2022, 11, 26, 5, 26, 30), Locale.FRANCE, "26 nov. 2022, 05:26:30"));
  }
}
