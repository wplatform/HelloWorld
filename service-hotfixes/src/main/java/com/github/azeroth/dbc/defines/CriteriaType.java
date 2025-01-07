package com.github.azeroth.dbc.defines;

public enum CriteriaType {
    KillCreature,   // Kill NPC "{Creature}"
    WinBattleground,   // Win battleground "{Map}"
    CompleteResearchProject,   /*NYI*/ // Complete research project "{ResearchProject}"
    CompleteAnyResearchProject,   /*NYI*/ // Complete any research project
    FindResearchObject,   /*NYI*/ // Find research object "{GameObjects}"
    ReachLevel,   // Reach level
    ExhaustAnyResearchSite,   /*NYI*/ // Exhaust any research site
    SkillRaised,   // Skill "{SkillLine}" raised
    EarnAchievement,   // Earn achievement "{Achievement}"
    CompleteQuestsCount,   // Count of complete quests (quest count)
    CompleteAnyDailyQuestPerDay,  // Complete any daily quest (per day)
    CompleteQuestsInZone,  // Complete quests in "{AreaTable}"
    CurrencyGained,  // Currency "{CurrencyTypes}" gained
    DamageDealt,  // Damage dealt
    CompleteDailyQuest,  // Complete daily quest
    ParticipateInBattleground,  // Participate in battleground "{Map}"
    DieOnMap,  // Die on map "{Map}"
    DieAnywhere,  // Die anywhere
    DieInInstance,  // Die in an instance which handles at most {#Max Players} players
    RunInstance,  /*NYI*/ // Run an instance which handles at most {#Max Players} players
    KilledByCreature,  // Get killed by "{Creature}"
    CompleteInternalCriteria,  /*NYI*/ // Designer Value{`Uses Record ID}
    CompleteAnyChallengeMode,  /*NYI*/ // Complete any challenge mode
    KilledByPlayer,  // Die to a player
    MaxDistFallenWithoutDying,  // Maximum distance fallen without dying
    EarnChallengeModeMedal,  /*NYI*/ // Earn a challenge mode medal of "{#Challenge Mode Medal (OBSOLETE)}" (OBSOLETE)
    DieFromEnviromentalDamage,  // Die to "{$Env Damage}" environmental damage
    CompleteQuest,  // Complete quest "{QuestV2}"
    BeSpellTarget,  // Have the spell "{Spell}" cast on you
    CastSpell,  // Cast the spell "{Spell}"
    TrackedWorldStateUIModified,  // Tracked WorldStateUI value "{WorldStateUI}" is modified
    PVPKillInArea,  // Kill someone in PVP in "{AreaTable}"
    WinArena,  // Win arena "{Map}"
    ParticipateInArena,  /*NYI*/ // Participate in arena "{Map}"
    LearnOrKnowSpell,  // Learn or Know spell "{Spell}"
    EarnHonorableKill,  // Earn an honorable kill
    AcquireItem,  // Acquire item "{Item}"
    WinAnyRankedArena,  // Win a ranked arena match (any arena)
    EarnTeamArenaRating,  /*NYI*/ // Earn a team arena rating of {#Arena Rating}
    EarnPersonalArenaRating,  // Earn a personal arena rating of {#Arena Rating}
    AchieveSkillStep,  // Achieve a skill step in "{SkillLine}"
    UseItem,  // Use item "{Item}"
    LootItem,  // Loot "{Item}" via corpse, pickpocket, fishing, disenchanting, etc.
    RevealWorldMapOverlay,  // Reveal world map overlay "{WorldMapOverlay}"
    EarnTitle,  /*NYI*/ // Deprecated PVP Titles
    BankSlotsPurchased,  // Bank slots purchased
    ReputationGained,  // Reputation gained with faction "{Faction}"
    TotalExaltedFactions,  // Total exalted factions
    GotHaircut,  // Got a haircut
    EquipItemInSlot,  // Equip item in slot "{$Equip Slot}"
    RollNeed,  // Roll need and get {#Need Roll}
    RollGreed,  // Roll greed and get {#Greed Roll}
    DeliverKillingBlowToClass,  // Deliver a killing blow to a {ChrClasses}
    DeliverKillingBlowToRace,  // Deliver a killing blow to a {ChrRaces}
    DoEmote,  // Do a "{EmotesText}" emote
    HealingDone,  // Healing done
    DeliveredKillingBlow,  // Delivered a killing blow
    EquipItem,  // Equip item "{Item}"
    CompleteQuestsInSort,  /*NYI*/ // Complete quests in "{QuestSort}"
    MoneyEarnedFromSales,  // Sell items to vendors
    MoneySpentOnRespecs,  // Money spent on respecs
    TotalRespecs,  // Total respecs
    MoneyEarnedFromQuesting,  // Money earned from questing
    MoneySpentOnTaxis,  // Money spent on taxis
    KilledAllUnitsInSpawnRegion,  /*NYI*/ // Killed all units in spawn region "{SpawnRegion}"
    MoneySpentAtBarberShop,  // Money spent at the barber shop
    MoneySpentOnPostage,  // Money spent on postage
    MoneyLootedFromCreatures,  // Money looted from creatures
    UseGameobject,  // Use Game Object "{GameObjects}"
    GainAura,  // Gain aura "{Spell}"
    KillPlayer,  // Kill a player (no honor check)
    CompleteChallengeMode,  /*NYI*/ // Complete a challenge mode on map "{Map}"
    CatchFishInFishingHole,  // Catch fish in the "{GameObjects}" fishing hole
    PlayerTriggerGameEvent,  /*NYI*/ // Player will Trigger game event "{GameEvents}"
    Login,  // Login (USE SPARINGLY!)
    LearnSpellFromSkillLine,  // Learn spell from the "{SkillLine}" skill line
    WinDuel,  // Win a duel
    LoseDuel,  // Lose a duel
    KillAnyCreature,  // Kill any NPC
    CreatedItemsByCastingSpellWithLimit,  /*NYI*/ // Created items by casting a spell (limit 1 per create...)
    MoneyEarnedFromAuctions,  // Money earned from auctions
    BattlePetAchievementPointsEarned,  /*NYI*/ // Battle pet achievement points earned
    ItemsPostedAtAuction,  // Number of items posted at auction
    HighestAuctionBid,  // Highest auction bid
    AuctionsWon,  // Auctions won
    HighestAuctionSale,  // Highest coin value of item sold
    MostMoneyOwned,  // Most money owned
    TotalReveredFactions,  // Total revered factions
    TotalHonoredFactions,  // Total honored factions
    TotalFactionsEncountered,  // Total factions encountered
    LootAnyItem,  // Loot any item
    ObtainAnyItem,  // Obtain any item
    AnyoneTriggerGameEventScenario,  /*NYI*/ // Anyone will Trigger game event "{GameEvents}" (Scenario Only)
    RollAnyNeed,  // Roll any number on need
    RollAnyGreed,  // Roll any number on greed
    ReleasedSpirit,  /*NYI*/ // Released Spirit
    AccountKnownPet,  /*NYI*/ // Account knows pet "{Creature}" (Backtracked)
    DefeatDungeonEncounterWhileElegibleForLoot,  // Defeat Encounter "{DungeonEncounter}" While Eligible For Loot
    // UNUSED 18{}                                 ,  // Unused
    // UNUSED 19{}                                 ,  // Unused
    // UNUSED 20{}                                 , // Unused
    HighestDamageDone, // Highest damage done in 1 single ability
    HighestDamageTaken, // Most damage taken in 1 single hit
    TotalDamageTaken, // Total damage taken
    HighestHealCast, // Largest heal cast
    TotalHealReceived, // Total healing received
    HighestHealReceived, // Largest heal received
    AbandonAnyQuest, // Abandon any quest
    BuyTaxi, // Buy a taxi
    GetLootByType, // Get loot via "{$Loot Acquisition}"
    LandTargetedSpellOnTarget, // Land targeted spell "{Spell}" on a target
    // UNUSED 21{}                                 , // Unused
    LearnTradeskillSkillLine, // Learn tradeskill skill line "{SkillLine}"
    HonorableKills, // Honorable kills (number in interface, won't update except for login)
    AcceptSummon, // Accept a summon
    EarnAchievementPoints, // Earn achievement points
    RollDisenchant, /*NYI*/ // Roll disenchant and get {#Disenchant Roll}
    RollAnyDisenchant, /*NYI*/ // Roll any number on disenchant
    CompletedLFGDungeon, /*NYI*/ // Completed an LFG dungeon
    CompletedLFGDungeonWithStrangers, // Completed an LFG dungeon with strangers
    KickInitiatorInLFGDungeon, /*NYI*/ // Kicked in an LFG dungeon (initiator)
    KickVoterInLFGDungeon, /*NYI*/ // Kicked in an LFG dungeon (voter)
    KickTargetInLFGDungeon, /*NYI*/ // Kicked in an LFG dungeon (target)
    AbandonedLFGDungeon, /*NYI*/ // Abandoned an LFG dungeon
    MoneySpentOnGuildRepair, /*NYI*/ // Guild repair amount spent
    GuildAttainedLevel, /*NYI*/ // Guild attained level
    CreatedItemsByCastingSpell, /*NYI*/ // Created items by casting a spell
    FishInAnyPool, /*NYI*/ // Fish in any pool
    GuildBankTabsPurchased, /*NYI*/ // Guild bank tabs purchased
    EarnGuildAchievementPoints, /*NYI*/ // Earn guild achievement points
    WinAnyBattleground, /*NYI*/ // Win any battleground
    ParticipateInAnyBattleground, /*NYI*/ // Participate in any battleground
    EarnBattlegroundRating, /*NYI*/ // Earn a battleground rating
    GuildTabardCreated, /*NYI*/ // Guild tabard created
    CompleteQuestsCountForGuild, /*NYI*/ // Count of complete quests for guild (Quest count)
    HonorableKillsForGuild, /*NYI*/ // Honorable kills for Guild
    KillAnyCreatureForGuild, /*NYI*/ // Kill any NPC for Guild
    GroupedTankLeftEarlyInLFGDungeon, /*NYI*/ // Grouped tank left early in an LFG dungeon
    CompleteGuildChallenge, /*NYI*/ // Complete a "{$Guild Challenge}" guild challenge
    CompleteAnyGuildChallenge, /*NYI*/ // Complete any guild challenge
    MarkedAFKInBattleground, /*NYI*/ // Marked AFK in a battleground
    RemovedAFKInBattleground, /*NYI*/ // Removed for being AFK in a battleground
    StartAnyBattleground, /*NYI*/ // Start any battleground (AFK tracking)
    CompleteAnyBattleground, /*NYI*/ // Complete any battleground (AFK tracking)
    MarkedSomeoneAFKInBattleground, /*NYI*/ // Marked someone for being AFK in a battleground
    CompletedLFRDungeon, /*NYI*/ // Completed an LFR dungeon
    AbandonedLFRDungeon, /*NYI*/ // Abandoned an LFR dungeon
    KickInitiatorInLFRDungeon, /*NYI*/ // Kicked in an LFR dungeon (initiator)
    KickVoterInLFRDungeon, /*NYI*/ // Kicked in an LFR dungeon (voter)
    KickTargetInLFRDungeon, /*NYI*/ // Kicked in an LFR dungeon (target)
    GroupedTankLeftEarlyInLFRDungeon, /*NYI*/ // Grouped tank left early in an LFR dungeon
    CompleteAnyScenario, /*NYI*/ // Complete a Scenario
    CompleteScenario, /*NYI*/ // Complete scenario "{Scenario}"
    EnterAreaTriggerWithActionSet, /*NYI*/ // Enter area trigger "{AreaTriggerActionSet}"
    LeaveAreaTriggerWithActionSet, /*NYI*/ // Leave area trigger "{AreaTriggerActionSet}"
    LearnedNewPet, // (Account Only) Learned a new pet
    UniquePetsOwned, // (Account Only) Unique pets owned
    AccountObtainPetThroughBattle, /*NYI*/ // (Account Only) Obtain a pet through battle
    WinPetBattle, /*NYI*/ // Win a pet battle
    LosePetBattle, /*NYI*/ // Lose a pet battle
    BattlePetReachLevel, // (Account Only) Battle pet has reached level {#Level}
    PlayerObtainPetThroughBattle, /*NYI*/ // (Player) Obtain a pet through battle
    ActivelyEarnPetLevel, // (Player) Actively earn level {#Level} with a pet by a player
    EnterArea, /*NYI*/ // Enter Map Area "{AreaTable}"
    LeaveArea, /*NYI*/ // Leave Map Area "{AreaTable}"
    DefeatDungeonEncounter, // Defeat Encounter "{DungeonEncounter}"
    PlaceAnyGarrisonBuilding, /*NYI*/ // Garrison Building: Place any
    PlaceGarrisonBuilding, // Garrison Building: Place "{GarrBuilding}"
    ActivateAnyGarrisonBuilding, // Garrison Building: Activate any
    ActivateGarrisonBuilding, /*NYI*/ // Garrison Building: Activate "{GarrBuilding}"
    UpgradeGarrison, /*NYI*/ // Garrison: Upgrade Garrison to Tier "{#Tier:2,3}"
    StartAnyGarrisonMissionWithFollowerType, /*NYI*/ // Garrison Mission: Start any with FollowerType "{GarrFollowerType}"
    StartGarrisonMission, /*NYI*/ // Garrison Mission: Start "{GarrMission}"
    SucceedAnyGarrisonMissionWithFollowerType, /*NYI*/ // Garrison Mission: Succeed any with FollowerType "{GarrFollowerType}"
    SucceedGarrisonMission, /*NYI*/ // Garrison Mission: Succeed "{GarrMission}"
    RecruitAnyGarrisonFollower, /*NYI*/ // Garrison Follower: Recruit any
    RecruitGarrisonFollower, // Garrison Follower: Recruit "{GarrFollower}"
    AcquireGarrison, /*NYI*/ // Garrison: Acquire a Garrison
    LearnAnyGarrisonBlueprint, /*NYI*/ // Garrison Blueprint: Learn any
    LearnGarrisonBlueprint, /*NYI*/ // Garrison Blueprint: Learn "{GarrBuilding}"
    LearnAnyGarrisonSpecialization, /*NYI*/ // Garrison Specialization: Learn any
    LearnGarrisonSpecialization, /*NYI*/ // Garrison Specialization: Learn "{GarrSpecialization}"
    CollectGarrisonShipment, /*NYI*/ // Garrison Shipment of type "{CharShipmentContainer}" collected
    ItemLevelChangedForGarrisonFollower, /*NYI*/ // Garrison Follower: Item Level Changed
    LevelChangedForGarrisonFollower, /*NYI*/ // Garrison Follower: Level Changed
    LearnToy, /*NYI*/ // Learn Toy "{Item}"
    LearnAnyToy, /*NYI*/ // Learn Any Toy
    QualityUpgradedForGarrisonFollower, /*NYI*/ // Garrison Follower: Quality Upgraded
    LearnHeirloom, /*NYI*/ // Learn Heirloom "{Item}"
    LearnAnyHeirloom, /*NYI*/ // Learn Any Heirloom
    EarnArtifactXP, /*NYI*/ // Earn Artifact XP
    AnyArtifactPowerRankPurchased, /*NYI*/ // Artifact Power Ranks Purchased
    LearnTransmog, /*NYI*/ // Learn Transmog "{ItemModifiedAppearance}"
    LearnAnyTransmog, /*NYI*/ // Learn Any Transmog
    HonorLevelIncrease, // (Player) honor level increase
    PrestigeLevelIncrease, /*NYI*/ // (Player) prestige level increase
    ActivelyReachLevel, // Actively level to level {#Level}
    CompleteResearchAnyGarrisonTalent, /*NYI*/ // Garrison Talent: Complete Research Any
    CompleteResearchGarrisonTalent, /*NYI*/ // Garrison Talent: Complete Research "{GarrTalent}"
    LearnAnyTransmogInSlot, // Learn Any Transmog in Slot "{$Equip Slot}"
    RecruitAnyGarrisonTroop, /*NYI*/ // Recruit any Garrison Troop
    StartResearchAnyGarrisonTalent, /*NYI*/ // Garrison Talent: Start Research Any
    StartResearchGarrisonTalent, /*NYI*/ // Garrison Talent: Start Research "{GarrTalent}"
    CompleteAnyWorldQuest, /*NYI*/ // Complete Any Quest
    EarnLicense, /*NYI*/ // Earn License "{BattlePayDeliverable}" (does NOT work for box level)
    CollectTransmogSetFromGroup, // (Account Only) Collect a Transmog Set from Group "{TransmogSetGroup}"
    ParagonLevelIncreaseWithFaction, /*NYI*/ // (Player) paragon level increase with faction "{Faction}"
    PlayerHasEarnedHonor, /*NYI*/ // Player has earned honor
    KillCreatureScenario, /*NYI*/ // Kill NPC "{Creature}" (scenario criteria only, do not use for player)
    ArtifactPowerRankPurchased, /*NYI*/ // Artifact Power Rank of "{ArtifactPower}" Purchased
    ChooseAnyRelicTalent, /*NYI*/ // Choose any Relic Talent
    ChooseRelicTalent, /*NYI*/ // Choose Relic Talent "{ArtifactPower}"
    EarnExpansionLevel, /*NYI*/ // Earn Expansion Level "{$Expansion Level}"
    Count
}
