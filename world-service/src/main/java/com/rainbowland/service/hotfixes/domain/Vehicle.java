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
@Table("vehicle")
public class Vehicle {

    @Column("ID")
    private Integer id;
    @Column("Flags")
    private Integer flags;
    @Column("FlagsB")
    private Integer flagsB;
    @Column("TurnSpeed")
    private Double turnSpeed;
    @Column("PitchSpeed")
    private Double pitchSpeed;
    @Column("PitchMin")
    private Double pitchMin;
    @Column("PitchMax")
    private Double pitchMax;
    @Column("MouseLookOffsetPitch")
    private Double mouseLookOffsetPitch;
    @Column("CameraFadeDistScalarMin")
    private Double cameraFadeDistScalarMin;
    @Column("CameraFadeDistScalarMax")
    private Double cameraFadeDistScalarMax;
    @Column("CameraPitchOffset")
    private Double cameraPitchOffset;
    @Column("FacingLimitRight")
    private Double facingLimitRight;
    @Column("FacingLimitLeft")
    private Double facingLimitLeft;
    @Column("CameraYawOffset")
    private Double cameraYawOffset;
    @Column("VehicleUIIndicatorID")
    private Integer vehicleUiIndicatorId;
    @Column("MissileTargetingID")
    private Integer missileTargetingId;
    @Column("VehiclePOITypeID")
    private Integer vehiclePoiTypeId;
    @Column("SeatID1")
    private Integer seatId1;
    @Column("SeatID2")
    private Integer seatId2;
    @Column("SeatID3")
    private Integer seatId3;
    @Column("SeatID4")
    private Integer seatId4;
    @Column("SeatID5")
    private Integer seatId5;
    @Column("SeatID6")
    private Integer seatId6;
    @Column("SeatID7")
    private Integer seatId7;
    @Column("SeatID8")
    private Integer seatId8;
    @Column("PowerDisplayID1")
    private Integer powerDisplayId1;
    @Column("PowerDisplayID2")
    private Integer powerDisplayId2;
    @Column("PowerDisplayID3")
    private Integer powerDisplayId3;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Vehicle> {

        public Vehicle convert(Row row) {
            Vehicle domain = new Vehicle();
            domain.setId(row.get("ID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setFlagsB(row.get("FlagsB", Integer.class));
            domain.setTurnSpeed(row.get("TurnSpeed", Double.class));
            domain.setPitchSpeed(row.get("PitchSpeed", Double.class));
            domain.setPitchMin(row.get("PitchMin", Double.class));
            domain.setPitchMax(row.get("PitchMax", Double.class));
            domain.setMouseLookOffsetPitch(row.get("MouseLookOffsetPitch", Double.class));
            domain.setCameraFadeDistScalarMin(row.get("CameraFadeDistScalarMin", Double.class));
            domain.setCameraFadeDistScalarMax(row.get("CameraFadeDistScalarMax", Double.class));
            domain.setCameraPitchOffset(row.get("CameraPitchOffset", Double.class));
            domain.setFacingLimitRight(row.get("FacingLimitRight", Double.class));
            domain.setFacingLimitLeft(row.get("FacingLimitLeft", Double.class));
            domain.setCameraYawOffset(row.get("CameraYawOffset", Double.class));
            domain.setVehicleUiIndicatorId(row.get("VehicleUIIndicatorID", Integer.class));
            domain.setMissileTargetingId(row.get("MissileTargetingID", Integer.class));
            domain.setVehiclePoiTypeId(row.get("VehiclePOITypeID", Integer.class));
            domain.setSeatId1(row.get("SeatID1", Integer.class));
            domain.setSeatId2(row.get("SeatID2", Integer.class));
            domain.setSeatId3(row.get("SeatID3", Integer.class));
            domain.setSeatId4(row.get("SeatID4", Integer.class));
            domain.setSeatId5(row.get("SeatID5", Integer.class));
            domain.setSeatId6(row.get("SeatID6", Integer.class));
            domain.setSeatId7(row.get("SeatID7", Integer.class));
            domain.setSeatId8(row.get("SeatID8", Integer.class));
            domain.setPowerDisplayId1(row.get("PowerDisplayID1", Integer.class));
            domain.setPowerDisplayId2(row.get("PowerDisplayID2", Integer.class));
            domain.setPowerDisplayId3(row.get("PowerDisplayID3", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Vehicle, OutboundRow> {

        public OutboundRow convert(Vehicle source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getFlagsB()).ifPresent(e -> row.put("FlagsB", Parameter.from(e)));
            Optional.ofNullable(source.getTurnSpeed()).ifPresent(e -> row.put("TurnSpeed", Parameter.from(e)));
            Optional.ofNullable(source.getPitchSpeed()).ifPresent(e -> row.put("PitchSpeed", Parameter.from(e)));
            Optional.ofNullable(source.getPitchMin()).ifPresent(e -> row.put("PitchMin", Parameter.from(e)));
            Optional.ofNullable(source.getPitchMax()).ifPresent(e -> row.put("PitchMax", Parameter.from(e)));
            Optional.ofNullable(source.getMouseLookOffsetPitch()).ifPresent(e -> row.put("MouseLookOffsetPitch", Parameter.from(e)));
            Optional.ofNullable(source.getCameraFadeDistScalarMin()).ifPresent(e -> row.put("CameraFadeDistScalarMin", Parameter.from(e)));
            Optional.ofNullable(source.getCameraFadeDistScalarMax()).ifPresent(e -> row.put("CameraFadeDistScalarMax", Parameter.from(e)));
            Optional.ofNullable(source.getCameraPitchOffset()).ifPresent(e -> row.put("CameraPitchOffset", Parameter.from(e)));
            Optional.ofNullable(source.getFacingLimitRight()).ifPresent(e -> row.put("FacingLimitRight", Parameter.from(e)));
            Optional.ofNullable(source.getFacingLimitLeft()).ifPresent(e -> row.put("FacingLimitLeft", Parameter.from(e)));
            Optional.ofNullable(source.getCameraYawOffset()).ifPresent(e -> row.put("CameraYawOffset", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleUiIndicatorId()).ifPresent(e -> row.put("VehicleUIIndicatorID", Parameter.from(e)));
            Optional.ofNullable(source.getMissileTargetingId()).ifPresent(e -> row.put("MissileTargetingID", Parameter.from(e)));
            Optional.ofNullable(source.getVehiclePoiTypeId()).ifPresent(e -> row.put("VehiclePOITypeID", Parameter.from(e)));
            Optional.ofNullable(source.getSeatId1()).ifPresent(e -> row.put("SeatID1", Parameter.from(e)));
            Optional.ofNullable(source.getSeatId2()).ifPresent(e -> row.put("SeatID2", Parameter.from(e)));
            Optional.ofNullable(source.getSeatId3()).ifPresent(e -> row.put("SeatID3", Parameter.from(e)));
            Optional.ofNullable(source.getSeatId4()).ifPresent(e -> row.put("SeatID4", Parameter.from(e)));
            Optional.ofNullable(source.getSeatId5()).ifPresent(e -> row.put("SeatID5", Parameter.from(e)));
            Optional.ofNullable(source.getSeatId6()).ifPresent(e -> row.put("SeatID6", Parameter.from(e)));
            Optional.ofNullable(source.getSeatId7()).ifPresent(e -> row.put("SeatID7", Parameter.from(e)));
            Optional.ofNullable(source.getSeatId8()).ifPresent(e -> row.put("SeatID8", Parameter.from(e)));
            Optional.ofNullable(source.getPowerDisplayId1()).ifPresent(e -> row.put("PowerDisplayID1", Parameter.from(e)));
            Optional.ofNullable(source.getPowerDisplayId2()).ifPresent(e -> row.put("PowerDisplayID2", Parameter.from(e)));
            Optional.ofNullable(source.getPowerDisplayId3()).ifPresent(e -> row.put("PowerDisplayID3", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
