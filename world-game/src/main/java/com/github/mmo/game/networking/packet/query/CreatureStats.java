package com.github.mmo.game.networking.packet.query;


import java.util.ArrayList;

public class CreatureStats {
    public String title;
    public String titleAlt;
    public String cursorName;
    public int creatureType;
    public int creatureFamily;
    public int classification;
    public CreaturedisplayStats display = new creatureDisplayStats();
    public float hpMulti;
    public float energyMulti;
    public boolean leader;

    public ArrayList<Integer> questItems = new ArrayList<>();

    public int creatureMovementInfoID;
    public int healthScalingExpansion;

    public int requiredExpansion;

    public int vignetteID;
    public int class;
    public int creatureDifficultyID;
    public int widgetSetID;
    public int widgetSetUnitConditionID;

    public int[] flags = new int[2];

    public int[] proxyCreatureID = new int[SharedConst.MaxCreatureKillCredit];
    public LocalizedString name = new LocalizedString();
    public LocalizedString nameAlt = new LocalizedString();
}
