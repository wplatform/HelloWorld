package com.rainbowland.service.hotfixes.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("vehicle_seat")
public class VehicleSeat {

    @Column("ID")
    private Integer id;
    @Column("AttachmentOffsetX")
    private Double attachmentOffsetX;
    @Column("AttachmentOffsetY")
    private Double attachmentOffsetY;
    @Column("AttachmentOffsetZ")
    private Double attachmentOffsetZ;
    @Column("CameraOffsetX")
    private Double cameraOffsetX;
    @Column("CameraOffsetY")
    private Double cameraOffsetY;
    @Column("CameraOffsetZ")
    private Double cameraOffsetZ;
    @Column("Flags")
    private Integer flags;
    @Column("FlagsB")
    private Integer flagsB;
    @Column("FlagsC")
    private Integer flagsC;
    @Column("AttachmentID")
    private Integer attachmentId;
    @Column("EnterPreDelay")
    private Double enterPreDelay;
    @Column("EnterSpeed")
    private Double enterSpeed;
    @Column("EnterGravity")
    private Double enterGravity;
    @Column("EnterMinDuration")
    private Double enterMinDuration;
    @Column("EnterMaxDuration")
    private Double enterMaxDuration;
    @Column("EnterMinArcHeight")
    private Double enterMinArcHeight;
    @Column("EnterMaxArcHeight")
    private Double enterMaxArcHeight;
    @Column("EnterAnimStart")
    private Integer enterAnimStart;
    @Column("EnterAnimLoop")
    private Integer enterAnimLoop;
    @Column("RideAnimStart")
    private Integer rideAnimStart;
    @Column("RideAnimLoop")
    private Integer rideAnimLoop;
    @Column("RideUpperAnimStart")
    private Integer rideUpperAnimStart;
    @Column("RideUpperAnimLoop")
    private Integer rideUpperAnimLoop;
    @Column("ExitPreDelay")
    private Double exitPreDelay;
    @Column("ExitSpeed")
    private Double exitSpeed;
    @Column("ExitGravity")
    private Double exitGravity;
    @Column("ExitMinDuration")
    private Double exitMinDuration;
    @Column("ExitMaxDuration")
    private Double exitMaxDuration;
    @Column("ExitMinArcHeight")
    private Double exitMinArcHeight;
    @Column("ExitMaxArcHeight")
    private Double exitMaxArcHeight;
    @Column("ExitAnimStart")
    private Integer exitAnimStart;
    @Column("ExitAnimLoop")
    private Integer exitAnimLoop;
    @Column("ExitAnimEnd")
    private Integer exitAnimEnd;
    @Column("VehicleEnterAnim")
    private Integer vehicleEnterAnim;
    @Column("VehicleEnterAnimBone")
    private Integer vehicleEnterAnimBone;
    @Column("VehicleExitAnim")
    private Integer vehicleExitAnim;
    @Column("VehicleExitAnimBone")
    private Integer vehicleExitAnimBone;
    @Column("VehicleRideAnimLoop")
    private Integer vehicleRideAnimLoop;
    @Column("VehicleRideAnimLoopBone")
    private Integer vehicleRideAnimLoopBone;
    @Column("PassengerAttachmentID")
    private Integer passengerAttachmentId;
    @Column("PassengerYaw")
    private Double passengerYaw;
    @Column("PassengerPitch")
    private Double passengerPitch;
    @Column("PassengerRoll")
    private Double passengerRoll;
    @Column("VehicleEnterAnimDelay")
    private Double vehicleEnterAnimDelay;
    @Column("VehicleExitAnimDelay")
    private Double vehicleExitAnimDelay;
    @Column("VehicleAbilityDisplay")
    private Integer vehicleAbilityDisplay;
    @Column("EnterUISoundID")
    private Integer enterUiSoundId;
    @Column("ExitUISoundID")
    private Integer exitUiSoundId;
    @Column("UiSkinFileDataID")
    private Integer uiSkinFileDataId;
    @Column("CameraEnteringDelay")
    private Double cameraEnteringDelay;
    @Column("CameraEnteringDuration")
    private Double cameraEnteringDuration;
    @Column("CameraExitingDelay")
    private Double cameraExitingDelay;
    @Column("CameraExitingDuration")
    private Double cameraExitingDuration;
    @Column("CameraPosChaseRate")
    private Double cameraPosChaseRate;
    @Column("CameraFacingChaseRate")
    private Double cameraFacingChaseRate;
    @Column("CameraEnteringZoom")
    private Double cameraEnteringZoom;
    @Column("CameraSeatZoomMin")
    private Double cameraSeatZoomMin;
    @Column("CameraSeatZoomMax")
    private Double cameraSeatZoomMax;
    @Column("EnterAnimKitID")
    private Integer enterAnimKitId;
    @Column("RideAnimKitID")
    private Integer rideAnimKitId;
    @Column("ExitAnimKitID")
    private Integer exitAnimKitId;
    @Column("VehicleEnterAnimKitID")
    private Integer vehicleEnterAnimKitId;
    @Column("VehicleRideAnimKitID")
    private Integer vehicleRideAnimKitId;
    @Column("VehicleExitAnimKitID")
    private Integer vehicleExitAnimKitId;
    @Column("CameraModeID")
    private Integer cameraModeId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, VehicleSeat> {

        public VehicleSeat convert(Row row) {
            VehicleSeat domain = new VehicleSeat();
            domain.setId(row.get("ID", Integer.class));
            domain.setAttachmentOffsetX(row.get("AttachmentOffsetX", Double.class));
            domain.setAttachmentOffsetY(row.get("AttachmentOffsetY", Double.class));
            domain.setAttachmentOffsetZ(row.get("AttachmentOffsetZ", Double.class));
            domain.setCameraOffsetX(row.get("CameraOffsetX", Double.class));
            domain.setCameraOffsetY(row.get("CameraOffsetY", Double.class));
            domain.setCameraOffsetZ(row.get("CameraOffsetZ", Double.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setFlagsB(row.get("FlagsB", Integer.class));
            domain.setFlagsC(row.get("FlagsC", Integer.class));
            domain.setAttachmentId(row.get("AttachmentID", Integer.class));
            domain.setEnterPreDelay(row.get("EnterPreDelay", Double.class));
            domain.setEnterSpeed(row.get("EnterSpeed", Double.class));
            domain.setEnterGravity(row.get("EnterGravity", Double.class));
            domain.setEnterMinDuration(row.get("EnterMinDuration", Double.class));
            domain.setEnterMaxDuration(row.get("EnterMaxDuration", Double.class));
            domain.setEnterMinArcHeight(row.get("EnterMinArcHeight", Double.class));
            domain.setEnterMaxArcHeight(row.get("EnterMaxArcHeight", Double.class));
            domain.setEnterAnimStart(row.get("EnterAnimStart", Integer.class));
            domain.setEnterAnimLoop(row.get("EnterAnimLoop", Integer.class));
            domain.setRideAnimStart(row.get("RideAnimStart", Integer.class));
            domain.setRideAnimLoop(row.get("RideAnimLoop", Integer.class));
            domain.setRideUpperAnimStart(row.get("RideUpperAnimStart", Integer.class));
            domain.setRideUpperAnimLoop(row.get("RideUpperAnimLoop", Integer.class));
            domain.setExitPreDelay(row.get("ExitPreDelay", Double.class));
            domain.setExitSpeed(row.get("ExitSpeed", Double.class));
            domain.setExitGravity(row.get("ExitGravity", Double.class));
            domain.setExitMinDuration(row.get("ExitMinDuration", Double.class));
            domain.setExitMaxDuration(row.get("ExitMaxDuration", Double.class));
            domain.setExitMinArcHeight(row.get("ExitMinArcHeight", Double.class));
            domain.setExitMaxArcHeight(row.get("ExitMaxArcHeight", Double.class));
            domain.setExitAnimStart(row.get("ExitAnimStart", Integer.class));
            domain.setExitAnimLoop(row.get("ExitAnimLoop", Integer.class));
            domain.setExitAnimEnd(row.get("ExitAnimEnd", Integer.class));
            domain.setVehicleEnterAnim(row.get("VehicleEnterAnim", Integer.class));
            domain.setVehicleEnterAnimBone(row.get("VehicleEnterAnimBone", Integer.class));
            domain.setVehicleExitAnim(row.get("VehicleExitAnim", Integer.class));
            domain.setVehicleExitAnimBone(row.get("VehicleExitAnimBone", Integer.class));
            domain.setVehicleRideAnimLoop(row.get("VehicleRideAnimLoop", Integer.class));
            domain.setVehicleRideAnimLoopBone(row.get("VehicleRideAnimLoopBone", Integer.class));
            domain.setPassengerAttachmentId(row.get("PassengerAttachmentID", Integer.class));
            domain.setPassengerYaw(row.get("PassengerYaw", Double.class));
            domain.setPassengerPitch(row.get("PassengerPitch", Double.class));
            domain.setPassengerRoll(row.get("PassengerRoll", Double.class));
            domain.setVehicleEnterAnimDelay(row.get("VehicleEnterAnimDelay", Double.class));
            domain.setVehicleExitAnimDelay(row.get("VehicleExitAnimDelay", Double.class));
            domain.setVehicleAbilityDisplay(row.get("VehicleAbilityDisplay", Integer.class));
            domain.setEnterUiSoundId(row.get("EnterUISoundID", Integer.class));
            domain.setExitUiSoundId(row.get("ExitUISoundID", Integer.class));
            domain.setUiSkinFileDataId(row.get("UiSkinFileDataID", Integer.class));
            domain.setCameraEnteringDelay(row.get("CameraEnteringDelay", Double.class));
            domain.setCameraEnteringDuration(row.get("CameraEnteringDuration", Double.class));
            domain.setCameraExitingDelay(row.get("CameraExitingDelay", Double.class));
            domain.setCameraExitingDuration(row.get("CameraExitingDuration", Double.class));
            domain.setCameraPosChaseRate(row.get("CameraPosChaseRate", Double.class));
            domain.setCameraFacingChaseRate(row.get("CameraFacingChaseRate", Double.class));
            domain.setCameraEnteringZoom(row.get("CameraEnteringZoom", Double.class));
            domain.setCameraSeatZoomMin(row.get("CameraSeatZoomMin", Double.class));
            domain.setCameraSeatZoomMax(row.get("CameraSeatZoomMax", Double.class));
            domain.setEnterAnimKitId(row.get("EnterAnimKitID", Integer.class));
            domain.setRideAnimKitId(row.get("RideAnimKitID", Integer.class));
            domain.setExitAnimKitId(row.get("ExitAnimKitID", Integer.class));
            domain.setVehicleEnterAnimKitId(row.get("VehicleEnterAnimKitID", Integer.class));
            domain.setVehicleRideAnimKitId(row.get("VehicleRideAnimKitID", Integer.class));
            domain.setVehicleExitAnimKitId(row.get("VehicleExitAnimKitID", Integer.class));
            domain.setCameraModeId(row.get("CameraModeID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<VehicleSeat, OutboundRow> {

        public OutboundRow convert(VehicleSeat source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getAttachmentOffsetX()).ifPresent(e -> row.put("AttachmentOffsetX", Parameter.from(e)));
            Optional.ofNullable(source.getAttachmentOffsetY()).ifPresent(e -> row.put("AttachmentOffsetY", Parameter.from(e)));
            Optional.ofNullable(source.getAttachmentOffsetZ()).ifPresent(e -> row.put("AttachmentOffsetZ", Parameter.from(e)));
            Optional.ofNullable(source.getCameraOffsetX()).ifPresent(e -> row.put("CameraOffsetX", Parameter.from(e)));
            Optional.ofNullable(source.getCameraOffsetY()).ifPresent(e -> row.put("CameraOffsetY", Parameter.from(e)));
            Optional.ofNullable(source.getCameraOffsetZ()).ifPresent(e -> row.put("CameraOffsetZ", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getFlagsB()).ifPresent(e -> row.put("FlagsB", Parameter.from(e)));
            Optional.ofNullable(source.getFlagsC()).ifPresent(e -> row.put("FlagsC", Parameter.from(e)));
            Optional.ofNullable(source.getAttachmentId()).ifPresent(e -> row.put("AttachmentID", Parameter.from(e)));
            Optional.ofNullable(source.getEnterPreDelay()).ifPresent(e -> row.put("EnterPreDelay", Parameter.from(e)));
            Optional.ofNullable(source.getEnterSpeed()).ifPresent(e -> row.put("EnterSpeed", Parameter.from(e)));
            Optional.ofNullable(source.getEnterGravity()).ifPresent(e -> row.put("EnterGravity", Parameter.from(e)));
            Optional.ofNullable(source.getEnterMinDuration()).ifPresent(e -> row.put("EnterMinDuration", Parameter.from(e)));
            Optional.ofNullable(source.getEnterMaxDuration()).ifPresent(e -> row.put("EnterMaxDuration", Parameter.from(e)));
            Optional.ofNullable(source.getEnterMinArcHeight()).ifPresent(e -> row.put("EnterMinArcHeight", Parameter.from(e)));
            Optional.ofNullable(source.getEnterMaxArcHeight()).ifPresent(e -> row.put("EnterMaxArcHeight", Parameter.from(e)));
            Optional.ofNullable(source.getEnterAnimStart()).ifPresent(e -> row.put("EnterAnimStart", Parameter.from(e)));
            Optional.ofNullable(source.getEnterAnimLoop()).ifPresent(e -> row.put("EnterAnimLoop", Parameter.from(e)));
            Optional.ofNullable(source.getRideAnimStart()).ifPresent(e -> row.put("RideAnimStart", Parameter.from(e)));
            Optional.ofNullable(source.getRideAnimLoop()).ifPresent(e -> row.put("RideAnimLoop", Parameter.from(e)));
            Optional.ofNullable(source.getRideUpperAnimStart()).ifPresent(e -> row.put("RideUpperAnimStart", Parameter.from(e)));
            Optional.ofNullable(source.getRideUpperAnimLoop()).ifPresent(e -> row.put("RideUpperAnimLoop", Parameter.from(e)));
            Optional.ofNullable(source.getExitPreDelay()).ifPresent(e -> row.put("ExitPreDelay", Parameter.from(e)));
            Optional.ofNullable(source.getExitSpeed()).ifPresent(e -> row.put("ExitSpeed", Parameter.from(e)));
            Optional.ofNullable(source.getExitGravity()).ifPresent(e -> row.put("ExitGravity", Parameter.from(e)));
            Optional.ofNullable(source.getExitMinDuration()).ifPresent(e -> row.put("ExitMinDuration", Parameter.from(e)));
            Optional.ofNullable(source.getExitMaxDuration()).ifPresent(e -> row.put("ExitMaxDuration", Parameter.from(e)));
            Optional.ofNullable(source.getExitMinArcHeight()).ifPresent(e -> row.put("ExitMinArcHeight", Parameter.from(e)));
            Optional.ofNullable(source.getExitMaxArcHeight()).ifPresent(e -> row.put("ExitMaxArcHeight", Parameter.from(e)));
            Optional.ofNullable(source.getExitAnimStart()).ifPresent(e -> row.put("ExitAnimStart", Parameter.from(e)));
            Optional.ofNullable(source.getExitAnimLoop()).ifPresent(e -> row.put("ExitAnimLoop", Parameter.from(e)));
            Optional.ofNullable(source.getExitAnimEnd()).ifPresent(e -> row.put("ExitAnimEnd", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleEnterAnim()).ifPresent(e -> row.put("VehicleEnterAnim", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleEnterAnimBone()).ifPresent(e -> row.put("VehicleEnterAnimBone", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleExitAnim()).ifPresent(e -> row.put("VehicleExitAnim", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleExitAnimBone()).ifPresent(e -> row.put("VehicleExitAnimBone", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleRideAnimLoop()).ifPresent(e -> row.put("VehicleRideAnimLoop", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleRideAnimLoopBone()).ifPresent(e -> row.put("VehicleRideAnimLoopBone", Parameter.from(e)));
            Optional.ofNullable(source.getPassengerAttachmentId()).ifPresent(e -> row.put("PassengerAttachmentID", Parameter.from(e)));
            Optional.ofNullable(source.getPassengerYaw()).ifPresent(e -> row.put("PassengerYaw", Parameter.from(e)));
            Optional.ofNullable(source.getPassengerPitch()).ifPresent(e -> row.put("PassengerPitch", Parameter.from(e)));
            Optional.ofNullable(source.getPassengerRoll()).ifPresent(e -> row.put("PassengerRoll", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleEnterAnimDelay()).ifPresent(e -> row.put("VehicleEnterAnimDelay", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleExitAnimDelay()).ifPresent(e -> row.put("VehicleExitAnimDelay", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleAbilityDisplay()).ifPresent(e -> row.put("VehicleAbilityDisplay", Parameter.from(e)));
            Optional.ofNullable(source.getEnterUiSoundId()).ifPresent(e -> row.put("EnterUISoundID", Parameter.from(e)));
            Optional.ofNullable(source.getExitUiSoundId()).ifPresent(e -> row.put("ExitUISoundID", Parameter.from(e)));
            Optional.ofNullable(source.getUiSkinFileDataId()).ifPresent(e -> row.put("UiSkinFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getCameraEnteringDelay()).ifPresent(e -> row.put("CameraEnteringDelay", Parameter.from(e)));
            Optional.ofNullable(source.getCameraEnteringDuration()).ifPresent(e -> row.put("CameraEnteringDuration", Parameter.from(e)));
            Optional.ofNullable(source.getCameraExitingDelay()).ifPresent(e -> row.put("CameraExitingDelay", Parameter.from(e)));
            Optional.ofNullable(source.getCameraExitingDuration()).ifPresent(e -> row.put("CameraExitingDuration", Parameter.from(e)));
            Optional.ofNullable(source.getCameraPosChaseRate()).ifPresent(e -> row.put("CameraPosChaseRate", Parameter.from(e)));
            Optional.ofNullable(source.getCameraFacingChaseRate()).ifPresent(e -> row.put("CameraFacingChaseRate", Parameter.from(e)));
            Optional.ofNullable(source.getCameraEnteringZoom()).ifPresent(e -> row.put("CameraEnteringZoom", Parameter.from(e)));
            Optional.ofNullable(source.getCameraSeatZoomMin()).ifPresent(e -> row.put("CameraSeatZoomMin", Parameter.from(e)));
            Optional.ofNullable(source.getCameraSeatZoomMax()).ifPresent(e -> row.put("CameraSeatZoomMax", Parameter.from(e)));
            Optional.ofNullable(source.getEnterAnimKitId()).ifPresent(e -> row.put("EnterAnimKitID", Parameter.from(e)));
            Optional.ofNullable(source.getRideAnimKitId()).ifPresent(e -> row.put("RideAnimKitID", Parameter.from(e)));
            Optional.ofNullable(source.getExitAnimKitId()).ifPresent(e -> row.put("ExitAnimKitID", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleEnterAnimKitId()).ifPresent(e -> row.put("VehicleEnterAnimKitID", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleRideAnimKitId()).ifPresent(e -> row.put("VehicleRideAnimKitID", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleExitAnimKitId()).ifPresent(e -> row.put("VehicleExitAnimKitID", Parameter.from(e)));
            Optional.ofNullable(source.getCameraModeId()).ifPresent(e -> row.put("CameraModeID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
