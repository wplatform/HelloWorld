package com.github.mmo.game.networking.packet.guild;


public class GuildFlaggedForRename extends ServerPacket
{
	public boolean flagSet;
	public GuildFlaggedForRename()
	{
		super(ServerOpcode.GuildFlaggedForRename);
	}

	@Override
	public void write()
	{
        this.writeBit(flagSet);
	}
}
