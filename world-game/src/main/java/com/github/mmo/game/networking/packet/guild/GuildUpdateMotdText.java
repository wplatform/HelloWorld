package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GuildUpdateMotdText extends ClientPacket {
    public String motdText;

    public GuildUpdateMotdText(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var textLen = this.<Integer>readBit(11);
        motdText = this.readString(textLen);
    }
}
