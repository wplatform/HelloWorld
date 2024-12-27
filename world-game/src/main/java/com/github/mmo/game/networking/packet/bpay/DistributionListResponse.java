package com.github.mmo.game.networking.packet.bpay;


import java.util.ArrayList;


public class DistributionListResponse extends ServerPacket
{
	private int result = 0;
	public final int getResult()
	{
		return result;
	}
	public final void setResult(int value)
	{
		result = value;
	}
	private ArrayList<BpaydistributionObject> distributionObject = new ArrayList<>();
	public final ArrayList<BpayDistributionObject> getDistributionObject()
	{
		return distributionObject;
	}
	public final void setDistributionObject(ArrayList<BpayDistributionObject> value)
	{
		distributionObject = value;
	}

	public DistributionListResponse()
	{
		super(ServerOpcode.BattlePayGetDistributionListResponse);
	}

	@Override
	public void write()
	{
		this.write(getResult());
        this.writeBits((int) getDistributionObject().size(), 11);

		for (var objectData : getDistributionObject())
		{
			objectData.write(this);
		}
	}
}
