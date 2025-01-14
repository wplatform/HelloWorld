package com.github.azeroth.game.domain.creature;

public class CreatureBaseStats {

    public short level;
    public short klass;
    public int baseMana;
    public int attackPower;
    public int rangedAttackPower;

    public CreatureBaseStats(short level, short klass, int baseMana, int attackPower, int rangedAttackPower) {
        this.level = level;
        this.klass = klass;
        this.baseMana = baseMana;
        this.attackPower = attackPower;
        this.rangedAttackPower = rangedAttackPower;
    }

    // Helpers
    public final int generateMana(CreatureTemplate info) {
        // Mana can be 0.
        if (baseMana == 0) {
            return 0;
        }
        return (int) Math.ceil(baseMana * info.modMana * info.modManaExtra);
    }
}
