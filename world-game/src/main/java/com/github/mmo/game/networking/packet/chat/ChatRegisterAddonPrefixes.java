package com.github.mmo.game.networking.packet.chat;

import com.github.mmo.game.networking.*;class ChatRegisterAddonPrefixes extends ClientPacket {
    public String[] prefixes = new String[64];

    public ChatRegisterAddonPrefixes(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var count = this.readInt32();

        for (var i = 0; i < count && i < 64; ++i) {
            Prefixes[i] = this.readString(this.<Integer>readBit(5));
        }
    }
}
