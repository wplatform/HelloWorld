package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellEffectAttributes implements EnumFlag.FlagValue {
    None(0),
    NoImmunity(0x000001), // not cancelled by immunities
    PositionIsFacingRelative(0x000002), /*NYI*/
    JumpChargeUnitMeleeRange(0x000004), /*NYI*/
    JumpChargeUnitStrictPathCheck(0x000008), /*NYI*/
    ExcludeOwnParty(0x000010), /*NYI*/
    AlwaysAoeLineOfSight(0x000020),
    SuppressPointsStacking(0x000040),
    ChainFromInitialTarget(0x000080),
    UncontrolledNoBackwards(0x000100), /*NYI*/
    AuraPointsStack(0x000200), /*NYI*/ // refreshing periodic auras with this attribute will add remaining damage to new aura
    NoCopyDamageInterruptsOrProcs(0x000400), /*NYI*/
    AddTargetCombatReachToAOE(0x000800), /*NYI*/
    IsHarmful(0x001000),
    ForceScaleToOverrideCameraMinHeight(0x002000), /*NYI*/
    PlayersOnly(0x004000),
    ComputePointsOnlyAtCastTime(0x008000), /*NYI*/
    EnforceLineOfSightToChainTargets(0x010000),
    AreaEffectsUseTargetRadius(0x020000), /*NYI*/
    TeleportWithVehicle(0x040000), /*NYI*/
    ScalePointsByChallengeModeDamageScaler(0x080000), /*NYI*/
    DontFailSpellOnTargetingFailure(0x100000), /*NYI*/
    IgnoreDuringCooldownTimeRateCalculation(0x800000); /*NYI*/

    public final int value;
}
