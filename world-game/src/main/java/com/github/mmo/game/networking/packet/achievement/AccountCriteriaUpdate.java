package com.github.mmo.game.networking.packet.achievement;


import com.github.mmo.game.networking.ServerPacket;

public class AccountCriteriaUpdate extends ServerPacket {
    public CriteriaprogressPkt progress = new criteriaProgressPkt();

    public AccountCriteriaUpdate() {
        super(ServerOpcode.AccountCriteriaUpdate);
    }

    @Override
    public void write() {
        progress.write(this);
    }
}
