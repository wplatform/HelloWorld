package com.github.mmo.game.map.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class ZoneAndAreaId {
    public final int zoneId;
    public final int areaId;
}
