package com.github.azeroth.hotfixes.repository;

import com.github.azeroth.dbc.domain.*;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.stream.Stream;

/*
  将C:\CodeRepo\HelloWorld\service-hotfixes\src\main\java\com\github\azeroth\hotfixes\repository\HotfixDatabase.cpp
  中的所有sql转换为spring data jdbc 实现， 用Query，
  查询用Stream<>类型返回。在C:\CodeRepo\HelloWorld\service-hotfixes\src\main\java\com\github\azeroth\dbc\domain下面栽到对应的实体类

  将C:\CodeRepo\HelloWorld\service-auth\src\main\java\com\github\azeroth\service\auth\repository\LoginDatabase.cpp
  中的所有sql转换为spring data jdbc 实现， 用@Query写sql，查询用List<>类型返回。生成的代码放置C:\CodeRepo\HelloWorld\service-auth\src\main\java\com\github\azeroth\service\auth\repository\Repository.java

 */
public interface Repository extends CrudRepository<Object, Integer> {
    // Achievement queries
    @Query("SELECT Description, Title, Reward, ID, InstanceID, Faction, Supercedes, Category, MinimumCriteria, Points, Flags, UiOrder, IconFileID, CriteriaTree, SharesCriteria FROM achievement WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<Achievement> selectAchievements(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM achievement")
    Integer selectMaxAchievementId();

    @Query("SELECT ID, Description_lang, Title_lang, Reward_lang FROM achievement_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<Achievement> selectAchievementLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // AchievementCategory queries
    @Query("SELECT Name, ID, Parent, UiOrder FROM achievement_category WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<AchievementCategory> selectAchievementCategories(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM achievement_category")
    Integer selectMaxAchievementCategoryId();

    @Query("SELECT ID, Name_lang FROM achievement_category_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<AchievementCategory> selectAchievementCategoryLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // AnimationData queries
    @Query("SELECT ID, Fallback, BehaviorTier, BehaviorID, Flags FROM animation_data WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<AnimationData> selectAnimationData(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM animation_data")
    Integer selectMaxAnimationDataId();

    // ChrRaces queries
    @Query("SELECT ID, Name, Flags, FactionID, MaleModelID, FemaleModelID, TeamID, CinematicSequenceID FROM chr_races WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ChrRaces> selectChrRaces(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM chr_races")
    Integer selectMaxChrRacesId();

    @Query("SELECT ID, Name_lang, Description_lang FROM chr_races_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<ChrRaces> selectChrRacesLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // ChrClasses queries
    @Query("SELECT ID, Name, Mask, PowerType, Flags, PetNameToken, RacialLeader, CinematicSequenceID FROM chr_classes WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ChrClasses> selectChrClasses(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM chr_classes")
    Integer selectMaxChrClassesId();

    @Query("SELECT ID, Name_lang, NameFemale_lang, Tooltip_lang FROM chr_classes_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<ChrClasses> selectChrClassesLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // ChrCustomizationChoice queries
    @Query("SELECT ID, ChrCustomizationOptionID, ChrCustomizationElementID, Flags, OrderIndex FROM chr_customization_choice WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ChrCustomizationChoice> selectChrCustomizationChoices(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM chr_customization_choice")
    Integer selectMaxChrCustomizationChoiceId();

    @Query("SELECT ID, Name_lang, Description_lang FROM chr_customization_choice_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<ChrCustomizationChoice> selectChrCustomizationChoiceLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // ChrCustomizationDisplayInfo queries
    @Query("SELECT ID, ChrCustomizationElementID, DisplayInfoID, RaceID, Gender, Flags FROM chr_customization_display_info WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ChrCustomizationDisplayInfo> selectChrCustomizationDisplayInfos(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM chr_customization_display_info")
    Integer selectMaxChrCustomizationDisplayInfoId();

    // ChrCustomizationElement queries
    @Query("SELECT ID, ChrCustomizationOptionID, Type, Flags, OrderIndex FROM chr_customization_element WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ChrCustomizationElement> selectChrCustomizationElements(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM chr_customization_element")
    Integer selectMaxChrCustomizationElementId();

    @Query("SELECT ID, Name_lang, Description_lang FROM chr_customization_element_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<ChrCustomizationElement> selectChrCustomizationElementLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // ChrCustomizationOption queries
    @Query("SELECT ID, ChrRaceID, ChrClassID, Flags, OrderIndex FROM chr_customization_option WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ChrCustomizationOption> selectChrCustomizationOptions(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM chr_customization_option")
    Integer selectMaxChrCustomizationOptionId();

    @Query("SELECT ID, Name_lang, Description_lang FROM chr_customization_option_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<ChrCustomizationOption> selectChrCustomizationOptionLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // ChrClassesXPowerTypes queries
    @Query("SELECT ID, ChrClassID, PowerType FROM chr_classes_x_power_types WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ChrClassesXPowerTypes> selectChrClassesXPowerTypes(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM chr_classes_x_power_types")
    Integer selectMaxChrClassesXPowerTypesId();

    // ChrModel queries
    @Query("SELECT ID, Flags, BoundingRadius, CombatReach, DisplayID, NameSound, ModelScale, BloodLevel, BloodType, FootprintTexture, FootprintTextureLength, FoleyMaterialID, FootstepShakeSize, DeathThudShakeSize, SoundDataID, ParticleColorID, CreatureGeosetDataID, ObjectEffectPackageID FROM chr_model WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ChrModel> selectChrModels(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM chr_model")
    Integer selectMaxChrModelId();

    @Query("SELECT ID, Name_lang FROM chr_model_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<ChrModel> selectChrModelLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // ChrRaceXChrModel queries
    @Query("SELECT ID, ChrRaceID, ChrModelID, Flags FROM chr_race_x_chr_model WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ChrRaceXChrModel> selectChrRaceXChrModels(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM chr_race_x_chr_model")
    Integer selectMaxChrRaceXChrModelId();

    // ChrCustomizationReq queries
    @Query("SELECT ID, ChrCustomizationOptionID, ReqType, ReqId, ReqSourceType, ReqSourceGroup, ReqSourceId, Operator, Value, VerifiedBuild FROM chr_customization_req WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ChrCustomizationReq> selectChrCustomizationReqs(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM chr_customization_req")
    Integer selectMaxChrCustomizationReqId();

    // CinematicCamera queries
    @Query("SELECT ID, Name, Flags, ScriptName, CameraID, Priority, VerifiedBuild FROM cinematic_camera WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CinematicCamera> selectCinematicCameras(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM cinematic_camera")
    Integer selectMaxCinematicCameraId();

    @Query("SELECT ID, Name_lang FROM cinematic_camera_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CinematicCamera> selectCinematicCameraLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // ConditionalChrModel queries
    @Query("SELECT ID, ChrModelID, ConditionID, VerifiedBuild FROM conditional_chr_model WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ConditionalChrModel> selectConditionalChrModels(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM conditional_chr_model")
    Integer selectMaxConditionalChrModelId();

    // CinematicSequences queries
    @Query("SELECT ID, Name, CameraID, Flags, VerifiedBuild FROM cinematic_sequences WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CinematicSequences> selectCinematicSequences(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM cinematic_sequences")
    Integer selectMaxCinematicSequenceId();

    @Query("SELECT ID, Name_lang FROM cinematic_sequences_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CinematicSequences> selectCinematicSequenceLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // ConditionalContentTuning queries
    @Query("SELECT ID, ContentTuningID, ConditionID, VerifiedBuild FROM conditional_content_tuning WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ConditionalContentTuning> selectConditionalContentTunings(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM conditional_content_tuning")
    Integer selectMaxConditionalContentTuningId();

    // ContentTuning queries
    @Query("SELECT ID, Flags, MinLevel, MaxLevel, ContentTuningType, VerifiedBuild FROM content_tuning WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ContentTuning> selectContentTunings(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM content_tuning")
    Integer selectMaxContentTuningId();

    // ConversationLine queries
    @Query("SELECT ID, ConversationID, LineNumber, Text, Type, SoundID, EmoteID, VerifiedBuild FROM conversation_line WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<ConversationLine> selectConversationLines(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM conversation_line")
    Integer selectMaxConversationLineId();

    @Query("SELECT ID, Text_lang FROM conversation_line_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<ConversationLine> selectConversationLineLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureDisplayInfo queries
    @Query("SELECT ID, ModelID, SoundID, ExtendedDisplayInfoID, CreatureModelScale, CreatureModelAlpha, TextureVariation, VerifiedBuild FROM creature_display_info WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureDisplayInfo> selectCreatureDisplayInfos(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_display_info")
    Integer selectMaxCreatureDisplayInfoId();

    // CreatureDisplayInfoExtra queries
    @Query("SELECT ID, CreatureDisplayInfoID, DisplayInfoExtraType, Value, VerifiedBuild FROM creature_display_info_extra WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureDisplayInfoExtra> selectCreatureDisplayInfoExtras(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_display_info_extra")
    Integer selectMaxCreatureDisplayInfoExtraId();

    // CreatureFamily queries
    @Query("SELECT ID, Name, Flags, PetFoodMask, MinScale, MaxScale, MinLevel, MaxLevel, PetTalentType, VerifiedBuild FROM creature_family WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureFamily> selectCreatureFamilies(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_family")
    Integer selectMaxCreatureFamilyId();

    @Query("SELECT ID, Name_lang FROM creature_family_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureFamily> selectCreatureFamilyLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureModelInfo queries
    @Query("SELECT ID, ModelID, SoundID, ExtendedDisplayInfoID, CreatureModelScale, CreatureModelAlpha, TextureVariation, VerifiedBuild FROM creature_model_info WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureModelInfo> selectCreatureModelInfos(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_model_info")
    Integer selectMaxCreatureModelInfoId();

    @Query("SELECT ID, Name_lang FROM creature_model_info_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureModelInfo> selectCreatureModelInfoLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // Creature queries
    @Query("SELECT ID, Name, Health, Level, Faction, ModelID, VerifiedBuild FROM creature WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<Creature> selectCreatures(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature")
    Integer selectMaxCreatureId();

    @Query("SELECT ID, Name_lang, Description_lang FROM creature_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<Creature> selectCreatureLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureTemplate queries
    @Query("SELECT ID, Name, Health, Level, Faction, ModelID, UnitClass, VerifiedBuild FROM creature_template WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureTemplate> selectCreatureTemplates(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_template")
    Integer selectMaxCreatureTemplateId();

    @Query("SELECT ID, Name_lang, Title_lang, Description_lang FROM creature_template_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureTemplate> selectCreatureTemplateLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureTexture queries
    @Query("SELECT ID, CreatureDisplayInfoID, TextureID, Flags, VerifiedBuild FROM creature_texture WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureTexture> selectCreatureTextures(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_texture")
    Integer selectMaxCreatureTextureId();

    @Query("SELECT ID, Name_lang FROM creature_texture_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureTexture> selectCreatureTextureLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureEquipTemplate queries
    @Query("SELECT ID, CreatureID, EquipmentID, Slot, VerifiedBuild FROM creature_equip_template WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureEquipTemplate> selectCreatureEquipTemplates(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_equip_template")
    Integer selectMaxCreatureEquipTemplateId();

    @Query("SELECT ID, Name_lang FROM creature_equip_template_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureEquipTemplate> selectCreatureEquipTemplateLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureSpell queries
    @Query("SELECT ID, CreatureID, SpellID, Flags, VerifiedBuild FROM creature_spell WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureSpell> selectCreatureSpells(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_spell")
    Integer selectMaxCreatureSpellId();

    @Query("SELECT ID, Name_lang FROM creature_spell_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureSpell> selectCreatureSpellLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiScripts queries
    @Query("SELECT ID, CreatureID, ScriptName, EventType, EventParam1, EventParam2, VerifiedBuild FROM creature_ai_scripts WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiScript> selectCreatureAiScripts(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_scripts")
    Integer selectMaxCreatureAiScriptId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_scripts_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiScript> selectCreatureAiScriptLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureLootTemplate queries
    @Query("SELECT ID, CreatureID, ItemID, Reference, Chance, QuestRequired, VerifiedBuild FROM creature_loot_template WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureLootTemplate> selectCreatureLootTemplates(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_loot_template")
    Integer selectMaxCreatureLootTemplateId();

    @Query("SELECT ID, Name_lang FROM creature_loot_template_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureLootTemplate> selectCreatureLootTemplateLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureQuestItem queries
    @Query("SELECT ID, CreatureID, ItemID, VerifiedBuild FROM creature_questitem WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureQuestItem> selectCreatureQuestItems(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_questitem")
    Integer selectMaxCreatureQuestItemId();

    // CreatureQuestStarter queries
    @Query("SELECT ID, CreatureID, QuestID, VerifiedBuild FROM creature_queststarter WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureQuestStarter> selectCreatureQuestStarters(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_queststarter")
    Integer selectMaxCreatureQuestStarterId();

    // CreatureQuestEnder queries
    @Query("SELECT ID, CreatureID, QuestID, VerifiedBuild FROM creature_questender WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureQuestEnder> selectCreatureQuestEnders(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_questender")
    Integer selectMaxCreatureQuestEnderId();

    // CreatureQuestGiver queries
    @Query("SELECT ID, CreatureID, QuestID, VerifiedBuild FROM creature_questgiver WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureQuestGiver> selectCreatureQuestGivers(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_questgiver")
    Integer selectMaxCreatureQuestGiverId();

    // CreatureWaypoint queries
    @Query("SELECT ID, CreatureID, PointX, PointY, PointZ, Orientation, WaitTime, VerifiedBuild FROM creature_waypoint WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureWaypoint> selectCreatureWaypoints(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_waypoint")
    Integer selectMaxCreatureWaypointId();

    // CreatureText queries
    @Query("SELECT ID, CreatureID, GroupID, Text, Type, Language, Probability, Emote, Duration, Sound, BroadcastTextId, VerifiedBuild FROM creature_text WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureText> selectCreatureTexts(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_text")
    Integer selectMaxCreatureTextId();

    @Query("SELECT ID, Text_lang FROM creature_text_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureText> selectCreatureTextLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureTemplateAddon queries
    @Query("SELECT ID, CreatureID, MountID, Bytes1, Bytes2, Emote, VisibleItem1, VisibleItem2, VisibleItem3, VerifiedBuild FROM creature_template_addon WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureTemplateAddon> selectCreatureTemplateAddons(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_template_addon")
    Integer selectMaxCreatureTemplateAddonId();

    // CreatureMovement queries
    @Query("SELECT ID, CreatureID, PointX, PointY, PointZ, Orientation, WaitTime, ScriptId, VerifiedBuild FROM creature_movement WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureMovement> selectCreatureMovements(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_movement")
    Integer selectMaxCreatureMovementId();

    // CreatureSpawnData queries
    @Query("SELECT ID, CreatureID, SpawnDataID, VerifiedBuild FROM creature_spawn_data WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureSpawnData> selectCreatureSpawnDatas(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_spawn_data")
    Integer selectMaxCreatureSpawnDataId();

    // CreatureSpawnDataTemplate queries
    @Query("SELECT ID, CreatureSpawnDataID, ModelID, EquipmentID, VerifiedBuild FROM creature_spawn_data_template WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureSpawnDataTemplate> selectCreatureSpawnDataTemplates(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_spawn_data_template")
    Integer selectMaxCreatureSpawnDataTemplateId();

    // CreatureSpawnEntry queries
    @Query("SELECT ID, CreatureID, SpawnEntryID, VerifiedBuild FROM creature_spawn_entry WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureSpawnEntry> selectCreatureSpawnEntries(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_spawn_entry")
    Integer selectMaxCreatureSpawnEntryId();

    // CreatureRespawn queries
    @Query("SELECT ID, CreatureID, RespawnTime, VerifiedBuild FROM creature_respawn WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureRespawn> selectCreatureRespawns(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_respawn")
    Integer selectMaxCreatureRespawnId();

    // CreatureAiTexts queries
    @Query("SELECT ID, CreatureID, GroupID, Text, Type, Language, Probability, Emote, Duration, Sound, BroadcastTextId, VerifiedBuild FROM creature_ai_texts WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiText> selectCreatureAiTexts(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_texts")
    Integer selectMaxCreatureAiTextId();

    @Query("SELECT ID, Text_lang FROM creature_ai_texts_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiText> selectCreatureAiTextLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureSkinningLootTemplate queries
    @Query("SELECT ID, CreatureID, ItemID, Reference, Chance, GroupId, MinCount, MaxCount, VerifiedBuild FROM creature_skinning_loot_template WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureSkinningLootTemplate> selectCreatureSkinningLootTemplates(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_skinning_loot_template")
    Integer selectMaxCreatureSkinningLootTemplateId();

    @Query("SELECT ID, Name_lang FROM creature_skinning_loot_template_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureSkinningLootTemplate> selectCreatureSkinningLootTemplateLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureTameData queries
    @Query("SELECT ID, CreatureID, TameSkillID, RequiredLevel, VerifiedBuild FROM creature_tame_data WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureTameData> selectCreatureTameDatas(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_tame_data")
    Integer selectMaxCreatureTameDataId();

    // CreatureVehicle queries
    @Query("SELECT ID, CreatureID, VehicleID, Flags, VerifiedBuild FROM creature_vehicle WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureVehicle> selectCreatureVehicles(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_vehicle")
    Integer selectMaxCreatureVehicleId();

    @Query("SELECT ID, Name_lang FROM creature_vehicle_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureVehicle> selectCreatureVehicleLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiSchedule queries
    @Query("SELECT ID, CreatureID, ScheduleID, VerifiedBuild FROM creature_ai_schedule WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiSchedule> selectCreatureAiSchedules(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_schedule")
    Integer selectMaxCreatureAiScheduleId();

    @Query("SELECT ID, Name_lang FROM creature_ai_schedule_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiSchedule> selectCreatureAiScheduleLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiBehavior queries
    @Query("SELECT ID, CreatureID, GroupID, BehaviorType, ActionType, TargetType, TargetParam1, TargetParam2, TargetParam3, TargetParam4, TargetParam5, TargetParam6, TargetParam7, TargetParam8, TargetParam9, TargetParam10, TargetParam11, TargetParam12, Chance, Cooldown, Repeat, Comment, VerifiedBuild FROM creature_ai_behavior WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiBehavior> selectCreatureAiBehaviors(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_behavior")
    Integer selectMaxCreatureAiBehaviorId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_behavior_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiBehavior> selectCreatureAiBehaviorLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiBehaviorParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_behavior_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiBehaviorParam> selectCreatureAiBehaviorParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_behavior_param")
    Integer selectMaxCreatureAiBehaviorParamId();

    // CreatureAiEmote queries
    @Query("SELECT ID, CreatureID, GroupID, EmoteID, Probability, ConditionType, ConditionValue1, ConditionValue2, VerifiedBuild FROM creature_ai_emote WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiEmote> selectCreatureAiEmotes(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_emote")
    Integer selectMaxCreatureAiEmoteId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_emote_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiEmote> selectCreatureAiEmoteLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiSpell queries
    @Query("SELECT ID, CreatureID, GroupID, SpellID, CastFlags, TargetType, TargetParam1, TargetParam2, TargetParam3, TargetParam4, TargetParam5, TargetParam6, TargetParam7, TargetParam8, TargetParam9, TargetParam10, Cooldown, Repeat, Comment, VerifiedBuild FROM creature_ai_spell WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiSpell> selectCreatureAiSpells(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_spell")
    Integer selectMaxCreatureAiSpellId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_spell_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiSpell> selectCreatureAiSpellLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiSpellParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_spell_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiSpellParam> selectCreatureAiSpellParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_spell_param")
    Integer selectMaxCreatureAiSpellParamId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_spell_param_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiSpellParam> selectCreatureAiSpellParamLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiWalkPoints queries
    @Query("SELECT ID, CreatureID, PointID, X, Y, Z, Orientation, WaitTime, ScriptId, VerifiedBuild FROM creature_ai_walk_points WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiWalkPoint> selectCreatureAiWalkPoints(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_walk_points")
    Integer selectMaxCreatureAiWalkPointId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_walk_points_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiWalkPoint> selectCreatureAiWalkPointLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiAggro queries
    @Query("SELECT ID, CreatureID, AggroRange, AggroDelay, VerifiedBuild FROM creature_ai_aggro WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiAggro> selectCreatureAiAggros(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_aggro")
    Integer selectMaxCreatureAiAggroId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_aggro_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiAggro> selectCreatureAiAggroLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiAggroParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_aggro_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiAggroParam> selectCreatureAiAggroParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_aggro_param")
    Integer selectMaxCreatureAiAggroParamId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_aggro_param_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiAggroParam> selectCreatureAiAggroParamLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiAuras queries
    @Query("SELECT ID, CreatureID, AuraID, ApplicationType, Chance, Cooldown, VerifiedBuild FROM creature_ai_auras WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiAura> selectCreatureAiAuras(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_auras")
    Integer selectMaxCreatureAiAuraId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_auras_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiAura> selectCreatureAiAuraLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiAurasParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_auras_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiAuraParam> selectCreatureAiAurasParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_auras_param")
    Integer selectMaxCreatureAiAuraParamId();

    // CreatureAiAvoidance queries
    @Query("SELECT ID, CreatureID, Type, TriggerType, Radius, Height, VerifiedBuild FROM creature_ai_avoidance WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiAvoidance> selectCreatureAiAvoidances(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_avoidance")
    Integer selectMaxCreatureAiAvoidanceId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_avoidance_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiAvoidance> selectCreatureAiAvoidanceLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiAvoidanceParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_avoidance_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiAvoidanceParam> selectCreatureAiAvoidanceParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_avoidance_param")
    Integer selectMaxCreatureAiAvoidanceParamId();

    // CreatureAiGoal queries
    @Query("SELECT ID, CreatureID, GoalType, Priority, Flags, TargetType, TargetParam1, TargetParam2, TargetParam3, TargetParam4, TargetParam5, TargetParam6, TargetParam7, TargetParam8, TargetParam9, TargetParam10, VerifiedBuild FROM creature_ai_goal WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiGoal> selectCreatureAiGoals(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_goal")
    Integer selectMaxCreatureAiGoalId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_goal_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiGoal> selectCreatureAiGoalLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiGoalParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_goal_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiGoalParam> selectCreatureAiGoalParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_goal_param")
    Integer selectMaxCreatureAiGoalParamId();

    // CreatureAiEvent queries
    @Query("SELECT ID, CreatureID, EventType, EventParam1, EventParam2, EventParam3, EventParam4, EventParam5, PhaseMask, Flags, VerifiedBuild FROM creature_ai_event WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiEvent> selectCreatureAiEvents(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_event")
    Integer selectMaxCreatureAiEventId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_event_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiEvent> selectCreatureAiEventLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiEventParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_event_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiEventParam> selectCreatureAiEventParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_event_param")
    Integer selectMaxCreatureAiEventParamId();

    // CreatureAiAction queries
    @Query("SELECT ID, CreatureID, ActionType, TargetType, TargetParam1, TargetParam2, TargetParam3, TargetParam4, TargetParam5, TargetParam6, TargetParam7, TargetParam8, TargetParam9, TargetParam10, Flags, VerifiedBuild FROM creature_ai_action WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiAction> selectCreatureAiActions(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_action")
    Integer selectMaxCreatureAiActionId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_action_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiAction> selectCreatureAiActionLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiActionParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_action_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiActionParam> selectCreatureAiActionParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_action_param")
    Integer selectMaxCreatureAiActionParamId();

    // CreatureAiCondition queries
    @Query("SELECT ID, CreatureID, ConditionType, ConditionValue1, ConditionValue2, ConditionValue3, ConditionValue4, ConditionValue5, ConditionValue6, Flags, VerifiedBuild FROM creature_ai_condition WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiCondition> selectCreatureAiConditions(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_condition")
    Integer selectMaxCreatureAiConditionId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_condition_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiCondition> selectCreatureAiConditionLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiConditionParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_condition_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiConditionParam> selectCreatureAiConditionParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_condition_param")
    Integer selectMaxCreatureAiConditionParamId();

    // CreatureAiFormation queries
    @Query("SELECT ID, CreatureID, FormationType, FormationRank, FormationGroup, Flags, VerifiedBuild FROM creature_ai_formation WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiFormation> selectCreatureAiFormations(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_formation")
    Integer selectMaxCreatureAiFormationId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_formation_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiFormation> selectCreatureAiFormationLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiFormationParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_formation_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiFormationParam> selectCreatureAiFormationParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_formation_param")
    Integer selectMaxCreatureAiFormationParamId();

    // CreatureAiGoalWaypoints queries
    @Query("SELECT ID, CreatureID, PointID, X, Y, Z, Orientation, WaitTime, ScriptId, VerifiedBuild FROM creature_ai_goal_waypoints WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiGoalWaypoint> selectCreatureAiGoalWaypoints(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_goal_waypoints")
    Integer selectMaxCreatureAiGoalWaypointId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_goal_waypoints_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiGoalWaypoint> selectCreatureAiGoalWaypointLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiGoalWaypointsParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_goal_waypoints_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiGoalWaypointParam> selectCreatureAiGoalWaypointsParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_goal_waypoints_param")
    Integer selectMaxCreatureAiGoalWaypointParamId();

    // CreatureAiPoi queries
    @Query("SELECT ID, CreatureID, PoiType, X, Y, Z, Radius, Flags, VerifiedBuild FROM creature_ai_poi WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiPoi> selectCreatureAiPois(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_poi")
    Integer selectMaxCreatureAiPoiId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_poi_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiPoi> selectCreatureAiPoiLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiPoiParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_poi_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiPoiParam> selectCreatureAiPoiParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_poi_param")
    Integer selectMaxCreatureAiPoiParamId();

    // CreatureAiLeash queries
    @Query("SELECT ID, CreatureID, LeashRange, ReturnRange, Flags, VerifiedBuild FROM creature_ai_leash WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiLeash> selectCreatureAiLeashes(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_leash")
    Integer selectMaxCreatureAiLeashId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_leash_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiLeash> selectCreatureAiLeashLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiLeashParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_leash_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiLeashParam> selectCreatureAiLeashParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_leash_param")
    Integer selectMaxCreatureAiLeashParamId();

    // CreatureAiSound queries
    @Query("SELECT ID, CreatureID, SoundID, SoundType, Probability, Emote, Flags, VerifiedBuild FROM creature_ai_sound WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiSound> selectCreatureAiSounds(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_sound")
    Integer selectMaxCreatureAiSoundId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_sound_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiSound> selectCreatureAiSoundLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiSoundParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_sound_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiSoundParam> selectCreatureAiSoundParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_sound_param")
    Integer selectMaxCreatureAiSoundParamId();

    // CreatureAiText queries
    @Query("SELECT ID, CreatureID, GroupID, IDX, Text, Type, Language, Probability, Emote, Duration, Sound, BroadcastTextId, VerifiedBuild FROM creature_ai_text WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiText> selectCreatureAiTexts(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_text")
    Integer selectMaxCreatureAiTextId();

    @Query("SELECT ID, Text_lang, Comment_lang FROM creature_ai_text_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiText> selectCreatureAiTextLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiEquip queries
    @Query("SELECT ID, CreatureID, EquipID, Slot, Flags, VerifiedBuild FROM creature_ai_equip WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiEquip> selectCreatureAiEquips(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_equip")
    Integer selectMaxCreatureAiEquipId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_equip_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiEquip> selectCreatureAiEquipLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiEquipParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_equip_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiEquipParam> selectCreatureAiEquipParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_equip_param")
    Integer selectMaxCreatureAiEquipParamId();

    // CreatureAiVehicle queries
    @Query("SELECT ID, CreatureID, VehicleID, Flags, VerifiedBuild FROM creature_ai_vehicle WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiVehicle> selectCreatureAiVehicles(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_vehicle")
    Integer selectMaxCreatureAiVehicleId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_vehicle_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiVehicle> selectCreatureAiVehicleLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiVehicleParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_vehicle_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiVehicleParam> selectCreatureAiVehicleParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_vehicle_param")
    Integer selectMaxCreatureAiVehicleParamId();

    // CreatureAiTarget queries
    @Query("SELECT ID, CreatureID, TargetType, TargetFlags, TargetCreatureType, TargetCreatureFamily, TargetCreatureRank, Distance, VerifiedBuild FROM creature_ai_target WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiTarget> selectCreatureAiTargets(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_target")
    Integer selectMaxCreatureAiTargetId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_target_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiTarget> selectCreatureAiTargetLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiTargetParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_target_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiTargetParam> selectCreatureAiTargetParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_target_param")
    Integer selectMaxCreatureAiTargetParamId();

    // CreatureAiMovement queries
    @Query("SELECT ID, CreatureID, MovementType, ChaseRange, ChaseAngle, HomeRange, Flags, VerifiedBuild FROM creature_ai_movement WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiMovement> selectCreatureAiMovements(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_movement")
    Integer selectMaxCreatureAiMovementId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_movement_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiMovement> selectCreatureAiMovementLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiMovementParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_movement_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiMovementParam> selectCreatureAiMovementParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_movement_param")
    Integer selectMaxCreatureAiMovementParamId();

    // CreatureAiSpawn queries
    @Query("SELECT ID, CreatureID, SpawnType, X, Y, Z, Orientation, SpawnTime, Flags, VerifiedBuild FROM creature_ai_spawn WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiSpawn> selectCreatureAiSpawns(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_spawn")
    Integer selectMaxCreatureAiSpawnId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_spawn_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiSpawn> selectCreatureAiSpawnLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiSpawnParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_spawn_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiSpawnParam> selectCreatureAiSpawnParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_spawn_param")
    Integer selectMaxCreatureAiSpawnParamId();

    // CreatureAiLoot queries
    @Query("SELECT ID, CreatureID, LootId, LootMode, Probability, MinCount, MaxCount, Flags, VerifiedBuild FROM creature_ai_loot WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiLoot> selectCreatureAiLoots(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_loot")
    Integer selectMaxCreatureAiLootId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_loot_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiLoot> selectCreatureAiLootLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);

    // CreatureAiLootParam queries
    @Query("SELECT ID, CreatureID, GroupID, Index, ParamType, ParamValue, VerifiedBuild FROM creature_ai_loot_param WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiLootParam> selectCreatureAiLootParams(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_loot_param")
    Integer selectMaxCreatureAiLootParamId();

    // CreatureAiAbility queries
    @Query("SELECT ID, CreatureID, AbilityID, CastFlags, Cooldown, Priority, Flags, VerifiedBuild FROM creature_ai_ability WHERE (`VerifiedBuild` > :verifiedBuild)")
    Stream<CreatureAiAbility> selectCreatureAiAbilities(@Param("verifiedBuild") int verifiedBuild);

    @Query("SELECT MAX(ID) + 1 FROM creature_ai_ability")
    Integer selectMaxCreatureAiAbilityId();

    @Query("SELECT ID, Comment_lang FROM creature_ai_ability_locale WHERE (`VerifiedBuild` > :verifiedBuild) AND locale = :locale")
    Stream<CreatureAiAbility> selectCreatureAiAbilityLocales(@Param("verifiedBuild") int verifiedBuild, @Param("locale") String locale);
}