package com.github.mmo.game.service.model.player;

// used at player loading query list preparing, and later result selection
public enum PlayerLoginQueryLoad {
    from,
    customizations,
    group,
    auras,
    auraEffects,
    AuraStoredLocations,
    spells,
    SpellFavorites,
    QuestStatus,
    QuestStatusObjectives,
    QuestStatusObjectivesCriteria,
    QuestStatusObjectivesCriteriaProgress,
    DailyQuestStatus,
    Reputation,
    Inventory,
    Artifacts,
    Azerite,
    AzeriteMilestonePowers,
    AzeriteUnlockedEssences,
    AzeriteEmpowered,
    mails,
    MailItems,
    MailItemsArtifact,
    MailItemsAzerite,
    MailItemsAzeriteMilestonePower,
    MailItemsAzeriteUnlockedEssence,
    MailItemsAzeriteEmpowered,
    SocialList,
    HomeBind,
    spellCooldowns,
    spellCharges,
    declinedNames,
    guild,
    ArenaInfo,
    Achievements,
    criteriaProgress,
    EquipmentSets,
    TransmogOutfits,
    BgData,
    glyphs,
    talents,
    pvpTalents,
    AccountData,
    skills,
    WeeklyQuestStatus,
    RandomBg,
    Banned,
    QuestStatusRew,
    InstanceLockTimes,
    SeasonalQuestStatus,
    MonthlyQuestStatus,
    VoidStorage,
    currency,
    CufProfiles,
    CorpseLocation,
    PetSlots,
    Garrison,
    GarrisonBlueprints,
    GarrisonBuildings,
    GarrisonFollowers,
    GarrisonFollowerAbilities,
    TraitEntries,
    traitConfigs,
    max;

    public static final int SIZE = Integer.SIZE;

    public static PlayerLoginQueryLoad forValue(int value) {
        return values()[value];
    }

    public int getValue() {
        return this.ordinal();
    }
}
