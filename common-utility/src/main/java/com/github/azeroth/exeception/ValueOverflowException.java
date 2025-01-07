package com.github.azeroth.exeception;

public class ValueOverflowException extends RuntimeException {

    public ValueOverflowException(String message) {
        super(message);
    }

    public ValueOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
