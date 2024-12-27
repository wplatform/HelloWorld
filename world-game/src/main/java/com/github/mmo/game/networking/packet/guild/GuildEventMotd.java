package com.github.mmo.game.networking.packet.guild;


public class GuildEventMotd extends ServerPacket
{
	public String motdText;
	public GuildEventMotd()
	{
		super(ServerOpcode.GuildEventMotd);
	}

	@Override
	public void write()
	{
		this.writeBits(motdText.GetByteCount(), 11);
		this.writeString(motdText);
	}
}
