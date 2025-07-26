package com.github.azeroth.game.domain.gobject;


import com.github.azeroth.defines.InvisibilityType;

public class GameObjectAddon {
    public int guid;
    public QuaternionData parentRotation;
    public InvisibilityType invisibilityType = InvisibilityType.values()[0];
    public int invisibilityValue;
    public int worldEffectID;
    public int aiAnimKitID;
}
