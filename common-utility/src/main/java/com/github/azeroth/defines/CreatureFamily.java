package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

// CreatureFamily.dbc (9.0.2.37176)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CreatureFamily {
    NONE(0),
    WOLF(1),
    CAT(2),
    SPIDER(3),
    BEAR(4),
    BOAR(5),
    CROCOLISK(6),
    CARRION_BIRD(7),
    CRAB(8),
    GORILLA(9),
    RAPTOR(11),
    TALLSTRIDER(12),
    FELHUNTER(15),
    VOIDWALKER(16),
    SUCCUBUS(17),
    DOOMGUARD(19),
    SCORPID(20),
    TURTLE(21),
    IMP(23),
    BAT(24),
    HYENA(25),
    BIRD_OF_PREY(26),
    WIND_SERPENT(27),
    REMOTE_CONTROL(28),
    FELGUARD(29),
    DRAGONHAWK(30),
    RAVAGER(31),
    WARP_STALKER(32),
    SPOREBAT(33),
    RAY(34),
    SERPENT(35),
    MOTH(37),
    CHIMAERA(38),
    DEVILSAUR(39),
    GHOUL(40),
    AQIRI(41),
    WORM(42),
    CLEFTHOOF(43),
    WASP(44),
    CORE_HOUND(45),
    SPIRIT_BEAST(46),
    WATER_ELEMENTAL(49),
    FOX(50),
    MONKEY(51),
    HOUND(52),
    BEETLE(53),
    SHALE_BEAST(55),
    ZOMBIE(56),
    QA_TEST(57),
    HYDRA(68),
    FELIMP(100),
    VOIDLORD(101),
    SHIVARA(102),
    OBSERVER(103),
    WRATHGUARD(104),
    INFERNAL(108),
    FIREELEMENTAL(116),
    EARTHELEMENTAL(117),
    CRANE(125),
    WATERSTRIDER(126),
    RODENT(127),
    STONE_HOUND(128),
    GRUFFHORN(129),
    BASILISK(130),
    DIREHORN(138),
    STORMELEMENTAL(145),
    TORRORGUARD(147),
    ABYSSAL(148),
    RIVERBEAST(150),
    STAG(151),
    MECHANICAL(154),
    ABOMINATION(155),
    SCALEHIDE(156),
    OXEN(157),
    FEATHERMANE(160),
    LIZARD(288),
    PTERRORDAX(290),
    TOAD(291),
    CARAPID(292),
    BLOOD_BEAST(296),
    CAMEL(298),
    COURSER(299),
    MAMMOTH(300),
    INCUBUS(302);
    public final int value;
}