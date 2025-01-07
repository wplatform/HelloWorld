package com.github.azeroth.game;

import com.github.azeroth.game.condition.Condition;

import java.util.ArrayList;

public class PhaseAreaInfo {
    public PhaseInfoStruct phaseInfo;
    public ArrayList<Integer> subAreaExclusions = new ArrayList<>();
    public ArrayList<Condition> conditions = new ArrayList<>();

    public PhaseAreaInfo(PhaseInfoStruct phaseInfo) {
        this.phaseInfo = phaseInfo;
    }
}
