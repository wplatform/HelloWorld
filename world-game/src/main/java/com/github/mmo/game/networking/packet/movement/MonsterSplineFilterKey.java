package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.WorldPacket;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
public final class MonsterSplineFilterKey {
    public short idx;

    public short speed;

    public void write(WorldPacket data) {
        data.writeInt16(idx);
        data.writeInt16(speed);
    }

    public MonsterSplineFilterKey clone() {
        MonsterSplineFilterKey varCopy = new MonsterSplineFilterKey();

        varCopy.idx = this.idx;
        varCopy.speed = this.speed;

        return varCopy;
    }
}
