package com.github.mmo.game.networking.packet.bpay;

import com.github.mmo.game.networking.WorldPacket;

public class StartPurchase extends ClientPacket
{
	private ObjectGuid targetCharacter = ObjectGuid.EMPTY;
	public final ObjectGuid getTargetCharacter()
	{
		return targetCharacter;
	}
	public final void setTargetCharacter(ObjectGuid value)
	{
		targetCharacter = value;
	}
	private int clientToken = 0;
	public final int getClientToken()
	{
		return clientToken;
	}
	public final void setClientToken(int value)
	{
		clientToken = value;
	}
	private int productID = 0;
	public final int getProductID()
	{
		return productID;
	}
	public final void setProductID(int value)
	{
		productID = value;
	}

	public StartPurchase(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		setClientToken(this.readUInt());
		setProductID(this.readUInt());
		setTargetCharacter(this.readPackedGuid());
	}
}
