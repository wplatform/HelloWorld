package com.rainbowland.enums;

// CreatureType.dbc (9.0.2.37176)
public enum CreatureType {
    CREATURE_TYPE_BEAST(1),
    CREATURE_TYPE_DRAGONKIN(2),
    CREATURE_TYPE_DEMON(3),
    CREATURE_TYPE_ELEMENTAL(4),
    CREATURE_TYPE_GIANT(5),
    CREATURE_TYPE_UNDEAD(6),
    CREATURE_TYPE_HUMANOID(7),
    CREATURE_TYPE_CRITTER(8),
    CREATURE_TYPE_MECHANICAL(9),
    CREATURE_TYPE_NOT_SPECIFIED(10),
    CREATURE_TYPE_TOTEM(11),
    CREATURE_TYPE_NON_COMBAT_PET(12),
    CREATURE_TYPE_GAS_CLOUD(13),
    CREATURE_TYPE_WILD_PET(14),
    CREATURE_TYPE_ABERRATION(15);


    private final int value;

    CreatureType(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
