package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;public class SaveGuildEmblem extends ClientPacket {
    public ObjectGuid vendor = ObjectGuid.EMPTY;

    public int BStyle;

    public int EStyle;

    public int BColor;

    public int EColor;

    public int bg;

    public SaveGuildEmblem(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        vendor = this.readPackedGuid();
        EStyle = this.readUInt();
        EColor = this.readUInt();
        BStyle = this.readUInt();
        BColor = this.readUInt();
        bg = this.readUInt();
    }
}
