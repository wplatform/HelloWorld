package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.*;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
public final class NameCacheLookupResult {
    public ObjectGuid player = ObjectGuid.EMPTY;

    public byte result; // 0 - full packet, != 0 - only guid
    public PlayerGuidLookupdata data;
    public NameCacheunused920 unused920;

    public void write(WorldPacket data) {
        data.writeInt8(result);
        data.writeGuid(player);
        data.writeBit(data != null);
        data.writeBit(unused920 != null);
        data.flushBits();

        if (data != null) {
            data.write(data);
        }

        if (unused920 != null) {
            unused920.write(data);
        }
    }

    public NameCacheLookupResult clone() {
        NameCacheLookupResult varCopy = new NameCacheLookupResult();

        varCopy.player = this.player;
        varCopy.result = this.result;
        varCopy.data = this.data;
        varCopy.unused920 = this.unused920;

        return varCopy;
    }
}