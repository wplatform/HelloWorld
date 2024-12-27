package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;
class CancelChannelling extends ClientPacket
{
	public int channelSpell;
	public int reason; // 40 = /run spellStopCasting(), 16 = movement/AURA_INTERRUPT_FLAG_MOVE, 41 = turning/AURA_INTERRUPT_FLAG_TURNING
	public CancelChannelling(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		channelSpell = this.readInt32();
		reason = this.readInt32();
	}
	// does not match SpellCastResult enum
}
