package com.github.mmo.game.networking.packet.guild;


public class GuildBankRemainingWithdrawMoney extends ServerPacket
{
	public long remainingWithdrawMoney;
	public GuildBankRemainingWithdrawMoney()
	{
		super(ServerOpcode.GuildBankRemainingWithdrawMoney);
	}

	@Override
	public void write()
	{
		this.writeInt64(remainingWithdrawMoney);
	}
}
