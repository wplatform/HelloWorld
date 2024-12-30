package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ServerPacket;

public class SetFactionVisible extends ServerPacket {
    public int factionIndex;

    public SetFactionVisible(boolean visible) {
        super(visible ? ServerOpcode.SetFactionVisible : ServerOpcode.SetFactionNotVisible, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(factionIndex);
    }
}
