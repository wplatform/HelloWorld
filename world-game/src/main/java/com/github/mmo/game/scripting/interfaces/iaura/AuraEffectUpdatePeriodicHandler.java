package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.spell.*;

public class AuraEffectUpdatePeriodicHandler extends AuraEffectHandler implements IAuraUpdatePeriodic
{
	private final tangible.Action1Param<AuraEffect> fn;

	public AuraEffectUpdatePeriodicHandler(tangible.Action1Param<AuraEffect> fn, int effectIndex, AuraType auraType)
	{
		super(effectIndex, auraType, AuraScriptHookType.EffectUpdatePeriodic);
		fn = fn;
	}

	public final void updatePeriodic(AuraEffect aurEff)
	{
		fn.invoke(aurEff);
	}
}
