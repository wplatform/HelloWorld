package com.github.mmo.game.networking.packet.areatrigger;

import com.github.mmo.game.networking.ServerPacket;

public class AreaTriggerNoCorpse extends ServerPacket {
    public AreaTriggerNoCorpse() {
        super(ServerOpcode.AreaTriggerNoCorpse);
    }

    @Override
    public void write() {
    }
}
