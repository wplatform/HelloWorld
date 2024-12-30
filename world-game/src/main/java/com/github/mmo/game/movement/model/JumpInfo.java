package com.github.mmo.game.movement.model;

import lombok.Data;

// jumping
@Data
public class JumpInfo {
    private int fallTime;
    private float zspeed;
    private float sinAngle;
    private float cosAngle;
    private float xyspeed;

    void reset() {
        fallTime = 0;
        zspeed = sinAngle = cosAngle = xyspeed = 0.0f;
    }
}
