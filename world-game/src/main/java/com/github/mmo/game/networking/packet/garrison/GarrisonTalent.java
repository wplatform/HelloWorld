package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.*;
final class GarrisonTalent
{
	public void write(WorldPacket data)
	{
        data.writeInt32(garrTalentID);
        data.writeInt32(rank);
        data.writeInt64(researchStartTime);
        data.writeInt32(flags);
        data.writeBit(socket != null);
        data.flushBits();

		if (socket != null)
		{
			socket.getValue().write(data);
		}
	}

	public int garrTalentID;
	public int rank;
	public long researchStartTime;
	public int flags;
	public GarrisonTalentsocketData socket = null;

	public GarrisonTalent clone()
	{
		GarrisonTalent varCopy = new GarrisonTalent();

		varCopy.garrTalentID = this.garrTalentID;
		varCopy.rank = this.rank;
		varCopy.researchStartTime = this.researchStartTime;
		varCopy.flags = this.flags;
		varCopy.socket = this.socket;

		return varCopy;
	}
}
