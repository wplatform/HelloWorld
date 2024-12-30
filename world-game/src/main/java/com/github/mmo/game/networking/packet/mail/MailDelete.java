package com.github.mmo.game.networking.packet.mail;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class MailDelete extends ClientPacket {

    public long mailID;
    public int deleteReason;

    public MailDelete(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        mailID = this.readUInt64();
        deleteReason = this.readInt32();
    }
}
