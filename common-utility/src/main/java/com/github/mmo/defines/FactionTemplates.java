package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum FactionTemplates {
    FACTION_NONE(0),
    FACTION_CREATURE(7),
    FACTION_ESCORTEE_A_NEUTRAL_PASSIVE(10),
    FACTION_MONSTER(14),
    FACTION_MONSTER_2(16),
    FACTION_TROLL_BLOODSCALP(28),
    FACTION_PREY(31),
    FACTION_ESCORTEE_H_NEUTRAL_PASSIVE(33),
    FACTION_FRIENDLY(35),
    FACTION_TROLL_FROSTMANE(37),
    FACTION_OGRE(45),
    FACTION_ORC_DRAGONMAW(62),
    FACTION_HORDE_GENERIC(83),
    FACTION_ALLIANCE_GENERIC(84),
    FACTION_DEMON(90),
    FACTION_ELEMENTAL(91),
    FACTION_DRAGONFLIGHT_BLACK(103),
    FACTION_ESCORTEE_N_NEUTRAL_PASSIVE(113),
    FACTION_ENEMY(168),
    FACTION_ESCORTEE_A_NEUTRAL_ACTIVE(231),
    FACTION_ESCORTEE_H_NEUTRAL_ACTIVE(232), FACTION_ESCORTEE_N_NEUTRAL_ACTIVE(250), FACTION_ESCORTEE_N_FRIEND_PASSIVE(290), FACTION_TITAN(415), FACTION_ESCORTEE_N_FRIEND_ACTIVE(495), FACTION_RATCHET(637), FACTION_GOBLIN_DARK_IRON_BAR_PATRON(736), FACTION_DARK_IRON_DWARVES(754), FACTION_ESCORTEE_A_PASSIVE(774), FACTION_ESCORTEE_H_PASSIVE(775), FACTION_UNDEAD_SCOURGE(974), FACTION_EARTHEN_RING(1726), FACTION_ALLIANCE_GENERIC_WG(1732), FACTION_HORDE_GENERIC_WG(1735), FACTION_ARAKKOA(1738), FACTION_ASHTONGUE_DEATHSWORN(1820), FACTION_FLAYER_HUNTER(1840), FACTION_MONSTER_SPAR_BUDDY(1868), FACTION_ESCORTEE_N_ACTIVE(1986), FACTION_ESCORTEE_H_ACTIVE(2046), FACTION_UNDEAD_SCOURGE_2(2068), FACTION_UNDEAD_SCOURGE_3(2084), FACTION_SCARLET_CRUSADE(2089), FACTION_SCARLET_CRUSADE_2(2096);

    public final int value;

}