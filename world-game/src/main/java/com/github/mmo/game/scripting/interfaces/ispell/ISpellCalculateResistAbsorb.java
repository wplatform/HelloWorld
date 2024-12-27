package com.github.mmo.game.scripting.interfaces.ispell;

import com.github.mmo.game.entity.unit.DamageInfo;
import com.github.mmo.game.scripting.interfaces.ISpellScript;

public interface ISpellCalculateResistAbsorb extends ISpellScript
{
	void CalculateResistAbsorb(DamageInfo damageInfo, tangible.RefObject<Double> resistAmount, tangible.RefObject<Double> absorbAmount);
}
