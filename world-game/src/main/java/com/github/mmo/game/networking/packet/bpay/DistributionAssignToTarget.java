package com.github.mmo.game.networking.packet.bpay;

import com.github.mmo.game.networking.WorldPacket;

public class DistributionAssignToTarget extends ClientPacket
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
	private long distributionID = 0;
	public final long getDistributionID()
	{
		return distributionID;
	}
	public final void setDistributionID(long value)
	{
		distributionID = value;
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
	private short specializationID = 0;
	public final short getSpecializationID()
	{
		return specializationID;
	}
	public final void setSpecializationID(short value)
	{
		specializationID = value;
	}
	private short choiceID = 0;
	public final short getChoiceID()
	{
		return choiceID;
	}
	public final void setChoiceID(short value)
	{
		choiceID = value;
	}

	public DistributionAssignToTarget(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		setProductID(this.readUInt());
		setDistributionID(this.readUInt64());
		setTargetCharacter(this.readPackedGuid());
		setSpecializationID(this.readUInt16());
		setChoiceID(this.readUInt16());
	}
}
