package com.github.mmo.game.networking.packet.chat;


import com.github.mmo.game.networking.ServerPacket;
public class DefenseMessage extends ServerPacket {

    public int zoneID;
    public String messageText = "";

    public DefenseMessage() {
        super(ServerOpcode.DefenseMessage);
    }

    @Override
    public void write() {
        this.writeInt32(zoneID);
        this.writeBits(messageText.GetByteCount(), 12);
        this.flushBits();
        this.writeString(messageText);
    }
}
