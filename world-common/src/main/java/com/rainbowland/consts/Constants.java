package com.rainbowland.consts;

import com.rainbowland.enums.*;

public interface Constants {

    // used in script definitions
    int EFFECT_FIRST_FOUND = 254;
    int EFFECT_ALL = 255;


    int CLASSMASK_ALL_CREATURES = ((1 << (UnitClass.UNIT_CLASS_WARRIOR.val() - 1)) | (1 << (UnitClass.UNIT_CLASS_PALADIN.val() - 1)) | (1 << (UnitClass.UNIT_CLASS_ROGUE.val() - 1)) | (1 << (UnitClass.UNIT_CLASS_MAGE.val() - 1)));

    int CLASSMASK_WAND_USERS = ((1 << (Classes.CLASS_PRIEST.ordinal() - 1)) | (1 << (Classes.CLASS_MAGE.ordinal() - 1)) | (1 << (Classes.CLASS_WARLOCK.ordinal() - 1)));

    int PLAYER_MAX_BATTLEGROUND_QUEUES = 2;


    int MIN_REPUTATION_RANK = (ReputationRank.REP_HATED.ordinal());
    int MAX_REPUTATION_RANK = 8;

    int MAX_SPILLOVER_FACTIONS = 5;


    int MAX_STATS = 4;


    int MAX_POWERS_PER_CLASS = 6;
    int MAX_ITEM_QUALITY = 9;
    int MAX_CLASSES = 13;


    int CLASS_MASK_ALL_PLAYABLE =
            ((1 << (Classes.CLASS_WARRIOR.ordinal() - 1)) |
                    (1 << (Classes.CLASS_PALADIN.ordinal() - 1)) |
                    (1 << (Classes.CLASS_HUNTER.ordinal() - 1)) |
                    (1 << (Classes.CLASS_ROGUE.ordinal() - 1)) |
                    (1 << (Classes.CLASS_PRIEST.ordinal() - 1)) |
                    (1 << (Classes.CLASS_DEATH_KNIGHT.ordinal() - 1)) |
                    (1 << (Classes.CLASS_SHAMAN.ordinal() - 1)) |
                    (1 << (Classes.CLASS_MAGE.ordinal() - 1)) |
                    (1 << (Classes.CLASS_WARLOCK.ordinal() - 1)) |
                    (1 << (Classes.CLASS_MONK.ordinal() - 1)) |
                    (1 << (Classes.CLASS_DRUID.ordinal() - 1)) |
                    (1 << (Classes.CLASS_DEMON_HUNTER.ordinal() - 1)));

    int MIN_SPECIALIZATION_LEVEL = 10;
    int MAX_SPECIALIZATIONS = 5;
    int PET_SPEC_OVERRIDE_CLASS_INDEX = MAX_CLASSES;
    int INITIAL_SPECIALIZATION_INDEX = 4;

    int CURRENT_EXPANSION = Expansions.EXPANSION_SHADOWLANDS.ordinal();


    int MAX_SHEATHETYPE = 8;


    int PLAYER_CUSTOM_DISPLAY_SIZE = 3;


    int LANGUAGES_COUNT = 31;


    int PER_CASTER_AURA_STATE_MASK = (
            (1 << (AuraStateType.AURA_STATE_RAID_ENCOUNTER_2.ordinal() - 1)) | (1 << (AuraStateType.AURA_STATE_ROGUE_POISONED.ordinal() - 1)));


    // Used for spell 42292 Immune Movement Impairment and Loss of Control (0x49967ca6)
    int IMMUNE_TO_MOVEMENT_IMPAIRMENT_AND_LOSS_CONTROL_MASK = (
            (1 << Mechanics.MECHANIC_CHARM.ordinal()) | (1 << Mechanics.MECHANIC_DISORIENTED.ordinal()) | (1 << Mechanics.MECHANIC_FEAR.ordinal()) |
                    (1 << Mechanics.MECHANIC_ROOT.ordinal()) | (1 << Mechanics.MECHANIC_SLEEP.ordinal()) | (1 << Mechanics.MECHANIC_SNARE.ordinal()) |
                    (1 << Mechanics.MECHANIC_STUN.ordinal()) | (1 << Mechanics.MECHANIC_FREEZE.ordinal()) | (1 << Mechanics.MECHANIC_SILENCE.ordinal()) | (1 << Mechanics.MECHANIC_DISARM.ordinal()) | (1 << Mechanics.MECHANIC_KNOCKOUT.ordinal()) |
                    (1 << Mechanics.MECHANIC_POLYMORPH.ordinal()) | (1 << Mechanics.MECHANIC_BANISH.ordinal()) | (1 << Mechanics.MECHANIC_SHACKLE.ordinal()) |
                    (1 << Mechanics.MECHANIC_TURN.ordinal()) | (1 << Mechanics.MECHANIC_HORROR.ordinal()) | (1 << Mechanics.MECHANIC_DAZE.ordinal()) |
                    (1 << Mechanics.MECHANIC_SAPPED.ordinal()));


    int DISPEL_ALL_MASK = ((1 << DispelType.DISPEL_MAGIC.ordinal()) | (1 << DispelType.DISPEL_CURSE.ordinal()) | (1 << DispelType.DISPEL_DISEASE.ordinal()) | (1 << DispelType.DISPEL_POISON.ordinal()));


    int MAX_GAMEOBJECT_TYPE = 61;             // sending to client this or greater value can crash client.
    int MAX_GAMEOBJECT_DATA = 34;          // Max number of uint32 vars in gameobject_template data field

    int MAX_GO_STATE = 3;
    int MAX_GO_STATE_TRANSPORT_STOP_FRAMES = 9;


    int CREATURE_TYPEMASK_DEMON_OR_UNDEAD = (1 << (CreatureType.CREATURE_TYPE_DEMON.val() - 1)) | (1 << (CreatureType.CREATURE_TYPE_UNDEAD.val() - 1));

    int CREATURE_TYPEMASK_HUMANOID_OR_UNDEAD = (1 << (CreatureType.CREATURE_TYPE_HUMANOID.val() - 1)) | (1 << (CreatureType.CREATURE_TYPE_UNDEAD.val() - 1));

    int CREATURE_TYPEMASK_MECHANICAL_OR_ELEMENTAL = (1 << (CreatureType.CREATURE_TYPE_MECHANICAL.val() - 1)) | (1 << (CreatureType.CREATURE_TYPE_ELEMENTAL.val() - 1));

    int MAX_WEATHER_TYPE = 4;

    int GM_SILENCE_AURA = 1852;

    int MAX_PET_DIET = 9;

    int CHAIN_SPELL_JUMP_RADIUS = 8;

    int BG_TEAMS_COUNT = 2;
    int CURRENCY_PRECISION = 100;
    int PLAYER_CORPSE_LOOT_ENTRY = 1;
    int MAX_ACCOUNT_TUTORIAL_VALUES = 8;
    int MAX_BATTLEGROUND_TYPE_ID = 845;

    int MAX_CHARACTERS_PER_REALM = 200;

}