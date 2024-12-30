package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.WorldPacket;

public class TraitConfig extends BaseUpdateData<Player> {
    public DynamicUpdateField<TraitEntry> entries = new DynamicUpdateField<TraitEntry>(0, 1);
    public UpdateField<Integer> ID = new UpdateField<Integer>(0, 2);
    public updateFieldString name = new updateFieldString(0, 3);
    public UpdateField<Integer> type = new UpdateField<Integer>(4, 5);
    public UpdateField<Integer> skillLineID = new UpdateField<Integer>(4, 6);
    public UpdateField<Integer> chrSpecializationID = new UpdateField<Integer>(4, 7);
    public UpdateField<Integer> combatConfigFlags = new UpdateField<Integer>(8, 9);
    public UpdateField<Integer> localIdentifier = new UpdateField<Integer>(8, 10);
    public UpdateField<Integer> traitSystemID = new UpdateField<Integer>(8, 11);

    public TraitConfig() {
        super(12);
    }

    public final void writeCreate(WorldPacket data, Player owner, Player receiver) {
        data.writeInt32(ID);
        data.writeInt32(type);
        data.writeInt32(entries.size());

        if (type == 2) {
            data.writeInt32(skillLineID);
        }

        if (type == 1) {
            data.writeInt32(chrSpecializationID);
            data.writeInt32(combatConfigFlags);
            data.writeInt32(localIdentifier);
        }

        if (type == 3) {
            data.writeInt32(traitSystemID);
        }

        for (var i = 0; i < entries.size(); ++i) {
            entries.get(i).writeCreate(data, owner, receiver);
        }

        data.writeBits(name.getValue().getBytes().length, 9);
        data.writeString(name);
        data.flushBits();
    }

    public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Player owner, Player receiver) {
        var changesMask = getChangesMask();

        if (ignoreChangesMask) {
            changesMask.setAll();
        }

        data.writeBits(changesMask.getBlock(0), 12);

        if (changesMask.get(0)) {
            if (changesMask.get(1)) {
                if (!ignoreChangesMask) {
                    entries.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(entries.size(), data);
                }
            }
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(1)) {
                for (var i = 0; i < entries.size(); ++i) {
                    if (entries.hasChanged(i) || ignoreChangesMask) {
                        entries.get(i).writeUpdate(data, ignoreChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(2)) {
                data.writeInt32(ID);
            }
        }

        if (changesMask.get(4)) {
            if (changesMask.get(5)) {
                data.writeInt32(type);
            }

            if (changesMask.get(6)) {
                if (type == 2) {
                    data.writeInt32(skillLineID);
                }
            }

            if (changesMask.get(7)) {
                if (type == 1) {
                    data.writeInt32(chrSpecializationID);
                }
            }
        }

        if (changesMask.get(8)) {
            if (changesMask.get(9)) {
                if (type == 1) {
                    data.writeInt32(combatConfigFlags);
                }
            }

            if (changesMask.get(10)) {
                if (type == 1) {
                    data.writeInt32(localIdentifier);
                }
            }

            if (changesMask.get(11)) {
                if (type == 3) {
                    data.writeInt32(traitSystemID);
                }
            }
        }

        if (changesMask.get(0)) {
            if (changesMask.get(3)) {
                data.writeBits(name.getValue().getBytes().length, 9);
                data.writeString(name);
            }
        }

        data.flushBits();
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(entries);
        clearChangesMask(ID);
        clearChangesMask(name);
        clearChangesMask(type);
        clearChangesMask(skillLineID);
        clearChangesMask(chrSpecializationID);
        clearChangesMask(combatConfigFlags);
        clearChangesMask(localIdentifier);
        clearChangesMask(traitSystemID);
        getChangesMask().resetAll();
    }
}
