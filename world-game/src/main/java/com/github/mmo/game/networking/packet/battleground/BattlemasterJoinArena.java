package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class BattlemasterJoinArena extends ClientPacket {
    public byte teamSizeIndex;
    public byte roles;

    public BattlemasterJoinArena(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        teamSizeIndex = this.readUInt8();
        roles = this.readUInt8();
    }
}
