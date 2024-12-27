package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;
public final class SpellChannelStartInterruptImmunities
{
	public void write(WorldPacket data)
	{
		data.writeInt32(schoolImmunities);
		data.writeInt32(immunities);
	}

	public int schoolImmunities;
	public int immunities;

	public SpellChannelStartInterruptImmunities clone()
	{
		SpellChannelStartInterruptImmunities varCopy = new SpellChannelStartInterruptImmunities();

		varCopy.schoolImmunities = this.schoolImmunities;
		varCopy.immunities = this.immunities;

		return varCopy;
	}
}
