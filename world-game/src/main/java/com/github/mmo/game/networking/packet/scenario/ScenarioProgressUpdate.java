package com.github.mmo.game.networking.packet.scenario;


import com.github.mmo.game.networking.ServerPacket;

public class ScenarioProgressUpdate extends ServerPacket {
    public criteriaProgressPkt criteriaProgress = new criteriaProgressPkt();

    public ScenarioProgressUpdate() {
        super(ServerOpcode.ScenarioProgressUpdate, ConnectionType.instance);
    }

    @Override
    public void write() {
        criteriaProgress.write(this);
    }
}
