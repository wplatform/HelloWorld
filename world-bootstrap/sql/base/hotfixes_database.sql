-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: hotfixes
-- ------------------------------------------------------
-- Server version	8.0.22-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `achievement`
--

DROP TABLE IF EXISTS `achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `achievement` (
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Reward` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `InstanceID` smallint NOT NULL DEFAULT '0',
  `Faction` tinyint NOT NULL DEFAULT '0',
  `Supercedes` smallint NOT NULL DEFAULT '0',
  `Category` smallint NOT NULL DEFAULT '0',
  `MinimumCriteria` tinyint NOT NULL DEFAULT '0',
  `Points` tinyint NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `UiOrder` smallint NOT NULL DEFAULT '0',
  `IconFileID` int NOT NULL DEFAULT '0',
  `RewardItemID` int NOT NULL DEFAULT '0',
  `CriteriaTree` int unsigned NOT NULL DEFAULT '0',
  `SharesCriteria` smallint NOT NULL DEFAULT '0',
  `CovenantID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `achievement_locale`
--

DROP TABLE IF EXISTS `achievement_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `achievement_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Title_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Reward_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement_locale`
--

LOCK TABLES `achievement_locale` WRITE;
/*!40000 ALTER TABLE `achievement_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `achievement_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anim_kit`
--

DROP TABLE IF EXISTS `anim_kit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anim_kit` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `OneShotDuration` int unsigned NOT NULL DEFAULT '0',
  `OneShotStopAnimKitID` smallint unsigned NOT NULL DEFAULT '0',
  `LowDefAnimKitID` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anim_kit`
--

LOCK TABLES `anim_kit` WRITE;
/*!40000 ALTER TABLE `anim_kit` DISABLE KEYS */;
/*!40000 ALTER TABLE `anim_kit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animation_data`
--

DROP TABLE IF EXISTS `animation_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animation_data` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `BehaviorID` smallint unsigned NOT NULL DEFAULT '0',
  `BehaviorTier` tinyint unsigned NOT NULL DEFAULT '0',
  `Fallback` int NOT NULL DEFAULT '0',
  `Flags1` int NOT NULL DEFAULT '0',
  `Flags2` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animation_data`
--

LOCK TABLES `animation_data` WRITE;
/*!40000 ALTER TABLE `animation_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `animation_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area_group_member`
--

DROP TABLE IF EXISTS `area_group_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area_group_member` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `AreaID` smallint unsigned NOT NULL DEFAULT '0',
  `AreaGroupID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_group_member`
--

LOCK TABLES `area_group_member` WRITE;
/*!40000 ALTER TABLE `area_group_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_group_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area_table`
--

DROP TABLE IF EXISTS `area_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area_table` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ZoneName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `AreaName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ContinentID` smallint unsigned NOT NULL DEFAULT '0',
  `ParentAreaID` smallint unsigned NOT NULL DEFAULT '0',
  `AreaBit` smallint NOT NULL DEFAULT '0',
  `SoundProviderPref` tinyint unsigned NOT NULL DEFAULT '0',
  `SoundProviderPrefUnderwater` tinyint unsigned NOT NULL DEFAULT '0',
  `AmbienceID` smallint unsigned NOT NULL DEFAULT '0',
  `UwAmbience` smallint unsigned NOT NULL DEFAULT '0',
  `ZoneMusic` smallint unsigned NOT NULL DEFAULT '0',
  `UwZoneMusic` smallint unsigned NOT NULL DEFAULT '0',
  `IntroSound` smallint unsigned NOT NULL DEFAULT '0',
  `UwIntroSound` int unsigned NOT NULL DEFAULT '0',
  `FactionGroupMask` tinyint unsigned NOT NULL DEFAULT '0',
  `AmbientMultiplier` float NOT NULL DEFAULT '0',
  `MountFlags` tinyint unsigned NOT NULL DEFAULT '0',
  `PvpCombatWorldStateID` smallint NOT NULL DEFAULT '0',
  `WildBattlePetLevelMin` tinyint unsigned NOT NULL DEFAULT '0',
  `WildBattlePetLevelMax` tinyint unsigned NOT NULL DEFAULT '0',
  `WindSettingsID` tinyint unsigned NOT NULL DEFAULT '0',
  `ContentTuningID` int NOT NULL DEFAULT '0',
  `Flags1` int NOT NULL DEFAULT '0',
  `Flags2` int NOT NULL DEFAULT '0',
  `LiquidTypeID1` smallint unsigned NOT NULL DEFAULT '0',
  `LiquidTypeID2` smallint unsigned NOT NULL DEFAULT '0',
  `LiquidTypeID3` smallint unsigned NOT NULL DEFAULT '0',
  `LiquidTypeID4` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_table`
--

LOCK TABLES `area_table` WRITE;
/*!40000 ALTER TABLE `area_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area_table_locale`
--

DROP TABLE IF EXISTS `area_table_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area_table_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `AreaName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_table_locale`
--

LOCK TABLES `area_table_locale` WRITE;
/*!40000 ALTER TABLE `area_table_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_table_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area_trigger`
--

DROP TABLE IF EXISTS `area_trigger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area_trigger` (
  `PosX` float NOT NULL DEFAULT '0',
  `PosY` float NOT NULL DEFAULT '0',
  `PosZ` float NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ContinentID` smallint NOT NULL DEFAULT '0',
  `PhaseUseFlags` tinyint NOT NULL DEFAULT '0',
  `PhaseID` smallint NOT NULL DEFAULT '0',
  `PhaseGroupID` smallint NOT NULL DEFAULT '0',
  `Radius` float NOT NULL DEFAULT '0',
  `BoxLength` float NOT NULL DEFAULT '0',
  `BoxWidth` float NOT NULL DEFAULT '0',
  `BoxHeight` float NOT NULL DEFAULT '0',
  `BoxYaw` float NOT NULL DEFAULT '0',
  `ShapeType` tinyint NOT NULL DEFAULT '0',
  `ShapeID` smallint NOT NULL DEFAULT '0',
  `AreaTriggerActionSetID` smallint NOT NULL DEFAULT '0',
  `Flags` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_trigger`
--

LOCK TABLES `area_trigger` WRITE;
/*!40000 ALTER TABLE `area_trigger` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_trigger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `armor_location`
--

DROP TABLE IF EXISTS `armor_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armor_location` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Clothmodifier` float NOT NULL DEFAULT '0',
  `Leathermodifier` float NOT NULL DEFAULT '0',
  `Chainmodifier` float NOT NULL DEFAULT '0',
  `Platemodifier` float NOT NULL DEFAULT '0',
  `Modifier` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armor_location`
--

LOCK TABLES `armor_location` WRITE;
/*!40000 ALTER TABLE `armor_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `armor_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact`
--

DROP TABLE IF EXISTS `artifact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `UiTextureKitID` smallint unsigned NOT NULL DEFAULT '0',
  `UiNameColor` int NOT NULL DEFAULT '0',
  `UiBarOverlayColor` int NOT NULL DEFAULT '0',
  `UiBarBackgroundColor` int NOT NULL DEFAULT '0',
  `ChrSpecializationID` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `ArtifactCategoryID` tinyint unsigned NOT NULL DEFAULT '0',
  `UiModelSceneID` int unsigned NOT NULL DEFAULT '0',
  `SpellVisualKitID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact`
--

LOCK TABLES `artifact` WRITE;
/*!40000 ALTER TABLE `artifact` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_appearance`
--

DROP TABLE IF EXISTS `artifact_appearance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_appearance` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ArtifactAppearanceSetID` smallint unsigned NOT NULL DEFAULT '0',
  `DisplayIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `UnlockPlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `ItemAppearanceModifierID` tinyint unsigned NOT NULL DEFAULT '0',
  `UiSwatchColor` int NOT NULL DEFAULT '0',
  `UiModelSaturation` float NOT NULL DEFAULT '0',
  `UiModelOpacity` float NOT NULL DEFAULT '0',
  `OverrideShapeshiftFormID` tinyint unsigned NOT NULL DEFAULT '0',
  `OverrideShapeshiftDisplayID` int unsigned NOT NULL DEFAULT '0',
  `UiItemAppearanceID` int unsigned NOT NULL DEFAULT '0',
  `UiAltItemAppearanceID` int unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `UiCameraID` smallint unsigned NOT NULL DEFAULT '0',
  `UsablePlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_appearance`
--

LOCK TABLES `artifact_appearance` WRITE;
/*!40000 ALTER TABLE `artifact_appearance` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_appearance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_appearance_locale`
--

DROP TABLE IF EXISTS `artifact_appearance_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_appearance_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_appearance_locale`
--

LOCK TABLES `artifact_appearance_locale` WRITE;
/*!40000 ALTER TABLE `artifact_appearance_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_appearance_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_appearance_set`
--

DROP TABLE IF EXISTS `artifact_appearance_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_appearance_set` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DisplayIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `UiCameraID` smallint unsigned NOT NULL DEFAULT '0',
  `AltHandUICameraID` smallint unsigned NOT NULL DEFAULT '0',
  `ForgeAttachmentOverride` tinyint NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `ArtifactID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_appearance_set`
--

LOCK TABLES `artifact_appearance_set` WRITE;
/*!40000 ALTER TABLE `artifact_appearance_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_appearance_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_appearance_set_locale`
--

DROP TABLE IF EXISTS `artifact_appearance_set_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_appearance_set_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_appearance_set_locale`
--

LOCK TABLES `artifact_appearance_set_locale` WRITE;
/*!40000 ALTER TABLE `artifact_appearance_set_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_appearance_set_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_category`
--

DROP TABLE IF EXISTS `artifact_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_category` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `XpMultCurrencyID` smallint NOT NULL DEFAULT '0',
  `XpMultCurveID` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_category`
--

LOCK TABLES `artifact_category` WRITE;
/*!40000 ALTER TABLE `artifact_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_locale`
--

DROP TABLE IF EXISTS `artifact_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_locale`
--

LOCK TABLES `artifact_locale` WRITE;
/*!40000 ALTER TABLE `artifact_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_power`
--

DROP TABLE IF EXISTS `artifact_power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_power` (
  `DisplayPosX` float NOT NULL DEFAULT '0',
  `DisplayPosY` float NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ArtifactID` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxPurchasableRank` tinyint unsigned NOT NULL DEFAULT '0',
  `Label` int NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `Tier` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_power`
--

LOCK TABLES `artifact_power` WRITE;
/*!40000 ALTER TABLE `artifact_power` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_power_link`
--

DROP TABLE IF EXISTS `artifact_power_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_power_link` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PowerA` smallint unsigned NOT NULL DEFAULT '0',
  `PowerB` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_power_link`
--

LOCK TABLES `artifact_power_link` WRITE;
/*!40000 ALTER TABLE `artifact_power_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_power_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_power_picker`
--

DROP TABLE IF EXISTS `artifact_power_picker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_power_picker` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_power_picker`
--

LOCK TABLES `artifact_power_picker` WRITE;
/*!40000 ALTER TABLE `artifact_power_picker` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_power_picker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_power_rank`
--

DROP TABLE IF EXISTS `artifact_power_rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_power_rank` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `RankIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `ItemBonusListID` smallint unsigned NOT NULL DEFAULT '0',
  `AuraPointsOverride` float NOT NULL DEFAULT '0',
  `ArtifactPowerID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_power_rank`
--

LOCK TABLES `artifact_power_rank` WRITE;
/*!40000 ALTER TABLE `artifact_power_rank` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_power_rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_quest_xp`
--

DROP TABLE IF EXISTS `artifact_quest_xp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_quest_xp` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Difficulty1` int unsigned NOT NULL DEFAULT '0',
  `Difficulty2` int unsigned NOT NULL DEFAULT '0',
  `Difficulty3` int unsigned NOT NULL DEFAULT '0',
  `Difficulty4` int unsigned NOT NULL DEFAULT '0',
  `Difficulty5` int unsigned NOT NULL DEFAULT '0',
  `Difficulty6` int unsigned NOT NULL DEFAULT '0',
  `Difficulty7` int unsigned NOT NULL DEFAULT '0',
  `Difficulty8` int unsigned NOT NULL DEFAULT '0',
  `Difficulty9` int unsigned NOT NULL DEFAULT '0',
  `Difficulty10` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_quest_xp`
--

LOCK TABLES `artifact_quest_xp` WRITE;
/*!40000 ALTER TABLE `artifact_quest_xp` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_quest_xp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_tier`
--

DROP TABLE IF EXISTS `artifact_tier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_tier` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ArtifactTier` int unsigned NOT NULL DEFAULT '0',
  `MaxNumTraits` int unsigned NOT NULL DEFAULT '0',
  `MaxArtifactKnowledge` int unsigned NOT NULL DEFAULT '0',
  `KnowledgePlayerCondition` int unsigned NOT NULL DEFAULT '0',
  `MinimumEmpowerKnowledge` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_tier`
--

LOCK TABLES `artifact_tier` WRITE;
/*!40000 ALTER TABLE `artifact_tier` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_tier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artifact_unlock`
--

DROP TABLE IF EXISTS `artifact_unlock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artifact_unlock` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PowerID` int unsigned NOT NULL DEFAULT '0',
  `PowerRank` tinyint unsigned NOT NULL DEFAULT '0',
  `ItemBonusListID` smallint unsigned NOT NULL DEFAULT '0',
  `PlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `ArtifactID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artifact_unlock`
--

LOCK TABLES `artifact_unlock` WRITE;
/*!40000 ALTER TABLE `artifact_unlock` DISABLE KEYS */;
/*!40000 ALTER TABLE `artifact_unlock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auction_house`
--

DROP TABLE IF EXISTS `auction_house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auction_house` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `FactionID` smallint unsigned NOT NULL DEFAULT '0',
  `DepositRate` tinyint unsigned NOT NULL DEFAULT '0',
  `ConsignmentRate` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auction_house`
--

LOCK TABLES `auction_house` WRITE;
/*!40000 ALTER TABLE `auction_house` DISABLE KEYS */;
/*!40000 ALTER TABLE `auction_house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auction_house_locale`
--

DROP TABLE IF EXISTS `auction_house_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auction_house_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auction_house_locale`
--

LOCK TABLES `auction_house_locale` WRITE;
/*!40000 ALTER TABLE `auction_house_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `auction_house_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_empowered_item`
--

DROP TABLE IF EXISTS `azerite_empowered_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_empowered_item` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemID` int NOT NULL DEFAULT '0',
  `AzeriteTierUnlockSetID` int unsigned NOT NULL DEFAULT '0',
  `AzeritePowerSetID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_empowered_item`
--

LOCK TABLES `azerite_empowered_item` WRITE;
/*!40000 ALTER TABLE `azerite_empowered_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_empowered_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_essence`
--

DROP TABLE IF EXISTS `azerite_essence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_essence` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpecSetID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_essence`
--

LOCK TABLES `azerite_essence` WRITE;
/*!40000 ALTER TABLE `azerite_essence` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_essence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_essence_locale`
--

DROP TABLE IF EXISTS `azerite_essence_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_essence_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_essence_locale`
--

LOCK TABLES `azerite_essence_locale` WRITE;
/*!40000 ALTER TABLE `azerite_essence_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_essence_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_essence_power`
--

DROP TABLE IF EXISTS `azerite_essence_power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_essence_power` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SourceAlliance` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `SourceHorde` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `AzeriteEssenceID` int NOT NULL DEFAULT '0',
  `Tier` tinyint unsigned NOT NULL DEFAULT '0',
  `MajorPowerDescription` int NOT NULL DEFAULT '0',
  `MinorPowerDescription` int NOT NULL DEFAULT '0',
  `MajorPowerActual` int NOT NULL DEFAULT '0',
  `MinorPowerActual` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_essence_power`
--

LOCK TABLES `azerite_essence_power` WRITE;
/*!40000 ALTER TABLE `azerite_essence_power` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_essence_power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_essence_power_locale`
--

DROP TABLE IF EXISTS `azerite_essence_power_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_essence_power_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SourceAlliance_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `SourceHorde_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_essence_power_locale`
--

LOCK TABLES `azerite_essence_power_locale` WRITE;
/*!40000 ALTER TABLE `azerite_essence_power_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_essence_power_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_item`
--

DROP TABLE IF EXISTS `azerite_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_item` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_item`
--

LOCK TABLES `azerite_item` WRITE;
/*!40000 ALTER TABLE `azerite_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_item_milestone_power`
--

DROP TABLE IF EXISTS `azerite_item_milestone_power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_item_milestone_power` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `RequiredLevel` int NOT NULL DEFAULT '0',
  `AzeritePowerID` int NOT NULL DEFAULT '0',
  `Type` int NOT NULL DEFAULT '0',
  `AutoUnlock` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_item_milestone_power`
--

LOCK TABLES `azerite_item_milestone_power` WRITE;
/*!40000 ALTER TABLE `azerite_item_milestone_power` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_item_milestone_power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_knowledge_multiplier`
--

DROP TABLE IF EXISTS `azerite_knowledge_multiplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_knowledge_multiplier` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Multiplier` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_knowledge_multiplier`
--

LOCK TABLES `azerite_knowledge_multiplier` WRITE;
/*!40000 ALTER TABLE `azerite_knowledge_multiplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_knowledge_multiplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_level_info`
--

DROP TABLE IF EXISTS `azerite_level_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_level_info` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `BaseExperienceToNextLevel` bigint unsigned NOT NULL DEFAULT '0',
  `MinimumExperienceToNextLevel` bigint unsigned NOT NULL DEFAULT '0',
  `ItemLevel` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_level_info`
--

LOCK TABLES `azerite_level_info` WRITE;
/*!40000 ALTER TABLE `azerite_level_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_level_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_power`
--

DROP TABLE IF EXISTS `azerite_power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_power` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `ItemBonusListID` int NOT NULL DEFAULT '0',
  `SpecSetID` int NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_power`
--

LOCK TABLES `azerite_power` WRITE;
/*!40000 ALTER TABLE `azerite_power` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_power_set_member`
--

DROP TABLE IF EXISTS `azerite_power_set_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_power_set_member` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `AzeritePowerSetID` int NOT NULL DEFAULT '0',
  `AzeritePowerID` int NOT NULL DEFAULT '0',
  `Class` int NOT NULL DEFAULT '0',
  `Tier` int NOT NULL DEFAULT '0',
  `OrderIndex` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_power_set_member`
--

LOCK TABLES `azerite_power_set_member` WRITE;
/*!40000 ALTER TABLE `azerite_power_set_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_power_set_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_tier_unlock`
--

DROP TABLE IF EXISTS `azerite_tier_unlock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_tier_unlock` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemCreationContext` tinyint unsigned NOT NULL DEFAULT '0',
  `Tier` tinyint unsigned NOT NULL DEFAULT '0',
  `AzeriteLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `AzeriteTierUnlockSetID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_tier_unlock`
--

LOCK TABLES `azerite_tier_unlock` WRITE;
/*!40000 ALTER TABLE `azerite_tier_unlock` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_tier_unlock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_tier_unlock_set`
--

DROP TABLE IF EXISTS `azerite_tier_unlock_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_tier_unlock_set` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_tier_unlock_set`
--

LOCK TABLES `azerite_tier_unlock_set` WRITE;
/*!40000 ALTER TABLE `azerite_tier_unlock_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_tier_unlock_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azerite_unlock_mapping`
--

DROP TABLE IF EXISTS `azerite_unlock_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azerite_unlock_mapping` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemLevel` int NOT NULL DEFAULT '0',
  `ItemBonusListHead` int NOT NULL DEFAULT '0',
  `ItemBonusListShoulders` int NOT NULL DEFAULT '0',
  `ItemBonusListChest` int NOT NULL DEFAULT '0',
  `AzeriteUnlockMappingSetID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azerite_unlock_mapping`
--

LOCK TABLES `azerite_unlock_mapping` WRITE;
/*!40000 ALTER TABLE `azerite_unlock_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `azerite_unlock_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_bag_slot_prices`
--

DROP TABLE IF EXISTS `bank_bag_slot_prices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_bag_slot_prices` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Cost` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_bag_slot_prices`
--

LOCK TABLES `bank_bag_slot_prices` WRITE;
/*!40000 ALTER TABLE `bank_bag_slot_prices` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank_bag_slot_prices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banned_addons`
--

DROP TABLE IF EXISTS `banned_addons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banned_addons` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Version` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banned_addons`
--

LOCK TABLES `banned_addons` WRITE;
/*!40000 ALTER TABLE `banned_addons` DISABLE KEYS */;
/*!40000 ALTER TABLE `banned_addons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barber_shop_style`
--

DROP TABLE IF EXISTS `barber_shop_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barber_shop_style` (
  `DisplayName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Type` tinyint unsigned NOT NULL DEFAULT '0',
  `CostModifier` float NOT NULL DEFAULT '0',
  `Race` tinyint unsigned NOT NULL DEFAULT '0',
  `Sex` tinyint unsigned NOT NULL DEFAULT '0',
  `Data` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barber_shop_style`
--

LOCK TABLES `barber_shop_style` WRITE;
/*!40000 ALTER TABLE `barber_shop_style` DISABLE KEYS */;
/*!40000 ALTER TABLE `barber_shop_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barber_shop_style_locale`
--

DROP TABLE IF EXISTS `barber_shop_style_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barber_shop_style_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `DisplayName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barber_shop_style_locale`
--

LOCK TABLES `barber_shop_style_locale` WRITE;
/*!40000 ALTER TABLE `barber_shop_style_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `barber_shop_style_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `battle_pet_breed_quality`
--

DROP TABLE IF EXISTS `battle_pet_breed_quality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `battle_pet_breed_quality` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `StateMultiplier` float NOT NULL DEFAULT '0',
  `QualityEnum` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `battle_pet_breed_quality`
--

LOCK TABLES `battle_pet_breed_quality` WRITE;
/*!40000 ALTER TABLE `battle_pet_breed_quality` DISABLE KEYS */;
/*!40000 ALTER TABLE `battle_pet_breed_quality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `battle_pet_breed_state`
--

DROP TABLE IF EXISTS `battle_pet_breed_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `battle_pet_breed_state` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `BattlePetStateID` int NOT NULL DEFAULT '0',
  `Value` smallint unsigned NOT NULL DEFAULT '0',
  `BattlePetBreedID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `battle_pet_breed_state`
--

LOCK TABLES `battle_pet_breed_state` WRITE;
/*!40000 ALTER TABLE `battle_pet_breed_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `battle_pet_breed_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `battle_pet_species`
--

DROP TABLE IF EXISTS `battle_pet_species`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `battle_pet_species` (
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `SourceText` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `CreatureID` int NOT NULL DEFAULT '0',
  `SummonSpellID` int NOT NULL DEFAULT '0',
  `IconFileDataID` int NOT NULL DEFAULT '0',
  `PetTypeEnum` tinyint unsigned NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `SourceTypeEnum` tinyint NOT NULL DEFAULT '0',
  `CardUIModelSceneID` int NOT NULL DEFAULT '0',
  `LoadoutUIModelSceneID` int NOT NULL DEFAULT '0',
  `CovenantID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `battle_pet_species`
--

LOCK TABLES `battle_pet_species` WRITE;
/*!40000 ALTER TABLE `battle_pet_species` DISABLE KEYS */;
/*!40000 ALTER TABLE `battle_pet_species` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `battle_pet_species_locale`
--

DROP TABLE IF EXISTS `battle_pet_species_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `battle_pet_species_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `SourceText_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `battle_pet_species_locale`
--

LOCK TABLES `battle_pet_species_locale` WRITE;
/*!40000 ALTER TABLE `battle_pet_species_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `battle_pet_species_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `battle_pet_species_state`
--

DROP TABLE IF EXISTS `battle_pet_species_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `battle_pet_species_state` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `BattlePetStateID` smallint unsigned NOT NULL DEFAULT '0',
  `Value` int NOT NULL DEFAULT '0',
  `BattlePetSpeciesID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `battle_pet_species_state`
--

LOCK TABLES `battle_pet_species_state` WRITE;
/*!40000 ALTER TABLE `battle_pet_species_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `battle_pet_species_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `battlemaster_list`
--

DROP TABLE IF EXISTS `battlemaster_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `battlemaster_list` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `GameType` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ShortDescription` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `LongDescription` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `InstanceType` tinyint NOT NULL DEFAULT '0',
  `MinLevel` tinyint NOT NULL DEFAULT '0',
  `MaxLevel` tinyint NOT NULL DEFAULT '0',
  `RatedPlayers` tinyint NOT NULL DEFAULT '0',
  `MinPlayers` tinyint NOT NULL DEFAULT '0',
  `MaxPlayers` tinyint NOT NULL DEFAULT '0',
  `GroupsAllowed` tinyint NOT NULL DEFAULT '0',
  `MaxGroupSize` tinyint NOT NULL DEFAULT '0',
  `HolidayWorldState` smallint NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `IconFileDataID` int NOT NULL DEFAULT '0',
  `RequiredPlayerConditionID` int NOT NULL DEFAULT '0',
  `MapID1` smallint NOT NULL DEFAULT '0',
  `MapID2` smallint NOT NULL DEFAULT '0',
  `MapID3` smallint NOT NULL DEFAULT '0',
  `MapID4` smallint NOT NULL DEFAULT '0',
  `MapID5` smallint NOT NULL DEFAULT '0',
  `MapID6` smallint NOT NULL DEFAULT '0',
  `MapID7` smallint NOT NULL DEFAULT '0',
  `MapID8` smallint NOT NULL DEFAULT '0',
  `MapID9` smallint NOT NULL DEFAULT '0',
  `MapID10` smallint NOT NULL DEFAULT '0',
  `MapID11` smallint NOT NULL DEFAULT '0',
  `MapID12` smallint NOT NULL DEFAULT '0',
  `MapID13` smallint NOT NULL DEFAULT '0',
  `MapID14` smallint NOT NULL DEFAULT '0',
  `MapID15` smallint NOT NULL DEFAULT '0',
  `MapID16` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `battlemaster_list`
--

LOCK TABLES `battlemaster_list` WRITE;
/*!40000 ALTER TABLE `battlemaster_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `battlemaster_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `battlemaster_list_locale`
--

DROP TABLE IF EXISTS `battlemaster_list_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `battlemaster_list_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `GameType_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ShortDescription_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `LongDescription_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `battlemaster_list_locale`
--

LOCK TABLES `battlemaster_list_locale` WRITE;
/*!40000 ALTER TABLE `battlemaster_list_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `battlemaster_list_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `broadcast_text`
--

DROP TABLE IF EXISTS `broadcast_text`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `broadcast_text` (
  `Text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Text1` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `LanguageID` int NOT NULL DEFAULT '0',
  `ConditionID` int NOT NULL DEFAULT '0',
  `EmotesID` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `ChatBubbleDurationMs` int unsigned NOT NULL DEFAULT '0',
  `SoundEntriesID1` int unsigned NOT NULL DEFAULT '0',
  `SoundEntriesID2` int unsigned NOT NULL DEFAULT '0',
  `EmoteID1` smallint unsigned NOT NULL DEFAULT '0',
  `EmoteID2` smallint unsigned NOT NULL DEFAULT '0',
  `EmoteID3` smallint unsigned NOT NULL DEFAULT '0',
  `EmoteDelay1` smallint unsigned NOT NULL DEFAULT '0',
  `EmoteDelay2` smallint unsigned NOT NULL DEFAULT '0',
  `EmoteDelay3` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `broadcast_text`
--

LOCK TABLES `broadcast_text` WRITE;
/*!40000 ALTER TABLE `broadcast_text` DISABLE KEYS */;
INSERT INTO `broadcast_text` VALUES ('It is good you sided with our covenant, $n. I think you will look marvelous in velvet.','It is good you sided with our covenant, $n. I think you will look marvelous in velvet.',207352,0,0,1,0,0,0,0,0,0,0,0,0,0,36949),('The Night Fae do not vie for power? Whatever do they do in those unkempt groves?','The Night Fae do not vie for power? Whatever do they do in those unkempt groves?',207353,0,0,1,0,0,0,0,0,0,0,0,0,0,36949),('Our forests may be less majestic than Ardenweald\'s, but we, too, fight to preserve our realm.','Our forests may be less majestic than Ardenweald\'s, but we, too, fight to preserve our realm.',207354,0,0,1,0,0,0,0,0,0,0,0,0,0,36949),('Do pass along our best to the Winter Queen, Maw Walker.','Do pass along our best to the Winter Queen, Maw Walker.',207355,0,0,1,0,0,0,0,0,0,0,0,0,0,36949),('When you tire of frolicking with the fae, do come round again for a bit of sport.','When you tire of frolicking with the fae, do come round again for a bit of sport.',207356,0,0,1,0,0,0,0,0,0,0,0,0,0,36949),('Fortunate we are to have you in our midst, $n. May the grace of the Archon guide your path.','Fortunate we are to have you in our midst, $n. May the grace of the Archon guide your path.',207357,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('Ah, Maw Walker! On business for the Archon, no doubt.  Go in service.','Ah, Maw Walker! On business for the Archon, no doubt.  Go in service.',207358,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('I am pleased to see our paths converge, $n. Your dedication is most appreciated.','I am pleased to see our paths converge, $n. Your dedication is most appreciated.',207359,0,0,1,0,0,0,0,1,1,0,0,1000,0,36949),('Your service honors our covenant, Maw Walker.','Your service honors our covenant, Maw Walker.',207360,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('I\'d thought you more suited to service than conflict, Maw Walker. Perhaps I was mistaken.','I\'d thought you more suited to service than conflict, Maw Walker. Perhaps I was mistaken.',207361,0,0,1,0,0,0,0,1,1,0,0,2000,0,36949),('May you bring discipline to the realm of strife, $n.','May you bring discipline to the realm of strife, $n.',207362,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('The Archon\'s favor remains upon you, no matter your covenant.','The Archon\'s favor remains upon you, no matter your covenant.',207363,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('Go in service... whatever that service may be.','Go in service... whatever that service may be.',207364,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('You chose to serve the venthyr? Guiding souls to redemption is a worthy task indeed.','You chose to serve the venthyr? Guiding souls to redemption is a worthy task indeed.',207365,0,0,1,0,0,0,0,1,1,0,0,2000,0,36949),('The venthyr understand that the past is a burden. Our covenants have much in common, $n.','The venthyr understand that the past is a burden. Our covenants have much in common, $n.',207366,0,0,1,0,0,0,0,1,1,0,0,2000,0,36949),('Maw Walker. May your guidance help wayward souls be unburdened.','Maw Walker. May your guidance help wayward souls be unburdened.',207367,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('May you find fulfillment in your... harvest, and meaning in your chosen service, $n.','May you find fulfillment in your... harvest, and meaning in your chosen service, $n.',207368,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('Our regards to the Winter Queen. A true ally of the Archon.','Our regards to the Winter Queen. A true ally of the Archon.',207369,0,0,1,0,0,0,0,1,1,0,0,2000,0,36949),('Though you did not join our covenant, you serve a great cycle, Maw Walker. A noble duty indeed.','Though you did not join our covenant, you serve a great cycle, Maw Walker. A noble duty indeed.',207370,0,0,1,0,0,0,0,1,1,0,0,1000,0,36949),('It would seem the wilds have beckoned you to their service, $n. A noble calling.','It would seem the wilds have beckoned you to their service, $n. A noble calling.',207371,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('The Night Fae are fortunate to have one so dauntless in their service, Maw Walker.','The Night Fae are fortunate to have one so dauntless in their service, Maw Walker.',207372,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('A shame you sided with formality over force, Maw Walker.','A shame you sided with formality over force, Maw Walker.',207376,0,0,1,0,0,0,0,1,0,0,0,0,0,36949),('','Any requests?',207388,0,0,0,0,0,0,0,0,0,0,0,0,0,36949),('Is that you down there, Theotar?','',207434,0,0,0,0,0,0,0,0,0,0,0,0,0,36949),('','I do, and I shall tell you after you see to it that your friend there is in Oribos.\n\nCome back to me once he is safe.',207442,0,0,0,0,0,0,0,0,0,0,0,0,0,36949);
/*!40000 ALTER TABLE `broadcast_text` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `broadcast_text_locale`
--

DROP TABLE IF EXISTS `broadcast_text_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `broadcast_text_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Text_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Text1_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `broadcast_text_locale`
--

LOCK TABLES `broadcast_text_locale` WRITE;
/*!40000 ALTER TABLE `broadcast_text_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `broadcast_text_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cfg_regions`
--

DROP TABLE IF EXISTS `cfg_regions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cfg_regions` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Tag` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `RegionID` smallint unsigned NOT NULL DEFAULT '0',
  `Raidorigin` int unsigned NOT NULL DEFAULT '0',
  `RegionGroupMask` tinyint unsigned NOT NULL DEFAULT '0',
  `ChallengeOrigin` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cfg_regions`
--

LOCK TABLES `cfg_regions` WRITE;
/*!40000 ALTER TABLE `cfg_regions` DISABLE KEYS */;
/*!40000 ALTER TABLE `cfg_regions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `char_titles`
--

DROP TABLE IF EXISTS `char_titles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `char_titles` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Name1` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `MaskID` smallint NOT NULL DEFAULT '0',
  `Flags` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `char_titles`
--

LOCK TABLES `char_titles` WRITE;
/*!40000 ALTER TABLE `char_titles` DISABLE KEYS */;
/*!40000 ALTER TABLE `char_titles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `char_titles_locale`
--

DROP TABLE IF EXISTS `char_titles_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `char_titles_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Name1_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `char_titles_locale`
--

LOCK TABLES `char_titles_locale` WRITE;
/*!40000 ALTER TABLE `char_titles_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `char_titles_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `character_loadout`
--

DROP TABLE IF EXISTS `character_loadout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_loadout` (
  `RaceMask` bigint NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ChrClassID` tinyint NOT NULL DEFAULT '0',
  `Purpose` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character_loadout`
--

LOCK TABLES `character_loadout` WRITE;
/*!40000 ALTER TABLE `character_loadout` DISABLE KEYS */;
/*!40000 ALTER TABLE `character_loadout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `character_loadout_item`
--

DROP TABLE IF EXISTS `character_loadout_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_loadout_item` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `CharacterLoadoutID` smallint unsigned NOT NULL DEFAULT '0',
  `ItemID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character_loadout_item`
--

LOCK TABLES `character_loadout_item` WRITE;
/*!40000 ALTER TABLE `character_loadout_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `character_loadout_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_channels`
--

DROP TABLE IF EXISTS `chat_channels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_channels` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Shortcut` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `FactionGroup` tinyint NOT NULL DEFAULT '0',
  `Ruleset` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_channels`
--

LOCK TABLES `chat_channels` WRITE;
/*!40000 ALTER TABLE `chat_channels` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat_channels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_channels_locale`
--

DROP TABLE IF EXISTS `chat_channels_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_channels_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Shortcut_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_channels_locale`
--

LOCK TABLES `chat_channels_locale` WRITE;
/*!40000 ALTER TABLE `chat_channels_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat_channels_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_classes`
--

DROP TABLE IF EXISTS `chr_classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_classes` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Filename` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameMale` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameFemale` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `PetNameToken` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text COLLATE utf8mb4_unicode_ci,
  `RoleInfoString` text COLLATE utf8mb4_unicode_ci,
  `DisabledString` text COLLATE utf8mb4_unicode_ci,
  `HyphenatedNameMale` text COLLATE utf8mb4_unicode_ci,
  `HyphenatedNameFemale` text COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `CreateScreenFileDataID` int unsigned NOT NULL DEFAULT '0',
  `SelectScreenFileDataID` int unsigned NOT NULL DEFAULT '0',
  `IconFileDataID` int unsigned NOT NULL DEFAULT '0',
  `LowResScreenFileDataID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int unsigned NOT NULL DEFAULT '0',
  `SpellTextureBlobFileDataID` int unsigned NOT NULL DEFAULT '0',
  `RolesMask` int unsigned NOT NULL DEFAULT '0',
  `ArmorTypeMask` int unsigned NOT NULL DEFAULT '0',
  `CharStartKitUnknown901` int NOT NULL DEFAULT '0',
  `MaleCharacterCreationVisualFallback` int NOT NULL DEFAULT '0',
  `MaleCharacterCreationIdleVisualFallback` int NOT NULL DEFAULT '0',
  `FemaleCharacterCreationVisualFallback` int NOT NULL DEFAULT '0',
  `FemaleCharacterCreationIdleVisualFallback` int NOT NULL DEFAULT '0',
  `CharacterCreationIdleGroundVisualFallback` int NOT NULL DEFAULT '0',
  `CharacterCreationGroundVisualFallback` int NOT NULL DEFAULT '0',
  `AlteredFormCharacterCreationIdleVisualFallback` int NOT NULL DEFAULT '0',
  `CharacterCreationAnimLoopWaitTimeMsFallback` int NOT NULL DEFAULT '0',
  `CinematicSequenceID` smallint unsigned NOT NULL DEFAULT '0',
  `DefaultSpec` smallint unsigned NOT NULL DEFAULT '0',
  `PrimaryStatPriority` tinyint unsigned NOT NULL DEFAULT '0',
  `DisplayPower` tinyint unsigned NOT NULL DEFAULT '0',
  `RangedAttackPowerPerAgility` tinyint unsigned NOT NULL DEFAULT '0',
  `AttackPowerPerAgility` tinyint unsigned NOT NULL DEFAULT '0',
  `AttackPowerPerStrength` tinyint unsigned NOT NULL DEFAULT '0',
  `SpellClassSet` tinyint unsigned NOT NULL DEFAULT '0',
  `ChatColorR` tinyint unsigned NOT NULL DEFAULT '0',
  `ChatColorG` tinyint unsigned NOT NULL DEFAULT '0',
  `ChatColorB` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_classes`
--

LOCK TABLES `chr_classes` WRITE;
/*!40000 ALTER TABLE `chr_classes` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_classes_locale`
--

DROP TABLE IF EXISTS `chr_classes_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_classes_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameMale_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameFemale_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text COLLATE utf8mb4_unicode_ci,
  `RoleInfoString_lang` text COLLATE utf8mb4_unicode_ci,
  `DisabledString_lang` text COLLATE utf8mb4_unicode_ci,
  `HyphenatedNameMale_lang` text COLLATE utf8mb4_unicode_ci,
  `HyphenatedNameFemale_lang` text COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_classes_locale`
--

LOCK TABLES `chr_classes_locale` WRITE;
/*!40000 ALTER TABLE `chr_classes_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_classes_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_classes_x_power_types`
--

DROP TABLE IF EXISTS `chr_classes_x_power_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_classes_x_power_types` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PowerType` tinyint NOT NULL DEFAULT '0',
  `ClassID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_classes_x_power_types`
--

LOCK TABLES `chr_classes_x_power_types` WRITE;
/*!40000 ALTER TABLE `chr_classes_x_power_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_classes_x_power_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_customization_choice`
--

DROP TABLE IF EXISTS `chr_customization_choice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_customization_choice` (
  `Name` text COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ChrCustomizationOptionID` int NOT NULL DEFAULT '0',
  `ChrCustomizationReqID` int NOT NULL DEFAULT '0',
  `SortOrder` smallint unsigned NOT NULL DEFAULT '0',
  `SwatchColor1` int NOT NULL DEFAULT '0',
  `SwatchColor2` int NOT NULL DEFAULT '0',
  `UiOrderIndex` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_customization_choice`
--

LOCK TABLES `chr_customization_choice` WRITE;
/*!40000 ALTER TABLE `chr_customization_choice` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_customization_choice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_customization_choice_locale`
--

DROP TABLE IF EXISTS `chr_customization_choice_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_customization_choice_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_customization_choice_locale`
--

LOCK TABLES `chr_customization_choice_locale` WRITE;
/*!40000 ALTER TABLE `chr_customization_choice_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_customization_choice_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_customization_display_info`
--

DROP TABLE IF EXISTS `chr_customization_display_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_customization_display_info` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ShapeshiftFormID` int NOT NULL DEFAULT '0',
  `DisplayID` int NOT NULL DEFAULT '0',
  `BarberShopMinCameraDistance` float NOT NULL DEFAULT '0',
  `BarberShopHeightOffset` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_customization_display_info`
--

LOCK TABLES `chr_customization_display_info` WRITE;
/*!40000 ALTER TABLE `chr_customization_display_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_customization_display_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_customization_element`
--

DROP TABLE IF EXISTS `chr_customization_element`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_customization_element` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ChrCustomizationChoiceID` int NOT NULL DEFAULT '0',
  `RelatedChrCustomizationChoiceID` int NOT NULL DEFAULT '0',
  `ChrCustomizationGeosetID` int NOT NULL DEFAULT '0',
  `ChrCustomizationSkinnedModelID` int NOT NULL DEFAULT '0',
  `ChrCustomizationMaterialID` int NOT NULL DEFAULT '0',
  `ChrCustomizationBoneSetID` int NOT NULL DEFAULT '0',
  `ChrCustomizationCondModelID` int NOT NULL DEFAULT '0',
  `ChrCustomizationDisplayInfoID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_customization_element`
--

LOCK TABLES `chr_customization_element` WRITE;
/*!40000 ALTER TABLE `chr_customization_element` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_customization_element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_customization_option`
--

DROP TABLE IF EXISTS `chr_customization_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_customization_option` (
  `Name` text COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SecondaryID` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `ChrModelID` int NOT NULL DEFAULT '0',
  `SortIndex` int NOT NULL DEFAULT '0',
  `ChrCustomizationCategoryID` int NOT NULL DEFAULT '0',
  `OptionType` int NOT NULL DEFAULT '0',
  `BarberShopCostModifier` float NOT NULL DEFAULT '0',
  `ChrCustomizationID` int NOT NULL DEFAULT '0',
  `ChrCustomizationReqID` int NOT NULL DEFAULT '0',
  `UiOrderIndex` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_customization_option`
--

LOCK TABLES `chr_customization_option` WRITE;
/*!40000 ALTER TABLE `chr_customization_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_customization_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_customization_option_locale`
--

DROP TABLE IF EXISTS `chr_customization_option_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_customization_option_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_customization_option_locale`
--

LOCK TABLES `chr_customization_option_locale` WRITE;
/*!40000 ALTER TABLE `chr_customization_option_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_customization_option_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_customization_req`
--

DROP TABLE IF EXISTS `chr_customization_req`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_customization_req` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `ClassMask` int NOT NULL DEFAULT '0',
  `AchievementID` int NOT NULL DEFAULT '0',
  `OverrideArchive` int NOT NULL DEFAULT '0',
  `ItemModifiedAppearanceID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_customization_req`
--

LOCK TABLES `chr_customization_req` WRITE;
/*!40000 ALTER TABLE `chr_customization_req` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_customization_req` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_customization_req_choice`
--

DROP TABLE IF EXISTS `chr_customization_req_choice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_customization_req_choice` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ChrCustomizationChoiceID` int NOT NULL DEFAULT '0',
  `ChrCustomizationReqID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_customization_req_choice`
--

LOCK TABLES `chr_customization_req_choice` WRITE;
/*!40000 ALTER TABLE `chr_customization_req_choice` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_customization_req_choice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_model`
--

DROP TABLE IF EXISTS `chr_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_model` (
  `FaceCustomizationOffset1` float NOT NULL DEFAULT '0',
  `FaceCustomizationOffset2` float NOT NULL DEFAULT '0',
  `FaceCustomizationOffset3` float NOT NULL DEFAULT '0',
  `CustomizeOffset1` float NOT NULL DEFAULT '0',
  `CustomizeOffset2` float NOT NULL DEFAULT '0',
  `CustomizeOffset3` float NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Sex` int NOT NULL DEFAULT '0',
  `DisplayID` int NOT NULL DEFAULT '0',
  `CharComponentTextureLayoutID` int NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `SkeletonFileDataID` int NOT NULL DEFAULT '0',
  `ModelFallbackChrModelID` int NOT NULL DEFAULT '0',
  `TextureFallbackChrModelID` int NOT NULL DEFAULT '0',
  `HelmVisFallbackChrModelID` int NOT NULL DEFAULT '0',
  `CustomizeScale` float NOT NULL DEFAULT '0',
  `CustomizeFacing` float NOT NULL DEFAULT '0',
  `CameraDistanceOffset` float NOT NULL DEFAULT '0',
  `BarberShopCameraOffsetScale` float NOT NULL DEFAULT '0',
  `BarberShopCameraRotationOffset` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_model`
--

LOCK TABLES `chr_model` WRITE;
/*!40000 ALTER TABLE `chr_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_race_x_chr_model`
--

DROP TABLE IF EXISTS `chr_race_x_chr_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_race_x_chr_model` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ChrRacesID` int NOT NULL DEFAULT '0',
  `ChrModelID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_race_x_chr_model`
--

LOCK TABLES `chr_race_x_chr_model` WRITE;
/*!40000 ALTER TABLE `chr_race_x_chr_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_race_x_chr_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_races`
--

DROP TABLE IF EXISTS `chr_races`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_races` (
  `ClientPrefix` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ClientFileString` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameFemale` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameLowercase` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameFemaleLowercase` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameS` text COLLATE utf8mb4_unicode_ci,
  `NameFemaleS` text COLLATE utf8mb4_unicode_ci,
  `NameLowercaseS` text COLLATE utf8mb4_unicode_ci,
  `NameFemaleLowercaseS` text COLLATE utf8mb4_unicode_ci,
  `RaceFantasyDescription` text COLLATE utf8mb4_unicode_ci,
  `NameL` text COLLATE utf8mb4_unicode_ci,
  `NameFemaleL` text COLLATE utf8mb4_unicode_ci,
  `NameLowercaseL` text COLLATE utf8mb4_unicode_ci,
  `NameFemaleLowercaseL` text COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `BaseLanguage` int NOT NULL DEFAULT '0',
  `ResSicknessSpellID` int NOT NULL DEFAULT '0',
  `SplashSoundID` int NOT NULL DEFAULT '0',
  `CreateScreenFileDataID` int NOT NULL DEFAULT '0',
  `SelectScreenFileDataID` int NOT NULL DEFAULT '0',
  `LowResScreenFileDataID` int NOT NULL DEFAULT '0',
  `AlteredFormStartVisualKitID1` int unsigned NOT NULL DEFAULT '0',
  `AlteredFormStartVisualKitID2` int unsigned NOT NULL DEFAULT '0',
  `AlteredFormStartVisualKitID3` int unsigned NOT NULL DEFAULT '0',
  `AlteredFormFinishVisualKitID1` int unsigned NOT NULL DEFAULT '0',
  `AlteredFormFinishVisualKitID2` int unsigned NOT NULL DEFAULT '0',
  `AlteredFormFinishVisualKitID3` int unsigned NOT NULL DEFAULT '0',
  `HeritageArmorAchievementID` int NOT NULL DEFAULT '0',
  `StartingLevel` int NOT NULL DEFAULT '0',
  `UiDisplayOrder` int NOT NULL DEFAULT '0',
  `PlayableRaceBit` int NOT NULL DEFAULT '0',
  `HelmetAnimScalingRaceID` int NOT NULL DEFAULT '0',
  `TransmogrifyDisabledSlotMask` int NOT NULL DEFAULT '0',
  `AlteredFormCustomizeOffsetFallback1` float NOT NULL DEFAULT '0',
  `AlteredFormCustomizeOffsetFallback2` float NOT NULL DEFAULT '0',
  `AlteredFormCustomizeOffsetFallback3` float NOT NULL DEFAULT '0',
  `AlteredFormCustomizeRotationFallback` float NOT NULL DEFAULT '0',
  `FactionID` smallint NOT NULL DEFAULT '0',
  `CinematicSequenceID` smallint NOT NULL DEFAULT '0',
  `CreatureType` tinyint NOT NULL DEFAULT '0',
  `Alliance` tinyint NOT NULL DEFAULT '0',
  `RaceRelated` tinyint NOT NULL DEFAULT '0',
  `UnalteredVisualRaceID` tinyint NOT NULL DEFAULT '0',
  `DefaultClassID` tinyint NOT NULL DEFAULT '0',
  `NeutralRaceID` tinyint NOT NULL DEFAULT '0',
  `MaleModelFallbackRaceID` tinyint NOT NULL DEFAULT '0',
  `MaleModelFallbackSex` tinyint NOT NULL DEFAULT '0',
  `FemaleModelFallbackRaceID` tinyint NOT NULL DEFAULT '0',
  `FemaleModelFallbackSex` tinyint NOT NULL DEFAULT '0',
  `MaleTextureFallbackRaceID` tinyint NOT NULL DEFAULT '0',
  `MaleTextureFallbackSex` tinyint NOT NULL DEFAULT '0',
  `FemaleTextureFallbackRaceID` tinyint NOT NULL DEFAULT '0',
  `FemaleTextureFallbackSex` tinyint NOT NULL DEFAULT '0',
  `UnalteredVisualCustomizationRaceID` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_races`
--

LOCK TABLES `chr_races` WRITE;
/*!40000 ALTER TABLE `chr_races` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_races` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_races_locale`
--

DROP TABLE IF EXISTS `chr_races_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_races_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameFemale_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameLowercase_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameFemaleLowercase_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `NameS_lang` text COLLATE utf8mb4_unicode_ci,
  `NameFemaleS_lang` text COLLATE utf8mb4_unicode_ci,
  `NameLowercaseS_lang` text COLLATE utf8mb4_unicode_ci,
  `NameFemaleLowercaseS_lang` text COLLATE utf8mb4_unicode_ci,
  `RaceFantasyDescription_lang` text COLLATE utf8mb4_unicode_ci,
  `NameL_lang` text COLLATE utf8mb4_unicode_ci,
  `NameFemaleL_lang` text COLLATE utf8mb4_unicode_ci,
  `NameLowercaseL_lang` text COLLATE utf8mb4_unicode_ci,
  `NameFemaleLowercaseL_lang` text COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_races_locale`
--

LOCK TABLES `chr_races_locale` WRITE;
/*!40000 ALTER TABLE `chr_races_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_races_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_specialization`
--

DROP TABLE IF EXISTS `chr_specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_specialization` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `FemaleName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ClassID` tinyint NOT NULL DEFAULT '0',
  `OrderIndex` tinyint NOT NULL DEFAULT '0',
  `PetTalentType` tinyint NOT NULL DEFAULT '0',
  `Role` tinyint NOT NULL DEFAULT '0',
  `Flags` int unsigned NOT NULL DEFAULT '0',
  `SpellIconFileID` int NOT NULL DEFAULT '0',
  `PrimaryStatPriority` tinyint NOT NULL DEFAULT '0',
  `AnimReplacements` int NOT NULL DEFAULT '0',
  `MasterySpellID1` int NOT NULL DEFAULT '0',
  `MasterySpellID2` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_specialization`
--

LOCK TABLES `chr_specialization` WRITE;
/*!40000 ALTER TABLE `chr_specialization` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chr_specialization_locale`
--

DROP TABLE IF EXISTS `chr_specialization_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chr_specialization_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `FemaleName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chr_specialization_locale`
--

LOCK TABLES `chr_specialization_locale` WRITE;
/*!40000 ALTER TABLE `chr_specialization_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `chr_specialization_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinematic_camera`
--

DROP TABLE IF EXISTS `cinematic_camera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinematic_camera` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `OriginX` float NOT NULL DEFAULT '0',
  `OriginY` float NOT NULL DEFAULT '0',
  `OriginZ` float NOT NULL DEFAULT '0',
  `SoundID` int unsigned NOT NULL DEFAULT '0',
  `OriginFacing` float NOT NULL DEFAULT '0',
  `FileDataID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinematic_camera`
--

LOCK TABLES `cinematic_camera` WRITE;
/*!40000 ALTER TABLE `cinematic_camera` DISABLE KEYS */;
/*!40000 ALTER TABLE `cinematic_camera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinematic_sequences`
--

DROP TABLE IF EXISTS `cinematic_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinematic_sequences` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SoundID` int unsigned NOT NULL DEFAULT '0',
  `Camera1` smallint unsigned NOT NULL DEFAULT '0',
  `Camera2` smallint unsigned NOT NULL DEFAULT '0',
  `Camera3` smallint unsigned NOT NULL DEFAULT '0',
  `Camera4` smallint unsigned NOT NULL DEFAULT '0',
  `Camera5` smallint unsigned NOT NULL DEFAULT '0',
  `Camera6` smallint unsigned NOT NULL DEFAULT '0',
  `Camera7` smallint unsigned NOT NULL DEFAULT '0',
  `Camera8` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinematic_sequences`
--

LOCK TABLES `cinematic_sequences` WRITE;
/*!40000 ALTER TABLE `cinematic_sequences` DISABLE KEYS */;
/*!40000 ALTER TABLE `cinematic_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_tuning`
--

DROP TABLE IF EXISTS `content_tuning`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content_tuning` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `ExpansionID` int NOT NULL DEFAULT '0',
  `MinLevel` int NOT NULL DEFAULT '0',
  `MaxLevel` int NOT NULL DEFAULT '0',
  `MinLevelType` int NOT NULL DEFAULT '0',
  `MaxLevelType` int NOT NULL DEFAULT '0',
  `TargetLevelDelta` int NOT NULL DEFAULT '0',
  `TargetLevelMaxDelta` int NOT NULL DEFAULT '0',
  `TargetLevelMin` int NOT NULL DEFAULT '0',
  `TargetLevelMax` int NOT NULL DEFAULT '0',
  `MinItemLevel` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_tuning`
--

LOCK TABLES `content_tuning` WRITE;
/*!40000 ALTER TABLE `content_tuning` DISABLE KEYS */;
/*!40000 ALTER TABLE `content_tuning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_tuning_x_expected`
--

DROP TABLE IF EXISTS `content_tuning_x_expected`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content_tuning_x_expected` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ExpectedStatModID` int NOT NULL DEFAULT '0',
  `MythicPlusSeasonID` int NOT NULL DEFAULT '0',
  `ContentTuningID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_tuning_x_expected`
--

LOCK TABLES `content_tuning_x_expected` WRITE;
/*!40000 ALTER TABLE `content_tuning_x_expected` DISABLE KEYS */;
/*!40000 ALTER TABLE `content_tuning_x_expected` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conversation_line`
--

DROP TABLE IF EXISTS `conversation_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conversation_line` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `BroadcastTextID` int unsigned NOT NULL DEFAULT '0',
  `SpellVisualKitID` int unsigned NOT NULL DEFAULT '0',
  `AdditionalDuration` int NOT NULL DEFAULT '0',
  `NextConversationLineID` smallint unsigned NOT NULL DEFAULT '0',
  `AnimKitID` smallint unsigned NOT NULL DEFAULT '0',
  `SpeechType` tinyint unsigned NOT NULL DEFAULT '0',
  `StartAnimation` tinyint unsigned NOT NULL DEFAULT '0',
  `EndAnimation` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conversation_line`
--

LOCK TABLES `conversation_line` WRITE;
/*!40000 ALTER TABLE `conversation_line` DISABLE KEYS */;
/*!40000 ALTER TABLE `conversation_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corruption_effects`
--

DROP TABLE IF EXISTS `corruption_effects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corruption_effects` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `MinCorruption` float NOT NULL DEFAULT '0',
  `Aura` int NOT NULL DEFAULT '0',
  `PlayerConditionID` int NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corruption_effects`
--

LOCK TABLES `corruption_effects` WRITE;
/*!40000 ALTER TABLE `corruption_effects` DISABLE KEYS */;
/*!40000 ALTER TABLE `corruption_effects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creature`
--

DROP TABLE IF EXISTS `creature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creature` (
  `ID` mediumint unsigned NOT NULL DEFAULT '0',
  `ItemID1` mediumint unsigned NOT NULL DEFAULT '0',
  `ItemID2` mediumint unsigned NOT NULL DEFAULT '0',
  `ItemID3` mediumint unsigned NOT NULL DEFAULT '0',
  `Mount` mediumint unsigned NOT NULL DEFAULT '0',
  `DisplayID1` mediumint unsigned NOT NULL DEFAULT '0',
  `DisplayID2` mediumint unsigned NOT NULL DEFAULT '0',
  `DisplayID3` mediumint unsigned NOT NULL DEFAULT '0',
  `DisplayID4` mediumint unsigned NOT NULL DEFAULT '0',
  `DisplayIDProbability1` float NOT NULL DEFAULT '0',
  `DisplayIDProbability2` float NOT NULL DEFAULT '0',
  `DisplayIDProbability3` float NOT NULL DEFAULT '0',
  `DisplayIDProbability4` float NOT NULL DEFAULT '0',
  `Name` text NOT NULL,
  `FemaleName` text NOT NULL,
  `SubName` text NOT NULL,
  `FemaleSubName` text NOT NULL,
  `Type` mediumint unsigned NOT NULL DEFAULT '0',
  `Family` tinyint unsigned NOT NULL DEFAULT '0',
  `Classification` tinyint unsigned NOT NULL DEFAULT '0',
  `InhabitType` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creature`
--

LOCK TABLES `creature` WRITE;
/*!40000 ALTER TABLE `creature` DISABLE KEYS */;
/*!40000 ALTER TABLE `creature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creature_difficulty`
--

DROP TABLE IF EXISTS `creature_difficulty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creature_difficulty` (
  `ID` mediumint unsigned NOT NULL DEFAULT '0',
  `CreatureID` mediumint unsigned NOT NULL DEFAULT '0',
  `Flags1` int unsigned NOT NULL DEFAULT '0',
  `Flags2` int unsigned NOT NULL DEFAULT '0',
  `Flags3` int unsigned NOT NULL DEFAULT '0',
  `Flags4` int unsigned NOT NULL DEFAULT '0',
  `Flags5` int unsigned NOT NULL DEFAULT '0',
  `Flags6` int unsigned NOT NULL DEFAULT '0',
  `Flags7` int unsigned NOT NULL DEFAULT '0',
  `FactionTemplateID` smallint unsigned NOT NULL DEFAULT '0',
  `Expansion` tinyint NOT NULL DEFAULT '0',
  `MinLevel` tinyint NOT NULL DEFAULT '0',
  `MaxLevel` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creature_difficulty`
--

LOCK TABLES `creature_difficulty` WRITE;
/*!40000 ALTER TABLE `creature_difficulty` DISABLE KEYS */;
/*!40000 ALTER TABLE `creature_difficulty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creature_display_info`
--

DROP TABLE IF EXISTS `creature_display_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creature_display_info` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ModelID` smallint unsigned NOT NULL DEFAULT '0',
  `SoundID` smallint unsigned NOT NULL DEFAULT '0',
  `SizeClass` tinyint NOT NULL DEFAULT '0',
  `CreatureModelScale` float NOT NULL DEFAULT '0',
  `CreatureModelAlpha` tinyint unsigned NOT NULL DEFAULT '0',
  `BloodID` tinyint unsigned NOT NULL DEFAULT '0',
  `ExtendedDisplayInfoID` int NOT NULL DEFAULT '0',
  `NPCSoundID` smallint unsigned NOT NULL DEFAULT '0',
  `ParticleColorID` smallint unsigned NOT NULL DEFAULT '0',
  `PortraitCreatureDisplayInfoID` int NOT NULL DEFAULT '0',
  `PortraitTextureFileDataID` int NOT NULL DEFAULT '0',
  `ObjectEffectPackageID` smallint unsigned NOT NULL DEFAULT '0',
  `AnimReplacementSetID` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `StateSpellVisualKitID` int NOT NULL DEFAULT '0',
  `PlayerOverrideScale` float NOT NULL DEFAULT '0',
  `PetInstanceScale` float NOT NULL DEFAULT '0',
  `UnarmedWeaponType` tinyint NOT NULL DEFAULT '0',
  `MountPoofSpellVisualKitID` int NOT NULL DEFAULT '0',
  `DissolveEffectID` int NOT NULL DEFAULT '0',
  `Gender` tinyint NOT NULL DEFAULT '0',
  `DissolveOutEffectID` int NOT NULL DEFAULT '0',
  `CreatureModelMinLod` tinyint NOT NULL DEFAULT '0',
  `TextureVariationFileDataID1` int NOT NULL DEFAULT '0',
  `TextureVariationFileDataID2` int NOT NULL DEFAULT '0',
  `TextureVariationFileDataID3` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creature_display_info`
--

LOCK TABLES `creature_display_info` WRITE;
/*!40000 ALTER TABLE `creature_display_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `creature_display_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creature_display_info_extra`
--

DROP TABLE IF EXISTS `creature_display_info_extra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creature_display_info_extra` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DisplayRaceID` tinyint NOT NULL DEFAULT '0',
  `DisplaySexID` tinyint NOT NULL DEFAULT '0',
  `DisplayClassID` tinyint NOT NULL DEFAULT '0',
  `Flags` tinyint NOT NULL DEFAULT '0',
  `BakeMaterialResourcesID` int NOT NULL DEFAULT '0',
  `HDBakeMaterialResourcesID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creature_display_info_extra`
--

LOCK TABLES `creature_display_info_extra` WRITE;
/*!40000 ALTER TABLE `creature_display_info_extra` DISABLE KEYS */;
/*!40000 ALTER TABLE `creature_display_info_extra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creature_family`
--

DROP TABLE IF EXISTS `creature_family`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creature_family` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `MinScale` float NOT NULL DEFAULT '0',
  `MinScaleLevel` tinyint NOT NULL DEFAULT '0',
  `MaxScale` float NOT NULL DEFAULT '0',
  `MaxScaleLevel` tinyint NOT NULL DEFAULT '0',
  `PetFoodMask` smallint NOT NULL DEFAULT '0',
  `PetTalentType` tinyint NOT NULL DEFAULT '0',
  `IconFileID` int NOT NULL DEFAULT '0',
  `SkillLine1` smallint NOT NULL DEFAULT '0',
  `SkillLine2` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creature_family`
--

LOCK TABLES `creature_family` WRITE;
/*!40000 ALTER TABLE `creature_family` DISABLE KEYS */;
/*!40000 ALTER TABLE `creature_family` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creature_family_locale`
--

DROP TABLE IF EXISTS `creature_family_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creature_family_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creature_family_locale`
--

LOCK TABLES `creature_family_locale` WRITE;
/*!40000 ALTER TABLE `creature_family_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `creature_family_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creature_model_data`
--

DROP TABLE IF EXISTS `creature_model_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creature_model_data` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `GeoBox1` float NOT NULL DEFAULT '0',
  `GeoBox2` float NOT NULL DEFAULT '0',
  `GeoBox3` float NOT NULL DEFAULT '0',
  `GeoBox4` float NOT NULL DEFAULT '0',
  `GeoBox5` float NOT NULL DEFAULT '0',
  `GeoBox6` float NOT NULL DEFAULT '0',
  `Flags` int unsigned NOT NULL DEFAULT '0',
  `FileDataID` int unsigned NOT NULL DEFAULT '0',
  `BloodID` int unsigned NOT NULL DEFAULT '0',
  `FootprintTextureID` int unsigned NOT NULL DEFAULT '0',
  `FootprintTextureLength` float NOT NULL DEFAULT '0',
  `FootprintTextureWidth` float NOT NULL DEFAULT '0',
  `FootprintParticleScale` float NOT NULL DEFAULT '0',
  `FoleyMaterialID` int unsigned NOT NULL DEFAULT '0',
  `FootstepCameraEffectID` int unsigned NOT NULL DEFAULT '0',
  `DeathThudCameraEffectID` int unsigned NOT NULL DEFAULT '0',
  `SoundID` int unsigned NOT NULL DEFAULT '0',
  `SizeClass` int unsigned NOT NULL DEFAULT '0',
  `CollisionWidth` float NOT NULL DEFAULT '0',
  `CollisionHeight` float NOT NULL DEFAULT '0',
  `WorldEffectScale` float NOT NULL DEFAULT '0',
  `CreatureGeosetDataID` int unsigned NOT NULL DEFAULT '0',
  `HoverHeight` float NOT NULL DEFAULT '0',
  `AttachedEffectScale` float NOT NULL DEFAULT '0',
  `ModelScale` float NOT NULL DEFAULT '0',
  `MissileCollisionRadius` float NOT NULL DEFAULT '0',
  `MissileCollisionPush` float NOT NULL DEFAULT '0',
  `MissileCollisionRaise` float NOT NULL DEFAULT '0',
  `MountHeight` float NOT NULL DEFAULT '0',
  `OverrideLootEffectScale` float NOT NULL DEFAULT '0',
  `OverrideNameScale` float NOT NULL DEFAULT '0',
  `OverrideSelectionRadius` float NOT NULL DEFAULT '0',
  `TamedPetBaseScale` float NOT NULL DEFAULT '0',
  `Unknown820_1` tinyint NOT NULL DEFAULT '0',
  `Unknown820_2` float NOT NULL DEFAULT '0',
  `Unknown820_31` float NOT NULL DEFAULT '0',
  `Unknown820_32` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creature_model_data`
--

LOCK TABLES `creature_model_data` WRITE;
/*!40000 ALTER TABLE `creature_model_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `creature_model_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creature_type`
--

DROP TABLE IF EXISTS `creature_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creature_type` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creature_type`
--

LOCK TABLES `creature_type` WRITE;
/*!40000 ALTER TABLE `creature_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `creature_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creature_type_locale`
--

DROP TABLE IF EXISTS `creature_type_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creature_type_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creature_type_locale`
--

LOCK TABLES `creature_type_locale` WRITE;
/*!40000 ALTER TABLE `creature_type_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `creature_type_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criteria`
--

DROP TABLE IF EXISTS `criteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criteria` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Type` smallint NOT NULL DEFAULT '0',
  `Asset` int NOT NULL DEFAULT '0',
  `ModifierTreeId` int unsigned NOT NULL DEFAULT '0',
  `StartEvent` tinyint unsigned NOT NULL DEFAULT '0',
  `StartAsset` int NOT NULL DEFAULT '0',
  `StartTimer` smallint unsigned NOT NULL DEFAULT '0',
  `FailEvent` tinyint unsigned NOT NULL DEFAULT '0',
  `FailAsset` int NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `EligibilityWorldStateID` smallint NOT NULL DEFAULT '0',
  `EligibilityWorldStateValue` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteria`
--

LOCK TABLES `criteria` WRITE;
/*!40000 ALTER TABLE `criteria` DISABLE KEYS */;
/*!40000 ALTER TABLE `criteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criteria_tree`
--

DROP TABLE IF EXISTS `criteria_tree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criteria_tree` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Parent` int unsigned NOT NULL DEFAULT '0',
  `Amount` int unsigned NOT NULL DEFAULT '0',
  `Operator` tinyint NOT NULL DEFAULT '0',
  `CriteriaID` int unsigned NOT NULL DEFAULT '0',
  `OrderIndex` int NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteria_tree`
--

LOCK TABLES `criteria_tree` WRITE;
/*!40000 ALTER TABLE `criteria_tree` DISABLE KEYS */;
/*!40000 ALTER TABLE `criteria_tree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criteria_tree_locale`
--

DROP TABLE IF EXISTS `criteria_tree_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criteria_tree_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteria_tree_locale`
--

LOCK TABLES `criteria_tree_locale` WRITE;
/*!40000 ALTER TABLE `criteria_tree_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `criteria_tree_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency_types`
--

DROP TABLE IF EXISTS `currency_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency_types` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `CategoryID` int NOT NULL DEFAULT '0',
  `InventoryIconFileID` int NOT NULL DEFAULT '0',
  `SpellWeight` int unsigned NOT NULL DEFAULT '0',
  `SpellCategory` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxQty` int unsigned NOT NULL DEFAULT '0',
  `MaxEarnablePerWeek` int unsigned NOT NULL DEFAULT '0',
  `Quality` tinyint NOT NULL DEFAULT '0',
  `FactionID` int NOT NULL DEFAULT '0',
  `ItemGroupSoundsID` int NOT NULL DEFAULT '0',
  `XpQuestDifficulty` int NOT NULL DEFAULT '0',
  `AwardConditionID` int NOT NULL DEFAULT '0',
  `MaxQtyWorldStateID` int NOT NULL DEFAULT '0',
  `Flags1` int NOT NULL DEFAULT '0',
  `Flags2` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency_types`
--

LOCK TABLES `currency_types` WRITE;
/*!40000 ALTER TABLE `currency_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `currency_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency_types_locale`
--

DROP TABLE IF EXISTS `currency_types_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency_types_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency_types_locale`
--

LOCK TABLES `currency_types_locale` WRITE;
/*!40000 ALTER TABLE `currency_types_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `currency_types_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curve`
--

DROP TABLE IF EXISTS `curve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curve` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Type` tinyint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curve`
--

LOCK TABLES `curve` WRITE;
/*!40000 ALTER TABLE `curve` DISABLE KEYS */;
/*!40000 ALTER TABLE `curve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curve_point`
--

DROP TABLE IF EXISTS `curve_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curve_point` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PosX` float NOT NULL DEFAULT '0',
  `PosY` float NOT NULL DEFAULT '0',
  `PosPreSquishX` float NOT NULL DEFAULT '0',
  `PosPreSquishY` float NOT NULL DEFAULT '0',
  `CurveID` smallint unsigned NOT NULL DEFAULT '0',
  `OrderIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curve_point`
--

LOCK TABLES `curve_point` WRITE;
/*!40000 ALTER TABLE `curve_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `curve_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destructible_model_data`
--

DROP TABLE IF EXISTS `destructible_model_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destructible_model_data` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `State0ImpactEffectDoodadSet` tinyint NOT NULL DEFAULT '0',
  `State0AmbientDoodadSet` tinyint unsigned NOT NULL DEFAULT '0',
  `State1Wmo` int NOT NULL DEFAULT '0',
  `State1DestructionDoodadSet` tinyint NOT NULL DEFAULT '0',
  `State1ImpactEffectDoodadSet` tinyint NOT NULL DEFAULT '0',
  `State1AmbientDoodadSet` tinyint unsigned NOT NULL DEFAULT '0',
  `State2Wmo` int NOT NULL DEFAULT '0',
  `State2DestructionDoodadSet` tinyint NOT NULL DEFAULT '0',
  `State2ImpactEffectDoodadSet` tinyint NOT NULL DEFAULT '0',
  `State2AmbientDoodadSet` tinyint unsigned NOT NULL DEFAULT '0',
  `State3Wmo` int NOT NULL DEFAULT '0',
  `State3InitDoodadSet` tinyint unsigned NOT NULL DEFAULT '0',
  `State3AmbientDoodadSet` tinyint unsigned NOT NULL DEFAULT '0',
  `EjectDirection` tinyint unsigned NOT NULL DEFAULT '0',
  `DoNotHighlight` tinyint unsigned NOT NULL DEFAULT '0',
  `State0Wmo` int NOT NULL DEFAULT '0',
  `HealEffect` tinyint unsigned NOT NULL DEFAULT '0',
  `HealEffectSpeed` smallint unsigned NOT NULL DEFAULT '0',
  `State0NameSet` tinyint NOT NULL DEFAULT '0',
  `State1NameSet` tinyint NOT NULL DEFAULT '0',
  `State2NameSet` tinyint NOT NULL DEFAULT '0',
  `State3NameSet` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destructible_model_data`
--

LOCK TABLES `destructible_model_data` WRITE;
/*!40000 ALTER TABLE `destructible_model_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `destructible_model_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `difficulty`
--

DROP TABLE IF EXISTS `difficulty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `difficulty` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `InstanceType` tinyint unsigned NOT NULL DEFAULT '0',
  `OrderIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `OldEnumValue` tinyint NOT NULL DEFAULT '0',
  `FallbackDifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `MinPlayers` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxPlayers` tinyint unsigned NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `ItemContext` tinyint unsigned NOT NULL DEFAULT '0',
  `ToggleDifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `GroupSizeHealthCurveID` smallint unsigned NOT NULL DEFAULT '0',
  `GroupSizeDmgCurveID` smallint unsigned NOT NULL DEFAULT '0',
  `GroupSizeSpellPointsCurveID` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `difficulty`
--

LOCK TABLES `difficulty` WRITE;
/*!40000 ALTER TABLE `difficulty` DISABLE KEYS */;
/*!40000 ALTER TABLE `difficulty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `difficulty_locale`
--

DROP TABLE IF EXISTS `difficulty_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `difficulty_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `difficulty_locale`
--

LOCK TABLES `difficulty_locale` WRITE;
/*!40000 ALTER TABLE `difficulty_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `difficulty_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dungeon_encounter`
--

DROP TABLE IF EXISTS `dungeon_encounter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dungeon_encounter` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `MapID` smallint NOT NULL DEFAULT '0',
  `DifficultyID` int NOT NULL DEFAULT '0',
  `OrderIndex` int NOT NULL DEFAULT '0',
  `CompleteWorldStateID` int NOT NULL DEFAULT '0',
  `Bit` tinyint NOT NULL DEFAULT '0',
  `CreatureDisplayID` int NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `SpellIconFileID` int NOT NULL DEFAULT '0',
  `Faction` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dungeon_encounter`
--

LOCK TABLES `dungeon_encounter` WRITE;
/*!40000 ALTER TABLE `dungeon_encounter` DISABLE KEYS */;
/*!40000 ALTER TABLE `dungeon_encounter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dungeon_encounter_locale`
--

DROP TABLE IF EXISTS `dungeon_encounter_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dungeon_encounter_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dungeon_encounter_locale`
--

LOCK TABLES `dungeon_encounter_locale` WRITE;
/*!40000 ALTER TABLE `dungeon_encounter_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `dungeon_encounter_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `durability_costs`
--

DROP TABLE IF EXISTS `durability_costs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `durability_costs` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost1` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost2` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost3` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost4` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost5` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost6` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost7` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost8` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost9` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost10` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost11` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost12` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost13` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost14` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost15` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost16` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost17` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost18` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost19` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost20` smallint unsigned NOT NULL DEFAULT '0',
  `WeaponSubClassCost21` smallint unsigned NOT NULL DEFAULT '0',
  `ArmorSubClassCost1` smallint unsigned NOT NULL DEFAULT '0',
  `ArmorSubClassCost2` smallint unsigned NOT NULL DEFAULT '0',
  `ArmorSubClassCost3` smallint unsigned NOT NULL DEFAULT '0',
  `ArmorSubClassCost4` smallint unsigned NOT NULL DEFAULT '0',
  `ArmorSubClassCost5` smallint unsigned NOT NULL DEFAULT '0',
  `ArmorSubClassCost6` smallint unsigned NOT NULL DEFAULT '0',
  `ArmorSubClassCost7` smallint unsigned NOT NULL DEFAULT '0',
  `ArmorSubClassCost8` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `durability_costs`
--

LOCK TABLES `durability_costs` WRITE;
/*!40000 ALTER TABLE `durability_costs` DISABLE KEYS */;
/*!40000 ALTER TABLE `durability_costs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `durability_quality`
--

DROP TABLE IF EXISTS `durability_quality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `durability_quality` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Data` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `durability_quality`
--

LOCK TABLES `durability_quality` WRITE;
/*!40000 ALTER TABLE `durability_quality` DISABLE KEYS */;
/*!40000 ALTER TABLE `durability_quality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emotes`
--

DROP TABLE IF EXISTS `emotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emotes` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `RaceMask` bigint NOT NULL DEFAULT '0',
  `EmoteSlashCommand` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `AnimID` int NOT NULL DEFAULT '0',
  `EmoteFlags` int unsigned NOT NULL DEFAULT '0',
  `EmoteSpecProc` tinyint unsigned NOT NULL DEFAULT '0',
  `EmoteSpecProcParam` int unsigned NOT NULL DEFAULT '0',
  `EventSoundID` int unsigned NOT NULL DEFAULT '0',
  `SpellVisualKitID` int unsigned NOT NULL DEFAULT '0',
  `ClassMask` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emotes`
--

LOCK TABLES `emotes` WRITE;
/*!40000 ALTER TABLE `emotes` DISABLE KEYS */;
/*!40000 ALTER TABLE `emotes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emotes_text`
--

DROP TABLE IF EXISTS `emotes_text`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emotes_text` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `EmoteID` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emotes_text`
--

LOCK TABLES `emotes_text` WRITE;
/*!40000 ALTER TABLE `emotes_text` DISABLE KEYS */;
/*!40000 ALTER TABLE `emotes_text` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emotes_text_sound`
--

DROP TABLE IF EXISTS `emotes_text_sound`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emotes_text_sound` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `RaceID` tinyint unsigned NOT NULL DEFAULT '0',
  `ClassID` tinyint unsigned NOT NULL DEFAULT '0',
  `SexID` tinyint unsigned NOT NULL DEFAULT '0',
  `SoundID` int unsigned NOT NULL DEFAULT '0',
  `EmotesTextID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emotes_text_sound`
--

LOCK TABLES `emotes_text_sound` WRITE;
/*!40000 ALTER TABLE `emotes_text_sound` DISABLE KEYS */;
/*!40000 ALTER TABLE `emotes_text_sound` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expected_stat`
--

DROP TABLE IF EXISTS `expected_stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expected_stat` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ExpansionID` int NOT NULL DEFAULT '0',
  `CreatureHealth` float NOT NULL DEFAULT '0',
  `PlayerHealth` float NOT NULL DEFAULT '0',
  `CreatureAutoAttackDps` float NOT NULL DEFAULT '0',
  `CreatureArmor` float NOT NULL DEFAULT '0',
  `PlayerMana` float NOT NULL DEFAULT '0',
  `PlayerPrimaryStat` float NOT NULL DEFAULT '0',
  `PlayerSecondaryStat` float NOT NULL DEFAULT '0',
  `ArmorConstant` float NOT NULL DEFAULT '0',
  `CreatureSpellDamage` float NOT NULL DEFAULT '0',
  `Lvl` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expected_stat`
--

LOCK TABLES `expected_stat` WRITE;
/*!40000 ALTER TABLE `expected_stat` DISABLE KEYS */;
/*!40000 ALTER TABLE `expected_stat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expected_stat_mod`
--

DROP TABLE IF EXISTS `expected_stat_mod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expected_stat_mod` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `CreatureHealthMod` float NOT NULL DEFAULT '0',
  `PlayerHealthMod` float NOT NULL DEFAULT '0',
  `CreatureAutoAttackDPSMod` float NOT NULL DEFAULT '0',
  `CreatureArmorMod` float NOT NULL DEFAULT '0',
  `PlayerManaMod` float NOT NULL DEFAULT '0',
  `PlayerPrimaryStatMod` float NOT NULL DEFAULT '0',
  `PlayerSecondaryStatMod` float NOT NULL DEFAULT '0',
  `ArmorConstantMod` float NOT NULL DEFAULT '0',
  `CreatureSpellDamageMod` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expected_stat_mod`
--

LOCK TABLES `expected_stat_mod` WRITE;
/*!40000 ALTER TABLE `expected_stat_mod` DISABLE KEYS */;
/*!40000 ALTER TABLE `expected_stat_mod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faction`
--

DROP TABLE IF EXISTS `faction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faction` (
  `ReputationRaceMask1` bigint NOT NULL DEFAULT '0',
  `ReputationRaceMask2` bigint NOT NULL DEFAULT '0',
  `ReputationRaceMask3` bigint NOT NULL DEFAULT '0',
  `ReputationRaceMask4` bigint NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ReputationIndex` smallint NOT NULL DEFAULT '0',
  `ParentFactionID` smallint unsigned NOT NULL DEFAULT '0',
  `Expansion` tinyint unsigned NOT NULL DEFAULT '0',
  `FriendshipRepID` int unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `ParagonFactionID` smallint unsigned NOT NULL DEFAULT '0',
  `ReputationClassMask1` smallint NOT NULL DEFAULT '0',
  `ReputationClassMask2` smallint NOT NULL DEFAULT '0',
  `ReputationClassMask3` smallint NOT NULL DEFAULT '0',
  `ReputationClassMask4` smallint NOT NULL DEFAULT '0',
  `ReputationFlags1` smallint unsigned NOT NULL DEFAULT '0',
  `ReputationFlags2` smallint unsigned NOT NULL DEFAULT '0',
  `ReputationFlags3` smallint unsigned NOT NULL DEFAULT '0',
  `ReputationFlags4` smallint unsigned NOT NULL DEFAULT '0',
  `ReputationBase1` int NOT NULL DEFAULT '0',
  `ReputationBase2` int NOT NULL DEFAULT '0',
  `ReputationBase3` int NOT NULL DEFAULT '0',
  `ReputationBase4` int NOT NULL DEFAULT '0',
  `ReputationMax1` int NOT NULL DEFAULT '0',
  `ReputationMax2` int NOT NULL DEFAULT '0',
  `ReputationMax3` int NOT NULL DEFAULT '0',
  `ReputationMax4` int NOT NULL DEFAULT '0',
  `ParentFactionMod1` float NOT NULL DEFAULT '0',
  `ParentFactionMod2` float NOT NULL DEFAULT '0',
  `ParentFactionCap1` tinyint unsigned NOT NULL DEFAULT '0',
  `ParentFactionCap2` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faction`
--

LOCK TABLES `faction` WRITE;
/*!40000 ALTER TABLE `faction` DISABLE KEYS */;
/*!40000 ALTER TABLE `faction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faction_locale`
--

DROP TABLE IF EXISTS `faction_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faction_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faction_locale`
--

LOCK TABLES `faction_locale` WRITE;
/*!40000 ALTER TABLE `faction_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `faction_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faction_template`
--

DROP TABLE IF EXISTS `faction_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faction_template` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Faction` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `FactionGroup` tinyint unsigned NOT NULL DEFAULT '0',
  `FriendGroup` tinyint unsigned NOT NULL DEFAULT '0',
  `EnemyGroup` tinyint unsigned NOT NULL DEFAULT '0',
  `Enemies1` smallint unsigned NOT NULL DEFAULT '0',
  `Enemies2` smallint unsigned NOT NULL DEFAULT '0',
  `Enemies3` smallint unsigned NOT NULL DEFAULT '0',
  `Enemies4` smallint unsigned NOT NULL DEFAULT '0',
  `Friend1` smallint unsigned NOT NULL DEFAULT '0',
  `Friend2` smallint unsigned NOT NULL DEFAULT '0',
  `Friend3` smallint unsigned NOT NULL DEFAULT '0',
  `Friend4` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faction_template`
--

LOCK TABLES `faction_template` WRITE;
/*!40000 ALTER TABLE `faction_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `faction_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameobject_display_info`
--

DROP TABLE IF EXISTS `gameobject_display_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gameobject_display_info` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `GeoBoxMinX` float NOT NULL DEFAULT '0',
  `GeoBoxMinY` float NOT NULL DEFAULT '0',
  `GeoBoxMinZ` float NOT NULL DEFAULT '0',
  `GeoBoxMaxX` float NOT NULL DEFAULT '0',
  `GeoBoxMaxY` float NOT NULL DEFAULT '0',
  `GeoBoxMaxZ` float NOT NULL DEFAULT '0',
  `FileDataID` int NOT NULL DEFAULT '0',
  `ObjectEffectPackageID` smallint NOT NULL DEFAULT '0',
  `OverrideLootEffectScale` float NOT NULL DEFAULT '0',
  `OverrideNameScale` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameobject_display_info`
--

LOCK TABLES `gameobject_display_info` WRITE;
/*!40000 ALTER TABLE `gameobject_display_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `gameobject_display_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameobjects`
--

DROP TABLE IF EXISTS `gameobjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gameobjects` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `PosX` float NOT NULL DEFAULT '0',
  `PosY` float NOT NULL DEFAULT '0',
  `PosZ` float NOT NULL DEFAULT '0',
  `Rot1` float NOT NULL DEFAULT '0',
  `Rot2` float NOT NULL DEFAULT '0',
  `Rot3` float NOT NULL DEFAULT '0',
  `Rot4` float NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `OwnerID` int NOT NULL DEFAULT '0',
  `DisplayID` int NOT NULL DEFAULT '0',
  `Scale` float NOT NULL DEFAULT '0',
  `TypeID` int NOT NULL DEFAULT '0',
  `PhaseUseFlags` int NOT NULL DEFAULT '0',
  `PhaseID` int NOT NULL DEFAULT '0',
  `PhaseGroupID` int NOT NULL DEFAULT '0',
  `PropValue1` int NOT NULL DEFAULT '0',
  `PropValue2` int NOT NULL DEFAULT '0',
  `PropValue3` int NOT NULL DEFAULT '0',
  `PropValue4` int NOT NULL DEFAULT '0',
  `PropValue5` int NOT NULL DEFAULT '0',
  `PropValue6` int NOT NULL DEFAULT '0',
  `PropValue7` int NOT NULL DEFAULT '0',
  `PropValue8` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameobjects`
--

LOCK TABLES `gameobjects` WRITE;
/*!40000 ALTER TABLE `gameobjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `gameobjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameobjects_locale`
--

DROP TABLE IF EXISTS `gameobjects_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gameobjects_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameobjects_locale`
--

LOCK TABLES `gameobjects_locale` WRITE;
/*!40000 ALTER TABLE `gameobjects_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `gameobjects_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_ability`
--

DROP TABLE IF EXISTS `garr_ability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_ability` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `GarrAbilityCategoryID` tinyint unsigned NOT NULL DEFAULT '0',
  `GarrFollowerTypeID` tinyint unsigned NOT NULL DEFAULT '0',
  `IconFileDataID` int NOT NULL DEFAULT '0',
  `FactionChangeGarrAbilityID` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_ability`
--

LOCK TABLES `garr_ability` WRITE;
/*!40000 ALTER TABLE `garr_ability` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_ability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_ability_locale`
--

DROP TABLE IF EXISTS `garr_ability_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_ability_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_ability_locale`
--

LOCK TABLES `garr_ability_locale` WRITE;
/*!40000 ALTER TABLE `garr_ability_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_ability_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_building`
--

DROP TABLE IF EXISTS `garr_building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_building` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `HordeName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `AllianceName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Tooltip` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `GarrTypeID` tinyint unsigned NOT NULL DEFAULT '0',
  `BuildingType` tinyint unsigned NOT NULL DEFAULT '0',
  `HordeGameObjectID` int NOT NULL DEFAULT '0',
  `AllianceGameObjectID` int NOT NULL DEFAULT '0',
  `GarrSiteID` int NOT NULL DEFAULT '0',
  `UpgradeLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `BuildSeconds` int NOT NULL DEFAULT '0',
  `CurrencyTypeID` smallint unsigned NOT NULL DEFAULT '0',
  `CurrencyQty` int NOT NULL DEFAULT '0',
  `HordeUiTextureKitID` smallint unsigned NOT NULL DEFAULT '0',
  `AllianceUiTextureKitID` smallint unsigned NOT NULL DEFAULT '0',
  `IconFileDataID` int NOT NULL DEFAULT '0',
  `AllianceSceneScriptPackageID` smallint unsigned NOT NULL DEFAULT '0',
  `HordeSceneScriptPackageID` smallint unsigned NOT NULL DEFAULT '0',
  `MaxAssignments` int NOT NULL DEFAULT '0',
  `ShipmentCapacity` tinyint unsigned NOT NULL DEFAULT '0',
  `GarrAbilityID` smallint unsigned NOT NULL DEFAULT '0',
  `BonusGarrAbilityID` smallint unsigned NOT NULL DEFAULT '0',
  `GoldCost` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_building`
--

LOCK TABLES `garr_building` WRITE;
/*!40000 ALTER TABLE `garr_building` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_building_locale`
--

DROP TABLE IF EXISTS `garr_building_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_building_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `HordeName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `AllianceName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Tooltip_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_building_locale`
--

LOCK TABLES `garr_building_locale` WRITE;
/*!40000 ALTER TABLE `garr_building_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_building_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_building_plot_inst`
--

DROP TABLE IF EXISTS `garr_building_plot_inst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_building_plot_inst` (
  `MapOffsetX` float NOT NULL DEFAULT '0',
  `MapOffsetY` float NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `GarrBuildingID` tinyint unsigned NOT NULL DEFAULT '0',
  `GarrSiteLevelPlotInstID` smallint unsigned NOT NULL DEFAULT '0',
  `UiTextureAtlasMemberID` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_building_plot_inst`
--

LOCK TABLES `garr_building_plot_inst` WRITE;
/*!40000 ALTER TABLE `garr_building_plot_inst` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_building_plot_inst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_class_spec`
--

DROP TABLE IF EXISTS `garr_class_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_class_spec` (
  `ClassSpec` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ClassSpecMale` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ClassSpecFemale` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `UiTextureAtlasMemberID` smallint unsigned NOT NULL DEFAULT '0',
  `GarrFollItemSetID` smallint unsigned NOT NULL DEFAULT '0',
  `FollowerClassLimit` tinyint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_class_spec`
--

LOCK TABLES `garr_class_spec` WRITE;
/*!40000 ALTER TABLE `garr_class_spec` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_class_spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_class_spec_locale`
--

DROP TABLE IF EXISTS `garr_class_spec_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_class_spec_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ClassSpec_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ClassSpecMale_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ClassSpecFemale_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_class_spec_locale`
--

LOCK TABLES `garr_class_spec_locale` WRITE;
/*!40000 ALTER TABLE `garr_class_spec_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_class_spec_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_follower`
--

DROP TABLE IF EXISTS `garr_follower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_follower` (
  `HordeSourceText` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `AllianceSourceText` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `TitleName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `GarrTypeID` tinyint unsigned NOT NULL DEFAULT '0',
  `GarrFollowerTypeID` tinyint unsigned NOT NULL DEFAULT '0',
  `HordeCreatureID` int NOT NULL DEFAULT '0',
  `AllianceCreatureID` int NOT NULL DEFAULT '0',
  `HordeGarrFollRaceID` tinyint unsigned NOT NULL DEFAULT '0',
  `AllianceGarrFollRaceID` tinyint unsigned NOT NULL DEFAULT '0',
  `HordeGarrClassSpecID` int NOT NULL DEFAULT '0',
  `AllianceGarrClassSpecID` int NOT NULL DEFAULT '0',
  `Quality` tinyint unsigned NOT NULL DEFAULT '0',
  `FollowerLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `ItemLevelWeapon` smallint unsigned NOT NULL DEFAULT '0',
  `ItemLevelArmor` smallint unsigned NOT NULL DEFAULT '0',
  `HordeSourceTypeEnum` tinyint NOT NULL DEFAULT '0',
  `AllianceSourceTypeEnum` tinyint NOT NULL DEFAULT '0',
  `HordeIconFileDataID` int NOT NULL DEFAULT '0',
  `AllianceIconFileDataID` int NOT NULL DEFAULT '0',
  `HordeGarrFollItemSetID` smallint unsigned NOT NULL DEFAULT '0',
  `AllianceGarrFollItemSetID` smallint unsigned NOT NULL DEFAULT '0',
  `HordeUITextureKitID` smallint unsigned NOT NULL DEFAULT '0',
  `AllianceUITextureKitID` smallint unsigned NOT NULL DEFAULT '0',
  `Vitality` tinyint unsigned NOT NULL DEFAULT '0',
  `HordeFlavorGarrStringID` tinyint unsigned NOT NULL DEFAULT '0',
  `AllianceFlavorGarrStringID` tinyint unsigned NOT NULL DEFAULT '0',
  `HordeSlottingBroadcastTextID` int unsigned NOT NULL DEFAULT '0',
  `AllySlottingBroadcastTextID` int unsigned NOT NULL DEFAULT '0',
  `ChrClassID` tinyint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `Gender` tinyint unsigned NOT NULL DEFAULT '0',
  `AutoCombatantID` int NOT NULL DEFAULT '0',
  `CovenantID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_follower`
--

LOCK TABLES `garr_follower` WRITE;
/*!40000 ALTER TABLE `garr_follower` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_follower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_follower_locale`
--

DROP TABLE IF EXISTS `garr_follower_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_follower_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `HordeSourceText_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `AllianceSourceText_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `TitleName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_follower_locale`
--

LOCK TABLES `garr_follower_locale` WRITE;
/*!40000 ALTER TABLE `garr_follower_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_follower_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_follower_x_ability`
--

DROP TABLE IF EXISTS `garr_follower_x_ability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_follower_x_ability` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `OrderIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `FactionIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `GarrAbilityID` smallint unsigned NOT NULL DEFAULT '0',
  `GarrFollowerID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_follower_x_ability`
--

LOCK TABLES `garr_follower_x_ability` WRITE;
/*!40000 ALTER TABLE `garr_follower_x_ability` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_follower_x_ability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_plot`
--

DROP TABLE IF EXISTS `garr_plot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_plot` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `PlotType` tinyint unsigned NOT NULL DEFAULT '0',
  `HordeConstructObjID` int NOT NULL DEFAULT '0',
  `AllianceConstructObjID` int NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `UiCategoryID` tinyint unsigned NOT NULL DEFAULT '0',
  `UpgradeRequirement1` int unsigned NOT NULL DEFAULT '0',
  `UpgradeRequirement2` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_plot`
--

LOCK TABLES `garr_plot` WRITE;
/*!40000 ALTER TABLE `garr_plot` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_plot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_plot_building`
--

DROP TABLE IF EXISTS `garr_plot_building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_plot_building` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `GarrPlotID` tinyint unsigned NOT NULL DEFAULT '0',
  `GarrBuildingID` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_plot_building`
--

LOCK TABLES `garr_plot_building` WRITE;
/*!40000 ALTER TABLE `garr_plot_building` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_plot_building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_plot_instance`
--

DROP TABLE IF EXISTS `garr_plot_instance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_plot_instance` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `GarrPlotID` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_plot_instance`
--

LOCK TABLES `garr_plot_instance` WRITE;
/*!40000 ALTER TABLE `garr_plot_instance` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_plot_instance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_site_level`
--

DROP TABLE IF EXISTS `garr_site_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_site_level` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `TownHallUiPosX` float NOT NULL DEFAULT '0',
  `TownHallUiPosY` float NOT NULL DEFAULT '0',
  `GarrSiteID` int unsigned NOT NULL DEFAULT '0',
  `GarrLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `MapID` smallint unsigned NOT NULL DEFAULT '0',
  `UpgradeMovieID` smallint unsigned NOT NULL DEFAULT '0',
  `UiTextureKitID` smallint unsigned NOT NULL DEFAULT '0',
  `MaxBuildingLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `UpgradeCost` smallint unsigned NOT NULL DEFAULT '0',
  `UpgradeGoldCost` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_site_level`
--

LOCK TABLES `garr_site_level` WRITE;
/*!40000 ALTER TABLE `garr_site_level` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_site_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garr_site_level_plot_inst`
--

DROP TABLE IF EXISTS `garr_site_level_plot_inst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garr_site_level_plot_inst` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `UiMarkerPosX` float NOT NULL DEFAULT '0',
  `UiMarkerPosY` float NOT NULL DEFAULT '0',
  `GarrSiteLevelID` smallint unsigned NOT NULL DEFAULT '0',
  `GarrPlotInstanceID` tinyint unsigned NOT NULL DEFAULT '0',
  `UiMarkerSize` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garr_site_level_plot_inst`
--

LOCK TABLES `garr_site_level_plot_inst` WRITE;
/*!40000 ALTER TABLE `garr_site_level_plot_inst` DISABLE KEYS */;
/*!40000 ALTER TABLE `garr_site_level_plot_inst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gem_properties`
--

DROP TABLE IF EXISTS `gem_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gem_properties` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `EnchantId` smallint unsigned NOT NULL DEFAULT '0',
  `Type` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gem_properties`
--

LOCK TABLES `gem_properties` WRITE;
/*!40000 ALTER TABLE `gem_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `gem_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glyph_bindable_spell`
--

DROP TABLE IF EXISTS `glyph_bindable_spell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `glyph_bindable_spell` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `GlyphPropertiesID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glyph_bindable_spell`
--

LOCK TABLES `glyph_bindable_spell` WRITE;
/*!40000 ALTER TABLE `glyph_bindable_spell` DISABLE KEYS */;
/*!40000 ALTER TABLE `glyph_bindable_spell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glyph_properties`
--

DROP TABLE IF EXISTS `glyph_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `glyph_properties` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `GlyphType` tinyint unsigned NOT NULL DEFAULT '0',
  `GlyphExclusiveCategoryID` tinyint unsigned NOT NULL DEFAULT '0',
  `SpellIconFileDataID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glyph_properties`
--

LOCK TABLES `glyph_properties` WRITE;
/*!40000 ALTER TABLE `glyph_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `glyph_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glyph_required_spec`
--

DROP TABLE IF EXISTS `glyph_required_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `glyph_required_spec` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ChrSpecializationID` smallint unsigned NOT NULL DEFAULT '0',
  `GlyphPropertiesID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glyph_required_spec`
--

LOCK TABLES `glyph_required_spec` WRITE;
/*!40000 ALTER TABLE `glyph_required_spec` DISABLE KEYS */;
/*!40000 ALTER TABLE `glyph_required_spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guild_color_background`
--

DROP TABLE IF EXISTS `guild_color_background`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guild_color_background` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Red` tinyint unsigned NOT NULL DEFAULT '0',
  `Blue` tinyint unsigned NOT NULL DEFAULT '0',
  `Green` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guild_color_background`
--

LOCK TABLES `guild_color_background` WRITE;
/*!40000 ALTER TABLE `guild_color_background` DISABLE KEYS */;
/*!40000 ALTER TABLE `guild_color_background` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guild_color_border`
--

DROP TABLE IF EXISTS `guild_color_border`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guild_color_border` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Red` tinyint unsigned NOT NULL DEFAULT '0',
  `Blue` tinyint unsigned NOT NULL DEFAULT '0',
  `Green` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guild_color_border`
--

LOCK TABLES `guild_color_border` WRITE;
/*!40000 ALTER TABLE `guild_color_border` DISABLE KEYS */;
/*!40000 ALTER TABLE `guild_color_border` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guild_color_emblem`
--

DROP TABLE IF EXISTS `guild_color_emblem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guild_color_emblem` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Red` tinyint unsigned NOT NULL DEFAULT '0',
  `Blue` tinyint unsigned NOT NULL DEFAULT '0',
  `Green` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guild_color_emblem`
--

LOCK TABLES `guild_color_emblem` WRITE;
/*!40000 ALTER TABLE `guild_color_emblem` DISABLE KEYS */;
/*!40000 ALTER TABLE `guild_color_emblem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guild_perk_spells`
--

DROP TABLE IF EXISTS `guild_perk_spells`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guild_perk_spells` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guild_perk_spells`
--

LOCK TABLES `guild_perk_spells` WRITE;
/*!40000 ALTER TABLE `guild_perk_spells` DISABLE KEYS */;
/*!40000 ALTER TABLE `guild_perk_spells` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `heirloom`
--

DROP TABLE IF EXISTS `heirloom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `heirloom` (
  `SourceText` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemID` int NOT NULL DEFAULT '0',
  `LegacyUpgradedItemID` int NOT NULL DEFAULT '0',
  `StaticUpgradedItemID` int NOT NULL DEFAULT '0',
  `SourceTypeEnum` tinyint NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `LegacyItemID` int NOT NULL DEFAULT '0',
  `UpgradeItemID1` int NOT NULL DEFAULT '0',
  `UpgradeItemID2` int NOT NULL DEFAULT '0',
  `UpgradeItemID3` int NOT NULL DEFAULT '0',
  `UpgradeItemID4` int NOT NULL DEFAULT '0',
  `UpgradeItemBonusListID1` smallint unsigned NOT NULL DEFAULT '0',
  `UpgradeItemBonusListID2` smallint unsigned NOT NULL DEFAULT '0',
  `UpgradeItemBonusListID3` smallint unsigned NOT NULL DEFAULT '0',
  `UpgradeItemBonusListID4` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `heirloom`
--

LOCK TABLES `heirloom` WRITE;
/*!40000 ALTER TABLE `heirloom` DISABLE KEYS */;
/*!40000 ALTER TABLE `heirloom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `heirloom_locale`
--

DROP TABLE IF EXISTS `heirloom_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `heirloom_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SourceText_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `heirloom_locale`
--

LOCK TABLES `heirloom_locale` WRITE;
/*!40000 ALTER TABLE `heirloom_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `heirloom_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holidays`
--

DROP TABLE IF EXISTS `holidays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `holidays` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Region` smallint unsigned NOT NULL DEFAULT '0',
  `Looping` tinyint unsigned NOT NULL DEFAULT '0',
  `HolidayNameID` int unsigned NOT NULL DEFAULT '0',
  `HolidayDescriptionID` int unsigned NOT NULL DEFAULT '0',
  `Priority` tinyint unsigned NOT NULL DEFAULT '0',
  `CalendarFilterType` tinyint NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `Duration1` smallint unsigned NOT NULL DEFAULT '0',
  `Duration2` smallint unsigned NOT NULL DEFAULT '0',
  `Duration3` smallint unsigned NOT NULL DEFAULT '0',
  `Duration4` smallint unsigned NOT NULL DEFAULT '0',
  `Duration5` smallint unsigned NOT NULL DEFAULT '0',
  `Duration6` smallint unsigned NOT NULL DEFAULT '0',
  `Duration7` smallint unsigned NOT NULL DEFAULT '0',
  `Duration8` smallint unsigned NOT NULL DEFAULT '0',
  `Duration9` smallint unsigned NOT NULL DEFAULT '0',
  `Duration10` smallint unsigned NOT NULL DEFAULT '0',
  `Date1` int unsigned NOT NULL DEFAULT '0',
  `Date2` int unsigned NOT NULL DEFAULT '0',
  `Date3` int unsigned NOT NULL DEFAULT '0',
  `Date4` int unsigned NOT NULL DEFAULT '0',
  `Date5` int unsigned NOT NULL DEFAULT '0',
  `Date6` int unsigned NOT NULL DEFAULT '0',
  `Date7` int unsigned NOT NULL DEFAULT '0',
  `Date8` int unsigned NOT NULL DEFAULT '0',
  `Date9` int unsigned NOT NULL DEFAULT '0',
  `Date10` int unsigned NOT NULL DEFAULT '0',
  `Date11` int unsigned NOT NULL DEFAULT '0',
  `Date12` int unsigned NOT NULL DEFAULT '0',
  `Date13` int unsigned NOT NULL DEFAULT '0',
  `Date14` int unsigned NOT NULL DEFAULT '0',
  `Date15` int unsigned NOT NULL DEFAULT '0',
  `Date16` int unsigned NOT NULL DEFAULT '0',
  `Date17` int unsigned NOT NULL DEFAULT '0',
  `Date18` int unsigned NOT NULL DEFAULT '0',
  `Date19` int unsigned NOT NULL DEFAULT '0',
  `Date20` int unsigned NOT NULL DEFAULT '0',
  `Date21` int unsigned NOT NULL DEFAULT '0',
  `Date22` int unsigned NOT NULL DEFAULT '0',
  `Date23` int unsigned NOT NULL DEFAULT '0',
  `Date24` int unsigned NOT NULL DEFAULT '0',
  `Date25` int unsigned NOT NULL DEFAULT '0',
  `Date26` int unsigned NOT NULL DEFAULT '0',
  `CalendarFlags1` tinyint unsigned NOT NULL DEFAULT '0',
  `CalendarFlags2` tinyint unsigned NOT NULL DEFAULT '0',
  `CalendarFlags3` tinyint unsigned NOT NULL DEFAULT '0',
  `CalendarFlags4` tinyint unsigned NOT NULL DEFAULT '0',
  `CalendarFlags5` tinyint unsigned NOT NULL DEFAULT '0',
  `CalendarFlags6` tinyint unsigned NOT NULL DEFAULT '0',
  `CalendarFlags7` tinyint unsigned NOT NULL DEFAULT '0',
  `CalendarFlags8` tinyint unsigned NOT NULL DEFAULT '0',
  `CalendarFlags9` tinyint unsigned NOT NULL DEFAULT '0',
  `CalendarFlags10` tinyint unsigned NOT NULL DEFAULT '0',
  `TextureFileDataID1` int NOT NULL DEFAULT '0',
  `TextureFileDataID2` int NOT NULL DEFAULT '0',
  `TextureFileDataID3` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holidays`
--

LOCK TABLES `holidays` WRITE;
/*!40000 ALTER TABLE `holidays` DISABLE KEYS */;
/*!40000 ALTER TABLE `holidays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotfix_blob`
--

DROP TABLE IF EXISTS `hotfix_blob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotfix_blob` (
  `TableHash` int unsigned NOT NULL,
  `RecordId` int NOT NULL,
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Blob` blob,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`TableHash`,`RecordId`,`locale`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotfix_blob`
--

LOCK TABLES `hotfix_blob` WRITE;
/*!40000 ALTER TABLE `hotfix_blob` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotfix_blob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotfix_data`
--

DROP TABLE IF EXISTS `hotfix_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotfix_data` (
  `Id` int NOT NULL,
  `TableHash` int unsigned NOT NULL,
  `RecordId` int NOT NULL,
  `Deleted` tinyint unsigned DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`,`TableHash`,`RecordId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotfix_data`
--

LOCK TABLES `hotfix_data` WRITE;
/*!40000 ALTER TABLE `hotfix_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotfix_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotfix_optional_data`
--

DROP TABLE IF EXISTS `hotfix_optional_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotfix_optional_data` (
  `TableHash` int unsigned NOT NULL,
  `RecordId` int unsigned NOT NULL,
  `locale` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Key` int unsigned NOT NULL,
  `Data` blob NOT NULL,
  `VerifiedBuild` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotfix_optional_data`
--

LOCK TABLES `hotfix_optional_data` WRITE;
/*!40000 ALTER TABLE `hotfix_optional_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotfix_optional_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_price_armor`
--

DROP TABLE IF EXISTS `import_price_armor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_price_armor` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ClothModifier` float NOT NULL DEFAULT '0',
  `LeatherModifier` float NOT NULL DEFAULT '0',
  `ChainModifier` float NOT NULL DEFAULT '0',
  `PlateModifier` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_price_armor`
--

LOCK TABLES `import_price_armor` WRITE;
/*!40000 ALTER TABLE `import_price_armor` DISABLE KEYS */;
/*!40000 ALTER TABLE `import_price_armor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_price_quality`
--

DROP TABLE IF EXISTS `import_price_quality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_price_quality` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Data` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_price_quality`
--

LOCK TABLES `import_price_quality` WRITE;
/*!40000 ALTER TABLE `import_price_quality` DISABLE KEYS */;
/*!40000 ALTER TABLE `import_price_quality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_price_shield`
--

DROP TABLE IF EXISTS `import_price_shield`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_price_shield` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Data` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_price_shield`
--

LOCK TABLES `import_price_shield` WRITE;
/*!40000 ALTER TABLE `import_price_shield` DISABLE KEYS */;
/*!40000 ALTER TABLE `import_price_shield` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_price_weapon`
--

DROP TABLE IF EXISTS `import_price_weapon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_price_weapon` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Data` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_price_weapon`
--

LOCK TABLES `import_price_weapon` WRITE;
/*!40000 ALTER TABLE `import_price_weapon` DISABLE KEYS */;
/*!40000 ALTER TABLE `import_price_weapon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ClassID` tinyint unsigned NOT NULL DEFAULT '0',
  `SubclassID` tinyint unsigned NOT NULL DEFAULT '0',
  `Material` tinyint unsigned NOT NULL DEFAULT '0',
  `InventoryType` tinyint NOT NULL DEFAULT '0',
  `SheatheType` tinyint unsigned NOT NULL DEFAULT '0',
  `SoundOverrideSubclassID` tinyint NOT NULL DEFAULT '0',
  `IconFileDataID` int NOT NULL DEFAULT '0',
  `ItemGroupSoundsID` tinyint unsigned NOT NULL DEFAULT '0',
  `ModifiedCraftingReagentItemID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_appearance`
--

DROP TABLE IF EXISTS `item_appearance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_appearance` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DisplayType` tinyint unsigned NOT NULL DEFAULT '0',
  `ItemDisplayInfoID` int NOT NULL DEFAULT '0',
  `DefaultIconFileDataID` int NOT NULL DEFAULT '0',
  `UiOrder` int NOT NULL DEFAULT '0',
  `PlayerConditionID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_appearance`
--

LOCK TABLES `item_appearance` WRITE;
/*!40000 ALTER TABLE `item_appearance` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_appearance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_armor_quality`
--

DROP TABLE IF EXISTS `item_armor_quality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_armor_quality` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Qualitymod1` float NOT NULL DEFAULT '0',
  `Qualitymod2` float NOT NULL DEFAULT '0',
  `Qualitymod3` float NOT NULL DEFAULT '0',
  `Qualitymod4` float NOT NULL DEFAULT '0',
  `Qualitymod5` float NOT NULL DEFAULT '0',
  `Qualitymod6` float NOT NULL DEFAULT '0',
  `Qualitymod7` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_armor_quality`
--

LOCK TABLES `item_armor_quality` WRITE;
/*!40000 ALTER TABLE `item_armor_quality` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_armor_quality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_armor_shield`
--

DROP TABLE IF EXISTS `item_armor_shield`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_armor_shield` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Quality1` float NOT NULL DEFAULT '0',
  `Quality2` float NOT NULL DEFAULT '0',
  `Quality3` float NOT NULL DEFAULT '0',
  `Quality4` float NOT NULL DEFAULT '0',
  `Quality5` float NOT NULL DEFAULT '0',
  `Quality6` float NOT NULL DEFAULT '0',
  `Quality7` float NOT NULL DEFAULT '0',
  `ItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_armor_shield`
--

LOCK TABLES `item_armor_shield` WRITE;
/*!40000 ALTER TABLE `item_armor_shield` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_armor_shield` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_armor_total`
--

DROP TABLE IF EXISTS `item_armor_total`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_armor_total` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemLevel` smallint NOT NULL DEFAULT '0',
  `Cloth` float NOT NULL DEFAULT '0',
  `Leather` float NOT NULL DEFAULT '0',
  `Mail` float NOT NULL DEFAULT '0',
  `Plate` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_armor_total`
--

LOCK TABLES `item_armor_total` WRITE;
/*!40000 ALTER TABLE `item_armor_total` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_armor_total` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_bag_family`
--

DROP TABLE IF EXISTS `item_bag_family`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_bag_family` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_bag_family`
--

LOCK TABLES `item_bag_family` WRITE;
/*!40000 ALTER TABLE `item_bag_family` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_bag_family` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_bag_family_locale`
--

DROP TABLE IF EXISTS `item_bag_family_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_bag_family_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_bag_family_locale`
--

LOCK TABLES `item_bag_family_locale` WRITE;
/*!40000 ALTER TABLE `item_bag_family_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_bag_family_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_bonus`
--

DROP TABLE IF EXISTS `item_bonus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_bonus` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Value1` int NOT NULL DEFAULT '0',
  `Value2` int NOT NULL DEFAULT '0',
  `Value3` int NOT NULL DEFAULT '0',
  `Value4` int NOT NULL DEFAULT '0',
  `ParentItemBonusListID` smallint unsigned NOT NULL DEFAULT '0',
  `Type` tinyint unsigned NOT NULL DEFAULT '0',
  `OrderIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_bonus`
--

LOCK TABLES `item_bonus` WRITE;
/*!40000 ALTER TABLE `item_bonus` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_bonus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_bonus_list_level_delta`
--

DROP TABLE IF EXISTS `item_bonus_list_level_delta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_bonus_list_level_delta` (
  `ItemLevelDelta` smallint NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_bonus_list_level_delta`
--

LOCK TABLES `item_bonus_list_level_delta` WRITE;
/*!40000 ALTER TABLE `item_bonus_list_level_delta` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_bonus_list_level_delta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_bonus_tree_node`
--

DROP TABLE IF EXISTS `item_bonus_tree_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_bonus_tree_node` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemContext` tinyint unsigned NOT NULL DEFAULT '0',
  `ChildItemBonusTreeID` smallint unsigned NOT NULL DEFAULT '0',
  `ChildItemBonusListID` smallint unsigned NOT NULL DEFAULT '0',
  `ChildItemLevelSelectorID` smallint unsigned NOT NULL DEFAULT '0',
  `ParentItemBonusTreeID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_bonus_tree_node`
--

LOCK TABLES `item_bonus_tree_node` WRITE;
/*!40000 ALTER TABLE `item_bonus_tree_node` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_bonus_tree_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_child_equipment`
--

DROP TABLE IF EXISTS `item_child_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_child_equipment` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ParentItemID` int NOT NULL DEFAULT '0',
  `ChildItemID` int NOT NULL DEFAULT '0',
  `ChildItemEquipSlot` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_child_equipment`
--

LOCK TABLES `item_child_equipment` WRITE;
/*!40000 ALTER TABLE `item_child_equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_child_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_class`
--

DROP TABLE IF EXISTS `item_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_class` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ClassName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ClassID` tinyint NOT NULL DEFAULT '0',
  `PriceModifier` float NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_class`
--

LOCK TABLES `item_class` WRITE;
/*!40000 ALTER TABLE `item_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_class_locale`
--

DROP TABLE IF EXISTS `item_class_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_class_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ClassName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_class_locale`
--

LOCK TABLES `item_class_locale` WRITE;
/*!40000 ALTER TABLE `item_class_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_class_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_currency_cost`
--

DROP TABLE IF EXISTS `item_currency_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_currency_cost` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_currency_cost`
--

LOCK TABLES `item_currency_cost` WRITE;
/*!40000 ALTER TABLE `item_currency_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_currency_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_damage_ammo`
--

DROP TABLE IF EXISTS `item_damage_ammo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_damage_ammo` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `Quality1` float NOT NULL DEFAULT '0',
  `Quality2` float NOT NULL DEFAULT '0',
  `Quality3` float NOT NULL DEFAULT '0',
  `Quality4` float NOT NULL DEFAULT '0',
  `Quality5` float NOT NULL DEFAULT '0',
  `Quality6` float NOT NULL DEFAULT '0',
  `Quality7` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_damage_ammo`
--

LOCK TABLES `item_damage_ammo` WRITE;
/*!40000 ALTER TABLE `item_damage_ammo` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_damage_ammo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_damage_one_hand`
--

DROP TABLE IF EXISTS `item_damage_one_hand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_damage_one_hand` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `Quality1` float NOT NULL DEFAULT '0',
  `Quality2` float NOT NULL DEFAULT '0',
  `Quality3` float NOT NULL DEFAULT '0',
  `Quality4` float NOT NULL DEFAULT '0',
  `Quality5` float NOT NULL DEFAULT '0',
  `Quality6` float NOT NULL DEFAULT '0',
  `Quality7` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_damage_one_hand`
--

LOCK TABLES `item_damage_one_hand` WRITE;
/*!40000 ALTER TABLE `item_damage_one_hand` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_damage_one_hand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_damage_one_hand_caster`
--

DROP TABLE IF EXISTS `item_damage_one_hand_caster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_damage_one_hand_caster` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `Quality1` float NOT NULL DEFAULT '0',
  `Quality2` float NOT NULL DEFAULT '0',
  `Quality3` float NOT NULL DEFAULT '0',
  `Quality4` float NOT NULL DEFAULT '0',
  `Quality5` float NOT NULL DEFAULT '0',
  `Quality6` float NOT NULL DEFAULT '0',
  `Quality7` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_damage_one_hand_caster`
--

LOCK TABLES `item_damage_one_hand_caster` WRITE;
/*!40000 ALTER TABLE `item_damage_one_hand_caster` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_damage_one_hand_caster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_damage_two_hand`
--

DROP TABLE IF EXISTS `item_damage_two_hand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_damage_two_hand` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `Quality1` float NOT NULL DEFAULT '0',
  `Quality2` float NOT NULL DEFAULT '0',
  `Quality3` float NOT NULL DEFAULT '0',
  `Quality4` float NOT NULL DEFAULT '0',
  `Quality5` float NOT NULL DEFAULT '0',
  `Quality6` float NOT NULL DEFAULT '0',
  `Quality7` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_damage_two_hand`
--

LOCK TABLES `item_damage_two_hand` WRITE;
/*!40000 ALTER TABLE `item_damage_two_hand` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_damage_two_hand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_damage_two_hand_caster`
--

DROP TABLE IF EXISTS `item_damage_two_hand_caster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_damage_two_hand_caster` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `Quality1` float NOT NULL DEFAULT '0',
  `Quality2` float NOT NULL DEFAULT '0',
  `Quality3` float NOT NULL DEFAULT '0',
  `Quality4` float NOT NULL DEFAULT '0',
  `Quality5` float NOT NULL DEFAULT '0',
  `Quality6` float NOT NULL DEFAULT '0',
  `Quality7` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_damage_two_hand_caster`
--

LOCK TABLES `item_damage_two_hand_caster` WRITE;
/*!40000 ALTER TABLE `item_damage_two_hand_caster` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_damage_two_hand_caster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_disenchant_loot`
--

DROP TABLE IF EXISTS `item_disenchant_loot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_disenchant_loot` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Subclass` tinyint NOT NULL DEFAULT '0',
  `Quality` tinyint unsigned NOT NULL DEFAULT '0',
  `MinLevel` smallint unsigned NOT NULL DEFAULT '0',
  `MaxLevel` smallint unsigned NOT NULL DEFAULT '0',
  `SkillRequired` smallint unsigned NOT NULL DEFAULT '0',
  `ExpansionID` tinyint NOT NULL DEFAULT '0',
  `Class` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_disenchant_loot`
--

LOCK TABLES `item_disenchant_loot` WRITE;
/*!40000 ALTER TABLE `item_disenchant_loot` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_disenchant_loot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_effect`
--

DROP TABLE IF EXISTS `item_effect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_effect` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `LegacySlotIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `TriggerType` tinyint NOT NULL DEFAULT '0',
  `Charges` smallint NOT NULL DEFAULT '0',
  `CoolDownMSec` int NOT NULL DEFAULT '0',
  `CategoryCoolDownMSec` int NOT NULL DEFAULT '0',
  `SpellCategoryID` smallint unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `ChrSpecializationID` smallint unsigned NOT NULL DEFAULT '0',
  `ParentItemID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_effect`
--

LOCK TABLES `item_effect` WRITE;
/*!40000 ALTER TABLE `item_effect` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_effect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_extended_cost`
--

DROP TABLE IF EXISTS `item_extended_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_extended_cost` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `RequiredArenaRating` smallint unsigned NOT NULL DEFAULT '0',
  `ArenaBracket` tinyint NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `MinFactionID` tinyint unsigned NOT NULL DEFAULT '0',
  `MinReputation` tinyint unsigned NOT NULL DEFAULT '0',
  `RequiredAchievement` tinyint unsigned NOT NULL DEFAULT '0',
  `ItemID1` int NOT NULL DEFAULT '0',
  `ItemID2` int NOT NULL DEFAULT '0',
  `ItemID3` int NOT NULL DEFAULT '0',
  `ItemID4` int NOT NULL DEFAULT '0',
  `ItemID5` int NOT NULL DEFAULT '0',
  `ItemCount1` smallint unsigned NOT NULL DEFAULT '0',
  `ItemCount2` smallint unsigned NOT NULL DEFAULT '0',
  `ItemCount3` smallint unsigned NOT NULL DEFAULT '0',
  `ItemCount4` smallint unsigned NOT NULL DEFAULT '0',
  `ItemCount5` smallint unsigned NOT NULL DEFAULT '0',
  `CurrencyID1` smallint unsigned NOT NULL DEFAULT '0',
  `CurrencyID2` smallint unsigned NOT NULL DEFAULT '0',
  `CurrencyID3` smallint unsigned NOT NULL DEFAULT '0',
  `CurrencyID4` smallint unsigned NOT NULL DEFAULT '0',
  `CurrencyID5` smallint unsigned NOT NULL DEFAULT '0',
  `CurrencyCount1` int unsigned NOT NULL DEFAULT '0',
  `CurrencyCount2` int unsigned NOT NULL DEFAULT '0',
  `CurrencyCount3` int unsigned NOT NULL DEFAULT '0',
  `CurrencyCount4` int unsigned NOT NULL DEFAULT '0',
  `CurrencyCount5` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_extended_cost`
--

LOCK TABLES `item_extended_cost` WRITE;
/*!40000 ALTER TABLE `item_extended_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_extended_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_level_selector`
--

DROP TABLE IF EXISTS `item_level_selector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_level_selector` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `MinItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `ItemLevelSelectorQualitySetID` smallint unsigned NOT NULL DEFAULT '0',
  `AzeriteUnlockMappingSet` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_level_selector`
--

LOCK TABLES `item_level_selector` WRITE;
/*!40000 ALTER TABLE `item_level_selector` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_level_selector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_level_selector_quality`
--

DROP TABLE IF EXISTS `item_level_selector_quality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_level_selector_quality` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `QualityItemBonusListID` int NOT NULL DEFAULT '0',
  `Quality` tinyint NOT NULL DEFAULT '0',
  `ParentILSQualitySetID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_level_selector_quality`
--

LOCK TABLES `item_level_selector_quality` WRITE;
/*!40000 ALTER TABLE `item_level_selector_quality` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_level_selector_quality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_level_selector_quality_set`
--

DROP TABLE IF EXISTS `item_level_selector_quality_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_level_selector_quality_set` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `IlvlRare` smallint NOT NULL DEFAULT '0',
  `IlvlEpic` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_level_selector_quality_set`
--

LOCK TABLES `item_level_selector_quality_set` WRITE;
/*!40000 ALTER TABLE `item_level_selector_quality_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_level_selector_quality_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_limit_category`
--

DROP TABLE IF EXISTS `item_limit_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_limit_category` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Quantity` tinyint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_limit_category`
--

LOCK TABLES `item_limit_category` WRITE;
/*!40000 ALTER TABLE `item_limit_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_limit_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_limit_category_condition`
--

DROP TABLE IF EXISTS `item_limit_category_condition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_limit_category_condition` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `AddQuantity` tinyint NOT NULL DEFAULT '0',
  `PlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `ParentItemLimitCategoryID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_limit_category_condition`
--

LOCK TABLES `item_limit_category_condition` WRITE;
/*!40000 ALTER TABLE `item_limit_category_condition` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_limit_category_condition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_limit_category_locale`
--

DROP TABLE IF EXISTS `item_limit_category_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_limit_category_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_limit_category_locale`
--

LOCK TABLES `item_limit_category_locale` WRITE;
/*!40000 ALTER TABLE `item_limit_category_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_limit_category_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_modified_appearance`
--

DROP TABLE IF EXISTS `item_modified_appearance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_modified_appearance` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemID` int NOT NULL DEFAULT '0',
  `ItemAppearanceModifierID` tinyint unsigned NOT NULL DEFAULT '0',
  `ItemAppearanceID` smallint unsigned NOT NULL DEFAULT '0',
  `OrderIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `TransmogSourceTypeEnum` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_modified_appearance`
--

LOCK TABLES `item_modified_appearance` WRITE;
/*!40000 ALTER TABLE `item_modified_appearance` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_modified_appearance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_name_description`
--

DROP TABLE IF EXISTS `item_name_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_name_description` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Color` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_name_description`
--

LOCK TABLES `item_name_description` WRITE;
/*!40000 ALTER TABLE `item_name_description` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_name_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_name_description_locale`
--

DROP TABLE IF EXISTS `item_name_description_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_name_description_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_name_description_locale`
--

LOCK TABLES `item_name_description_locale` WRITE;
/*!40000 ALTER TABLE `item_name_description_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_name_description_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_price_base`
--

DROP TABLE IF EXISTS `item_price_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_price_base` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `Armor` float NOT NULL DEFAULT '0',
  `Weapon` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_price_base`
--

LOCK TABLES `item_price_base` WRITE;
/*!40000 ALTER TABLE `item_price_base` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_price_base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_search_name`
--

DROP TABLE IF EXISTS `item_search_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_search_name` (
  `AllowableRace` bigint NOT NULL DEFAULT '0',
  `Display` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `OverallQualityID` tinyint unsigned NOT NULL DEFAULT '0',
  `ExpansionID` tinyint unsigned NOT NULL DEFAULT '0',
  `MinFactionID` smallint unsigned NOT NULL DEFAULT '0',
  `MinReputation` tinyint unsigned NOT NULL DEFAULT '0',
  `AllowableClass` int NOT NULL DEFAULT '0',
  `RequiredLevel` tinyint NOT NULL DEFAULT '0',
  `RequiredSkill` smallint unsigned NOT NULL DEFAULT '0',
  `RequiredSkillRank` smallint unsigned NOT NULL DEFAULT '0',
  `RequiredAbility` int unsigned NOT NULL DEFAULT '0',
  `ItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `Flags1` int NOT NULL DEFAULT '0',
  `Flags2` int NOT NULL DEFAULT '0',
  `Flags3` int NOT NULL DEFAULT '0',
  `Flags4` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_search_name`
--

LOCK TABLES `item_search_name` WRITE;
/*!40000 ALTER TABLE `item_search_name` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_search_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_search_name_locale`
--

DROP TABLE IF EXISTS `item_search_name_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_search_name_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Display_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_search_name_locale`
--

LOCK TABLES `item_search_name_locale` WRITE;
/*!40000 ALTER TABLE `item_search_name_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_search_name_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_set`
--

DROP TABLE IF EXISTS `item_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_set` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `SetFlags` int unsigned NOT NULL DEFAULT '0',
  `RequiredSkill` int unsigned NOT NULL DEFAULT '0',
  `RequiredSkillRank` smallint unsigned NOT NULL DEFAULT '0',
  `ItemID1` int unsigned NOT NULL DEFAULT '0',
  `ItemID2` int unsigned NOT NULL DEFAULT '0',
  `ItemID3` int unsigned NOT NULL DEFAULT '0',
  `ItemID4` int unsigned NOT NULL DEFAULT '0',
  `ItemID5` int unsigned NOT NULL DEFAULT '0',
  `ItemID6` int unsigned NOT NULL DEFAULT '0',
  `ItemID7` int unsigned NOT NULL DEFAULT '0',
  `ItemID8` int unsigned NOT NULL DEFAULT '0',
  `ItemID9` int unsigned NOT NULL DEFAULT '0',
  `ItemID10` int unsigned NOT NULL DEFAULT '0',
  `ItemID11` int unsigned NOT NULL DEFAULT '0',
  `ItemID12` int unsigned NOT NULL DEFAULT '0',
  `ItemID13` int unsigned NOT NULL DEFAULT '0',
  `ItemID14` int unsigned NOT NULL DEFAULT '0',
  `ItemID15` int unsigned NOT NULL DEFAULT '0',
  `ItemID16` int unsigned NOT NULL DEFAULT '0',
  `ItemID17` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_set`
--

LOCK TABLES `item_set` WRITE;
/*!40000 ALTER TABLE `item_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_set_locale`
--

DROP TABLE IF EXISTS `item_set_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_set_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_set_locale`
--

LOCK TABLES `item_set_locale` WRITE;
/*!40000 ALTER TABLE `item_set_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_set_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_set_spell`
--

DROP TABLE IF EXISTS `item_set_spell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_set_spell` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ChrSpecID` smallint unsigned NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `Threshold` tinyint unsigned NOT NULL DEFAULT '0',
  `ItemSetID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_set_spell`
--

LOCK TABLES `item_set_spell` WRITE;
/*!40000 ALTER TABLE `item_set_spell` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_set_spell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_sparse`
--

DROP TABLE IF EXISTS `item_sparse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_sparse` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `AllowableRace` bigint NOT NULL DEFAULT '0',
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Display3` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Display2` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Display1` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Display` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `DmgVariance` float NOT NULL DEFAULT '0',
  `DurationInInventory` int unsigned NOT NULL DEFAULT '0',
  `QualityModifier` float NOT NULL DEFAULT '0',
  `BagFamily` int unsigned NOT NULL DEFAULT '0',
  `ItemRange` float NOT NULL DEFAULT '0',
  `StatPercentageOfSocket1` float NOT NULL DEFAULT '0',
  `StatPercentageOfSocket2` float NOT NULL DEFAULT '0',
  `StatPercentageOfSocket3` float NOT NULL DEFAULT '0',
  `StatPercentageOfSocket4` float NOT NULL DEFAULT '0',
  `StatPercentageOfSocket5` float NOT NULL DEFAULT '0',
  `StatPercentageOfSocket6` float NOT NULL DEFAULT '0',
  `StatPercentageOfSocket7` float NOT NULL DEFAULT '0',
  `StatPercentageOfSocket8` float NOT NULL DEFAULT '0',
  `StatPercentageOfSocket9` float NOT NULL DEFAULT '0',
  `StatPercentageOfSocket10` float NOT NULL DEFAULT '0',
  `StatPercentEditor1` int NOT NULL DEFAULT '0',
  `StatPercentEditor2` int NOT NULL DEFAULT '0',
  `StatPercentEditor3` int NOT NULL DEFAULT '0',
  `StatPercentEditor4` int NOT NULL DEFAULT '0',
  `StatPercentEditor5` int NOT NULL DEFAULT '0',
  `StatPercentEditor6` int NOT NULL DEFAULT '0',
  `StatPercentEditor7` int NOT NULL DEFAULT '0',
  `StatPercentEditor8` int NOT NULL DEFAULT '0',
  `StatPercentEditor9` int NOT NULL DEFAULT '0',
  `StatPercentEditor10` int NOT NULL DEFAULT '0',
  `Stackable` int NOT NULL DEFAULT '0',
  `MaxCount` int NOT NULL DEFAULT '0',
  `RequiredAbility` int unsigned NOT NULL DEFAULT '0',
  `SellPrice` int unsigned NOT NULL DEFAULT '0',
  `BuyPrice` int unsigned NOT NULL DEFAULT '0',
  `VendorStackCount` int unsigned NOT NULL DEFAULT '0',
  `PriceVariance` float NOT NULL DEFAULT '0',
  `PriceRandomValue` float NOT NULL DEFAULT '0',
  `Flags1` int NOT NULL DEFAULT '0',
  `Flags2` int NOT NULL DEFAULT '0',
  `Flags3` int NOT NULL DEFAULT '0',
  `Flags4` int NOT NULL DEFAULT '0',
  `FactionRelated` int NOT NULL DEFAULT '0',
  `ModifiedCraftingReagentItemID` int NOT NULL DEFAULT '0',
  `ContentTuningID` int NOT NULL DEFAULT '0',
  `PlayerLevelToItemLevelCurveID` int NOT NULL DEFAULT '0',
  `ItemNameDescriptionID` smallint unsigned NOT NULL DEFAULT '0',
  `RequiredTransmogHoliday` smallint unsigned NOT NULL DEFAULT '0',
  `RequiredHoliday` smallint unsigned NOT NULL DEFAULT '0',
  `LimitCategory` smallint unsigned NOT NULL DEFAULT '0',
  `GemProperties` smallint unsigned NOT NULL DEFAULT '0',
  `SocketMatchEnchantmentId` smallint unsigned NOT NULL DEFAULT '0',
  `TotemCategoryID` smallint unsigned NOT NULL DEFAULT '0',
  `InstanceBound` smallint unsigned NOT NULL DEFAULT '0',
  `ZoneBound1` smallint unsigned NOT NULL DEFAULT '0',
  `ZoneBound2` smallint unsigned NOT NULL DEFAULT '0',
  `ItemSet` smallint unsigned NOT NULL DEFAULT '0',
  `LockID` smallint unsigned NOT NULL DEFAULT '0',
  `StartQuestID` smallint unsigned NOT NULL DEFAULT '0',
  `PageID` smallint unsigned NOT NULL DEFAULT '0',
  `ItemDelay` smallint unsigned NOT NULL DEFAULT '0',
  `MinFactionID` smallint unsigned NOT NULL DEFAULT '0',
  `RequiredSkillRank` smallint unsigned NOT NULL DEFAULT '0',
  `RequiredSkill` smallint unsigned NOT NULL DEFAULT '0',
  `ItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `AllowableClass` smallint NOT NULL DEFAULT '0',
  `ExpansionID` tinyint unsigned NOT NULL DEFAULT '0',
  `ArtifactID` tinyint unsigned NOT NULL DEFAULT '0',
  `SpellWeight` tinyint unsigned NOT NULL DEFAULT '0',
  `SpellWeightCategory` tinyint unsigned NOT NULL DEFAULT '0',
  `SocketType1` tinyint unsigned NOT NULL DEFAULT '0',
  `SocketType2` tinyint unsigned NOT NULL DEFAULT '0',
  `SocketType3` tinyint unsigned NOT NULL DEFAULT '0',
  `SheatheType` tinyint unsigned NOT NULL DEFAULT '0',
  `Material` tinyint unsigned NOT NULL DEFAULT '0',
  `PageMaterialID` tinyint unsigned NOT NULL DEFAULT '0',
  `LanguageID` tinyint unsigned NOT NULL DEFAULT '0',
  `Bonding` tinyint unsigned NOT NULL DEFAULT '0',
  `DamageDamageType` tinyint unsigned NOT NULL DEFAULT '0',
  `StatModifierBonusStat1` tinyint NOT NULL DEFAULT '0',
  `StatModifierBonusStat2` tinyint NOT NULL DEFAULT '0',
  `StatModifierBonusStat3` tinyint NOT NULL DEFAULT '0',
  `StatModifierBonusStat4` tinyint NOT NULL DEFAULT '0',
  `StatModifierBonusStat5` tinyint NOT NULL DEFAULT '0',
  `StatModifierBonusStat6` tinyint NOT NULL DEFAULT '0',
  `StatModifierBonusStat7` tinyint NOT NULL DEFAULT '0',
  `StatModifierBonusStat8` tinyint NOT NULL DEFAULT '0',
  `StatModifierBonusStat9` tinyint NOT NULL DEFAULT '0',
  `StatModifierBonusStat10` tinyint NOT NULL DEFAULT '0',
  `ContainerSlots` tinyint unsigned NOT NULL DEFAULT '0',
  `MinReputation` tinyint unsigned NOT NULL DEFAULT '0',
  `RequiredPVPMedal` tinyint unsigned NOT NULL DEFAULT '0',
  `RequiredPVPRank` tinyint unsigned NOT NULL DEFAULT '0',
  `RequiredLevel` tinyint NOT NULL DEFAULT '0',
  `InventoryType` tinyint unsigned NOT NULL DEFAULT '0',
  `OverallQualityID` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_sparse`
--

LOCK TABLES `item_sparse` WRITE;
/*!40000 ALTER TABLE `item_sparse` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_sparse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_sparse_locale`
--

DROP TABLE IF EXISTS `item_sparse_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_sparse_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Display3_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Display2_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Display1_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Display_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_sparse_locale`
--

LOCK TABLES `item_sparse_locale` WRITE;
/*!40000 ALTER TABLE `item_sparse_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_sparse_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_spec`
--

DROP TABLE IF EXISTS `item_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_spec` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `MinLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `ItemType` tinyint unsigned NOT NULL DEFAULT '0',
  `PrimaryStat` tinyint unsigned NOT NULL DEFAULT '0',
  `SecondaryStat` tinyint unsigned NOT NULL DEFAULT '0',
  `SpecializationID` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_spec`
--

LOCK TABLES `item_spec` WRITE;
/*!40000 ALTER TABLE `item_spec` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_spec_override`
--

DROP TABLE IF EXISTS `item_spec_override`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_spec_override` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpecID` smallint unsigned NOT NULL DEFAULT '0',
  `ItemID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_spec_override`
--

LOCK TABLES `item_spec_override` WRITE;
/*!40000 ALTER TABLE `item_spec_override` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_spec_override` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_x_bonus_tree`
--

DROP TABLE IF EXISTS `item_x_bonus_tree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_x_bonus_tree` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemBonusTreeID` smallint unsigned NOT NULL DEFAULT '0',
  `ItemID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_x_bonus_tree`
--

LOCK TABLES `item_x_bonus_tree` WRITE;
/*!40000 ALTER TABLE `item_x_bonus_tree` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_x_bonus_tree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keychain`
--

DROP TABLE IF EXISTS `keychain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `keychain` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Key1` tinyint unsigned NOT NULL DEFAULT '0',
  `Key2` tinyint unsigned NOT NULL DEFAULT '0',
  `Key3` tinyint unsigned NOT NULL DEFAULT '0',
  `Key4` tinyint unsigned NOT NULL DEFAULT '0',
  `Key5` tinyint unsigned NOT NULL DEFAULT '0',
  `Key6` tinyint unsigned NOT NULL DEFAULT '0',
  `Key7` tinyint unsigned NOT NULL DEFAULT '0',
  `Key8` tinyint unsigned NOT NULL DEFAULT '0',
  `Key9` tinyint unsigned NOT NULL DEFAULT '0',
  `Key10` tinyint unsigned NOT NULL DEFAULT '0',
  `Key11` tinyint unsigned NOT NULL DEFAULT '0',
  `Key12` tinyint unsigned NOT NULL DEFAULT '0',
  `Key13` tinyint unsigned NOT NULL DEFAULT '0',
  `Key14` tinyint unsigned NOT NULL DEFAULT '0',
  `Key15` tinyint unsigned NOT NULL DEFAULT '0',
  `Key16` tinyint unsigned NOT NULL DEFAULT '0',
  `Key17` tinyint unsigned NOT NULL DEFAULT '0',
  `Key18` tinyint unsigned NOT NULL DEFAULT '0',
  `Key19` tinyint unsigned NOT NULL DEFAULT '0',
  `Key20` tinyint unsigned NOT NULL DEFAULT '0',
  `Key21` tinyint unsigned NOT NULL DEFAULT '0',
  `Key22` tinyint unsigned NOT NULL DEFAULT '0',
  `Key23` tinyint unsigned NOT NULL DEFAULT '0',
  `Key24` tinyint unsigned NOT NULL DEFAULT '0',
  `Key25` tinyint unsigned NOT NULL DEFAULT '0',
  `Key26` tinyint unsigned NOT NULL DEFAULT '0',
  `Key27` tinyint unsigned NOT NULL DEFAULT '0',
  `Key28` tinyint unsigned NOT NULL DEFAULT '0',
  `Key29` tinyint unsigned NOT NULL DEFAULT '0',
  `Key30` tinyint unsigned NOT NULL DEFAULT '0',
  `Key31` tinyint unsigned NOT NULL DEFAULT '0',
  `Key32` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keychain`
--

LOCK TABLES `keychain` WRITE;
/*!40000 ALTER TABLE `keychain` DISABLE KEYS */;
/*!40000 ALTER TABLE `keychain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lfg_dungeons`
--

DROP TABLE IF EXISTS `lfg_dungeons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lfg_dungeons` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `TypeID` tinyint unsigned NOT NULL DEFAULT '0',
  `Subtype` tinyint unsigned NOT NULL DEFAULT '0',
  `Faction` tinyint NOT NULL DEFAULT '0',
  `IconTextureFileID` int NOT NULL DEFAULT '0',
  `RewardsBgTextureFileID` int NOT NULL DEFAULT '0',
  `PopupBgTextureFileID` int NOT NULL DEFAULT '0',
  `ExpansionLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `MapID` smallint NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `MinGear` float NOT NULL DEFAULT '0',
  `GroupID` tinyint unsigned NOT NULL DEFAULT '0',
  `OrderIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `RequiredPlayerConditionId` int unsigned NOT NULL DEFAULT '0',
  `RandomID` smallint unsigned NOT NULL DEFAULT '0',
  `ScenarioID` smallint unsigned NOT NULL DEFAULT '0',
  `FinalEncounterID` smallint unsigned NOT NULL DEFAULT '0',
  `CountTank` tinyint unsigned NOT NULL DEFAULT '0',
  `CountHealer` tinyint unsigned NOT NULL DEFAULT '0',
  `CountDamage` tinyint unsigned NOT NULL DEFAULT '0',
  `MinCountTank` tinyint unsigned NOT NULL DEFAULT '0',
  `MinCountHealer` tinyint unsigned NOT NULL DEFAULT '0',
  `MinCountDamage` tinyint unsigned NOT NULL DEFAULT '0',
  `BonusReputationAmount` smallint unsigned NOT NULL DEFAULT '0',
  `MentorItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `MentorCharLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `ContentTuningID` int NOT NULL DEFAULT '0',
  `Flags1` int NOT NULL DEFAULT '0',
  `Flags2` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lfg_dungeons`
--

LOCK TABLES `lfg_dungeons` WRITE;
/*!40000 ALTER TABLE `lfg_dungeons` DISABLE KEYS */;
/*!40000 ALTER TABLE `lfg_dungeons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lfg_dungeons_locale`
--

DROP TABLE IF EXISTS `lfg_dungeons_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lfg_dungeons_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lfg_dungeons_locale`
--

LOCK TABLES `lfg_dungeons_locale` WRITE;
/*!40000 ALTER TABLE `lfg_dungeons_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `lfg_dungeons_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `light`
--

DROP TABLE IF EXISTS `light`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `light` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `GameCoordsX` float NOT NULL DEFAULT '0',
  `GameCoordsY` float NOT NULL DEFAULT '0',
  `GameCoordsZ` float NOT NULL DEFAULT '0',
  `GameFalloffStart` float NOT NULL DEFAULT '0',
  `GameFalloffEnd` float NOT NULL DEFAULT '0',
  `ContinentID` smallint NOT NULL DEFAULT '0',
  `LightParamsID1` smallint unsigned NOT NULL DEFAULT '0',
  `LightParamsID2` smallint unsigned NOT NULL DEFAULT '0',
  `LightParamsID3` smallint unsigned NOT NULL DEFAULT '0',
  `LightParamsID4` smallint unsigned NOT NULL DEFAULT '0',
  `LightParamsID5` smallint unsigned NOT NULL DEFAULT '0',
  `LightParamsID6` smallint unsigned NOT NULL DEFAULT '0',
  `LightParamsID7` smallint unsigned NOT NULL DEFAULT '0',
  `LightParamsID8` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `light`
--

LOCK TABLES `light` WRITE;
/*!40000 ALTER TABLE `light` DISABLE KEYS */;
/*!40000 ALTER TABLE `light` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liquid_type`
--

DROP TABLE IF EXISTS `liquid_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `liquid_type` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Texture1` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Texture2` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Texture3` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Texture4` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Texture5` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Texture6` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `SoundBank` tinyint unsigned NOT NULL DEFAULT '0',
  `SoundID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `MaxDarkenDepth` float NOT NULL DEFAULT '0',
  `FogDarkenIntensity` float NOT NULL DEFAULT '0',
  `AmbDarkenIntensity` float NOT NULL DEFAULT '0',
  `DirDarkenIntensity` float NOT NULL DEFAULT '0',
  `LightID` smallint unsigned NOT NULL DEFAULT '0',
  `ParticleScale` float NOT NULL DEFAULT '0',
  `ParticleMovement` tinyint unsigned NOT NULL DEFAULT '0',
  `ParticleTexSlots` tinyint unsigned NOT NULL DEFAULT '0',
  `MaterialID` tinyint unsigned NOT NULL DEFAULT '0',
  `MinimapStaticCol` int NOT NULL DEFAULT '0',
  `FrameCountTexture1` tinyint unsigned NOT NULL DEFAULT '0',
  `FrameCountTexture2` tinyint unsigned NOT NULL DEFAULT '0',
  `FrameCountTexture3` tinyint unsigned NOT NULL DEFAULT '0',
  `FrameCountTexture4` tinyint unsigned NOT NULL DEFAULT '0',
  `FrameCountTexture5` tinyint unsigned NOT NULL DEFAULT '0',
  `FrameCountTexture6` tinyint unsigned NOT NULL DEFAULT '0',
  `Color1` int NOT NULL DEFAULT '0',
  `Color2` int NOT NULL DEFAULT '0',
  `Float1` float NOT NULL DEFAULT '0',
  `Float2` float NOT NULL DEFAULT '0',
  `Float3` float NOT NULL DEFAULT '0',
  `Float4` float NOT NULL DEFAULT '0',
  `Float5` float NOT NULL DEFAULT '0',
  `Float6` float NOT NULL DEFAULT '0',
  `Float7` float NOT NULL DEFAULT '0',
  `Float8` float NOT NULL DEFAULT '0',
  `Float9` float NOT NULL DEFAULT '0',
  `Float10` float NOT NULL DEFAULT '0',
  `Float11` float NOT NULL DEFAULT '0',
  `Float12` float NOT NULL DEFAULT '0',
  `Float13` float NOT NULL DEFAULT '0',
  `Float14` float NOT NULL DEFAULT '0',
  `Float15` float NOT NULL DEFAULT '0',
  `Float16` float NOT NULL DEFAULT '0',
  `Float17` float NOT NULL DEFAULT '0',
  `Float18` float NOT NULL DEFAULT '0',
  `Int1` int unsigned NOT NULL DEFAULT '0',
  `Int2` int unsigned NOT NULL DEFAULT '0',
  `Int3` int unsigned NOT NULL DEFAULT '0',
  `Int4` int unsigned NOT NULL DEFAULT '0',
  `Coefficient1` float NOT NULL DEFAULT '0',
  `Coefficient2` float NOT NULL DEFAULT '0',
  `Coefficient3` float NOT NULL DEFAULT '0',
  `Coefficient4` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liquid_type`
--

LOCK TABLES `liquid_type` WRITE;
/*!40000 ALTER TABLE `liquid_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `liquid_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lock`
--

DROP TABLE IF EXISTS `lock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lock` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `Index1` int NOT NULL DEFAULT '0',
  `Index2` int NOT NULL DEFAULT '0',
  `Index3` int NOT NULL DEFAULT '0',
  `Index4` int NOT NULL DEFAULT '0',
  `Index5` int NOT NULL DEFAULT '0',
  `Index6` int NOT NULL DEFAULT '0',
  `Index7` int NOT NULL DEFAULT '0',
  `Index8` int NOT NULL DEFAULT '0',
  `Skill1` smallint unsigned NOT NULL DEFAULT '0',
  `Skill2` smallint unsigned NOT NULL DEFAULT '0',
  `Skill3` smallint unsigned NOT NULL DEFAULT '0',
  `Skill4` smallint unsigned NOT NULL DEFAULT '0',
  `Skill5` smallint unsigned NOT NULL DEFAULT '0',
  `Skill6` smallint unsigned NOT NULL DEFAULT '0',
  `Skill7` smallint unsigned NOT NULL DEFAULT '0',
  `Skill8` smallint unsigned NOT NULL DEFAULT '0',
  `Type1` tinyint unsigned NOT NULL DEFAULT '0',
  `Type2` tinyint unsigned NOT NULL DEFAULT '0',
  `Type3` tinyint unsigned NOT NULL DEFAULT '0',
  `Type4` tinyint unsigned NOT NULL DEFAULT '0',
  `Type5` tinyint unsigned NOT NULL DEFAULT '0',
  `Type6` tinyint unsigned NOT NULL DEFAULT '0',
  `Type7` tinyint unsigned NOT NULL DEFAULT '0',
  `Type8` tinyint unsigned NOT NULL DEFAULT '0',
  `Action1` tinyint unsigned NOT NULL DEFAULT '0',
  `Action2` tinyint unsigned NOT NULL DEFAULT '0',
  `Action3` tinyint unsigned NOT NULL DEFAULT '0',
  `Action4` tinyint unsigned NOT NULL DEFAULT '0',
  `Action5` tinyint unsigned NOT NULL DEFAULT '0',
  `Action6` tinyint unsigned NOT NULL DEFAULT '0',
  `Action7` tinyint unsigned NOT NULL DEFAULT '0',
  `Action8` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lock`
--

LOCK TABLES `lock` WRITE;
/*!40000 ALTER TABLE `lock` DISABLE KEYS */;
/*!40000 ALTER TABLE `lock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mail_template`
--

DROP TABLE IF EXISTS `mail_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mail_template` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Body` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mail_template`
--

LOCK TABLES `mail_template` WRITE;
/*!40000 ALTER TABLE `mail_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `mail_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mail_template_locale`
--

DROP TABLE IF EXISTS `mail_template_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mail_template_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Body_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mail_template_locale`
--

LOCK TABLES `mail_template_locale` WRITE;
/*!40000 ALTER TABLE `mail_template_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `mail_template_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map`
--

DROP TABLE IF EXISTS `map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `map` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Directory` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `MapName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `InternalName` text COLLATE utf8mb4_unicode_ci,
  `MapDescription0` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `MapDescription1` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `PvpShortDescription` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `PvpLongDescription` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `CorpseX` float NOT NULL DEFAULT '0',
  `CorpseY` float NOT NULL DEFAULT '0',
  `MapType` tinyint unsigned NOT NULL DEFAULT '0',
  `InstanceType` tinyint NOT NULL DEFAULT '0',
  `ExpansionID` tinyint unsigned NOT NULL DEFAULT '0',
  `AreaTableID` smallint unsigned NOT NULL DEFAULT '0',
  `LoadingScreenID` smallint NOT NULL DEFAULT '0',
  `TimeOfDayOverride` smallint NOT NULL DEFAULT '0',
  `ParentMapID` smallint NOT NULL DEFAULT '0',
  `CosmeticParentMapID` smallint NOT NULL DEFAULT '0',
  `TimeOffset` tinyint unsigned NOT NULL DEFAULT '0',
  `MinimapIconScale` float NOT NULL DEFAULT '0',
  `CorpseMapID` smallint NOT NULL DEFAULT '0',
  `MaxPlayers` tinyint unsigned NOT NULL DEFAULT '0',
  `WindSettingsID` smallint NOT NULL DEFAULT '0',
  `ZmpFileDataID` int NOT NULL DEFAULT '0',
  `WdtFileDataID` int NOT NULL DEFAULT '0',
  `Flags1` int NOT NULL DEFAULT '0',
  `Flags2` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map`
--

LOCK TABLES `map` WRITE;
/*!40000 ALTER TABLE `map` DISABLE KEYS */;
/*!40000 ALTER TABLE `map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map_difficulty`
--

DROP TABLE IF EXISTS `map_difficulty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `map_difficulty` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `DifficultyID` int NOT NULL DEFAULT '0',
  `LockID` int NOT NULL DEFAULT '0',
  `ResetInterval` tinyint NOT NULL DEFAULT '0',
  `MaxPlayers` int NOT NULL DEFAULT '0',
  `ItemContext` int NOT NULL DEFAULT '0',
  `ItemContextPickerID` int NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `ContentTuningID` int NOT NULL DEFAULT '0',
  `MapID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map_difficulty`
--

LOCK TABLES `map_difficulty` WRITE;
/*!40000 ALTER TABLE `map_difficulty` DISABLE KEYS */;
/*!40000 ALTER TABLE `map_difficulty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map_difficulty_locale`
--

DROP TABLE IF EXISTS `map_difficulty_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `map_difficulty_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Message_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map_difficulty_locale`
--

LOCK TABLES `map_difficulty_locale` WRITE;
/*!40000 ALTER TABLE `map_difficulty_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `map_difficulty_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map_difficulty_x_condition`
--

DROP TABLE IF EXISTS `map_difficulty_x_condition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `map_difficulty_x_condition` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `FailureDescription` text COLLATE utf8mb4_unicode_ci,
  `PlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `OrderIndex` int NOT NULL DEFAULT '0',
  `MapDifficultyID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map_difficulty_x_condition`
--

LOCK TABLES `map_difficulty_x_condition` WRITE;
/*!40000 ALTER TABLE `map_difficulty_x_condition` DISABLE KEYS */;
/*!40000 ALTER TABLE `map_difficulty_x_condition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map_difficulty_x_condition_locale`
--

DROP TABLE IF EXISTS `map_difficulty_x_condition_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `map_difficulty_x_condition_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `FailureDescription_lang` text COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map_difficulty_x_condition_locale`
--

LOCK TABLES `map_difficulty_x_condition_locale` WRITE;
/*!40000 ALTER TABLE `map_difficulty_x_condition_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `map_difficulty_x_condition_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map_locale`
--

DROP TABLE IF EXISTS `map_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `map_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `MapName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `MapDescription0_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `MapDescription1_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `PvpShortDescription_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `PvpLongDescription_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map_locale`
--

LOCK TABLES `map_locale` WRITE;
/*!40000 ALTER TABLE `map_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `map_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modifier_tree`
--

DROP TABLE IF EXISTS `modifier_tree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modifier_tree` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Parent` int unsigned NOT NULL DEFAULT '0',
  `Operator` tinyint NOT NULL DEFAULT '0',
  `Amount` tinyint NOT NULL DEFAULT '0',
  `Type` int NOT NULL DEFAULT '0',
  `Asset` int NOT NULL DEFAULT '0',
  `SecondaryAsset` int NOT NULL DEFAULT '0',
  `TertiaryAsset` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modifier_tree`
--

LOCK TABLES `modifier_tree` WRITE;
/*!40000 ALTER TABLE `modifier_tree` DISABLE KEYS */;
/*!40000 ALTER TABLE `modifier_tree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mount`
--

DROP TABLE IF EXISTS `mount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mount` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `SourceText` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `MountTypeID` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `SourceTypeEnum` tinyint NOT NULL DEFAULT '0',
  `SourceSpellID` int NOT NULL DEFAULT '0',
  `PlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `MountFlyRideHeight` float NOT NULL DEFAULT '0',
  `UiModelSceneID` int NOT NULL DEFAULT '0',
  `MountSpecialRiderAnimKitID` int NOT NULL DEFAULT '0',
  `MountSpecialSpellVisualKitID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mount`
--

LOCK TABLES `mount` WRITE;
/*!40000 ALTER TABLE `mount` DISABLE KEYS */;
/*!40000 ALTER TABLE `mount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mount_capability`
--

DROP TABLE IF EXISTS `mount_capability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mount_capability` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `ReqRidingSkill` smallint unsigned NOT NULL DEFAULT '0',
  `ReqAreaID` smallint unsigned NOT NULL DEFAULT '0',
  `ReqSpellAuraID` int unsigned NOT NULL DEFAULT '0',
  `ReqSpellKnownID` int NOT NULL DEFAULT '0',
  `ModSpellAuraID` int NOT NULL DEFAULT '0',
  `ReqMapID` smallint NOT NULL DEFAULT '0',
  `PlayerConditionID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mount_capability`
--

LOCK TABLES `mount_capability` WRITE;
/*!40000 ALTER TABLE `mount_capability` DISABLE KEYS */;
/*!40000 ALTER TABLE `mount_capability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mount_locale`
--

DROP TABLE IF EXISTS `mount_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mount_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `SourceText_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mount_locale`
--

LOCK TABLES `mount_locale` WRITE;
/*!40000 ALTER TABLE `mount_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `mount_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mount_type_x_capability`
--

DROP TABLE IF EXISTS `mount_type_x_capability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mount_type_x_capability` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `MountTypeID` smallint unsigned NOT NULL DEFAULT '0',
  `MountCapabilityID` smallint unsigned NOT NULL DEFAULT '0',
  `OrderIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mount_type_x_capability`
--

LOCK TABLES `mount_type_x_capability` WRITE;
/*!40000 ALTER TABLE `mount_type_x_capability` DISABLE KEYS */;
/*!40000 ALTER TABLE `mount_type_x_capability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mount_x_display`
--

DROP TABLE IF EXISTS `mount_x_display`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mount_x_display` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `CreatureDisplayInfoID` int NOT NULL DEFAULT '0',
  `PlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `MountID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mount_x_display`
--

LOCK TABLES `mount_x_display` WRITE;
/*!40000 ALTER TABLE `mount_x_display` DISABLE KEYS */;
/*!40000 ALTER TABLE `mount_x_display` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Volume` tinyint unsigned NOT NULL DEFAULT '0',
  `KeyID` tinyint unsigned NOT NULL DEFAULT '0',
  `AudioFileDataID` int unsigned NOT NULL DEFAULT '0',
  `SubtitleFileDataID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `name_gen`
--

DROP TABLE IF EXISTS `name_gen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `name_gen` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `RaceID` tinyint unsigned NOT NULL DEFAULT '0',
  `Sex` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `name_gen`
--

LOCK TABLES `name_gen` WRITE;
/*!40000 ALTER TABLE `name_gen` DISABLE KEYS */;
/*!40000 ALTER TABLE `name_gen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `names_profanity`
--

DROP TABLE IF EXISTS `names_profanity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `names_profanity` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Language` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `names_profanity`
--

LOCK TABLES `names_profanity` WRITE;
/*!40000 ALTER TABLE `names_profanity` DISABLE KEYS */;
/*!40000 ALTER TABLE `names_profanity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `names_reserved`
--

DROP TABLE IF EXISTS `names_reserved`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `names_reserved` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `names_reserved`
--

LOCK TABLES `names_reserved` WRITE;
/*!40000 ALTER TABLE `names_reserved` DISABLE KEYS */;
/*!40000 ALTER TABLE `names_reserved` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `names_reserved_locale`
--

DROP TABLE IF EXISTS `names_reserved_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `names_reserved_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `LocaleMask` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `names_reserved_locale`
--

LOCK TABLES `names_reserved_locale` WRITE;
/*!40000 ALTER TABLE `names_reserved_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `names_reserved_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `num_talents_at_level`
--

DROP TABLE IF EXISTS `num_talents_at_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `num_talents_at_level` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `NumTalents` int NOT NULL DEFAULT '0',
  `NumTalentsDeathKnight` int NOT NULL DEFAULT '0',
  `NumTalentsDemonHunter` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `num_talents_at_level`
--

LOCK TABLES `num_talents_at_level` WRITE;
/*!40000 ALTER TABLE `num_talents_at_level` DISABLE KEYS */;
/*!40000 ALTER TABLE `num_talents_at_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `override_spell_data`
--

DROP TABLE IF EXISTS `override_spell_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `override_spell_data` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Spells1` int NOT NULL DEFAULT '0',
  `Spells2` int NOT NULL DEFAULT '0',
  `Spells3` int NOT NULL DEFAULT '0',
  `Spells4` int NOT NULL DEFAULT '0',
  `Spells5` int NOT NULL DEFAULT '0',
  `Spells6` int NOT NULL DEFAULT '0',
  `Spells7` int NOT NULL DEFAULT '0',
  `Spells8` int NOT NULL DEFAULT '0',
  `Spells9` int NOT NULL DEFAULT '0',
  `Spells10` int NOT NULL DEFAULT '0',
  `PlayerActionBarFileDataID` int NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `override_spell_data`
--

LOCK TABLES `override_spell_data` WRITE;
/*!40000 ALTER TABLE `override_spell_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `override_spell_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phase`
--

DROP TABLE IF EXISTS `phase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phase` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phase`
--

LOCK TABLES `phase` WRITE;
/*!40000 ALTER TABLE `phase` DISABLE KEYS */;
/*!40000 ALTER TABLE `phase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phase_x_phase_group`
--

DROP TABLE IF EXISTS `phase_x_phase_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phase_x_phase_group` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PhaseID` smallint unsigned NOT NULL DEFAULT '0',
  `PhaseGroupID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phase_x_phase_group`
--

LOCK TABLES `phase_x_phase_group` WRITE;
/*!40000 ALTER TABLE `phase_x_phase_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `phase_x_phase_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_condition`
--

DROP TABLE IF EXISTS `player_condition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player_condition` (
  `RaceMask` bigint NOT NULL DEFAULT '0',
  `FailureDescription` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ClassMask` int NOT NULL DEFAULT '0',
  `SkillLogic` int unsigned NOT NULL DEFAULT '0',
  `LanguageID` int NOT NULL DEFAULT '0',
  `MinLanguage` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxLanguage` int NOT NULL DEFAULT '0',
  `MaxFactionID` smallint unsigned NOT NULL DEFAULT '0',
  `MaxReputation` tinyint unsigned NOT NULL DEFAULT '0',
  `ReputationLogic` int unsigned NOT NULL DEFAULT '0',
  `CurrentPvpFaction` tinyint NOT NULL DEFAULT '0',
  `PvpMedal` tinyint unsigned NOT NULL DEFAULT '0',
  `PrevQuestLogic` int unsigned NOT NULL DEFAULT '0',
  `CurrQuestLogic` int unsigned NOT NULL DEFAULT '0',
  `CurrentCompletedQuestLogic` int unsigned NOT NULL DEFAULT '0',
  `SpellLogic` int unsigned NOT NULL DEFAULT '0',
  `ItemLogic` int unsigned NOT NULL DEFAULT '0',
  `ItemFlags` tinyint unsigned NOT NULL DEFAULT '0',
  `AuraSpellLogic` int unsigned NOT NULL DEFAULT '0',
  `WorldStateExpressionID` smallint unsigned NOT NULL DEFAULT '0',
  `WeatherID` int NOT NULL DEFAULT '0',
  `PartyStatus` tinyint unsigned NOT NULL DEFAULT '0',
  `LifetimeMaxPVPRank` tinyint unsigned NOT NULL DEFAULT '0',
  `AchievementLogic` int unsigned NOT NULL DEFAULT '0',
  `Gender` tinyint NOT NULL DEFAULT '0',
  `NativeGender` tinyint NOT NULL DEFAULT '0',
  `AreaLogic` int unsigned NOT NULL DEFAULT '0',
  `LfgLogic` int unsigned NOT NULL DEFAULT '0',
  `CurrencyLogic` int unsigned NOT NULL DEFAULT '0',
  `QuestKillID` int NOT NULL DEFAULT '0',
  `QuestKillLogic` int unsigned NOT NULL DEFAULT '0',
  `MinExpansionLevel` tinyint NOT NULL DEFAULT '0',
  `MaxExpansionLevel` tinyint NOT NULL DEFAULT '0',
  `MinAvgItemLevel` int NOT NULL DEFAULT '0',
  `MaxAvgItemLevel` int NOT NULL DEFAULT '0',
  `MinAvgEquippedItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `MaxAvgEquippedItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `PhaseUseFlags` tinyint unsigned NOT NULL DEFAULT '0',
  `PhaseID` smallint unsigned NOT NULL DEFAULT '0',
  `PhaseGroupID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `ChrSpecializationIndex` tinyint NOT NULL DEFAULT '0',
  `ChrSpecializationRole` tinyint NOT NULL DEFAULT '0',
  `ModifierTreeID` int unsigned NOT NULL DEFAULT '0',
  `PowerType` tinyint NOT NULL DEFAULT '0',
  `PowerTypeComp` tinyint unsigned NOT NULL DEFAULT '0',
  `PowerTypeValue` tinyint unsigned NOT NULL DEFAULT '0',
  `WeaponSubclassMask` int NOT NULL DEFAULT '0',
  `MaxGuildLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `MinGuildLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxExpansionTier` tinyint NOT NULL DEFAULT '0',
  `MinExpansionTier` tinyint NOT NULL DEFAULT '0',
  `MinPVPRank` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxPVPRank` tinyint unsigned NOT NULL DEFAULT '0',
  `ContentTuningID` int NOT NULL DEFAULT '0',
  `CovenantID` int NOT NULL DEFAULT '0',
  `SkillID1` smallint unsigned NOT NULL DEFAULT '0',
  `SkillID2` smallint unsigned NOT NULL DEFAULT '0',
  `SkillID3` smallint unsigned NOT NULL DEFAULT '0',
  `SkillID4` smallint unsigned NOT NULL DEFAULT '0',
  `MinSkill1` smallint unsigned NOT NULL DEFAULT '0',
  `MinSkill2` smallint unsigned NOT NULL DEFAULT '0',
  `MinSkill3` smallint unsigned NOT NULL DEFAULT '0',
  `MinSkill4` smallint unsigned NOT NULL DEFAULT '0',
  `MaxSkill1` smallint unsigned NOT NULL DEFAULT '0',
  `MaxSkill2` smallint unsigned NOT NULL DEFAULT '0',
  `MaxSkill3` smallint unsigned NOT NULL DEFAULT '0',
  `MaxSkill4` smallint unsigned NOT NULL DEFAULT '0',
  `MinFactionID1` int unsigned NOT NULL DEFAULT '0',
  `MinFactionID2` int unsigned NOT NULL DEFAULT '0',
  `MinFactionID3` int unsigned NOT NULL DEFAULT '0',
  `MinReputation1` tinyint unsigned NOT NULL DEFAULT '0',
  `MinReputation2` tinyint unsigned NOT NULL DEFAULT '0',
  `MinReputation3` tinyint unsigned NOT NULL DEFAULT '0',
  `PrevQuestID1` int NOT NULL DEFAULT '0',
  `PrevQuestID2` int NOT NULL DEFAULT '0',
  `PrevQuestID3` int NOT NULL DEFAULT '0',
  `PrevQuestID4` int NOT NULL DEFAULT '0',
  `CurrQuestID1` int NOT NULL DEFAULT '0',
  `CurrQuestID2` int NOT NULL DEFAULT '0',
  `CurrQuestID3` int NOT NULL DEFAULT '0',
  `CurrQuestID4` int NOT NULL DEFAULT '0',
  `CurrentCompletedQuestID1` int NOT NULL DEFAULT '0',
  `CurrentCompletedQuestID2` int NOT NULL DEFAULT '0',
  `CurrentCompletedQuestID3` int NOT NULL DEFAULT '0',
  `CurrentCompletedQuestID4` int NOT NULL DEFAULT '0',
  `SpellID1` int NOT NULL DEFAULT '0',
  `SpellID2` int NOT NULL DEFAULT '0',
  `SpellID3` int NOT NULL DEFAULT '0',
  `SpellID4` int NOT NULL DEFAULT '0',
  `ItemID1` int NOT NULL DEFAULT '0',
  `ItemID2` int NOT NULL DEFAULT '0',
  `ItemID3` int NOT NULL DEFAULT '0',
  `ItemID4` int NOT NULL DEFAULT '0',
  `ItemCount1` int unsigned NOT NULL DEFAULT '0',
  `ItemCount2` int unsigned NOT NULL DEFAULT '0',
  `ItemCount3` int unsigned NOT NULL DEFAULT '0',
  `ItemCount4` int unsigned NOT NULL DEFAULT '0',
  `Explored1` smallint unsigned NOT NULL DEFAULT '0',
  `Explored2` smallint unsigned NOT NULL DEFAULT '0',
  `Time1` int unsigned NOT NULL DEFAULT '0',
  `Time2` int unsigned NOT NULL DEFAULT '0',
  `AuraSpellID1` int NOT NULL DEFAULT '0',
  `AuraSpellID2` int NOT NULL DEFAULT '0',
  `AuraSpellID3` int NOT NULL DEFAULT '0',
  `AuraSpellID4` int NOT NULL DEFAULT '0',
  `AuraStacks1` tinyint unsigned NOT NULL DEFAULT '0',
  `AuraStacks2` tinyint unsigned NOT NULL DEFAULT '0',
  `AuraStacks3` tinyint unsigned NOT NULL DEFAULT '0',
  `AuraStacks4` tinyint unsigned NOT NULL DEFAULT '0',
  `Achievement1` smallint unsigned NOT NULL DEFAULT '0',
  `Achievement2` smallint unsigned NOT NULL DEFAULT '0',
  `Achievement3` smallint unsigned NOT NULL DEFAULT '0',
  `Achievement4` smallint unsigned NOT NULL DEFAULT '0',
  `AreaID1` smallint unsigned NOT NULL DEFAULT '0',
  `AreaID2` smallint unsigned NOT NULL DEFAULT '0',
  `AreaID3` smallint unsigned NOT NULL DEFAULT '0',
  `AreaID4` smallint unsigned NOT NULL DEFAULT '0',
  `LfgStatus1` tinyint unsigned NOT NULL DEFAULT '0',
  `LfgStatus2` tinyint unsigned NOT NULL DEFAULT '0',
  `LfgStatus3` tinyint unsigned NOT NULL DEFAULT '0',
  `LfgStatus4` tinyint unsigned NOT NULL DEFAULT '0',
  `LfgCompare1` tinyint unsigned NOT NULL DEFAULT '0',
  `LfgCompare2` tinyint unsigned NOT NULL DEFAULT '0',
  `LfgCompare3` tinyint unsigned NOT NULL DEFAULT '0',
  `LfgCompare4` tinyint unsigned NOT NULL DEFAULT '0',
  `LfgValue1` int unsigned NOT NULL DEFAULT '0',
  `LfgValue2` int unsigned NOT NULL DEFAULT '0',
  `LfgValue3` int unsigned NOT NULL DEFAULT '0',
  `LfgValue4` int unsigned NOT NULL DEFAULT '0',
  `CurrencyID1` int unsigned NOT NULL DEFAULT '0',
  `CurrencyID2` int unsigned NOT NULL DEFAULT '0',
  `CurrencyID3` int unsigned NOT NULL DEFAULT '0',
  `CurrencyID4` int unsigned NOT NULL DEFAULT '0',
  `CurrencyCount1` int unsigned NOT NULL DEFAULT '0',
  `CurrencyCount2` int unsigned NOT NULL DEFAULT '0',
  `CurrencyCount3` int unsigned NOT NULL DEFAULT '0',
  `CurrencyCount4` int unsigned NOT NULL DEFAULT '0',
  `QuestKillMonster1` int unsigned NOT NULL DEFAULT '0',
  `QuestKillMonster2` int unsigned NOT NULL DEFAULT '0',
  `QuestKillMonster3` int unsigned NOT NULL DEFAULT '0',
  `QuestKillMonster4` int unsigned NOT NULL DEFAULT '0',
  `QuestKillMonster5` int unsigned NOT NULL DEFAULT '0',
  `QuestKillMonster6` int unsigned NOT NULL DEFAULT '0',
  `MovementFlags1` int NOT NULL DEFAULT '0',
  `MovementFlags2` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_condition`
--

LOCK TABLES `player_condition` WRITE;
/*!40000 ALTER TABLE `player_condition` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_condition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_condition_locale`
--

DROP TABLE IF EXISTS `player_condition_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player_condition_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `FailureDescription_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_condition_locale`
--

LOCK TABLES `player_condition_locale` WRITE;
/*!40000 ALTER TABLE `player_condition_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_condition_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `power_display`
--

DROP TABLE IF EXISTS `power_display`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `power_display` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `GlobalStringBaseTag` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ActualType` tinyint unsigned NOT NULL DEFAULT '0',
  `Red` tinyint unsigned NOT NULL DEFAULT '0',
  `Green` tinyint unsigned NOT NULL DEFAULT '0',
  `Blue` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power_display`
--

LOCK TABLES `power_display` WRITE;
/*!40000 ALTER TABLE `power_display` DISABLE KEYS */;
/*!40000 ALTER TABLE `power_display` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `power_type`
--

DROP TABLE IF EXISTS `power_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `power_type` (
  `NameGlobalStringTag` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `CostGlobalStringTag` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PowerTypeEnum` tinyint NOT NULL DEFAULT '0',
  `MinPower` tinyint NOT NULL DEFAULT '0',
  `MaxBasePower` smallint NOT NULL DEFAULT '0',
  `CenterPower` tinyint NOT NULL DEFAULT '0',
  `DefaultPower` tinyint NOT NULL DEFAULT '0',
  `DisplayModifier` tinyint NOT NULL DEFAULT '0',
  `RegenInterruptTimeMS` smallint NOT NULL DEFAULT '0',
  `RegenPeace` float NOT NULL DEFAULT '0',
  `RegenCombat` float NOT NULL DEFAULT '0',
  `Flags` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power_type`
--

LOCK TABLES `power_type` WRITE;
/*!40000 ALTER TABLE `power_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `power_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestige_level_info`
--

DROP TABLE IF EXISTS `prestige_level_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestige_level_info` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `PrestigeLevel` int NOT NULL DEFAULT '0',
  `BadgeTextureFileDataID` int NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `AwardedAchievementID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestige_level_info`
--

LOCK TABLES `prestige_level_info` WRITE;
/*!40000 ALTER TABLE `prestige_level_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestige_level_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestige_level_info_locale`
--

DROP TABLE IF EXISTS `prestige_level_info_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestige_level_info_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestige_level_info_locale`
--

LOCK TABLES `prestige_level_info_locale` WRITE;
/*!40000 ALTER TABLE `prestige_level_info_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestige_level_info_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pvp_difficulty`
--

DROP TABLE IF EXISTS `pvp_difficulty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pvp_difficulty` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `RangeIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `MinLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `MapID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pvp_difficulty`
--

LOCK TABLES `pvp_difficulty` WRITE;
/*!40000 ALTER TABLE `pvp_difficulty` DISABLE KEYS */;
/*!40000 ALTER TABLE `pvp_difficulty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pvp_item`
--

DROP TABLE IF EXISTS `pvp_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pvp_item` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemID` int NOT NULL DEFAULT '0',
  `ItemLevelDelta` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pvp_item`
--

LOCK TABLES `pvp_item` WRITE;
/*!40000 ALTER TABLE `pvp_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `pvp_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pvp_talent`
--

DROP TABLE IF EXISTS `pvp_talent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pvp_talent` (
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpecID` int NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `OverridesSpellID` int NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `ActionBarSpellID` int NOT NULL DEFAULT '0',
  `PvpTalentCategoryID` int NOT NULL DEFAULT '0',
  `LevelRequired` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pvp_talent`
--

LOCK TABLES `pvp_talent` WRITE;
/*!40000 ALTER TABLE `pvp_talent` DISABLE KEYS */;
/*!40000 ALTER TABLE `pvp_talent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pvp_talent_category`
--

DROP TABLE IF EXISTS `pvp_talent_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pvp_talent_category` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `TalentSlotMask` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pvp_talent_category`
--

LOCK TABLES `pvp_talent_category` WRITE;
/*!40000 ALTER TABLE `pvp_talent_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `pvp_talent_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pvp_talent_locale`
--

DROP TABLE IF EXISTS `pvp_talent_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pvp_talent_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pvp_talent_locale`
--

LOCK TABLES `pvp_talent_locale` WRITE;
/*!40000 ALTER TABLE `pvp_talent_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `pvp_talent_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pvp_talent_slot_unlock`
--

DROP TABLE IF EXISTS `pvp_talent_slot_unlock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pvp_talent_slot_unlock` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Slot` tinyint NOT NULL DEFAULT '0',
  `LevelRequired` int NOT NULL DEFAULT '0',
  `DeathKnightLevelRequired` int NOT NULL DEFAULT '0',
  `DemonHunterLevelRequired` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pvp_talent_slot_unlock`
--

LOCK TABLES `pvp_talent_slot_unlock` WRITE;
/*!40000 ALTER TABLE `pvp_talent_slot_unlock` DISABLE KEYS */;
/*!40000 ALTER TABLE `pvp_talent_slot_unlock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_faction_reward`
--

DROP TABLE IF EXISTS `quest_faction_reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_faction_reward` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Difficulty1` smallint NOT NULL DEFAULT '0',
  `Difficulty2` smallint NOT NULL DEFAULT '0',
  `Difficulty3` smallint NOT NULL DEFAULT '0',
  `Difficulty4` smallint NOT NULL DEFAULT '0',
  `Difficulty5` smallint NOT NULL DEFAULT '0',
  `Difficulty6` smallint NOT NULL DEFAULT '0',
  `Difficulty7` smallint NOT NULL DEFAULT '0',
  `Difficulty8` smallint NOT NULL DEFAULT '0',
  `Difficulty9` smallint NOT NULL DEFAULT '0',
  `Difficulty10` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_faction_reward`
--

LOCK TABLES `quest_faction_reward` WRITE;
/*!40000 ALTER TABLE `quest_faction_reward` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_faction_reward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_info`
--

DROP TABLE IF EXISTS `quest_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_info` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `InfoName` text COLLATE utf8mb4_unicode_ci,
  `Type` tinyint NOT NULL DEFAULT '0',
  `Modifiers` tinyint unsigned NOT NULL DEFAULT '0',
  `Profession` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_info`
--

LOCK TABLES `quest_info` WRITE;
/*!40000 ALTER TABLE `quest_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_info_locale`
--

DROP TABLE IF EXISTS `quest_info_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_info_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `InfoName_lang` text COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_info_locale`
--

LOCK TABLES `quest_info_locale` WRITE;
/*!40000 ALTER TABLE `quest_info_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_info_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_money_reward`
--

DROP TABLE IF EXISTS `quest_money_reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_money_reward` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Difficulty1` int unsigned NOT NULL DEFAULT '0',
  `Difficulty2` int unsigned NOT NULL DEFAULT '0',
  `Difficulty3` int unsigned NOT NULL DEFAULT '0',
  `Difficulty4` int unsigned NOT NULL DEFAULT '0',
  `Difficulty5` int unsigned NOT NULL DEFAULT '0',
  `Difficulty6` int unsigned NOT NULL DEFAULT '0',
  `Difficulty7` int unsigned NOT NULL DEFAULT '0',
  `Difficulty8` int unsigned NOT NULL DEFAULT '0',
  `Difficulty9` int unsigned NOT NULL DEFAULT '0',
  `Difficulty10` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_money_reward`
--

LOCK TABLES `quest_money_reward` WRITE;
/*!40000 ALTER TABLE `quest_money_reward` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_money_reward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_package_item`
--

DROP TABLE IF EXISTS `quest_package_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_package_item` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PackageID` smallint unsigned NOT NULL DEFAULT '0',
  `ItemID` int NOT NULL DEFAULT '0',
  `ItemQuantity` int unsigned NOT NULL DEFAULT '0',
  `DisplayType` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_package_item`
--

LOCK TABLES `quest_package_item` WRITE;
/*!40000 ALTER TABLE `quest_package_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_package_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_sort`
--

DROP TABLE IF EXISTS `quest_sort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_sort` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SortName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `UiOrderIndex` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_sort`
--

LOCK TABLES `quest_sort` WRITE;
/*!40000 ALTER TABLE `quest_sort` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_sort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_sort_locale`
--

DROP TABLE IF EXISTS `quest_sort_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_sort_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SortName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_sort_locale`
--

LOCK TABLES `quest_sort_locale` WRITE;
/*!40000 ALTER TABLE `quest_sort_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_sort_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_v2`
--

DROP TABLE IF EXISTS `quest_v2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_v2` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `UniqueBitFlag` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_v2`
--

LOCK TABLES `quest_v2` WRITE;
/*!40000 ALTER TABLE `quest_v2` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_v2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_xp`
--

DROP TABLE IF EXISTS `quest_xp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quest_xp` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Difficulty1` smallint unsigned NOT NULL DEFAULT '0',
  `Difficulty2` smallint unsigned NOT NULL DEFAULT '0',
  `Difficulty3` smallint unsigned NOT NULL DEFAULT '0',
  `Difficulty4` smallint unsigned NOT NULL DEFAULT '0',
  `Difficulty5` smallint unsigned NOT NULL DEFAULT '0',
  `Difficulty6` smallint unsigned NOT NULL DEFAULT '0',
  `Difficulty7` smallint unsigned NOT NULL DEFAULT '0',
  `Difficulty8` smallint unsigned NOT NULL DEFAULT '0',
  `Difficulty9` smallint unsigned NOT NULL DEFAULT '0',
  `Difficulty10` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_xp`
--

LOCK TABLES `quest_xp` WRITE;
/*!40000 ALTER TABLE `quest_xp` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_xp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rand_prop_points`
--

DROP TABLE IF EXISTS `rand_prop_points`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rand_prop_points` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DamageReplaceStat` int NOT NULL DEFAULT '0',
  `DamageSecondary` int NOT NULL DEFAULT '0',
  `Epic1` int unsigned NOT NULL DEFAULT '0',
  `Epic2` int unsigned NOT NULL DEFAULT '0',
  `Epic3` int unsigned NOT NULL DEFAULT '0',
  `Epic4` int unsigned NOT NULL DEFAULT '0',
  `Epic5` int unsigned NOT NULL DEFAULT '0',
  `Superior1` int unsigned NOT NULL DEFAULT '0',
  `Superior2` int unsigned NOT NULL DEFAULT '0',
  `Superior3` int unsigned NOT NULL DEFAULT '0',
  `Superior4` int unsigned NOT NULL DEFAULT '0',
  `Superior5` int unsigned NOT NULL DEFAULT '0',
  `Good1` int unsigned NOT NULL DEFAULT '0',
  `Good2` int unsigned NOT NULL DEFAULT '0',
  `Good3` int unsigned NOT NULL DEFAULT '0',
  `Good4` int unsigned NOT NULL DEFAULT '0',
  `Good5` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rand_prop_points`
--

LOCK TABLES `rand_prop_points` WRITE;
/*!40000 ALTER TABLE `rand_prop_points` DISABLE KEYS */;
/*!40000 ALTER TABLE `rand_prop_points` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reward_pack`
--

DROP TABLE IF EXISTS `reward_pack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reward_pack` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `CharTitleID` int NOT NULL DEFAULT '0',
  `Money` int unsigned NOT NULL DEFAULT '0',
  `ArtifactXPDifficulty` tinyint NOT NULL DEFAULT '0',
  `ArtifactXPMultiplier` float NOT NULL DEFAULT '0',
  `ArtifactXPCategoryID` tinyint unsigned NOT NULL DEFAULT '0',
  `TreasurePickerID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reward_pack`
--

LOCK TABLES `reward_pack` WRITE;
/*!40000 ALTER TABLE `reward_pack` DISABLE KEYS */;
/*!40000 ALTER TABLE `reward_pack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reward_pack_x_currency_type`
--

DROP TABLE IF EXISTS `reward_pack_x_currency_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reward_pack_x_currency_type` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `CurrencyTypeID` int unsigned NOT NULL DEFAULT '0',
  `Quantity` int NOT NULL DEFAULT '0',
  `RewardPackID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reward_pack_x_currency_type`
--

LOCK TABLES `reward_pack_x_currency_type` WRITE;
/*!40000 ALTER TABLE `reward_pack_x_currency_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `reward_pack_x_currency_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reward_pack_x_item`
--

DROP TABLE IF EXISTS `reward_pack_x_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reward_pack_x_item` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemID` int NOT NULL DEFAULT '0',
  `ItemQuantity` int NOT NULL DEFAULT '0',
  `RewardPackID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reward_pack_x_item`
--

LOCK TABLES `reward_pack_x_item` WRITE;
/*!40000 ALTER TABLE `reward_pack_x_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `reward_pack_x_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scenario`
--

DROP TABLE IF EXISTS `scenario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scenario` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `AreaTableID` smallint unsigned NOT NULL DEFAULT '0',
  `Type` tinyint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `UiTextureKitID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scenario`
--

LOCK TABLES `scenario` WRITE;
/*!40000 ALTER TABLE `scenario` DISABLE KEYS */;
/*!40000 ALTER TABLE `scenario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scenario_locale`
--

DROP TABLE IF EXISTS `scenario_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scenario_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scenario_locale`
--

LOCK TABLES `scenario_locale` WRITE;
/*!40000 ALTER TABLE `scenario_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `scenario_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scenario_step`
--

DROP TABLE IF EXISTS `scenario_step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scenario_step` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ScenarioID` smallint unsigned NOT NULL DEFAULT '0',
  `Criteriatreeid` int unsigned NOT NULL DEFAULT '0',
  `RewardQuestID` int NOT NULL DEFAULT '0',
  `RelatedStep` int NOT NULL DEFAULT '0',
  `Supersedes` smallint unsigned NOT NULL DEFAULT '0',
  `OrderIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VisibilityPlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `WidgetSetID` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scenario_step`
--

LOCK TABLES `scenario_step` WRITE;
/*!40000 ALTER TABLE `scenario_step` DISABLE KEYS */;
/*!40000 ALTER TABLE `scenario_step` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scenario_step_locale`
--

DROP TABLE IF EXISTS `scenario_step_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scenario_step_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Title_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scenario_step_locale`
--

LOCK TABLES `scenario_step_locale` WRITE;
/*!40000 ALTER TABLE `scenario_step_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `scenario_step_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scene_script`
--

DROP TABLE IF EXISTS `scene_script`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene_script` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `FirstSceneScriptID` smallint unsigned NOT NULL DEFAULT '0',
  `NextSceneScriptID` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scene_script`
--

LOCK TABLES `scene_script` WRITE;
/*!40000 ALTER TABLE `scene_script` DISABLE KEYS */;
/*!40000 ALTER TABLE `scene_script` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scene_script_global_text`
--

DROP TABLE IF EXISTS `scene_script_global_text`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene_script_global_text` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Script` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scene_script_global_text`
--

LOCK TABLES `scene_script_global_text` WRITE;
/*!40000 ALTER TABLE `scene_script_global_text` DISABLE KEYS */;
/*!40000 ALTER TABLE `scene_script_global_text` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scene_script_package`
--

DROP TABLE IF EXISTS `scene_script_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene_script_package` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scene_script_package`
--

LOCK TABLES `scene_script_package` WRITE;
/*!40000 ALTER TABLE `scene_script_package` DISABLE KEYS */;
/*!40000 ALTER TABLE `scene_script_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scene_script_text`
--

DROP TABLE IF EXISTS `scene_script_text`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene_script_text` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Script` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scene_script_text`
--

LOCK TABLES `scene_script_text` WRITE;
/*!40000 ALTER TABLE `scene_script_text` DISABLE KEYS */;
/*!40000 ALTER TABLE `scene_script_text` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_line`
--

DROP TABLE IF EXISTS `skill_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill_line` (
  `DisplayName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `AlternateVerb` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `HordeDisplayName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `OverrideSourceInfoDisplayName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `CategoryID` tinyint NOT NULL DEFAULT '0',
  `SpellIconFileID` int NOT NULL DEFAULT '0',
  `CanLink` tinyint NOT NULL DEFAULT '0',
  `ParentSkillLineID` int unsigned NOT NULL DEFAULT '0',
  `ParentTierIndex` int NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `SpellBookSpellID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_line`
--

LOCK TABLES `skill_line` WRITE;
/*!40000 ALTER TABLE `skill_line` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_line_ability`
--

DROP TABLE IF EXISTS `skill_line_ability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill_line_ability` (
  `RaceMask` bigint NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SkillLine` smallint NOT NULL DEFAULT '0',
  `Spell` int NOT NULL DEFAULT '0',
  `MinSkillLineRank` smallint NOT NULL DEFAULT '0',
  `ClassMask` int NOT NULL DEFAULT '0',
  `SupercedesSpell` int NOT NULL DEFAULT '0',
  `AcquireMethod` tinyint NOT NULL DEFAULT '0',
  `TrivialSkillLineRankHigh` smallint NOT NULL DEFAULT '0',
  `TrivialSkillLineRankLow` smallint NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `NumSkillUps` tinyint NOT NULL DEFAULT '0',
  `UniqueBit` smallint NOT NULL DEFAULT '0',
  `TradeSkillCategoryID` smallint NOT NULL DEFAULT '0',
  `SkillupSkillLineID` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_line_ability`
--

LOCK TABLES `skill_line_ability` WRITE;
/*!40000 ALTER TABLE `skill_line_ability` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill_line_ability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_line_locale`
--

DROP TABLE IF EXISTS `skill_line_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill_line_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `DisplayName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `AlternateVerb_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `HordeDisplayName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_line_locale`
--

LOCK TABLES `skill_line_locale` WRITE;
/*!40000 ALTER TABLE `skill_line_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill_line_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_race_class_info`
--

DROP TABLE IF EXISTS `skill_race_class_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill_race_class_info` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `RaceMask` bigint NOT NULL DEFAULT '0',
  `SkillID` smallint NOT NULL DEFAULT '0',
  `ClassMask` int NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `Availability` tinyint NOT NULL DEFAULT '0',
  `MinLevel` tinyint NOT NULL DEFAULT '0',
  `SkillTierID` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_race_class_info`
--

LOCK TABLES `skill_race_class_info` WRITE;
/*!40000 ALTER TABLE `skill_race_class_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill_race_class_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sound_kit`
--

DROP TABLE IF EXISTS `sound_kit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sound_kit` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SoundType` int NOT NULL DEFAULT '0',
  `VolumeFloat` float NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `MinDistance` float NOT NULL DEFAULT '0',
  `DistanceCutoff` float NOT NULL DEFAULT '0',
  `EAXDef` tinyint unsigned NOT NULL DEFAULT '0',
  `SoundKitAdvancedID` int unsigned NOT NULL DEFAULT '0',
  `VolumeVariationPlus` float NOT NULL DEFAULT '0',
  `VolumeVariationMinus` float NOT NULL DEFAULT '0',
  `PitchVariationPlus` float NOT NULL DEFAULT '0',
  `PitchVariationMinus` float NOT NULL DEFAULT '0',
  `DialogType` tinyint NOT NULL DEFAULT '0',
  `PitchAdjust` float NOT NULL DEFAULT '0',
  `BusOverwriteID` smallint unsigned NOT NULL DEFAULT '0',
  `MaxInstances` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sound_kit`
--

LOCK TABLES `sound_kit` WRITE;
/*!40000 ALTER TABLE `sound_kit` DISABLE KEYS */;
/*!40000 ALTER TABLE `sound_kit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spec_set_member`
--

DROP TABLE IF EXISTS `spec_set_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spec_set_member` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ChrSpecializationID` int NOT NULL DEFAULT '0',
  `SpecSetID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spec_set_member`
--

LOCK TABLES `spec_set_member` WRITE;
/*!40000 ALTER TABLE `spec_set_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `spec_set_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialization_spells`
--

DROP TABLE IF EXISTS `specialization_spells`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialization_spells` (
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpecID` smallint unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `OverridesSpellID` int NOT NULL DEFAULT '0',
  `DisplayOrder` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialization_spells`
--

LOCK TABLES `specialization_spells` WRITE;
/*!40000 ALTER TABLE `specialization_spells` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialization_spells` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialization_spells_locale`
--

DROP TABLE IF EXISTS `specialization_spells_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialization_spells_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialization_spells_locale`
--

LOCK TABLES `specialization_spells_locale` WRITE;
/*!40000 ALTER TABLE `specialization_spells_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialization_spells_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_aura_options`
--

DROP TABLE IF EXISTS `spell_aura_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_aura_options` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `CumulativeAura` smallint unsigned NOT NULL DEFAULT '0',
  `ProcCategoryRecovery` int NOT NULL DEFAULT '0',
  `ProcChance` tinyint unsigned NOT NULL DEFAULT '0',
  `ProcCharges` int NOT NULL DEFAULT '0',
  `SpellProcsPerMinuteID` smallint unsigned NOT NULL DEFAULT '0',
  `ProcTypeMask1` int NOT NULL DEFAULT '0',
  `ProcTypeMask2` int NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_aura_options`
--

LOCK TABLES `spell_aura_options` WRITE;
/*!40000 ALTER TABLE `spell_aura_options` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_aura_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_aura_restrictions`
--

DROP TABLE IF EXISTS `spell_aura_restrictions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_aura_restrictions` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `CasterAuraState` tinyint unsigned NOT NULL DEFAULT '0',
  `TargetAuraState` tinyint unsigned NOT NULL DEFAULT '0',
  `ExcludeCasterAuraState` tinyint unsigned NOT NULL DEFAULT '0',
  `ExcludeTargetAuraState` tinyint unsigned NOT NULL DEFAULT '0',
  `CasterAuraSpell` int NOT NULL DEFAULT '0',
  `TargetAuraSpell` int NOT NULL DEFAULT '0',
  `ExcludeCasterAuraSpell` int NOT NULL DEFAULT '0',
  `ExcludeTargetAuraSpell` int NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_aura_restrictions`
--

LOCK TABLES `spell_aura_restrictions` WRITE;
/*!40000 ALTER TABLE `spell_aura_restrictions` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_aura_restrictions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_cast_times`
--

DROP TABLE IF EXISTS `spell_cast_times`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_cast_times` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Base` int NOT NULL DEFAULT '0',
  `Minimum` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_cast_times`
--

LOCK TABLES `spell_cast_times` WRITE;
/*!40000 ALTER TABLE `spell_cast_times` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_cast_times` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_casting_requirements`
--

DROP TABLE IF EXISTS `spell_casting_requirements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_casting_requirements` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `FacingCasterFlags` tinyint unsigned NOT NULL DEFAULT '0',
  `MinFactionID` smallint unsigned NOT NULL DEFAULT '0',
  `MinReputation` tinyint NOT NULL DEFAULT '0',
  `RequiredAreasID` smallint unsigned NOT NULL DEFAULT '0',
  `RequiredAuraVision` tinyint unsigned NOT NULL DEFAULT '0',
  `RequiresSpellFocus` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_casting_requirements`
--

LOCK TABLES `spell_casting_requirements` WRITE;
/*!40000 ALTER TABLE `spell_casting_requirements` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_casting_requirements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_categories`
--

DROP TABLE IF EXISTS `spell_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_categories` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `Category` smallint NOT NULL DEFAULT '0',
  `DefenseType` tinyint NOT NULL DEFAULT '0',
  `DispelType` tinyint NOT NULL DEFAULT '0',
  `Mechanic` tinyint NOT NULL DEFAULT '0',
  `PreventionType` tinyint NOT NULL DEFAULT '0',
  `StartRecoveryCategory` smallint NOT NULL DEFAULT '0',
  `ChargeCategory` smallint NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_categories`
--

LOCK TABLES `spell_categories` WRITE;
/*!40000 ALTER TABLE `spell_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_category`
--

DROP TABLE IF EXISTS `spell_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_category` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Flags` tinyint NOT NULL DEFAULT '0',
  `UsesPerWeek` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxCharges` tinyint NOT NULL DEFAULT '0',
  `ChargeRecoveryTime` int NOT NULL DEFAULT '0',
  `TypeMask` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_category`
--

LOCK TABLES `spell_category` WRITE;
/*!40000 ALTER TABLE `spell_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_category_locale`
--

DROP TABLE IF EXISTS `spell_category_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_category_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_category_locale`
--

LOCK TABLES `spell_category_locale` WRITE;
/*!40000 ALTER TABLE `spell_category_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_category_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_class_options`
--

DROP TABLE IF EXISTS `spell_class_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_class_options` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `ModalNextSpell` int unsigned NOT NULL DEFAULT '0',
  `SpellClassSet` tinyint unsigned NOT NULL DEFAULT '0',
  `SpellClassMask1` int NOT NULL DEFAULT '0',
  `SpellClassMask2` int NOT NULL DEFAULT '0',
  `SpellClassMask3` int NOT NULL DEFAULT '0',
  `SpellClassMask4` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_class_options`
--

LOCK TABLES `spell_class_options` WRITE;
/*!40000 ALTER TABLE `spell_class_options` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_class_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_cooldowns`
--

DROP TABLE IF EXISTS `spell_cooldowns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_cooldowns` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `CategoryRecoveryTime` int NOT NULL DEFAULT '0',
  `RecoveryTime` int NOT NULL DEFAULT '0',
  `StartRecoveryTime` int NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_cooldowns`
--

LOCK TABLES `spell_cooldowns` WRITE;
/*!40000 ALTER TABLE `spell_cooldowns` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_cooldowns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_duration`
--

DROP TABLE IF EXISTS `spell_duration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_duration` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Duration` int NOT NULL DEFAULT '0',
  `MaxDuration` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_duration`
--

LOCK TABLES `spell_duration` WRITE;
/*!40000 ALTER TABLE `spell_duration` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_duration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_effect`
--

DROP TABLE IF EXISTS `spell_effect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_effect` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `EffectAura` smallint NOT NULL DEFAULT '0',
  `DifficultyID` int NOT NULL DEFAULT '0',
  `EffectIndex` int NOT NULL DEFAULT '0',
  `Effect` int NOT NULL DEFAULT '0',
  `EffectAmplitude` float NOT NULL DEFAULT '0',
  `EffectAttributes` int NOT NULL DEFAULT '0',
  `EffectAuraPeriod` int NOT NULL DEFAULT '0',
  `EffectBonusCoefficient` float NOT NULL DEFAULT '0',
  `EffectChainAmplitude` float NOT NULL DEFAULT '0',
  `EffectChainTargets` int NOT NULL DEFAULT '0',
  `EffectItemType` int NOT NULL DEFAULT '0',
  `EffectMechanic` int NOT NULL DEFAULT '0',
  `EffectPointsPerResource` float NOT NULL DEFAULT '0',
  `EffectPosFacing` float NOT NULL DEFAULT '0',
  `EffectRealPointsPerLevel` float NOT NULL DEFAULT '0',
  `EffectTriggerSpell` int NOT NULL DEFAULT '0',
  `BonusCoefficientFromAP` float NOT NULL DEFAULT '0',
  `PvpMultiplier` float NOT NULL DEFAULT '0',
  `Coefficient` float NOT NULL DEFAULT '0',
  `Variance` float NOT NULL DEFAULT '0',
  `ResourceCoefficient` float NOT NULL DEFAULT '0',
  `GroupSizeBasePointsCoefficient` float NOT NULL DEFAULT '0',
  `EffectBasePoints` float NOT NULL DEFAULT '0',
  `EffectMiscValue1` int NOT NULL DEFAULT '0',
  `EffectMiscValue2` int NOT NULL DEFAULT '0',
  `EffectRadiusIndex1` int unsigned NOT NULL DEFAULT '0',
  `EffectRadiusIndex2` int unsigned NOT NULL DEFAULT '0',
  `EffectSpellClassMask1` int NOT NULL DEFAULT '0',
  `EffectSpellClassMask2` int NOT NULL DEFAULT '0',
  `EffectSpellClassMask3` int NOT NULL DEFAULT '0',
  `EffectSpellClassMask4` int NOT NULL DEFAULT '0',
  `ImplicitTarget1` smallint NOT NULL DEFAULT '0',
  `ImplicitTarget2` smallint NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_effect`
--

LOCK TABLES `spell_effect` WRITE;
/*!40000 ALTER TABLE `spell_effect` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_effect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_equipped_items`
--

DROP TABLE IF EXISTS `spell_equipped_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_equipped_items` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `EquippedItemClass` tinyint NOT NULL DEFAULT '0',
  `EquippedItemInvTypes` int NOT NULL DEFAULT '0',
  `EquippedItemSubclass` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_equipped_items`
--

LOCK TABLES `spell_equipped_items` WRITE;
/*!40000 ALTER TABLE `spell_equipped_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_equipped_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_focus_object`
--

DROP TABLE IF EXISTS `spell_focus_object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_focus_object` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_focus_object`
--

LOCK TABLES `spell_focus_object` WRITE;
/*!40000 ALTER TABLE `spell_focus_object` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_focus_object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_focus_object_locale`
--

DROP TABLE IF EXISTS `spell_focus_object_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_focus_object_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_focus_object_locale`
--

LOCK TABLES `spell_focus_object_locale` WRITE;
/*!40000 ALTER TABLE `spell_focus_object_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_focus_object_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_interrupts`
--

DROP TABLE IF EXISTS `spell_interrupts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_interrupts` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `InterruptFlags` smallint NOT NULL DEFAULT '0',
  `AuraInterruptFlags1` int NOT NULL DEFAULT '0',
  `AuraInterruptFlags2` int NOT NULL DEFAULT '0',
  `ChannelInterruptFlags1` int NOT NULL DEFAULT '0',
  `ChannelInterruptFlags2` int NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_interrupts`
--

LOCK TABLES `spell_interrupts` WRITE;
/*!40000 ALTER TABLE `spell_interrupts` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_interrupts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_item_enchantment`
--

DROP TABLE IF EXISTS `spell_item_enchantment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_item_enchantment` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `HordeName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `EffectArg1` int unsigned NOT NULL DEFAULT '0',
  `EffectArg2` int unsigned NOT NULL DEFAULT '0',
  `EffectArg3` int unsigned NOT NULL DEFAULT '0',
  `EffectScalingPoints1` float NOT NULL DEFAULT '0',
  `EffectScalingPoints2` float NOT NULL DEFAULT '0',
  `EffectScalingPoints3` float NOT NULL DEFAULT '0',
  `IconFileDataID` int unsigned NOT NULL DEFAULT '0',
  `TransmogCost` int unsigned NOT NULL DEFAULT '0',
  `MinItemLevel` int NOT NULL DEFAULT '0',
  `MaxItemLevel` int NOT NULL DEFAULT '0',
  `TransmogUseConditionID` int unsigned NOT NULL DEFAULT '0',
  `EffectPointsMin1` smallint NOT NULL DEFAULT '0',
  `EffectPointsMin2` smallint NOT NULL DEFAULT '0',
  `EffectPointsMin3` smallint NOT NULL DEFAULT '0',
  `ItemVisual` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `RequiredSkillID` smallint unsigned NOT NULL DEFAULT '0',
  `RequiredSkillRank` smallint unsigned NOT NULL DEFAULT '0',
  `ItemLevel` smallint unsigned NOT NULL DEFAULT '0',
  `Charges` tinyint unsigned NOT NULL DEFAULT '0',
  `Effect1` tinyint unsigned NOT NULL DEFAULT '0',
  `Effect2` tinyint unsigned NOT NULL DEFAULT '0',
  `Effect3` tinyint unsigned NOT NULL DEFAULT '0',
  `ScalingClass` tinyint NOT NULL DEFAULT '0',
  `ScalingClassRestricted` tinyint NOT NULL DEFAULT '0',
  `ConditionID` tinyint unsigned NOT NULL DEFAULT '0',
  `MinLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_item_enchantment`
--

LOCK TABLES `spell_item_enchantment` WRITE;
/*!40000 ALTER TABLE `spell_item_enchantment` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_item_enchantment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_item_enchantment_condition`
--

DROP TABLE IF EXISTS `spell_item_enchantment_condition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_item_enchantment_condition` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `LtOperandType1` tinyint unsigned NOT NULL DEFAULT '0',
  `LtOperandType2` tinyint unsigned NOT NULL DEFAULT '0',
  `LtOperandType3` tinyint unsigned NOT NULL DEFAULT '0',
  `LtOperandType4` tinyint unsigned NOT NULL DEFAULT '0',
  `LtOperandType5` tinyint unsigned NOT NULL DEFAULT '0',
  `LtOperand1` int unsigned NOT NULL DEFAULT '0',
  `LtOperand2` int unsigned NOT NULL DEFAULT '0',
  `LtOperand3` int unsigned NOT NULL DEFAULT '0',
  `LtOperand4` int unsigned NOT NULL DEFAULT '0',
  `LtOperand5` int unsigned NOT NULL DEFAULT '0',
  `Operator1` tinyint unsigned NOT NULL DEFAULT '0',
  `Operator2` tinyint unsigned NOT NULL DEFAULT '0',
  `Operator3` tinyint unsigned NOT NULL DEFAULT '0',
  `Operator4` tinyint unsigned NOT NULL DEFAULT '0',
  `Operator5` tinyint unsigned NOT NULL DEFAULT '0',
  `RtOperandType1` tinyint unsigned NOT NULL DEFAULT '0',
  `RtOperandType2` tinyint unsigned NOT NULL DEFAULT '0',
  `RtOperandType3` tinyint unsigned NOT NULL DEFAULT '0',
  `RtOperandType4` tinyint unsigned NOT NULL DEFAULT '0',
  `RtOperandType5` tinyint unsigned NOT NULL DEFAULT '0',
  `RtOperand1` tinyint unsigned NOT NULL DEFAULT '0',
  `RtOperand2` tinyint unsigned NOT NULL DEFAULT '0',
  `RtOperand3` tinyint unsigned NOT NULL DEFAULT '0',
  `RtOperand4` tinyint unsigned NOT NULL DEFAULT '0',
  `RtOperand5` tinyint unsigned NOT NULL DEFAULT '0',
  `Logic1` tinyint unsigned NOT NULL DEFAULT '0',
  `Logic2` tinyint unsigned NOT NULL DEFAULT '0',
  `Logic3` tinyint unsigned NOT NULL DEFAULT '0',
  `Logic4` tinyint unsigned NOT NULL DEFAULT '0',
  `Logic5` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_item_enchantment_condition`
--

LOCK TABLES `spell_item_enchantment_condition` WRITE;
/*!40000 ALTER TABLE `spell_item_enchantment_condition` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_item_enchantment_condition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_item_enchantment_locale`
--

DROP TABLE IF EXISTS `spell_item_enchantment_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_item_enchantment_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `HordeName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_item_enchantment_locale`
--

LOCK TABLES `spell_item_enchantment_locale` WRITE;
/*!40000 ALTER TABLE `spell_item_enchantment_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_item_enchantment_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_learn_spell`
--

DROP TABLE IF EXISTS `spell_learn_spell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_learn_spell` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `LearnSpellID` int NOT NULL DEFAULT '0',
  `OverridesSpellID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_learn_spell`
--

LOCK TABLES `spell_learn_spell` WRITE;
/*!40000 ALTER TABLE `spell_learn_spell` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_learn_spell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_levels`
--

DROP TABLE IF EXISTS `spell_levels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_levels` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxLevel` smallint NOT NULL DEFAULT '0',
  `MaxPassiveAuraLevel` tinyint unsigned NOT NULL DEFAULT '0',
  `BaseLevel` int NOT NULL DEFAULT '0',
  `SpellLevel` int NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_levels`
--

LOCK TABLES `spell_levels` WRITE;
/*!40000 ALTER TABLE `spell_levels` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_levels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_misc`
--

DROP TABLE IF EXISTS `spell_misc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_misc` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Attributes1` int NOT NULL DEFAULT '0',
  `Attributes2` int NOT NULL DEFAULT '0',
  `Attributes3` int NOT NULL DEFAULT '0',
  `Attributes4` int NOT NULL DEFAULT '0',
  `Attributes5` int NOT NULL DEFAULT '0',
  `Attributes6` int NOT NULL DEFAULT '0',
  `Attributes7` int NOT NULL DEFAULT '0',
  `Attributes8` int NOT NULL DEFAULT '0',
  `Attributes9` int NOT NULL DEFAULT '0',
  `Attributes10` int NOT NULL DEFAULT '0',
  `Attributes11` int NOT NULL DEFAULT '0',
  `Attributes12` int NOT NULL DEFAULT '0',
  `Attributes13` int NOT NULL DEFAULT '0',
  `Attributes14` int NOT NULL DEFAULT '0',
  `Attributes15` int NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `CastingTimeIndex` smallint unsigned NOT NULL DEFAULT '0',
  `DurationIndex` smallint unsigned NOT NULL DEFAULT '0',
  `RangeIndex` smallint unsigned NOT NULL DEFAULT '0',
  `SchoolMask` tinyint unsigned NOT NULL DEFAULT '0',
  `Speed` float NOT NULL DEFAULT '0',
  `LaunchDelay` float NOT NULL DEFAULT '0',
  `MinDuration` float NOT NULL DEFAULT '0',
  `SpellIconFileDataID` int NOT NULL DEFAULT '0',
  `ActiveIconFileDataID` int NOT NULL DEFAULT '0',
  `ContentTuningID` int NOT NULL DEFAULT '0',
  `ShowFutureSpellPlayerConditionID` int NOT NULL DEFAULT '0',
  `SpellVisualScript` int NOT NULL DEFAULT '0',
  `ActiveSpellVisualScript` int NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_misc`
--

LOCK TABLES `spell_misc` WRITE;
/*!40000 ALTER TABLE `spell_misc` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_misc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_name`
--

DROP TABLE IF EXISTS `spell_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_name` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_name`
--

LOCK TABLES `spell_name` WRITE;
/*!40000 ALTER TABLE `spell_name` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_name_locale`
--

DROP TABLE IF EXISTS `spell_name_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_name_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_name_locale`
--

LOCK TABLES `spell_name_locale` WRITE;
/*!40000 ALTER TABLE `spell_name_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_name_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_power`
--

DROP TABLE IF EXISTS `spell_power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_power` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `OrderIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `ManaCost` int NOT NULL DEFAULT '0',
  `ManaCostPerLevel` int NOT NULL DEFAULT '0',
  `ManaPerSecond` int NOT NULL DEFAULT '0',
  `PowerDisplayID` int unsigned NOT NULL DEFAULT '0',
  `AltPowerBarID` int NOT NULL DEFAULT '0',
  `PowerCostPct` float NOT NULL DEFAULT '0',
  `PowerCostMaxPct` float NOT NULL DEFAULT '0',
  `PowerPctPerSecond` float NOT NULL DEFAULT '0',
  `PowerType` tinyint NOT NULL DEFAULT '0',
  `RequiredAuraSpellID` int NOT NULL DEFAULT '0',
  `OptionalCost` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_power`
--

LOCK TABLES `spell_power` WRITE;
/*!40000 ALTER TABLE `spell_power` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_power_difficulty`
--

DROP TABLE IF EXISTS `spell_power_difficulty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_power_difficulty` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `OrderIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_power_difficulty`
--

LOCK TABLES `spell_power_difficulty` WRITE;
/*!40000 ALTER TABLE `spell_power_difficulty` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_power_difficulty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_procs_per_minute`
--

DROP TABLE IF EXISTS `spell_procs_per_minute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_procs_per_minute` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `BaseProcRate` float NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_procs_per_minute`
--

LOCK TABLES `spell_procs_per_minute` WRITE;
/*!40000 ALTER TABLE `spell_procs_per_minute` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_procs_per_minute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_procs_per_minute_mod`
--

DROP TABLE IF EXISTS `spell_procs_per_minute_mod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_procs_per_minute_mod` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Type` tinyint unsigned NOT NULL DEFAULT '0',
  `Param` int NOT NULL DEFAULT '0',
  `Coeff` float NOT NULL DEFAULT '0',
  `SpellProcsPerMinuteID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_procs_per_minute_mod`
--

LOCK TABLES `spell_procs_per_minute_mod` WRITE;
/*!40000 ALTER TABLE `spell_procs_per_minute_mod` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_procs_per_minute_mod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_radius`
--

DROP TABLE IF EXISTS `spell_radius`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_radius` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Radius` float NOT NULL DEFAULT '0',
  `RadiusPerLevel` float NOT NULL DEFAULT '0',
  `RadiusMin` float NOT NULL DEFAULT '0',
  `RadiusMax` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_radius`
--

LOCK TABLES `spell_radius` WRITE;
/*!40000 ALTER TABLE `spell_radius` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_radius` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_range`
--

DROP TABLE IF EXISTS `spell_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_range` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DisplayName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `DisplayNameShort` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `RangeMin1` float NOT NULL DEFAULT '0',
  `RangeMin2` float NOT NULL DEFAULT '0',
  `RangeMax1` float NOT NULL DEFAULT '0',
  `RangeMax2` float NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_range`
--

LOCK TABLES `spell_range` WRITE;
/*!40000 ALTER TABLE `spell_range` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_range` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_range_locale`
--

DROP TABLE IF EXISTS `spell_range_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_range_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `DisplayName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `DisplayNameShort_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_range_locale`
--

LOCK TABLES `spell_range_locale` WRITE;
/*!40000 ALTER TABLE `spell_range_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_range_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_reagents`
--

DROP TABLE IF EXISTS `spell_reagents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_reagents` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `Reagent1` int NOT NULL DEFAULT '0',
  `Reagent2` int NOT NULL DEFAULT '0',
  `Reagent3` int NOT NULL DEFAULT '0',
  `Reagent4` int NOT NULL DEFAULT '0',
  `Reagent5` int NOT NULL DEFAULT '0',
  `Reagent6` int NOT NULL DEFAULT '0',
  `Reagent7` int NOT NULL DEFAULT '0',
  `Reagent8` int NOT NULL DEFAULT '0',
  `ReagentCount1` smallint NOT NULL DEFAULT '0',
  `ReagentCount2` smallint NOT NULL DEFAULT '0',
  `ReagentCount3` smallint NOT NULL DEFAULT '0',
  `ReagentCount4` smallint NOT NULL DEFAULT '0',
  `ReagentCount5` smallint NOT NULL DEFAULT '0',
  `ReagentCount6` smallint NOT NULL DEFAULT '0',
  `ReagentCount7` smallint NOT NULL DEFAULT '0',
  `ReagentCount8` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_reagents`
--

LOCK TABLES `spell_reagents` WRITE;
/*!40000 ALTER TABLE `spell_reagents` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_reagents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_scaling`
--

DROP TABLE IF EXISTS `spell_scaling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_scaling` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `Class` int NOT NULL DEFAULT '0',
  `MinScalingLevel` int unsigned NOT NULL DEFAULT '0',
  `MaxScalingLevel` int unsigned NOT NULL DEFAULT '0',
  `ScalesFromItemLevel` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_scaling`
--

LOCK TABLES `spell_scaling` WRITE;
/*!40000 ALTER TABLE `spell_scaling` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_scaling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_shapeshift`
--

DROP TABLE IF EXISTS `spell_shapeshift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_shapeshift` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `StanceBarOrder` tinyint NOT NULL DEFAULT '0',
  `ShapeshiftExclude1` int NOT NULL DEFAULT '0',
  `ShapeshiftExclude2` int NOT NULL DEFAULT '0',
  `ShapeshiftMask1` int NOT NULL DEFAULT '0',
  `ShapeshiftMask2` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_shapeshift`
--

LOCK TABLES `spell_shapeshift` WRITE;
/*!40000 ALTER TABLE `spell_shapeshift` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_shapeshift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_shapeshift_form`
--

DROP TABLE IF EXISTS `spell_shapeshift_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_shapeshift_form` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `CreatureType` tinyint NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `AttackIconFileID` int NOT NULL DEFAULT '0',
  `BonusActionBar` tinyint NOT NULL DEFAULT '0',
  `CombatRoundTime` smallint NOT NULL DEFAULT '0',
  `DamageVariance` float NOT NULL DEFAULT '0',
  `MountTypeID` smallint unsigned NOT NULL DEFAULT '0',
  `CreatureDisplayID1` int unsigned NOT NULL DEFAULT '0',
  `CreatureDisplayID2` int unsigned NOT NULL DEFAULT '0',
  `CreatureDisplayID3` int unsigned NOT NULL DEFAULT '0',
  `CreatureDisplayID4` int unsigned NOT NULL DEFAULT '0',
  `PresetSpellID1` int unsigned NOT NULL DEFAULT '0',
  `PresetSpellID2` int unsigned NOT NULL DEFAULT '0',
  `PresetSpellID3` int unsigned NOT NULL DEFAULT '0',
  `PresetSpellID4` int unsigned NOT NULL DEFAULT '0',
  `PresetSpellID5` int unsigned NOT NULL DEFAULT '0',
  `PresetSpellID6` int unsigned NOT NULL DEFAULT '0',
  `PresetSpellID7` int unsigned NOT NULL DEFAULT '0',
  `PresetSpellID8` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_shapeshift_form`
--

LOCK TABLES `spell_shapeshift_form` WRITE;
/*!40000 ALTER TABLE `spell_shapeshift_form` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_shapeshift_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_shapeshift_form_locale`
--

DROP TABLE IF EXISTS `spell_shapeshift_form_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_shapeshift_form_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_shapeshift_form_locale`
--

LOCK TABLES `spell_shapeshift_form_locale` WRITE;
/*!40000 ALTER TABLE `spell_shapeshift_form_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_shapeshift_form_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_target_restrictions`
--

DROP TABLE IF EXISTS `spell_target_restrictions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_target_restrictions` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `ConeDegrees` float NOT NULL DEFAULT '0',
  `MaxTargets` tinyint unsigned NOT NULL DEFAULT '0',
  `MaxTargetLevel` int unsigned NOT NULL DEFAULT '0',
  `TargetCreatureType` smallint NOT NULL DEFAULT '0',
  `Targets` int NOT NULL DEFAULT '0',
  `Width` float NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_target_restrictions`
--

LOCK TABLES `spell_target_restrictions` WRITE;
/*!40000 ALTER TABLE `spell_target_restrictions` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_target_restrictions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_totems`
--

DROP TABLE IF EXISTS `spell_totems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_totems` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int NOT NULL DEFAULT '0',
  `RequiredTotemCategoryID1` smallint unsigned NOT NULL DEFAULT '0',
  `RequiredTotemCategoryID2` smallint unsigned NOT NULL DEFAULT '0',
  `Totem1` int NOT NULL DEFAULT '0',
  `Totem2` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_totems`
--

LOCK TABLES `spell_totems` WRITE;
/*!40000 ALTER TABLE `spell_totems` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_totems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_visual_kit`
--

DROP TABLE IF EXISTS `spell_visual_kit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_visual_kit` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `FallbackPriority` tinyint NOT NULL DEFAULT '0',
  `FallbackSpellVisualKitId` int NOT NULL DEFAULT '0',
  `DelayMin` smallint unsigned NOT NULL DEFAULT '0',
  `DelayMax` smallint unsigned NOT NULL DEFAULT '0',
  `Flags1` int NOT NULL DEFAULT '0',
  `Flags2` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_visual_kit`
--

LOCK TABLES `spell_visual_kit` WRITE;
/*!40000 ALTER TABLE `spell_visual_kit` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_visual_kit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spell_x_spell_visual`
--

DROP TABLE IF EXISTS `spell_x_spell_visual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_x_spell_visual` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `DifficultyID` tinyint unsigned NOT NULL DEFAULT '0',
  `SpellVisualID` int unsigned NOT NULL DEFAULT '0',
  `Probability` float NOT NULL DEFAULT '0',
  `Priority` tinyint unsigned NOT NULL DEFAULT '0',
  `SpellIconFileID` int NOT NULL DEFAULT '0',
  `ActiveIconFileID` int NOT NULL DEFAULT '0',
  `ViewerUnitConditionID` smallint unsigned NOT NULL DEFAULT '0',
  `ViewerPlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `CasterUnitConditionID` smallint unsigned NOT NULL DEFAULT '0',
  `CasterPlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spell_x_spell_visual`
--

LOCK TABLES `spell_x_spell_visual` WRITE;
/*!40000 ALTER TABLE `spell_x_spell_visual` DISABLE KEYS */;
/*!40000 ALTER TABLE `spell_x_spell_visual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summon_properties`
--

DROP TABLE IF EXISTS `summon_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summon_properties` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Control` int NOT NULL DEFAULT '0',
  `Faction` int NOT NULL DEFAULT '0',
  `Title` int NOT NULL DEFAULT '0',
  `Slot` int NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summon_properties`
--

LOCK TABLES `summon_properties` WRITE;
/*!40000 ALTER TABLE `summon_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `summon_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tact_key`
--

DROP TABLE IF EXISTS `tact_key`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tact_key` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Key1` tinyint unsigned NOT NULL DEFAULT '0',
  `Key2` tinyint unsigned NOT NULL DEFAULT '0',
  `Key3` tinyint unsigned NOT NULL DEFAULT '0',
  `Key4` tinyint unsigned NOT NULL DEFAULT '0',
  `Key5` tinyint unsigned NOT NULL DEFAULT '0',
  `Key6` tinyint unsigned NOT NULL DEFAULT '0',
  `Key7` tinyint unsigned NOT NULL DEFAULT '0',
  `Key8` tinyint unsigned NOT NULL DEFAULT '0',
  `Key9` tinyint unsigned NOT NULL DEFAULT '0',
  `Key10` tinyint unsigned NOT NULL DEFAULT '0',
  `Key11` tinyint unsigned NOT NULL DEFAULT '0',
  `Key12` tinyint unsigned NOT NULL DEFAULT '0',
  `Key13` tinyint unsigned NOT NULL DEFAULT '0',
  `Key14` tinyint unsigned NOT NULL DEFAULT '0',
  `Key15` tinyint unsigned NOT NULL DEFAULT '0',
  `Key16` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tact_key`
--

LOCK TABLES `tact_key` WRITE;
/*!40000 ALTER TABLE `tact_key` DISABLE KEYS */;
/*!40000 ALTER TABLE `tact_key` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talent`
--

DROP TABLE IF EXISTS `talent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `talent` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `TierID` tinyint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `ColumnIndex` tinyint unsigned NOT NULL DEFAULT '0',
  `ClassID` tinyint unsigned NOT NULL DEFAULT '0',
  `SpecID` smallint unsigned NOT NULL DEFAULT '0',
  `SpellID` int unsigned NOT NULL DEFAULT '0',
  `OverridesSpellID` int unsigned NOT NULL DEFAULT '0',
  `CategoryMask1` tinyint unsigned NOT NULL DEFAULT '0',
  `CategoryMask2` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talent`
--

LOCK TABLES `talent` WRITE;
/*!40000 ALTER TABLE `talent` DISABLE KEYS */;
/*!40000 ALTER TABLE `talent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talent_locale`
--

DROP TABLE IF EXISTS `talent_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `talent_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talent_locale`
--

LOCK TABLES `talent_locale` WRITE;
/*!40000 ALTER TABLE `talent_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `talent_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxi_nodes`
--

DROP TABLE IF EXISTS `taxi_nodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taxi_nodes` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `PosX` float NOT NULL DEFAULT '0',
  `PosY` float NOT NULL DEFAULT '0',
  `PosZ` float NOT NULL DEFAULT '0',
  `MapOffsetX` float NOT NULL DEFAULT '0',
  `MapOffsetY` float NOT NULL DEFAULT '0',
  `FlightMapOffsetX` float NOT NULL DEFAULT '0',
  `FlightMapOffsetY` float NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ContinentID` smallint unsigned NOT NULL DEFAULT '0',
  `ConditionID` int NOT NULL DEFAULT '0',
  `CharacterBitNumber` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `UiTextureKitID` int NOT NULL DEFAULT '0',
  `MinimapAtlasMemberID` int NOT NULL DEFAULT '0',
  `Facing` float NOT NULL DEFAULT '0',
  `SpecialIconConditionID` int unsigned NOT NULL DEFAULT '0',
  `VisibilityConditionID` int unsigned NOT NULL DEFAULT '0',
  `MountCreatureID1` int NOT NULL DEFAULT '0',
  `MountCreatureID2` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxi_nodes`
--

LOCK TABLES `taxi_nodes` WRITE;
/*!40000 ALTER TABLE `taxi_nodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `taxi_nodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxi_nodes_locale`
--

DROP TABLE IF EXISTS `taxi_nodes_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taxi_nodes_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxi_nodes_locale`
--

LOCK TABLES `taxi_nodes_locale` WRITE;
/*!40000 ALTER TABLE `taxi_nodes_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `taxi_nodes_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxi_path`
--

DROP TABLE IF EXISTS `taxi_path`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taxi_path` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `FromTaxiNode` smallint unsigned NOT NULL DEFAULT '0',
  `ToTaxiNode` smallint unsigned NOT NULL DEFAULT '0',
  `Cost` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxi_path`
--

LOCK TABLES `taxi_path` WRITE;
/*!40000 ALTER TABLE `taxi_path` DISABLE KEYS */;
/*!40000 ALTER TABLE `taxi_path` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxi_path_node`
--

DROP TABLE IF EXISTS `taxi_path_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taxi_path_node` (
  `LocX` float NOT NULL DEFAULT '0',
  `LocY` float NOT NULL DEFAULT '0',
  `LocZ` float NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PathID` smallint unsigned NOT NULL DEFAULT '0',
  `NodeIndex` int NOT NULL DEFAULT '0',
  `ContinentID` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `Delay` int unsigned NOT NULL DEFAULT '0',
  `ArrivalEventID` int NOT NULL DEFAULT '0',
  `DepartureEventID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxi_path_node`
--

LOCK TABLES `taxi_path_node` WRITE;
/*!40000 ALTER TABLE `taxi_path_node` DISABLE KEYS */;
/*!40000 ALTER TABLE `taxi_path_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `totem_category`
--

DROP TABLE IF EXISTS `totem_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `totem_category` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `TotemCategoryType` tinyint unsigned NOT NULL DEFAULT '0',
  `TotemCategoryMask` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `totem_category`
--

LOCK TABLES `totem_category` WRITE;
/*!40000 ALTER TABLE `totem_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `totem_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `totem_category_locale`
--

DROP TABLE IF EXISTS `totem_category_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `totem_category_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `totem_category_locale`
--

LOCK TABLES `totem_category_locale` WRITE;
/*!40000 ALTER TABLE `totem_category_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `totem_category_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toy`
--

DROP TABLE IF EXISTS `toy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toy` (
  `SourceText` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ItemID` int NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `SourceTypeEnum` tinyint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toy`
--

LOCK TABLES `toy` WRITE;
/*!40000 ALTER TABLE `toy` DISABLE KEYS */;
/*!40000 ALTER TABLE `toy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toy_locale`
--

DROP TABLE IF EXISTS `toy_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toy_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SourceText_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toy_locale`
--

LOCK TABLES `toy_locale` WRITE;
/*!40000 ALTER TABLE `toy_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `toy_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmog_holiday`
--

DROP TABLE IF EXISTS `transmog_holiday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transmog_holiday` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `RequiredTransmogHoliday` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmog_holiday`
--

LOCK TABLES `transmog_holiday` WRITE;
/*!40000 ALTER TABLE `transmog_holiday` DISABLE KEYS */;
/*!40000 ALTER TABLE `transmog_holiday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmog_illusion`
--

DROP TABLE IF EXISTS `transmog_illusion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transmog_illusion` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `UnlockConditionID` int NOT NULL DEFAULT '0',
  `TransmogCost` int NOT NULL DEFAULT '0',
  `SpellItemEnchantmentID` int NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmog_illusion`
--

LOCK TABLES `transmog_illusion` WRITE;
/*!40000 ALTER TABLE `transmog_illusion` DISABLE KEYS */;
/*!40000 ALTER TABLE `transmog_illusion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmog_set`
--

DROP TABLE IF EXISTS `transmog_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transmog_set` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ClassMask` int NOT NULL DEFAULT '0',
  `TrackingQuestID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `TransmogSetGroupID` int unsigned NOT NULL DEFAULT '0',
  `ItemNameDescriptionID` int NOT NULL DEFAULT '0',
  `ParentTransmogSetID` smallint unsigned NOT NULL DEFAULT '0',
  `Unknown810` tinyint unsigned NOT NULL DEFAULT '0',
  `ExpansionID` tinyint unsigned NOT NULL DEFAULT '0',
  `PatchID` int NOT NULL DEFAULT '0',
  `UiOrder` smallint NOT NULL DEFAULT '0',
  `PlayerConditionID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmog_set`
--

LOCK TABLES `transmog_set` WRITE;
/*!40000 ALTER TABLE `transmog_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `transmog_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmog_set_group`
--

DROP TABLE IF EXISTS `transmog_set_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transmog_set_group` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmog_set_group`
--

LOCK TABLES `transmog_set_group` WRITE;
/*!40000 ALTER TABLE `transmog_set_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `transmog_set_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmog_set_group_locale`
--

DROP TABLE IF EXISTS `transmog_set_group_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transmog_set_group_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmog_set_group_locale`
--

LOCK TABLES `transmog_set_group_locale` WRITE;
/*!40000 ALTER TABLE `transmog_set_group_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `transmog_set_group_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmog_set_item`
--

DROP TABLE IF EXISTS `transmog_set_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transmog_set_item` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `TransmogSetID` int unsigned NOT NULL DEFAULT '0',
  `ItemModifiedAppearanceID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmog_set_item`
--

LOCK TABLES `transmog_set_item` WRITE;
/*!40000 ALTER TABLE `transmog_set_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `transmog_set_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmog_set_locale`
--

DROP TABLE IF EXISTS `transmog_set_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transmog_set_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmog_set_locale`
--

LOCK TABLES `transmog_set_locale` WRITE;
/*!40000 ALTER TABLE `transmog_set_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `transmog_set_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport_animation`
--

DROP TABLE IF EXISTS `transport_animation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transport_animation` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PosX` float NOT NULL DEFAULT '0',
  `PosY` float NOT NULL DEFAULT '0',
  `PosZ` float NOT NULL DEFAULT '0',
  `SequenceID` tinyint unsigned NOT NULL DEFAULT '0',
  `TimeIndex` int unsigned NOT NULL DEFAULT '0',
  `TransportID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport_animation`
--

LOCK TABLES `transport_animation` WRITE;
/*!40000 ALTER TABLE `transport_animation` DISABLE KEYS */;
/*!40000 ALTER TABLE `transport_animation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport_rotation`
--

DROP TABLE IF EXISTS `transport_rotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transport_rotation` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Rot1` float NOT NULL DEFAULT '0',
  `Rot2` float NOT NULL DEFAULT '0',
  `Rot3` float NOT NULL DEFAULT '0',
  `Rot4` float NOT NULL DEFAULT '0',
  `TimeIndex` int unsigned NOT NULL DEFAULT '0',
  `GameObjectsID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport_rotation`
--

LOCK TABLES `transport_rotation` WRITE;
/*!40000 ALTER TABLE `transport_rotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `transport_rotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ui_map`
--

DROP TABLE IF EXISTS `ui_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ui_map` (
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ParentUiMapID` int NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `System` int NOT NULL DEFAULT '0',
  `Type` int NOT NULL DEFAULT '0',
  `BountySetID` int NOT NULL DEFAULT '0',
  `BountyDisplayLocation` int unsigned NOT NULL DEFAULT '0',
  `VisibilityPlayerConditionID` int NOT NULL DEFAULT '0',
  `HelpTextPosition` tinyint NOT NULL DEFAULT '0',
  `BkgAtlasID` int NOT NULL DEFAULT '0',
  `AlternateUiMapGroup` int NOT NULL DEFAULT '0',
  `ContentTuningID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ui_map`
--

LOCK TABLES `ui_map` WRITE;
/*!40000 ALTER TABLE `ui_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `ui_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ui_map_assignment`
--

DROP TABLE IF EXISTS `ui_map_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ui_map_assignment` (
  `UiMinX` float NOT NULL DEFAULT '0',
  `UiMinY` float NOT NULL DEFAULT '0',
  `UiMaxX` float NOT NULL DEFAULT '0',
  `UiMaxY` float NOT NULL DEFAULT '0',
  `Region1X` float NOT NULL DEFAULT '0',
  `Region1Y` float NOT NULL DEFAULT '0',
  `Region1Z` float NOT NULL DEFAULT '0',
  `Region2X` float NOT NULL DEFAULT '0',
  `Region2Y` float NOT NULL DEFAULT '0',
  `Region2Z` float NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `UiMapID` int NOT NULL DEFAULT '0',
  `OrderIndex` int NOT NULL DEFAULT '0',
  `MapID` int NOT NULL DEFAULT '0',
  `AreaID` int NOT NULL DEFAULT '0',
  `WmoDoodadPlacementID` int NOT NULL DEFAULT '0',
  `WmoGroupID` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ui_map_assignment`
--

LOCK TABLES `ui_map_assignment` WRITE;
/*!40000 ALTER TABLE `ui_map_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `ui_map_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ui_map_link`
--

DROP TABLE IF EXISTS `ui_map_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ui_map_link` (
  `UiMinX` float NOT NULL DEFAULT '0',
  `UiMinY` float NOT NULL DEFAULT '0',
  `UiMaxX` float NOT NULL DEFAULT '0',
  `UiMaxY` float NOT NULL DEFAULT '0',
  `ID` int unsigned NOT NULL DEFAULT '0',
  `ParentUiMapID` int NOT NULL DEFAULT '0',
  `OrderIndex` int NOT NULL DEFAULT '0',
  `ChildUiMapID` int NOT NULL DEFAULT '0',
  `OverrideHighlightFileDataID` int NOT NULL DEFAULT '0',
  `OverrideHighlightAtlasID` int NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ui_map_link`
--

LOCK TABLES `ui_map_link` WRITE;
/*!40000 ALTER TABLE `ui_map_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `ui_map_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ui_map_locale`
--

DROP TABLE IF EXISTS `ui_map_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ui_map_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ui_map_locale`
--

LOCK TABLES `ui_map_locale` WRITE;
/*!40000 ALTER TABLE `ui_map_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `ui_map_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ui_map_x_map_art`
--

DROP TABLE IF EXISTS `ui_map_x_map_art`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ui_map_x_map_art` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `PhaseID` int NOT NULL DEFAULT '0',
  `UiMapArtID` int NOT NULL DEFAULT '0',
  `UiMapID` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ui_map_x_map_art`
--

LOCK TABLES `ui_map_x_map_art` WRITE;
/*!40000 ALTER TABLE `ui_map_x_map_art` DISABLE KEYS */;
/*!40000 ALTER TABLE `ui_map_x_map_art` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_power_bar`
--

DROP TABLE IF EXISTS `unit_power_bar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit_power_bar` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Cost` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `OutOfError` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ToolTip` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `MinPower` int unsigned NOT NULL DEFAULT '0',
  `MaxPower` int unsigned NOT NULL DEFAULT '0',
  `StartPower` int unsigned NOT NULL DEFAULT '0',
  `CenterPower` tinyint unsigned NOT NULL DEFAULT '0',
  `RegenerationPeace` float NOT NULL DEFAULT '0',
  `RegenerationCombat` float NOT NULL DEFAULT '0',
  `BarType` tinyint unsigned NOT NULL DEFAULT '0',
  `Flags` smallint unsigned NOT NULL DEFAULT '0',
  `StartInset` float NOT NULL DEFAULT '0',
  `EndInset` float NOT NULL DEFAULT '0',
  `FileDataID1` int NOT NULL DEFAULT '0',
  `FileDataID2` int NOT NULL DEFAULT '0',
  `FileDataID3` int NOT NULL DEFAULT '0',
  `FileDataID4` int NOT NULL DEFAULT '0',
  `FileDataID5` int NOT NULL DEFAULT '0',
  `FileDataID6` int NOT NULL DEFAULT '0',
  `Color1` int NOT NULL DEFAULT '0',
  `Color2` int NOT NULL DEFAULT '0',
  `Color3` int NOT NULL DEFAULT '0',
  `Color4` int NOT NULL DEFAULT '0',
  `Color5` int NOT NULL DEFAULT '0',
  `Color6` int NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_power_bar`
--

LOCK TABLES `unit_power_bar` WRITE;
/*!40000 ALTER TABLE `unit_power_bar` DISABLE KEYS */;
/*!40000 ALTER TABLE `unit_power_bar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_power_bar_locale`
--

DROP TABLE IF EXISTS `unit_power_bar_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit_power_bar_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `Cost_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `OutOfError_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ToolTip_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_power_bar_locale`
--

LOCK TABLES `unit_power_bar_locale` WRITE;
/*!40000 ALTER TABLE `unit_power_bar_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `unit_power_bar_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `updates`
--

DROP TABLE IF EXISTS `updates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `updates` (
  `name` varchar(200) NOT NULL COMMENT 'filename with extension of the update.',
  `hash` char(40) DEFAULT '' COMMENT 'sha1 hash of the sql file.',
  `state` enum('RELEASED','ARCHIVED') NOT NULL DEFAULT 'RELEASED' COMMENT 'defines if an update is released or archived.',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'timestamp when the query was applied.',
  `speed` int unsigned NOT NULL DEFAULT '0' COMMENT 'time the query takes to apply in ms.',
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='List of all applied updates in this database.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `updates`
--

LOCK TABLES `updates` WRITE;
/*!40000 ALTER TABLE `updates` DISABLE KEYS */;
/*!40000 ALTER TABLE `updates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `updates_include`
--

DROP TABLE IF EXISTS `updates_include`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `updates_include` (
  `path` varchar(200) NOT NULL COMMENT 'directory to include. $ means relative to the source directory.',
  `state` enum('RELEASED','ARCHIVED') NOT NULL DEFAULT 'RELEASED' COMMENT 'defines if the directory contains released or archived updates.',
  PRIMARY KEY (`path`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='List of directories where we want to include sql updates.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `updates_include`
--

LOCK TABLES `updates_include` WRITE;
/*!40000 ALTER TABLE `updates_include` DISABLE KEYS */;
INSERT INTO `updates_include` VALUES ('$/sql/old/8.x/hotfixes','ARCHIVED');
/*!40000 ALTER TABLE `updates_include` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `FlagsB` tinyint unsigned NOT NULL DEFAULT '0',
  `TurnSpeed` float NOT NULL DEFAULT '0',
  `PitchSpeed` float NOT NULL DEFAULT '0',
  `PitchMin` float NOT NULL DEFAULT '0',
  `PitchMax` float NOT NULL DEFAULT '0',
  `MouseLookOffsetPitch` float NOT NULL DEFAULT '0',
  `CameraFadeDistScalarMin` float NOT NULL DEFAULT '0',
  `CameraFadeDistScalarMax` float NOT NULL DEFAULT '0',
  `CameraPitchOffset` float NOT NULL DEFAULT '0',
  `FacingLimitRight` float NOT NULL DEFAULT '0',
  `FacingLimitLeft` float NOT NULL DEFAULT '0',
  `CameraYawOffset` float NOT NULL DEFAULT '0',
  `VehicleUIIndicatorID` smallint unsigned NOT NULL DEFAULT '0',
  `MissileTargetingID` int NOT NULL DEFAULT '0',
  `VehiclePOITypeID` smallint unsigned NOT NULL DEFAULT '0',
  `SeatID1` smallint unsigned NOT NULL DEFAULT '0',
  `SeatID2` smallint unsigned NOT NULL DEFAULT '0',
  `SeatID3` smallint unsigned NOT NULL DEFAULT '0',
  `SeatID4` smallint unsigned NOT NULL DEFAULT '0',
  `SeatID5` smallint unsigned NOT NULL DEFAULT '0',
  `SeatID6` smallint unsigned NOT NULL DEFAULT '0',
  `SeatID7` smallint unsigned NOT NULL DEFAULT '0',
  `SeatID8` smallint unsigned NOT NULL DEFAULT '0',
  `PowerDisplayID1` smallint unsigned NOT NULL DEFAULT '0',
  `PowerDisplayID2` smallint unsigned NOT NULL DEFAULT '0',
  `PowerDisplayID3` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_seat`
--

DROP TABLE IF EXISTS `vehicle_seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_seat` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `AttachmentOffsetX` float NOT NULL DEFAULT '0',
  `AttachmentOffsetY` float NOT NULL DEFAULT '0',
  `AttachmentOffsetZ` float NOT NULL DEFAULT '0',
  `CameraOffsetX` float NOT NULL DEFAULT '0',
  `CameraOffsetY` float NOT NULL DEFAULT '0',
  `CameraOffsetZ` float NOT NULL DEFAULT '0',
  `Flags` int NOT NULL DEFAULT '0',
  `FlagsB` int NOT NULL DEFAULT '0',
  `FlagsC` int NOT NULL DEFAULT '0',
  `AttachmentID` tinyint NOT NULL DEFAULT '0',
  `EnterPreDelay` float NOT NULL DEFAULT '0',
  `EnterSpeed` float NOT NULL DEFAULT '0',
  `EnterGravity` float NOT NULL DEFAULT '0',
  `EnterMinDuration` float NOT NULL DEFAULT '0',
  `EnterMaxDuration` float NOT NULL DEFAULT '0',
  `EnterMinArcHeight` float NOT NULL DEFAULT '0',
  `EnterMaxArcHeight` float NOT NULL DEFAULT '0',
  `EnterAnimStart` int NOT NULL DEFAULT '0',
  `EnterAnimLoop` int NOT NULL DEFAULT '0',
  `RideAnimStart` int NOT NULL DEFAULT '0',
  `RideAnimLoop` int NOT NULL DEFAULT '0',
  `RideUpperAnimStart` int NOT NULL DEFAULT '0',
  `RideUpperAnimLoop` int NOT NULL DEFAULT '0',
  `ExitPreDelay` float NOT NULL DEFAULT '0',
  `ExitSpeed` float NOT NULL DEFAULT '0',
  `ExitGravity` float NOT NULL DEFAULT '0',
  `ExitMinDuration` float NOT NULL DEFAULT '0',
  `ExitMaxDuration` float NOT NULL DEFAULT '0',
  `ExitMinArcHeight` float NOT NULL DEFAULT '0',
  `ExitMaxArcHeight` float NOT NULL DEFAULT '0',
  `ExitAnimStart` int NOT NULL DEFAULT '0',
  `ExitAnimLoop` int NOT NULL DEFAULT '0',
  `ExitAnimEnd` int NOT NULL DEFAULT '0',
  `VehicleEnterAnim` smallint NOT NULL DEFAULT '0',
  `VehicleEnterAnimBone` tinyint NOT NULL DEFAULT '0',
  `VehicleExitAnim` smallint NOT NULL DEFAULT '0',
  `VehicleExitAnimBone` tinyint NOT NULL DEFAULT '0',
  `VehicleRideAnimLoop` smallint NOT NULL DEFAULT '0',
  `VehicleRideAnimLoopBone` tinyint NOT NULL DEFAULT '0',
  `PassengerAttachmentID` tinyint NOT NULL DEFAULT '0',
  `PassengerYaw` float NOT NULL DEFAULT '0',
  `PassengerPitch` float NOT NULL DEFAULT '0',
  `PassengerRoll` float NOT NULL DEFAULT '0',
  `VehicleEnterAnimDelay` float NOT NULL DEFAULT '0',
  `VehicleExitAnimDelay` float NOT NULL DEFAULT '0',
  `VehicleAbilityDisplay` tinyint NOT NULL DEFAULT '0',
  `EnterUISoundID` int unsigned NOT NULL DEFAULT '0',
  `ExitUISoundID` int unsigned NOT NULL DEFAULT '0',
  `UiSkinFileDataID` int NOT NULL DEFAULT '0',
  `CameraEnteringDelay` float NOT NULL DEFAULT '0',
  `CameraEnteringDuration` float NOT NULL DEFAULT '0',
  `CameraExitingDelay` float NOT NULL DEFAULT '0',
  `CameraExitingDuration` float NOT NULL DEFAULT '0',
  `CameraPosChaseRate` float NOT NULL DEFAULT '0',
  `CameraFacingChaseRate` float NOT NULL DEFAULT '0',
  `CameraEnteringZoom` float NOT NULL DEFAULT '0',
  `CameraSeatZoomMin` float NOT NULL DEFAULT '0',
  `CameraSeatZoomMax` float NOT NULL DEFAULT '0',
  `EnterAnimKitID` smallint NOT NULL DEFAULT '0',
  `RideAnimKitID` smallint NOT NULL DEFAULT '0',
  `ExitAnimKitID` smallint NOT NULL DEFAULT '0',
  `VehicleEnterAnimKitID` smallint NOT NULL DEFAULT '0',
  `VehicleRideAnimKitID` smallint NOT NULL DEFAULT '0',
  `VehicleExitAnimKitID` smallint NOT NULL DEFAULT '0',
  `CameraModeID` smallint NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_seat`
--

LOCK TABLES `vehicle_seat` WRITE;
/*!40000 ALTER TABLE `vehicle_seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wmo_area_table`
--

DROP TABLE IF EXISTS `wmo_area_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wmo_area_table` (
  `AreaName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `ID` int unsigned NOT NULL DEFAULT '0',
  `WmoID` smallint unsigned NOT NULL DEFAULT '0',
  `NameSetID` tinyint unsigned NOT NULL DEFAULT '0',
  `WmoGroupID` int NOT NULL DEFAULT '0',
  `SoundProviderPref` tinyint unsigned NOT NULL DEFAULT '0',
  `SoundProviderPrefUnderwater` tinyint unsigned NOT NULL DEFAULT '0',
  `AmbienceID` smallint unsigned NOT NULL DEFAULT '0',
  `UwAmbience` smallint unsigned NOT NULL DEFAULT '0',
  `ZoneMusic` smallint unsigned NOT NULL DEFAULT '0',
  `UwZoneMusic` int unsigned NOT NULL DEFAULT '0',
  `IntroSound` smallint unsigned NOT NULL DEFAULT '0',
  `UwIntroSound` smallint unsigned NOT NULL DEFAULT '0',
  `AreaTableID` smallint unsigned NOT NULL DEFAULT '0',
  `Flags` tinyint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wmo_area_table`
--

LOCK TABLES `wmo_area_table` WRITE;
/*!40000 ALTER TABLE `wmo_area_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `wmo_area_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wmo_area_table_locale`
--

DROP TABLE IF EXISTS `wmo_area_table_locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wmo_area_table_locale` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `locale` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `AreaName_lang` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`locale`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
/*!50500 PARTITION BY LIST  COLUMNS(locale)
(PARTITION deDE VALUES IN ('deDE') ENGINE = InnoDB,
 PARTITION esES VALUES IN ('esES') ENGINE = InnoDB,
 PARTITION esMX VALUES IN ('esMX') ENGINE = InnoDB,
 PARTITION frFR VALUES IN ('frFR') ENGINE = InnoDB,
 PARTITION itIT VALUES IN ('itIT') ENGINE = InnoDB,
 PARTITION koKR VALUES IN ('koKR') ENGINE = InnoDB,
 PARTITION ptBR VALUES IN ('ptBR') ENGINE = InnoDB,
 PARTITION ruRU VALUES IN ('ruRU') ENGINE = InnoDB,
 PARTITION zhCN VALUES IN ('zhCN') ENGINE = InnoDB,
 PARTITION zhTW VALUES IN ('zhTW') ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wmo_area_table_locale`
--

LOCK TABLES `wmo_area_table_locale` WRITE;
/*!40000 ALTER TABLE `wmo_area_table_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `wmo_area_table_locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `world_effect`
--

DROP TABLE IF EXISTS `world_effect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `world_effect` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `QuestFeedbackEffectID` int unsigned NOT NULL DEFAULT '0',
  `WhenToDisplay` tinyint unsigned NOT NULL DEFAULT '0',
  `TargetType` tinyint NOT NULL DEFAULT '0',
  `TargetAsset` int NOT NULL DEFAULT '0',
  `PlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `CombatConditionID` smallint unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `world_effect`
--

LOCK TABLES `world_effect` WRITE;
/*!40000 ALTER TABLE `world_effect` DISABLE KEYS */;
/*!40000 ALTER TABLE `world_effect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `world_map_overlay`
--

DROP TABLE IF EXISTS `world_map_overlay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `world_map_overlay` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `UiMapArtID` int unsigned NOT NULL DEFAULT '0',
  `TextureWidth` smallint unsigned NOT NULL DEFAULT '0',
  `TextureHeight` smallint unsigned NOT NULL DEFAULT '0',
  `OffsetX` int NOT NULL DEFAULT '0',
  `OffsetY` int NOT NULL DEFAULT '0',
  `HitRectTop` int NOT NULL DEFAULT '0',
  `HitRectBottom` int NOT NULL DEFAULT '0',
  `HitRectLeft` int NOT NULL DEFAULT '0',
  `HitRectRight` int NOT NULL DEFAULT '0',
  `PlayerConditionID` int unsigned NOT NULL DEFAULT '0',
  `Flags` int unsigned NOT NULL DEFAULT '0',
  `AreaID1` int unsigned NOT NULL DEFAULT '0',
  `AreaID2` int unsigned NOT NULL DEFAULT '0',
  `AreaID3` int unsigned NOT NULL DEFAULT '0',
  `AreaID4` int unsigned NOT NULL DEFAULT '0',
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `world_map_overlay`
--

LOCK TABLES `world_map_overlay` WRITE;
/*!40000 ALTER TABLE `world_map_overlay` DISABLE KEYS */;
/*!40000 ALTER TABLE `world_map_overlay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `world_state_expression`
--

DROP TABLE IF EXISTS `world_state_expression`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `world_state_expression` (
  `ID` int unsigned NOT NULL DEFAULT '0',
  `Expression` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `VerifiedBuild` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`,`VerifiedBuild`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `world_state_expression`
--

LOCK TABLES `world_state_expression` WRITE;
/*!40000 ALTER TABLE `world_state_expression` DISABLE KEYS */;
/*!40000 ALTER TABLE `world_state_expression` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-06  4:16:58