package com.github.azeroth.game.entity.object.update;


import com.github.azeroth.game.networking.WorldPacket;

import java.util.AbstractList;
import java.util.ArrayList;


public class DynamicUpdateField<T> extends AbstractList<T> {


    private final ArrayList<T> values = new ArrayList<>();
    private final ArrayList<Integer> updateMask = new ArrayList<>();
    private final int blockBit;
    private final int bit;
    private final UpdateMaskObject owner;

    public DynamicUpdateField(int blockBit, int bit, UpdateMaskObject owner) {
        this.blockBit = blockBit;
        this.bit = bit;
        this.owner = owner;
    }

    @Override
    public T set(int index, T element) {
        T v = values.set(index, element);
        // mark all fields of old value as changed
        for (var i = index; i < values.size(); ++i) {
            markChanged(i);
            // also mark all fields of value as changed
            markAllUpdateMaskFields(values.get(i));
        }
        return v;
    }

    @Override
    public void add(int index, T element) {
        values.add(index, element);
        markChanged(index);
        markAllUpdateMaskFields(element);
    }

    @Override
    public T remove(int index) {

        // remove by shifting entire container - client might rely on values being sorted for certain fields
        values.remove(index);

        for (var i = index; i < values.size(); ++i) {
            markChanged(i);
            // also mark all fields of value as changed
            markAllUpdateMaskFields(values.get(i));
        }

        if ((values.size() % 32) != 0) {
            updateMask.set(owner.changesMask.getBlockIndex(values.size()), updateMask.get(owner.changesMask.getBlockIndex(values.size())) & (int)~owner.changesMask.getBlockFlag(values.size()));
        } else {
            updateMask.remove(updateMask.size() - 1);
        }

        return values.remove(index);
    }

    @Override
    public T get(int index) {
        return values.get(index);
    }

    @Override
    public int size() {
        return values.size();
    }



    public final boolean hasChanged(int index) {
        return (updateMask.get(index / 32) & (1 << (index % 32))) != 0;
    }


    public final void writeUpdateMask(WorldPacket data) {
        writeUpdateMask(data, 32);
    }

    public final void writeUpdateMask(WorldPacket data, int bitsForSize) {
        data.writeBits(values.size(), bitsForSize);

        if (values.size() > 32) {
            if (data.hasUnfinishedBitPack()) {
                for (var block = 0; block < values.size() / 32; ++block) {
                    data.writeBits(updateMask.get(block), 32);
                }
            } else {
                for (var block = 0; block < values.size() / 32; ++block) {
                    data.writeInt32(updateMask.get(block));
                }
            }
        }

        else if (values.size() == 32) {
            data.writeBits(updateMask.get(updateMask.size() - 1), 32);

            return;
        }

        if ((values.size() % 32) != 0) {
            data.writeBits(updateMask.get(updateMask.size() - 1), values.size() % 32);
        }
    }
    public final void clearChangesMask() {
        for (var i = 0; i < updateMask.size(); ++i) {
            updateMask.set(i, 0);
        }
    }




    public final void clear() {
        values.clear();
        updateMask.clear();
    }

    private void markChanged(int index) {
        var block = owner.changesMask.getBlockIndex(index);

        if (block >= updateMask.size()) {
            updateMask.add(0);
        }

        updateMask.set(block, updateMask.get(block) | UpdateMask.getBlockFlag(index));
    }

    private void clearChanged(int index) {
        var block = UpdateMask.getBlockIndex(index);

        if (block >= updateMask.size()) {
            updateMask.add(0);
        }
        updateMask.set(block, updateMask.get(block) & ~(int)UpdateMask.getBlockFlag(index));
    }


    private void markAllUpdateMaskFields(T value) {
        if (value instanceof UpdateMaskObject maskObject) {
            maskObject.changesMask.setAll();
        }
    }
}