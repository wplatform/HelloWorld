package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GenerateRandomCharacterName extends ClientPacket {

    public byte sex;

    public byte race;

    public GenerateRandomCharacterName(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        race = this.readUInt8();
        sex = this.readUInt8();
    }
}
