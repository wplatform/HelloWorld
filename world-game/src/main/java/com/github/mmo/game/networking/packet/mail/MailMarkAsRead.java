package com.github.mmo.game.networking.packet.mail;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class MailMarkAsRead extends ClientPacket {
    public ObjectGuid mailbox = ObjectGuid.EMPTY;
    public long mailID;

    public MailMarkAsRead(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        mailbox = this.readPackedGuid();
        mailID = this.readUInt64();
    }
}
