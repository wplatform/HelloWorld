package com.github.azeroth.game.service.repository;


import com.github.azeroth.game.domain.creature.*;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.stream.Stream;

public interface CreatureRepository {


    
    @Query(value = """
            SELECT entry, KillCredit1, KillCredit2, name, femaleName, subname,
                TitleAlt, IconName, RequiredExpansion, VignetteID, faction, npcflag,
                speed_walk, speed_run, scale, Classification, dmgschool, BaseAttackTime,
                RangeAttackTime, BaseVariance, RangeVariance, unit_class, unit_flags,
                unit_flags2, unit_flags3, family, trainer_class, type, VehicleId, AIName,
                MovementType, ctm.Ground, ctm.Swim, ctm.Flight, ctm.Rooted, ctm.Chase,
                ctm.Random, ctm.InteractionPauseTimer, ExperienceModifier, RacialLeader,
                movementId, RegenHealth, CreatureImmunitiesId, flags_extra, ScriptName, StringId
            FROM creature_template ct
            LEFT JOIN creature_template_movement ctm ON ct.entry = ctm.CreatureId WHERE entry = :entry OR 1 = :all
            """)
    Stream<CreatureTemplate> streamCreatureTemplate(int entry, int all);

    @Query(value = "SELECT creatureID, school, Resistance FROM creature_template_resistance")
    Stream<int[]> streamAllCreatureTemplateResistance();

    @Query(value = "SELECT creatureID, `Index`, Spell FROM creature_template_spell")
    Stream<int[]> streamAllCreatureTemplateSpell();

    @Query(value = "SELECT creatureID, creatureDisplayID, displayScale, Probability FROM creature_template_model ORDER BY Idx ASC")
    Stream<Object[]> streamAllCreatureTemplateModel();

    @Query(value = "SELECT creatureID, CreatureIDVisibleToSummoner, GroundMountDisplayID, FlyingMountDisplayID FROM creature_summoned_data")
    Stream<CreatureSummonedData> streamAllCreatureSummonedData();
    @Query(value = "SELECT entry, locale, name, nameAlt, title, TitleAlt FROM creature_template_locale")
    Stream<CreatureLocale> streamAllCreatureTemplateLocale();

    
    @Query(value = """
            SELECT creature.guid, id, map, position_x, position_y, position_z, orientation, modelid, equipment_id, spawntimesecs, wander_distance,
                   currentwaypoint, curHealthPct, MovementType, spawnDifficulties, eventEntry, poolSpawnId, creature.npcflag, creature.unit_flags,
                   creature.unit_flags2, creature.unit_flags3, creature.phaseUseFlags, creature.phaseid, creature.phasegroup, creature.terrainSwapMap,
                   creature.ScriptName, creature.StringId
            FROM creature
                   LEFT OUTER JOIN game_event_creature ON creature.guid = game_event_creature.guid
                   LEFT OUTER JOIN pool_members ON pool_members.type = 0 AND creature.guid = pool_members.spawnId
            """)
    Stream<CreatureData> streamAllCreature();

    
    @Query("SELECT summonerId, summonerType, groupId, entry, position_x, position_y, position_z, orientation, summonType, summonTime FROM creature_summon_groups")
    Stream<TempSummonData> streamsAllTempSummon();
}
