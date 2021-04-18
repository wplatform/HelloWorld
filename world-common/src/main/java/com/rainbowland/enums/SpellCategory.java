package com.rainbowland.enums;

public enum SpellCategory {
    SPELL_CATEGORY_FOOD(11),
    SPELL_CATEGORY_DRINK(59);

    private final int value;

    SpellCategory(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
