package com.github.mmo.game.networking.packet.lfg;

import com.github.mmo.game.networking.ServerPacket;

public class LfgDisabled extends ServerPacket {
    public LfgDisabled() {
        super(ServerOpcode.LfgDisabled, ConnectionType.instance);
    }

    @Override
    public void write() {
    }
}
