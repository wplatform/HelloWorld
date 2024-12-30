package com.github.mmo.game.networking.packet.movement;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ServerPacket;
import com.github.mmo.game.networking.opcode.ServerOpCode;

public class MoveSetSpeed extends ServerPacket {
    public ObjectGuid moverGUID = ObjectGuid.EMPTY;
    public int sequenceIndex;
    public float speed = 1.0f;

    public MoveSetSpeed(ServerOpCode opcode) {
        super(opcode);
    }

    @Override
    public void write() {
        this.writeGuid(moverGUID);
        this.writeInt32(sequenceIndex);
        this.writeFloat(speed);
    }
}
