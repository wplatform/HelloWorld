package com.github.mmo.game.networking.packet.guild;


public class GuildEventTabModified extends ServerPacket
{
	public String icon;
	public String name;
	public int tab;
	public GuildEventTabModified()
	{
		super(ServerOpcode.GuildEventTabModified);
	}

	@Override
	public void write()
	{
		this.writeInt32(tab);

		this.writeBits(name.GetByteCount(), 7);
		this.writeBits(icon.GetByteCount(), 9);
		this.flushBits();

		this.writeString(name);
		this.writeString(icon);
	}
}