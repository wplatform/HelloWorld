package com.rainbowland.enums;

public enum GameObjectDynamicLowFlags {
    GO_DYNFLAG_LO_HIDE_MODEL(0x02),                 // Object model is not shown with this flag
    GO_DYNFLAG_LO_ACTIVATE(0x04),                 // enables interaction with GO
    GO_DYNFLAG_LO_ANIMATE(0x08),                 // possibly more distinct animation of GO
    GO_DYNFLAG_LO_NO_INTERACT(0x10),                 // appears to disable interaction (not fully verified)
    GO_DYNFLAG_LO_SPARKLE(0x20),                 // makes GO sparkle
    GO_DYNFLAG_LO_STOPPED(0x40);                  // Transport is stopped


    private final int value;

    GameObjectDynamicLowFlags(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
