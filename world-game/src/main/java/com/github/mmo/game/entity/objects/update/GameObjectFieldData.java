package com.github.mmo.game.entity;


import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.WorldPacket;

import java.util.ArrayList;


public class GameObjectFieldData extends BaseUpdateData<GameObject> {
    public UpdateField<ArrayList<Integer>> stateWorldEffectIDs = new UpdateField<ArrayList<Integer>>(0, 1);
    public DynamicUpdateField<Integer> enableDoodadSets = new DynamicUpdateField<Integer>(0, 2);
    public DynamicUpdateField<Integer> worldEffects = new DynamicUpdateField<Integer>(0, 3);
    public UpdateField<Integer> displayID = new UpdateField<Integer>(0, 4);
    public UpdateField<Integer> spellVisualID = new UpdateField<Integer>(0, 5);
    public UpdateField<Integer> stateSpellVisualID = new UpdateField<Integer>(0, 6);
    public UpdateField<Integer> spawnTrackingStateAnimID = new UpdateField<Integer>(0, 7);
    public UpdateField<Integer> spawnTrackingStateAnimKitID = new UpdateField<Integer>(0, 8);
    public UpdateField<Integer> stateWorldEffectsQuestObjectiveID = new UpdateField<Integer>(0, 9);
    public UpdateField<ObjectGuid> createdBy = new UpdateField<ObjectGuid>(0, 10);
    public UpdateField<ObjectGuid> guildGUID = new UpdateField<ObjectGuid>(0, 11);
    public UpdateField<Integer> flags = new UpdateField<Integer>(0, 12);
    public UpdateField<Quaternion> parentRotation = new UpdateField<Quaternion>(0, 13);
    public UpdateField<Integer> factionTemplate = new UpdateField<Integer>(0, 14);
    public UpdateField<Byte> state = new UpdateField<Byte>(0, 15);
    public UpdateField<Byte> typeID = new UpdateField<Byte>(0, 16);
    public UpdateField<Byte> percentHealth = new UpdateField<Byte>(0, 17);
    public UpdateField<Integer> artKit = new UpdateField<Integer>(0, 18);
    public UpdateField<Integer> customParam = new UpdateField<Integer>(0, 19);
    public UpdateField<Integer> level = new UpdateField<Integer>(0, 20);
    public UpdateField<Integer> animGroupInstance = new UpdateField<Integer>(0, 21);
    public UpdateField<Integer> uiWidgetItemID = new UpdateField<Integer>(0, 22);
    public UpdateField<Integer> uiWidgetItemQuality = new UpdateField<Integer>(0, 23);
    public UpdateField<Integer> uiWidgetItemUnknown1000 = new UpdateField<Integer>(0, 24);

    public gameObjectFieldData() {
        super(0, TypeId.gameObject, 25);
    }

    public final void writeCreate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, GameObject owner, Player receiver) {
        data.writeInt32(displayID);
        data.writeInt32(spellVisualID);
        data.writeInt32(stateSpellVisualID);
        data.writeInt32(spawnTrackingStateAnimID);
        data.writeInt32(spawnTrackingStateAnimKitID);
        data.writeInt32(((ArrayList<Integer>) stateWorldEffectIDs).size());
        data.writeInt32(stateWorldEffectsQuestObjectiveID);

        for (var i = 0; i < ((ArrayList<Integer>) stateWorldEffectIDs).size(); ++i) {
            data.writeInt32(((ArrayList<Integer>) stateWorldEffectIDs).get(i));
        }

        data.writeGuid(createdBy);
        data.writeGuid(guildGUID);
        data.writeInt32(getViewerGameObjectFlags(this, owner, receiver));
        Quaternion rotation = parentRotation;
        data.writeFloat(rotation.X);
        data.writeFloat(rotation.Y);
        data.writeFloat(rotation.Z);
        data.writeFloat(rotation.W);
        data.writeInt32(factionTemplate);
        data.writeInt8(getViewerGOState(this, owner, receiver));
        data.writeInt8(typeID);
        data.writeInt8(percentHealth);
        data.writeInt32(artKit);
        data.writeInt32(enableDoodadSets.size());
        data.writeInt32(customParam);
        data.writeInt32(level);
        data.writeInt32(animGroupInstance);
        data.writeInt32(uiWidgetItemID);
        data.writeInt32(uiWidgetItemQuality);
        data.writeInt32(uiWidgetItemUnknown1000);
        data.writeInt32(worldEffects.size());

        for (var i = 0; i < enableDoodadSets.size(); ++i) {
            data.writeInt32(enableDoodadSets.get(i));
        }

        for (var i = 0; i < worldEffects.size(); ++i) {
            data.writeInt32(worldEffects.get(i));
        }
    }

    public final void writeUpdate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, GameObject owner, Player receiver) {
        writeUpdate(data, getChangesMask(), false, owner, receiver);
    }

    public final void writeUpdate(WorldPacket data, UpdateMask changesMask, boolean ignoreNestedChangesMask, GameObject owner, Player receiver) {
        data.writeBits(changesMask.getBlock(0), 25);

        if (changesMask.get(0)) {
            if (changesMask.get(1)) {
                data.writeBits(((ArrayList<Integer>) stateWorldEffectIDs).size(), 32);

                for (var i = 0; i < ((ArrayList<Integer>) stateWorldEffectIDs).size(); ++i) {
                    data.writeInt32(((ArrayList<Integer>) stateWorldEffectIDs).get(i));
                }
            }
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(2)) {
                if (!ignoreNestedChangesMask) {
                    enableDoodadSets.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(enableDoodadSets.size(), data);
                }
            }

            if (changesMask.get(3)) {
                if (!ignoreNestedChangesMask) {
                    worldEffects.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(worldEffects.size(), data);
                }
            }
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(2)) {
                for (var i = 0; i < enableDoodadSets.size(); ++i) {
                    if (enableDoodadSets.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(enableDoodadSets.get(i));
                    }
                }
            }

            if (changesMask.get(3)) {
                for (var i = 0; i < worldEffects.size(); ++i) {
                    if (worldEffects.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(worldEffects.get(i));
                    }
                }
            }

            if (changesMask.get(4)) {
                data.writeInt32(displayID);
            }

            if (changesMask.get(5)) {
                data.writeInt32(spellVisualID);
            }

            if (changesMask.get(6)) {
                data.writeInt32(stateSpellVisualID);
            }

            if (changesMask.get(7)) {
                data.writeInt32(spawnTrackingStateAnimID);
            }

            if (changesMask.get(8)) {
                data.writeInt32(spawnTrackingStateAnimKitID);
            }

            if (changesMask.get(9)) {
                data.writeInt32(stateWorldEffectsQuestObjectiveID);
            }

            if (changesMask.get(10)) {
                data.writeGuid(createdBy);
            }

            if (changesMask.get(11)) {
                data.writeGuid(guildGUID);
            }

            if (changesMask.get(12)) {
                data.writeInt32(getViewerGameObjectFlags(this, owner, receiver));
            }

            if (changesMask.get(13)) {
                data.writeFloat(((Quaternion) parentRotation).X);
                data.writeFloat(((Quaternion) parentRotation).Y);
                data.writeFloat(((Quaternion) parentRotation).Z);
                data.writeFloat(((Quaternion) parentRotation).W);
            }

            if (changesMask.get(14)) {
                data.writeInt32(factionTemplate);
            }

            if (changesMask.get(15)) {
                data.writeInt8(getViewerGOState(this, owner, receiver));
            }

            if (changesMask.get(16)) {
                data.writeInt8(typeID);
            }

            if (changesMask.get(17)) {
                data.writeInt8(percentHealth);
            }

            if (changesMask.get(18)) {
                data.writeInt32(artKit);
            }

            if (changesMask.get(19)) {
                data.writeInt32(customParam);
            }

            if (changesMask.get(20)) {
                data.writeInt32(level);
            }

            if (changesMask.get(21)) {
                data.writeInt32(animGroupInstance);
            }

            if (changesMask.get(22)) {
                data.writeInt32(uiWidgetItemID);
            }

            if (changesMask.get(23)) {
                data.writeInt32(uiWidgetItemQuality);
            }

            if (changesMask.get(24)) {
                data.writeInt32(uiWidgetItemUnknown1000);
            }
        }
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(stateWorldEffectIDs);
        clearChangesMask(enableDoodadSets);
        clearChangesMask(worldEffects);
        clearChangesMask(displayID);
        clearChangesMask(spellVisualID);
        clearChangesMask(stateSpellVisualID);
        clearChangesMask(spawnTrackingStateAnimID);
        clearChangesMask(spawnTrackingStateAnimKitID);
        clearChangesMask(stateWorldEffectsQuestObjectiveID);
        clearChangesMask(createdBy);
        clearChangesMask(guildGUID);
        clearChangesMask(flags);
        clearChangesMask(parentRotation);
        clearChangesMask(factionTemplate);
        clearChangesMask(state);
        clearChangesMask(typeID);
        clearChangesMask(percentHealth);
        clearChangesMask(artKit);
        clearChangesMask(customParam);
        clearChangesMask(level);
        clearChangesMask(animGroupInstance);
        clearChangesMask(uiWidgetItemID);
        clearChangesMask(uiWidgetItemQuality);
        clearChangesMask(uiWidgetItemUnknown1000);
        getChangesMask().resetAll();
    }

    private int getViewerGameObjectFlags(GameObjectFieldData gameObjectData, GameObject gameObject, Player receiver) {
        int flags = gameObjectData.flags;

        if (gameObject.getGoType() == GameObjectTypes.chest) {
            if (gameObject.getTemplate().chest.usegrouplootrules != 0 && !gameObject.isLootAllowedFor(receiver)) {
                flags |= (int) (GameObjectFlags.locked.getValue() | GameObjectFlags.NotSelectable.getValue());
            }
        }

        return flags;
    }

    private byte getViewerGOState(GameObjectFieldData gameObjectData, GameObject gameObject, Player receiver) {
        return (byte) gameObject.getGoStateFor(receiver.getGUID()).getValue();
    }
}
