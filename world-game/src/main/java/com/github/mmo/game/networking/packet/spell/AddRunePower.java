package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.ServerPacket;

public class AddRunePower extends ServerPacket {
    public int addedRunesMask;

    public AddRunePower() {
        super(ServerOpcode.AddRunePower, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(addedRunesMask);
    }
}
