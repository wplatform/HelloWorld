package com.github.azeroth.game.map.collision.model;


import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class ModelMinimalData {

    public byte flags;

    public byte adtId;

    public int id;
    public Vector3 iPos;
    public float iScale;
    public BoundingBox iBound;
    public String name;
}
