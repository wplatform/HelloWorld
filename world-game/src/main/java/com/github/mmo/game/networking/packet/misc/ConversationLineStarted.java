package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ConversationLineStarted extends ClientPacket {
    public ObjectGuid conversationGUID = ObjectGuid.EMPTY;
    public int lineID;

    public ConversationLineStarted(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        conversationGUID = this.readPackedGuid();
        lineID = this.readUInt();
    }
}
