package com.github.savitoh.format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeLocalizationClient {

  public String format(LocalDateTime localDateTime, Locale locale) {
    DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(locale);
    return localDateTime.format(dateTimeFormatter);
  }
}
