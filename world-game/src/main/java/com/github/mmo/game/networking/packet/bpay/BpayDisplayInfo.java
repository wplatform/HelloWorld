package com.github.mmo.game.networking.packet.bpay;

import com.github.mmo.game.networking.WorldPacket;

import java.util.ArrayList;


public class BpayDisplayInfo
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
	private int creatureDisplayID;
	public final int getCreatureDisplayID()
	{
		return creatureDisplayID;
	}
	public final void setCreatureDisplayID(int value)
	{
		creatureDisplayID = value;
	}
	private int visualID;
	public final int getVisualID()
	{
		return visualID;
	}
	public final void setVisualID(int value)
	{
		visualID = value;
	}
	private String name1 = "";
	public final String getName1()
	{
		return name1;
	}
	public final void setName1(String value)
	{
		name1 = value;
	}
	private String name2 = "";
	public final String getName2()
	{
		return name2;
	}
	public final void setName2(String value)
	{
		name2 = value;
	}
	private String name3 = "";
	public final String getName3()
	{
		return name3;
	}
	public final void setName3(String value)
	{
		name3 = value;
	}
	private String name4 = "";
	public final String getName4()
	{
		return name4;
	}
	public final void setName4(String value)
	{
		name4 = value;
	}
	private String name5 = "";
	public final String getName5()
	{
		return name5;
	}
	public final void setName5(String value)
	{
		name5 = value;
	}
	private String name6 = "";
	public final String getName6()
	{
		return name6;
	}
	public final void setName6(String value)
	{
		name6 = value;
	}
	private String name7 = "";
	public final String getName7()
	{
		return name7;
	}
	public final void setName7(String value)
	{
		name7 = value;
	}
	private int flags;
	public final int getFlags()
	{
		return flags;
	}
	public final void setFlags(int value)
	{
		flags = value;
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
	private int unk3;
	public final int getUnk3()
	{
		return unk3;
	}
	public final void setUnk3(int value)
	{
		unk3 = value;
	}
	private int unkInt1;
	public final int getUnkInt1()
	{
		return unkInt1;
	}
	public final void setUnkInt1(int value)
	{
		unkInt1 = value;
	}
	private int unkInt2;
	public final int getUnkInt2()
	{
		return unkInt2;
	}
	public final void setUnkInt2(int value)
	{
		unkInt2 = value;
	}
	private int unkInt3;
	public final int getUnkInt3()
	{
		return unkInt3;
	}
	public final void setUnkInt3(int value)
	{
		unkInt3 = value;
	}

	private ArrayList<BpayVisual> visuals = new ArrayList<>();
	public final ArrayList<BpayVisual> getVisuals()
	{
		return visuals;
	}
	public final void setVisuals(ArrayList<BpayVisual> value)
	{
		visuals = value;
	}

	public final void write(WorldPacket this)
	{
		this.writeBit(getCreatureDisplayID() != 0);
		this.writeBit(getVisualID() != 0);
		this.writeBits(getName1().length(), 10);
		this.writeBits(getName2().length(), 10);
		this.writeBits(getName3().length(), 13);
		this.writeBits(getName4().length(), 13);
		this.writeBits(getName5().length(), 13);
		this.writeBit(getFlags() != 0);
		this.writeBit(getUnk1() != 0);
		this.writeBit(getUnk2() != 0);
		this.writeBit(getUnk3() != 0);
		this.writeBits(getName6().length(), 13);
		this.writeBits(getName7().length(), 13);
		this.flushBits();
		this.write((int)getVisuals().size());
		this.write(getUnkInt1());
		this.write(getUnkInt2());
		this.write(getUnkInt3());

		if (getCreatureDisplayID() != 0)
		{
			this.write(getCreatureDisplayID());
		}

		if (getVisualID() != 0)
		{
			this.write(getVisualID());
		}

		this.writeString(getName1());
		this.writeString(getName2());
		this.writeString(getName3());
		this.writeString(getName4());
		this.writeString(getName5());

		if (getFlags() != 0)
		{
			this.write(getFlags());
		}

		if (getUnk1() != 0)
		{
			this.write(getUnk1());
		}

		if (getUnk2() != 0)
		{
			this.write(getUnk2());
		}

		if (getUnk3() != 0)
		{
			this.write(getUnk3());
		}

		this.writeString(getName6());
		this.writeString(getName7());

		for (var visual : getVisuals())
		{
			visual.write(this);
		}
	}
}