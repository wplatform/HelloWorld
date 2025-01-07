package com.github.azeroth.game.scripting.interfaces.ispell;

import com.github.azeroth.game.entity.unit.DamageInfo;
import com.github.azeroth.game.scripting.interfaces.ISpellScript;

public interface ISpellCalculateResistAbsorb extends ISpellScript {
    void CalculateResistAbsorb(DamageInfo damageInfo, tangible.RefObject<Double> resistAmount, tangible.RefObject<Double> absorbAmount);
}
