package com.github.mmo.game.networking.packet.instance;


import com.github.mmo.game.networking.ServerPacket;
public class InstanceEncounterDisengageUnit extends ServerPacket {
    public ObjectGuid unit = ObjectGuid.EMPTY;

    public InstanceEncounterDisengageUnit() {
        super(ServerOpcode.InstanceEncounterDisengageUnit, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(unit);
    }
}
