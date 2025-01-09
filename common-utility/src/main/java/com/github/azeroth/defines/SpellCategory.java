package com.github.azeroth.defines;

public enum SpellCategory {
    FOOD(11), DRINK(59);

    public final int value;

    SpellCategory(int value) {
        this.value = value;
    }

    public static SpellCategory valueOf(int value) {
        return switch (value) {
            case 11 -> FOOD;
            case 59 -> DRINK;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }
}
