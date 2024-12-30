package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class EnumCharacters extends ClientPacket {
    public EnumCharacters(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}

// @todo: CharCustomizeResult

//Structs

