package com.github.mmo.game.scripting.interfaces.iaura;


import Framework.models.*;
import com.github.mmo.game.spell.*;

public class AuraEffectCalcAmountHandler extends AuraEffectHandler implements IAuraCalcAmount {
    private final tangible.Action3Param<AuraEffect, BoxedValue<Double>, BoxedValue<Boolean>> fn;

    public AuraEffectCalcAmountHandler(tangible.Action3Param<AuraEffect, BoxedValue<Double>, BoxedValue<Boolean>> fn, int effectIndex, AuraType auraType) {
        super(effectIndex, auraType, AuraScriptHookType.EffectCalcAmount);
        fn = fn;
    }

    public final void handleCalcAmount(AuraEffect aurEff, tangible.RefObject<Double> amount, tangible.RefObject<Boolean> canBeRecalculated) {
        var canbeCalc = new BoxedValue<Boolean>(canBeRecalculated.refArgValue);
        var boxedValue = new BoxedValue<Double>(amount.refArgValue);

        fn.invoke(aurEff, boxedValue, canbeCalc);

        amount.refArgValue = boxedValue.value;
        canBeRecalculated.refArgValue = canbeCalc.value;
    }
}
