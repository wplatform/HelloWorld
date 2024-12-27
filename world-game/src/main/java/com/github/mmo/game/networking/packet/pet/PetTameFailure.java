package com.github.mmo.game.networking.packet.pet;


import com.github.mmo.game.networking.ServerPacket;

public class PetTameFailure extends ServerPacket {

    public byte result;

    public PetTameFailure() {
        super(ServerOpcode.PetTameFailure);
    }

    @Override
    public void write() {
        this.writeInt8(result);
    }
}
