package com.github.mmo.game.networking.packet.equipment;


public class EquipmentSetID extends ServerPacket {
    public long GUID; // Set Identifier
    public int type;
    public int setID; // Index

    public EquipmentSetID() {
        super(ServerOpcode.EquipmentSetId, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt64(GUID);
        this.writeInt32(type);
        this.writeInt32(setID);
    }
}
