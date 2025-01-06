package com.github.mmo.game.service.repository;


import com.github.mmo.game.domain.gossip.GossipMenuItemsLocale;
import com.github.mmo.game.domain.gossip.GossipMenuOption;
import com.github.mmo.game.domain.gossip.GossipMenus;
import com.github.mmo.game.domain.misc.*;
import com.github.mmo.game.domain.misc.ClassExpansionRequirement;
import com.github.mmo.game.domain.scene.SceneTemplate;
import com.github.mmo.game.domain.spawn.SpawnGroupTemplateData;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;
@Repository
public interface MiscRepository {

    @Transactional(readOnly = true)
    @Query("SELECT entry, content_default, content_loc1, content_loc2, content_loc3, content_loc4, content_loc5, content_loc6, content_loc7, content_loc8 FROM trinity_string")
    Stream<SystemText> queryAllTrinityString();

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
    @Query("SELECT ID, locale, `Text` FROM page_text_locale")
    Stream<PageTextLocale> streamAllPageTextLocale();

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


    @Transactional(readOnly = true)
    @Query("""
            SELECT ID, Probability0, Probability1, Probability2, Probability3, Probability4, Probability5, Probability6, Probability7,
            BroadcastTextID0, BroadcastTextID1, BroadcastTextID2, BroadcastTextID3, BroadcastTextID4, BroadcastTextID5, BroadcastTextID6, BroadcastTextID7 FROM npc_text
            """)
    Stream<NpcText> streamAllNpcText();

    @Transactional(readOnly = true)
    @Query("SELECT menuId, TextId FROM gossip_menu")
    Stream<GossipMenus> streamAllGossipMenu();

    @Transactional(readOnly = true)
    @Query("""
            SELECT MenuID, GossipOptionID, OptionID, OptionNpc, OptionText, OptionBroadcastTextID, Language, Flags, ActionMenuID, ActionPoiID, GossipNpcOptionID,
                    BoxCoded, BoxMoney, BoxText, BoxBroadcastTextID, SpellID, OverrideIconID
                    FROM gossip_menu_option ORDER BY MenuID, OptionID
            """)
    Stream<GossipMenuOption> streamAllGossipMenuOption();
    @Transactional(readOnly = true)
    @Query("SELECT menuId, OptionID, locale, optionText, BoxText FROM gossip_menu_option_locale")
    Stream<GossipMenuItemsLocale> streamAllGossipMenuOptionLocale();

    @Transactional(readOnly = true)
    @Query("SELECT MenuID, FriendshipFactionID FROM gossip_menu_addon")
    Stream<GossipMenuAddon> streamAllGossipMenuAddon();

    @Transactional(readOnly = true)
    @Query("SELECT ID, positionX, positionY, positionZ, icon, flags, importance, name, WMOGroupID FROM points_of_interest")
    Stream<PointOfInterest> streamAllPointsOfInterest();

    @Transactional(readOnly = true)
    @Query("SELECT ID, locale, Name FROM points_of_interest_locale")
    Stream<PointOfInterestLocale> streamAllPointsOfInterestLocale();

    @Transactional(readOnly = true)
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_titles")
    Stream<int[]> streamAllPlayerFactionChangeTitles();

    @Transactional(readOnly = true)
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_spells")
    Stream<int[]> streamAllPlayerFactionChangeSpells();

    @Transactional(readOnly = true)
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_reputations")
    Stream<int[]> streamAllPlayerFactionChangeReputations();

    @Transactional(readOnly = true)
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_quests")
    Stream<int[]> streamAllPlayerFactionChangeQuests();

    @Transactional(readOnly = true)
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_achievement")
    Stream<int[]> streamAllPlayerFactionChangeAchievement();


    @Transactional(readOnly = true)
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_items")
    Stream<int[]> streamAllPlayerFactionChangeItem();

    @Transactional(readOnly = true)
    @Query("SELECT groupId, groupName, groupFlags FROM spawn_group_template")
    Stream<SpawnGroupTemplateData> streamAllSpawnGroupTemplate();


    @Transactional(readOnly = true)
    @Query("SELECT groupId, groupName, groupFlags FROM spawn_group_template")
    Stream<SceneTemplate> streamAllSceneTemplates();
}
