package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ServerPacket;

public class DestroyArenaUnit extends ServerPacket {
    public ObjectGuid guid = ObjectGuid.EMPTY;

    public DestroyArenaUnit() {
        super(ServerOpcode.DestroyArenaUnit);
    }

    @Override
    public void write() {
        this.writeGuid(guid);
    }
}
