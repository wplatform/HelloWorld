package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MapFlag2 implements EnumFlag.FlagValue {
    DontActivateShowMap(0x00000001),
    NoVoteKicks(0x00000002),
    NoIncomingTransfers(0x00000004),
    DontVoxelizePathData(0x00000008),
    TerrainLOD(0x00000010),
    UnclampedPointLights(0x00000020),
    PVP(0x00000040),
    IgnoreInstanceFarmLimit(0x00000080),
    DontInheritAreaLightsFromParent(0x00000100),
    ForceLightBufferOn(0x00000200),
    WMOLiquidScale(0x00000400),
    SpellClutterOn(0x00000800),
    SpellClutterOff(0x00001000),
    ReducedPathMapHeightValidation(0x00002000),
    NewMinimapGeneration(0x00004000),
    AIBotsDetectedLikePlayers(0x00008000),
    LinearlyLitTerrain(0x00010000),
    FogOfWar(0x00020000),
    DisableSharedWeatherSystems(0x00040000),
    HonorSpellAttribute11LosHitsNocamcollide(0x00080000),
    BelongsToLayer(0x00100000);

    public final int value;
}
