package com.github.mmo.game.networking.packet.movement;


public class MoveSplineSetFlag extends ServerPacket {
    public ObjectGuid moverGUID = ObjectGuid.EMPTY;

    public MoveSplineSetFlag(ServerOpCode opcode) {
        super(opcode, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(moverGUID);
    }
}
