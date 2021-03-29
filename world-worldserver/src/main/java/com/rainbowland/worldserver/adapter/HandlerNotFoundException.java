package com.rainbowland.worldserver.adapter;

public class HandlerNotFoundException extends RuntimeException {
    public HandlerNotFoundException() {
    }

    public HandlerNotFoundException(String message) {
        super(message);
    }

    public HandlerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandlerNotFoundException(Throwable cause) {
        super(cause);
    }

    public HandlerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
