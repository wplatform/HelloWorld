package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum VehicleSeatFlagsB implements EnumFlag.FlagValue {
    VEHICLE_SEAT_FLAG_B_NONE(0x00000000),
    VEHICLE_SEAT_FLAG_B_USABLE_FORCED(0x00000002),
    VEHICLE_SEAT_FLAG_B_TARGETS_IN_RAIDUI(0x00000008),           // Lua_UnitTargetsVehicleInRaidUI
    VEHICLE_SEAT_FLAG_B_EJECTABLE(0x00000020),           // ejectable
    VEHICLE_SEAT_FLAG_B_USABLE_FORCED_2(0x00000040),
    VEHICLE_SEAT_FLAG_B_USABLE_FORCED_3(0x00000100),
    VEHICLE_SEAT_FLAG_B_PASSENGER_MIRRORS_ANIMS(0x00010000),           // Passenger forced to repeat all vehicle animations
    VEHICLE_SEAT_FLAG_B_KEEP_PET(0x00020000),
    VEHICLE_SEAT_FLAG_B_USABLE_FORCED_4(0x02000000),
    VEHICLE_SEAT_FLAG_B_CAN_SWITCH(0x04000000),
    VEHICLE_SEAT_FLAG_B_VEHICLE_PLAYERFRAME_UI(0x80000000);            // Lua_UnitHasVehiclePlayerFrameUI - actually checked for flagsb &~ 0x80000000
    public final int value;
}
