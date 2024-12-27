package com.github.mmo.game.entity.player.model;

import com.github.mmo.game.entity.player.enums.SpellModType;
import com.github.mmo.game.spell.Aura;
import com.github.mmo.game.spell.enums.SpellModOp;
import lombok.Data;

@Data
public class SpellModifier {
    private SpellModOp op;
    private SpellModType type;

    private int spellId;
    private Aura ownerAura;

    public SpellModifier(Aura ownerAura) {
        setOp(SpellModOp.HealingAndDamage);
        setType(SpellModType.FLAT);
        setSpellId(0);
        setOwnerAura(ownerAura);
    }
}
