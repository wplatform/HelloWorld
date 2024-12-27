package com.github.mmo.game.networking.packet.bpay;

import com.github.mmo.game.networking.WorldPacket;
public class BattlePayAckFailedResponse extends ClientPacket
{
	private int serverToken = 0;
	public final int getServerToken()
	{
		return serverToken;
	}
	public final void setServerToken(int value)
	{
		serverToken = value;
	}

	public BattlePayAckFailedResponse(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        setServerToken(this.readUInt());
	}
}
