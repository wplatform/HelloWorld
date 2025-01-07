package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum VehicleSeatFlags implements EnumFlag.FlagValue {
    VEHICLE_SEAT_FLAG_HAS_LOWER_ANIM_FOR_ENTER(0x00000001),
    VEHICLE_SEAT_FLAG_HAS_LOWER_ANIM_FOR_RIDE(0x00000002),
    VEHICLE_SEAT_FLAG_DISABLE_GRAVITY(0x00000004), // Passenger will not be affected by gravity
    VEHICLE_SEAT_FLAG_SHOULD_USE_VEH_SEAT_EXIT_ANIM_ON_VOLUNTARY_EXIT(0x00000008),
    VEHICLE_SEAT_FLAG_UNK5(0x00000010),
    VEHICLE_SEAT_FLAG_UNK6(0x00000020),
    VEHICLE_SEAT_FLAG_UNK7(0x00000040),
    VEHICLE_SEAT_FLAG_UNK8(0x00000080),
    VEHICLE_SEAT_FLAG_UNK9(0x00000100),
    VEHICLE_SEAT_FLAG_HIDE_PASSENGER(0x00000200), // Passenger is hidden
    VEHICLE_SEAT_FLAG_ALLOW_TURNING(0x00000400), // needed for CGCamera__SyncFreeLookFacing
    VEHICLE_SEAT_FLAG_CAN_CONTROL(0x00000800), // Lua_UnitInVehicleControlSeat
    VEHICLE_SEAT_FLAG_CAN_CAST_MOUNT_SPELL(0x00001000), // Can cast spells with SPELL_AURA_MOUNTED from seat (possibly 4.x only, 0 seats on 3.3.5a)
    VEHICLE_SEAT_FLAG_UNCONTROLLED(0x00002000), // can override !& VEHICLE_SEAT_FLAG_CAN_ENTER_OR_EXIT
    VEHICLE_SEAT_FLAG_CAN_ATTACK(0x00004000), // Can attack, cast spells and use items from vehicle
    VEHICLE_SEAT_FLAG_SHOULD_USE_VEH_SEAT_EXIT_ANIM_ON_FORCED_EXIT(0x00008000),
    VEHICLE_SEAT_FLAG_UNK17(0x00010000),
    VEHICLE_SEAT_FLAG_UNK18(0x00020000), // Needs research and support (28 vehicles): Allow entering vehicles while keeping specific permanent(?) auras that impose visuals (states like beeing under freeze/stun mechanic, emote state animations).
    VEHICLE_SEAT_FLAG_HAS_VEH_EXIT_ANIM_VOLUNTARY_EXIT(0x00040000),
    VEHICLE_SEAT_FLAG_HAS_VEH_EXIT_ANIM_FORCED_EXIT(0x00080000),
    VEHICLE_SEAT_FLAG_PASSENGER_NOT_SELECTABLE(0x00100000),
    VEHICLE_SEAT_FLAG_UNK22(0x00200000),
    VEHICLE_SEAT_FLAG_REC_HAS_VEHICLE_ENTER_ANIM(0x00400000),
    VEHICLE_SEAT_FLAG_IS_USING_VEHICLE_CONTROLS(0x00800000), // Lua_IsUsingVehicleControls
    VEHICLE_SEAT_FLAG_ENABLE_VEHICLE_ZOOM(0x01000000),
    VEHICLE_SEAT_FLAG_CAN_ENTER_OR_EXIT(0x02000000), // Lua_CanExitVehicle - can enter and exit at free will
    VEHICLE_SEAT_FLAG_CAN_SWITCH(0x04000000), // Lua_CanSwitchVehicleSeats
    VEHICLE_SEAT_FLAG_HAS_START_WARITING_FOR_VEH_TRANSITION_ANIM_ENTER(0x08000000),
    VEHICLE_SEAT_FLAG_HAS_START_WARITING_FOR_VEH_TRANSITION_ANIM_EXIT(0x10000000),
    VEHICLE_SEAT_FLAG_CAN_CAST(0x20000000), // Lua_UnitHasVehicleUI
    VEHICLE_SEAT_FLAG_UNK2(0x40000000), // checked in conjunction with 0x800 in CastSpell2
    VEHICLE_SEAT_FLAG_ALLOWS_INTERACTION(0x80000000);

    public final int value;
}
