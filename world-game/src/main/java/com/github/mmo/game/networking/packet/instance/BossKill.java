package com.github.mmo.game.networking.packet.instance;


import com.github.mmo.game.networking.ServerPacket;

public class BossKill extends ServerPacket {

    public int dungeonEncounterID;

    public BossKill() {
        super(ServerOpcode.BossKill, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(dungeonEncounterID);
    }
}
