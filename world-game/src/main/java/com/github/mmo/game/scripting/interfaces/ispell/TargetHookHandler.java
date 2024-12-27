package com.github.mmo.game.scripting.interfaces.ispell;


public class TargetHookHandler extends SpellEffect implements ITargetHookHandler
{
	private final Targets targetType;
	public final Targets getTargetType()
	{
		return targetType;
	}

	private final boolean area;
	public final boolean getArea()
	{
		return area;
	}

	private final boolean dest;
	public final boolean getDest()
	{
		return dest;
	}


	public TargetHookHandler(int effectIndex, Targets targetType, boolean area, SpellScriptHookType hookType)
	{
		this(effectIndex, targetType, area, hookType, false);
	}

	public TargetHookHandler(int effectIndex, Targets targetType, boolean area, SpellScriptHookType hookType, boolean dest)
	{
		super(effectIndex, hookType);
		targetType = targetType;
		area = area;
		dest = dest;
	}
}
