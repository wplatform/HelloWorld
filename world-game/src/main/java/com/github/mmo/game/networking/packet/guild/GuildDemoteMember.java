package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;

public class GuildDemoteMember extends ClientPacket
{
    public ObjectGuid demotee = ObjectGuid.EMPTY;
	public GuildDemoteMember(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        demotee = this.readPackedGuid();
	}
}
