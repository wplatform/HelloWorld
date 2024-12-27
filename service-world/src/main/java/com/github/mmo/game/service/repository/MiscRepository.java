package com.github.mmo.game.service.repository;


import com.github.mmo.game.service.domain.misc.*;
import com.github.mmo.game.service.domain.misc.ClassExpansionRequirement;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;
@Repository
public interface MiscRepository {

    @Transactional(readOnly = true)
    @Query("SELECT entry, content_default, content_loc1, content_loc2, content_loc3, content_loc4, content_loc5, content_loc6, content_loc7, content_loc8 FROM trinity_string")
    Stream<TrinityString> queryAllTrinityString();

    @Transactional(readOnly = true)
    @Query("SELECT raceID, expansion, achievementId FROM `race_unlock_requirement`")
    Stream<RaceUnlockRequirement> queryAllRaceUnlockRequirement();

    @Transactional(readOnly = true)
    @Query("SELECT classID, raceID, activeExpansionLevel, AccountExpansionLevel FROM `class_expansion_requirement`")
    Stream<ClassExpansionRequirement> queryAllClassExpansionRequirement();

    @Transactional(readOnly = true)
    @Query("SELECT map, parent, script FROM instance_template")
    Stream<InstanceTemplate> streamAllInstanceTemplate();

    @Transactional(readOnly = true)
    @Query("SELECT id, position_x, position_y, position_z, orientation, map, name FROM game_tele")
    Stream<GameTele> streamAllGameTeleport();

    @Transactional(readOnly = true)
    @Query("SELECT ID, `text`, nextPageID, playerConditionID, Flags FROM page_text")
    Stream<PageText> streamAllPageText();

    @Transactional(readOnly = true)
    @Query("SELECT level, basexp FROM exploration_basexp")
    Stream<ExplorationBaseXp> streamsAllExplorationBaseXp();

    @Transactional(readOnly = true)
    @Query("SELECT level, raceMask, mailTemplateId, senderEntry FROM mail_level_reward")
    Stream<MailLevelReward> streamsAllMailLevelReward();

    @Query("SELECT level, raceMask, mailTemplateId, senderEntry FROM mail_level_reward")
    List<Integer> queryAllTavernAreaTriggers();

    @Query("SELECT id, speed, treatSpeedAsMoveTimeSeconds, jumpGravity, spellVisualId, progressCurveId, parabolicCurveId FROM jump_charge_params")
    List<JumpChargeParams> queryAllJumpChargeParams();
}
