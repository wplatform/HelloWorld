package com.github.azeroth.game.entity.player;


import java.util.ArrayList;


public class Runes {
    private ArrayList<Byte> cooldownOrder = new ArrayList<>();
    private int[] cooldown = new int[PlayerConst.MaxRunes];
    private byte runeState;

    public final ArrayList<Byte> getCooldownOrder() {
        return cooldownOrder;
    }

    public final void setCooldownOrder(ArrayList<Byte> value) {
        cooldownOrder = value;
    }

    public final int[] getCooldown() {
        return cooldown;
    }

    public final void setCooldown(int[] value) {
        cooldown = value;
    }

    public final byte getRuneState() {
        return runeState;
    }

    public final void setRuneState(byte value) {
        runeState = value;
    }


    public final void setRuneState(byte index) {
        setRuneState(index, true);
    }

    public final void setRuneState(byte index, boolean set) {
        var foundRune = getCooldownOrder().contains(index);

        if (set) {
            setRuneState(getRuneState() | (byte) (1 << index)); // usable

            if (foundRune) {
                getCooldownOrder().remove(index);
            }
        } else {
            setRuneState(getRuneState() & (byte) ~(1 << index)); // on cooldown

            if (!foundRune) {
                getCooldownOrder().add(index);
            }
        }
    }
}
