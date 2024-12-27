package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.WorldPacket;

public class GuildNewsUpdateSticky extends ClientPacket
{
	public int newsID;
    public ObjectGuid guildGUID = ObjectGuid.EMPTY;
	public boolean sticky;
	public GuildNewsUpdateSticky(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        guildGUID = this.readPackedGuid();
        newsID = this.readInt32();

        sticky = this.readBit();
	}
}
