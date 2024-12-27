package com.github.mmo.game.networking.packet.voidstorage;


import java.util.*;import com.github.mmo.game.networking.ServerPacket;
public class VoidStorageTransferChanges extends ServerPacket {
    public ArrayList<ObjectGuid> removedItems = new ArrayList<>();
    public ArrayList<VoidItem> addedItems = new ArrayList<>();

    public VoidStorageTransferChanges() {
        super(ServerOpcode.VoidStorageTransferChanges, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeBits(addedItems.size(), 4);
        this.writeBits(removedItems.size(), 4);
        this.flushBits();

        for (var addedItem : addedItems) {
            addedItem.write(this);
        }

        for (var removedItem : removedItems) {
            this.writeGuid(removedItem);
        }
    }
}
