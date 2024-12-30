package com.github.mmo.game.networking.packet.character;


import com.github.mmo.game.networking.ServerPacket;

public class InitialSetup extends ServerPacket {

    public byte serverExpansionTier;

    public byte serverExpansionLevel;

    public InitialSetup() {
        super(ServerOpcode.InitialSetup, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt8(serverExpansionLevel);
        this.writeInt8(serverExpansionTier);
    }
}
