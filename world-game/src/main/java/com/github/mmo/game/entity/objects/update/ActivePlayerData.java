package com.github.mmo.game.entity;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;

public class ActivePlayerData extends BaseUpdateData<Player> {
    public static int EXPLOREDZONESSIZE;
    public static int EXPLOREDZONESBITS;
    public static int QUESTCOMPLETEDBITSSIZE;
    public static int QUESTCOMPLETEDBITSPERBLOCK;

    public UpdateField<Boolean> backpackAutoSortDisabled = new UpdateField<Boolean>(0, 1);
    public UpdateField<Boolean> bankAutoSortDisabled = new UpdateField<Boolean>(0, 2);
    public UpdateField<Boolean> sortBagsRightToLeft = new UpdateField<Boolean>(0, 3);
    public UpdateField<Boolean> insertItemsLeftToRight = new UpdateField<Boolean>(0, 4);
    public UpdateField<Boolean> hasPerksProgramPendingReward = new UpdateField<Boolean>(0, 5);
    public UpdateFieldArray<DynamicUpdateField<research>> research = new UpdateFieldArray<DynamicUpdateField<research>>(1, 32, 33);
   
    public DynamicUpdateField<Long> knownTitles = new DynamicUpdateField<Long>(0, 6);
   
    public DynamicUpdateField<SHORT> researchSites = new DynamicUpdateField<SHORT>(0, 8);
   
    public DynamicUpdateField<Integer> researchSiteProgress = new DynamicUpdateField<Integer>(0, 9);
   
    public DynamicUpdateField<Integer> dailyQuestsCompleted = new DynamicUpdateField<Integer>(0, 10);
    public DynamicUpdateField<Integer> availableQuestLineXQuestIDs = new DynamicUpdateField<Integer>(0, 11);
   
    public DynamicUpdateField<Integer> heirlooms = new DynamicUpdateField<Integer>(0, 12);
   
    public DynamicUpdateField<Integer> heirloomFlags = new DynamicUpdateField<Integer>(0, 13);
   
    public DynamicUpdateField<Integer> toys = new DynamicUpdateField<Integer>(0, 14);
   
    public DynamicUpdateField<Integer> toyFlags = new DynamicUpdateField<Integer>(0, 15);
   
    public DynamicUpdateField<Integer> transmog = new DynamicUpdateField<Integer>(0, 16);
   
    public DynamicUpdateField<Integer> conditionalTransmog = new DynamicUpdateField<Integer>(0, 17);
   
    public DynamicUpdateField<Integer> selfResSpells = new DynamicUpdateField<Integer>(0, 18);
   
    public DynamicUpdateField<Integer> runeforgePowers = new DynamicUpdateField<Integer>(0, 19);
   
    public DynamicUpdateField<Integer> transmogIllusions = new DynamicUpdateField<Integer>(0, 20);
    public DynamicUpdateField<spellPctModByLabel> spellPctModByLabel = new DynamicUpdateField<spellPctModByLabel>(0, 22);
    public DynamicUpdateField<spellFlatModByLabel> spellFlatModByLabel = new DynamicUpdateField<spellFlatModByLabel>(0, 23);
    public DynamicUpdateField<MAWPOWER> mawPowers = new DynamicUpdateField<MAWPOWER>(0, 24);
    public DynamicUpdateField<MultiFloorExplore> multiFloorExploration = new DynamicUpdateField<MultiFloorExplore>(0, 25);
    public DynamicUpdateField<recipeProgressionInfo> recipeProgression = new DynamicUpdateField<RecipeProgressionInfo>(0, 26);
    public DynamicUpdateField<ReplayedQuest> replayedQuests = new DynamicUpdateField<ReplayedQuest>(0, 27);
    public DynamicUpdateField<Integer> disabledSpells = new DynamicUpdateField<Integer>(0, 28);
    public DynamicUpdateField<PersonalCraftingOrderCount> personalCraftingOrderCounts = new DynamicUpdateField<PersonalCraftingOrderCount>(0, 31);
    public DynamicUpdateField<PVPInfo> pvpInfo = new DynamicUpdateField<PVPInfo>(0, 7);
    public DynamicUpdateField<CharacterRestriction> characterRestrictions = new DynamicUpdateField<CharacterRestriction>(0, 21);
    public DynamicUpdateField<TraitConfig> traitConfigs = new DynamicUpdateField<TraitConfig>(0, 29);
    public DynamicUpdateField<CraftingOrder> craftingOrders = new DynamicUpdateField<CraftingOrder>(0, 30);
    public UpdateField<ObjectGuid> farsightObject = new UpdateField<ObjectGuid>(34, 35);
    public UpdateField<ObjectGuid> summonedBattlePetGUID = new UpdateField<ObjectGuid>(34, 36);
   
    public UpdateField<Long> coinage = new UpdateField<Long>(34, 37);
   
    public UpdateField<Integer> XP = new UpdateField<Integer>(34, 38);
   
    public UpdateField<Integer> nextLevelXP = new UpdateField<Integer>(34, 39);
    public UpdateField<Integer> trialXP = new UpdateField<Integer>(34, 40);
    public UpdateField<skillInfo> skill = new UpdateField<SkillInfo>(34, 41);
   
    public UpdateField<Integer> characterPoints = new UpdateField<Integer>(34, 42);
   
    public UpdateField<Integer> maxTalentTiers = new UpdateField<Integer>(34, 43);
   
    public UpdateField<Integer> trackCreatureMask = new UpdateField<Integer>(34, 44);
    public UpdateField<Float> mainhandExpertise = new UpdateField<Float>(34, 45);
    public UpdateField<Float> offhandExpertise = new UpdateField<Float>(34, 46);
    public UpdateField<Float> rangedExpertise = new UpdateField<Float>(34, 47);
    public UpdateField<Float> combatRatingExpertise = new UpdateField<Float>(34, 48);
    public UpdateField<Float> blockPercentage = new UpdateField<Float>(34, 49);
    public UpdateField<Float> dodgePercentage = new UpdateField<Float>(34, 50);
    public UpdateField<Float> dodgePercentageFromAttribute = new UpdateField<Float>(34, 51);
    public UpdateField<Float> parryPercentage = new UpdateField<Float>(34, 52);
    public UpdateField<Float> parryPercentageFromAttribute = new UpdateField<Float>(34, 53);
    public UpdateField<Float> critPercentage = new UpdateField<Float>(34, 54);
    public UpdateField<Float> rangedCritPercentage = new UpdateField<Float>(34, 55);
    public UpdateField<Float> offhandCritPercentage = new UpdateField<Float>(34, 56);
    public UpdateField<Float> spellCritPercentage = new UpdateField<Float>(34, 57);
   
    public UpdateField<Integer> shieldBlock = new UpdateField<Integer>(34, 58);
    public UpdateField<Float> shieldBlockCritPercentage = new UpdateField<Float>(34, 59);
    public UpdateField<Float> mastery = new UpdateField<Float>(34, 60);
    public UpdateField<Float> speed = new UpdateField<Float>(34, 61);
    public UpdateField<Float> avoidance = new UpdateField<Float>(34, 62);
    public UpdateField<Float> sturdiness = new UpdateField<Float>(34, 63);
    public UpdateField<Integer> versatility = new UpdateField<Integer>(34, 64);
    public UpdateField<Float> versatilityBonus = new UpdateField<Float>(34, 65);
    public UpdateField<Float> pvpPowerDamage = new UpdateField<Float>(66, 67);
    public UpdateField<Float> pvpPowerHealing = new UpdateField<Float>(66, 68);
    public UpdateField<Integer> modHealingDonePos = new UpdateField<Integer>(66, 69);
    public UpdateField<Float> modHealingPercent = new UpdateField<Float>(66, 70);
    public UpdateField<Float> modPeriodicHealingDonePercent = new UpdateField<Float>(66, 71);
    public UpdateField<Float> modSpellPowerPercent = new UpdateField<Float>(66, 72);
    public UpdateField<Float> modResiliencePercent = new UpdateField<Float>(66, 73);
    public UpdateField<Float> overrideSpellPowerByAPPercent = new UpdateField<Float>(66, 74);
    public UpdateField<Float> overrideAPBySpellPowerPercent = new UpdateField<Float>(66, 75);
    public UpdateField<Integer> modTargetResistance = new UpdateField<Integer>(66, 76);
    public UpdateField<Integer> modTargetPhysicalResistance = new UpdateField<Integer>(66, 77);
   
    public UpdateField<Integer> localFlags = new UpdateField<Integer>(66, 78);
   
    public UpdateField<Byte> grantableLevels = new UpdateField<Byte>(66, 79);
   
    public UpdateField<Byte> multiActionBars = new UpdateField<Byte>(66, 80);
   
    public UpdateField<Byte> lifetimeMaxRank = new UpdateField<Byte>(66, 81);
   
    public UpdateField<Byte> numRespecs = new UpdateField<Byte>(66, 82);
   
    public UpdateField<Integer> pvpMedals = new UpdateField<Integer>(66, 83);
   
    public UpdateField<SHORT> todayHonorableKills = new UpdateField<SHORT>(66, 84);
   
    public UpdateField<SHORT> yesterdayHonorableKills = new UpdateField<SHORT>(66, 85);
   
    public UpdateField<Integer> lifetimeHonorableKills = new UpdateField<Integer>(66, 86);
   
    public UpdateField<Integer> watchedFactionIndex = new UpdateField<Integer>(66, 87);
    public UpdateField<Integer> maxLevel = new UpdateField<Integer>(66, 88);
    public UpdateField<Integer> scalingPlayerLevelDelta = new UpdateField<Integer>(66, 89);
    public UpdateField<Integer> maxCreatureScalingLevel = new UpdateField<Integer>(66, 90);
   
    public UpdateField<Integer> petSpellPower = new UpdateField<Integer>(66, 91);
    public UpdateField<Float> uiHitModifier = new UpdateField<Float>(66, 92);
    public UpdateField<Float> uiSpellHitModifier = new UpdateField<Float>(66, 93);
    public UpdateField<Integer> homeRealmTimeOffset = new UpdateField<Integer>(66, 94);
    public UpdateField<Float> modPetHaste = new UpdateField<Float>(66, 95);
    public UpdateField<Byte> jailersTowerLevelMax = new UpdateField<Byte>(66, 96);
    public UpdateField<Byte> jailersTowerLevel = new UpdateField<Byte>(66, 97);
   
    public UpdateField<Byte> localRegenFlags = new UpdateField<Byte>(98, 99);
   
    public UpdateField<Byte> auraVision = new UpdateField<Byte>(98, 100);
   
    public UpdateField<Byte> numBackpackSlots = new UpdateField<Byte>(98, 101);
   
    public UpdateField<Integer> overrideSpellsID = new UpdateField<Integer>(98, 102);
   
    public UpdateField<SHORT> lootSpecID = new UpdateField<SHORT>(98, 103);
   
    public UpdateField<Integer> overrideZonePVPType = new UpdateField<Integer>(98, 104);
    public UpdateField<ObjectGuid> bnetAccount = new UpdateField<ObjectGuid>(98, 105);
   
    public UpdateField<Long> guildClubMemberID = new UpdateField<Long>(98, 106);
   
    public UpdateField<Integer> honor = new UpdateField<Integer>(98, 107);
   
    public UpdateField<Integer> honorNextLevel = new UpdateField<Integer>(98, 108);
    public UpdateField<Integer> perksProgramCurrency = new UpdateField<Integer>(98, 109);
   
    public UpdateField<Byte> numBankSlots = new UpdateField<Byte>(98, 110);
    public UpdateField<PerksVendorItem> frozenPerksVendorItem = new UpdateField<PerksVendorItem>(98, 111);
    public UpdateField<ActivePlayerUnk901> field_1410 = new UpdateField<ActivePlayerUnk901>(98, 113);
    public OptionalUpdateField<questSession> questSession = new OptionalUpdateField<questSession>(98, 112);
    public UpdateField<Integer> uiChromieTimeExpansionID = new UpdateField<Integer>(98, 114);
    public UpdateField<Integer> transportServerTime = new UpdateField<Integer>(98, 115);
   
    public UpdateField<Integer> weeklyRewardsPeriodSinceOrigin = new UpdateField<Integer>(98, 116); // week count since Cfg_RegionsEntry::ChallengeOrigin
    public UpdateField<SHORT> DEBUGSoulbindConduitRank = new UpdateField<SHORT>(98, 117);
    public UpdateField<dungeonScoreData> dungeonScore = new UpdateField<DungeonScoreData>(98, 118);
   
    public UpdateField<Integer> activeCombatTraitConfigID = new UpdateField<Integer>(98, 119);
    public UpdateFieldArray<ObjectGuid> invSlots = new UpdateFieldArray<ObjectGuid>(218, 120, 121);
   
    public UpdateFieldArray<Long> exploredZones = new UpdateFieldArray<Long>(240, 339, 340);
    public UpdateFieldArray<restInfo> restInfo = new UpdateFieldArray<restInfo>(2, 580, 581);
    public UpdateFieldArray<Integer> modDamageDonePos = new UpdateFieldArray<Integer>(7, 583, 584);
    public UpdateFieldArray<Integer> modDamageDoneNeg = new UpdateFieldArray<Integer>(7, 583, 591);
    public UpdateFieldArray<Float> modDamageDonePercent = new UpdateFieldArray<Float>(7, 583, 598);
    public UpdateFieldArray<Float> modHealingDonePercent = new UpdateFieldArray<Float>(7, 583, 605);
    public UpdateFieldArray<Float> weaponDmgMultipliers = new UpdateFieldArray<Float>(3, 612, 613);
    public UpdateFieldArray<Float> weaponAtkSpeedMultipliers = new UpdateFieldArray<Float>(3, 612, 616);
   
    public UpdateFieldArray<Integer> buybackPrice = new UpdateFieldArray<Integer>(12, 619, 620);
   
    public UpdateFieldArray<Long> buybackTimestamp = new UpdateFieldArray<Long>(12, 619, 632);
   
    public UpdateFieldArray<Integer> combatRatings = new UpdateFieldArray<Integer>(32, 644, 645);
   
    public UpdateFieldArray<Integer> noReagentCostMask = new UpdateFieldArray<Integer>(4, 677, 678);
   
    public UpdateFieldArray<Integer> professionSkillLine = new UpdateFieldArray<Integer>(2, 682, 683);
   
    public UpdateFieldArray<Integer> bagSlotFlags = new UpdateFieldArray<Integer>(5, 685, 686);
   
    public UpdateFieldArray<Integer> bankBagSlotFlags = new UpdateFieldArray<Integer>(7, 691, 692);
   
    public UpdateFieldArray<Long> questCompleted = new UpdateFieldArray<Long>(875, 699, 700);

    public activePlayerData() {
        super(0, TypeId.activePlayer, 1575);
        EXPLOREDZONESSIZE = exploredZones.getSize();
        EXPLOREDZONESBITS = (Long.SIZE / Byte.SIZE) * 8;

        QUESTCOMPLETEDBITSSIZE = questCompleted.getSize();
        QUESTCOMPLETEDBITSPERBLOCK = (Long.SIZE / Byte.SIZE) * 8;
    }

    public final void writeCreate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, Player owner, Player receiver) {
        for (var i = 0; i < 218; ++i) {
            data.writeGuid(invSlots.get(i));
        }

        data.writeGuid(farsightObject);
        data.writeGuid(summonedBattlePetGUID);
        data.writeInt32(knownTitles.size());
        data.writeInt64(coinage);
        data.writeInt32(XP);
        data.writeInt32(nextLevelXP);
        data.writeInt32(trialXP);
        ((SkillInfo) skill).writeCreate(data, owner, receiver);
        data.writeInt32(characterPoints);
        data.writeInt32(maxTalentTiers);
        data.writeInt32(trackCreatureMask);
        data.writeFloat(mainhandExpertise);
        data.writeFloat(offhandExpertise);
        data.writeFloat(rangedExpertise);
        data.writeFloat(combatRatingExpertise);
        data.writeFloat(blockPercentage);
        data.writeFloat(dodgePercentage);
        data.writeFloat(dodgePercentageFromAttribute);
        data.writeFloat(parryPercentage);
        data.writeFloat(parryPercentageFromAttribute);
        data.writeFloat(critPercentage);
        data.writeFloat(rangedCritPercentage);
        data.writeFloat(offhandCritPercentage);
        data.writeFloat(spellCritPercentage);
        data.writeInt32(shieldBlock);
        data.writeFloat(shieldBlockCritPercentage);
        data.writeFloat(mastery);
        data.writeFloat(speed);
        data.writeFloat(avoidance);
        data.writeFloat(sturdiness);
        data.writeInt32(versatility);
        data.writeFloat(versatilityBonus);
        data.writeFloat(pvpPowerDamage);
        data.writeFloat(pvpPowerHealing);

        for (var i = 0; i < 240; ++i) {
            data.writeInt64(exploredZones.get(i));
        }

        for (var i = 0; i < 2; ++i) {
            restInfo.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < 7; ++i) {
            data.writeInt32(modDamageDonePos.get(i));
            data.writeInt32(modDamageDoneNeg.get(i));
            data.writeFloat(modDamageDonePercent.get(i));
            data.writeFloat(modHealingDonePercent.get(i));
        }

        data.writeInt32(modHealingDonePos);
        data.writeFloat(modHealingPercent);
        data.writeFloat(modPeriodicHealingDonePercent);

        for (var i = 0; i < 3; ++i) {
            data.writeFloat(weaponDmgMultipliers.get(i));
            data.writeFloat(weaponAtkSpeedMultipliers.get(i));
        }

        data.writeFloat(modSpellPowerPercent);
        data.writeFloat(modResiliencePercent);
        data.writeFloat(overrideSpellPowerByAPPercent);
        data.writeFloat(overrideAPBySpellPowerPercent);
        data.writeInt32(modTargetResistance);
        data.writeInt32(modTargetPhysicalResistance);
        data.writeInt32(localFlags);
        data.writeInt8(grantableLevels);
        data.writeInt8(multiActionBars);
        data.writeInt8(lifetimeMaxRank);
        data.writeInt8(numRespecs);
        data.writeInt32(pvpMedals);

        for (var i = 0; i < 12; ++i) {
            data.writeInt32(buybackPrice.get(i));
            data.writeInt64(buybackTimestamp.get(i));
        }

        data.writeInt16(todayHonorableKills);
        data.writeInt16(yesterdayHonorableKills);
        data.writeInt32(lifetimeHonorableKills);
        data.writeInt32(watchedFactionIndex);

        for (var i = 0; i < 32; ++i) {
            data.writeInt32(combatRatings.get(i));
        }

        data.writeInt32(pvpInfo.size());
        data.writeInt32(maxLevel);
        data.writeInt32(scalingPlayerLevelDelta);
        data.writeInt32(maxCreatureScalingLevel);

        for (var i = 0; i < 4; ++i) {
            data.writeInt32(noReagentCostMask.get(i));
        }

        data.writeInt32(petSpellPower);

        for (var i = 0; i < 2; ++i) {
            data.writeInt32(professionSkillLine.get(i));
        }

        data.writeFloat(uiHitModifier);
        data.writeFloat(uiSpellHitModifier);
        data.writeInt32(homeRealmTimeOffset);
        data.writeFloat(modPetHaste);
        data.writeInt8(jailersTowerLevelMax);
        data.writeInt8(jailersTowerLevel);
        data.writeInt8(localRegenFlags);
        data.writeInt8(auraVision);
        data.writeInt8(numBackpackSlots);
        data.writeInt32(overrideSpellsID);
        data.writeInt16(lootSpecID);
        data.writeInt32(overrideZonePVPType);
        data.writeGuid(bnetAccount);
        data.writeInt64(guildClubMemberID);

        for (var i = 0; i < 5; ++i) {
            data.writeInt32(bagSlotFlags.get(i));
        }

        for (var i = 0; i < 7; ++i) {
            data.writeInt32(bankBagSlotFlags.get(i));
        }

        for (var i = 0; i < 875; ++i) {
            data.writeInt64(questCompleted.get(i));
        }

        data.writeInt32(honor);
        data.writeInt32(honorNextLevel);
        data.writeInt32(perksProgramCurrency);
        data.writeInt8(numBankSlots);
        data.writeInt32(researchSites.size());
        data.writeInt32(researchSiteProgress.size());
        data.writeInt32(dailyQuestsCompleted.size());
        data.writeInt32(availableQuestLineXQuestIDs.size());
        data.writeInt32(heirlooms.size());
        data.writeInt32(heirloomFlags.size());
        data.writeInt32(toys.size());
        data.writeInt32(toyFlags.size());
        data.writeInt32(transmog.size());
        data.writeInt32(conditionalTransmog.size());
        data.writeInt32(selfResSpells.size());
        data.writeInt32(runeforgePowers.size());
        data.writeInt32(transmogIllusions.size());
        data.writeInt32(characterRestrictions.size());
        data.writeInt32(spellPctModByLabel.size());
        data.writeInt32(spellFlatModByLabel.size());

        for (var i = 0; i < 1; ++i) {
            data.writeInt32(research.get(i).size());

            for (var j = 0; j < research.get(i).size(); ++j) {
                research.get(i)[j].writeCreate(data, owner, receiver);
            }
        }

        data.writeInt32(mawPowers.size());
        data.writeInt32(multiFloorExploration.size());
        data.writeInt32(recipeProgression.size());
        data.writeInt32(replayedQuests.size());
        data.writeInt32(disabledSpells.size());
        data.writeInt32(uiChromieTimeExpansionID);
        data.writeInt32(transportServerTime);
        data.writeInt32(weeklyRewardsPeriodSinceOrigin);
        data.writeInt16(DEBUGSoulbindConduitRank);
        data.writeInt32(traitConfigs.size());
        data.writeInt32(activeCombatTraitConfigID);
        data.writeInt32(craftingOrders.size());
        data.writeInt32(personalCraftingOrderCounts.size());

        for (var i = 0; i < knownTitles.size(); ++i) {
            data.writeInt64(knownTitles.get(i));
        }

        for (var i = 0; i < researchSites.size(); ++i) {
            data.writeInt16(researchSites.get(i));
        }

        for (var i = 0; i < researchSiteProgress.size(); ++i) {
            data.writeInt32(researchSiteProgress.get(i));
        }

        for (var i = 0; i < dailyQuestsCompleted.size(); ++i) {
            data.writeInt32(dailyQuestsCompleted.get(i));
        }

        for (var i = 0; i < availableQuestLineXQuestIDs.size(); ++i) {
            data.writeInt32(availableQuestLineXQuestIDs.get(i));
        }

        for (var i = 0; i < heirlooms.size(); ++i) {
            data.writeInt32(heirlooms.get(i));
        }

        for (var i = 0; i < heirloomFlags.size(); ++i) {
            data.writeInt32(heirloomFlags.get(i));
        }

        for (var i = 0; i < toys.size(); ++i) {
            data.writeInt32(toys.get(i));
        }

        for (var i = 0; i < toyFlags.size(); ++i) {
            data.writeInt32(toyFlags.get(i));
        }

        for (var i = 0; i < transmog.size(); ++i) {
            data.writeInt32(transmog.get(i));
        }

        for (var i = 0; i < conditionalTransmog.size(); ++i) {
            data.writeInt32(conditionalTransmog.get(i));
        }

        for (var i = 0; i < selfResSpells.size(); ++i) {
            data.writeInt32(selfResSpells.get(i));
        }

        for (var i = 0; i < runeforgePowers.size(); ++i) {
            data.writeInt32(runeforgePowers.get(i));
        }

        for (var i = 0; i < transmogIllusions.size(); ++i) {
            data.writeInt32(transmogIllusions.get(i));
        }

        for (var i = 0; i < spellPctModByLabel.size(); ++i) {
            spellPctModByLabel.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < spellFlatModByLabel.size(); ++i) {
            spellFlatModByLabel.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < mawPowers.size(); ++i) {
            mawPowers.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < multiFloorExploration.size(); ++i) {
            multiFloorExploration.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < recipeProgression.size(); ++i) {
            recipeProgression.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < replayedQuests.size(); ++i) {
            replayedQuests.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < disabledSpells.size(); ++i) {
            data.writeInt32(disabledSpells.get(i));
        }

        for (var i = 0; i < personalCraftingOrderCounts.size(); ++i) {
            personalCraftingOrderCounts.get(i).writeCreate(data, owner, receiver);
        }

        data.flushBits();
        data.writeBit(backpackAutoSortDisabled);
        data.writeBit(bankAutoSortDisabled);
        data.writeBit(sortBagsRightToLeft);
        data.writeBit(insertItemsLeftToRight);
        data.writeBit(hasPerksProgramPendingReward);
        data.writeBits(questSession.hasValue(), 1);
        frozenPerksVendorItem.getValue().write(data);

        if (questSession.hasValue()) {
            questSession.getValue().writeCreate(data, owner, receiver);
        }

        ((ActivePlayerUnk901) field_1410).writeCreate(data, owner, receiver);
        dungeonScore.getValue().write(data);

        for (var i = 0; i < pvpInfo.size(); ++i) {
            pvpInfo.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < characterRestrictions.size(); ++i) {
            characterRestrictions.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < traitConfigs.size(); ++i) {
            traitConfigs.get(i).writeCreate(data, owner, receiver);
        }

        for (var i = 0; i < craftingOrders.size(); ++i) {
            craftingOrders.get(i).writeCreate(data, owner, receiver);
        }

        data.flushBits();
    }

    public final void writeUpdate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, Player owner, Player receiver) {
        writeUpdate(data, getChangesMask(), false, owner, receiver);
    }

    public final void writeUpdate(WorldPacket data, UpdateMask changesMask, boolean ignoreNestedChangesMask, Player owner, Player receiver) {
        for (int i = 0; i < 1; ++i) {
            data.writeInt32(changesMask.getBlocksMask(i));
        }

        data.writeBits(changesMask.getBlocksMask(1), 18);

        for (int i = 0; i < 50; ++i) {
            if (changesMask.getBlock(i) != 0) {
                data.writeBits(changesMask.getBlock(i), 32);
            }
        }

        if (changesMask.get(0)) {
            if (changesMask.get(1)) {
                data.writeBit(backpackAutoSortDisabled);
            }

            if (changesMask.get(2)) {
                data.writeBit(bankAutoSortDisabled);
            }

            if (changesMask.get(3)) {
                data.writeBit(sortBagsRightToLeft);
            }

            if (changesMask.get(4)) {
                data.writeBit(insertItemsLeftToRight);
            }

            if (changesMask.get(5)) {
                data.writeBit(hasPerksProgramPendingReward);
            }

            if (changesMask.get(6)) {
                if (!ignoreNestedChangesMask) {
                    knownTitles.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(knownTitles.size(), data);
                }
            }

            if (changesMask.get(7)) {
                if (!ignoreNestedChangesMask) {
                    pvpInfo.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(pvpInfo.size(), data);
                }
            }

            if (changesMask.get(8)) {
                if (!ignoreNestedChangesMask) {
                    researchSites.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(researchSites.size(), data);
                }
            }

            if (changesMask.get(9)) {
                if (!ignoreNestedChangesMask) {
                    researchSiteProgress.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(researchSiteProgress.size(), data);
                }
            }

            if (changesMask.get(10)) {
                if (!ignoreNestedChangesMask) {
                    dailyQuestsCompleted.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(dailyQuestsCompleted.size(), data);
                }
            }

            if (changesMask.get(11)) {
                if (!ignoreNestedChangesMask) {
                    availableQuestLineXQuestIDs.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(availableQuestLineXQuestIDs.size(), data);
                }
            }

            if (changesMask.get(12)) {
                if (!ignoreNestedChangesMask) {
                    heirlooms.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(heirlooms.size(), data);
                }
            }

            if (changesMask.get(13)) {
                if (!ignoreNestedChangesMask) {
                    heirloomFlags.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(heirloomFlags.size(), data);
                }
            }

            if (changesMask.get(14)) {
                if (!ignoreNestedChangesMask) {
                    toys.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(toys.size(), data);
                }
            }

            if (changesMask.get(15)) {
                if (!ignoreNestedChangesMask) {
                    toyFlags.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(toyFlags.size(), data);
                }
            }

            if (changesMask.get(16)) {
                if (!ignoreNestedChangesMask) {
                    transmog.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(transmog.size(), data);
                }
            }

            if (changesMask.get(17)) {
                if (!ignoreNestedChangesMask) {
                    conditionalTransmog.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(conditionalTransmog.size(), data);
                }
            }

            if (changesMask.get(18)) {
                if (!ignoreNestedChangesMask) {
                    selfResSpells.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(selfResSpells.size(), data);
                }
            }

            if (changesMask.get(19)) {
                if (!ignoreNestedChangesMask) {
                    runeforgePowers.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(runeforgePowers.size(), data);
                }
            }

            if (changesMask.get(20)) {
                if (!ignoreNestedChangesMask) {
                    transmogIllusions.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(transmogIllusions.size(), data);
                }
            }

            if (changesMask.get(21)) {
                if (!ignoreNestedChangesMask) {
                    characterRestrictions.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(characterRestrictions.size(), data);
                }
            }

            if (changesMask.get(22)) {
                if (!ignoreNestedChangesMask) {
                    spellPctModByLabel.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(spellPctModByLabel.size(), data);
                }
            }

            if (changesMask.get(23)) {
                if (!ignoreNestedChangesMask) {
                    spellFlatModByLabel.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(spellFlatModByLabel.size(), data);
                }
            }
        }

        if (changesMask.get(32)) {
            for (var i = 0; i < 1; ++i) {
                if (changesMask.get(33 + i)) {
                    if (!ignoreNestedChangesMask) {
                        research.get(i).WriteUpdateMask(data);
                    } else {
                        writeCompleteDynamicFieldUpdateMask(research.get(i).size(), data);
                    }

                    for (var j = 0; j < research.get(i).size(); ++j) {
                        if (research.get(i).hasChanged(j) || ignoreNestedChangesMask) {
                            research.get(i)[j].writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                        }
                    }
                }
            }
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(24)) {
                if (!ignoreNestedChangesMask) {
                    mawPowers.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(mawPowers.size(), data);
                }
            }

            if (changesMask.get(25)) {
                if (!ignoreNestedChangesMask) {
                    multiFloorExploration.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(multiFloorExploration.size(), data);
                }
            }

            if (changesMask.get(26)) {
                if (!ignoreNestedChangesMask) {
                    recipeProgression.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(recipeProgression.size(), data);
                }
            }

            if (changesMask.get(27)) {
                if (!ignoreNestedChangesMask) {
                    replayedQuests.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(replayedQuests.size(), data);
                }
            }

            if (changesMask.get(28)) {
                if (!ignoreNestedChangesMask) {
                    disabledSpells.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(disabledSpells.size(), data);
                }
            }

            if (changesMask.get(29)) {
                if (!ignoreNestedChangesMask) {
                    traitConfigs.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(traitConfigs.size(), data);
                }
            }

            if (changesMask.get(30)) {
                if (!ignoreNestedChangesMask) {
                    craftingOrders.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(craftingOrders.size(), data);
                }
            }

            if (changesMask.get(31)) {
                if (!ignoreNestedChangesMask) {
                    personalCraftingOrderCounts.WriteUpdateMask(data);
                } else {
                    writeCompleteDynamicFieldUpdateMask(personalCraftingOrderCounts.size(), data);
                }
            }
        }

        data.flushBits();

        if (changesMask.get(0)) {
            if (changesMask.get(6)) {
                for (var i = 0; i < knownTitles.size(); ++i) {
                    if (knownTitles.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt64(knownTitles.get(i));
                    }
                }
            }

            if (changesMask.get(8)) {
                for (var i = 0; i < researchSites.size(); ++i) {
                    if (researchSites.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt16(researchSites.get(i));
                    }
                }
            }

            if (changesMask.get(9)) {
                for (var i = 0; i < researchSiteProgress.size(); ++i) {
                    if (researchSiteProgress.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(researchSiteProgress.get(i));
                    }
                }
            }

            if (changesMask.get(10)) {
                for (var i = 0; i < dailyQuestsCompleted.size(); ++i) {
                    if (dailyQuestsCompleted.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(dailyQuestsCompleted.get(i));
                    }
                }
            }

            if (changesMask.get(11)) {
                for (var i = 0; i < availableQuestLineXQuestIDs.size(); ++i) {
                    if (availableQuestLineXQuestIDs.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(availableQuestLineXQuestIDs.get(i));
                    }
                }
            }

            if (changesMask.get(12)) {
                for (var i = 0; i < heirlooms.size(); ++i) {
                    if (heirlooms.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(heirlooms.get(i));
                    }
                }
            }

            if (changesMask.get(13)) {
                for (var i = 0; i < heirloomFlags.size(); ++i) {
                    if (heirloomFlags.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(heirloomFlags.get(i));
                    }
                }
            }

            if (changesMask.get(14)) {
                for (var i = 0; i < toys.size(); ++i) {
                    if (toys.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(toys.get(i));
                    }
                }
            }

            if (changesMask.get(15)) {
                for (var i = 0; i < toyFlags.size(); ++i) {
                    if (toyFlags.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(toyFlags.get(i));
                    }
                }
            }

            if (changesMask.get(16)) {
                for (var i = 0; i < transmog.size(); ++i) {
                    if (transmog.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(transmog.get(i));
                    }
                }
            }

            if (changesMask.get(17)) {
                for (var i = 0; i < conditionalTransmog.size(); ++i) {
                    if (conditionalTransmog.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(conditionalTransmog.get(i));
                    }
                }
            }

            if (changesMask.get(18)) {
                for (var i = 0; i < selfResSpells.size(); ++i) {
                    if (selfResSpells.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(selfResSpells.get(i));
                    }
                }
            }

            if (changesMask.get(19)) {
                for (var i = 0; i < runeforgePowers.size(); ++i) {
                    if (runeforgePowers.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(runeforgePowers.get(i));
                    }
                }
            }

            if (changesMask.get(20)) {
                for (var i = 0; i < transmogIllusions.size(); ++i) {
                    if (transmogIllusions.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(transmogIllusions.get(i));
                    }
                }
            }

            if (changesMask.get(22)) {
                for (var i = 0; i < spellPctModByLabel.size(); ++i) {
                    if (spellPctModByLabel.hasChanged(i) || ignoreNestedChangesMask) {
                        spellPctModByLabel.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(23)) {
                for (var i = 0; i < spellFlatModByLabel.size(); ++i) {
                    if (spellFlatModByLabel.hasChanged(i) || ignoreNestedChangesMask) {
                        spellFlatModByLabel.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(24)) {
                for (var i = 0; i < mawPowers.size(); ++i) {
                    if (mawPowers.hasChanged(i) || ignoreNestedChangesMask) {
                        mawPowers.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(25)) {
                for (var i = 0; i < multiFloorExploration.size(); ++i) {
                    if (multiFloorExploration.hasChanged(i) || ignoreNestedChangesMask) {
                        multiFloorExploration.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(26)) {
                for (var i = 0; i < recipeProgression.size(); ++i) {
                    if (recipeProgression.hasChanged(i) || ignoreNestedChangesMask) {
                        recipeProgression.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(27)) {
                for (var i = 0; i < replayedQuests.size(); ++i) {
                    if (replayedQuests.hasChanged(i) || ignoreNestedChangesMask) {
                        replayedQuests.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(28)) {
                for (var i = 0; i < disabledSpells.size(); ++i) {
                    if (disabledSpells.hasChanged(i) || ignoreNestedChangesMask) {
                        data.writeInt32(disabledSpells.get(i));
                    }
                }
            }

            if (changesMask.get(31)) {
                for (var i = 0; i < personalCraftingOrderCounts.size(); ++i) {
                    if (personalCraftingOrderCounts.hasChanged(i) || ignoreNestedChangesMask) {
                        personalCraftingOrderCounts.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(7)) {
                for (var i = 0; i < pvpInfo.size(); ++i) {
                    if (pvpInfo.hasChanged(i) || ignoreNestedChangesMask) {
                        pvpInfo.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(21)) {
                for (var i = 0; i < characterRestrictions.size(); ++i) {
                    if (characterRestrictions.hasChanged(i) || ignoreNestedChangesMask) {
                        characterRestrictions.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(29)) {
                for (var i = 0; i < traitConfigs.size(); ++i) {
                    if (traitConfigs.hasChanged(i) || ignoreNestedChangesMask) {
                        traitConfigs.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }

            if (changesMask.get(30)) {
                for (var i = 0; i < craftingOrders.size(); ++i) {
                    if (craftingOrders.hasChanged(i) || ignoreNestedChangesMask) {
                        craftingOrders.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                    }
                }
            }
        }

        if (changesMask.get(34)) {
            if (changesMask.get(35)) {
                data.writeGuid(farsightObject);
            }

            if (changesMask.get(36)) {
                data.writeGuid(summonedBattlePetGUID);
            }

            if (changesMask.get(37)) {
                data.writeInt64(coinage);
            }

            if (changesMask.get(38)) {
                data.writeInt32(XP);
            }

            if (changesMask.get(39)) {
                data.writeInt32(nextLevelXP);
            }

            if (changesMask.get(40)) {
                data.writeInt32(trialXP);
            }

            if (changesMask.get(41)) {
                ((SkillInfo) skill).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
            }

            if (changesMask.get(42)) {
                data.writeInt32(characterPoints);
            }

            if (changesMask.get(43)) {
                data.writeInt32(maxTalentTiers);
            }

            if (changesMask.get(44)) {
                data.writeInt32(trackCreatureMask);
            }

            if (changesMask.get(45)) {
                data.writeFloat(mainhandExpertise);
            }

            if (changesMask.get(46)) {
                data.writeFloat(offhandExpertise);
            }

            if (changesMask.get(47)) {
                data.writeFloat(rangedExpertise);
            }

            if (changesMask.get(48)) {
                data.writeFloat(combatRatingExpertise);
            }

            if (changesMask.get(49)) {
                data.writeFloat(blockPercentage);
            }

            if (changesMask.get(50)) {
                data.writeFloat(dodgePercentage);
            }

            if (changesMask.get(51)) {
                data.writeFloat(dodgePercentageFromAttribute);
            }

            if (changesMask.get(52)) {
                data.writeFloat(parryPercentage);
            }

            if (changesMask.get(53)) {
                data.writeFloat(parryPercentageFromAttribute);
            }

            if (changesMask.get(54)) {
                data.writeFloat(critPercentage);
            }

            if (changesMask.get(55)) {
                data.writeFloat(rangedCritPercentage);
            }

            if (changesMask.get(56)) {
                data.writeFloat(offhandCritPercentage);
            }

            if (changesMask.get(57)) {
                data.writeFloat(spellCritPercentage);
            }

            if (changesMask.get(58)) {
                data.writeInt32(shieldBlock);
            }

            if (changesMask.get(59)) {
                data.writeFloat(shieldBlockCritPercentage);
            }

            if (changesMask.get(60)) {
                data.writeFloat(mastery);
            }

            if (changesMask.get(61)) {
                data.writeFloat(speed);
            }

            if (changesMask.get(62)) {
                data.writeFloat(avoidance);
            }

            if (changesMask.get(63)) {
                data.writeFloat(sturdiness);
            }

            if (changesMask.get(64)) {
                data.writeInt32(versatility);
            }

            if (changesMask.get(65)) {
                data.writeFloat(versatilityBonus);
            }
        }

        if (changesMask.get(66)) {
            if (changesMask.get(67)) {
                data.writeFloat(pvpPowerDamage);
            }

            if (changesMask.get(68)) {
                data.writeFloat(pvpPowerHealing);
            }

            if (changesMask.get(69)) {
                data.writeInt32(modHealingDonePos);
            }

            if (changesMask.get(70)) {
                data.writeFloat(modHealingPercent);
            }

            if (changesMask.get(71)) {
                data.writeFloat(modPeriodicHealingDonePercent);
            }

            if (changesMask.get(72)) {
                data.writeFloat(modSpellPowerPercent);
            }

            if (changesMask.get(73)) {
                data.writeFloat(modResiliencePercent);
            }

            if (changesMask.get(74)) {
                data.writeFloat(overrideSpellPowerByAPPercent);
            }

            if (changesMask.get(75)) {
                data.writeFloat(overrideAPBySpellPowerPercent);
            }

            if (changesMask.get(76)) {
                data.writeInt32(modTargetResistance);
            }

            if (changesMask.get(77)) {
                data.writeInt32(modTargetPhysicalResistance);
            }

            if (changesMask.get(78)) {
                data.writeInt32(localFlags);
            }

            if (changesMask.get(79)) {
                data.writeInt8(grantableLevels);
            }

            if (changesMask.get(80)) {
                data.writeInt8(multiActionBars);
            }

            if (changesMask.get(81)) {
                data.writeInt32(lifetimeMaxRank);
            }

            if (changesMask.get(82)) {
                data.writeInt16(numRespecs);
            }

            if (changesMask.get(83)) {
                data.writeInt32(pvpMedals);
            }

            if (changesMask.get(84)) {
                data.writeInt32(todayHonorableKills);
            }

            if (changesMask.get(85)) {
                data.writeInt32(yesterdayHonorableKills);
            }

            if (changesMask.get(86)) {
                data.writeInt32(lifetimeHonorableKills);
            }

            if (changesMask.get(87)) {
                data.writeInt32(watchedFactionIndex);
            }

            if (changesMask.get(88)) {
                data.writeInt32(maxLevel);
            }

            if (changesMask.get(89)) {
                data.writeInt32(scalingPlayerLevelDelta);
            }

            if (changesMask.get(90)) {
                data.writeInt32(maxCreatureScalingLevel);
            }

            if (changesMask.get(91)) {
                data.writeInt32(petSpellPower);
            }

            if (changesMask.get(92)) {
                data.writeFloat(uiHitModifier);
            }

            if (changesMask.get(93)) {
                data.writeFloat(uiSpellHitModifier);
            }

            if (changesMask.get(94)) {
                data.writeInt32(homeRealmTimeOffset);
            }

            if (changesMask.get(95)) {
                data.writeFloat(modPetHaste);
            }

            if (changesMask.get(96)) {
                data.writeInt8(jailersTowerLevelMax);
            }

            if (changesMask.get(97)) {
                data.writeInt8(jailersTowerLevel);
            }
        }

        if (changesMask.get(98)) {
            if (changesMask.get(99)) {
                data.writeInt8(localRegenFlags);
            }

            if (changesMask.get(100)) {
                data.writeInt32(auraVision);
            }

            if (changesMask.get(101)) {
                data.writeInt16(numBackpackSlots);
            }

            if (changesMask.get(102)) {
                data.writeInt32(overrideSpellsID);
            }

            if (changesMask.get(103)) {
                data.writeInt16(lootSpecID);
            }

            if (changesMask.get(104)) {
                data.writeInt64(overrideZonePVPType);
            }

            if (changesMask.get(105)) {
                data.writeGuid(bnetAccount);
            }

            if (changesMask.get(106)) {
                data.writeInt64(guildClubMemberID);
            }

            if (changesMask.get(107)) {
                data.writeInt32(honor);
            }

            if (changesMask.get(108)) {
                data.writeInt32(honorNextLevel);
            }

            if (changesMask.get(109)) {
                data.writeInt32(perksProgramCurrency);
            }

            if (changesMask.get(110)) {
                data.writeInt32(numBankSlots);
            }

            if (changesMask.get(114)) {
                data.writeInt32(uiChromieTimeExpansionID);
            }

            if (changesMask.get(115)) {
                data.writeInt32(transportServerTime);
            }

            if (changesMask.get(116)) {
                data.writeInt32(weeklyRewardsPeriodSinceOrigin);
            }

            if (changesMask.get(117)) {
                data.writeInt16(DEBUGSoulbindConduitRank);
            }

            if (changesMask.get(119)) {
                data.writeInt32(activeCombatTraitConfigID);
            }
        }

        if (changesMask.get(98)) {
            data.writeBits(questSession.hasValue(), 1);

            if (changesMask.get(111)) {
                frozenPerksVendorItem.getValue().write(data);
            }

            if (changesMask.get(112)) {
                if (questSession.hasValue()) {
                    questSession.getValue().writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                }
            }

            if (changesMask.get(113)) {
                ((ActivePlayerUnk901) field_1410).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
            }

            if (changesMask.get(118)) {
                dungeonScore.getValue().write(data);
            }
        }

        if (changesMask.get(120)) {
            for (var i = 0; i < 218; ++i) {
                if (changesMask.get(121 + i)) {
                    data.writeGuid(invSlots.get(i));
                }
            }
        }

        if (changesMask.get(339)) {
            for (var i = 0; i < 240; ++i) {
                if (changesMask.get(340 + i)) {
                    data.writeInt64(exploredZones.get(i));
                }
            }
        }

        if (changesMask.get(580)) {
            for (var i = 0; i < 2; ++i) {
                if (changesMask.get(581 + i)) {
                    restInfo.get(i).writeUpdate(data, ignoreNestedChangesMask, owner, receiver);
                }
            }
        }

        if (changesMask.get(583)) {
            for (var i = 0; i < 7; ++i) {
                if (changesMask.get(584 + i)) {
                    data.writeInt32(modDamageDonePos.get(i));
                }

                if (changesMask.get(591 + i)) {
                    data.writeInt32(modDamageDoneNeg.get(i));
                }

                if (changesMask.get(598 + i)) {
                    data.writeFloat(modDamageDonePercent.get(i));
                }

                if (changesMask.get(605 + i)) {
                    data.writeFloat(modHealingDonePercent.get(i));
                }
            }
        }

        if (changesMask.get(612)) {
            for (var i = 0; i < 3; ++i) {
                if (changesMask.get(613 + i)) {
                    data.writeFloat(weaponDmgMultipliers.get(i));
                }

                if (changesMask.get(616 + i)) {
                    data.writeFloat(weaponAtkSpeedMultipliers.get(i));
                }
            }
        }

        if (changesMask.get(619)) {
            for (var i = 0; i < 12; ++i) {
                if (changesMask.get(620 + i)) {
                    data.writeInt32(buybackPrice.get(i));
                }

                if (changesMask.get(632 + i)) {
                    data.writeInt64(buybackTimestamp.get(i));
                }
            }
        }

        if (changesMask.get(644)) {
            for (var i = 0; i < 32; ++i) {
                if (changesMask.get(645 + i)) {
                    data.writeInt32(combatRatings.get(i));
                }
            }
        }

        if (changesMask.get(677)) {
            for (var i = 0; i < 4; ++i) {
                if (changesMask.get(678 + i)) {
                    data.writeInt32(noReagentCostMask.get(i));
                }
            }
        }

        if (changesMask.get(682)) {
            for (var i = 0; i < 2; ++i) {
                if (changesMask.get(683 + i)) {
                    data.writeInt32(professionSkillLine.get(i));
                }
            }
        }

        if (changesMask.get(685)) {
            for (var i = 0; i < 5; ++i) {
                if (changesMask.get(686 + i)) {
                    data.writeInt32(bagSlotFlags.get(i));
                }
            }
        }

        if (changesMask.get(691)) {
            for (var i = 0; i < 7; ++i) {
                if (changesMask.get(692 + i)) {
                    data.writeInt32(bankBagSlotFlags.get(i));
                }
            }
        }

        if (changesMask.get(699)) {
            for (var i = 0; i < 875; ++i) {
                if (changesMask.get(700 + i)) {
                    data.writeInt64(questCompleted.get(i));
                }
            }
        }

        data.flushBits();
    }

    @Override
    public void clearChangesMask() {
        clearChangesMask(backpackAutoSortDisabled);
        clearChangesMask(bankAutoSortDisabled);
        clearChangesMask(sortBagsRightToLeft);
        clearChangesMask(insertItemsLeftToRight);
        clearChangesMask(hasPerksProgramPendingReward);
        clearChangesMask(research);
        clearChangesMask(knownTitles);
        clearChangesMask(researchSites);
        clearChangesMask(researchSiteProgress);
        clearChangesMask(dailyQuestsCompleted);
        clearChangesMask(availableQuestLineXQuestIDs);
        clearChangesMask(heirlooms);
        clearChangesMask(heirloomFlags);
        clearChangesMask(toys);
        clearChangesMask(toyFlags);
        clearChangesMask(transmog);
        clearChangesMask(conditionalTransmog);
        clearChangesMask(selfResSpells);
        clearChangesMask(runeforgePowers);
        clearChangesMask(transmogIllusions);
        clearChangesMask(spellPctModByLabel);
        clearChangesMask(spellFlatModByLabel);
        clearChangesMask(mawPowers);
        clearChangesMask(multiFloorExploration);
        clearChangesMask(recipeProgression);
        clearChangesMask(replayedQuests);
        clearChangesMask(disabledSpells);
        clearChangesMask(personalCraftingOrderCounts);
        clearChangesMask(pvpInfo);
        clearChangesMask(characterRestrictions);
        clearChangesMask(traitConfigs);
        clearChangesMask(craftingOrders);
        clearChangesMask(farsightObject);
        clearChangesMask(summonedBattlePetGUID);
        clearChangesMask(coinage);
        clearChangesMask(XP);
        clearChangesMask(nextLevelXP);
        clearChangesMask(trialXP);
        clearChangesMask(skill);
        clearChangesMask(characterPoints);
        clearChangesMask(maxTalentTiers);
        clearChangesMask(trackCreatureMask);
        clearChangesMask(mainhandExpertise);
        clearChangesMask(offhandExpertise);
        clearChangesMask(rangedExpertise);
        clearChangesMask(combatRatingExpertise);
        clearChangesMask(blockPercentage);
        clearChangesMask(dodgePercentage);
        clearChangesMask(dodgePercentageFromAttribute);
        clearChangesMask(parryPercentage);
        clearChangesMask(parryPercentageFromAttribute);
        clearChangesMask(critPercentage);
        clearChangesMask(rangedCritPercentage);
        clearChangesMask(offhandCritPercentage);
        clearChangesMask(spellCritPercentage);
        clearChangesMask(shieldBlock);
        clearChangesMask(shieldBlockCritPercentage);
        clearChangesMask(mastery);
        clearChangesMask(speed);
        clearChangesMask(avoidance);
        clearChangesMask(sturdiness);
        clearChangesMask(versatility);
        clearChangesMask(versatilityBonus);
        clearChangesMask(pvpPowerDamage);
        clearChangesMask(pvpPowerHealing);
        clearChangesMask(modHealingDonePos);
        clearChangesMask(modHealingPercent);
        clearChangesMask(modPeriodicHealingDonePercent);
        clearChangesMask(modSpellPowerPercent);
        clearChangesMask(modResiliencePercent);
        clearChangesMask(overrideSpellPowerByAPPercent);
        clearChangesMask(overrideAPBySpellPowerPercent);
        clearChangesMask(modTargetResistance);
        clearChangesMask(modTargetPhysicalResistance);
        clearChangesMask(localFlags);
        clearChangesMask(grantableLevels);
        clearChangesMask(multiActionBars);
        clearChangesMask(lifetimeMaxRank);
        clearChangesMask(numRespecs);
        clearChangesMask(pvpMedals);
        clearChangesMask(todayHonorableKills);
        clearChangesMask(yesterdayHonorableKills);
        clearChangesMask(lifetimeHonorableKills);
        clearChangesMask(watchedFactionIndex);
        clearChangesMask(maxLevel);
        clearChangesMask(scalingPlayerLevelDelta);
        clearChangesMask(maxCreatureScalingLevel);
        clearChangesMask(petSpellPower);
        clearChangesMask(uiHitModifier);
        clearChangesMask(uiSpellHitModifier);
        clearChangesMask(homeRealmTimeOffset);
        clearChangesMask(modPetHaste);
        clearChangesMask(jailersTowerLevelMax);
        clearChangesMask(jailersTowerLevel);
        clearChangesMask(localRegenFlags);
        clearChangesMask(auraVision);
        clearChangesMask(numBackpackSlots);
        clearChangesMask(overrideSpellsID);
        clearChangesMask(lootSpecID);
        clearChangesMask(overrideZonePVPType);
        clearChangesMask(bnetAccount);
        clearChangesMask(guildClubMemberID);
        clearChangesMask(honor);
        clearChangesMask(honorNextLevel);
        clearChangesMask(perksProgramCurrency);
        clearChangesMask(numBankSlots);
        clearChangesMask(frozenPerksVendorItem);
        clearChangesMask(field_1410);
        clearChangesMask(questSession);
        clearChangesMask(uiChromieTimeExpansionID);
        clearChangesMask(transportServerTime);
        clearChangesMask(weeklyRewardsPeriodSinceOrigin);
        clearChangesMask(DEBUGSoulbindConduitRank);
        clearChangesMask(dungeonScore);
        clearChangesMask(activeCombatTraitConfigID);
        clearChangesMask(invSlots);
        clearChangesMask(exploredZones);
        clearChangesMask(restInfo);
        clearChangesMask(modDamageDonePos);
        clearChangesMask(modDamageDoneNeg);
        clearChangesMask(modDamageDonePercent);
        clearChangesMask(modHealingDonePercent);
        clearChangesMask(weaponDmgMultipliers);
        clearChangesMask(weaponAtkSpeedMultipliers);
        clearChangesMask(buybackPrice);
        clearChangesMask(buybackTimestamp);
        clearChangesMask(combatRatings);
        clearChangesMask(noReagentCostMask);
        clearChangesMask(professionSkillLine);
        clearChangesMask(bagSlotFlags);
        clearChangesMask(bankBagSlotFlags);
        clearChangesMask(questCompleted);
        getChangesMask().resetAll();
    }
}
