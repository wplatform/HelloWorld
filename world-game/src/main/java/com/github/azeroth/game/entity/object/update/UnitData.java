package com.github.azeroth.game.entity.object.update;


import com.github.azeroth.game.domain.object.ObjectGuid;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.networking.WorldPacket;

import java.util.ArrayList;


public class UnitData extends UpdateMaskObject {
    public UpdateField<ArrayList<Integer>> stateWorldEffectIDs = new UpdateField<ArrayList<Integer>>(0, 1);
    public DynamicUpdateField<PassiveSpellHistory> passiveSpells = new DynamicUpdateField<PassiveSpellHistory>(0, 2);
    public DynamicUpdateField<Integer> worldEffects = new DynamicUpdateField<Integer>(0, 3);
    public DynamicUpdateField<ObjectGuid> channelObjects = new DynamicUpdateField<ObjectGuid>(0, 4);
    public UpdateField<Integer> displayID = new UpdateField<>(0, 5);
    public UpdateField<Integer> stateSpellVisualID = new UpdateField<>(0, 6);
    public UpdateField<Integer> stateAnimID = new UpdateField<>(0, 7);
    public UpdateField<Integer> stateAnimKitID = new UpdateField<>(0, 8);
    public UpdateField<Integer> stateWorldEffectsQuestObjectiveID = new UpdateField<>(0, 9);
    public UpdateField<Integer> spellOverrideNameID = new UpdateField<>(0, 10);
    public UpdateField<ObjectGuid> charm = new UpdateField<>(0, 11);
    public UpdateField<ObjectGuid> summon = new UpdateField<>(0, 12);
    public UpdateField<ObjectGuid> critter = new UpdateField<>(0, 13);
    public UpdateField<ObjectGuid> charmedBy = new UpdateField<>(0, 14);
    public UpdateField<ObjectGuid> summonedBy = new UpdateField<>(0, 15);
    public UpdateField<ObjectGuid> createdBy = new UpdateField<>(0, 16);
    public UpdateField<ObjectGuid> demonCreator = new UpdateField<>(0, 17);
    public UpdateField<ObjectGuid> lookAtControllerTarget = new UpdateField<>(0, 18);
    public UpdateField<ObjectGuid> target = new UpdateField<>(0, 19);
    public UpdateField<ObjectGuid> battlePetCompanionGUID = new UpdateField<>(0, 20);
    public UpdateField<Long> battlePetDBID = new UpdateField<>(0, 21);
    public UpdateField<UnitChannel> channelData = new UpdateField<>(0, 22);
    public UpdateField<Byte> spellEmpowerStage = new UpdateField<>(0, 23);
    public UpdateField<Integer> summonedByHomeRealm = new UpdateField<>(0, 24);
    public UpdateField<Byte> race = new UpdateField<>(0, 25);
    public UpdateField<Byte> classId = new UpdateField<>(0, 26);
    public UpdateField<Byte> playerClassId = new UpdateField<>(0, 27);
    public UpdateField<Byte> sex = new UpdateField<>(0, 28);
    public UpdateField<Byte> displayPower = new UpdateField<>(0, 29);
    public UpdateField<Integer> overrideDisplayPowerID = new UpdateField<>(0, 30);
    public UpdateField<Long> health = new UpdateField<>(0, 31);
    public UpdateField<Long> maxHealth = new UpdateField<>(32, 33);
    public UpdateField<Integer> level = new UpdateField<>(32, 34);
    public UpdateField<Integer> effectiveLevel = new UpdateField<>(32, 35);
    public UpdateField<Integer> contentTuningID = new UpdateField<>(32, 36);
    public UpdateField<Integer> scalingLevelMin = new UpdateField<>(32, 37);
    public UpdateField<Integer> scalingLevelMax = new UpdateField<>(32, 38);
    public UpdateField<Integer> scalingLevelDelta = new UpdateField<>(32, 39);
    public UpdateField<Integer> scalingFactionGroup = new UpdateField<>(32, 40);
    public UpdateField<Integer> scalingHealthItemLevelCurveID = new UpdateField<>(32, 41);
    public UpdateField<Integer> scalingDamageItemLevelCurveID = new UpdateField<>(32, 42);
    public UpdateField<Integer> factionTemplate = new UpdateField<>(32, 43);
    public UpdateField<Integer> flags = new UpdateField<>(32, 44);
    public UpdateField<Integer> flags2 = new UpdateField<>(32, 45);
    public UpdateField<Integer> flags3 = new UpdateField<>(32, 46);
    public UpdateField<Integer> auraState = new UpdateField<>(32, 47);
    public UpdateField<Integer> rangedAttackRoundBaseTime = new UpdateField<>(32, 48);
    public UpdateField<Float> boundingRadius = new UpdateField<>(32, 49);
    public UpdateField<Float> combatReach = new UpdateField<>(32, 50);
    public UpdateField<Float> displayScale = new UpdateField<>(32, 51);
    public UpdateField<Integer> creatureFamily = new UpdateField<>(32, 52);
    public UpdateField<Integer> creatureType = new UpdateField<>(32, 53);
    public UpdateField<Integer> nativeDisplayID = new UpdateField<>(32, 54);
    public UpdateField<Float> nativeXDisplayScale = new UpdateField<>(32, 55);
    public UpdateField<Integer> mountDisplayID = new UpdateField<>(32, 56);
    public UpdateField<Integer> cosmeticMountDisplayID = new UpdateField<>(32, 57);
    public UpdateField<Float> minDamage = new UpdateField<>(32, 58);
    public UpdateField<Float> maxDamage = new UpdateField<>(32, 59);
    public UpdateField<Float> minOffHandDamage = new UpdateField<>(32, 60);
    public UpdateField<Float> maxOffHandDamage = new UpdateField<>(32, 61);
    public UpdateField<Byte> standState = new UpdateField<>(32, 62);
    public UpdateField<Byte> petTalentPoints = new UpdateField<>(32, 63);
    public UpdateField<Byte> visFlags = new UpdateField<>(64, 65);
    public UpdateField<Byte> animTier = new UpdateField<>(64, 66);
    public UpdateField<Integer> petNumber = new UpdateField<>(64, 67);
    public UpdateField<Integer> petNameTimestamp = new UpdateField<>(64, 68);
    public UpdateField<Integer> petExperience = new UpdateField<>(64, 69);
    public UpdateField<Integer> petNextLevelExperience = new UpdateField<>(64, 70);
    public UpdateField<Float> modCastingSpeed = new UpdateField<>(64, 71);
    public UpdateField<Float> modCastingSpeedNeg = new UpdateField<>(64, 72);
    public UpdateField<Float> modSpellHaste = new UpdateField<>(64, 73);
    public UpdateField<Float> modHaste = new UpdateField<>(64, 74);
    public UpdateField<Float> modRangedHaste = new UpdateField<>(64, 75);
    public UpdateField<Float> modHasteRegen = new UpdateField<>(64, 76);
    public UpdateField<Float> modTimeRate = new UpdateField<>(64, 77);
    public UpdateField<Integer> createdBySpell = new UpdateField<>(64, 78);
    public UpdateField<Integer> emoteState = new UpdateField<>(64, 79);
    public UpdateField<Integer> baseMana = new UpdateField<>(64, 80);
    public UpdateField<Integer> baseHealth = new UpdateField<>(64, 81);
    public UpdateField<Byte> sheatheState = new UpdateField<>(64, 82);
    public UpdateField<Byte> pvpFlags = new UpdateField<>(64, 83);
    public UpdateField<Byte> petFlags = new UpdateField<>(64, 84);
    public UpdateField<Byte> shapeshiftForm = new UpdateField<>(64, 85);
    public UpdateField<Integer> attackPower = new UpdateField<>(64, 86);
    public UpdateField<Integer> attackPowerModPos = new UpdateField<>(64, 87);
    public UpdateField<Integer> attackPowerModNeg = new UpdateField<>(64, 88);
    public UpdateField<Float> attackPowerMultiplier = new UpdateField<>(64, 89);
    public UpdateField<Integer> rangedAttackPower = new UpdateField<>(64, 90);
    public UpdateField<Integer> rangedAttackPowerModPos = new UpdateField<>(64, 91);
    public UpdateField<Integer> rangedAttackPowerModNeg = new UpdateField<>(64, 92);
    public UpdateField<Float> rangedAttackPowerMultiplier = new UpdateField<>(64, 93);
    public UpdateField<Integer> mainHandWeaponAttackPower = new UpdateField<>(64, 94);
    public UpdateField<Integer> offHandWeaponAttackPower = new UpdateField<>(64, 95);
    public UpdateField<Integer> rangedWeaponAttackPower = new UpdateField<>(96, 97);
    public UpdateField<Integer> setAttackSpeedAura = new UpdateField<>(96, 98);
    public UpdateField<Float> lifesteal = new UpdateField<>(96, 99);
    public UpdateField<Float> minRangedDamage = new UpdateField<>(96, 100);
    public UpdateField<Float> maxRangedDamage = new UpdateField<>(96, 101);
    public UpdateField<Float> manaCostMultiplier = new UpdateField<>(96, 102);
    public UpdateField<Float> maxHealthModifier = new UpdateField<>(96, 103);
    public UpdateField<Float> hoverHeight = new UpdateField<>(96, 104);
    public UpdateField<Integer> minItemLevelCutoff = new UpdateField<>(96, 105);
    public UpdateField<Integer> minItemLevel = new UpdateField<>(96, 106);
    public UpdateField<Integer> maxItemLevel = new UpdateField<>(96, 107);
    public UpdateField<Integer> azeriteItemLevel = new UpdateField<>(96, 108);
    public UpdateField<Integer> wildBattlePetLevel = new UpdateField<>(96, 109);
    public UpdateField<Integer> battlePetCompanionExperience = new UpdateField<>(96, 110);
    public UpdateField<Integer> battlePetCompanionNameTimestamp = new UpdateField<>(96, 111);
    public UpdateField<Integer> interactSpellID = new UpdateField<>(96, 112);
    public UpdateField<Integer> scaleDuration = new UpdateField<>(96, 113);
    public UpdateField<Integer> looksLikeMountID = new UpdateField<>(96, 114);
    public UpdateField<Integer> looksLikeCreatureID = new UpdateField<>(96, 115);
    public UpdateField<Integer> lookAtControllerID = new UpdateField<>(96, 116);
    public UpdateField<Integer> perksVendorItemID = new UpdateField<>(96, 117);
    public UpdateField<Integer> taxiNodesID = new UpdateField<>(96, 118);
    public UpdateField<ObjectGuid> guildGUID = new UpdateField<>(96, 119);
    public UpdateField<Integer> flightCapabilityID = new UpdateField<>(96, 120);
    public UpdateField<Integer> silencedSchoolMask = new UpdateField<>(96, 121);
    public UpdateField<ObjectGuid> nameplateAttachToGUID = new UpdateField<>(96, 122); // When set, nameplate of this unit will instead appear on that object
    public Array<Integer> npcFlags = new Array<Integer>(2, 123, 124);
    public Array<Integer> power = new Array<Integer>(7, 126, 127);
    public Array<Integer> maxPower = new Array<Integer>(7, 126, 134);
    public Array<Float> powerRegenFlatModifier = new Array<Float>(7, 126, 141);
    public Array<Float> powerRegenInterruptedFlatModifier = new Array<Float>(7, 126, 148);
    public Array<VisibleItem> virtualItems = new Array<VisibleItem>(3, 155, 156);
    public Array<Integer> attackRoundBaseTime = new Array<Integer>(2, 159, 160);
    public Array<Integer> stats = new Array<Integer>(4, 162, 163);
    public Array<Integer> statPosBuff = new Array<Integer>(4, 162, 167);
    public Array<Integer> statNegBuff = new Array<Integer>(4, 162, 171);
    public Array<Integer> resistances = new Array<Integer>(7, 175, 176);
    public Array<Integer> bonusResistanceMods = new Array<Integer>(7, 175, 183);
    public Array<Integer> manaCostModifier = new Array<Integer>(7, 175, 190);

    public UnitData() {
        super(0, TypeId.UNIT, 197);
    }

    public final void writeCreate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, Unit owner, Player receiver) {
        data.writeInt32(getViewerDependentDisplayId(this, owner, receiver));

        for (var i = 0; i < 2; ++i) {
            data.writeInt32(getViewerDependentNpcFlags(this, i, owner, receiver));
        }

        data.writeInt32(stateSpellVisualID);
        data.writeInt32(stateAnimID);
        data.writeInt32(stateAnimKitID);
        data.writeInt32(stateWorldEffectIDs.get().size());
        data.writeInt32(stateWorldEffectsQuestObjectiveID);
        data.writeInt32(spellOverrideNameID);

        for (var i = 0; i < stateWorldEffectIDs.get().size(); ++i) {
            data.writeInt32(stateWorldEffectIDs.get().get(i));
        }

        data.writeGuid(charm);
        data.writeGuid(summon);

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.owner)) {
            data.writeGuid(critter);
        }

        data.writeGuid(charmedBy);
        data.writeGuid(summonedBy);
        data.writeGuid(createdBy);
        data.writeGuid(demonCreator);
        data.writeGuid(lookAtControllerTarget);
        data.writeGuid(target);
        data.writeGuid(battlePetCompanionGUID);
        data.writeInt64(battlePetDBID);
        channelData.get().writeCreate(data, owner, receiver);
        data.writeInt8(spellEmpowerStage);
        data.writeInt32(summonedByHomeRealm);
        data.writeInt8(race);
        data.writeInt8(classId);
        data.writeInt8(playerClassId);
        data.writeInt8(sex);
        data.writeInt8(displayPower);
        data.writeInt32(overrideDisplayPowerID);
        data.write(health);

        for (var i = 0; i < 7; ++i) {
            data.writeInt32(power.get(i));
            data.writeInt32(maxPower.get(i));
        }

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.owner) || fieldVisibilityFlags.hasFlag(UpdateFieldFlag.UnitAll)) {
            for (var i = 0; i < 7; ++i) {
                data.writeFloat(powerRegenFlatModifier.get(i));
                data.writeFloat(powerRegenInterruptedFlatModifier.get(i));
            }
        }

        data.write(maxHealth);
        data.writeInt32(level);
        data.writeInt32(effectiveLevel);
        data.writeInt32(contentTuningID);
        data.writeInt32(scalingLevelMin);
        data.writeInt32(scalingLevelMax);
        data.writeInt32(scalingLevelDelta);
        data.writeInt32(scalingFactionGroup);
        data.writeInt32(scalingHealthItemLevelCurveID);
        data.writeInt32(scalingDamageItemLevelCurveID);
        data.writeInt32(getViewerDependentFactionTemplate(this, owner, receiver));

        for (var i = 0; i < 3; ++i) {
            virtualItems.get(i).writeCreate(data, owner, receiver);
        }

        data.writeInt32(getViewerDependentFlags(this, owner, receiver));
        data.writeInt32(flags2);
        data.writeInt32(getViewerDependentFlags3(this, owner, receiver));
        data.writeInt32(getViewerDependentAuraState(this, owner, receiver));

        for (var i = 0; i < 2; ++i) {
            data.writeInt32(attackRoundBaseTime.get(i));
        }

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.owner)) {
            data.writeInt32(rangedAttackRoundBaseTime);
        }

        data.writeFloat(boundingRadius.get());
        data.writeFloat(combatReach);
        data.writeFloat(displayScale);
        data.writeInt32(creatureFamily);
        data.writeInt32(creatureType);
        data.writeInt32(nativeDisplayID);
        data.writeFloat(nativeXDisplayScale);
        data.writeInt32(mountDisplayID);
        data.writeInt32(cosmeticMountDisplayID);

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.owner) || fieldVisibilityFlags.hasFlag(UpdateFieldFlag.Empath)) {
            data.writeFloat(minDamage);
            data.writeFloat(maxDamage);
            data.writeFloat(minOffHandDamage);
            data.writeFloat(maxOffHandDamage);
        }

        data.writeInt8(standState);
        data.writeInt8(petTalentPoints);
        data.writeInt8(visFlags);
        data.writeInt8(animTier);
        data.writeInt32(petNumber);
        data.writeInt32(petNameTimestamp);
        data.writeInt32(petExperience);
        data.writeInt32(petNextLevelExperience);
        data.writeFloat(modCastingSpeed);
        data.writeFloat(modCastingSpeedNeg);
        data.writeFloat(modSpellHaste);
        data.writeFloat(modHaste);
        data.writeFloat(modRangedHaste);
        data.writeFloat(modHasteRegen);
        data.writeFloat(modTimeRate);
        data.writeInt32(createdBySpell);
        data.writeInt32(emoteState);

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.owner)) {
            for (var i = 0; i < 4; ++i) {
                data.writeInt32(stats.get(i));
                data.writeInt32(statPosBuff.get(i));
                data.writeInt32(statNegBuff.get(i));
            }
        }

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.owner) || fieldVisibilityFlags.hasFlag(UpdateFieldFlag.Empath)) {
            for (var i = 0; i < 7; ++i) {
                data.writeInt32(resistances.get(i));
            }
        }

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.owner)) {
            for (var i = 0; i < 7; ++i) {
                data.writeInt32(bonusResistanceMods.get(i));
                data.writeInt32(manaCostModifier.get(i));
            }
        }

        data.writeInt32(baseMana);

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.owner)) {
            data.writeInt32(baseHealth);
        }

        data.writeInt8(sheatheState);
        data.writeInt8((byte) getViewerDependentPvpFlags(this, owner, receiver));
        data.writeInt8(petFlags);
        data.writeInt8(shapeshiftForm);

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.owner)) {
            data.writeInt32(attackPower);
            data.writeInt32(attackPowerModPos);
            data.writeInt32(attackPowerModNeg);
            data.writeFloat(attackPowerMultiplier);
            data.writeInt32(rangedAttackPower);
            data.writeInt32(rangedAttackPowerModPos);
            data.writeInt32(rangedAttackPowerModNeg);
            data.writeFloat(rangedAttackPowerMultiplier);
            data.writeInt32(mainHandWeaponAttackPower);
            data.writeInt32(offHandWeaponAttackPower);
            data.writeInt32(rangedWeaponAttackPower);
            data.writeInt32(setAttackSpeedAura);
            data.writeFloat(lifesteal);
            data.writeFloat(minRangedDamage);
            data.writeFloat(maxRangedDamage);
            data.writeFloat(manaCostMultiplier);
            data.writeFloat(maxHealthModifier);
        }

        data.writeFloat(hoverHeight);
        data.writeInt32(minItemLevelCutoff);
        data.writeInt32(minItemLevel);
        data.writeInt32(maxItemLevel);
        data.writeInt32(azeriteItemLevel);
        data.writeInt32(wildBattlePetLevel);
        data.writeInt32(battlePetCompanionExperience);
        data.writeInt32(battlePetCompanionNameTimestamp);
        data.writeInt32(interactSpellID);
        data.writeInt32(scaleDuration);
        data.writeInt32(looksLikeMountID);
        data.writeInt32(looksLikeCreatureID);
        data.writeInt32(lookAtControllerID);
        data.writeInt32(perksVendorItemID);
        data.writeInt32(taxiNodesID);
        data.writeGuid(guildGUID);
        data.writeInt32(passiveSpells.size());
        data.writeInt32(worldEffects.size());
        data.writeInt32(channelObjects.size());
        data.writeInt32(flightCapabilityID);
        data.writeInt32(silencedSchoolMask);
        data.writeGuid(nameplateAttachToGUID);

        for (var i = 0; i < passiveSpells.size(); ++i) {
            passiveSpells.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < worldEffects.size(); ++i) {
            data.writeInt32(worldEffects.get(i));
        }

        for (var i = 0; i < channelObjects.size(); ++i) {
            data.writeGuid(channelObjects.get(i));
        }
    }

    public final void writeUpdate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, Unit owner, Player receiver) {
        UpdateMask allowedMaskForTarget = new UpdateMask(195, new int[]{0xFFFFDFFF, 0xC3FEFFFF, 0x003DFFFF, 0xFFFFFF01, 0xF8001FFF, 0x00000003, 0x00000000});

        appendAllowedFieldsMaskForFlag(allowedMaskForTarget, fieldVisibilityFlags);
        writeUpdate(data, UpdateMask.opBitwiseAnd(getChangesMask(), allowedMaskForTarget), false, owner, receiver);
    }

    public final void appendAllowedFieldsMaskForFlag(UpdateMask allowedMaskForTarget, UpdateFieldFlag fieldVisibilityFlags) {
        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.owner)) {
            allowedMaskForTarget.OR(new UpdateMask(195, new int[]{0x00002000, 0x3C010000, 0xFFC20000, 0x400000FE, 0x03FFF000, 0xFFFFFFFE, 0x0000000F}));
        }

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.UnitAll)) {
            allowedMaskForTarget.OR(new UpdateMask(195, new int[]{0x00000000, 0x00000000, 0x00000000, 0x40000000, 0x07FFE000, 0x00000000, 0x00000000}));
        }

        if (fieldVisibilityFlags.hasFlag(UpdateFieldFlag.Empath)) {
            allowedMaskForTarget.OR(new UpdateMask(195, new int[]{0x00000000, 0x3C000000, 0x00000000, 0x00000000, 0x00000000, 0x007F8000, 0x00000000}));
        }
    }

    public final void filterDisallowedFieldsMaskForFlag(UpdateMask changesMask, UpdateFieldFlag fieldVisibilityFlags) {
        UpdateMask allowedMaskForTarget = new UpdateMask(195, new Object[]{0xFFFFDFFF, 0xC3FEFFFF, 0x003DFFFF, 0xFFFFFF01, 0xF8001FFF, 0x00000003, 0x00000000});

        appendAllowedFieldsMaskForFlag(allowedMaskForTarget, fieldVisibilityFlags);
        changesMask.AND(allowedMaskForTarget);
    }

    public final void writeUpdate(WorldPacket data, UpdateMask changesMask, boolean ignoreNestedChangesMask, Unit owner, Player receiver) {
        data.writeBits(changesMask.getBlocksMask(0), 7);

        for (int i = 0; i < 7; ++i) {
            if (changesMask.getBlock(i) != 0) {
                data.writeBits(changesMask.getBlock(i), 32);
            }
        }

        if (changesMask.get(0)) {
            if (changesMask.get(1)) {
                data.writeBits(stateWorldEffectIDs.get().size(), 32);

                for (var i = 0; i < stateWorldEffectIDs.get().size(); ++i) {
                    data.writeInt32(stateWorldEffectIDs.get().get(i));
                }
            }
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(2)) {
                if (!ignoreNestedChangesMask) {
                    passiveSpells.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(passiveSpells.size(), data);
                }
            }

            if (changesMask.get(3)) {
                if (!ignoreNestedChangesMask) {
                    worldEffects.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(worldEffects.size(), data);
                }
            }

            if (changesMask.get(4)) {
                if (!ignoreNestedChangesMask) {
                    channelObjects.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(channelObjects.size(), data);
                }
            }
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(2)) {
                for (var i = 0; i < passiveSpells.size(); ++i) {
                    if (passiveSpells.hasChanged(i) || ignoreNestedChangesMask) {
                        passiveSpells.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
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
                for (var i = 0; i < channelObjects.size(); ++i) {
                    if (channelObjects.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeGuid(channelObjects.get(i));
                    }
                }
            }

            if (changesMask.get(5)) {
                data.writeInt32(getViewerDependentDisplayId(this, owner, receiver));
            }

            if (changesMask.get(6)) {
                data.writeInt32(stateSpellVisualID);
            }

            if (changesMask.get(7)) {
                data.writeInt32(stateAnimID);
            }

            if (changesMask.get(8)) {
                data.writeInt32(stateAnimKitID);
            }

            if (changesMask.get(9)) {
                data.writeInt32(stateWorldEffectsQuestObjectiveID);
            }

            if (changesMask.get(10)) {
                data.writeInt32(spellOverrideNameID);
            }

            if (changesMask.get(11)) {
                data.writeGuid(charm);
            }

            if (changesMask.get(12)) {
                data.writeGuid(summon);
            }

            if (changesMask.get(13)) {
                data.writeGuid(critter);
            }

            if (changesMask.get(14)) {
                data.writeGuid(charmedBy);
            }

            if (changesMask.get(15)) {
                data.writeGuid(summonedBy);
            }

            if (changesMask.get(16)) {
                data.writeGuid(createdBy);
            }

            if (changesMask.get(17)) {
                data.writeGuid(demonCreator);
            }

            if (changesMask.get(18)) {
                data.writeGuid(lookAtControllerTarget);
            }

            if (changesMask.get(19)) {
                data.writeGuid(target);
            }

            if (changesMask.get(20)) {
                data.writeGuid(battlePetCompanionGUID);
            }

            if (changesMask.get(21)) {
                data.writeInt64(battlePetDBID);
            }

            if (changesMask.get(22)) {
                channelData.get().writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
            }

            if (changesMask.get(23)) {
                data.writeInt8(spellEmpowerStage);
            }

            if (changesMask.get(24)) {
                data.writeInt32(summonedByHomeRealm);
            }

            if (changesMask.get(25)) {
                data.writeInt8(race);
            }

            if (changesMask.get(26)) {
                data.writeInt8(classId);
            }

            if (changesMask.get(27)) {
                data.writeInt8(playerClassId);
            }

            if (changesMask.get(28)) {
                data.writeInt8(sex);
            }

            if (changesMask.get(29)) {
                data.writeInt8(displayPower);
            }

            if (changesMask.get(30)) {
                data.writeInt32(overrideDisplayPowerID);
            }

            if (changesMask.get(31)) {
                data.write(health);
            }
        }

        if (changesMask.get(32)) {
            if (changesMask.get(33)) {
                data.write(maxHealth);
            }

            if (changesMask.get(34)) {
                data.writeInt32(level);
            }

            if (changesMask.get(35)) {
                data.writeInt32(effectiveLevel);
            }

            if (changesMask.get(36)) {
                data.writeInt32(contentTuningID);
            }

            if (changesMask.get(37)) {
                data.writeInt32(scalingLevelMin);
            }

            if (changesMask.get(38)) {
                data.writeInt32(scalingLevelMax);
            }

            if (changesMask.get(39)) {
                data.writeInt32(scalingLevelDelta);
            }

            if (changesMask.get(40)) {
                data.writeInt32(scalingFactionGroup);
            }

            if (changesMask.get(41)) {
                data.writeInt32(scalingHealthItemLevelCurveID);
            }

            if (changesMask.get(42)) {
                data.writeInt32(scalingDamageItemLevelCurveID);
            }

            if (changesMask.get(43)) {
                data.writeInt32(getViewerDependentFactionTemplate(this, owner, receiver));
            }

            if (changesMask.get(44)) {
                data.writeInt32(getViewerDependentFlags(this, owner, receiver));
            }

            if (changesMask.get(45)) {
                data.writeInt32(flags2);
            }

            if (changesMask.get(46)) {
                data.writeInt32(getViewerDependentFlags3(this, owner, receiver));
            }

            if (changesMask.get(47)) {
                data.writeInt32(getViewerDependentAuraState(this, owner, receiver));
            }

            if (changesMask.get(48)) {
                data.writeInt32(rangedAttackRoundBaseTime);
            }

            if (changesMask.get(49)) {
                data.writeFloat(boundingRadius);
            }

            if (changesMask.get(50)) {
                data.writeFloat(combatReach);
            }

            if (changesMask.get(51)) {
                data.writeFloat(displayScale);
            }

            if (changesMask.get(52)) {
                data.writeInt32(creatureFamily);
            }

            if (changesMask.get(53)) {
                data.writeInt32(creatureType);
            }

            if (changesMask.get(54)) {
                data.writeInt32(nativeDisplayID);
            }

            if (changesMask.get(55)) {
                data.writeFloat(nativeXDisplayScale);
            }

            if (changesMask.get(56)) {
                data.writeInt32(mountDisplayID);
            }

            if (changesMask.get(57)) {
                data.writeInt32(cosmeticMountDisplayID);
            }

            if (changesMask.get(58)) {
                data.writeFloat(minDamage);
            }

            if (changesMask.get(59)) {
                data.writeFloat(maxDamage);
            }

            if (changesMask.get(60)) {
                data.writeFloat(minOffHandDamage);
            }

            if (changesMask.get(61)) {
                data.writeFloat(maxOffHandDamage);
            }

            if (changesMask.get(62)) {
                data.writeInt8(standState);
            }

            if (changesMask.get(63)) {
                data.writeInt8(petTalentPoints);
            }
        }

        if (changesMask.get(64)) {
            if (changesMask.get(65)) {
                data.writeInt8(visFlags);
            }

            if (changesMask.get(66)) {
                data.writeInt8(animTier);
            }

            if (changesMask.get(67)) {
                data.writeInt32(petNumber);
            }

            if (changesMask.get(68)) {
                data.writeInt32(petNameTimestamp);
            }

            if (changesMask.get(69)) {
                data.writeInt32(petExperience);
            }

            if (changesMask.get(70)) {
                data.writeInt32(petNextLevelExperience);
            }

            if (changesMask.get(71)) {
                data.writeFloat(modCastingSpeed);
            }

            if (changesMask.get(72)) {
                data.writeFloat(modCastingSpeedNeg);
            }

            if (changesMask.get(73)) {
                data.writeFloat(modSpellHaste);
            }

            if (changesMask.get(74)) {
                data.writeFloat(modHaste);
            }

            if (changesMask.get(75)) {
                data.writeFloat(modRangedHaste);
            }

            if (changesMask.get(76)) {
                data.writeFloat(modHasteRegen);
            }

            if (changesMask.get(77)) {
                data.writeFloat(modTimeRate);
            }

            if (changesMask.get(78)) {
                data.writeInt32(createdBySpell);
            }

            if (changesMask.get(79)) {
                data.writeInt32(emoteState);
            }

            if (changesMask.get(80)) {
                data.writeInt32(baseMana);
            }

            if (changesMask.get(81)) {
                data.writeInt32(baseHealth);
            }

            if (changesMask.get(82)) {
                data.writeInt8(sheatheState);
            }

            if (changesMask.get(83)) {
                data.writeInt8(getViewerDependentPvpFlags(this, owner, receiver));
            }

            if (changesMask.get(84)) {
                data.writeInt8(petFlags);
            }

            if (changesMask.get(85)) {
                data.writeInt8(shapeshiftForm);
            }

            if (changesMask.get(86)) {
                data.writeInt32(attackPower);
            }

            if (changesMask.get(87)) {
                data.writeInt32(attackPowerModPos);
            }

            if (changesMask.get(88)) {
                data.writeInt32(attackPowerModNeg);
            }

            if (changesMask.get(89)) {
                data.writeFloat(attackPowerMultiplier);
            }

            if (changesMask.get(90)) {
                data.writeInt32(rangedAttackPower);
            }

            if (changesMask.get(91)) {
                data.writeInt32(rangedAttackPowerModPos);
            }

            if (changesMask.get(92)) {
                data.writeInt32(rangedAttackPowerModNeg);
            }

            if (changesMask.get(93)) {
                data.writeFloat(rangedAttackPowerMultiplier);
            }

            if (changesMask.get(94)) {
                data.writeInt32(mainHandWeaponAttackPower);
            }

            if (changesMask.get(95)) {
                data.writeInt32(offHandWeaponAttackPower);
            }
        }

        if (changesMask.get(96)) {
            if (changesMask.get(97)) {
                data.writeInt32(rangedWeaponAttackPower);
            }

            if (changesMask.get(98)) {
                data.writeInt32(setAttackSpeedAura);
            }

            if (changesMask.get(99)) {
                data.writeFloat(lifesteal);
            }

            if (changesMask.get(100)) {
                data.writeFloat(minRangedDamage);
            }

            if (changesMask.get(101)) {
                data.writeFloat(maxRangedDamage);
            }

            if (changesMask.get(102)) {
                data.writeFloat(manaCostMultiplier);
            }

            if (changesMask.get(103)) {
                data.writeFloat(maxHealthModifier);
            }

            if (changesMask.get(104)) {
                data.writeFloat(hoverHeight);
            }

            if (changesMask.get(105)) {
                data.writeInt32(minItemLevelCutoff);
            }

            if (changesMask.get(106)) {
                data.writeInt32(minItemLevel);
            }

            if (changesMask.get(107)) {
                data.writeInt32(maxItemLevel);
            }

            if (changesMask.get(108)) {
                data.writeInt32(azeriteItemLevel);
            }

            if (changesMask.get(109)) {
                data.writeInt32(wildBattlePetLevel);
            }

            if (changesMask.get(110)) {
                data.writeInt32(battlePetCompanionExperience);
            }

            if (changesMask.get(111)) {
                data.writeInt32(battlePetCompanionNameTimestamp);
            }

            if (changesMask.get(112)) {
                data.writeInt32(interactSpellID);
            }

            if (changesMask.get(113)) {
                data.writeInt32(scaleDuration);
            }

            if (changesMask.get(114)) {
                data.writeInt32(looksLikeMountID);
            }

            if (changesMask.get(115)) {
                data.writeInt32(looksLikeCreatureID);
            }

            if (changesMask.get(116)) {
                data.writeInt32(lookAtControllerID);
            }

            if (changesMask.get(117)) {
                data.writeInt32(perksVendorItemID);
            }

            if (changesMask.get(118)) {
                data.writeInt32(taxiNodesID);
            }

            if (changesMask.get(119)) {
                data.writeGuid(guildGUID);
            }

            if (changesMask.get(120)) {
                data.writeInt32(flightCapabilityID);
            }

            if (changesMask.get(121)) {
                data.writeInt32(silencedSchoolMask);
            }

            if (changesMask.get(122)) {
                data.writeGuid(nameplateAttachToGUID);
            }
        }

        if (changesMask.get(123)) {
            for (var i = 0; i < 2; ++i) {
                if (changesMask.get(124 + i)) {
                    data.writeInt32(getViewerDependentNpcFlags(this, i, owner, receiver));
                }
            }
        }

        if (changesMask.get(126)) {
            for (var i = 0; i < 7; ++i) {
                if (changesMask.get(127 + i)) {
                    data.writeInt32(power.get(i));
                }

                if (changesMask.get(134 + i)) {
                    data.writeInt32(maxPower.get(i));
                }

                if (changesMask.get(141 + i)) {
                    data.writeFloat(powerRegenFlatModifier.get(i));
                }

                if (changesMask.get(148 + i)) {
                    data.writeFloat(powerRegenInterruptedFlatModifier.get(i));
                }
            }
        }

        if (changesMask.get(155)) {
            for (var i = 0; i < 3; ++i) {
                if (changesMask.get(156 + i)) {
                    virtualItems.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                }
            }
        }

        if (changesMask.get(159)) {
            for (var i = 0; i < 2; ++i) {
                if (changesMask.get(160 + i)) {
                    data.writeInt32(attackRoundBaseTime.get(i));
                }
            }
        }

        if (changesMask.get(162)) {
            for (var i = 0; i < 4; ++i) {
                if (changesMask.get(163 + i)) {
                    data.writeInt32(stats.get(i));
                }

                if (changesMask.get(167 + i)) {
                    data.writeInt32(statPosBuff.get(i));
                }

                if (changesMask.get(171 + i)) {
                    data.writeInt32(statNegBuff.get(i));
                }
            }
        }

        if (changesMask.get(175)) {
            for (var i = 0; i < 7; ++i) {
                if (changesMask.get(176 + i)) {
                    data.writeInt32(resistances.get(i));
                }

                if (changesMask.get(183 + i)) {
                    data.writeInt32(bonusResistanceMods.get(i));
                }

                if (changesMask.get(190 + i)) {
                    data.writeInt32(manaCostModifier.get(i));
                }
            }
        }
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(stateWorldEffectIDs);
        clearChangesMask(passiveSpells);
        clearChangesMask(worldEffects);
        clearChangesMask(channelObjects);
        clearChangesMask(displayID);
        clearChangesMask(stateSpellVisualID);
        clearChangesMask(stateAnimID);
        clearChangesMask(stateAnimKitID);
        clearChangesMask(stateWorldEffectsQuestObjectiveID);
        clearChangesMask(spellOverrideNameID);
        clearChangesMask(charm);
        clearChangesMask(summon);
        clearChangesMask(critter);
        clearChangesMask(charmedBy);
        clearChangesMask(summonedBy);
        clearChangesMask(createdBy);
        clearChangesMask(demonCreator);
        clearChangesMask(lookAtControllerTarget);
        clearChangesMask(target);
        clearChangesMask(battlePetCompanionGUID);
        clearChangesMask(battlePetDBID);
        clearChangesMask(channelData);
        clearChangesMask(spellEmpowerStage);
        clearChangesMask(summonedByHomeRealm);
        clearChangesMask(race);
        clearChangesMask(classId);
        clearChangesMask(playerClassId);
        clearChangesMask(sex);
        clearChangesMask(displayPower);
        clearChangesMask(overrideDisplayPowerID);
        clearChangesMask(health);
        clearChangesMask(maxHealth);
        clearChangesMask(level);
        clearChangesMask(effectiveLevel);
        clearChangesMask(contentTuningID);
        clearChangesMask(scalingLevelMin);
        clearChangesMask(scalingLevelMax);
        clearChangesMask(scalingLevelDelta);
        clearChangesMask(scalingFactionGroup);
        clearChangesMask(scalingHealthItemLevelCurveID);
        clearChangesMask(scalingDamageItemLevelCurveID);
        clearChangesMask(factionTemplate);
        clearChangesMask(flags);
        clearChangesMask(flags2);
        clearChangesMask(flags3);
        clearChangesMask(auraState);
        clearChangesMask(rangedAttackRoundBaseTime);
        clearChangesMask(boundingRadius);
        clearChangesMask(combatReach);
        clearChangesMask(displayScale);
        clearChangesMask(creatureFamily);
        clearChangesMask(creatureType);
        clearChangesMask(nativeDisplayID);
        clearChangesMask(nativeXDisplayScale);
        clearChangesMask(mountDisplayID);
        clearChangesMask(cosmeticMountDisplayID);
        clearChangesMask(minDamage);
        clearChangesMask(maxDamage);
        clearChangesMask(minOffHandDamage);
        clearChangesMask(maxOffHandDamage);
        clearChangesMask(standState);
        clearChangesMask(petTalentPoints);
        clearChangesMask(visFlags);
        clearChangesMask(animTier);
        clearChangesMask(petNumber);
        clearChangesMask(petNameTimestamp);
        clearChangesMask(petExperience);
        clearChangesMask(petNextLevelExperience);
        clearChangesMask(modCastingSpeed);
        clearChangesMask(modCastingSpeedNeg);
        clearChangesMask(modSpellHaste);
        clearChangesMask(modHaste);
        clearChangesMask(modRangedHaste);
        clearChangesMask(modHasteRegen);
        clearChangesMask(modTimeRate);
        clearChangesMask(createdBySpell);
        clearChangesMask(emoteState);
        clearChangesMask(baseMana);
        clearChangesMask(baseHealth);
        clearChangesMask(sheatheState);
        clearChangesMask(pvpFlags);
        clearChangesMask(petFlags);
        clearChangesMask(shapeshiftForm);
        clearChangesMask(attackPower);
        clearChangesMask(attackPowerModPos);
        clearChangesMask(attackPowerModNeg);
        clearChangesMask(attackPowerMultiplier);
        clearChangesMask(rangedAttackPower);
        clearChangesMask(rangedAttackPowerModPos);
        clearChangesMask(rangedAttackPowerModNeg);
        clearChangesMask(rangedAttackPowerMultiplier);
        clearChangesMask(mainHandWeaponAttackPower);
        clearChangesMask(offHandWeaponAttackPower);
        clearChangesMask(rangedWeaponAttackPower);
        clearChangesMask(setAttackSpeedAura);
        clearChangesMask(lifesteal);
        clearChangesMask(minRangedDamage);
        clearChangesMask(maxRangedDamage);
        clearChangesMask(manaCostMultiplier);
        clearChangesMask(maxHealthModifier);
        clearChangesMask(hoverHeight);
        clearChangesMask(minItemLevelCutoff);
        clearChangesMask(minItemLevel);
        clearChangesMask(maxItemLevel);
        clearChangesMask(azeriteItemLevel);
        clearChangesMask(wildBattlePetLevel);
        clearChangesMask(battlePetCompanionExperience);
        clearChangesMask(battlePetCompanionNameTimestamp);
        clearChangesMask(interactSpellID);
        clearChangesMask(scaleDuration);
        clearChangesMask(looksLikeMountID);
        clearChangesMask(looksLikeCreatureID);
        clearChangesMask(lookAtControllerID);
        clearChangesMask(perksVendorItemID);
        clearChangesMask(taxiNodesID);
        clearChangesMask(guildGUID);
        clearChangesMask(flightCapabilityID);
        clearChangesMask(silencedSchoolMask);
        clearChangesMask(nameplateAttachToGUID);
        clearChangesMask(npcFlags);
        clearChangesMask(power);
        clearChangesMask(maxPower);
        clearChangesMask(powerRegenFlatModifier);
        clearChangesMask(powerRegenInterruptedFlatModifier);
        clearChangesMask(virtualItems);
        clearChangesMask(attackRoundBaseTime);
        clearChangesMask(stats);
        clearChangesMask(statPosBuff);
        clearChangesMask(statNegBuff);
        clearChangesMask(resistances);
        clearChangesMask(bonusResistanceMods);
        clearChangesMask(manaCostModifier);
        getChangesMask().resetAll();
    }

    private int getViewerDependentDisplayId(UnitData unitData, Unit unit, Player receiver) {
        int displayId = unitData.displayID;

        if (unit.isCreature()) {
            var cinfo = unit.toCreature().getTemplate();
            var summon = unit.toTempSummon();

            if (summon != null) {
                if (Objects.equals(summon.getSummonerGUID(), receiver.getGUID())) {
                    if (summon.getCreatureIdVisibleToSummoner() != null) {
                        cinfo = global.getObjectMgr().getCreatureTemplate(summon.getCreatureIdVisibleToSummoner().intValue());
                    }

                    if (summon.getDisplayIdVisibleToSummoner() != null) {
                        displayId = summon.getDisplayIdVisibleToSummoner().intValue();
                    }
                }
            }

            // this also applies for transform auras
            var transform = global.getSpellMgr().getSpellInfo(unit.getTransformSpell(), unit.getMap().getDifficultyID());

            if (transform != null) {
                for (var spellEffectInfo : transform.getEffects()) {
                    if (spellEffectInfo.isAura(AuraType.Transform)) {
                        var transformInfo = global.getObjectMgr().getCreatureTemplate((int) spellEffectInfo.miscValue);

                        if (transformInfo != null) {
                            cinfo = transformInfo;

                            break;
                        }
                    }
                }
            }

            if (cinfo.flagsExtra.hasFlag(CreatureFlagExtra.trigger)) {
                if (receiver.isGameMaster()) {
                    displayId = cinfo.getFirstVisibleModel().creatureDisplayId;
                }
            }
        }

        return displayId;
    }

    private int getViewerDependentNpcFlags(UnitData unitData, int i, Unit unit, Player receiver) {
        var npcFlag = unitData.npcFlags.get(i);

        if (i == 0 && unit.isCreature() && !receiver.canSeeSpellClickOn(unit.toCreature())) {
            npcFlag &= ~(int) NPCFlags.SpellClick.getValue();
        }

        return npcFlag;
    }

    private int getViewerDependentFactionTemplate(UnitData unitData, Unit unit, Player receiver) {
        int factionTemplate = unitData.factionTemplate;

        if (unit.isControlledByPlayer() && receiver != unit && WorldConfig.getBoolValue(WorldCfg.AllowTwoSideInteractionGroup) && unit.isInRaidWith(receiver)) {
            var ft1 = unit.getFactionTemplateEntry();
            var ft2 = receiver.getFactionTemplateEntry();

            if (ft1 != null && ft2 != null && !ft1.isFriendlyTo(ft2)) {
                // pretend that all other HOSTILE players have own faction, to allow follow, heal, rezz (trade wont work)
                factionTemplate = receiver.getFaction();
            }
        }

        return factionTemplate;
    }

    private int getViewerDependentFlags(UnitData unitData, Unit unit, Player receiver) {
        int flags = unitData.flags;

        // Update fields of triggers, transformed units or uninteractible units (values dependent on GM state)
        if (receiver.isGameMaster()) {
            flags &= ~(int) UnitFlag.Uninteractible.getValue();
        }

        return flags;
    }

    private int getViewerDependentFlags3(UnitData unitData, Unit unit, Player receiver) {
        int flags = unitData.flags3;

        if ((flags & (int) unitFlags3.AlreadySkinned.getValue()) != 0 && unit.isCreature() && !unit.toCreature().isSkinnedBy(receiver)) {
            flags &= ~(int) unitFlags3.AlreadySkinned.getValue();
        }

        return flags;
    }

    private int getViewerDependentAuraState(UnitData unitData, Unit unit, Player receiver) {
        // Check per caster aura states to not enable using a spell in client if specified aura is not by target
        return unit.buildAuraStateUpdateForTarget(receiver);
    }

    private byte getViewerDependentPvpFlags(UnitData unitData, Unit unit, Player receiver) {
        byte pvpFlags = unitData.pvpFlags;

        if (unit.isControlledByPlayer() && receiver != unit && WorldConfig.getBoolValue(WorldCfg.AllowTwoSideInteractionGroup) && unit.isInRaidWith(receiver)) {
            var ft1 = unit.getFactionTemplateEntry();
            var ft2 = receiver.getFactionTemplateEntry();

            if (ft1 != null && ft2 != null && !ft1.isFriendlyTo(ft2)) {
                // Allow targeting opposite faction in party when enabled in config
                pvpFlags &= (byte) UnitPVPStateFlags.Sanctuary.getValue();
            }
        }

        return pvpFlags;
    }
}
