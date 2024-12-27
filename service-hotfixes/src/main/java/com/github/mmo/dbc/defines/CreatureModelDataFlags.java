package com.github.mmo.dbc.defines;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CreatureModelDataFlags {
    NoFootprintParticles(0x00001),
    NoBreathParticles(0x00002),
    IsPlayerModel(0x00004),
    NoAttachedWeapons(0x00010),
    NoFootprintTrailTextures(0x00020),
    DisableHighlight(0x00040),
    CanMountWhileTransformedAsThis(0x00080),
    DisableScaleInterpolation(0x00100),
    ForceProjectedTex(0x00200),
    CanJumpInPlaceAsMount(0x00400),
    AICannotUseWalkBackwardsAnim(0x00800),
    IgnoreSpineLowForSplitBody(0x01000),
    IgnoreHeadForSplitBody(0x02000),
    IgnoreSpineLowForSplitBodyWhenFlying(0x04000),
    IgnoreHeadForSplitBodyWhenFlying(0x08000),
    UseWheelAnimationOnUnitWheelBones(0x10000),
    IsHDModel(0x20000),
    SuppressEmittersOnLowSettings(0x40000);

    public final int value;
}
