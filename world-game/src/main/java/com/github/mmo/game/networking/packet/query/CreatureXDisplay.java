package com.github.mmo.game.networking.packet.query;

public class CreatureXDisplay {

    public int creatureDisplayID;
    public float scale = 1.0f;
    public float probability = 1.0f;


    public CreatureXDisplay(int creatureDisplayID, float displayScale, float probability) {
        creatureDisplayID = creatureDisplayID;
        scale = displayScale;
        probability = probability;
    }
}
