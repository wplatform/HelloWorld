package com.github.mmo.game.networking.packet.guild;


public class GuildEventBankMoneyChanged extends ServerPacket
{
	public long money;
	public GuildEventBankMoneyChanged()
	{
		super(ServerOpcode.GuildEventBankMoneyChanged);
	}

	@Override
	public void write()
	{
		this.writeInt64(money);
	}
}
