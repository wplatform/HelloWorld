package com.github.mmo.game.networking.packet.social;

import com.github.mmo.game.networking.*;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
public final class QualifiedGUID {
    public ObjectGuid guid = ObjectGuid.EMPTY;

    public int virtualRealmAddress;

    public void read(WorldPacket data) {
        virtualRealmAddress = data.readUInt();
        guid = data.readPackedGuid();
    }

    public QualifiedGUID clone() {
        QualifiedGUID varCopy = new qualifiedGUID();

        varCopy.guid = this.guid;
        varCopy.virtualRealmAddress = this.virtualRealmAddress;

        return varCopy;
    }
}
