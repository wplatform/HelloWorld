package com.github.azeroth.game.domain.script;

public enum ScriptCommand {
    TALK                  ,                // source/target = Creature, target = any, datalong = talk type (see ChatType enum), datalong2 & 1 = player talk (instead of creature), dataint = string_id
    EMOTE                 ,                // source/target = Creature, datalong = emote id, datalong2 = 0: set emote state; > 0: play emote state
    FIELD_SET_DEPRECATED  ,
    MOVE_TO               ,                // source/target = Creature, datalong2 = time to reach, x/y/z = destination
    FLAG_SET_DEPRECATED   ,
    FLAG_REMOVE_DEPRECATED,
    TELEPORT_TO           ,                // source/target = Creature/Player (see datalong2), datalong = map_id, datalong2 = 0: Player; 1: Creature, x/y/z = destination, o = orientation
    QUEST_EXPLORED        ,                // target/source = Player, target/source = GO/Creature, datalong = quest id, datalong2 = distance or 0
    KILL_CREDIT           ,                // target/source = Player, datalong = creature entry, datalong2 = 0: personal credit, 1: group credit
    RESPAWN_GAMEOBJECT    ,                // source = WorldObject (summoner), datalong = GO guid, datalong2 = despawn delay
    TEMP_SUMMON_CREATURE  ,               // source = WorldObject (summoner), datalong = creature entry, datalong2 = despawn delay, x/y/z = summon position, o = orientation
    OPEN_DOOR             ,               // source = Unit, datalong = GO guid, datalong2 = reset delay (min 15)
    CLOSE_DOOR            ,               // source = Unit, datalong = GO guid, datalong2 = reset delay (min 15)
    ACTIVATE_OBJECT       ,               // source = Unit, target = GO
    REMOVE_AURA           ,               // source (datalong2 != 0) or target (datalong2 == 0) = Unit, datalong = spell id
    CAST_SPELL            ,               // source and/or target = Unit, datalong2 = cast direction (0: s->t 1: s->s 2: t->t 3: t->s 4: s->creature with dataint entry), dataint & 1 = triggered flag
    PLAY_SOUND            ,               // source = WorldObject, target = none/Player, datalong = sound id, datalong2 (bitmask: 0/1=anyone/player, 0/2=without/with distance dependency, so 1|2 = 3 is target with distance dependency)
    CREATE_ITEM           ,               // target/source = Player, datalong = item entry, datalong2 = amount
    DESPAWN_SELF          ,               // target/source = Creature, datalong = despawn delay

    LOAD_PATH             ,               // source = Unit, datalong = path id, datalong2 = is repeatable
    CALLSCRIPT_TO_UNIT    ,               // source = WorldObject (if present used as a search center), datalong = script id, datalong2 = unit lowguid, dataint = script table to use (see ScriptsType)
    KILL                  ,               // source/target = Creature, dataint = remove corpse attribute

    // TrinityCore only
    ORIENTATION           ,               // source = Unit, target (datalong > 0) = Unit, datalong = > 0 turn source to face target, o = orientation
    EQUIP                 ,               // soucre = Creature, datalong = equipment id
    MODEL                 ,               // source = Creature, datalong = model id
    CLOSE_GOSSIP          ,               // source = Player
    PLAYMOVIE             ,               // source = Player, datalong = movie id
    MOVEMENT              ,               // source = Creature, datalong = MovementType, datalong2 = MovementDistance (wander_distance f.ex.), dataint = pathid
    PLAY_ANIMKIT                          // source = Creature, datalong = AnimKit id
    
}
