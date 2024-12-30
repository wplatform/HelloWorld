package com.github.mmo.game.networking.packet.gameobject;

import com.github.mmo.game.networking.ServerPacket;

public class FishNotHooked extends ServerPacket {
    public FishNotHooked() {
        super(ServerOpcode.FishNotHooked);
    }

    @Override
    public void write() {
    }
}
