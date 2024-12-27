package com.github.mmo.game.networking.packet.adventurejournal;

import com.github.mmo.game.networking.*;
class AdventureJournalUpdateSuggestions extends ClientPacket
{
	public boolean onLevelUp;
	public AdventureJournalUpdateSuggestions(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        onLevelUp = this.readBit();
	}
}
