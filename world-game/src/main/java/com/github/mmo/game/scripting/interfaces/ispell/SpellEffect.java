package com.github.mmo.game.scripting.interfaces.ispell;


public class SpellEffect implements ISpellEffect
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

	private SpellScripthookType hookType = SpellScriptHookType.values()[0];
	public final SpellScriptHookType getHookType()
	{
		return hookType;
	}
	private void setHookType(SpellScriptHookType value)
	{
		hookType = value;
	}

	public SpellEffect(int effectIndex, SpellScriptHookType hookType)
	{
		setEffectIndex(effectIndex);
		setHookType(hookType);
	}
}
