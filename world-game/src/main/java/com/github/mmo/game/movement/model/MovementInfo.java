package com.github.mmo.game.movement.model;

import com.github.mmo.common.EnumFlag;
import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.entity.object.Position;
import com.github.mmo.game.entity.unit.enums.MovementFlag;
import com.github.mmo.game.entity.unit.enums.MovementFlag2;
import lombok.Data;

@Data
public class MovementInfo {
    // common
    private ObjectGuid guid;
    private EnumFlag<MovementFlag> flags = EnumFlag.of(MovementFlag.NONE);
    private EnumFlag<MovementFlag2> flags2 = EnumFlag.of(MovementFlag2.NONE);
    private Position pos;
    private int time;

    private TransportInfo transport;

    // swimming/flying
    private float pitch;

    private JumpInfo jump;
    // spline
    private float stepUpStartElevation;

    public MovementInfo() {
        pos = new Position();
        transport = new TransportInfo();
        jump = new JumpInfo();
    }


    public int getMovementFlags() {
        return flags.getFlag();
    }

    public void setMovementFlags(MovementFlag flag) {
        flags.set(flag);
    }

    public void addMovementFlag(MovementFlag flag) {
        flags.addFlag(flag);
    }

    public void removeMovementFlag(MovementFlag flag) {
        flags.removeFlag(flag);
    }

    public boolean hasMovementFlag(MovementFlag flag) {
        return flags.hasFlag(flag);
    }

    public int getExtraMovementFlags() {
        return flags2.getFlag();
    }

    public void setExtraMovementFlags(MovementFlag2 flag) {
        flags2.set(flag);
    }

    public void addExtraMovementFlag(MovementFlag2 flag) {
        flags2.addFlag(flag);
    }

    public void removeExtraMovementFlag(MovementFlag2 flag) {
        flags2.removeFlag(flag);
    }

    public boolean hasExtraMovementFlag(MovementFlag2 flag) {
        return flags2.hasFlag(flag);
    }


    void resetTransport() {
        transport = new TransportInfo();
    }

    void resetJump() {
        jump = new JumpInfo();
    }

    void outDebug() {
        // Debug implementation
    }
}



