package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum EventId {
    EVENT_CHARGE(1003),
    EVENT_JUMP(1004),

    /// Special charge event which is used for charge spells that have explicit targets
    /// and had a path already generated - using it in PointMovementGenerator will not
    /// create a new spline and launch it
    EVENT_CHARGE_PREPATH(1005),

    EVENT_FACE(1006),
    EVENT_VEHICLE_BOARD(1007),
    EVENT_VEHICLE_EXIT(1008),
    EVENT_ASSIST_MOVE(1009);

    public final int value;
}
