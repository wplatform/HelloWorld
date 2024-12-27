package com.github.mmo.game.networking.packet.bpay;

import com.github.mmo.game.networking.WorldPacket;

import java.util.ArrayList;


public class BpayProductInfo
{
	private int entry;
	public final int getEntry()
	{
		return entry;
	}
	public final void setEntry(int value)
	{
		entry = value;
	}
	private int productId;
	public final int getProductId()
	{
		return productId;
	}
	public final void setProductId(int value)
	{
		productId = value;
	}
	private long normalPriceFixedPoint;
	public final long getNormalPriceFixedPoint()
	{
		return normalPriceFixedPoint;
	}
	public final void setNormalPriceFixedPoint(long value)
	{
		normalPriceFixedPoint = value;
	}
	private long currentPriceFixedPoint;
	public final long getCurrentPriceFixedPoint()
	{
		return currentPriceFixedPoint;
	}
	public final void setCurrentPriceFixedPoint(long value)
	{
		currentPriceFixedPoint = value;
	}
	private ArrayList<Integer> productIds = new ArrayList<>();
	public final ArrayList<Integer> getProductIds()
	{
		return productIds;
	}
	public final void setProductIds(ArrayList<Integer> value)
	{
		productIds = value;
	}
	private int unk1;
	public final int getUnk1()
	{
		return unk1;
	}
	public final void setUnk1(int value)
	{
		unk1 = value;
	}
	private int unk2;
	public final int getUnk2()
	{
		return unk2;
	}
	public final void setUnk2(int value)
	{
		unk2 = value;
	}
	private ArrayList<Integer> unkInts = new ArrayList<>();
	public final ArrayList<Integer> getUnkInts()
	{
		return unkInts;
	}
	public final void setUnkInts(ArrayList<Integer> value)
	{
		unkInts = value;
	}
	private int unk3;
	public final int getUnk3()
	{
		return unk3;
	}
	public final void setUnk3(int value)
	{
		unk3 = value;
	}
	private int choiceType;
	public final int getChoiceType()
	{
		return choiceType;
	}
	public final void setChoiceType(int value)
	{
		choiceType = value;
	}
	private BpaydisplayInfo display;
	public final BpayDisplayInfo getDisplay()
	{
		return display;
	}
	public final void setDisplay(BpayDisplayInfo value)
	{
		display = value;
	}

	public final void write(WorldPacket this)
	{
		this.write(getProductId());
		this.write(getNormalPriceFixedPoint());
		this.write(getCurrentPriceFixedPoint());
		this.write((int)getProductIds().size());
		this.write(getUnk1());
		this.write(getUnk2());
		this.write((int)getUnkInts().size());
		this.write(getUnk3());

		for (var id : getProductIds())
		{
			this.write(id);
		}

		for (var id : getUnkInts())
		{
			this.write(id);
		}

		this.writeBits(getChoiceType(), 7);

		var wrote = this.writeBit(getDisplay().has_value());
		this.flushBits();

		if (wrote)
		{
			getDisplay().write(this);
		}
	}
}
