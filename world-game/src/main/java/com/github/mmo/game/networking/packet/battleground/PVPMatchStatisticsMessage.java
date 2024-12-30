package com.github.mmo.game.networking.packet.battleground;


public class PVPMatchStatisticsMessage extends ServerPacket {
    public PVPMatchStatistics data;

    public PVPMatchStatisticsMessage() {
        super(ServerOpcode.PvpMatchStatistics, ConnectionType.instance);
    }

    @Override
    public void write() {
        data.write(this);
    }
}
