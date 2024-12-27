package com.github.mmo.game.entity.creature;

public class CreatureModel {
    public static creatureModel DEFAULTINVISIBLEMODEL = new creatureModel(11686, 1.0f, 1.0f);
    public static CreatureModel DEFAULTVISIBLEMODEL = new creatureModel(17519, 1.0f, 1.0f);


    public int creatureDisplayId;
    public float displayScale;
    public float probability;

    public creatureModel() {
    }


    public creatureModel(int creatureDisplayId, float displayScale, float probability) {
        creatureDisplayId = creatureDisplayId;
        displayScale = displayScale;
        probability = probability;
    }
}
