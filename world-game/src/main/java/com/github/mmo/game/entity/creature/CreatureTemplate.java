package com.github.mmo.game.entity.creature;


import com.github.mmo.common.EnumFlag;
import com.github.mmo.defines.CreatureFamily;
import com.github.mmo.defines.CreatureType;
import com.github.mmo.defines.CreatureTypeFlags;
import com.github.mmo.defines.PlayerClass;
import com.github.mmo.game.entity.unit.enums.UnitFlag;
import com.github.mmo.game.networking.packet.CreatureStats;
import com.github.mmo.game.networking.packet.CreatureXDisplay;
import com.github.mmo.game.networking.packet.QueryCreatureResponse;

import java.util.ArrayList;
import java.util.HashMap;


public class CreatureTemplate {
    public int entry;
    public int[] difficultyEntry = new int[SharedConst.MaxCreatureDifficulties];
    public int[] killCredit = new int[SharedConst.MaxCreatureKillCredit];
    public ArrayList<CreatureModel> models = new ArrayList<>();
    public String name;
    public String femaleName;
    public String subName;
    public String titleAlt;
    public String iconName;
    public int gossipMenuId;
    public short minlevel;
    public HashMap<Difficulty, CreatureLevelScaling> scalingStorage = new HashMap<Difficulty, CreatureLevelScaling>();
    public short maxlevel;
    public int healthScalingExpansion;
    public int requiredExpansion;
    public int vignetteID; // @todo Read Vignette.db2
    public int faction;
    public long npcflag;
    public float speedWalk;
    public float speedRun;
    public float scale;
    public CreatureClassification rank = CreatureClassification.values()[0];
    public int dmgSchool;
    public int baseAttackTime;
    public int rangeAttackTime;
    public float baseVariance;
    public float rangeVariance;
    public int unitClass;
    public UnitFlag unitFlags;
    public int unitFlags2;
    public int unitFlags3;
    public int dynamicFlags;
    public CreatureFamily family;
    public PlayerClass trainerClass;
    public CreatureType creatureType;
    public EnumFlag<CreatureTypeFlags> typeFlags;
    public int typeFlags2;
    public int lootId;
    public int pickPocketId;
    public int skinLootId;
    public int[] resistance = new int[7];
    public int[] spells = new int[8];
    public int vehicleId;
    public int minGold;
    public int maxGold;
    public String AIName;
    public int movementType;
    public CreatureMovementData movement = new CreatureMovementData();
    public float hoverHeight;
    public float modHealth;
    public float modHealthExtra;
    public float modMana;
    public float modManaExtra;
    public float modArmor;
    public float modDamage;
    public float modExperience;
    public boolean racialLeader;
    public int movementId;
    public int creatureDifficultyID;
    public int widgetSetID;
    public int widgetSetUnitConditionID;
    public boolean regenHealth;
    public long mechanicImmuneMask;
    public int spellSchoolImmuneMask;
    public CreatureflagsExtra flagsExtra = CreatureFlagsExtra.values()[0];
    public int scriptID;
    public String stringId;

    public QueryCreatureResponse queryData;

    public static int difficultyIDToDifficultyEntryIndex(int difficulty) {
        switch (Difficulty.forValue((byte) difficulty)) {
            case None:
            case Normal:
            case Raid10N:
            case Raid40:
            case Scenario3ManN:
            case NormalRaid:
                return -1;
            case Heroic:
            case Raid25N:
            case Scenario3ManHC:
            case HeroicRaid:
                return 0;
            case Raid10HC:
            case MythicKeystone:
            case MythicRaid:
                return 1;
            case Raid25HC:
                return 2;
            case LFR:
            case LFRNew:
            case EventRaid:
            case EventDungeon:
            case EventScenario:
            default:
                return -1;
        }
    }

    public final CreatureModel getModelByIdx(int idx) {
        return idx < models.size() ? models.get(idx) : null;
    }

    public final CreatureModel getRandomValidModel() {
        if (models.isEmpty()) {
            return null;
        }

        // If only one element, ignore the probability (even if 0)
        if (models.size() == 1) {
            return models.get(0);
        }

        var selectedItr = models.SelectRandomElementByWeight(model ->
        {
            return model.probability;
        });

        return selectedItr;
    }

    public final CreatureModel getFirstValidModel() {
        for (var model : models) {
            if (model.creatureDisplayId != 0) {
                return model;
            }
        }

        return null;
    }

    public final CreatureModel getModelWithDisplayId(int displayId) {
        for (var model : models) {
            if (displayId == model.creatureDisplayId) {
                return model;
            }
        }

        return null;
    }

    public final CreatureModel getFirstInvisibleModel() {
        for (var model : models) {
            var modelInfo = global.getObjectMgr().getCreatureModelInfo(model.creatureDisplayId);

            if (modelInfo != null && modelInfo.isTrigger) {
                return model;
            }
        }

        return CreatureModel.DEFAULTINVISIBLEMODEL;
    }

    public final CreatureModel getFirstVisibleModel() {
        for (var model : models) {
            var modelInfo = global.getObjectMgr().getCreatureModelInfo(model.creatureDisplayId);

            if (modelInfo != null && !modelInfo.isTrigger) {
                return model;
            }
        }

        return CreatureModel.DEFAULTVISIBLEMODEL;
    }

    public final int[] getMinMaxLevel() {
		[]tempVar = new[]();
        tempVar.healthScalingExpansion != expansion.LevelCurrent.getValue() ? Minlevel : minlevel + SharedConst.maxLevel;
        tempVar.healthScalingExpansion != expansion.LevelCurrent.getValue() ? Maxlevel : maxlevel + SharedConst.maxLevel;
        return tempVar;
    }

    public final int getHealthScalingExpansion() {
        return healthScalingExpansion == expansion.LevelCurrent.getValue() ? WorldConfig.getIntValue(WorldCfg.expansion) : healthScalingExpansion;
    }

    public final SkillType getRequiredLootSkill() {
        if (typeFlags.hasFlag(CreatureTypeFlags.SkinWithHerbalism)) {
            return SkillType.Herbalism;
        } else if (typeFlags.hasFlag(CreatureTypeFlags.SkinWithMining)) {
            return SkillType.Mining;
        } else if (typeFlags.hasFlag(CreatureTypeFlags.SkinWithEngineering)) {
            return SkillType.Engineering;
        } else {
            return SkillType.SKINNING; // normal case
        }
    }

    public final boolean isExotic() {
        return (typeFlags.getValue() & CreatureTypeFlags.TameableExotic.getValue()) != 0;
    }

    public final boolean isTameable(boolean canTameExotic) {
        if (creatureType != creatureType.Beast || family == creatureFamily.NONE || !typeFlags.hasFlag(CreatureTypeFlags.Tameable)) {
            return false;
        }

        // if can tame exotic then can tame any tameable
        return canTameExotic || !isExotic();
    }

    public final void initializeQueryData() {
        queryData = new QueryCreatureResponse();

        queryData.creatureID = entry;
        queryData.allow = true;

        CreatureStats stats = new CreatureStats();
        stats.leader = racialLeader;

        stats.name.charAt(0) = name;
        stats.nameAlt.set(0, femaleName);

        stats.Flags[0] = (int) typeFlags.getValue();
        stats.Flags[1] = typeFlags2;

        stats.creatureType = creatureType.getValue();
        stats.creatureFamily = family.getValue();
        stats.classification = rank.getValue();

        for (int i = 0; i < SharedConst.MaxCreatureKillCredit; ++i) {
            stats.ProxyCreatureID[i] = KillCredit[i];
        }

        for (var model : models) {
            stats.display.totalProbability += model.probability;
            stats.display.creatureDisplay.add(new CreatureXDisplay(model.creatureDisplayId, model.displayScale, model.probability));
        }

        stats.hpMulti = modHealth;
        stats.energyMulti = modMana;

        stats.creatureMovementInfoID = movementId;
        stats.requiredExpansion = requiredExpansion;
        stats.healthScalingExpansion = healthScalingExpansion;
        stats.vignetteID = vignetteID;
        stats.class = (int) unitClass;
        stats.creatureDifficultyID = creatureDifficultyID;
        stats.widgetSetID = widgetSetID;
        stats.widgetSetUnitConditionID = widgetSetUnitConditionID;

        stats.title = subName;
        stats.titleAlt = titleAlt;
        stats.cursorName = iconName;

        var items = global.getObjectMgr().getCreatureQuestItemList(entry);

        if (items != null) {
            stats.questItems.addAll(items);
        }

        queryData.stats = stats;
    }

    public final CreatureLevelScaling getLevelScaling(Difficulty difficulty) {
        var creatureLevelScaling = scalingStorage.get(difficulty);

        if (creatureLevelScaling != null) {
            return creatureLevelScaling;
        }

        return new CreatureLevelScaling();
    }
}
