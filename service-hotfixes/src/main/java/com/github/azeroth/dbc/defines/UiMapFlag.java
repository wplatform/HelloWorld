package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum UiMapFlag implements EnumFlag.FlagValue {
    None(0),
    NoHighlight(0x00000001),
    ShowOverlays(0x00000002),
    ShowTaxiNodes(0x00000004),
    GarrisonMap(0x00000008),
    FallbackToParentMap(0x00000010),
    NoHighlightTexture(0x00000020),
    ShowTaskObjectives(0x00000040),
    NoWorldPositions(0x00000080),
    HideArchaeologyDigs(0x00000100),
    Deprecated(0x00000200),
    HideIcons(0x00000400),
    HideVignettes(0x00000800),
    ForceAllOverlayExplored(0x00001000),
    FlightMapShowZoomOut(0x00002000),
    FlightMapAutoZoom(0x00004000),
    ForceOnNavbar(0x00008000);

    public final int value;
}
