package com.github.azeroth.game.condition;




/*! Documentation on implementing a new ConditionType:
    Step 1: Check for the lowest free ID. Look for CONDITION_UNUSED_XX in the enum.
            Then define the new condition type.

    Step 2: Determine and map the parameters for the new condition type.

    Step 3: Add a case block to ConditionMgr::isConditionTypeValid with the new condition type
            and validate the parameters.

    Step 4: Define the maximum available condition targets in ConditionMgr::GetMaxAvailableConditionTargets.

    Step 5: Define the grid searcher mask in Condition::GetSearcherTypeMaskForCondition.

    Step 6: Add a case block to ConditionMgr::Meets with the new condition type.

    Step 7: Define condition name and expected condition values in ConditionMgr::StaticConditionTypeData.
*/

public enum ConditionType {
    NONE                     ,                    // 0                      0              0                  always true
    AURA                     ,                    // spell_id               effindex       0                  true if target has aura of spell_id with effect effindex
    ITEM                     ,                    // item_id                count          bank               true if has #count of item_ids (if 'bank' is set it searches in bank slots too)
    ITEM_EQUIPPED            ,                    // item_id                0              0                  true if has item_id equipped
    ZONEID                   ,                    // zone_id                0              0                  true if in zone_id
    REPUTATION_RANK          ,                    // faction_id             rankMask       0                  true if has min_rank for faction_id
    TEAM                     ,                    // player_team            0,             0                  469 - Alliance, 67 - Horde)
    SKILL                    ,                    // skill_id               skill_value    0                  true if has skill_value for skill_id
    QUEST_REWARDED            ,                    // quest_id               0              0                  true if quest_id was rewarded before
    QUEST_TAKEN               ,                    // quest_id               0,             0                  true while quest active
    DRUNKEN_STATE             ,                   // DrunkenState           0,             0                  true if player is drunk enough
    WORLD_STATE              ,                   // index                  value          0                  true if world has the value for the index
    ACTIVE_EVENT             ,                   // event_id               0              0                  true if event is active
    INSTANCE_INFO            ,                   // entry                  data           type               true if the instance info defined by type (enum InstanceInfo) equals data.
    QUEST_NONE               ,                   // quest_id               0              0                  true if doesn't have quest saved
    CLASS                    ,                   // class                  0              0                  true if player's class is equal to class
    RACE                     ,                   // race                   0              0                  true if player's race is equal to race
    ACHIEVEMENT              ,                   // achievement_id         0              0                  true if achievement is complete
    TITLE                    ,                   // title id               0              0                  true if player has title
    SPAWN_MASK_DEPRECATED     ,                   // DEPRECATED
    GENDER                   ,                   // gender                 0              0                  true if player's gender is equal to gender
    UNIT_STATE               ,                   // unitState              0              0                  true if unit has unitState
    MAP_ID                    ,                   // map_id                 0              0                  true if in map_id
    AREA_ID                   ,                   // area_id                0              0                  true if in area_id
    CREATURE_TYPE            ,                   // cinfo.type             0              0                  true if creature_template.type = value1
    SPELL                    ,                   // spell_id               0              0                  true if player has learned spell
    PHASE_ID                  ,                   // phaseid                0              0                  true if object is in phaseid
    LEVEL                    ,                   // level                  ComparisonType 0                  true if unit's level is equal to param1 (param2 can modify the statement)
    QUEST_COMPLETE           ,                   // quest_id               0              0                  true if player has quest_id with all objectives complete, but not yet rewarded
    NEAR_CREATURE            ,                   // creature entry         distance       dead (0/1)         true if there is a creature of entry in range
    NEAR_GAME_OBJECT          ,                   // gameobject entry       distance       0                  true if there is a gameobject of entry in range
    OBJECT_ENTRY_GUID_LEGACY ,                   // LEGACY_TypeID          entry          guid               true if object is type TypeID and the entry is 0 or matches entry of the object or matches guid of the object
    TYPE_MASK_LEGACY         ,                   // LEGACY_TypeMask        0              0                  true if object is type object's TypeMask matches provided TypeMask
    RELATION_TO              ,                   // ConditionTarget        RelationType   0                  true if object is in given relation with object specified by ConditionTarget
    REACTION_TO              ,                   // ConditionTarget        rankMask       0                  true if object's reaction matches rankMask object specified by ConditionTarget
    DISTANCE_TO              ,                   // ConditionTarget        distance       ComparisonType     true if object and ConditionTarget are within distance given by parameters
    ALIVE                    ,                   // 0                      0              0                  true if unit is alive
    HP_VAL                   ,                   // hpVal                  ComparisonType 0                  true if unit's hp matches given value
    HP_PCT                   ,                   // hpPct                  ComparisonType 0                  true if unit's hp matches given pct
    REALM_ACHIEVEMENT        ,                   // achievement_id         0              0                  true if realm achievement is complete
    IN_WATER                 ,                   // 0                      0              0                  true if unit in water
    TERRAIN_SWAP             ,                   // terrainSwap            0              0                  true if object is in terrainswap
    STAND_STATE              ,                   // stateType              state          0                  true if unit matches specified sitstate (0,x: has exactly state x; 1,0: any standing state; 1,1: any sitting state;)
    DAILY_QUEST_DONE         ,                   // quest id               0              0                  true if daily quest has been completed for the day
    CHARMED                  ,                   // 0                      0              0                  true if unit is currently charmed
    PET_TYPE                 ,                   // mask                   0              0                  true if player has a pet of given type(s)
    TAXI                     ,                   // 0                      0              0                  true if player is on taxi
    QUEST_STATE               ,                   // quest_id               state_mask     0                  true if player is in any of the provided quest states for the quest (1 = not taken, 2 = completed, 8 = in progress, 32 = failed, 64 = rewarded)
    QUEST_OBJECTIVE_PROGRESS ,                   // ID                     0              progressValue      true if player has ID objective progress equal to ConditionValue3 (and quest is in quest log)
    DIFFICULTY_ID            ,                   // Difficulty             0              0                  true is map has difficulty id
    GAME_MASTER               ,                   // canBeGM                0              0                  true if player is gamemaster (or can be gamemaster)
    OBJECT_ENTRY_GUID        ,                   // TypeID                 entry          guid               true if object is type TypeID and the entry is 0 or matches entry of the object or matches guid of the object
    TYPE_MASK                ,                   // TypeMask               0              0                  true if object is type object's TypeMask matches provided TypeMask
    BATTLE_PET_COUNT         ,                   // SpecieId               count          ComparisonType     true if player has `count` of battle pet species
    SCENARIO_STEP            ,                   // ScenarioStepId         0              0                  true if player is at scenario with current step equal to ScenarioStepID
    SCENE_IN_PROGRESS        ,                   // SceneScriptPackageId   0              0                  true if player is playing a scene with ScriptPackageId equal to given value
    PLAYER_CONDITION         ,                   // PlayerConditionId      0              0                  true if player satisfies PlayerCondition
    PRIVATE_OBJECT           ,                   // 0                      0              0                  true if entity is private object
    STRING_ID                ,
    LABEL                    ,                   // Label                  0              0                  true if creature/gameobject has specified Label in CreatureLabel.db2/GameObjectLabel.db2
}
