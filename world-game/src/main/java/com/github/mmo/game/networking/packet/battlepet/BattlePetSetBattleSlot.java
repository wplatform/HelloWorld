package com.github.mmo.game.networking.packet.battlepet;

import com.github.mmo.game.networking.*;class BattlePetSetBattleSlot extends ClientPacket {
    public ObjectGuid petGuid = ObjectGuid.EMPTY;

    public byte slot;

    public BattlePetSetBattleSlot(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        petGuid = this.readPackedGuid();
        slot = this.readUInt8();
    }
}
