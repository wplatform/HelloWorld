package com.github.azeroth.common;

import org.springframework.util.StringUtils;

import java.util.EnumMap;

import static com.github.azeroth.defines.SharedDefine.DEFAULT_LOCALE;

public class LocalizedString {

    private final EnumMap<Locale, String> localizedString = new EnumMap<>(Locale.class);


    public String get(final Locale locale) {
        String result = localizedString.get(locale);
        if (!StringUtils.hasText(result)) {
            result = localizedString.get(DEFAULT_LOCALE);
        }
        return result;
    }

    public void set(final Locale locale, final String value) {
        localizedString.put(locale, value);
    }

    @Override
    public String toString() {
        return localizedString.toString();
    }

    public static String get(LocalizedString localizedString, Locale locale) {
        if (localizedString == null) {
            return null;
        }
        return localizedString.get(locale);
    }
}
