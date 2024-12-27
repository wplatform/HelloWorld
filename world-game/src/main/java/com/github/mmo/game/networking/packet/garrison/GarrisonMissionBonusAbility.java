package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.*;
final class GarrisonMissionBonusAbility
{
	public void write(WorldPacket data)
	{
		data.writeInt64(startTime);
		data.writeInt32(garrMssnBonusAbilityID);
	}

	public int garrMssnBonusAbilityID;
	public long startTime;

	public GarrisonMissionBonusAbility clone()
	{
		GarrisonMissionBonusAbility varCopy = new GarrisonMissionBonusAbility();

		varCopy.garrMssnBonusAbilityID = this.garrMssnBonusAbilityID;
		varCopy.startTime = this.startTime;

		return varCopy;
	}
}
