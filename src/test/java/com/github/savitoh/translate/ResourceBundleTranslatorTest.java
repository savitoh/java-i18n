package com.github.savitoh.translate;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ResourceBundleTranslatorTest {

  private final Translator translator = new ResourceBundleTranslator();

  @Test
  void Should_TranslateTAG_WhenTAGExistsToLocale() {
    var locale = Locale.US;
    var tag = "message.welcome";

    Optional<String> maybeTranslation = translator.translate(locale, tag);

    assertTrue(maybeTranslation.isPresent());
    assertEquals("Welcome!", maybeTranslation.get());
  }

  @Test
  void Should_ReturnEmpty_WhenTAGDoenstExists() {
    var locale = Locale.US;
    var tagFail = "message";

    Optional<String> maybeTranslation = translator.translate(locale, tagFail);

    assertTrue(maybeTranslation.isEmpty());
  }

  @Test
  void Should_TranslateDefaultTAG_WhenLocaleDoenstMapping() {
    var locale = Locale.FRANCE;
    var tag = "message.welcome";

    Optional<String> maybeTranslation = translator.translate(locale, tag);

    assertTrue(maybeTranslation.isPresent());
    assertEquals("Welcome!", maybeTranslation.get());
  }

}
