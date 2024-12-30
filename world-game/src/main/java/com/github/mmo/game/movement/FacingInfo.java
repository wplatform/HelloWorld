package com.github.mmo.game.movement;


public class FacingInfo {
    public Vector3 f;
    public ObjectGuid target = ObjectGuid.EMPTY;
    public float angle;
    public MonsterMoveType type = MonsterMoveType.values()[0];
}
