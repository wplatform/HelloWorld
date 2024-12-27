package com.github.mmo.game.networking.packet.party;


import com.github.mmo.game.networking.*;class SetLootMethod extends ClientPacket {
    public byte partyIndex;
    public ObjectGuid lootMasterGUID = ObjectGuid.EMPTY;
    public lootMethod lootMethod = Framework.Constants.lootMethod.values()[0];
    public ItemQuality lootThreshold = itemQuality.values()[0];

    public setLootMethod(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        partyIndex = this.readByte();
        lootMethod = lootMethod.forValue(this.readUInt8());
        lootMasterGUID = this.readPackedGuid();
        lootThreshold = itemQuality.forValue(this.readUInt());
    }
}
