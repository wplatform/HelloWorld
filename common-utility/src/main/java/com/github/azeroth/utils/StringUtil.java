package com.github.azeroth.utils;

import org.slf4j.helpers.MessageFormatter;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public interface StringUtil {

    static String format(String format, Object... args) {
        return MessageFormatter.arrayFormat(format, args).getMessage();
    }

    static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    static int[] splitInts(String string, String delimiter) {
        Objects.requireNonNull(string);
        String[] split = string.split(delimiter);
        return Arrays.stream(split).map(String::trim).filter(StringUtil::isEmpty).mapToInt(Integer::parseInt).toArray();
    }

    static int[] distinctSplitInts(String string, String delimiter, boolean keepEmpty) {
        Objects.requireNonNull(string);
        String[] split = string.split(delimiter);
        Stream<String> stringStream = Arrays.stream(split).map(String::trim);
        if(!keepEmpty) {
            stringStream = stringStream.filter(StringUtil::isEmpty);
        }
        return stringStream.mapToInt(Integer::parseInt).distinct().toArray();
    }

    static int[] distinctSplitInts(String string, String delimiter) {
        return distinctSplitInts(string, delimiter, false);
    }
}
