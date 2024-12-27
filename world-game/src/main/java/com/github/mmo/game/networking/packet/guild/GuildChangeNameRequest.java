package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;public class GuildChangeNameRequest extends ClientPacket {
    public String newName;

    public GuildChangeNameRequest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var nameLen = this.<Integer>readBit(7);
        newName = this.readString(nameLen);
    }
}
