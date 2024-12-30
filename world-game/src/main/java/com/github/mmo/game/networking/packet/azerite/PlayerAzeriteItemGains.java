package com.github.mmo.game.networking.packet.azerite;

import com.github.mmo.game.networking.ServerPacket;

public class PlayerAzeriteItemGains extends ServerPacket {
    public ObjectGuid itemGUID = ObjectGuid.EMPTY;
    public long XP;

    public PlayerAzeriteItemGains() {
        super(ServerOpcode.PlayerAzeriteItemGains);
    }

    @Override
    public void write() {
        this.writeGuid(itemGUID);
        this.writeInt64(XP);
    }
}
