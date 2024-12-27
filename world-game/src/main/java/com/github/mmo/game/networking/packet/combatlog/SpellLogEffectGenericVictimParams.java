package com.github.mmo.game.networking.packet.combatlog;

public final class SpellLogEffectGenericVictimParams
{
    public ObjectGuid victim = ObjectGuid.EMPTY;

	public SpellLogEffectGenericVictimParams clone()
	{
		SpellLogEffectGenericVictimParams varCopy = new SpellLogEffectGenericVictimParams();

        varCopy.victim = this.victim;

		return varCopy;
	}
}
