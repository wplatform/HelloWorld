package com.github.mmo.dbc.defines;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ChrSpecialization {
    None(0),
    MageArcane(62),
    MageFire(63),
    MageFrost(64),
    PaladinHoly(65),
    PaladinProtection(66),
    PaladinRetribution(70),
    WarriorArms(71),
    WarriorFury(72),
    WarriorProtection(73),
    DruidBalance(102),
    DruidFeral(103),
    DruidGuardian(104),
    DruidRestoration(105),
    DeathKnightBlood(250),
    DeathKnightFrost(251),
    DeathKnightUnholy(252),
    HunterBeastMastery(253),
    HunterMarksmanship(254),
    HunterSurvival(255),
    PriestDiscipline(256),
    PriestHoly(257),
    PriestShadow(258),
    RogueAssassination(259),
    RogueOutlaw(260),
    RogueSubtely(261),
    ShamanElemental(262),
    ShamanEnhancement(263),
    ShamanRestoration(264),
    WarlockAffliction(265),
    WarlockDemonology(266),
    WarlockDestruction(267),
    MonkBrewmaster(268),
    MonkWindwalker(269),
    MonkMistweaver(270),
    DemonHunterHavoc(577),
    DemonHunterVengeance(581),
    EvokerDevastation(1467),
    EvokerPreservation(1468),
    EvokerAugmentation(1473);

    public final int value;
}
