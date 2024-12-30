package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.WorldPacket;

public class ActivePlayerUnk901 extends BaseUpdateData<Player> {
    public UpdateField<ObjectGuid> field_0 = new UpdateField<ObjectGuid>(0, 1);
    public UpdateField<Integer> field_10 = new UpdateField<Integer>(0, 2);

    public ActivePlayerUnk901() {
        super(3);
    }

    public final void writeCreate(WorldPacket data, Player owner, Player receiver) {
        data.writeGuid(field_0);
        data.writeInt32(field_10);
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
                data.writeGuid(field_0);
            }

            if (changesMask.get(2)) {
                data.writeInt32(field_10);
            }
        }
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(field_0);
        clearChangesMask(field_10);
        getChangesMask().resetAll();
    }
}
