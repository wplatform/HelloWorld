package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

// QuestSort.dbc (9.0.2.37176)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum QuestSort {
    EPIC(1),
    HALLOWS_END(21),
    SEASONAL(22),
    CATACLYSM(23),
    HERBALISM(24),
    BATTLEGROUNDS(25),
    DAY_OF_THE_DEAD(41),
    WARLOCK(61),
    WARRIOR(81),
    SHAMAN(82),
    FISHING(101),
    BLACKSMITHING(121),
    PALADIN(141),
    MAGE(161),
    ROGUE(162),
    ALCHEMY(181),
    LEATHERWORKING(182),
    ENGINEERING(201),
    TREASURE_MAP(221),
    TOURNAMENT(241),
    HUNTER(261),
    PRIEST(262),
    DRUID(263),
    TAILORING(264),
    SPECIAL(284),
    COOKING(304),
    FIRST_AID(324),
    LEGENDARY(344),
    DARKMOON_FAIRE(364),
    AHN_QIRAJ_WAR(365),
    LUNAR_FESTIVAL(366),
    REPUTATION(367),
    INVASION(368),
    MIDSUMMER(369),
    BREWFEST(370),
    INSCRIPTION(371),
    DEATH_KNIGHT(372),
    JEWELCRAFTING(373),
    NOBLEGARDEN(374),
    PILGRIMS_BOUNTY(375),
    LOVE_IS_IN_THE_AIR(376),
    ARCHAEOLOGY(377),
    CHILDRENS_WEEK(378),
    FIRELANDS_INVASION(379),
    THE_ZANDALARI(380),
    ELEMENTAL_BONDS(381),
    PANDAREN_BREWMASTER(391),
    SCENARIO(392),
    BATTLE_PETS(394),
    MONK(395),
    LANDFALL(396),
    PANDAREN_CAMPAIGN(397),
    RIDING(398),
    BRAWLERS_GUILD(399),
    PROVING_GROUNDS(400),
    GARRISON_CAMPAIGN(401),
    ASSAULT_ON_THE_DARK_PORTAL(402),
    GARRISON_SUPPORT(403),
    LOGGING(404),
    PICKPOCKETING(405),
    ARTIFACT(406),
    DEMON_HUNTER(407),
    MINING(408),
    WEEKEND_EVENT(409),
    ENCHANTING(410),
    SKINNING(411),
    WORLD_QUEST(412),
    DEATH_KNIGHT_CAMPAIGN(413),
    DEMON_HUNTER_CAMPAIGN(416),
    DRUID_CAMPAIGN(417),
    HUNTER_CAMPAIGN(418),
    MONK_CAMPAIGN(419),
    MAGE_CAMPAIGN(420),
    PRIEST_CAMPAIGN(421),
    PALADIN_CAMPAIGN(422),
    SHAMAN_CAMPAIGN(423),
    ROGUE_CAMPAIGN(424),
    WARLOCK_CAMPAIGN(425),
    WARRIOR_CAMPAIGN(426),
    ORDER_HALL(427),
    LEGIONFALL_CAMPAIGN(428),
    THE_HUNT_FOR_ILLIDAN_STORMRAGE(429),
    PIRATES_DAY(430),
    ARGUS_EXPEDITION(431),
    WARFRONTS(432),
    MOONKIN_FESTIVAL(433),
    THE_KINGS_PATH(434),
    THE_DEATHS_OF_CHROMIE(435),
    ROCKET_CHICKEN(436),
    LIGHTFORGED_DRAENEI(437),
    HIGHMOUNTAIN_TAUREN(438),
    VOID_ELF(439),
    NIGHTBORNE(440),
    DUNGEON(441),
    RAID(442),
    ALLIED_RACES(444),
    THE_WARCHIEFS_AGENDA(445),
    ADVENTURE_JOURNEY(446),
    ALLIANCE_WAR_CAMPAIGN(447),
    HORDE_WAR_CAMPAIGN(448),
    DARK_IRON_DWARF(449),
    MAGHAR_ORC(450),
    THE_SHADOW_HUNTER(451),
    ISLAND_EXPEDITIONS(453),
    WORLD_PVP(555),
    THE_PRIDE_OF_KUL_TIRAS(556),
    RATED_PVP(557),
    ZANDALARI_TROLL(559),
    HERITAGE(560),
    QUESTFALL(561),
    TYRANDES_VENGEANCE(562),
    THE_FATE_OF_SAURFANG(563),
    FREE_TSHIRT_DAY(564),
    CRUCIBLE_OF_STORMS(565),
    KUL_TIRAN(566),
    ASSAULT(567),
    HEART_OF_AZEROTH(569),
    PROFESSIONS(571),
    NAZJATAR_FOLLOWERS(573),
    SINFALL(574),
    KORRAKS_REVENGE(575),
    COVENANT_SANCTUM(576),
    REFER_A_FRIEND(579),
    VISIONS_OF_NZOTH(580),
    VULPERA(582),
    MECHAGNOME(583),
    BLACK_EMPIRE_CAMPAIGN(584),
    EMBER_COURT(586),
    THROUGH_THE_SHATTERED_SKY(587),
    DEATH_RISING(588),
    KYRIAN_CALLINGS(589),
    NIGHT_FAE_CALLINGS(590),
    NECROLORD_CALLINGS(591),
    VENTHYR_CALLINGS(592),
    ABOMINABLE_STITCHING(593),
    TIMEWALKING_CAMPAIGN(594),
    PATH_OF_ASCENSION(595),
    LEGENDARY_CRAFTING(596),
    CAMPAIGN_9_1(600),
    CYPHERS_OF_THE_FIRST_ONES(601),
    ZERETH_MORTIS_CAMPAIGN(602),
    THE_ARCHIVISTS_CODEX(603),
    COVENANT_ASSAULTS(604),
    PROTOFORM_SYNTHESIS(606),
    CH_6_SYMBOL_TRACKING(607);

    public final int value;

    public static QuestSort valueOf(int value) {
        return Arrays.stream(QuestSort.values()).filter(e->e.value == value).findFirst().orElse(null);
    }
}