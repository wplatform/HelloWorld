package com.github.mmo.game.networking.packet.petition;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class PetitionRenameGuild extends ClientPacket {
    public ObjectGuid petitionGuid = ObjectGuid.EMPTY;
    public String newGuildName;

    public PetitionRenameGuild(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        petitionGuid = this.readPackedGuid();

        this.resetBitPos();
        var nameLen = this.<Integer>readBit(7);

        newGuildName = this.readString(nameLen);
    }
}
