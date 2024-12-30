package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class CharDelete extends ClientPacket {
    public ObjectGuid guid = ObjectGuid.EMPTY; // Guid of the character to delete

    public CharDelete(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        guid = this.readPackedGuid();
    }
}
