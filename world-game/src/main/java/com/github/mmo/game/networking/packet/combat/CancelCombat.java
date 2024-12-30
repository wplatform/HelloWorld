package com.github.mmo.game.networking.packet.combat;


public class CancelCombat extends ServerPacket {
    public CancelCombat() {
        super(ServerOpcode.CancelCombat);
    }

    @Override
    public void write() {
    }
}
