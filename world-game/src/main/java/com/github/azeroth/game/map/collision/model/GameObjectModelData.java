package com.github.azeroth.game.map.collision.model;


import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;


public class GameObjectModelData {
    public final String name;
    public final boolean isWmo;

    public BoundingBox bound;

    public GameObjectModelData(String name, Vector3 lowBound, Vector3 highBound, boolean isWmo) {
        bound = new BoundingBox(lowBound, highBound);
        this.name = name;
        this.isWmo = isWmo;
    }
}
