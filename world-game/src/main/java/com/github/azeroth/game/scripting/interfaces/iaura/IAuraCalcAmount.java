package com.github.azeroth.game.scripting.interfaces.iaura;


import Framework.models.*;
import com.github.azeroth.game.spell.AuraEffect;

public interface IAuraCalcAmount extends IAuraEffectHandler {
    void handleCalcAmount(AuraEffect aurEff, tangible.RefObject<Double> amount, tangible.RefObject<Boolean> canBeRecalculated);
}
