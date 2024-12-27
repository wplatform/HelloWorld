package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.entity.unit.ProcEventInfo;
import com.github.mmo.game.spell.AuraEffect;

public interface IAuraEffectProcHandler extends IAuraEffectHandler
{
	void handleProc(AuraEffect aura, ProcEventInfo info);
}
