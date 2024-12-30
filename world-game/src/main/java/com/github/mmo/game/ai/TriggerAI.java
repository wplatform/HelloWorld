package com.github.mmo.game.ai;

import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.spell.CastSpellExtraArgs;

public class TriggerAI extends NullCreatureAI {
    public TriggerAI(Creature c) {
        super(c);
    }

    @Override
    public void isSummonedBy(WorldObject summoner) {
        if (me.getSpells()[0] != 0) {
            CastSpellExtraArgs extra = new CastSpellExtraArgs();
            extra.originalCaster = summoner.getGUID();
            me.castSpell(me, me.getSpells()[0], extra);
        }
    }
}
