package com.github.azeroth.game.service.repository;


import com.github.azeroth.game.domain.gossip.GossipMenuItemsLocale;
import com.github.azeroth.game.domain.gossip.GossipMenuOption;
import com.github.azeroth.game.domain.gossip.GossipMenus;
import com.github.azeroth.game.domain.misc.*;
import com.github.azeroth.game.domain.misc.ClassExpansionRequirement;
import com.github.azeroth.game.domain.scene.SceneTemplate;
import com.github.azeroth.game.domain.spawn.SpawnGroupTemplateData;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;
@Repository
public interface MiscRepository {

    
    @Query("SELECT entry, content_default, content_loc1, content_loc2, content_loc3, content_loc4, content_loc5, content_loc6, content_loc7, content_loc8 FROM trinity_string")
    Stream<SystemText> streamAllMessageText();

    
    @Query("SELECT raceID, expansion, achievementId FROM `race_unlock_requirement`")
    Stream<RaceUnlockRequirement> queryAllRaceUnlockRequirement();

    
    @Query("SELECT classID, raceID, activeExpansionLevel, AccountExpansionLevel FROM `class_expansion_requirement`")
    Stream<ClassExpansionRequirement> queryAllClassExpansionRequirement();

    
    @Query("SELECT map, parent, script FROM instance_template")
    Stream<InstanceTemplate> streamAllInstanceTemplate();

    
    @Query("SELECT id, position_x, position_y, position_z, orientation, map, name FROM game_tele")
    Stream<GameTele> streamAllGameTeleport();

    
    @Query("SELECT ID, `text`, nextPageID, playerConditionID, Flags FROM page_text")
    Stream<PageText> streamAllPageText();

    
    @Query("SELECT ID, locale, `Text` FROM page_text_locale")
    Stream<PageTextLocale> streamAllPageTextLocale();

    
    @Query("SELECT level, basexp FROM exploration_basexp")
    Stream<ExplorationBaseXp> streamsAllExplorationBaseXp();

    
    @Query("SELECT level, raceMask, mailTemplateId, senderEntry FROM mail_level_reward")
    Stream<MailLevelReward> streamsAllMailLevelReward();

    @Query("SELECT level, raceMask, mailTemplateId, senderEntry FROM mail_level_reward")
    List<Integer> queryAllTavernAreaTriggers();

    @Query("SELECT id, speed, treatSpeedAsMoveTimeSeconds, jumpGravity, spellVisualId, progressCurveId, parabolicCurveId FROM jump_charge_params")
    List<JumpChargeParams> queryAllJumpChargeParams();


    
    @Query("""
            SELECT ID, Probability0, Probability1, Probability2, Probability3, Probability4, Probability5, Probability6, Probability7,
            BroadcastTextID0, BroadcastTextID1, BroadcastTextID2, BroadcastTextID3, BroadcastTextID4, BroadcastTextID5, BroadcastTextID6, BroadcastTextID7 FROM npc_text
            """)
    Stream<NpcText> streamAllNpcText();

    
    @Query("SELECT menuId, TextId FROM gossip_menu")
    Stream<GossipMenus> streamAllGossipMenu();

    
    @Query("""
            SELECT MenuID, GossipOptionID, OptionID, OptionNpc, OptionText, OptionBroadcastTextID, Language, Flags, ActionMenuID, ActionPoiID, GossipNpcOptionID,
                    BoxCoded, BoxMoney, BoxText, BoxBroadcastTextID, SpellID, OverrideIconID
                    FROM gossip_menu_option ORDER BY MenuID, OptionID
            """)
    Stream<GossipMenuOption> streamAllGossipMenuOption();
    
    @Query("SELECT menuId, OptionID, locale, optionText, BoxText FROM gossip_menu_option_locale")
    Stream<GossipMenuItemsLocale> streamAllGossipMenuOptionLocale();

    
    @Query("SELECT MenuID, FriendshipFactionID FROM gossip_menu_addon")
    Stream<GossipMenuAddon> streamAllGossipMenuAddon();

    
    @Query("SELECT ID, positionX, positionY, positionZ, icon, flags, importance, name, WMOGroupID FROM points_of_interest")
    Stream<PointOfInterest> streamAllPointsOfInterest();

    
    @Query("SELECT ID, locale, Name FROM points_of_interest_locale")
    Stream<PointOfInterestLocale> streamAllPointsOfInterestLocale();

    
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_titles")
    Stream<int[]> streamAllPlayerFactionChangeTitles();

    
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_spells")
    Stream<int[]> streamAllPlayerFactionChangeSpells();

    
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_reputations")
    Stream<int[]> streamAllPlayerFactionChangeReputations();

    
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_quests")
    Stream<int[]> streamAllPlayerFactionChangeQuests();

    
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_achievement")
    Stream<int[]> streamAllPlayerFactionChangeAchievement();


    
    @Query("SELECT alliance_id, horde_id FROM player_factionchange_items")
    Stream<int[]> streamAllPlayerFactionChangeItem();

    
    @Query("SELECT groupId, groupName, groupFlags FROM spawn_group_template")
    Stream<SpawnGroupTemplateData> streamAllSpawnGroupTemplate();


    
    @Query("SELECT groupId, groupName, groupFlags FROM spawn_group_template")
    Stream<SceneTemplate> streamAllSceneTemplates();

    
    @Query("SELECT areaId, PhaseId FROM `phase_area`")
    Stream<int[]> streamAllPhaseArea();

    
    @Query("SELECT mapId, TerrainSwapMap FROM `terrain_swap_defaults`")
    Stream<int[]> streamAllTerrainSwapDefaults();

    
    @Query("SELECT TerrainSwapMap, UiMapPhaseId  FROM `terrain_worldmap`")
    Stream<int[]> streamAllTerrainWorldMap();

    @Query("SELECT ID, GhostZone FROM graveyard_zone")
    Stream<int[]> streamAllGraveyardZone();

    @Modifying
    @Query("INSERT INTO graveyard_zone (ID, GhostZone) VALUES (:id, :ghostZone)")
    void insertGraveyardZone(int id, int ghostZone);
    
    @Query("SELECT SourceTypeOrReferenceId, SourceGroup, SourceEntry, SourceId, ElseGroup, ConditionTypeOrReference, ConditionTarget," +
            "ConditionValue1, ConditionValue2, ConditionValue3, ConditionStringValue1," +
            "NegativeCondition, ErrorType, ErrorTextId, ScriptName FROM conditions")
    Stream<int[]> streamAllConditions();


    @Query("SELECT entry, skill FROM skill_fishing_base_level")
    Stream<int[]> streamAllSkillFishingBaseLevel();


    @Query("SELECT ID, Value1, Value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9, Value10, Value11, Value12, Value13, Value14, Value15, Value16 FROM skill_tiers")
    Stream<int[]> streamAllSkillTiers();

    @Query("SELECT `ID`, `Name` FROM `phase_name`")
    Stream<Object[]> streamAllPhaseName();
}
