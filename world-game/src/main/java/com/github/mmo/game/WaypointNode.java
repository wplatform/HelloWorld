package com.github.mmo.game;


public class WaypointNode {
    public int id;
    public float x, y, z;
    public Float orientation = null;
    public int delay;
    public int eventId;
    public WaypointMoveType moveType = WaypointMoveType.values()[0];
    public byte eventChance;

    public WaypointNode() {
        moveType = WaypointMoveType.run;
    }


    public WaypointNode(int id, float _x, float _y, float _z, Float orientation) {
        this(id, _x, _y, _z, orientation, 0);
    }

    public WaypointNode(int id, float _x, float _y, float _z) {
        this(id, _x, _y, _z, null, 0);
    }

    public WaypointNode(int id, float _x, float _y, float _z, Float orientation, int delay) {
        id = id;
        x = _x;
        y = _y;
        z = _z;
        orientation = orientation;
        delay = delay;
        eventId = 0;
        moveType = WaypointMoveType.Walk;
        eventChance = 100;
    }
}
