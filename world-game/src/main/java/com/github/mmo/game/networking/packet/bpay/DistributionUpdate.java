package com.github.mmo.game.networking.packet.bpay;


public class DistributionUpdate extends ServerPacket
{
	private BpaydistributionObject distributionObject = new bpayDistributionObject();
	public final BpayDistributionObject getDistributionObject()
	{
		return distributionObject;
	}
	public final void setDistributionObject(BpayDistributionObject value)
	{
		distributionObject = value;
	}

	public DistributionUpdate()
	{
		super(ServerOpcode.BattlePayDistributionUpdate);
	}

	@Override
	public void write()
	{
		getDistributionObject().write(this);
	}
}
