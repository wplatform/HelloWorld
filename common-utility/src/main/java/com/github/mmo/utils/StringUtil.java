package com.github.mmo.utils;

import org.slf4j.helpers.MessageFormatter;

public interface StringUtil {

    static String format(String format, Object... args) {
        return MessageFormatter.arrayFormat(format, args).getMessage();
    }

    static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
