package com.github.savitoh.format;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TimeLocalizationClientTest {

  @ParameterizedTest
  @MethodSource("timeToFormattedValue")
  void testFormat(LocalTime time, Locale locale, String formattedValue) {
    var timeLocalizationClient = new TimeLocalizationClient();

    var result = timeLocalizationClient.format(time, locale);

    assertEquals(formattedValue, result);
  }

  private static Stream<Arguments> timeToFormattedValue() {
    return Stream.of(
        arguments(LocalTime.of(22, 26, 30), Locale.US, "10:26:30 PM"),
        arguments(LocalTime.of(22, 26, 30), new Locale("pt", "BR"), "22:26:30"),
        arguments(LocalTime.of(22, 26, 30), Locale.JAPAN, "22:26:30"));
  }
}
