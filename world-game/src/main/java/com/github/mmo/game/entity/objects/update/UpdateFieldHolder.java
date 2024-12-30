package com.github.mmo.game.entity;


import com.github.mmo.game.entity.object.WorldObject;

public class UpdateFieldHolder {
    private final updateMask changesMask = new UpdateMask(TypeId.max.getValue());

    public UpdateFieldHolder(WorldObject owner) {
    }

    public final <T> BaseUpdateData<T> modifyValue(BaseUpdateData<T> updateData) {
        changesMask.set(updateData.getBit());

        return updateData;
    }

    public final <T> void clearChangesMask(BaseUpdateData<T> updateData) {
        changesMask.reset(updateData.getBit());
        updateData.clearChangesMask();
    }

    // C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
    public final <T, U> void clearChangesMask(BaseUpdateData<T> updateData, tangible.RefObject<UpdateField<U>> updateField) {
        changesMask.reset(updateData.getBit());

        var hasChangesMask = (IHasChangesMask) updateField.refArgValue.getValue();

        if (hasChangesMask != null) {
            hasChangesMask.clearChangesMask();
        }
    }

    public final int getChangedObjectTypeMask() {
        return changesMask.getBlock(0);
    }

    public final boolean hasChanged(TypeId index) {
        return changesMask.get(index.getValue());
    }
}
