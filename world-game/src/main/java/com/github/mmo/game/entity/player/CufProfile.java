package com.github.mmo.game.entity.player;



public class CufProfile
{
	private String profileName;
	public final String getProfileName()
	{
		return profileName;
	}
	public final void setProfileName(String value)
	{
		profileName = value;
	}
	private short frameHeight;
	public final short getFrameHeight()
	{
		return frameHeight;
	}
	public final void setFrameHeight(short value)
	{
		frameHeight = value;
	}
	private short frameWidth;
	public final short getFrameWidth()
	{
		return frameWidth;
	}
	public final void setFrameWidth(short value)
	{
		frameWidth = value;
	}
	private byte sortBy;
	public final byte getSortBy()
	{
		return sortBy;
	}
	public final void setSortBy(byte value)
	{
		sortBy = value;
	}
	private byte healthText;
	public final byte getHealthText()
	{
		return healthText;
	}
	public final void setHealthText(byte value)
	{
		healthText = value;
	}

	// LeftAlign, TopAlight, BottomAlign
	private byte topPoint;
	public final byte getTopPoint()
	{
		return topPoint;
	}
	public final void setTopPoint(byte value)
	{
		topPoint = value;
	}
	private byte bottomPoint;
	public final byte getBottomPoint()
	{
		return bottomPoint;
	}
	public final void setBottomPoint(byte value)
	{
		bottomPoint = value;
	}
	private byte leftPoint;
	public final byte getLeftPoint()
	{
		return leftPoint;
	}
	public final void setLeftPoint(byte value)
	{
		leftPoint = value;
	}

	// leftOffset, TopOffset and BottomOffset
	private short topOffset;
	public final short getTopOffset()
	{
		return topOffset;
	}
	public final void setTopOffset(short value)
	{
		topOffset = value;
	}
	private short bottomOffset;
	public final short getBottomOffset()
	{
		return bottomOffset;
	}
	public final void setBottomOffset(short value)
	{
		bottomOffset = value;
	}
	private short leftOffset;
	public final short getLeftOffset()
	{
		return leftOffset;
	}
	public final void setLeftOffset(short value)
	{
		leftOffset = value;
	}

	private BitSet boolOptions;
	public final BitSet getBoolOptions()
	{
		return boolOptions;
	}
	public final void setBoolOptions(BitSet value)
	{
		boolOptions = value;
	}

	public CufProfile()
	{
		setBoolOptions(new bitSet(CUFBoolOptions.BoolOptionsCount.getValue()));
	}

	public CufProfile(String name, short frameHeight, short frameWidth, byte sortBy, byte healthText, int boolOptions, byte topPoint, byte bottomPoint, byte leftPoint, short topOffset, short bottomOffset, short leftOffset)
	{
		setProfileName(name);

		setBoolOptions(new bitSet(new int[] {boolOptions}));

		setFrameHeight(frameHeight);
		setFrameWidth(frameWidth);
		setSortBy(sortBy);
		setHealthText(healthText);
		setTopPoint(topPoint);
		setBottomPoint(bottomPoint);
		setLeftPoint(leftPoint);
		setTopOffset(topOffset);
		setBottomOffset(bottomOffset);
		setLeftOffset(leftOffset);
	}

	public final void setOption(CUFBoolOptions opt, byte arg)
	{
		getBoolOptions().set(opt.getValue(), arg != 0);
	}

	public final boolean getOption(CUFBoolOptions opt)
	{
		return getBoolOptions().Get(opt.getValue());
	}

	public final long getUlongOptionValue()
	{
		var array = new int[1];
		getBoolOptions().CopyTo(array, 0);

		return (long)array[0];
	}

	// More fields can be added to BoolOptions without changing DB schema (up to 32, currently 27)
}
