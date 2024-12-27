package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.spell.*;

public interface IAuraPeriodic extends IAuraEffectHandler
{
	void handlePeriodic(AuraEffect aurEff);
}
