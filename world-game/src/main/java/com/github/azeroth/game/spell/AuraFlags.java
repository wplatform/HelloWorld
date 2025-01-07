package com.github.azeroth.game.spell;

public class AuraFlags {
    public static final auraFlags NONE = new auraFlags(0x00);
    public static final AuraFlags NOCASTER = new auraFlags(0x01);
    public static final AuraFlags POSITIVE = new auraFlags(0x02);
    public static final AuraFlags DURATION = new auraFlags(0x04);
    public static final AuraFlags SCALABLE = new auraFlags(0x08);
    public static final AuraFlags NEGATIVE = new auraFlags(0x10);
    public static final AuraFlags UNK20 = new auraFlags(0x20);
    public static final AuraFlags UNK40 = new auraFlags(0x40);
    public static final AuraFlags UNK80 = new auraFlags(0x80);
    public static final AuraFlags MAWPOWER = new auraFlags(0x100);

    public static final int SIZE = Integer.SIZE;
    private static java.util.HashMap<Integer, AuraFlags> mappings;
    private int intValue;

    private auraFlags(int value) {
        intValue = value;
        synchronized (AuraFlags.class) {
            getMappings().put(value, this);
        }
    }

    private static java.util.HashMap<Integer, AuraFlags> getMappings() {
        if (mappings == null) {
            synchronized (AuraFlags.class) {
                if (mappings == null) {
                    mappings = new java.util.HashMap<Integer, AuraFlags>();
                }
            }
        }
        return mappings;
    }

    public static AuraFlags forValue(int value) {
        synchronized (AuraFlags.class) {
            AuraFlags enumObj = getMappings().get(value);
            if (enumObj == null) {
                return new auraFlags(value);
            } else {
                return enumObj;
            }
        }
    }

    public int getValue() {
        return intValue;
    }
}
