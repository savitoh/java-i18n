package com.github.savitoh.format;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

public class OrdinalFormatClient {

  public String format(int number, Locale locale) {
    var formatter = new RuleBasedNumberFormat(locale, RuleBasedNumberFormat.ORDINAL);
    return formatter.format(number);
  }
}
