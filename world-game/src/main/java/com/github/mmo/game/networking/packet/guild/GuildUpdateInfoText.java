package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GuildUpdateInfoText extends ClientPacket {
    public String infoText;

    public GuildUpdateInfoText(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var textLen = this.<Integer>readBit(11);
        infoText = this.readString(textLen);
    }
}
