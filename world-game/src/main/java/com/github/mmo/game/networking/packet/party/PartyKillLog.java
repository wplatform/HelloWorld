package com.github.mmo.game.networking.packet.party;


import com.github.mmo.game.networking.ServerPacket;
public class PartyKillLog extends ServerPacket {
    public ObjectGuid player = ObjectGuid.EMPTY;
    public ObjectGuid victim = ObjectGuid.EMPTY;

    public PartyKillLog() {
        super(ServerOpcode.PartyKillLog);
    }

    @Override
    public void write() {
        this.writeGuid(player);
        this.writeGuid(victim);
    }
}
