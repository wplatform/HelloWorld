package com.github.mmo.net.server;

import com.github.mmo.net.Connection;

@FunctionalInterface
public interface ConnectionObserver {

    void onStateChange(Connection connection, State newState);

    default ConnectionObserver andThen(ConnectionObserver other) {
        return (connection, newState) -> {
            onStateChange(connection, newState);
            other.onStateChange(connection, newState);
        };
    }

    default void onUncaughtException(Connection connection, Throwable error) {
        onStateChange(connection, State.DISCONNECTING);
    }

    enum State {

        /**
         * Propagated when a connection has been established and is available
         */
        CONNECTED,

        /**
         * Propagated when a connection is bound to a channelOperation and ready for
         * user interaction
         */
         CONFIGURED,

        /**
         * Propagated when a connection is bound to a channelOperation and ready for
         * user interaction
         */
        READ,

        /**
         * Propagated when a connection is being fully closed
         */
        DISCONNECTING
    }
}
