package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;
public class GuildBankRemainingWithdrawMoneyQuery extends ClientPacket
{
	public GuildBankRemainingWithdrawMoneyQuery(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}