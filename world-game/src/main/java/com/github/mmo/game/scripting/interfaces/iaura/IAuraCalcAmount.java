package com.github.mmo.game.scripting.interfaces.iaura;


import Framework.models.*;
import com.github.mmo.game.spell.AuraEffect;

public interface IAuraCalcAmount extends IAuraEffectHandler {
    void handleCalcAmount(AuraEffect aurEff, tangible.RefObject<Double> amount, tangible.RefObject<Boolean> canBeRecalculated);
}
