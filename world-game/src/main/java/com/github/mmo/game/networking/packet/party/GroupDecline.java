package com.github.mmo.game.networking.packet.party;


import com.github.mmo.game.networking.ServerPacket;
public class GroupDecline extends ServerPacket {
    public String name;

    public GroupDecline(String name) {
        super(ServerOpcode.GroupDecline);
        name = name;
    }

    @Override
    public void write() {
        this.writeBits(name.GetByteCount(), 9);
        this.flushBits();
        this.writeString(name);
    }
}
