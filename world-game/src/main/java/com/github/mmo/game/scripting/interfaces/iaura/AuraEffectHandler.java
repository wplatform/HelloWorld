package com.github.mmo.game.scripting.interfaces.iaura;


public class AuraEffectHandler implements IAuraEffectHandler
{
	private int effectIndex;
	public final int getEffectIndex()
	{
		return effectIndex;
	}
	private void setEffectIndex(int value)
	{
		effectIndex = value;
	}

	private auraType auraType = getAuraType().values()[0];
	public final AuraType getAuraType()
	{
		return auraType;
	}
	private void setAuraType(AuraType value)
	{
		auraType = value;
	}

	private AuraScripthookType hookType = AuraScriptHookType.values()[0];
	public final AuraScriptHookType getHookType()
	{
		return hookType;
	}
	private void setHookType(AuraScriptHookType value)
	{
		hookType = value;
	}

	public AuraEffectHandler(int effectIndex, AuraType auraType, AuraScriptHookType hookType)
	{
		setEffectIndex(effectIndex);
		setAuraType(auraType);
		setHookType(hookType);
	}
}
