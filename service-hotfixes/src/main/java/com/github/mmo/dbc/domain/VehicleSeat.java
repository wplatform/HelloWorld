package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "vehicle_seat")
@Db2DataBind(name = "VehicleSeat.db2", layoutHash = 0x242E0ECD, fields = {
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "flagsB", type = Db2Type.INT, signed = true),
        @Db2Field(name = "flagsC", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"attachmentOffsetX", "attachmentOffsetY", "attachmentOffsetZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = "enterPreDelay", type = Db2Type.FLOAT),
        @Db2Field(name = "enterSpeed", type = Db2Type.FLOAT),
        @Db2Field(name = "enterGravity", type = Db2Type.FLOAT),
        @Db2Field(name = "enterMinDuration", type = Db2Type.FLOAT),
        @Db2Field(name = "enterMaxDuration", type = Db2Type.FLOAT),
        @Db2Field(name = "enterMinArcHeight", type = Db2Type.FLOAT),
        @Db2Field(name = "enterMaxArcHeight", type = Db2Type.FLOAT),
        @Db2Field(name = "exitPreDelay", type = Db2Type.FLOAT),
        @Db2Field(name = "exitSpeed", type = Db2Type.FLOAT),
        @Db2Field(name = "exitGravity", type = Db2Type.FLOAT),
        @Db2Field(name = "exitMinDuration", type = Db2Type.FLOAT),
        @Db2Field(name = "exitMaxDuration", type = Db2Type.FLOAT),
        @Db2Field(name = "exitMinArcHeight", type = Db2Type.FLOAT),
        @Db2Field(name = "exitMaxArcHeight", type = Db2Type.FLOAT),
        @Db2Field(name = "passengerYaw", type = Db2Type.FLOAT),
        @Db2Field(name = "passengerPitch", type = Db2Type.FLOAT),
        @Db2Field(name = "passengerRoll", type = Db2Type.FLOAT),
        @Db2Field(name = "vehicleEnterAnimDelay", type = Db2Type.FLOAT),
        @Db2Field(name = "vehicleExitAnimDelay", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraEnteringDelay", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraEnteringDuration", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraExitingDelay", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraExitingDuration", type = Db2Type.FLOAT),
        @Db2Field(name = {"cameraOffsetX", "cameraOffsetY", "cameraOffsetZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = "cameraPosChaseRate", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraFacingChaseRate", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraEnteringZoom", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraSeatZoomMin", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraSeatZoomMax", type = Db2Type.FLOAT),
        @Db2Field(name = "uiSkinFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "enterAnimStart", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "enterAnimLoop", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "rideAnimStart", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "rideAnimLoop", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "rideUpperAnimStart", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "rideUpperAnimLoop", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "exitAnimStart", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "exitAnimLoop", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "exitAnimEnd", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "vehicleEnterAnim", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "vehicleExitAnim", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "vehicleRideAnimLoop", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "enterAnimKitID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "rideAnimKitID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "exitAnimKitID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "vehicleEnterAnimKitID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "vehicleRideAnimKitID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "vehicleExitAnimKitID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "cameraModeID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "attachmentID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "passengerAttachmentID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "vehicleEnterAnimBone", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "vehicleExitAnimBone", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "vehicleRideAnimLoopBone", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "vehicleAbilityDisplay", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "enterUISoundID", type = Db2Type.INT),
        @Db2Field(name = "exitUISoundID", type = Db2Type.INT)
})
public class VehicleSeat implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Flags")
    private Integer flags;

    @Column("FlagsB")
    private Integer flagsB;

    @Column("FlagsC")
    private Integer flagsC;

    @Column("AttachmentOffsetX")
    private Float attachmentOffsetX;

    @Column("AttachmentOffsetY")
    private Float attachmentOffsetY;

    @Column("AttachmentOffsetZ")
    private Float attachmentOffsetZ;

    @Column("EnterPreDelay")
    private Float enterPreDelay;

    @Column("EnterSpeed")
    private Float enterSpeed;

    @Column("EnterGravity")
    private Float enterGravity;

    @Column("EnterMinDuration")
    private Float enterMinDuration;

    @Column("EnterMaxDuration")
    private Float enterMaxDuration;

    @Column("EnterMinArcHeight")
    private Float enterMinArcHeight;

    @Column("EnterMaxArcHeight")
    private Float enterMaxArcHeight;

    @Column("ExitPreDelay")
    private Float exitPreDelay;

    @Column("ExitSpeed")
    private Float exitSpeed;

    @Column("ExitGravity")
    private Float exitGravity;

    @Column("ExitMinDuration")
    private Float exitMinDuration;

    @Column("ExitMaxDuration")
    private Float exitMaxDuration;

    @Column("ExitMinArcHeight")
    private Float exitMinArcHeight;

    @Column("ExitMaxArcHeight")
    private Float exitMaxArcHeight;

    @Column("PassengerYaw")
    private Float passengerYaw;

    @Column("PassengerPitch")
    private Float passengerPitch;

    @Column("PassengerRoll")
    private Float passengerRoll;

    @Column("VehicleEnterAnimDelay")
    private Float vehicleEnterAnimDelay;

    @Column("VehicleExitAnimDelay")
    private Float vehicleExitAnimDelay;

    @Column("CameraEnteringDelay")
    private Float cameraEnteringDelay;

    @Column("CameraEnteringDuration")
    private Float cameraEnteringDuration;

    @Column("CameraExitingDelay")
    private Float cameraExitingDelay;

    @Column("CameraExitingDuration")
    private Float cameraExitingDuration;

    @Column("CameraOffsetX")
    private Float cameraOffsetX;

    @Column("CameraOffsetY")
    private Float cameraOffsetY;

    @Column("CameraOffsetZ")
    private Float cameraOffsetZ;

    @Column("CameraPosChaseRate")
    private Float cameraPosChaseRate;

    @Column("CameraFacingChaseRate")
    private Float cameraFacingChaseRate;

    @Column("CameraEnteringZoom")
    private Float cameraEnteringZoom;

    @Column("CameraSeatZoomMin")
    private Float cameraSeatZoomMin;

    @Column("CameraSeatZoomMax")
    private Float cameraSeatZoomMax;

    @Column("UiSkinFileDataID")
    private Integer uiSkinFileDataID;

    @Column("EnterAnimStart")
    private Short enterAnimStart;

    @Column("EnterAnimLoop")
    private Short enterAnimLoop;

    @Column("RideAnimStart")
    private Short rideAnimStart;

    @Column("RideAnimLoop")
    private Short rideAnimLoop;

    @Column("RideUpperAnimStart")
    private Short rideUpperAnimStart;

    @Column("RideUpperAnimLoop")
    private Short rideUpperAnimLoop;

    @Column("ExitAnimStart")
    private Short exitAnimStart;

    @Column("ExitAnimLoop")
    private Short exitAnimLoop;

    @Column("ExitAnimEnd")
    private Short exitAnimEnd;

    @Column("VehicleEnterAnim")
    private Short vehicleEnterAnim;

    @Column("VehicleExitAnim")
    private Short vehicleExitAnim;

    @Column("VehicleRideAnimLoop")
    private Short vehicleRideAnimLoop;

    @Column("EnterAnimKitID")
    private Short enterAnimKitID;

    @Column("RideAnimKitID")
    private Short rideAnimKitID;

    @Column("ExitAnimKitID")
    private Short exitAnimKitID;

    @Column("VehicleEnterAnimKitID")
    private Short vehicleEnterAnimKitID;

    @Column("VehicleRideAnimKitID")
    private Short vehicleRideAnimKitID;

    @Column("VehicleExitAnimKitID")
    private Short vehicleExitAnimKitID;

    @Column("CameraModeID")
    private Short cameraModeID;

    @Column("AttachmentID")
    private Byte attachmentID;

    @Column("PassengerAttachmentID")
    private Byte passengerAttachmentID;

    @Column("VehicleEnterAnimBone")
    private Byte vehicleEnterAnimBone;

    @Column("VehicleExitAnimBone")
    private Byte vehicleExitAnimBone;

    @Column("VehicleRideAnimLoopBone")
    private Byte vehicleRideAnimLoopBone;

    @Column("VehicleAbilityDisplay")
    private Byte vehicleAbilityDisplay;

    @Column("EnterUISoundID")
    private Integer enterUISoundID;

    @Column("ExitUISoundID")
    private Integer exitUISoundID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
