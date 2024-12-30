package com.github.mmo.game.entity;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.WorldPacket;

public class PlayerData extends BaseUpdateData<Player> {
    public UpdateField<Boolean> hasQuestSession = new UpdateField<Boolean>(0, 1);
    public UpdateField<Boolean> hasLevelLink = new UpdateField<Boolean>(0, 2);
    public DynamicUpdateField<ChrCustomizationChoice> customizations = new DynamicUpdateField<ChrCustomizationChoice>(0, 3);
    public DynamicUpdateField<questLog> questSessionQuestLog = new DynamicUpdateField<questLog>(0, 4);
    public DynamicUpdateField<ArenaCooldown> arenaCooldowns = new DynamicUpdateField<ArenaCooldown>(0, 5);
    public DynamicUpdateField<Integer> visualItemReplacements = new DynamicUpdateField<Integer>(0, 6);
    public UpdateField<ObjectGuid> duelArbiter = new UpdateField<ObjectGuid>(0, 7);
    public UpdateField<ObjectGuid> wowAccount = new UpdateField<ObjectGuid>(0, 8);
    public UpdateField<ObjectGuid> lootTargetGUID = new UpdateField<ObjectGuid>(0, 9);
    public UpdateField<Integer> playerFlags = new UpdateField<Integer>(0, 10);
    public UpdateField<Integer> playerFlagsEx = new UpdateField<Integer>(0, 11);
    public UpdateField<Integer> guildRankID = new UpdateField<Integer>(0, 12);
    public UpdateField<Integer> guildDeleteDate = new UpdateField<Integer>(0, 13);
    public UpdateField<Integer> guildLevel = new UpdateField<Integer>(0, 14);
    public UpdateField<Byte> partyType = new UpdateField<Byte>(0, 15);
    public UpdateField<Byte> nativeSex = new UpdateField<Byte>(0, 16);
    public UpdateField<Byte> inebriation = new UpdateField<Byte>(0, 17);
    public UpdateField<Byte> pvpTitle = new UpdateField<Byte>(0, 18);
    public UpdateField<Byte> arenaFaction = new UpdateField<Byte>(0, 19);
    public UpdateField<Integer> duelTeam = new UpdateField<Integer>(0, 20);
    public UpdateField<Integer> guildTimeStamp = new UpdateField<Integer>(0, 21);
    public UpdateField<Integer> playerTitle = new UpdateField<Integer>(0, 22);
    public UpdateField<Integer> fakeInebriation = new UpdateField<Integer>(0, 23);
    public UpdateField<Integer> virtualPlayerRealm = new UpdateField<Integer>(0, 24);
    public UpdateField<Integer> currentSpecID = new UpdateField<Integer>(0, 25);
    public UpdateField<Integer> taxiMountAnimKitID = new UpdateField<Integer>(0, 26);
    public UpdateField<Byte> currentBattlePetBreedQuality = new UpdateField<Byte>(0, 27);
    public UpdateField<Integer> honorLevel = new UpdateField<Integer>(0, 28);
    public UpdateField<Long> logoutTime = new UpdateField<Long>(0, 29);
    public UpdateField<Integer> field_B0 = new UpdateField<Integer>(0, 30);
    public UpdateField<Integer> field_B4 = new UpdateField<Integer>(0, 31);
    public UpdateField<CTROptions> ctrOptions = new UpdateField<CTROptions>(32, 33);
    public UpdateField<Integer> covenantID = new UpdateField<Integer>(32, 34);
    public UpdateField<Integer> soulbindID = new UpdateField<Integer>(32, 35);
    public UpdateField<dungeonScoreSummary> dungeonScore = new UpdateField<DungeonScoreSummary>(32, 36);
    public UpdateFieldArray<questLog> questLog = new UpdateFieldArray<questLog>(125, 37, 38);
    public UpdateFieldArray<VisibleItem> visibleItems = new UpdateFieldArray<VisibleItem>(19, 163, 164);
    public UpdateFieldArray<Float> avgItemLevel = new UpdateFieldArray<Float>(6, 183, 184);

    public playerData() {
        super(0, TypeId.PLAYER, 190);
    }

    public final void writeCreate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, Player owner, Player receiver) {
        data.writeGuid(duelArbiter);
        data.writeGuid(wowAccount);
        data.writeGuid(lootTargetGUID);
        data.writeInt32(playerFlags);
        data.writeInt32(playerFlagsEx);
        data.writeInt32(guildRankID);
        data.writeInt32(guildDeleteDate);
        data.writeInt32(guildLevel);
        data.writeInt32(customizations.size());
        data.writeInt8(partyType);
        data.writeInt8(nativeSex);
        data.writeInt8(inebriation);
        data.writeInt8(pvpTitle);
        data.writeInt8(arenaFaction);
        data.writeInt32(duelTeam);
        data.writeInt32(guildTimeStamp);

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.PartyMember)) {
            for (var i = 0; i < 125; ++i) {
                questLog.get(i).writeCreate(data, owner, receiver);
            }

            data.writeInt32(questSessionQuestLog.size());
        }

        for (var i = 0; i < 19; ++i) {
            visibleItems.get(i).writeCreate(data, owner, receiver);
        }

        data.writeInt32(playerTitle);
        data.writeInt32(fakeInebriation);
        data.writeInt32(virtualPlayerRealm);
        data.writeInt32(currentSpecID);
        data.writeInt32(taxiMountAnimKitID);

        for (var i = 0; i < 6; ++i) {
            data.writeFloat(avgItemLevel.get(i));
        }

        data.writeInt8(currentBattlePetBreedQuality);
        data.writeInt32(honorLevel);
        data.writeInt64(logoutTime);
        data.writeInt32(arenaCooldowns.size());
        data.writeInt32(field_B0);
        data.writeInt32(field_B4);
        ((CTROptions) ctrOptions).writeCreate(data, owner, receiver);
        data.writeInt32(covenantID);
        data.writeInt32(soulbindID);
        data.writeInt32(visualItemReplacements.size());

        for (var i = 0; i < customizations.size(); ++i) {
            customizations.get(i).writeCreate(data, owner, receiver);
        }

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.PartyMember)) {
            for (var i = 0; i < questSessionQuestLog.size(); ++i) {
                questSessionQuestLog.get(i).writeCreate(data, owner, receiver);
            }
        }

        for (var i = 0; i < arenaCooldowns.size(); ++i) {
            arenaCooldowns.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < visualItemReplacements.size(); ++i) {
            data.writeInt32(visualItemReplacements.get(i));
        }

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.PartyMember)) {
            data.writeBit(hasQuestSession);
        }

        data.writeBit(hasLevelLink);
        dungeonScore.getValue().write(data);
        data.flushBits();
    }

    public final void writeUpdate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, Player owner, Player receiver) {
        UpdateMask allowedMaskForTarget = new UpdateMask(188, new Object[]{0xFFFFFFED, 0x0000001F, 0x00000000, 0x00000000, 0x00000000, 0x3FFFFFF8});

        appendAllowedFieldsMaskForFlag(allowedMaskForTarget, fieldVisibilityFlags);
        writeUpdate(data, UpdateMask.opBitwiseAnd(getChangesMask(), allowedMaskForTarget), false, owner, receiver);
    }

    public final void appendAllowedFieldsMaskForFlag(UpdateMask allowedMaskForTarget, UpdateFieldFlag fieldVisibilityFlags) {
        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.PartyMember)) {
            allowedMaskForTarget.OR(new UpdateMask(188, new int[]{0x00000012, 0xFFFFFFE0, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x00000007}));
        }
    }

    public final void filterDisallowedFieldsMaskForFlag(UpdateMask changesMask, UpdateFieldFlag fieldVisibilityFlags) {
        UpdateMask allowedMaskForTarget = new UpdateMask(188, new Object[]{0xFFFFFFED, 0x0000001F, 0x00000000, 0x00000000, 0x00000000, 0x3FFFFFF8});

        appendAllowedFieldsMaskForFlag(allowedMaskForTarget, fieldVisibilityFlags);
        changesMask.AND(allowedMaskForTarget);
    }

    public final void writeUpdate(WorldPacket data, UpdateMask changesMask, boolean ignoreNestedChangesMask, Player owner, Player receiver) {
        data.writeBits(changesMask.getBlocksMask(0), 6);

        for (int i = 0; i < 6; ++i) {
            if (changesMask.getBlock(i) != 0) {
                data.writeBits(changesMask.getBlock(i), 32);
            }
        }

        var noQuestLogChangesMask = data.writeBit(isQuestLogChangesMaskSkipped());

        if (changesMask.get(0)) {
            if (changesMask.get(1)) {
                data.writeBit(hasQuestSession);
            }

            if (changesMask.get(2)) {
                data.writeBit(hasLevelLink);
            }

            if (changesMask.get(3)) {
                if (!ignoreNestedChangesMask) {
                    customizations.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(customizations.size(), data);
                }
            }

            if (changesMask.get(4)) {
                if (!ignoreNestedChangesMask) {
                    questSessionQuestLog.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(questSessionQuestLog.size(), data);
                }
            }

            if (changesMask.get(5)) {
                if (!ignoreNestedChangesMask) {
                    arenaCooldowns.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(arenaCooldowns.size(), data);
                }
            }

            if (changesMask.get(6)) {
                if (!ignoreNestedChangesMask) {
                    visualItemReplacements.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(visualItemReplacements.size(), data);
                }
            }
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(3)) {
                for (var i = 0; i < customizations.size(); ++i) {
                    if (customizations.hasChanged(i) || ignoreNestedChangesMask) {
                        customizations.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(4)) {
                for (var i = 0; i < questSessionQuestLog.size(); ++i) {
                    if (questSessionQuestLog.hasChanged(i) || ignoreNestedChangesMask) {
                        if (noQuestLogChangesMask) {
                            questSessionQuestLog.get(i).writeCreate(data, owner, receiver);
                        } else {
                            questSessionQuestLog.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                        }
                    }
                }
            }

            if (changesMask.get(5)) {
                for (var i = 0; i < arenaCooldowns.size(); ++i) {
                    if (arenaCooldowns.hasChanged(i) || ignoreNestedChangesMask) {
                        arenaCooldowns.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(6)) {
                for (var i = 0; i < visualItemReplacements.size(); ++i) {
                    if (visualItemReplacements.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(visualItemReplacements.get(i));
                    }
                }
            }

            if (changesMask.get(7)) {
                data.writeGuid(duelArbiter);
            }

            if (changesMask.get(8)) {
                data.writeGuid(wowAccount);
            }

            if (changesMask.get(9)) {
                data.writeGuid(lootTargetGUID);
            }

            if (changesMask.get(10)) {
                data.writeInt32(playerFlags);
            }

            if (changesMask.get(11)) {
                data.writeInt32(playerFlagsEx);
            }

            if (changesMask.get(12)) {
                data.writeInt32(guildRankID);
            }

            if (changesMask.get(13)) {
                data.writeInt32(guildDeleteDate);
            }

            if (changesMask.get(14)) {
                data.writeInt32(guildLevel);
            }

            if (changesMask.get(15)) {
                data.writeInt8(partyType);
            }

            if (changesMask.get(16)) {
                data.writeInt8(nativeSex);
            }

            if (changesMask.get(17)) {
                data.writeInt8(inebriation);
            }

            if (changesMask.get(18)) {
                data.writeInt8(pvpTitle);
            }

            if (changesMask.get(19)) {
                data.writeInt8(arenaFaction);
            }

            if (changesMask.get(20)) {
                data.writeInt32(duelTeam);
            }

            if (changesMask.get(21)) {
                data.writeInt32(guildTimeStamp);
            }

            if (changesMask.get(22)) {
                data.writeInt32(playerTitle);
            }

            if (changesMask.get(23)) {
                data.writeInt32(fakeInebriation);
            }

            if (changesMask.get(24)) {
                data.writeInt32(virtualPlayerRealm);
            }

            if (changesMask.get(25)) {
                data.writeInt32(currentSpecID);
            }

            if (changesMask.get(26)) {
                data.writeInt32(taxiMountAnimKitID);
            }

            if (changesMask.get(27)) {
                data.writeInt8(currentBattlePetBreedQuality);
            }

            if (changesMask.get(28)) {
                data.writeInt32(honorLevel);
            }

            if (changesMask.get(29)) {
                data.writeInt64(logoutTime);
            }

            if (changesMask.get(30)) {
                data.writeInt32(field_B0);
            }

            if (changesMask.get(31)) {
                data.writeInt32(field_B4);
            }
        }

        if (changesMask.get(32)) {
            if (changesMask.get(33)) {
                ctrOptions.getValue().writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
            }

            if (changesMask.get(34)) {
                data.writeInt32(covenantID);
            }

            if (changesMask.get(35)) {
                data.writeInt32(soulbindID);
            }

            if (changesMask.get(36)) {
                dungeonScore.getValue().write(data);
            }
        }

        if (changesMask.get(37)) {
            for (var i = 0; i < 125; ++i) {
                if (changesMask.get(38 + i)) {
                    if (noQuestLogChangesMask) {
                        questLog.get(i).writeCreate(data, owner, receiver);
                    } else {
                        questLog.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }
        }

        if (changesMask.get(163)) {
            for (var i = 0; i < 19; ++i) {
                if (changesMask.get(164 + i)) {
                    visibleItems.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                }
            }
        }

        if (changesMask.get(183)) {
            for (var i = 0; i < 6; ++i) {
                if (changesMask.get(184 + i)) {
                    data.writeFloat(avgItemLevel.get(i));
                }
            }
        }

        data.flushBits();
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(hasQuestSession);
        clearChangesMask(hasLevelLink);
        clearChangesMask(customizations);
        clearChangesMask(questSessionQuestLog);
        clearChangesMask(arenaCooldowns);
        clearChangesMask(visualItemReplacements);
        clearChangesMask(duelArbiter);
        clearChangesMask(wowAccount);
        clearChangesMask(lootTargetGUID);
        clearChangesMask(playerFlags);
        clearChangesMask(playerFlagsEx);
        clearChangesMask(guildRankID);
        clearChangesMask(guildDeleteDate);
        clearChangesMask(guildLevel);
        clearChangesMask(partyType);
        clearChangesMask(nativeSex);
        clearChangesMask(inebriation);
        clearChangesMask(pvpTitle);
        clearChangesMask(arenaFaction);
        clearChangesMask(duelTeam);
        clearChangesMask(guildTimeStamp);
        clearChangesMask(playerTitle);
        clearChangesMask(fakeInebriation);
        clearChangesMask(virtualPlayerRealm);
        clearChangesMask(currentSpecID);
        clearChangesMask(taxiMountAnimKitID);
        clearChangesMask(currentBattlePetBreedQuality);
        clearChangesMask(honorLevel);
        clearChangesMask(logoutTime);
        clearChangesMask(field_B0);
        clearChangesMask(field_B4);
        clearChangesMask(ctrOptions);
        clearChangesMask(covenantID);
        clearChangesMask(soulbindID);
        clearChangesMask(dungeonScore);
        clearChangesMask(questLog);
        clearChangesMask(visibleItems);
        clearChangesMask(avgItemLevel);
        getChangesMask().resetAll();
    }

    private boolean isQuestLogChangesMaskSkipped() {
        return false;
    } // bandwidth savings aren't worth the cpu time
}
