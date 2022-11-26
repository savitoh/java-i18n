package com.github.savitoh.format;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class TimeLocalizationClient {

  public String format(LocalTime time, Locale locale) {
    DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(locale);
    return time.format(dateTimeFormatter);
  }
}
