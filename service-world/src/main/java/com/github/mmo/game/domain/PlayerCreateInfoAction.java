package com.github.mmo.game.domain;
public class PlayerCreateInfoAction
{
	private byte button;
	public final byte getButton()
	{
		return button;
	}
	public final void setButton(byte value)
	{
		button = value;
	}
	private byte type;
	public final byte getType()
	{
		return type;
	}
	public final void setType(byte value)
	{
		type = value;
	}
	private int action;
	public final int getAction()
	{
		return action;
	}
	public final void setAction(int value)
	{
		action = value;
	}

	public PlayerCreateInfoAction()
	{
		this((byte)0, 0, (byte)0);
	}

	public PlayerCreateInfoAction(byte button, int action, byte type)
	{
		setButton(button);
		setType(type);
		setAction(action);
	}
}
