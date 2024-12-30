package com.github.mmo.game.entity.vehicle;

import Framework.Constants.*;


public final class VehicleSeatRecord {
    //C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint Id;
    public int id;
    public Vector3 attachmentOffset;
    public Vector3 cameraOffset;
    public int flags;
    public int flagsB;
    public int flagsC;
    public byte attachmentID;
    public float enterPreDelay;
    public float enterSpeed;
    public float enterGravity;
    public float enterMinDuration;
    public float enterMaxDuration;
    public float enterMinArcHeight;
    public float enterMaxArcHeight;
    public int enterAnimStart;
    public int enterAnimLoop;
    public int rideAnimStart;
    public int rideAnimLoop;
    public int rideUpperAnimStart;
    public int rideUpperAnimLoop;
    public float exitPreDelay;
    public float exitSpeed;
    public float exitGravity;
    public float exitMinDuration;
    public float exitMaxDuration;
    public float exitMinArcHeight;
    public float exitMaxArcHeight;
    public int exitAnimStart;
    public int exitAnimLoop;
    public int exitAnimEnd;
    public short vehicleEnterAnim;
    public byte vehicleEnterAnimBone;
    public short vehicleExitAnim;
    public byte vehicleExitAnimBone;
    public short vehicleRideAnimLoop;
    public byte vehicleRideAnimLoopBone;
    public byte passengerAttachmentID;
    public float passengerYaw;
    public float passengerPitch;
    public float passengerRoll;
    public float vehicleEnterAnimDelay;
    public float vehicleExitAnimDelay;
    public byte vehicleAbilityDisplay;
    //C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint EnterUISoundID;
    public int enterUISoundID;
    //C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint ExitUISoundID;
    public int exitUISoundID;
    public int uiSkinFileDataID;
    public float cameraEnteringDelay;
    public float cameraEnteringDuration;
    public float cameraExitingDelay;
    public float cameraExitingDuration;
    public float cameraPosChaseRate;
    public float cameraFacingChaseRate;
    public float cameraEnteringZoom;
    public float cameraSeatZoomMin;
    public float cameraSeatZoomMax;
    public short enterAnimKitID;
    public short rideAnimKitID;
    public short exitAnimKitID;
    public short vehicleEnterAnimKitID;
    public short vehicleRideAnimKitID;
    public short vehicleExitAnimKitID;
    public short cameraModeID;

    public boolean hasFlag(VehicleSeatFlags flag) {
        return flags.hasFlag(flag.getValue());
    }

    public boolean hasFlag(VehicleSeatFlagsB flag) {
        return flagsB.hasFlag(flag.getValue());
    }

    public boolean canEnterOrExit() {
        return (hasFlag(VehicleSeatFlags.CanEnterOrExit) || hasFlag(VehicleSeatFlags.HasLowerAnimForEnter.getValue() | VehicleSeatFlags.HasLowerAnimForRide.getValue()));
    }

    public boolean canSwitchFromSeat() {
        return flags.hasFlag(VehicleSeatFlags.CanSwitch.getValue());
    }

    public boolean isUsableByOverride() {
        return hasFlag(VehicleSeatFlags.Uncontrolled.getValue() | VehicleSeatFlags.Unk18.getValue()) || hasFlag(VehicleSeatFlagsB.UsableForced.getValue() | VehicleSeatFlagsB.UsableForced2.getValue().getValue() | VehicleSeatFlagsB.UsableForced3.getValue().getValue().getValue() | VehicleSeatFlagsB.UsableForced4.getValue().getValue().getValue());
    }

    public boolean isEjectable() {
        return hasFlag(VehicleSeatFlagsB.Ejectable);
    }
}