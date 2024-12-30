package com.github.mmo.game.scripting.interfaces.iaura;


import Framework.models.*;
import com.github.mmo.game.spell.AuraEffect;

public interface IAuraCalcPeriodic extends IAuraEffectHandler {
    void calcPeriodic(AuraEffect aura, BoxedValue<Boolean> isPeriodic, BoxedValue<Integer> amplitude);
}
