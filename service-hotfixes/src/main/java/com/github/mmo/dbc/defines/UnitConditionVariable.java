package com.github.mmo.dbc.defines;

public enum UnitConditionVariable {
    None,  // - NONE -
    Race,  // Race {$Is/Is Not} "{ChrRaces}"
    Class,  // Class {$Is/Is Not} "{ChrClasses}"
    Level,  // Level {$Relative Op} "{#Level}"
    IsSelf,  // Is self? {$Yes/No}{=1}
    IsMyPet,  // Is my pet? {$Yes/No}{=1}
    IsMaster,  // Is master? {$Yes/No}{=1}
    IsTarget,  // Is target? {$Yes/No}{=1}
    CanAssist,  // Can assist? {$Yes/No}{=1}
    CanAttack,  // Can attack? {$Yes/No}{=1}
    HasPet, // Has pet? {$Yes/No}{=1}
    HasWeapon, // Has weapon? {$Yes/No}{=1}
    HealthPct, // Health {$Relative Op} {#Health %}%
    ManaPct, // Mana {$Relative Op} {#Mana %}%
    RagePct, // Rage {$Relative Op} {#Rage %}%
    EnergyPct, // Energy {$Relative Op} {#Energy %}%
    ComboPoints, // Combo Points {$Relative Op} {#Points}
    HasHelpfulAuraSpell, // Has helpful aura spell? {$Yes/No} "{Spell}"
    HasHelpfulAuraDispelType, // Has helpful aura dispel type? {$Yes/No} "{SpellDispelType}"
    HasHelpfulAuraMechanic, // Has helpful aura mechanic? {$Yes/No} "{SpellMechanic}"
    HasHarmfulAuraSpell, // Has harmful aura spell? {$Yes/No} "{Spell}"
    HasHarmfulAuraDispelType, // Has harmful aura dispel type? {$Yes/No} "{SpellDispelType}"
    HasHarmfulAuraMechanic, // Has harmful aura mechanic? {$Yes/No} "{SpellMechanic}"
    HasHarmfulAuraSchool, // Has harmful aura school? {$Yes/No} "{Resistances}"
    DamagePhysicalPct, // NYI Damage (Physical) {$Relative Op} {#Physical Damage %}%
    DamageHolyPct, // NYI Damage (Holy) {$Relative Op} {#Holy Damage %}%
    DamageFirePct, // NYI Damage (Fire) {$Relative Op} {#Fire Damage %}%
    DamageNaturePct, // NYI Damage (Nature) {$Relative Op} {#Nature Damage %}%
    DamageFrostPct, // NYI Damage (Frost) {$Relative Op} {#Frost Damage %}%
    DamageShadowPct, // NYI Damage (Shadow) {$Relative Op} {#Shadow Damage %}%
    DamageArcanePct, // NYI Damage (Arcane) {$Relative Op} {#Arcane Damage %}%
    InCombat, // NYI In combat? {$Yes/No}{=1}
    IsMoving, // NYI Is moving? {$Yes/No}{=1}
    IsCasting, // NYI Is casting? {$Yes/No}{=1}
    IsCastingSpell, // NYI Is casting spell? {$Yes/No}{=1}
    IsChanneling, // NYI Is channeling? {$Yes/No}{=1}
    IsChannelingSpell, // NYI Is channeling spell? {$Yes/No}{=1}
    NumberOfMeleeAttackers, // NYI Number of melee attackers {$Relative Op} {#Attackers}
    IsAttackingMe, // NYI Is attacking me? {$Yes/No}{=1}
    Range, // NYI Range {$Relative Op} {#Yards}
    InMeleeRange, // NYI In melee range? {$Yes/No}{=1}
    PursuitTime, // NYI Pursuit time {$Relative Op} {#Seconds}
    HasHarmfulAuraCanceledByDamage, // NYI Has harmful aura canceled by damage? {$Yes/No}{=1}
    HasHarmfulAuraWithPeriodicDamage, // NYI Has harmful aura with periodic damage? {$Yes/No}{=1}
    NumberOfEnemies, // NYI Number of enemies {$Relative Op} {#Enemies}
    NumberOfFriends, // NYI Number of friends {$Relative Op} {#Friends}
    ThreatPhysicalPct, // NYI Threat (Physical) {$Relative Op} {#Physical Threat %}%
    ThreatHolyPct, // NYI Threat (Holy) {$Relative Op} {#Holy Threat %}%
    ThreatFirePct, // NYI Threat (Fire) {$Relative Op} {#Fire Threat %}%
    ThreatNaturePct, // NYI Threat (Nature) {$Relative Op} {#Nature Threat %}%
    ThreatFrostPct, // NYI Threat (Frost) {$Relative Op} {#Frost Threat %}%
    ThreatShadowPct, // NYI Threat (Shadow) {$Relative Op} {#Shadow Threat %}%
    ThreatArcanePct, // NYI Threat (Arcane) {$Relative Op} {#Arcane Threat %}%
    IsInterruptible, // NYI Is interruptible? {$Yes/No}{=1}
    NumberOfAttackers, // NYI Number of attackers {$Relative Op} {#Attackers}
    NumberOfRangedAttackers, // NYI Number of ranged attackers {$Relative Op} {#Ranged Attackers}
    CreatureType, // NYI Creature type {$Is/Is Not} "{CreatureType}"
    IsMeleeAttacking, // NYI Is melee-attacking? {$Yes/No}{=1}
    IsRangedAttacking, // NYI Is ranged-attacking? {$Yes/No}{=1}
    Health, // NYI Health {$Relative Op} {#HP} HP
    SpellKnown, // NYI Spell known? {$Yes/No} "{Spell}"
    HasHarmfulAuraEffect, // NYI Has harmful aura effect? {$Yes/No} "{#Spell Aura}"
    IsImmuneToAreaOfEffect, // NYI Is immune to area-of-effect? {$Yes/No}{=1}
    IsPlayer, // NYI Is player? {$Yes/No}{=1}
    DamageMagicPct, // NYI Damage (Magic) {$Relative Op} {#Magic Damage %}%
    DamageTotalPct, // NYI Damage (Total) {$Relative Op} {#Damage %}%
    ThreatMagicPct, // NYI Threat (Magic) {$Relative Op} {#Magic Threat %}%
    ThreatTotalPct, // NYI Threat (Total) {$Relative Op} {#Threat %}%
    HasCritter, // NYI Has critter? {$Yes/No}{=1}
    HasTotemInSlot1, // NYI Has totem in slot 1? {$Yes/No}{=1}
    HasTotemInSlot2, // NYI Has totem in slot 2? {$Yes/No}{=1}
    HasTotemInSlot3, // NYI Has totem in slot 3? {$Yes/No}{=1}
    HasTotemInSlot4, // NYI Has totem in slot 4? {$Yes/No}{=1}
    HasTotemInSlot5, // NYI Has totem in slot 5? {$Yes/No}{=1}
    Creature, // NYI Creature {$Is/Is Not} "{Creature}"
    StringID, // NYI String ID {$Is/Is Not} "{StringID}"
    HasAura, // NYI Has aura? {$Yes/No} {Spell}
    IsEnemy, // NYI Is enemy? {$Yes/No}{=1}
    IsSpecMelee, // NYI Is spec - melee? {$Yes/No}{=1}
    IsSpecTank, // NYI Is spec - tank? {$Yes/No}{=1}
    IsSpecRanged, // NYI Is spec - ranged? {$Yes/No}{=1}
    IsSpecHealer, // NYI Is spec - healer? {$Yes/No}{=1}
    IsPlayerControlledNPC, // NYI Is player controlled NPC? {$Yes/No}{=1}
    IsDying, // NYI Is dying? {$Yes/No}{=1}
    PathFailCount, // NYI Path fail count {$Relative Op} {#Path Fail Count}
    IsMounted, // NYI Is mounted? {$Yes/No}{=1}
    Label, // NYI Label {$Is/Is Not} "{Label}"
    IsMySummon, // NYI
    IsSummoner, // NYI
    IsMyTarget, // NYI
    Sex, // NYI Sex {$Is/Is Not} "{UnitSex}"
    LevelWithinContentTuning, // NYI Level is within {$Is/Is Not} {ContentTuning}

    IsFlying, // NYI Is flying? {$Yes/No}{=1}
    IsHovering, // NYI Is hovering? {$Yes/No}{=1}
    HasHelpfulAuraEffect, // NYI Has helpful aura effect? {$Yes/No} "{#Spell Aura}"
    HasHelpfulAuraSchool, // Has helpful aura school? {$Yes/No} "{Resistances}"
}
