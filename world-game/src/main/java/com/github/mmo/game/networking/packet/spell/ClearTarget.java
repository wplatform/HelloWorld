package com.github.mmo.game.networking.packet.spell;


import com.github.mmo.game.entity.ObjectGuid;

public class ClearTarget extends ServerPacket {
    public ObjectGuid guid = ObjectGuid.EMPTY;

    public ClearTarget() {
        super(ServerOpcode.ClearTarget);
    }

    @Override
    public void write() {
        this.writeGuid(guid);
    }
}
