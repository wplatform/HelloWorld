package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.spell.*;

public interface IAuraApplyHandler extends IAuraEffectHandler
{
	AuraEffectHandleModes getModes();
	void apply(AuraEffect aura, AuraEffectHandleModes auraMode);
}
