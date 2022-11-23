package com.github.savitoh.format;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatClient {

  public String format(Number number, Locale locale) {
    var numberFormat = NumberFormat.getNumberInstance(locale);
    numberFormat.setMaximumFractionDigits(2);
    numberFormat.setRoundingMode(RoundingMode.DOWN);
    return numberFormat.format(number);
  }
}
