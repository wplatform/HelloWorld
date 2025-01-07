package com.github.azeroth.game.spell;// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:

public final class SpellMisc {
    // Alternate names for this second
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int talentId;

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int spellId;

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int specializationId;

    // SPELL_EFFECT_SET_FOLLOWER_QUALITY
    // SPELL_EFFECT_INCREASE_FOLLOWER_ITEM_LEVEL
    // SPELL_EFFECT_INCREASE_FOLLOWER_EXPERIENCE
    // SPELL_EFFECT_RANDOMIZE_FOLLOWER_ABILITIES
    // SPELL_EFFECT_LEARN_FOLLOWER_ABILITY
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int followerId;

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int followerAbilityId; // only SPELL_EFFECT_LEARN_FOLLOWER_ABILITY

    // SPELL_EFFECT_FINISH_GARRISON_MISSION
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int garrMissionId;

    // SPELL_EFFECT_UPGRADE_HEIRLOOM
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int itemId;

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int data0;

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int data1;


    public int[] getRawData() {
        return new int[]{Data0, Data1};
    }

    public SpellMisc clone() {
        SpellMisc varCopy = new spellMisc();

        varCopy.talentId = this.talentId;
        varCopy.spellId = this.spellId;
        varCopy.specializationId = this.specializationId;
        varCopy.followerId = this.followerId;
        varCopy.followerAbilityId = this.followerAbilityId;
        varCopy.garrMissionId = this.garrMissionId;
        varCopy.itemId = this.itemId;
        varCopy.data0 = this.data0;
        varCopy.data1 = this.data1;

        return varCopy;
    }
}
