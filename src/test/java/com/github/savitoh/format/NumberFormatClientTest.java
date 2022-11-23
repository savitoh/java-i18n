package com.github.savitoh.format;

import com.github.savitoh.format.NumberFormatClient;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberFormatClientTest {

  @Test
  void ShouldFormatNumberToUSLocale() {
    var number = 20_000.548;
    var numberFormat = new NumberFormatClient();

    String result = numberFormat.format(number, Locale.US);

    assertEquals("20,000.54", result);
  }

  @Test
  void ShouldFormatNumberToBrLocale() {
    var number = 20_000.548;
    var numberFormat = new NumberFormatClient();

    String result = numberFormat.format(number, new Locale("pt", "BR"));

    assertEquals("20.000,54", result);
  }
}
