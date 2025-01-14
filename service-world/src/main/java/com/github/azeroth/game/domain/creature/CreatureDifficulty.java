package com.github.azeroth.game.domain.creature;

import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.common.Logs;
import com.github.azeroth.dbc.defines.Difficulty;
import com.github.azeroth.defines.CreatureTypeFlag;
import com.github.azeroth.defines.Expansion;
import com.github.azeroth.defines.SkillType;

public class CreatureDifficulty {
    public int entry;
    public short deltaLevelMin;
    public short deltaLevelMax;
    public int sandboxScalingId;
    public Expansion healthScalingExpansion;
    public float healthModifier;
    public float manaModifier;
    public float armorModifier;
    public float damageModifier;
    public Difficulty difficulty;
    public EnumFlag<CreatureTypeFlag> typeFlag;
    public int typeFlag2;
    public int lootID;
    public int pickPocketLootID;
    public int skinLootID;
    public int goldMin;
    public int goldMax;
    public EnumFlag<CreatureStaticFlag> _flags;
    public EnumFlag<CreatureStaticFlag2> _flags2;
    public EnumFlag<CreatureStaticFlag3> _flags3;
    public EnumFlag<CreatureStaticFlag4> _flags4;
    public EnumFlag<CreatureStaticFlag5> _flags5;
    public EnumFlag<CreatureStaticFlag6> _flags6;
    public EnumFlag<CreatureStaticFlag7> _flags7;
    public EnumFlag<CreatureStaticFlag8> _flags8;

    public boolean hasFlag(CreatureStaticFlag flag) {
        return _flags.hasFlag(flag);
    }

    public boolean hasFlag(CreatureStaticFlag2 flag) {
        return _flags2.hasFlag(flag);
    }

    public boolean hasFlag(CreatureStaticFlag3 flag) {
        return _flags3.hasFlag(flag);
    }

    public boolean hasFlag(CreatureStaticFlag4 flag) {
        return _flags4.hasFlag(flag);
    }

    public boolean hasFlag(CreatureStaticFlag5 flag) {
        return _flags5.hasFlag(flag);
    }

    public boolean hasFlag(CreatureStaticFlag6 flag) {
        return _flags6.hasFlag(flag);
    }

    public boolean hasFlag(CreatureStaticFlag7 flag) {
        return _flags7.hasFlag(flag);
    }

    public boolean hasFlag(CreatureStaticFlag8 flag) {
        return _flags8.hasFlag(flag);
    }

    public void applyFlag(CreatureStaticFlag flag, boolean apply) {
        if (apply) _flags.addFlag(flag);
        else _flags.removeFlag(flag);
    }

    public void applyFlag(CreatureStaticFlag2 flag, boolean apply) {
        if (apply) _flags2.addFlag(flag);
        else _flags2.removeFlag(flag);
    }

    public void applyFlag(CreatureStaticFlag3 flag, boolean apply) {
        if (apply) _flags3.addFlag(flag);
        else _flags3.removeFlag(flag);
    }

    public void applyFlag(CreatureStaticFlag4 flag, boolean apply) {
        if (apply) _flags4.addFlag(flag);
        else _flags4.removeFlag(flag);
    }

    public void applyFlag(CreatureStaticFlag5 flag, boolean apply) {
        if (apply) _flags5.addFlag(flag);
        else _flags5.removeFlag(flag);
    }

    public void applyFlag(CreatureStaticFlag6 flag, boolean apply) {
        if (apply) _flags6.addFlag(flag);
        else _flags6.removeFlag(flag);
    }

    public void applyFlag(CreatureStaticFlag7 flag, boolean apply) {
        if (apply) _flags7.addFlag(flag);
        else _flags7.removeFlag(flag);
    }

    public void applyFlag(CreatureStaticFlag8 flag, boolean apply) {
        if (apply) _flags8.addFlag(flag);
        else _flags8.removeFlag(flag);
    }

    // Helpers

    public SkillType getRequiredLootSkill() {
        if ((typeFlag.getFlag() & SkillType.HERBALISM.value) != 0)
            return SkillType.HERBALISM;
        else if ((typeFlag.getFlag() & SkillType.MINING.value) != 0)
            return SkillType.MINING;
        else if ((typeFlag.getFlag() & SkillType.ENGINEERING.value) != 0)
            return SkillType.ENGINEERING;
        else
            return SkillType.SKINNING; // Default case
    }

    public CreatureDifficulty(int entry, short deltaLevelMin, short deltaLevelMax, int sandboxScalingId, int healthScalingExpansion, float healthModifier, float manaModifier, float armorModifier, float damageModifier, int creatureDifficultyID, EnumFlag<CreatureTypeFlag> typeFlag, int typeFlag2, int lootID, int pickPocketLootID, int skinLootID, int goldMin, int goldMax, EnumFlag<CreatureStaticFlag> _flags, EnumFlag<CreatureStaticFlag2> _flags2, EnumFlag<CreatureStaticFlag3> _flags3, EnumFlag<CreatureStaticFlag4> _flags4, EnumFlag<CreatureStaticFlag5> _flags5, EnumFlag<CreatureStaticFlag6> _flags6, EnumFlag<CreatureStaticFlag7> _flags7, EnumFlag<CreatureStaticFlag8> _flags8) {
        this.entry = entry;
        this.deltaLevelMin = deltaLevelMin;
        this.deltaLevelMax = deltaLevelMax;
        this.sandboxScalingId = sandboxScalingId;

        if (healthScalingExpansion < -1 || healthScalingExpansion >= Expansion.MAX_EXPANSION) {
            Logs.SQL.error("Table `creature_template_difficulty` lists creature (ID: {}) with invalid `HealthScalingExpansion` {}. Ignored and set to 0.",
                    entry, healthScalingExpansion);
            this.healthScalingExpansion = Expansion.CLASSIC;
        } else if (healthScalingExpansion == -1) {
            this.healthScalingExpansion = Expansion.CURRENT;
        } else {
            this.healthScalingExpansion = Expansion.values()[healthScalingExpansion];
        }

        if (creatureDifficultyID < 0 || creatureDifficultyID >= Difficulty.values().length) {
            Logs.SQL.error("Table `creature_template_difficulty` lists creature (ID: {}) with invalid `creatureDifficultyID` {}. Ignored and set to 0.",
                    entry, creatureDifficultyID);
            this.difficulty = Difficulty.NONE;
        } else {
            this.difficulty = Difficulty.values()[creatureDifficultyID];
        }

        this.healthModifier = healthModifier;
        this.manaModifier = manaModifier;
        this.armorModifier = armorModifier;
        this.damageModifier = damageModifier;
        this.typeFlag = typeFlag;
        this.typeFlag2 = typeFlag2;
        this.lootID = lootID;
        this.pickPocketLootID = pickPocketLootID;
        this.skinLootID = skinLootID;
        this.goldMin = goldMin;
        this.goldMax = goldMax;
        this._flags = _flags;
        this._flags2 = _flags2;
        this._flags3 = _flags3;
        this._flags4 = _flags4;
        this._flags5 = _flags5;
        this._flags6 = _flags6;
        this._flags7 = _flags7;
        this._flags8 = _flags8;
    }
}
