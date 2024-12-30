package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.WorldPacket;

public class ReplayedQuest extends BaseUpdateData<Player> {
    public UpdateField<Integer> questID = new UpdateField<Integer>(0, 1);
    public UpdateField<Integer> replayTime = new UpdateField<Integer>(0, 2);

    public ReplayedQuest() {
        super(3);
    }

    public final void writeCreate(WorldPacket data, Player owner, Player receiver) {
        data.writeInt32(questID);
        data.writeInt32(replayTime);
    }

    public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Player owner, Player receiver) {
        var changesMask = getChangesMask();

        if (ignoreChangesMask) {
            changesMask.setAll();
        }

        data.writeBits(changesMask.getBlock(0), 3);

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(1)) {
                data.writeInt32(questID);
            }

            if (changesMask.get(2)) {
                data.writeInt32(replayTime);
            }
        }
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(questID);
        clearChangesMask(replayTime);
        getChangesMask().resetAll();
    }
}
