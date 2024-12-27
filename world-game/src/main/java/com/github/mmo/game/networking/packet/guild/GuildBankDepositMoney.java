package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;

public class GuildBankDepositMoney extends ClientPacket
{
    public ObjectGuid banker = ObjectGuid.EMPTY;
	public long money;
	public GuildBankDepositMoney(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        banker = this.readPackedGuid();
        money = this.readUInt64();
	}
}
