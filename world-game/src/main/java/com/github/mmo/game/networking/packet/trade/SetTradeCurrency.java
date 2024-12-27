package com.github.mmo.game.networking.packet.trade;

import com.github.mmo.game.networking.*;
public class SetTradeCurrency extends ClientPacket
{
	public int type;
	public int quantity;
	public SetTradeCurrency(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		type = this.readUInt();
		quantity = this.readUInt();
	}
}
