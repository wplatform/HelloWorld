package com.github.mmo.game.ai;

import com.github.mmo.game.entity.creature.Creature;

public class AggressorAI extends CreatureAI {
    public AggressorAI(Creature c) {
        super(c);
    }


    @Override
    public void updateAI(int diff) {
        if (!updateVictim()) {
            return;
        }

        doMeleeAttackIfReady();
    }
}
