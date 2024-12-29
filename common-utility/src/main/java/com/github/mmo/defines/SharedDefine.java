package com.github.mmo.defines;

import com.github.mmo.common.Locale;

public interface SharedDefine {

    float GROUND_HEIGHT_TOLERANCE = 0.05f; // Extra tolerance to z position to check if it is in air or on ground.
    float Z_OFFSET_FIND_HEIGHT = 0.5f;


    Locale DEFAULT_LOCALE = Locale.zhCN;

    int MAX_CLASSES = 13;
    int MAX_POWER = 20;
    int MAX_TALENT_TIERS = 7;
    int MAX_TALENT_COLUMNS = 3;
    int MAX_PVP_TALENT_TIERS = 6;
    int MAX_PVP_TALENT_COLUMNS = 3;


    int MIN_SPECIALIZATION_LEVEL = 10;
    int MAX_SPECIALIZATIONS = 4;
    int PET_SPEC_OVERRIDE_CLASS_INDEX = MAX_CLASSES;

    int MAX_NPC_TEXT_OPTIONS = 8;


    short BATTLE_PET_SPECIES_MAX_ID = 2164;


    byte LINE_OF_SIGHT_CHECK_VMAP = 0x1; // check static floor layout data

    byte LINE_OF_SIGHT_CHECK_GOBJECT = 0x2; // check dynamic game object data

    byte LINE_OF_SIGHT_ALL_CHECKS = (LINE_OF_SIGHT_CHECK_VMAP | LINE_OF_SIGHT_CHECK_GOBJECT);


    // used in script definitions
    byte EFFECT_FIRST_FOUND = (byte) 254;

    byte EFFECT_ALL = (byte) 255;

    int MAX_CHARACTERS_PER_REALM = 16;

    int CURRENT_EXPANSION = Expansion.LEGION.getValue();

    int CLASS_MASK_ALL_PLAYABLE = (1 << (PlayerClass.CLASS_WARRIOR.getValue() - 1))
            | (1 << (PlayerClass.CLASS_PALADIN.getValue() - 1))
            | (1 << (PlayerClass.CLASS_HUNTER.getValue() - 1))
            | (1 << (PlayerClass.CLASS_ROGUE.getValue() - 1))
            | (1 << (PlayerClass.CLASS_PRIEST.getValue() - 1))
            | (1 << (PlayerClass.CLASS_DEATH_KNIGHT.getValue() - 1))
            | (1 << (PlayerClass.CLASS_SHAMAN.getValue() - 1))
            | (1 << (PlayerClass.CLASS_MAGE.getValue() - 1))
            | (1 << (PlayerClass.CLASS_WARLOCK.getValue() - 1))
            | (1 << (PlayerClass.CLASS_MONK.getValue() - 1))
            | (1 << (PlayerClass.CLASS_DRUID.getValue() - 1))
            | (1 << (PlayerClass.CLASS_DEMON_HUNTER.getValue() - 1));


    int MAX_UNIT_CLASSES = 4;
    int CLASS_MASK_ALL_CREATURES = (1 << (UnitClass.UNIT_CLASS_WARRIOR.getValue() - 1))
            | (1 << (UnitClass.UNIT_CLASS_PALADIN.getValue() - 1))
            | (1 << (UnitClass.UNIT_CLASS_ROGUE.getValue() - 1))
            | (1 << (UnitClass.UNIT_CLASS_MAGE.getValue() - 1));

    int CLASS_MASK_WAND_USERS = (1 << (PlayerClass.CLASS_PRIEST.getValue() - 1))
            | (1 << (PlayerClass.CLASS_MAGE.getValue() - 1))
            | (1 << (PlayerClass.CLASS_WARLOCK.getValue() - 1));

    int PLAYER_MAX_BATTLEGROUND_QUEUES = 3;
    int MIN_REPUTATION_RANK = ReputationRank.HATED.ordinal();
    int MAX_REPUTATION_RANK = ReputationRank.values().length;
    int MAX_SPILLOVER_FACTIONS = 5;
    int MAX_STATS = 4;
    int MAX_POWERS_PER_CLASS = 6;
    int[] ITEM_QUALITY_COLORS = {
            0xff9d9d9d, // GREY
            0xffffffff, // WHITE
            0xff1eff00, // GREEN
            0xff0070dd, // BLUE
            0xffa335ee, // PURPLE
            0xffff8000, // ORANGE
            0xffe6cc80, // LIGHT YELLOW
            0xff00ccff, // LIGHT BLUE
            0xff00ccff  // LIGHT BLUE
    };
    int MAX_QUEST_DIFFICULTY = 5;
    int[] QUEST_DIFFICULTY_COLORS = {0xff40c040, 0xff808080, 0xffffff00, 0xffff8040, 0xffff2020};

    static int getMaxLevelForExpansion(int expansion) {
        return switch (expansion) {
            case 0 -> 60;
            case 1 -> 70;
            case 2 -> 80;
            case 3 -> 85;
            case 4 -> 90;
            case 5 -> 100;
            case 6 -> 110;
            default -> 0;
        };
    }

    static SpellSchoolMask getMaskForSchool(SpellSchool school) {
        return SpellSchoolMask.values()[1 << school.ordinal()];
    }

    static SpellSchool getFirstSchoolInMask(SpellSchoolMask mask) {
        for (int i = 0; i < SpellSchool.values().length; i++) {
            if ((mask.value & (1 << i)) != 0) {
                return SpellSchool.values()[i];
            }
        }
        return SpellSchool.NORMAL;
    }


// ***********************************
// Spell Attributes definitions
// ***********************************




    byte MAX_SHEATHETYPE = 8;


    byte PLAYER_CUSTOM_DISPLAY_SIZE = 3;


    int PER_CASTER_AURA_STATE_MASK = ((1 << (AuraStateType.RAID_ENCOUNTER_2.ordinal() - 1)) | (1 << (AuraStateType.ROGUE_POISONED.ordinal() - 1)));


    // Used for spell 42292 Immune Movement Impairment and Loss of Control (0x49967ca6)
    int IMMUNE_TO_MOVEMENT_IMPAIRMENT_AND_LOSS_CONTROL_MASK = (
            (1 << Mechanics.MECHANIC_CHARM.ordinal()) | (1 << Mechanics.MECHANIC_DISORIENTED.ordinal()) | (1 << Mechanics.MECHANIC_FEAR.ordinal()) |
                    (1 << Mechanics.MECHANIC_ROOT.ordinal()) | (1 << Mechanics.MECHANIC_SLEEP.ordinal()) | (1 << Mechanics.MECHANIC_SNARE.ordinal()) |
                    (1 << Mechanics.MECHANIC_STUN.ordinal()) | (1 << Mechanics.MECHANIC_FREEZE.ordinal()) | (1 << Mechanics.MECHANIC_SILENCE.ordinal())
                    | (1 << Mechanics.MECHANIC_DISARM.ordinal()) | (1 << Mechanics.MECHANIC_KNOCKOUT.ordinal()) |
                    (1 << Mechanics.MECHANIC_POLYMORPH.ordinal()) | (1 << Mechanics.MECHANIC_BANISH.ordinal()) | (1 << Mechanics.MECHANIC_SHACKLE.ordinal()) |
                    (1 << Mechanics.MECHANIC_TURN.ordinal()) | (1 << Mechanics.MECHANIC_HORROR.ordinal()) | (1 << Mechanics.MECHANIC_DAZE.ordinal()) |
                    (1 << Mechanics.MECHANIC_SAPPED.ordinal()));

    ;

    int DISPEL_ALL_MASK = ((1 << DispelType.MAGIC.ordinal()) | (1 << DispelType.CURSE.ordinal()) | (1 << DispelType.DISEASE.ordinal()) | (1 << DispelType.POISON.ordinal()));


    int MAX_GAME_OBJECT_TYPE = 52;             // sending to client this or greater value can crash client.
    int MAX_GAME_OBJECT_DATA = 33;             // Max number of uint32 vars in gameobject_template data field


    int MAX_GO_STATE = 3;
    int MAX_GO_STATE_TRANSPORT_STOP_FRAMES = 9;


    // this is important type for npcs!
    enum TrainerType {
        TRAINER_TYPE_CLASS
    }


    int CREATURE_TYPEMASK_DEMON_OR_UNDEAD = (1 << (CreatureType.CREATURE_TYPE_DEMON.ordinal() - 1)) | (1 << (CreatureType.CREATURE_TYPE_UNDEAD.ordinal() - 1));
    int CREATURE_TYPEMASK_HUMANOID_OR_UNDEAD = (1 << (CreatureType.CREATURE_TYPE_HUMANOID.ordinal() - 1)) | (1 << (CreatureType.CREATURE_TYPE_UNDEAD.ordinal() - 1));
    int CREATURE_TYPEMASK_MECHANICAL_OR_ELEMENTAL = (1 << (CreatureType.CREATURE_TYPE_MECHANICAL.ordinal() - 1)) | (1 << (CreatureType.CREATURE_TYPE_ELEMENTAL.ordinal() - 1));


    static PlayerClass classByQuestSort(QuestSort questSort) {
        return switch (questSort) {
            case QUEST_SORT_WARLOCK -> PlayerClass.CLASS_WARLOCK;
            case QUEST_SORT_WARRIOR -> PlayerClass.CLASS_WARRIOR;
            case QUEST_SORT_SHAMAN -> PlayerClass.CLASS_SHAMAN;
            case QUEST_SORT_PALADIN -> PlayerClass.CLASS_PALADIN;
            case QUEST_SORT_MAGE -> PlayerClass.CLASS_MAGE;
            case QUEST_SORT_ROGUE -> PlayerClass.CLASS_ROGUE;
            case QUEST_SORT_HUNTER -> PlayerClass.CLASS_HUNTER;
            case QUEST_SORT_PRIEST -> PlayerClass.CLASS_PRIEST;
            case QUEST_SORT_DRUID -> PlayerClass.CLASS_DRUID;
            case QUEST_SORT_DEATH_KNIGHT -> PlayerClass.CLASS_DEATH_KNIGHT;
            case QUEST_SORT_DEMON_HUNTER -> PlayerClass.CLASS_DEMON_HUNTER;
            default -> PlayerClass.CLASS_NONE;
        };
    }

    ;

    static SkillType skillByLockType(LockType locktype) {
        return switch (locktype) {
            case LOCKTYPE_HERBALISM -> SkillType.SKILL_HERBALISM;
            case LOCKTYPE_MINING -> SkillType.SKILL_MINING;
            case LOCKTYPE_FISHING -> SkillType.SKILL_FISHING;
            case LOCKTYPE_INSCRIPTION -> SkillType.SKILL_INSCRIPTION;
            case LOCKTYPE_ARCHAEOLOGY -> SkillType.SKILL_ARCHAEOLOGY;
            case LOCKTYPE_LUMBER_MILL -> SkillType.SKILL_LOGGING;
            case LOCKTYPE_CLASSIC_HERBALISM -> SkillType.SKILL_HERBALISM_2;
            case LOCKTYPE_OUTLAND_HERBALISM -> SkillType.SKILL_OUTLAND_HERBALISM;
            case LOCKTYPE_NORTHREND_HERBALISM -> SkillType.SKILL_NORTHREND_HERBALISM;
            case LOCKTYPE_CATACLYSM_HERBALISM -> SkillType.SKILL_CATACLYSM_HERBALISM;
            case LOCKTYPE_PANDARIA_HERBALISM -> SkillType.SKILL_PANDARIA_HERBALISM;
            case LOCKTYPE_DRAENOR_HERBALISM -> SkillType.SKILL_DRAENOR_HERBALISM;
            case LOCKTYPE_LEGION_HERBALISM -> SkillType.SKILL_LEGION_HERBALISM;
            case LOCKTYPE_KUL_TIRAN_HERBALISM -> SkillType.SKILL_KUL_TIRAN_HERBALISM;
            case LOCKTYPE_CLASSIC_MINING -> SkillType.SKILL_MINING_2;
            case LOCKTYPE_OUTLAND_MINING -> SkillType.SKILL_OUTLAND_MINING;
            case LOCKTYPE_NORTHREND_MINING -> SkillType.SKILL_NORTHREND_MINING;
            case LOCKTYPE_CATACLYSM_MINING -> SkillType.SKILL_CATACLYSM_MINING;
            case LOCKTYPE_PANDARIA_MINING -> SkillType.SKILL_PANDARIA_MINING;
            case LOCKTYPE_DRAENOR_MINING -> SkillType.SKILL_DRAENOR_MINING;
            case LOCKTYPE_LEGION_MINING -> SkillType.SKILL_LEGION_MINING;
            case LOCKTYPE_KUL_TIRAN_MINING -> SkillType.SKILL_KUL_TIRAN_MINING;
            default -> SkillType.SKILL_NONE;
        };
    }

    static SkillType skillByQuestSort(QuestSort QuestSort) {
        return switch (QuestSort) {
            case QUEST_SORT_HERBALISM -> SkillType.SKILL_HERBALISM;
            case QUEST_SORT_FISHING -> SkillType.SKILL_FISHING;
            case QUEST_SORT_BLACKSMITHING -> SkillType.SKILL_BLACKSMITHING;
            case QUEST_SORT_ALCHEMY -> SkillType.SKILL_ALCHEMY;
            case QUEST_SORT_LEATHERWORKING -> SkillType.SKILL_LEATHERWORKING;
            case QUEST_SORT_ENGINEERING -> SkillType.SKILL_ENGINEERING;
            case QUEST_SORT_TAILORING -> SkillType.SKILL_TAILORING;
            case QUEST_SORT_COOKING -> SkillType.SKILL_COOKING;
            case QUEST_SORT_JEWELCRAFTING -> SkillType.SKILL_JEWELCRAFTING;
            case QUEST_SORT_INSCRIPTION -> SkillType.SKILL_INSCRIPTION;
            case QUEST_SORT_ARCHAEOLOGY -> SkillType.SKILL_ARCHAEOLOGY;
            default -> SkillType.SKILL_NONE;
        };
    }


    byte PLAYER_CORPSE_LOOT_ENTRY = 1;


    byte MAX_WEATHER_TYPE = 4;


    int GM_SILENCE_AURA = 1852;


    byte MAX_PET_DIET = 9;

    byte CHAIN_SPELL_JUMP_RADIUS = 8;


    byte MAX_TOTEM_SLOT = 5;
    byte MAX_GAMEOBJECT_SLOT = 4;


    byte PVP_TEAMS_COUNT = 2;


    short MAX_BATTLEGROUND_TYPE_ID = 845;


    int CURRENCY_PRECISION = 100;


    byte MAX_ACCOUNT_TUTORIAL_VALUES = 8;

    // max+1 for player race
    int MAX_RACES = Race.RACE_COMPANION_PTERRODAX.ordinal();


}


