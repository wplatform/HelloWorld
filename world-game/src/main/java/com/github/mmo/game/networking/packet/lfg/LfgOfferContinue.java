package com.github.mmo.game.networking.packet.lfg;


import com.github.mmo.game.networking.*;class LfgOfferContinue extends ServerPacket {

    public int slot;


    public LfgOfferContinue(int slot) {
        super(ServerOpcode.LfgOfferContinue, ConnectionType.instance);
        slot = slot;
    }

    @Override
    public void write() {
        this.writeInt32(slot);
    }
}
