package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class BattlefieldListRequest extends ClientPacket {
    public int listID;

    public BattlefieldListRequest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        listID = this.readInt32();
    }
}
