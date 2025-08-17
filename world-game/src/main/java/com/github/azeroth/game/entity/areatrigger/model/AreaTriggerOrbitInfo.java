package com.github.azeroth.game.entity.areatrigger.model;

import com.badlogic.gdx.math.Vector3;
import com.github.azeroth.game.domain.object.ObjectGuid;
import com.github.azeroth.game.networking.WorldPacket;

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

    public final void write(WorldPacket data) {
        data.writeBit(pathTarget != null);
        data.writeBit(center != null);
        data.writeBit(counterClockwise);
        data.writeBit(canLoop);

        data.writeInt32(timeToTarget);
        data.writeInt32(elapsedTimeForMovement);
        data.writeInt32(startDelay);
        data.writeFloat(radius);
        data.writeFloat(blendFromRadius);
        data.writeFloat(initialAngle);
        data.writeFloat(ZOffset);

        if (pathTarget != null) {
            data.writeGuid(pathTarget);
        }

        if (center != null) {
            data.writeVector3(center);
        }
    }
}
