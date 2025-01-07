package com.github.azeroth.game.condition;

/*! Documentation on implementing a new ConditionSourceType:
    Step 1: Check for the lowest free ID. Look for CONDITION_SOURCE_TYPE_UNUSED_XX in the enum.
            Then define the new source type.

    Step 2: Determine and map the parameters for the new condition source type.

    Step 3: Add a case block to ConditionMgr::isSourceTypeValid with the new condition type
            and validate the parameters.

    Step 4: If your condition can be grouped (determined in step 2), add a rule for it in
            ConditionMgr::CanHaveSourceGroupSet, following the example of the existing types.

    Step 5: Define the maximum available condition targets in ConditionMgr::GetMaxAvailableConditionTargets.

    Step 6: Define ConditionSourceType Name in ConditionMgr::StaticSourceTypeData.

    The following steps only apply if your condition can be grouped:

    Step 7: Determine how you are going to store your conditions. You need to add a new storage container
            for it in ConditionMgr class, along with a function like:
            ConditionList GetConditionsForXXXYourNewSourceTypeXXX(parameters...)

            The above function should be placed in upper level (practical) code that actually
            checks the conditions.

    Step 8: Implement loading for your source type in ConditionMgr::LoadConditions.

    Step 9: Implement memory cleaning for your source type in ConditionMgr::Clean.
*/

public enum ConditionSourceType {

    NONE,
    CREATURE_LOOT_TEMPLATE,
    DISENCHANT_LOOT_TEMPLATE,
    FISHING_LOOT_TEMPLATE,
    GAMEOBJECT_LOOT_TEMPLATE,
    ITEM_LOOT_TEMPLATE,
    MAIL_LOOT_TEMPLATE,
    MILLING_LOOT_TEMPLATE,
    PICKPOCKETING_LOOT_TEMPLATE,
    PROSPECTING_LOOT_TEMPLATE,
    REFERENCE_LOOT_TEMPLATE,
    SKINNING_LOOT_TEMPLATE,
    SPELL_LOOT_TEMPLATE,
    SPELL_IMPLICIT_TARGET,
    GOSSIP_MENU,
    GOSSIP_MENU_OPTION,
    CREATURE_TEMPLATE_VEHICLE,
    SPELL,
    SPELL_CLICK_EVENT,
    QUEST_AVAILABLE,
    // Condition source type 20 unused
    VEHICLE_SPELL,
    SMART_EVENT,
    NPC_VENDOR,
    SPELL_PROC,
    TERRAIN_SWAP,
    PHASE,
    GRAVEYARD,
    AREATRIGGER,
    CONVERSATION_LINE,
    AREATRIGGER_CLIENT_TRIGGERED,
    TRAINER_SPELL,
    OBJECT_ID_VISIBILITY,
    SPAWN_GROUP,
    PLAYER_CONDITION;
}
