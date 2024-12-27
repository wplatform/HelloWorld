package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;
final class PartyDifficultySettings
{
	public void write(WorldPacket data)
	{
        data.writeInt32(dungeonDifficultyID);
        data.writeInt32(raidDifficultyID);
        data.writeInt32(legacyRaidDifficultyID);
	}

	public int dungeonDifficultyID;
	public int raidDifficultyID;
	public int legacyRaidDifficultyID;

	public PartyDifficultySettings clone()
	{
		PartyDifficultySettings varCopy = new PartyDifficultySettings();

		varCopy.dungeonDifficultyID = this.dungeonDifficultyID;
		varCopy.raidDifficultyID = this.raidDifficultyID;
		varCopy.legacyRaidDifficultyID = this.legacyRaidDifficultyID;

		return varCopy;
	}
}
