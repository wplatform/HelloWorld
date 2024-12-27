package com.github.mmo.game.networking.packet.inspect;

import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;public class QueryInspectAchievements extends ClientPacket {
    public ObjectGuid guid = ObjectGuid.EMPTY;

    public QueryInspectAchievements(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        guid = this.readPackedGuid();
    }
}
