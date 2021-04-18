package com.rainbowland.enums;

// client side GO show states
public enum GOState {
    GO_STATE_ACTIVE(0),                        // show in world as used and not reset (closed door open)
    GO_STATE_READY(1),                        // show in world as ready (closed door close)
    GO_STATE_ACTIVE_ALTERNATIVE(2),                        // show in world as used in alt way and not reset (closed door open by cannon fire)
    GO_STATE_TRANSPORT_ACTIVE(24),
    GO_STATE_TRANSPORT_STOPPED(25);


    private final int value;

    GOState(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
