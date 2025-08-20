package com.github.azeroth.game.domain.transport;

public final class TransportPathEvent {
    public int timestamp;
    public int eventId;

    public TransportPathEvent clone() {
        TransportPathEvent varCopy = new TransportPathEvent();

        varCopy.timestamp = this.timestamp;
        varCopy.eventId = this.eventId;

        return varCopy;
    }
}
