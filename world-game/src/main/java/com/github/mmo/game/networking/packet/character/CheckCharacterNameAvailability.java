package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class CheckCharacterNameAvailability extends ClientPacket {

    public int sequenceIndex;
    public String name;

    public CheckCharacterNameAvailability(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        sequenceIndex = this.readUInt();
        name = this.readString(this.<Integer>readBit(6));
    }
}
