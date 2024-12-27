package com.github.mmo.game.networking.packet.bpay;


import com.github.mmo.game.networking.packet.itemInstance;

import java.util.ArrayList;


public class DeliveryEnded extends ServerPacket
{
	private ArrayList<itemInstance> item = new ArrayList<>();
	public final ArrayList<itemInstance> getItem()
	{
		return item;
	}
	public final void setItem(ArrayList<itemInstance> value)
	{
		item = value;
	}
	private long distributionID = 0;
	public final long getDistributionID()
	{
		return distributionID;
	}
	public final void setDistributionID(long value)
	{
		distributionID = value;
	}

	public DeliveryEnded()
	{
		super(ServerOpcode.BattlePayDeliveryEnded);
	}

	@Override
	public void write()
	{
		this.write(getDistributionID());

		this.write(getItem().size());

		for (var itemData : getItem())
		{
			itemData.write(this);
		}
	}
}
