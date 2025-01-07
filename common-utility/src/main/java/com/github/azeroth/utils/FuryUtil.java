package com.github.azeroth.utils;

import com.github.azeroth.common.Locale;
import com.github.azeroth.common.LocalizedString;
import org.apache.fury.Fury;
import org.apache.fury.ThreadSafeFury;
import org.apache.fury.config.Language;


public class FuryUtil {

    public static final ThreadSafeFury FURY = Fury.builder()
            .withLanguage(Language.JAVA)
            .requireClassRegistration(true)
            .withRefTracking(false)
            .withRefCopy(false)
            .buildThreadSafeFury();

    static {
        FURY.register(Locale.class);
        FURY.register(LocalizedString.class);
    }

    public static byte[] serializeIntKey(Object object) {
        return FURY.serializeJavaObject(object);
    }


    public static <T> T deserialize(byte[] objectData, Class<T> clazz) {
        return FURY.deserializeJavaObject(objectData, clazz);
    }


    public static <T> T copy(T object) {
        return FURY.copy(object);
    }
}
