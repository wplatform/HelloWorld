package com.github.mmo.game.entity.player.model;

import com.github.mmo.common.Flag128;
import com.github.mmo.game.spell.Aura;

public class SpellModifierByClassMask extends SpellModifier {
    public int value;
    public Flag128 mask;

    public SpellModifierByClassMask(Aura ownerAura) {
        super(ownerAura);
        value = 0;
        mask = new Flag128();
    }
}
