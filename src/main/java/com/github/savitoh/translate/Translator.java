package com.github.savitoh.translate;

import java.util.Locale;
import java.util.Optional;

public interface Translator {

  Optional<String> translate(Locale locale, String tag);
}
