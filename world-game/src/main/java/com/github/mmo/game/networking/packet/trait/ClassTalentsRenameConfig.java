package com.github.mmo.game.networking.packet.trait;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ClassTalentsRenameConfig extends ClientPacket {
    public int configID;
    public String name;

    public ClassTalentsRenameConfig(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        configID = this.readInt32();
        var nameLength = this.<Integer>readBit(9);
        name = this.readString(nameLength);
    }
}
