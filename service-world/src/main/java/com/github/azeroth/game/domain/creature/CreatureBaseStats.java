package com.github.azeroth.game.domain.creature;

public class CreatureBaseStats {
    private int baseMana;
    private int attackPower;
    private int rangedAttackPower;

    public final int getBaseMana() {
        return baseMana;
    }

    public final void setBaseMana(int value) {
        baseMana = value;
    }

    public final int getAttackPower() {
        return attackPower;
    }

    public final void setAttackPower(int value) {
        attackPower = value;
    }

    public final int getRangedAttackPower() {
        return rangedAttackPower;
    }

    public final void setRangedAttackPower(int value) {
        rangedAttackPower = value;
    }

    // Helpers
    public final int generateMana(CreatureTemplate info) {
        // Mana can be 0.
        if (getBaseMana() == 0) {
            return 0;
        }

        return (int) Math.ceil(getBaseMana() * info.modMana * info.modManaExtra);
    }
}
