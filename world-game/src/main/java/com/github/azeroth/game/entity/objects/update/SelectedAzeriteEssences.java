package com.github.azeroth.game.entity;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.networking.WorldPacket;

public class SelectedAzeriteEssences extends BaseUpdateData<azeriteItem> {
    public UpdateField<Boolean> enabled = new UpdateField<Boolean>(0, 1);

    public UpdateField<Integer> specializationID = new UpdateField<Integer>(0, 2);

    public UpdateFieldArray<Integer> azeriteEssenceID = new UpdateFieldArray<Integer>(4, 3, 4);

    public SelectedAzeriteEssences() {
        super(8);
    }

    public final void writeCreate(WorldPacket data, AzeriteItem owner, Player receiver) {
        for (var i = 0; i < 4; ++i) {
            data.writeInt32(azeriteEssenceID.get(i));
        }

        data.writeInt32(specializationID);
        data.writeBit(enabled);
        data.flushBits();
    }

    public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, AzeriteItem owner, Player receiver) {
        var changesMask = getChangesMask();

        if (ignoreChangesMask) {
            changesMask.setAll();
        }

        data.writeBits(changesMask.getBlocksMask(0), 1);

        if (changesMask.getBlock(0) != 0) {
            data.writeBits(changesMask.getBlock(0), 32);
        }

        if (changesMask.get(0)) {
            if (changesMask.get(1)) {
                data.writeBit(enabled);
            }
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(2)) {
                data.writeInt32(specializationID);
            }
        }

        if (changesMask.get(3)) {
            for (var i = 0; i < 4; ++i) {
                if (changesMask.get(4 + i)) {
                    data.writeInt32(azeriteEssenceID.get(i));
                }
            }
        }

        data.flushBits();
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(enabled);
        clearChangesMask(specializationID);
        clearChangesMask(azeriteEssenceID);
        getChangesMask().resetAll();
    }
}
