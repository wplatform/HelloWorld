package com.github.azeroth.defines;

import lombok.RequiredArgsConstructor;

// Emotes.db2 (9.0.2.37176)
// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor
public enum Emote {
    EMOTE_ONESHOT_NONE(0),
    EMOTE_ONESHOT_TALK(1),
    EMOTE_ONESHOT_BOW(2),
    EMOTE_ONESHOT_WAVE(3),
    EMOTE_ONESHOT_CHEER(4),
    EMOTE_ONESHOT_EXCLAMATION(5),
    EMOTE_ONESHOT_QUESTION(6),
    EMOTE_ONESHOT_EAT(7),
    EMOTE_STATE_DANCE(10),
    EMOTE_ONESHOT_LAUGH(11),
    EMOTE_STATE_SLEEP(12),
    EMOTE_STATE_SIT(13),
    EMOTE_ONESHOT_RUDE(14),
    EMOTE_ONESHOT_ROAR(15),
    EMOTE_ONESHOT_KNEEL(16),
    EMOTE_ONESHOT_KISS(17),
    EMOTE_ONESHOT_CRY(18),
    EMOTE_ONESHOT_CHICKEN(19),
    EMOTE_ONESHOT_BEG(20),
    EMOTE_ONESHOT_APPLAUD(21),
    EMOTE_ONESHOT_SHOUT(22),
    EMOTE_ONESHOT_FLEX(23),
    EMOTE_ONESHOT_SHY(24),
    EMOTE_ONESHOT_POINT(25),
    EMOTE_STATE_STAND(26),
    EMOTE_STATE_READY_UNARMED(27),
    EMOTE_STATE_WORK_SHEATHED(28),
    EMOTE_STATE_POINT(29),
    EMOTE_STATE_NONE(30),
    EMOTE_ONESHOT_WOUND(33),
    EMOTE_ONESHOT_WOUND_CRITICAL(34),
    EMOTE_ONESHOT_ATTACK_UNARMED(35),
    EMOTE_ONESHOT_ATTACK1H(36),
    EMOTE_ONESHOT_ATTACK2HTIGHT(37),
    EMOTE_ONESHOT_ATTACK2H_LOOSE(38),
    EMOTE_ONESHOT_PARRY_UNARMED(39),
    EMOTE_ONESHOT_PARRY_SHIELD(43),
    EMOTE_ONESHOT_READY_UNARMED(44),
    EMOTE_ONESHOT_READY1H(45),
    EMOTE_ONESHOT_READY_BOW(48),
    EMOTE_ONESHOT_SPELL_PRECAST(50),
    EMOTE_ONESHOT_SPELL_CAST(51),
    EMOTE_ONESHOT_BATTLE_ROAR(53),
    EMOTE_ONESHOT_SPECIALATTACK1H(54),
    EMOTE_ONESHOT_KICK(60),
    EMOTE_ONESHOT_ATTACK_THROWN(61),
    EMOTE_STATE_STUN(64),
    EMOTE_STATE_DEAD(65),
    EMOTE_ONESHOT_SALUTE(66),
    EMOTE_STATE_KNEEL(68),
    EMOTE_STATE_USE_STANDING(69),
    EMOTE_ONESHOT_WAVE_NO_SHEATHE(70),
    EMOTE_ONESHOT_CHEER_NO_SHEATHE(71),
    EMOTE_ONESHOT_EAT_NO_SHEATHE(92),
    EMOTE_STATE_STUN_NO_SHEATHE(93),
    EMOTE_ONESHOT_DANCE(94),
    EMOTE_ONESHOT_SALUTE_NO_SHEATH(113),
    EMOTE_STATE_USE_STANDING_NO_SHEATHE(133),
    EMOTE_ONESHOT_LAUGH_NO_SHEATHE(153),
    EMOTE_STATE_WORK(173),
    EMOTE_STATE_SPELL_PRECAST(193),
    EMOTE_ONESHOT_READY_RIFLE(213),
    EMOTE_STATE_READY_RIFLE(214),
    EMOTE_STATE_WORK_MINING(233),
    EMOTE_STATE_WORK_CHOPWOOD(234),
    EMOTE_STATE_APPLAUD(253),
    EMOTE_ONESHOT_LIFTOFF(254),
    EMOTE_ONESHOT_YES(273),
    EMOTE_ONESHOT_NO(274),
    EMOTE_ONESHOT_TRAIN(275),
    EMOTE_ONESHOT_LAND(293),
    EMOTE_STATE_AT_EASE(313),
    EMOTE_STATE_READY1H(333),
    EMOTE_STATE_SPELL_KNEEL_START(353),
    EMOTE_STATE_SUBMERGED(373),
    EMOTE_ONESHOT_SUBMERGE(374),
    EMOTE_STATE_READY2H(375),
    EMOTE_STATE_READY_BOW(376),
    EMOTE_ONESHOT_MOUNT_SPECIAL(377),
    EMOTE_STATE_TALK(378),
    EMOTE_STATE_FISHING(379),
    EMOTE_ONESHOT_FISHING(380),
    EMOTE_ONESHOT_LOOT(381),
    EMOTE_STATE_WHIRLWIND(382),
    EMOTE_STATE_DROWNED(383),
    EMOTE_STATE_HOLD_BOW(384),
    EMOTE_STATE_HOLD_RIFLE(385),
    EMOTE_STATE_HOLD_THROWN(386),
    EMOTE_ONESHOT_DROWN(387),
    EMOTE_ONESHOT_STOMP(388),
    EMOTE_ONESHOT_ATTACK_OFF(389),
    EMOTE_ONESHOT_ATTACK_OFF_PIERCE(390),
    EMOTE_STATE_ROAR(391),
    EMOTE_STATE_LAUGH(392),
    EMOTE_ONESHOT_CREATURE_SPECIAL(393),
    EMOTE_ONESHOT_JUMPLANDRUN(394),
    EMOTE_ONESHOT_JUMPEND(395),
    EMOTE_ONESHOT_TALK_NO_SHEATHE(396),
    EMOTE_ONESHOT_POINT_NO_SHEATHE(397),
    EMOTE_STATE_CANNIBALIZE(398),
    EMOTE_ONESHOT_JUMPSTART(399),
    EMOTE_STATE_DANCESPECIAL(400),
    EMOTE_ONESHOT_DANCESPECIAL(401),
    EMOTE_ONESHOT_CUSTOM_SPELL_01(402),
    EMOTE_ONESHOT_CUSTOM_SPELL_02(403),
    EMOTE_ONESHOT_CUSTOM_SPELL_03(404),
    EMOTE_ONESHOT_CUSTOM_SPELL_04(405),
    EMOTE_ONESHOT_CUSTOM_SPELL_05(406),
    EMOTE_ONESHOT_CUSTOM_SPELL_06(407),
    EMOTE_ONESHOT_CUSTOM_SPELL_07(408),
    EMOTE_ONESHOT_CUSTOM_SPELL_08(409),
    EMOTE_ONESHOT_CUSTOM_SPELL_09(410),
    EMOTE_ONESHOT_CUSTOM_SPELL_10(411),
    EMOTE_STATE_EXCLAIM(412),
    EMOTE_STATE_DANCE_CUSTOM(413),
    EMOTE_STATE_SIT_CHAIR_MED(415),
    EMOTE_STATE_CUSTOM_SPELL_01(416),
    EMOTE_STATE_CUSTOM_SPELL_02(417),
    EMOTE_STATE_EAT(418),
    EMOTE_STATE_CUSTOM_SPELL_04(419),
    EMOTE_STATE_CUSTOM_SPELL_03(420),
    EMOTE_STATE_CUSTOM_SPELL_05(421),
    EMOTE_STATE_SPELLEFFECT_HOLD(422),
    EMOTE_STATE_EAT_NO_SHEATHE(423),
    EMOTE_STATE_MOUNT(424),
    EMOTE_STATE_READY2HL(425),
    EMOTE_STATE_SIT_CHAIR_HIGH(426),
    EMOTE_STATE_FALL(427),
    EMOTE_STATE_LOOT(428),
    EMOTE_STATE_SUBMERGED_NEW(429),
    EMOTE_ONESHOT_COWER(430),
    EMOTE_STATE_COWER(431),
    EMOTE_ONESHOT_USE_STANDING(432),
    EMOTE_STATE_STEALTH_STAND(433),
    EMOTE_ONESHOT_OMNICAST_GHOUL(434),
    EMOTE_ONESHOT_ATTACK_BOW(435),
    EMOTE_ONESHOT_ATTACK_RIFLE(436),
    EMOTE_STATE_SWIM_IDLE(437),
    EMOTE_STATE_ATTACK_UNARMED(438),
    EMOTE_ONESHOT_SPELL_CAST_W_SOUND(439),
    EMOTE_ONESHOT_DODGE(440),
    EMOTE_ONESHOT_PARRY1H(441),
    EMOTE_ONESHOT_PARRY2H(442),
    EMOTE_ONESHOT_PARRY2HL(443),
    EMOTE_STATE_FLYFALL(444),
    EMOTE_ONESHOT_FLYDEATH(445),
    EMOTE_STATE_FLY_FALL(446),
    EMOTE_ONESHOT_FLY_SIT_GROUND_DOWN(447),
    EMOTE_ONESHOT_FLY_SIT_GROUND_UP(448),
    EMOTE_ONESHOT_EMERGE(449),
    EMOTE_ONESHOT_DRAGON_SPIT(450),
    EMOTE_STATE_SPECIAL_UNARMED(451),
    EMOTE_ONESHOT_FLYGRAB(452),
    EMOTE_STATE_FLYGRABCLOSED(453),
    EMOTE_ONESHOT_FLYGRABTHROWN(454),
    EMOTE_STATE_FLY_SIT_GROUND(455),
    EMOTE_STATE_WALK_BACKWARDS(456),
    EMOTE_ONESHOT_FLYTALK(457),
    EMOTE_ONESHOT_FLYATTACK1H(458),
    EMOTE_STATE_CUSTOM_SPELL_08(459),
    EMOTE_ONESHOT_FLY_DRAGON_SPIT(460),
    EMOTE_STATE_SIT_CHAIR_LOW(461),
    EMOTE_ONESHOT_STUN(462),
    EMOTE_ONESHOT_SPELL_CAST_OMNI(463),
    EMOTE_STATE_READY_THROWN(465),
    EMOTE_ONESHOT_WORK_CHOPWOOD(466),
    EMOTE_ONESHOT_WORK_MINING(467),
    EMOTE_STATE_SPELL_CHANNEL_OMNI(468),
    EMOTE_STATE_SPELL_CHANNEL_DIRECTED(469),
    EMOTE_STAND_STATE_NONE(470),
    EMOTE_STATE_READYJOUST(471),
    EMOTE_STATE_STRANGULATE(472),
    EMOTE_STATE_STRANGULATE2(473),
    EMOTE_STATE_READY_SPELL_OMNI(474),
    EMOTE_STATE_HOLD_JOUST(475),
    EMOTE_ONESHOT_CRY_JAINA(476),
    EMOTE_ONESHOT_SPECIAL_UNARMED(477),
    EMOTE_STATE_DANCE_NOSHEATHE(478),
    EMOTE_ONESHOT_SNIFF(479),
    EMOTE_ONESHOT_DRAGONSTOMP(480),
    EMOTE_ONESHOT_KNOCKDOWN(482),
    EMOTE_STATE_READ(483),
    EMOTE_ONESHOT_FLYEMOTETALK(485),
    EMOTE_STATE_READ_ALLOWMOVEMENT(492),
    EMOTE_STATE_CUSTOM_SPELL_06(498),
    EMOTE_STATE_CUSTOM_SPELL_07(499),
    EMOTE_STATE_CUSTOM_SPELL_08_2(500),
    EMOTE_STATE_CUSTOM_SPELL_09(501),
    EMOTE_STATE_CUSTOM_SPELL_10(502),
    EMOTE_STATE_READY1H_ALLOW_MOVEMENT(505),
    EMOTE_STATE_READY2H_ALLOW_MOVEMENT(506),
    EMOTE_ONESHOT_MONKOFFENSE_ATTACKUNARMED(507),
    EMOTE_ONESHOT_MONKOFFENSE_SPECIALUNARMED(508),
    EMOTE_ONESHOT_MONKOFFENSE_PARRYUNARMED(509),
    EMOTE_STATE_MONKOFFENSE_READYUNARMED(510),
    EMOTE_ONESHOT_PALMSTRIKE(511),
    EMOTE_STATE_CRANE(512),
    EMOTE_ONESHOT_OPEN(517),
    EMOTE_STATE_READ_CHRISTMAS(518),
    EMOTE_ONESHOT_FLYATTACK2HL(526),
    EMOTE_ONESHOT_FLYATTACKTHROWN(527),
    EMOTE_STATE_FLYREADYSPELLDIRECTED(528),
    EMOTE_STATE_FLY_READY_1H(531),
    EMOTE_STATE_MEDITATE(533),
    EMOTE_STATE_FLY_READY_2HL(534),
    EMOTE_ONESHOT_TOGROUND(535),
    EMOTE_ONESHOT_TOFLY(536),
    EMOTE_STATE_ATTACKTHROWN(537),
    EMOTE_STATE_SPELL_CHANNEL_DIRECTED_NOSOUND(538),
    EMOTE_ONESHOT_WORK(539),
    EMOTE_STATE_READYUNARMED_NOSOUND(540),
    EMOTE_ONESHOT_MONKOFFENSE_ATTACKUNARMEDOFF(543),
    EMOTE_RECLINED_MOUNT_PASSENGER(546),
    EMOTE_ONESHOT_QUESTION_2(547),
    EMOTE_ONESHOT_SPELL_CHANNEL_DIRECTED_NOSOUND(549),
    EMOTE_STATE_KNEEL_2(550),
    EMOTE_ONESHOT_FLYATTACKUNARMED(551),
    EMOTE_ONESHOT_FLYCOMBATWOUND(552),
    EMOTE_ONESHOT_MOUNTSELFSPECIAL(553),
    EMOTE_ONESHOT_ATTACKUNARMED_NOSOUND(554),
    EMOTE_STATE_WOUNDCRITICAL_DOESNT_WORK(555),
    EMOTE_ONESHOT_ATTACK1H_NO_SOUND(556),
    EMOTE_STATE_MOUNT_SELF_IDLE(557),
    EMOTE_ONESHOT_WALK(558),
    EMOTE_STATE_OPENED(559),
    EMOTE_STATE_CUSTOMSPELL03(564),
    EMOTE_ONESHOT_BREATHOFFIRE(565),
    EMOTE_STATE_ATTACK1H(567),
    EMOTE_STATE_WORK_CHOPWOOD_2(568),
    EMOTE_STATE_USESTANDING_LOOP(569),
    EMOTE_STATE_USESTANDING(572),
    EMOTE_ONESHOT_SHEATH(573),
    EMOTE_ONESHOT_LAUGH_NO_SOUND(574),
    EMOTE_RECLINED_MOUNT(575),
    EMOTE_ONESHOT_ATTACK1H_2(577),
    EMOTE_STATE_CRY_NOSOUND(578),
    EMOTE_ONESHOT_CRY_NOSOUND(579),
    EMOTE_ONESHOT_COMBATCRITICAL(584),
    EMOTE_STATE_TRAIN(585),
    EMOTE_STATE_WORK_CHOPWOOD_LUMBER_AXE(586),
    EMOTE_ONESHOT_SPECIALATTACK2H(587),
    EMOTE_STATE_READ_AND_TALK(588),
    EMOTE_ONESHOT_STAND_VAR1(589),
    EMOTE_REXXAR_STRANGLES_GOBLIN(590),
    EMOTE_ONESHOT_STAND_VAR2(591),
    EMOTE_ONESHOT_DEATH(592),
    EMOTE_STATE_TALKONCE(595),
    EMOTE_STATE_ATTACK2H(596),
    EMOTE_STATE_SIT_GROUND(598),
    EMOTE_STATE_WORK_CHOPWOOD3(599),
    EMOTE_STATE_CUSTOMSPELL01(601),
    EMOTE_ONESHOT_COMBATWOUND(602),
    EMOTE_ONESHOT_TALK_EXCLAMATION(603),
    EMOTE_ONESHOT_QUESTION2(604),
    EMOTE_STATE_CRY(605),
    EMOTE_STATE_USESTANDING_LOOP2(606),
    EMOTE_STATE_WORK_SMITH(613),
    EMOTE_STATE_WORK_CHOPWOOD4(614),
    EMOTE_STATE_CUSTOMSPELL02(615),
    EMOTE_STATE_READ_AND_SIT(616),
    EMOTE_STATE_PARRY_UNARMED(619),
    EMOTE_STATE_BLOCK_SHIELD(620),
    EMOTE_STATE_SIT_GROUND_2(621),
    EMOTE_ONESHOT_MOUNTSPECIAL(628),
    EMOTE_ONESHOT_SETTLE(636),
    EMOTE_STATE_ATTACK_UNARMED_STILL(638),
    EMOTE_STATE_READ_BOOK_AND_TALK(641),
    EMOTE_ONESHOT_SLAM(642),
    EMOTE_ONESHOT_GRABTHROWN(643),
    EMOTE_ONESHOT_READYSPELLDIRECTED_NOSOUND(644),
    EMOTE_STATE_READYSPELLOMNI_WITH_SOUND(645),
    EMOTE_ONESHOT_TALK_BARSERVER(646),
    EMOTE_ONESHOT_WAVE_BARSERVER(647),
    EMOTE_STATE_WORK_MINING2(648),
    EMOTE_STATE_READY2HL_ALLOW_MOVEMENT(654),
    EMOTE_STATE_USESTANDING_NOSHEATHE_STILL(655),
    EMOTE_ONESHOT_WORK_STILL(657),
    EMOTE_STATE_HOLD_THROWN_INTERRUPTS(658),
    EMOTE_ONESHOT_CANNIBALIZE(659),
    EMOTE_ONESHOT_NO_NOT_SWIMMING(661),
    EMOTE_STATE_READYGLV(663),
    EMOTE_ONESHOT_COMBATABILITYGLV01(664),
    EMOTE_ONESHOT_COMBATABILITYGLVOFF01(665),
    EMOTE_ONESHOT_COMBATABILITYGLVBIG02(666),
    EMOTE_ONESHOT_PARRYGLV(667),
    EMOTE_STATE_WORK_MINING3(668),
    EMOTE_ONESHOT_TALK_NOSHEATHE(669),
    EMOTE_ONESHOT_STAND_VAR3(671),
    EMOTE_STATE_KNEEL2(672),
    EMOTE_ONESHOT_CUSTOM0(673),
    EMOTE_ONESHOT_CUSTOM1(674),
    EMOTE_ONESHOT_CUSTOM2(675),
    EMOTE_ONESHOT_CUSTOM3(676),
    EMOTE_STATE_FLY_READY_UNARMED(677),
    EMOTE_ONESHOT_CHEER_FORTHEALLIANCE(679),
    EMOTE_ONESHOT_CHEER_FORTHEHORDE(680),
    EMOTE_ONESHOT_STAND_VAR4(690),
    EMOTE_ONESHOT_FLYEMOTEEXCLAMATION(691),
    EMOTE_STATE_EMOTEEAT(700),
    EMOTE_STATE_MONKHEAL_CHANNELOMNI(705),
    EMOTE_STATE_MONKDEFENSE_READYUNARMED(706),
    EMOTE_ONESHOT_STAND(707),
    EMOTE_STATE_WAPOURHOLD(709),
    EMOTE_STATE_READYBLOWDART(710),
    EMOTE_STATE_WORK_CHOPMEAT(711),
    EMOTE_STATE_MONK2HLIDLE(712),
    EMOTE_STATE_WAPERCH(713),
    EMOTE_STATE_WAGUARDSTAND01(714),
    EMOTE_STATE_READ_AND_SIT_CHAIR_MED(715),
    EMOTE_STATE_WAGUARDSTAND02(716),
    EMOTE_STATE_WAGUARDSTAND03(717),
    EMOTE_STATE_WAGUARDSTAND04(718),
    EMOTE_STATE_WACHANT02(719),
    EMOTE_STATE_WALEAN01(720),
    EMOTE_STATE_DRUNKWALK(721),
    EMOTE_STATE_WASCRUBBING(722),
    EMOTE_STATE_WACHANT01(723),
    EMOTE_STATE_WACHANT03(724),
    EMOTE_STATE_WASUMMON01(725),
    EMOTE_STATE_WATRANCE01(726),
    EMOTE_STATE_CUSTOMSPELL05(727),
    EMOTE_STATE_WAHAMMERLOOP(728),
    EMOTE_STATE_WABOUND01(729),
    EMOTE_STATE_WABOUND02(730),
    EMOTE_STATE_WASACKHOLD(731),
    EMOTE_STATE_WASIT01(732),
    EMOTE_STATE_WAROWINGSTANDLEFT(733),
    EMOTE_STATE_WAROWINGSTANDRIGHT(734),
    EMOTE_STATE_LOOT_BITE_SOUND(735),
    EMOTE_ONESHOT_WASUMMON01(736),
    EMOTE_ONESHOT_STAND_VAR2_2(737),
    EMOTE_ONESHOT_FALCONEER_START(738),
    EMOTE_STATE_FALCONEER_LOOP(739),
    EMOTE_ONESHOT_FALCONEER_END(740),
    EMOTE_STATE_WAPERCH_NOINTERACT(741),
    EMOTE_ONESHOT_WASTANDDRINK(742),
    EMOTE_STATE_WALEAN02(743),
    EMOTE_ONESHOT_READ_END(744),
    EMOTE_STATE_WAGUARDSTAND04_ALLOW_MOVEMENT(745),
    EMOTE_STATE_READYCROSSBOW(747),
    EMOTE_ONESHOT_WASTANDDRINK_NOSHEATH(748),
    EMOTE_STATE_WAHANG01(749),
    EMOTE_STATE_WABEGGARSTAND(750),
    EMOTE_STATE_WADRUNKSTAND(751),
    EMOTE_ONESHOT_WACRIERTALK(753),
    EMOTE_STATE_HOLD_CROSSBOW(754),
    EMOTE_STATE_WASIT02(757),
    EMOTE_STATE_WACRANKSTAND(761),
    EMOTE_ONESHOT_READ_START(762),
    EMOTE_ONESHOT_READ_LOOP(763),
    EMOTE_ONESHOT_WADRUNKDRINK(765),
    EMOTE_STATE_SIT_CHAIR_MED_EAT(766),
    EMOTE_STATE_KNEEL_COPY(867),
    EMOTE_STATE_WORK_CHOPMEAT_NOSHEATHE(868),
    EMOTE_ONESHOT_BARPATRON_POINT(870),
    EMOTE_STATE_STAND_NOSOUND(871),
    EMOTE_STATE_MOUNT_FLIGHT_IDLE_NOSOUND(872),
    EMOTE_STATE_USESTANDING_LOOP3(873),
    EMOTE_ONESHOT_VEHICLEGRAB(874),
    EMOTE_STATE_USESTANDING_LOOP4(875),
    EMOTE_STATE_BARPATRON_STAND(876),
    EMOTE_ONESHOT_WABEGGARPOINT(877),
    EMOTE_STATE_WACRIERSTAND01(878),
    EMOTE_ONESHOT_WABEGGARBEG(879),
    EMOTE_STATE_WABOATWHEELSTAND(880),
    EMOTE_STATE_WASIT03(882),
    EMOTE_STATE_BARSWEEP_STAND(883),
    EMOTE_STATE_WAGUARDSTAND05(884),
    EMOTE_STATE_WAGUARDSTAND06(885),
    EMOTE_STATE_BARTENDSTAND(886),
    EMOTE_STATE_WAHAMMERLOOP2(887),
    // EMOTE_STAND_STATE_STATE_READYTHROWN          = 890,  //< Doesn't work
    EMOTE_STATE_WORK_MINING_NO_COMBAT(893),
    EMOTE_ONESHOT_CASTSTRONG(894),
    EMOTE_STATE_CUSTOMSPELL07(895),
    EMOTE_STATE_WALK(897),
    EMOTE_ONESHOT_CLOSE(898),
    EMOTE_STATE_WACRATEHOLD(900),
    EMOTE_STATE_FLYCUSTOMSPELL02(901),
    EMOTE_ONESHOT_SLEEP(902),
    EMOTE_STATE_STAND_SETEMOTESTATE(903),
    EMOTE_ONESHOT_WAWALKTALK(904),
    EMOTE_ONESHOT_TAKE_OFF_FINISH(905),
    EMOTE_ONESHOT_ATTACK2H(906),
    EMOTE_STATE_WA_BARREL_HOLD(908),
    EMOTE_STATE_WA_BARREL_WALK(909),
    EMOTE_STATE_CUSTOMSPELL04(910),
    EMOTE_STATE_FLYWAPERCH01(912),
    EMOTE_ONESHOT_PALSPELLCAST1HUP(916),
    EMOTE_ONESHOT_READYSPELLOMNI(917),
    EMOTE_ONESHOT_SPELLCAST_DIRECTED(961),
    EMOTE_STATE_FLYCUSTOMSPELL07(977),
    EMOTE_STATE_FLYCHANNELCASTOMNI(978),
    EMOTE_STATE_CLOSED(979),
    EMOTE_STATE_CUSTOMSPELL10(980),
    EMOTE_STATE_WAWHEELBARROWSTAND(981),
    EMOTE_STATE_CUSTOMSPELL06(982),
    EMOTE_STATE_CUSTOM1(983),
    EMOTE_STATE_WASIT04(986),
    EMOTE_ONESHOT_BARSWEEP_STAND(987),
    EMOTE_TORGHAST_TALKING_HEAD_MAW_CAST_SOUND(989),
    EMOTE_TORGHAST_TALKING_HEAD_MAW_CAST_SOUND2(990);

    public final int value;
}