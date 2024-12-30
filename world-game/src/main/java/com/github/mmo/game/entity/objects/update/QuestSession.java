package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.WorldPacket;

public class QuestSession extends BaseUpdateData<Player> {
    public UpdateField<ObjectGuid> owner = new UpdateField<ObjectGuid>(0, 1);
    public UpdateFieldArray<Long> questCompleted = new UpdateFieldArray<Long>(875, 2, 3);

    public questSession() {
        super(878);
    }

    public final void writeCreate(WorldPacket data, Player owner, Player receiver) {
        data.writeGuid(owner);

        for (var i = 0; i < 875; ++i) {
            data.writeInt64(questCompleted.get(i));
        }
    }

    public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Player owner, Player receiver) {
        var changesMask = getChangesMask();

        if (ignoreChangesMask) {
            changesMask.setAll();
        }

        data.writeBits(changesMask.getBlocksMask(0), 28);

        for (int i = 0; i < 28; ++i) {
            if (changesMask.getBlock(i) != 0) {
                data.writeBits(changesMask.getBlock(i), 32);
            }
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(1)) {
                data.writeGuid(owner);
            }
        }

        if (changesMask.get(2)) {
            for (var i = 0; i < 875; ++i) {
                if (changesMask.get(3 + i)) {
                    data.writeInt64(questCompleted.get(i));
                }
            }
        }
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(owner);
        clearChangesMask(questCompleted);
        getChangesMask().resetAll();
    }
}
