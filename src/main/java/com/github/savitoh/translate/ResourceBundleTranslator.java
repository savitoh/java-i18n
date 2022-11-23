package com.github.savitoh.translate;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class ResourceBundleTranslator implements Translator {

  private static final String I18N_PATH = "messages/i18n-resources";

  @Override
  public Optional<String> translate(Locale locale, String tag) {
    final var resourceBundle = ResourceBundle.getBundle(I18N_PATH, locale);
    if (resourceBundle.containsKey(tag)) {
      return Optional.of(resourceBundle.getString(tag));
    }
    return Optional.empty();
  }
}
