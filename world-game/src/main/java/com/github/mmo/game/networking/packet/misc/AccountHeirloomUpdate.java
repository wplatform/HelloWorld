package com.github.mmo.game.networking.packet.misc;


import com.github.mmo.game.entity.player.HeirloomData;
import com.github.mmo.game.networking.ServerPacket;

import java.util.HashMap;

public class AccountHeirloomUpdate extends ServerPacket {
    public boolean isFullUpdate;
    public HashMap<Integer, HeirloomData> heirlooms = new HashMap<Integer, HeirloomData>();
    public int unk;

    public AccountHeirloomUpdate() {
        super(ServerOpcode.AccountHeirloomUpdate, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeBit(isFullUpdate);
        this.flushBits();

        this.writeInt32(unk);

        // both lists have to have the same size
        this.writeInt32(heirlooms.size());
        this.writeInt32(heirlooms.size());

        for (var item : heirlooms.entrySet()) {
            this.writeInt32(item.getKey());
        }

        for (var flags : heirlooms.entrySet()) {
            this.writeInt32((int) flags.getValue().flags);
        }
    }
}
