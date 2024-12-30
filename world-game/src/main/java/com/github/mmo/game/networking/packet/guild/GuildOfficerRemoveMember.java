package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GuildOfficerRemoveMember extends ClientPacket {
    public ObjectGuid removee = ObjectGuid.EMPTY;

    public GuildOfficerRemoveMember(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        removee = this.readPackedGuid();
    }
}
