package com.github.azeroth.common;

import java.util.concurrent.TimeUnit;

public interface EventPublisher {
    void publish(Runnable command);
    void publish(Runnable command, long delay, TimeUnit unit);
    void publishAtFixedRate(Runnable command, long period, TimeUnit unit);
}
