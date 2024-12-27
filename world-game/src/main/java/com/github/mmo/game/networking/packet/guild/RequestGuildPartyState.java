package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;public class RequestGuildPartyState extends ClientPacket {
    public ObjectGuid guildGUID = ObjectGuid.EMPTY;

    public RequestGuildPartyState(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        guildGUID = this.readPackedGuid();
    }
}
