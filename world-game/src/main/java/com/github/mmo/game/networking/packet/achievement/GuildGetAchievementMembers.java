package com.github.mmo.game.networking.packet.achievement;

import com.github.mmo.game.networking.*;

class GuildGetAchievementMembers extends ClientPacket
{
    public ObjectGuid playerGUID = ObjectGuid.EMPTY;
    public ObjectGuid guildGUID = ObjectGuid.EMPTY;
	public int achievementID;
	public GuildGetAchievementMembers(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        playerGUID = this.readPackedGuid();
        guildGUID = this.readPackedGuid();
        achievementID = this.readUInt();
	}
}
