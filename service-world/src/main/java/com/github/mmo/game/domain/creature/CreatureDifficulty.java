package com.github.mmo.game.domain.creature;

import com.github.mmo.common.EnumFlag;
import com.github.mmo.defines.Expansion;
import com.github.mmo.defines.SharedDefine;
import com.github.mmo.defines.SkillType;

public class CreatureDifficulty {
    public short deltaLevelMin;
    public short deltaLevelMax;
    public int sandboxScalingId;
    public int healthScalingExpansion;
    public float healthModifier;
    public float manaModifier;
    public float armorModifier;
    public float damageModifier;
    public int creatureDifficultyID;
    public int typeFlag;
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
    public int getHealthScalingExpansion() {
        return healthScalingExpansion == Expansion.LEVEL_CURRENT.getValue() ? SharedDefine.CURRENT_EXPANSION : healthScalingExpansion;
    }

    public SkillType getRequiredLootSkill() {
        if ((typeFlag & SkillType.HERBALISM.value) != 0)
            return SkillType.HERBALISM;
        else if ((typeFlag & SkillType.MINING.value) != 0)
            return SkillType.MINING;
        else if ((typeFlag & SkillType.ENGINEERING.value) != 0)
            return SkillType.ENGINEERING;
        else
            return SkillType.SKINNING; // Default case
    }
}
