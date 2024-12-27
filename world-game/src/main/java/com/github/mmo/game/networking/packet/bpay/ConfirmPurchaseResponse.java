package com.github.mmo.game.networking.packet.bpay;

import com.github.mmo.game.networking.WorldPacket;

public class ConfirmPurchaseResponse extends ClientPacket
{
	private long clientCurrentPriceFixedPoint = 0;
	public final long getClientCurrentPriceFixedPoint()
	{
		return clientCurrentPriceFixedPoint;
	}
	public final void setClientCurrentPriceFixedPoint(long value)
	{
		clientCurrentPriceFixedPoint = value;
	}
	private int serverToken = 0;
	public final int getServerToken()
	{
		return serverToken;
	}
	public final void setServerToken(int value)
	{
		serverToken = value;
	}
	private boolean confirmPurchase = false;
	public final boolean getConfirmPurchase()
	{
		return confirmPurchase;
	}
	public final void setConfirmPurchase(boolean value)
	{
		confirmPurchase = value;
	}

	public ConfirmPurchaseResponse(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		setConfirmPurchase(this.ReadBool());
		setServerToken(this.readUInt());
		setClientCurrentPriceFixedPoint(this.readUInt64());
	}
}
