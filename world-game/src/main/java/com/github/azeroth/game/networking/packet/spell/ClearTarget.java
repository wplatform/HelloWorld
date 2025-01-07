package com.github.azeroth.game.networking.packet.spell;


import com.github.azeroth.game.entity.ObjectGuid;

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
