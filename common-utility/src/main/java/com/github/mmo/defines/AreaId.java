package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AreaId {
    AREA_WINTERGRASP(4197),
    AREA_THE_SUNKEN_RING(4538),
    AREA_THE_BROKEN_TEMPLATE(4539),
    AREA_WINTERGRASP_FORTRESS(4575),
    AREA_THE_CHILLED_QUAGMIRE(4589),
    AREA_WESTPARK_WORKSHOP(4611),
    AREA_EASTPARK_WORKSHOP(4612);

    public final int value;
}
