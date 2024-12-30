package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GetUndeleteCharacterCooldownStatus extends ClientPacket {
    public GetUndeleteCharacterCooldownStatus(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
