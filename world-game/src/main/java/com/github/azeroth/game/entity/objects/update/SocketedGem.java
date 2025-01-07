package com.github.azeroth.game.entity;

import com.github.azeroth.game.entity.item.Item;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.networking.WorldPacket;

public class SocketedGem extends BaseUpdateData<item> {

    public UpdateField<Integer> itemId = new UpdateField<Integer>(0, 1);

    public UpdateField<Byte> context = new UpdateField<Byte>(0, 2);

    public UpdateFieldArray<SHORT> bonusListIDs = new UpdateFieldArray<SHORT>(16, 3, 4);

    public SocketedGem() {
        super(20);
    }

    public final void writeCreate(WorldPacket data, Item owner, Player receiver) {
        data.writeInt32(itemId);

        for (var i = 0; i < 16; ++i) {
            data.writeInt16(bonusListIDs.get(i));
        }

        data.writeInt8(context);
    }

    public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Item owner, Player receiver) {
        var changesMask = getChangesMask();

        if (ignoreChangesMask) {
            changesMask.setAll();
        }

        data.writeBits(changesMask.getBlocksMask(0), 1);

        if (changesMask.getBlock(0) != 0) {
            data.writeBits(changesMask.getBlock(0), 32);
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(1)) {
                data.writeInt32(itemId);
            }

            if (changesMask.get(2)) {
                data.writeInt8(context);
            }
        }

        if (changesMask.get(3)) {
            for (var i = 0; i < 16; ++i) {
                if (changesMask.get(4 + i)) {
                    data.writeInt16(bonusListIDs.get(i));
                }
            }
        }
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(itemId);
        clearChangesMask(context);
        clearChangesMask(bonusListIDs);
        getChangesMask().resetAll();
    }
}
