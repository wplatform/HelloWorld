package com.github.mmo.game.networking.packet.movement;


public class MoveSplineSetSpeed extends ServerPacket {
    public ObjectGuid moverGUID = ObjectGuid.EMPTY;
    public float speed = 1.0f;

    public MoveSplineSetSpeed(ServerOpCode opcode) {
        super(opcode, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(moverGUID);
        this.writeFloat(speed);
    }
}
