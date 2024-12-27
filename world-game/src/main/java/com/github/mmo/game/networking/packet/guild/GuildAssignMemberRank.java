package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;public class GuildAssignMemberRank extends ClientPacket {
    public ObjectGuid member = ObjectGuid.EMPTY;
    public int rankOrder;

    public GuildAssignMemberRank(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        member = this.readPackedGuid();
        rankOrder = this.readInt32();
    }
}
