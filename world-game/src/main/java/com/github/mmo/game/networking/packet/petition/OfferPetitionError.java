package com.github.mmo.game.networking.packet.petition;


import com.github.mmo.game.networking.*;public class OfferPetitionError extends ServerPacket {
    public ObjectGuid playerGUID = ObjectGuid.EMPTY;

    public OfferPetitionError() {
        super(ServerOpcode.OfferPetitionError);
    }

    @Override
    public void write() {
        this.writeGuid(playerGUID);
    }
}
