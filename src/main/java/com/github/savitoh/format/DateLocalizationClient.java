package com.github.savitoh.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateLocalizationClient {

  public String format(LocalDate date, Locale locale) {
    DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(locale);
    return date.format(dateTimeFormatter);
  }


}
