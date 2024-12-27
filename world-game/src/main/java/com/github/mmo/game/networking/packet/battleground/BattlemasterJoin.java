package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.*;class BattlemasterJoin extends ClientPacket {

    public Array<Long> queueIDs = new Array<Long>(1);

    public byte roles;
    public int[] blacklistMap = new int[2];

    public BattlemasterJoin(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var queueCount = this.readUInt();
        roles = this.readUInt8();
        BlacklistMap[0] = this.readInt32();
        BlacklistMap[1] = this.readInt32();

        for (var i = 0; i < queueCount; ++i) {
            queueIDs.set(i, this.readUInt64());
        }
    }
}
