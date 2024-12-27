package com.github.mmo.game.networking.packet.bpay;


import java.util.ArrayList;


public class PurchaseUpdate extends ServerPacket
{
	private ArrayList<Bpaypurchase> purchase = new ArrayList<>();
	public final ArrayList<BpayPurchase> getPurchase()
	{
		return purchase;
	}
	public final void setPurchase(ArrayList<BpayPurchase> value)
	{
		purchase = value;
	}

	public PurchaseUpdate()
	{
		super(ServerOpcode.BattlePayPurchaseUpdate);
	}

	@Override
	public void write()
	{
        this.writeInt32((int) getPurchase().size());

		for (var purchaseData : getPurchase())
		{
			purchaseData.write(this);
		}
	}
}
