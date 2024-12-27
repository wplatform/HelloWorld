package com.github.mmo.game.networking.packet.guild;


import com.github.mmo.game.networking.*;

public class GuildEventStatusChange extends ServerPacket {
    public ObjectGuid guid = ObjectGuid.EMPTY;
    public boolean AFK;
    public boolean DND;

    public GuildEventStatusChange() {
        super(ServerOpcode.GuildEventStatusChange);
    }

    @Override
    public void write() {
        this.writeGuid(guid);
        this.writeBit(AFK);
        this.writeBit(DND);
        this.flushBits();
    }
}
