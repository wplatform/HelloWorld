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
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "FlagsB")
    private Integer flagsB;

    @Column(name = "FlagsC")
    private Integer flagsC;

    @Column(name = "AttachmentOffsetX")
    private Float attachmentOffsetX;

    @Column(name = "AttachmentOffsetY")
    private Float attachmentOffsetY;

    @Column(name = "AttachmentOffsetZ")
    private Float attachmentOffsetZ;

    @Column(name = "EnterPreDelay")
    private Float enterPreDelay;

    @Column(name = "EnterSpeed")
    private Float enterSpeed;

    @Column(name = "EnterGravity")
    private Float enterGravity;

    @Column(name = "EnterMinDuration")
    private Float enterMinDuration;

    @Column(name = "EnterMaxDuration")
    private Float enterMaxDuration;

    @Column(name = "EnterMinArcHeight")
    private Float enterMinArcHeight;

    @Column(name = "EnterMaxArcHeight")
    private Float enterMaxArcHeight;

    @Column(name = "ExitPreDelay")
    private Float exitPreDelay;

    @Column(name = "ExitSpeed")
    private Float exitSpeed;

    @Column(name = "ExitGravity")
    private Float exitGravity;

    @Column(name = "ExitMinDuration")
    private Float exitMinDuration;

    @Column(name = "ExitMaxDuration")
    private Float exitMaxDuration;

    @Column(name = "ExitMinArcHeight")
    private Float exitMinArcHeight;

    @Column(name = "ExitMaxArcHeight")
    private Float exitMaxArcHeight;

    @Column(name = "PassengerYaw")
    private Float passengerYaw;

    @Column(name = "PassengerPitch")
    private Float passengerPitch;

    @Column(name = "PassengerRoll")
    private Float passengerRoll;

    @Column(name = "VehicleEnterAnimDelay")
    private Float vehicleEnterAnimDelay;

    @Column(name = "VehicleExitAnimDelay")
    private Float vehicleExitAnimDelay;

    @Column(name = "CameraEnteringDelay")
    private Float cameraEnteringDelay;

    @Column(name = "CameraEnteringDuration")
    private Float cameraEnteringDuration;

    @Column(name = "CameraExitingDelay")
    private Float cameraExitingDelay;

    @Column(name = "CameraExitingDuration")
    private Float cameraExitingDuration;

    @Column(name = "CameraOffsetX")
    private Float cameraOffsetX;

    @Column(name = "CameraOffsetY")
    private Float cameraOffsetY;

    @Column(name = "CameraOffsetZ")
    private Float cameraOffsetZ;

    @Column(name = "CameraPosChaseRate")
    private Float cameraPosChaseRate;

    @Column(name = "CameraFacingChaseRate")
    private Float cameraFacingChaseRate;

    @Column(name = "CameraEnteringZoom")
    private Float cameraEnteringZoom;

    @Column(name = "CameraSeatZoomMin")
    private Float cameraSeatZoomMin;

    @Column(name = "CameraSeatZoomMax")
    private Float cameraSeatZoomMax;

    @Column(name = "UiSkinFileDataID")
    private Integer uiSkinFileDataID;

    @Column(name = "EnterAnimStart")
    private Short enterAnimStart;

    @Column(name = "EnterAnimLoop")
    private Short enterAnimLoop;

    @Column(name = "RideAnimStart")
    private Short rideAnimStart;

    @Column(name = "RideAnimLoop")
    private Short rideAnimLoop;

    @Column(name = "RideUpperAnimStart")
    private Short rideUpperAnimStart;

    @Column(name = "RideUpperAnimLoop")
    private Short rideUpperAnimLoop;

    @Column(name = "ExitAnimStart")
    private Short exitAnimStart;

    @Column(name = "ExitAnimLoop")
    private Short exitAnimLoop;

    @Column(name = "ExitAnimEnd")
    private Short exitAnimEnd;

    @Column(name = "VehicleEnterAnim")
    private Short vehicleEnterAnim;

    @Column(name = "VehicleExitAnim")
    private Short vehicleExitAnim;

    @Column(name = "VehicleRideAnimLoop")
    private Short vehicleRideAnimLoop;

    @Column(name = "EnterAnimKitID")
    private Short enterAnimKitID;

    @Column(name = "RideAnimKitID")
    private Short rideAnimKitID;

    @Column(name = "ExitAnimKitID")
    private Short exitAnimKitID;

    @Column(name = "VehicleEnterAnimKitID")
    private Short vehicleEnterAnimKitID;

    @Column(name = "VehicleRideAnimKitID")
    private Short vehicleRideAnimKitID;

    @Column(name = "VehicleExitAnimKitID")
    private Short vehicleExitAnimKitID;

    @Column(name = "CameraModeID")
    private Short cameraModeID;

    @Column(name = "AttachmentID")
    private Byte attachmentID;

    @Column(name = "PassengerAttachmentID")
    private Byte passengerAttachmentID;

    @Column(name = "VehicleEnterAnimBone")
    private Byte vehicleEnterAnimBone;

    @Column(name = "VehicleExitAnimBone")
    private Byte vehicleExitAnimBone;

    @Column(name = "VehicleRideAnimLoopBone")
    private Byte vehicleRideAnimLoopBone;

    @Column(name = "VehicleAbilityDisplay")
    private Byte vehicleAbilityDisplay;

    @Column(name = "EnterUISoundID")
    private Integer enterUISoundID;

    @Column(name = "ExitUISoundID")
    private Integer exitUISoundID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
