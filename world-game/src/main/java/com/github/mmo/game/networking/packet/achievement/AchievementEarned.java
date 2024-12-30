package com.github.mmo.game.networking.packet.achievement;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ServerPacket;

public class AchievementEarned extends ServerPacket {
    public ObjectGuid earner = ObjectGuid.EMPTY;
    public int earnerNativeRealm;
    public int earnerVirtualRealm;
    public int achievementID;
    public long time;
    public boolean initial;
    public ObjectGuid sender = ObjectGuid.EMPTY;

    public AchievementEarned() {
        super(ServerOpcode.AchievementEarned, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(sender);
        this.writeGuid(earner);
        this.writeInt32(achievementID);
        this.writePackedTime(time);
        this.writeInt32(earnerNativeRealm);
        this.writeInt32(earnerVirtualRealm);
        this.writeBit(initial);
        this.flushBits();
    }
}
