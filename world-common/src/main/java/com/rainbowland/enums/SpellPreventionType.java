package com.rainbowland.enums;

public enum SpellPreventionType {
    SPELL_PREVENTION_TYPE_SILENCE(1),
    SPELL_PREVENTION_TYPE_PACIFY(2),
    SPELL_PREVENTION_TYPE_NO_ACTIONS(4);

    private final int value;

    SpellPreventionType(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }

}
