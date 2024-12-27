package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;public class RestInfo extends BaseUpdateData<Player> {
   
    public UpdateField<Integer> threshold = new UpdateField<Integer>(0, 1);
   
    public UpdateField<Byte> stateID = new UpdateField<Byte>(0, 2);

    public restInfo() {
        super(3);
    }

    public final void writeCreate(WorldPacket data, Player owner, Player receiver) {
        data.writeInt32(threshold);
        data.writeInt8(stateID);
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
                data.writeInt32(threshold);
            }

            if (changesMask.get(2)) {
                data.writeInt8(stateID);
            }
        }
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(threshold);
        clearChangesMask(stateID);
        getChangesMask().resetAll();
    }
}
