package com.github.azeroth.game.domain.areatrigger;

import com.badlogic.gdx.math.Vector3;
import com.github.azeroth.game.domain.object.ObjectGuid;

public class AreaTriggerOrbitInfo {
    public ObjectGuid pathTarget = null;
    public Vector3 center = null;
    public boolean counterClockwise;
    public boolean canLoop;
    public int timeToTarget;
    public int elapsedTimeForMovement;
    public int startDelay;
    public float radius;
    public float blendFromRadius;
    public float initialAngle;
    public float ZOffset;
}
