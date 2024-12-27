package com.github.mmo.game.movement.model;


import com.badlogic.gdx.math.Vector3;
import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.WorldPacket;
import com.github.mmo.game.networking.packet.movement.MovementIOUtil;
import lombok.Data;

@Data
public class MovementForce {
    private ObjectGuid ID = ObjectGuid.EMPTY;
    private Vector3 origin;
    private Vector3 direction;
    private int transportID;
    private float magnitude;
    private MovementForceType type = MovementForceType.values()[0];
    private int unused910;

    public final void read(WorldPacket data) {
        setID(data.readPackedGuid());
        setOrigin(data.readVector3());
        setDirection(data.readVector3());
        setTransportID(data.readUInt());
        setMagnitude(data.readFloat());
        setUnused910(data.readInt32());
        int bit = data.readBit(2);
        setType(bit == 0 ? MovementForceType.Gravity : MovementForceType.values()[bit - 1]);
    }

    public final void write(WorldPacket data) {
        MovementIOUtil.writeMovementForceWithDirection(this, data);
    }
}

