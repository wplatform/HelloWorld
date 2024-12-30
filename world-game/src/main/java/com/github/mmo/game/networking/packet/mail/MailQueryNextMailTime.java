package com.github.mmo.game.networking.packet.mail;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class MailQueryNextMailTime extends ClientPacket {
    public MailQueryNextMailTime(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
