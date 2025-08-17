package com.github.azeroth.game.service.repository;

import com.github.azeroth.game.domain.misc.AccessRequirement;
import com.github.azeroth.game.domain.misc.InstanceEncounter;
import com.github.azeroth.game.domain.misc.InstanceSpawnGroup;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface InstanceRepository {

    @Query("SELECT mapid, difficulty, level_min, level_max, item, item2, quest_done_A, quest_done_H, completed_achievement, quest_failed_text FROM access_requirement")
    Stream<AccessRequirement> streamAllAccessRequirements();

    @Query("SELECT entry, creditType, creditEntry, lastEncounterDungeon FROM instance_encounters")
    Stream<InstanceEncounter> streamAllInstanceEncounters();

    @Query("SELECT instanceMapId, bossStateId, bossStates, spawnGroupId, flags FROM instance_spawn_groups")
    Stream<InstanceSpawnGroup> streamAllInstanceSpawnGroups();
}