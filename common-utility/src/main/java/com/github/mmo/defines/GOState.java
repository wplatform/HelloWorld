package com.github.mmo.defines;

import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

// client side GO show states
@RequiredArgsConstructor
public enum GOState {
    ACTIVE((byte) 0),                        // show in world as used and not reset (closed door open)
    READY((byte) 1),                        // show in world as ready (closed door close)
    DESTROYED((byte) 2),                        // show the object in-game as already used and not yet reset (e.g. door opened by a cannon blast)
    TRANSPORT_ACTIVE((byte) 24),
    TRANSPORT_STOPPED((byte) 25);
    public final byte value;

    public static GOState valueOf(byte value) {
        return switch (value) {
            case 0 -> ACTIVE;
            case 1 -> READY;
            case 2 -> DESTROYED;
            case 24 -> TRANSPORT_ACTIVE;
            case 25 -> TRANSPORT_STOPPED;
            default -> throw new NoSuchElementException();
        };
    }

}
