package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import io.netty.buffer.ByteBuf;

public class QuestGiverHello extends ClientPacket {
    public ObjectGuid questGiverGUID = ObjectGuid.EMPTY;

    public QuestGiverHello(ByteBuf packet) {
        super(packet);
    }

    @Override
    public void read() {
        questGiverGUID = this.readPackedGuid();
    }
}
