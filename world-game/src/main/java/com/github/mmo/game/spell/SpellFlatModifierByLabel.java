package com.github.mmo.game.spell;

import com.github.mmo.game.entity.player.model.SpellFlatModByLabel;
import com.github.mmo.game.entity.player.model.SpellModifier;

public class SpellFlatModifierByLabel extends SpellModifier {
    public SpellFlatModByLabel value = new SpellFlatModByLabel();

    public SpellFlatModifierByLabel(Aura ownerAura) {
        super(ownerAura);
    }
}
