package com.rainbowland.enums;

// Spell aura states
public enum AuraStateType {   // (C) used in caster aura state     (T) used in target aura state
    // (c) used in caster aura state-not (t) used in target aura state-not
    AURA_STATE_NONE,            // C   |
    AURA_STATE_DEFENSIVE,            // CcTt|
    AURA_STATE_WOUNDED_20_PERCENT,            // CcT |
    AURA_STATE_UNBALANCED,            // CcT | NYI
    AURA_STATE_FROZEN,            //  c t|
    AURA_STATE_MARKED,            // C  t| NYI
    AURA_STATE_WOUNDED_25_PERCENT,            //   T |
    AURA_STATE_DEFENSIVE_2,            // Cc  | NYI
    AURA_STATE_BANISHED,            //  c  | NYI
    AURA_STATE_DAZED,            //    t|
    AURA_STATE_VICTORIOUS,           // C   |
    AURA_STATE_RAMPAGE,           //     | NYI
    AURA_STATE_FAERIE_FIRE,           //  c t|
    AURA_STATE_WOUNDED_35_PERCENT,           // CcT |
    AURA_STATE_RAID_ENCOUNTER_2,           //  cT |
    AURA_STATE_DRUID_PERIODIC_HEAL,           //   T |
    AURA_STATE_ROGUE_POISONED,           //     |
    AURA_STATE_ENRAGED,           // C   |
    AURA_STATE_BLEED,           //   T |
    AURA_STATE_VULNERABLE,           //     | NYI
    AURA_STATE_ARENA_PREPARATION,           //  c  |
    AURA_STATE_WOUND_HEALTH_20_80,           //   T |
    AURA_STATE_RAID_ENCOUNTER,           // CcTt|
    AURA_STATE_HEALTHY_75_PERCENT,           // C   |
    AURA_STATE_WOUND_HEALTH_35_80            //   T |
}
