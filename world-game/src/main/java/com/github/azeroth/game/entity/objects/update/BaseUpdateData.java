package com.github.azeroth.game.entity;


import com.github.azeroth.game.networking.WorldPacket;

public abstract class BaseUpdateData<T> implements IHasChangesMask {
    private UpdateMask changesMask;
    private int blockBit;
    private int bit;

    public BaseUpdateData(int blockBit, TypeId bit, int changeMask) {
        setBlockBit(blockBit);
        setBit(bit.getValue());
        setChangesMask(new UpdateMask(changeMask));
    }

    public BaseUpdateData(int changeMask) {
        setChangesMask(new UpdateMask(changeMask));
    }

    public final UpdateMask getChangesMask() {
        return changesMask;
    }

    public final void setChangesMask(UpdateMask value) {
        changesMask = value;
    }

    public final int getBlockBit() {
        return blockBit;
    }

    public final void setBlockBit(int value) {
        blockBit = value;
    }

    public final int getBit() {
        return bit;
    }

    public final void setBit(int value) {
        bit = value;
    }

    public abstract void clearChangesMask();

    public final UpdateMask getUpdateMask() {
        return getChangesMask();
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> void clearChanged(UpdateField<U> updateField) {
        getChangesMask().reset(updateField.getBit());
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> void clearChanged(UpdateFieldArray<U> updateField, int index) {
        getChangesMask().reset(updateField.getFirstElementBit() + index);
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> void clearChanged(DynamicUpdateField<U> updateField, int index) {
        getChangesMask().reset(getBit());
        updateField.clearChanged(index);
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> void clearChangesMask(UpdateField<U> updateField) {
        if (U.class.isAssignableFrom(IHasChangesMask.class)) {
            ((IHasChangesMask) updateField.getValue()).clearChangesMask();
        }
    }

    public final void clearChangesMask(UpdateFieldString updateField) {
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> void clearChangesMask(OptionalUpdateField<U> updateField) {
        if (U.class.isAssignableFrom(IHasChangesMask.class) && updateField.hasValue()) {
            ((IHasChangesMask) updateField.getValue()).clearChangesMask();
        }
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> void clearChangesMask(UpdateFieldArray<U> updateField) {
        if (U.class.isAssignableFrom(IHasChangesMask.class)) {
            for (var i = 0; i < updateField.getSize(); ++i) {
                ((IHasChangesMask) updateField.get(i)).clearChangesMask();
            }
        }
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> void clearChangesMask(DynamicUpdateField<U> updateField) {
        if (U.class.isAssignableFrom(IHasChangesMask.class)) {
            for (var i = 0; i < updateField.size(); ++i) {
                ((IHasChangesMask) updateField.get(i)).clearChangesMask();
            }

            updateField.clearChangesMask();
        }
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> UpdateField<U> modifyValue(UpdateField<U> updateField) {
        markChanged(updateField);

        return updateField;
    }

    public final UpdateFieldString modifyValue(UpdateFieldString updateField) {
        markChanged(updateField);

        return updateField;
    }

// C# TO JAVA CONVERTER TASK: 'ref return' methods are not converted by C# to Java Converter:
//	public ref U ModifyValue<U>(UpdateFieldArray<U> updateField, int index) where U : new()
//		{
//			markChanged(updateField, index);
//
//			return ref updateField.Values[index];
//		}

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> DynamicUpdateField<U> modifyValue(DynamicUpdateField<U> updateField) {
        getChangesMask().set(updateField.getBlockBit());
        getChangesMask().set(updateField.getBit());

        return updateField;
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> DynamicUpdateFieldSetter<U> modifyValue(DynamicUpdateField<U> updateField, int index) {
        if (index >= updateField.getValues().size()) {
            // fill with zeros until reaching desired slot
            updateField.getValues().Resize((int) index + 1);
            updateField.getUpdateMask().Resize((int) (updateField.getValues().size() + 31) / 32);
        }

        getChangesMask().set(updateField.getBlockBit());
        getChangesMask().set(updateField.getBit());
        updateField.markChanged(index);

        return new DynamicUpdateFieldSetter<U>(updateField, index);
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> void markChanged(UpdateField<U> updateField) {
        getChangesMask().set(updateField.getBlockBit());
        getChangesMask().set(updateField.getBit());
    }

    public final void markChanged(UpdateFieldString updateField) {
        getChangesMask().set(updateField.blockBit);
        getChangesMask().set(updateField.bit);
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <U> void markChanged(UpdateFieldArray<U> updateField, int index) {
        getChangesMask().set(updateField.getBit());
        getChangesMask().set(updateField.getFirstElementBit() + index);
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
