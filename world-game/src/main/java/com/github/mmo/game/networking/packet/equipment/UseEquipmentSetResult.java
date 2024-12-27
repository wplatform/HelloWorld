package com.github.mmo.game.networking.packet.equipment;


import com.github.mmo.game.networking.*;class UseEquipmentSetResult extends ServerPacket {

    public long GUID; //Set Identifier

    public byte reason;

    public UseEquipmentSetResult() {
        super(ServerOpcode.UseEquipmentSetResult);
    }

    @Override
    public void write() {
        this.writeInt64(GUID);
        this.writeInt8(reason);
    }
}
