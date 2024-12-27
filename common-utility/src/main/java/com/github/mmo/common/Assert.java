package com.github.mmo.common;

import org.slf4j.helpers.MessageFormatter;

public interface Assert {

    static void state(boolean b) {
        if(!b) {
            throw new IllegalArgumentException("Assertion failed, require true but got false");
        }
    }

    static void state(boolean b, String message, Object... args) {
        if(!b) {
            throw new IllegalArgumentException(MessageFormatter.basicArrayFormat(message, args));
        }
    }

    static void notOutOfBound(int index, int length, String message, Object... args) {
        if(index >= length) {
            throw new IndexOutOfBoundsException(MessageFormatter.basicArrayFormat(message, args));
        }
    }

    static void fail() {
        throw new IllegalStateException("Assertion failed");
    }


}
