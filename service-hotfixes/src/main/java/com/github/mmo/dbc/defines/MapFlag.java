package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MapFlag implements EnumFlag.FlagValue {
    Optimize(0x00000001),
    DevelopmentMap(0x00000002),
    WeightedBlend(0x00000004),
    VertexColoring(0x00000008),
    SortObjects(0x00000010),
    LimitToPlayersFromOneRealm(0x00000020),
    EnableLighting(0x00000040),
    InvertedTerrain(0x00000080),
    DynamicDifficulty(0x00000100),
    ObjectFile(0x00000200),
    TextureFile(0x00000400),
    GenerateNormals(0x00000800),
    FixBorderShadowSeams(0x00001000),
    InfiniteOcean(0x00002000),
    UnderwaterMap(0x00004000),
    FlexibleRaidLocking(0x00008000),
    LimitFarclip(0x00010000),
    UseParentMapFlightBounds(0x00020000),
    NoRaceChangeOnThisMap(0x00040000),
    DisabledForNonGMs(0x00080000),
    WeightedNormals1(0x00100000),
    DisableLowDetailTerrain(0x00200000),
    EnableOrgArenaBlinkRule(0x00400000),
    WeightedHeightBlend(0x00800000),
    CoalescingAreaSharing(0x01000000),
    ProvingGrounds(0x02000000),
    Garrison(0x04000000),
    EnableAINeedSystem(0x08000000),
    SingleVServer(0x10000000),
    UseInstancePool(0x20000000),
    MapUsesRaidGraphics(0x40000000),
    ForceCustomUIMap(0x80000000);
    public final int value;
}
