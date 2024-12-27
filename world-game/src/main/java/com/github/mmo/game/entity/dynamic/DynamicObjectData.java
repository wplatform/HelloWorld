package com.github.mmo.game.entity.dynamic;


import com.github.mmo.game.entity.BaseUpdateData;
import com.github.mmo.game.entity.SpellCastVisualField;
import com.github.mmo.game.entity.UpdateField;
import com.github.mmo.game.entity.UpdateMask;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;public class DynamicObjectData extends BaseUpdateData<DynamicObject> {
    public UpdateField<ObjectGuid> caster = new UpdateField<ObjectGuid>(0, 1);
   
    public UpdateField<Byte> type = new UpdateField<Byte>(0, 2);
    public UpdateField<SpellCastVisualField> spellVisual = new UpdateField<SpellCastVisualField>(0, 3);
   
    public UpdateField<Integer> spellID = new UpdateField<Integer>(0, 4);
    public UpdateField<Float> radius = new UpdateField<Float>(0, 5);
   
    public UpdateField<Integer> castTime = new UpdateField<Integer>(0, 6);

    public dynamicObjectData() {
        super(0, TypeId.DynamicObject, 7);
    }

    public final void writeCreate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, DynamicObject owner, Player receiver) {
        data.writeGuid(caster);
        data.writeInt8(type);
        ((SpellCastVisualField) spellVisual).writeCreate(data, owner, receiver);
        data.writeInt32(spellID);
        data.writeFloat(radius);
        data.writeInt32(castTime);
    }

    public final void writeUpdate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, DynamicObject owner, Player receiver) {
        writeUpdate(data, getChangesMask(), false, owner, receiver);
    }

    public final void writeUpdate(WorldPacket data, UpdateMask changesMask, boolean ignoreNestedChangesMask, DynamicObject owner, Player receiver) {
        data.writeBits(getChangesMask().getBlock(0), 7);

        data.flushBits();

        if (getChangesMask().get(0)) {
            if (getChangesMask().get(1)) {
                data.writeGuid(caster);
            }

            if (getChangesMask().get(2)) {
                data.writeInt8(type);
            }

            if (getChangesMask().get(3)) {
                ((SpellCastVisualField) spellVisual).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
            }

            if (getChangesMask().get(4)) {
                data.writeInt32(spellID);
            }

            if (getChangesMask().get(5)) {
                data.writeFloat(radius);
            }

            if (getChangesMask().get(6)) {
                data.writeInt32(castTime);
            }
        }
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(caster);
        clearChangesMask(type);
        clearChangesMask(spellVisual);
        clearChangesMask(spellID);
        clearChangesMask(radius);
        clearChangesMask(castTime);
        getChangesMask().resetAll();
    }
}
