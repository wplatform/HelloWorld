package com.github.mmo.game.networking.packet.clientconfig;


import com.github.mmo.game.networking.*;public class RequestAccountData extends ClientPacket {
    public ObjectGuid playerGuid = ObjectGuid.EMPTY;
    public AccountdataTypes dataType = AccountDataTypes.forValue(0);

    public RequestAccountData(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        playerGuid = this.readPackedGuid();
        dataType = AccountDataTypes.forValue(this.<Integer>readBit(4));
    }
}
