package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class SetDungeonDifficulty extends ClientPacket {
    public int difficultyID;

    public SetDungeonDifficulty(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        difficultyID = this.readUInt();
    }
}
