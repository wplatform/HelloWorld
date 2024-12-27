package com.github.mmo.dbc.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ScenarioStepFlags {
    SCENARIO_STEP_FLAG_BONUS_OBJECTIVE(0x1),
    SCENARIO_STEP_FLAG_HEROIC_ONLY(0x2);

    public final int value;
}
