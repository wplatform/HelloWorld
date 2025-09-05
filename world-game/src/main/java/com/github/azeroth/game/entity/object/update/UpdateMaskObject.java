package com.github.azeroth.game.entity.object.update;



import com.github.azeroth.game.networking.WorldPacket;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public sealed abstract class UpdateMaskObject permits ActivePlayerData, BankTabSettings, BitVector, BitVectors, CompletedProject, ObjectData, PVPInfo, ResearchHistory, StableInfo, StablePetInfo, ZonePlayerForcedReaction {

    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    protected final UpdateMask changesMask;


    public UpdateMaskObject(int changeMask) {
        this.changesMask = new UpdateMask(changeMask);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public abstract void clearChangesMask();




    public final void fireMarkChanged(int blockBit, int bit) {
        if (blockBit > 0) {
            changesMask.set(blockBit);
        }
        changesMask.set(bit);
    }


    public final void fireArrayMarkChanged(Class<?> elementType, int bit, int firstElementBit, int index) {
        changesMask.set(bit);
        if(firstElementBit >= 0) {
            if(UpdateMaskObject.class.isAssignableFrom(elementType)) {
                changesMask.set(firstElementBit + index);
            } else {
                changesMask.set(firstElementBit);
            }
        }
    }

    public final void markChanged(UpdateFieldString updateField) {
        changesMask.set(updateField.blockBit);
        changesMask.set(updateField.bit);
    }




    public final <U> void markChanged(DynamicUpdateField<U> updateField, int index) {
        if (updateField.blockBit > 0) {
            getChangesMask().set(updateField.blockBit);
        }
        getChangesMask().set(updateField.bit);

    }


    public final <U> void markChanged(OptionalUpdateField<U> updateField) {
        if (updateField.getBlockBit() > 0) {
            getChangesMask().set(updateField.getBlockBit());
        }
        getChangesMask().set(updateField.getBit());
    }


    public final void writeCompleteDynamicFieldUpdateMask(int size, WorldPacket data) {
        writeCompleteDynamicFieldUpdateMask(size, data, 32);
    }

    public final void writeCompleteDynamicFieldUpdateMask(int size, WorldPacket data, int bitsForSize) {
        data.writeBits(size, bitsForSize);

        if (size > 32) {
            if (data.hasUnfinishedBitPack()) {
                for (var block = 0; block < size / 32; ++block) {
                    data.writeBits(0xFFFFFFFF, 32);
                }
            } else {
                for (var block = 0; block < size / 32; ++block) {
                    data.writeInt32(0xFFFFFFFF);
                }
            }
        } else if (size == 32) {
            data.writeBits(0xFFFFFFFF, 32);

            return;
        }

        if ((size % 32) != 0) {
            data.writeBits(0xFFFFFFFF, size % 32);
        }
    }
}
