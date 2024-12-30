package com.github.mmo.game.networking.packet.battlepet;


import com.github.mmo.game.networking.ServerPacket;

public class BattlePetJournalLockDenied extends ServerPacket {
    public BattlePetJournalLockDenied() {
        super(ServerOpcode.BattlePetJournalLockDenied);
    }

    @Override
    public void write() {
    }
}
