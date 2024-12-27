package com.github.mmo.game.entity.player.model;

import com.github.mmo.game.spell.Aura;

public class SpellPctModifierByLabel extends SpellModifier
{
	public SpellPctModByLabel value = new SpellPctModByLabel();

	public SpellPctModifierByLabel(Aura ownerAura)
	{
		super(ownerAura);
	}
}
