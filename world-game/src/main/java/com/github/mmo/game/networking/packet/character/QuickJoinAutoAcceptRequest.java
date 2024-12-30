package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QuickJoinAutoAcceptRequest extends ClientPacket {
    public boolean autoAccept;

    public QuickJoinAutoAcceptRequest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        autoAccept = this.readBit() == 1;
    }
}
