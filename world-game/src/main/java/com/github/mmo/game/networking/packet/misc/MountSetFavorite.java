package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class MountSetFavorite extends ClientPacket {
    public int mountSpellID;
    public boolean isFavorite;

    public mountSetFavorite(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        mountSpellID = this.readUInt();
        isFavorite = this.readBit();
    }
}
