package com.github.mmo.game.networking.packet.social;

import com.github.mmo.game.networking.ServerPacket;

public class SocialContractRequestResponse extends ServerPacket {
    public boolean showSocialContract;

    public SocialContractRequestResponse() {
        super(ServerOpcode.SocialContractRequestResponse);
    }

    @Override
    public void write() {
        this.writeBit(showSocialContract);
        this.flushBits();
    }
}
