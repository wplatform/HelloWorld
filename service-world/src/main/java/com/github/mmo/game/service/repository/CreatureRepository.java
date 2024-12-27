package com.github.mmo.game.service.repository;


import com.github.mmo.game.service.domain.creature.TempSummonData;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

public interface CreatureRepository {

    @Query(value = """
            SELECT creature.guid, id, map, position_x, position_y,
                   position_z,
                   orientation,
                   modelid,
                   equipment_id,
                   spawntimesecs,
                   wander_distance,
                   currentwaypoint,
                   MovementType,
                   spawnDifficulties,
                   eventEntry,
                   poolSpawnId,
                   creature.npcflag,
                   creature.unit_flags,
                   creature.unit_flags2,
                   creature.unit_flags3,
                   creature.phaseUseFlags,
                   creature.phaseid,
                   creature.phasegroup,
                   creature.terrainSwapMap,
                   creature.ScriptName,
                   creature.StringId
            FROM creature
                     LEFT OUTER JOIN game_event_creature ON creature.guid = game_event_creature.guid
                     LEFT OUTER JOIN pool_members ON pool_members.type = 0 AND creature.guid = pool_members.spawnId
            """)
    Object streamAllCreature();

    @Transactional(readOnly = true)
    @Query("SELECT summonerId, summonerType, groupId, entry, position_x, position_y, position_z, orientation, summonType, summonTime FROM creature_summon_groups")
    Stream<TempSummonData> streamsAllTempSummon();
}
