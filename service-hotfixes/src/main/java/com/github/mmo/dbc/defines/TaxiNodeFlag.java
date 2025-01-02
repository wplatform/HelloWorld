package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TaxiNodeFlag implements EnumFlag.FlagValue {

    ShowOnAllianceMap           (0x00000001),
    ShowOnHordeMap              (0x00000002),
    ShowOnMapBorder             (0x00000004),
    ShowIfClientPassesCondition (0x00000008),
    UsePlayerFavoriteMount      (0x00000010),
    EndPointPnly                (0x00000020),
    IgnoreForFindNearest        (0x00000040),
    DoNotShowInWorldMapUI       (0x00000080);

    public final int value;
}
