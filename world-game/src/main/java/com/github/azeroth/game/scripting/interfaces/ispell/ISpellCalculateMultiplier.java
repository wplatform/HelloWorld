package com.github.azeroth.game.scripting.interfaces.ispell;

import com.github.azeroth.game.scripting.interfaces.ISpellScript;

public interface ISpellCalculateMultiplier extends ISpellScript {
    /**
     * Returned value represents the new modifier that will be used.
     * Called at the end of the multiplier calc stack.
     * Multipliers are multiplicitive. For a 10% damage increase do
     * multiplier *= 1.1
     *
     * @param multiplier
     * @return
     */
    double CalcMultiplier(double multiplier);
}
