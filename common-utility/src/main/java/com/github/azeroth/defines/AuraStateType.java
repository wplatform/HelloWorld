package com.github.azeroth.defines;

// Spell aura states
// EnumUtils: DESCRIBE THIS
public enum AuraStateType {   // (C) used in caster aura state     (T) used in target aura state
    // (c) used in caster aura state-not (t) used in target aura state-not
    NONE,            // C   |
    DEFENSIVE,            // CcTt|
    WOUNDED_20_PERCENT,            // CcT |
    UNBALANCED,            // CcT | NYI
    FROZEN,            //  c t|
    MARKED,            // C  t| NYI
    WOUNDED_25_PERCENT,            //   T |
    DEFENSIVE_2,            // Cc  | NYI
    BANISHED,            //  c  | NYI
    DAZED,            //    t|
    VICTORIOUS,           // C   |
    RAMPAGE,           //     | NYI
    FAERIE_FIRE,           //  c t|
    WOUNDED_35_PERCENT,           // CcT |
    RAID_ENCOUNTER_2,           //  cT |
    DRUID_PERIODIC_HEAL,           //   T |
    ROGUE_POISONED,           //     |
    ENRAGED,           // C   |
    BLEED,           //   T |
    VULNERABLE,           //     | NYI
    ARENA_PREPARATION,           //  c  |
    WOUND_HEALTH_20_80,           //   T |
    RAID_ENCOUNTER,           // CcTt|
    HEALTHY_75_PERCENT,           // C   |
    WOUND_HEALTH_35_80                       //   T |
}
