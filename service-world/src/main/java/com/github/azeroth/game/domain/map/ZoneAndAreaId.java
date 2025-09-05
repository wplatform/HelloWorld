package com.github.azeroth.game.domain.map;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class ZoneAndAreaId {
    public final int zoneId;
    public final int areaId;
}
