package com.github.azeroth.game.service.repository;


import com.github.azeroth.game.domain.misc.RaceUnlockRequirement;
import com.github.azeroth.game.domain.misc.SystemText;
import com.github.azeroth.game.domain.misc.ClassExpansionRequirement;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Repository
public interface VehicleRepository {

    
    @Query("SELECT entry, content_default, content_loc1, content_loc2, content_loc3, content_loc4, content_loc5, content_loc6, content_loc7, content_loc8 FROM trinity_string")
    Stream<SystemText> queryAllTrinityString();

    
    @Query("SELECT raceID, expansion, achievementId FROM `race_unlock_requirement`")
    Stream<RaceUnlockRequirement> queryAllRaceUnlockRequirement();

    
    @Query("SELECT classID, raceID, activeExpansionLevel, AccountExpansionLevel FROM `class_expansion_requirement`")
    Stream<ClassExpansionRequirement> queryAllClassExpansionRequirement();
}
