package com.github.azeroth.game.phasing;

import com.github.azeroth.game.condition.Condition;

import java.util.ArrayList;

public class PhaseRef {
    public PhaseFlag flags = PhaseFlag.NONE;
    public int references;
    public ArrayList<Condition> areaConditions;

    public PhaseRef(PhaseFlag flags, ArrayList<Condition> conditions) {
        this.flags = flags;
        references = 0;
        areaConditions = conditions;
    }

    public final boolean isPersonal() {
        return (flags.value & PhaseFlag.PERSONAL.value) != 0;
    }
}
