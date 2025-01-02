package com.github.mmo.dbc.defines;

public enum ModifierTreeType {
    None,   // No modifier
    PlayerInebriationLevelEqualOrGreaterThan,   // Player inebriation level is {#Drunkenness} or more
    PlayerMeetsCondition,   // Player meets condition "{PlayerCondition}"
    MinimumItemLevel,   // Minimum item level is {#Item Level}
    TargetCreatureId,   // Target is NPC "{Creature}"
    TargetIsPlayer,   // Target is player
    TargetIsDead,   // Target is dead
    TargetIsOppositeFaction,   // Target is opposite faction
    PlayerHasAura,   // Player has aura "{Spell}"
    PlayerHasAuraEffect,   // Player has aura effect "{SpellAuraNames.EnumID}"
    TargetHasAura,  // Target has aura "{Spell}"
    TargetHasAuraEffect,  // Target has aura effect "{SpellAuraNames.EnumID}"
    TargetHasAuraState,  // Target has aura state "{$Aura State}"
    PlayerHasAuraState,  // Player has aura state "{$Aura State}"
    ItemQualityIsAtLeast,  // Item quality is at least {$Item Quality}
    ItemQualityIsExactly,  // Item quality is exactly {$Item Quality}
    PlayerIsAlive,  // Player is alive
    PlayerIsInArea,  // Player is in area "{AreaTable}"
    TargetIsInArea,  // Target is in area "{AreaTable}"
    ItemId,  // Item is "{Item}"
    LegacyDungeonDifficulty,  // Legacy dungeon difficulty is "{$Dungeon Difficulty}"
    PlayerToTargetLevelDeltaGreaterThan,  // Exceeds the target's level by {#Level Delta} levels
    TargetToPlayerLevelDeltaGreaterThan,  // Target exceeds your level by {#Level Delta} levels
    PlayerLevelEqualTargetLevel,  // You and the target are equal level
    PlayerInArenaWithTeamSize,  // Player is in an arena with team size {#Team Size}
    PlayerRace,  // Player race is "{ChrRaces}"
    PlayerClass,  // Player class is "{ChrClasses}"
    TargetRace,  // Target race is "{ChrRaces}"
    TargetClass,  // Target class is "{ChrClasses}"
    LessThanTappers,  // Less than {#Tappers} tappers
    CreatureType,  // Creature is type "{CreatureType}"
    CreatureFamily,  // Creature is family "{CreatureFamily}"
    PlayerMap,  // Player is on map "{Map}"
    ClientVersionEqualOrLessThan,  // Milestone is at or before "{WowStaticSchemas}"
    BattlePetTeamLevel,  // All three winning battle pets are at or above level {#Battle Pet Level}
    PlayerIsNotInParty,  // Player is not in a party
    PlayerIsInParty,  // Player is in a party
    HasPersonalRatingEqualOrGreaterThan,  // Has a Personal Rating of at least {#Personal Rating}
    HasTitle,  // Has title "{CharTitles.Mask_ID}"
    PlayerLevelEqual,  // Player is exactly level {#Level}
    TargetLevelEqual,  // Target is exactly level {#Level}
    PlayerIsInZone,  // Player is in top-level area "{AreaTable}"
    TargetIsInZone,  // Target is in top-level area "{AreaTable}"
    PlayerHealthBelowPercent,  // Player health below {#Percent}%
    PlayerHealthAbovePercent,  // Player health above {#Percent}%
    PlayerHealthEqualsPercent,  // Player health equals {#Percent}%
    TargetHealthBelowPercent,  // Target health below {#Percent}%
    TargetHealthAbovePercent,  // Target health above {#Percent}%
    TargetHealthEqualsPercent,  // Target health equals {#Percent}%
    PlayerHealthBelowValue,  // Player health below {#Hit Points} HP
    PlayerHealthAboveValue,  // Player health above {#Hit Points} HP
    PlayerHealthEqualsValue,  // Player health equals {#Hit Points} HP
    TargetHealthBelowValue,  // Target health below {#Hit Points} HP
    TargetHealthAboveValue,  // Target health above {#Hit Points} HP
    TargetHealthEqualsValue,  // Target health equals {#Hit Points} HP
    TargetIsPlayerAndMeetsCondition,  // Target is a player with condition "{PlayerCondition}"
    PlayerHasMoreThanAchievementPoints,  // Player has over {#Achievement Pts} achievement points
    PlayerInLfgDungeon,  // Player is in a LFG dungeon
    PlayerInRandomLfgDungeon,  // Player is in a random LFG dungeon
    PlayerInFirstRandomLfgDungeon,  // Player is in a first random LFG dungeon
    PlayerInRankedArenaMatch,  // Player is in a ranked arena match
    PlayerInGuildParty,  /*NYI*/ // Player is in a guild party
    PlayerGuildReputationEqualOrGreaterThan,  // Player has guild reputation of {#Guild Reputation} or more
    PlayerInRatedBattleground,  // Player is in rated battleground
    PlayerBattlegroundRatingEqualOrGreaterThan,  // Player has a battleground rating of {#Battleground Rating} or more
    ResearchProjectRarity,  /*NYI*/ // Research project rarity is "{$Project Rarity}"
    ResearchProjectBranch,  /*NYI*/ // Research project is in branch "{ResearchBranch}"
    WorldStateExpression,  // World state expression "{WorldStateExpression}" is true
    DungeonDifficulty,  // Dungeon difficulty is "{Difficulty}"
    PlayerLevelEqualOrGreaterThan,  // Player level is {#Level} or more
    TargetLevelEqualOrGreaterThan,  // Target level is {#Level} or more
    PlayerLevelEqualOrLessThan,  // Player level is {#Level} or less
    TargetLevelEqualOrLessThan,  // Target level is {#Level} or less
    ModifierTree,  // Modifier tree "{ModifierTree}" is also true
    PlayerScenario,  // Player is on scenario "{Scenario}"
    TillersReputationGreaterThan,  // Reputation with Tillers is above {#Reputation}
    WinDuel,  // Battle pet achievement points are at least {#Achievement Pts}
    UniqueBattlePetsEqualOrGreaterThan,  // (Account) At least {#Pets Known} unique pets known
    BattlePetType,  // Battlepet is of type "{$Battle Pet Types}"
    BattlePetHealthPercentLessThan,  /*NYI*/ // (Account) Battlepet's health is below {#Health Percent} percent
    GuildGroupMemberCountEqualOrGreaterThan,  // Be in a group with at least {#Members} guild members
    BattlePetOpponentCreatureId,  /*NYI*/ // Battle pet opponent is "{Creature}"
    PlayerScenarioStep,  // Player is on scenario step number {#Step Number}
    ChallengeModeMedal,  // Challenge mode medal earned is "{#Challenge Mode Medal(OBSOLETE)}" (OBSOLETE)
    PlayerOnQuest,  // Player is currently on the quest "{QuestV2}"
    ExaltedWithFaction,  // Reach exalted with "{Faction}"
    EarnedAchievementOnAccount,  // Earned achievement "{Achievement}" on this account
    EarnedAchievementOnPlayer,  // Earned achievement "{Achievement}" on this player
    OrderOfTheCloudSerpentReputationGreaterThan,  // Reputation with Order of the Cloud Serpent is above {#Reputation}
    BattlePetQuality,  /*NYI*/ // Battle pet is of quality "{BattlePetBreedQuality}"
    BattlePetFightWasPVP,  /*NYI*/ // Battle pet fight was PVP
    BattlePetSpecies,  // Battle pet is species type "{BattlePetSpecies}"
    ServerExpansionEqualOrGreaterThan,  // Server expansion level is "{$Expansion Level}" or higher
    PlayerHasBattlePetJournalLock,  // Player has battle pet journal lock
    FriendshipRepReactionIsMet,  // Friendship rep reaction "{FriendshipRepReaction}" is met
    ReputationWithFactionIsEqualOrGreaterThan,  // Reputation with "{Faction}" is {#Reputation} or more
    ItemClassAndSubclass,  // Item is class "{ItemClass.ClassID}", subclass "{^ItemSubclass.SubclassID:ItemSubclass.ClassID = ?}"
    PlayerGender,  // Player's gender is "{$Gender}"
    PlayerNativeGender,  // Player's native gender is "{$Gender}"
    PlayerSkillEqualOrGreaterThan,  // Player skill "{SkillLine}" is level {#Skill Level} or higher
    PlayerLanguageSkillEqualOrGreaterThan, // Player language "{Languages}" is level {#Language Level} or higher
    PlayerIsInNormalPhase, // Player is in normal phase
    PlayerIsInPhase, // Player is in phase "{Phase}"
    PlayerIsInPhaseGroup, // Player is in phase group "{PhaseGroup}"
    PlayerKnowsSpell, // Player knows spell "{Spell}"
    PlayerHasItemQuantity, // Player is carrying item "{Item}", quantity {#Quantity}
    PlayerExpansionLevelEqualOrGreaterThan, // Player expansion level is "{$Expansion Level}" or higher
    PlayerHasAuraWithLabel, // Player has aura with label {Label}
    PlayersRealmWorldState, // Player's realm state "{WorldState}" equals {#Value}
    TimeBetween, // Time is between "{/Begin Date}" and "{/End Date}"
    PlayerHasCompletedQuest, // Player has previously completed quest "{QuestV2}"
    PlayerIsReadyToTurnInQuest, // Player is ready to turn in quest "{QuestV2}"
    PlayerHasCompletedQuestObjective, // Player has completed Quest Objective "{QuestObjective}"
    PlayerHasExploredArea, // Player has explored area "{AreaTable}"
    PlayerHasItemQuantityIncludingBank, // Player or bank has item "{Item}", quantity {#Quantity}
    Weather, // Weather is "{Weather}"
    PlayerFaction, // Player faction is {$Player Faction}
    LfgStatusEqual, // Looking-for-group status "{$LFG Status}" equals {#Value}
    LFgStatusEqualOrGreaterThan, // Looking-for-group status "{$LFG Status}" is {#Value} or more
    PlayerHasCurrencyEqualOrGreaterThan, // Player has currency "{CurrencyTypes}" in amount {#Amount} or more
    TargetThreatListSizeLessThan, // Player Killed creature with less than "{#Targets}" threat list targets
    PlayerHasTrackedCurrencyEqualOrGreaterThan, // Player has currency "{CurrencyTypes}" tracked (per season) in amount {#Amount} or more
    PlayerMapInstanceType, // Player is on a map of type "{@INSTANCE_TYPE}"
    PlayerInTimeWalkerInstance, // Player was in a Time Walker instance
    PvpSeasonIsActive, // PVP season is active
    PvpSeason, // Current PVP season is {#Season}
    GarrisonTierEqualOrGreaterThan, // Garrison is tier {#Tier} or higher for garrison type "{GarrType}"
    GarrisonFollowersWithLevelEqualOrGreaterThan, // At least {#Followers} followers of at least level {#Level} for follower type "{GarrFollowerType}"
    GarrisonFollowersWithQualityEqualOrGreaterThan, // At least {#Followers} followers at least quality "{@GARR_FOLLOWER_QUALITY}" for follower type "{GarrFollowerType}"
    GarrisonFollowerWithAbilityAtLevelEqualOrGreaterThan, // Follower of at least level {#Level} has ability {GarrAbility} for follower type "{GarrFollowerType}"
    GarrisonFollowerWithTraitAtLevelEqualOrGreaterThan, // Follower of at least level {#Level} has trait {GarrAbility} for follower type "{GarrFollowerType}"
    GarrisonFollowerWithAbilityAssignedToBuilding, // Follower with ability "{GarrAbility}" is assigned to building type "{@GARRISON_BUILDING_TYPE}" for garrison type "{GarrType}"
    GarrisonFollowerWithTraitAssignedToBuilding, // Follower with trait "{GarrAbility}" is assigned to building type "{@GARRISON_BUILDING_TYPE}" for garrison type "{GarrType}"
    GarrisonFollowerWithLevelAssignedToBuilding, // Follower at least level {#Level} is assigned to building type "{@GARRISON_BUILDING_TYPE}" for garrison type "GarrType}"
    GarrisonBuildingWithLevelEqualOrGreaterThan, // Building "{@GARRISON_BUILDING_TYPE}" is at least level {#Level} for garrison type "{GarrType}"
    HasBlueprintForGarrisonBuilding, // Has blueprint for garrison building "{GarrBuilding}" of type "{GarrType}"
    HasGarrisonBuildingSpecialization, // Has garrison building specialization "{GarrSpecialization}"
    AllGarrisonPlotsAreFull, // All garrison type "{GarrType}" plots are full
    PlayerIsInOwnGarrison, // Player is in their own garrison
    GarrisonShipmentOfTypeIsPending, /*NYI*/ // Shipment of type "{CharShipmentContainer}" is pending
    GarrisonBuildingIsUnderConstruction, // Garrison building "{GarrBuilding}" is under construction
    GarrisonMissionHasBeenCompleted, /*NYI*/ // Garrison mission "{GarrMission}" has been completed
    GarrisonBuildingLevelEqual, // Building {@GARRISON_BUILDING_TYPE} is exactly level {#Level} for garrison type "{GarrType}"
    GarrisonFollowerHasAbility, // This follower has ability "{GarrAbility}" for garrison type "{GarrType}"
    GarrisonFollowerHasTrait, // This follower has trait "{GarrAbility}" for garrison type "{GarrType}"
    GarrisonFollowerQualityEqual, // This Garrison Follower is {@GARR_FOLLOWER_QUALITY} quality
    GarrisonFollowerLevelEqual, // This Garrison Follower is level {#Level}
    GarrisonMissionIsRare, /*NYI*/ // This Garrison Mission is Rare
    GarrisonMissionIsElite, /*NYI*/ // This Garrison Mission is Elite
    CurrentGarrisonBuildingLevelEqual, // This Garrison Building is level {#Level} - building type passed as argument
    GarrisonPlotInstanceHasBuildingThatIsReadyToActivate, // Garrison plot instance "{GarrPlotInstance}" has building that is ready to activate
    BattlePetTeamWithSpeciesEqualOrGreaterThan, // Battlepet: with at least {#Amount} "{BattlePetSpecies}"
    BattlePetTeamWithTypeEqualOrGreaterThan, // Battlepet: with at least {#Amount} pets of type "{$Battle Pet Types}"
    PetBattleLastAbility, /*NYI*/ // Battlepet: last ability was "{BattlePetAbility}"
    PetBattleLastAbilityType, /*NYI*/ // Battlepet: last ability was of type "{$Battle Pet Types}"
    BattlePetTeamWithAliveEqualOrGreaterThan, // Battlepet: with at least {#Alive} alive
    HasGarrisonBuildingActiveSpecialization, // Has Garrison building active specialization "{GarrSpecialization}"
    HasGarrisonFollower, // Has Garrison follower "{GarrFollower}"
    PlayerQuestObjectiveProgressEqual, // Player's progress on Quest Objective "{QuestObjective}" is equal to {#Value}
    PlayerQuestObjectiveProgressEqualOrGreaterThan, // Player's progress on Quest Objective "{QuestObjective}" is at least {#Value}
    IsPTRRealm, // This is a PTR Realm
    IsBetaRealm, // This is a Beta Realm
    IsQARealm, // This is a QA Realm
    GarrisonShipmentContainerIsFull, /*NYI*/ // Shipment Container "{CharShipmentContainer}" is full
    PlayerCountIsValidToStartGarrisonInvasion, // Player count is valid to start garrison invasion
    InstancePlayerCountEqualOrLessThan, // Instance has at most {#Players} players
    AllGarrisonPlotsFilledWithBuildingsWithLevelEqualOrGreater, // All plots are full and at least level {#Level} for garrison type "{GarrType}"
    GarrisonMissionType, /*NYI*/ // This mission is type "{GarrMissionType}"
    GarrisonFollowerItemLevelEqualOrGreaterThan, // This follower is at least item level {#Level}
    GarrisonFollowerCountWithItemLevelEqualOrGreaterThan, // At least {#Followers} followers are at least item level {#Level} for follower type "{GarrFollowerType}"
    GarrisonTierEqual, // Garrison is exactly tier {#Tier} for garrison type "{GarrType}"
    InstancePlayerCountEqual, // Instance has exactly {#Players} players
    CurrencyId, // The currency is type "{CurrencyTypes}"
    SelectionIsPlayerCorpse, // Target is player corpse
    PlayerCanAcceptQuest, // Player is currently eligible for quest "{QuestV2}"
    GarrisonFollowerCountWithLevelEqualOrGreaterThan, // At least {#Followers} followers exactly level {#Level} for follower type "{GarrFollowerType}"
    GarrisonFollowerIsInBuilding, // Garrison follower "{GarrFollower}" is in building "{GarrBuilding}"
    GarrisonMissionCountLessThan, /*NYI*/ // Player has less than {#Available} available and {#In-Progress} in-progress missions of garrison type "{GarrType}"
    GarrisonPlotInstanceCountEqualOrGreaterThan, // Player has at least {#Amount} instances of plot "{GarrPlot}" available
    CurrencySource, /*NYI*/ // Currency source is {$Currency Source}
    PlayerIsInNotOwnGarrison, // Player is in another garrison (not their own)
    HasActiveGarrisonFollower, // Has active Garrison follower "{GarrFollower}"
    PlayerDailyRandomValueMod_X_Equals, /*NYI*/ // Player daily random second mod {#Mod Value} equals {#Equals Value}
    PlayerHasMount, // Player has Mount "{Mount}"
    GarrisonFollowerCountWithInactiveWithItemLevelEqualOrGreaterThan, // At least {#Followers} followers (including inactive) are at least item level {#Level} for follower type "{GarrFollowerType}"
    GarrisonFollowerIsOnAMission, // Garrison follower "{GarrFollower}" is on a mission
    GarrisonMissionCountInSetLessThan, /*NYI*/ // Player has less than {#Missions} available and in-progress missions of set "{GarrMissionSet}" in garrison type "{GarrType}"
    GarrisonFollowerType, // This Garrison Follower is of type "{GarrFollowerType}"
    PlayerUsedBoostLessThanHoursAgoRealTime, /*NYI*/ // Player has boosted and boost occurred < {#Hours} hours ago (real time)
    PlayerUsedBoostLessThanHoursAgoGameTime, /*NYI*/ // Player has boosted and boost occurred < {#Hours} hours ago (in-game time)
    PlayerIsMercenary, // Player is currently Mercenary
    PlayerEffectiveRace, /*NYI*/ // Player effective race is "{ChrRaces}"
    TargetEffectiveRace, /*NYI*/ // Target effective race is "{ChrRaces}"
    HonorLevelEqualOrGreaterThan, // Honor level >= {#Level}
    PrestigeLevelEqualOrGreaterThan, // Prestige level >= {#Level}
    GarrisonMissionIsReadyToCollect, /*NYI*/ // Garrison mission "{GarrMission}" is ready to collect
    PlayerIsInstanceOwner, /*NYI*/ // Player is the instance owner (requires 'Lock Instance Owner' LFGDungeon flag)
    PlayerHasHeirloom, // Player has heirloom "{Item}"
    TeamPoints, /*NYI*/ // Team has {#Points} Points
    PlayerHasToy, // Player has toy "{Item}"
    PlayerHasTransmog, // Player has transmog "{ItemModifiedAppearance}"
    GarrisonTalentSelected, /*NYI*/ // Garrison has talent "{GarrTalent}" selected
    GarrisonTalentResearched, /*NYI*/ // Garrison has talent "{GarrTalent}" researched
    PlayerHasRestriction, // Player has restriction of type "{@CHARACTER_RESTRICTION_TYPE}"
    PlayerCreatedCharacterLessThanHoursAgoRealTime, /*NYI*/ // Player has created their character < {#Hours} hours ago (real time)
    PlayerCreatedCharacterLessThanHoursAgoGameTime, // Player has created their character < {#Hours} hours ago (in-game time)
    QuestHasQuestInfoId, // Quest has Quest Info "{QuestInfo}"
    GarrisonTalentResearchInProgress, /*NYI*/ // Garrison is researching talent "{GarrTalent}"
    PlayerEquippedArtifactAppearanceSet, // Player has equipped Artifact Appearance Set "{ArtifactAppearanceSet}"
    PlayerHasCurrencyEqual, // Player has currency "{CurrencyTypes}" in amount {#Amount} exactly
    MinimumAverageItemHighWaterMarkForSpec, /*NYI*/ // Minimum average item high water mark is {#Item High Water Mark} for "{$Item History Spec Match}")
    PlayerScenarioType, // Player in scenario of type "{$Scenario Type}"
    PlayersAuthExpansionLevelEqualOrGreaterThan, // Player's auth expansion level is "{$Expansion Level}" or higher
}
