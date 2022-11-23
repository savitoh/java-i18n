package com.github.savitoh.format;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatClient {

  public String format(BigDecimal amount, Locale locale) {
    final BigDecimal amountWithScale = amount.setScale(2, RoundingMode.HALF_UP);
    final var numberFormat = NumberFormat.getCurrencyInstance(locale);
    return numberFormat.format(amountWithScale);
  }
}
