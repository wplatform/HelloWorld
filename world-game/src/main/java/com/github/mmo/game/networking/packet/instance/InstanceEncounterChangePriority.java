package com.github.mmo.game.networking.packet.instance;

import com.github.mmo.game.networking.ServerPacket;

public class InstanceEncounterChangePriority extends ServerPacket {
    public ObjectGuid unit = ObjectGuid.EMPTY;
    public byte targetFramePriority; // used to update the position of the unit's current frame

    public InstanceEncounterChangePriority() {
        super(ServerOpcode.InstanceEncounterChangePriority, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(unit);
        this.writeInt8(targetFramePriority);
    }
}
