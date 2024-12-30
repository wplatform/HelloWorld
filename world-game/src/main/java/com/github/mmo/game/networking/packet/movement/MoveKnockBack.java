package com.github.mmo.game.networking.packet.movement;


import com.github.mmo.game.networking.ServerPacket;

class MoveKnockBack extends ServerPacket {
    public ObjectGuid moverGUID = ObjectGuid.EMPTY;
    public Vector2 direction;
    public MoveKnockBackspeeds speeds = new moveKnockBackSpeeds();

    public int sequenceIndex;

    public MoveKnockBack() {
        super(ServerOpcode.MoveKnockBack, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(moverGUID);
        this.writeInt32(sequenceIndex);
        this.writeVector2(direction);
        speeds.write(this);
    }
}
