package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SummonPropertyFlag implements EnumFlag.FlagValue {
    None(0x00000000),
    AttackSummoner(0x00000001), // NYI
    HelpWhenSummonedInCombat(0x00000002), // NYI
    UseLevelOffset(0x00000004), // NYI
    DespawnOnSummonerDeath(0x00000008), // NYI
    OnlyVisibleToSummoner(0x00000010),
    CannotDismissPet(0x00000020), // NYI
    UseDemonTimeout(0x00000040), // NYI
    UnlimitedSummons(0x00000080), // NYI
    UseCreatureLevel(0x00000100),
    JoinSummonerSpawnGroup(0x00000200), // NYI
    DoNotToggle(0x00000400), // NYI
    DespawnWhenExpired(0x00000800), // NYI
    UseSummonerFaction(0x00001000),
    DoNotFollowMountedSummoner(0x00002000), // NYI
    SavePetAutocast(0x00004000), // NYI
    IgnoreSummonerPhase(0x00008000), // Wild Only
    OnlyVisibleToSummonerGroup(0x00010000),
    DespawnOnSummonerLogout(0x00020000), // NYI
    CastRideVehicleSpellOnSummoner(0x00040000), // NYI
    GuardianActsLikePet(0x00080000), // NYI
    DontSnapSessileToGround(0x00100000), // NYI
    SummonFromBattlePetJournal(0x00200000),
    UnitClutter(0x00400000), // NYI
    DefaultNameColor(0x00800000), // NYI
    UseOwnInvisibilityDetection(0x01000000), // NYI. Ignore Owner's Invisibility Detection
    DespawnWhenReplaced(0x02000000), // NYI. Totem Slots Only
    DespawnWhenTeleportingOutOfRange(0x04000000), // NYI
    SummonedAtGroupFormationPosition(0x08000000), // NYI
    DontDespawnOnSummonerDeath(0x10000000), // NYI
    UseTitleAsCreatureName(0x20000000), // NYI
    AttackableBySummoner(0x40000000), // NYI
    DontDismissWhenEncounterIsAborted(0x80000000);  // NYI

    public final int value;
}
