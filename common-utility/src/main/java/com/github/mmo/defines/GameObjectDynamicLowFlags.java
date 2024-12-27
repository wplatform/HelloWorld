package com.github.mmo.defines;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GameObjectDynamicLowFlags {
    GO_DYNFLAG_LO_HIDE_MODEL(0x0002),               // Object model is not shown with this flag
    GO_DYNFLAG_LO_ACTIVATE(0x0004),               // enables interaction with GO
    GO_DYNFLAG_LO_ANIMATE(0x0008),               // possibly more distinct animation of GO
    GO_DYNFLAG_LO_DEPLETED(0x0010),               // can no longer be interacted with (and for gathering nodes it forces "open" visual state)
    GO_DYNFLAG_LO_SPARKLE(0x0020),               // makes GO sparkle
    GO_DYNFLAG_LO_STOPPED(0x0040),               // Transport is stopped
    GO_DYNFLAG_LO_NO_INTERACT(0x0080),
    GO_DYNFLAG_LO_INVERTED_MOVEMENT(0x0100),               // GAMEOBJECT_TYPE_TRANSPORT only
    GO_DYNFLAG_LO_HIGHLIGHT(0x0200);               // Allows object highlight when GO_DYNFLAG_LO_ACTIVATE or GO_DYNFLAG_LO_SPARKLE are set, not only when player is on quest determined by Data fields
    public final int value;
}
