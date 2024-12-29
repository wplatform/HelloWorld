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


@Table(name = "vehicle")
@Db2DataBind(name = "Vehicle.db2", layoutHash = 0x1606C582, fields = {
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "turnSpeed", type = Db2Type.FLOAT),
        @Db2Field(name = "pitchSpeed", type = Db2Type.FLOAT),
        @Db2Field(name = "pitchMin", type = Db2Type.FLOAT),
        @Db2Field(name = "pitchMax", type = Db2Type.FLOAT),
        @Db2Field(name = "mouseLookOffsetPitch", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraFadeDistScalarMin", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraFadeDistScalarMax", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraPitchOffset", type = Db2Type.FLOAT),
        @Db2Field(name = "facingLimitRight", type = Db2Type.FLOAT),
        @Db2Field(name = "facingLimitLeft", type = Db2Type.FLOAT),
        @Db2Field(name = "cameraYawOffset", type = Db2Type.FLOAT),
        @Db2Field(name = {"seatID1", "seatID2", "seatID3", "seatID4", "seatID5", "seatID6", "seatID7", "seatID8"}, type = Db2Type.SHORT),
        @Db2Field(name = "vehicleUIIndicatorID", type = Db2Type.SHORT),
        @Db2Field(name = {"powerDisplayID1", "powerDisplayID2", "powerDisplayID3"}, type = Db2Type.SHORT),
        @Db2Field(name = "flagsB", type = Db2Type.BYTE),
        @Db2Field(name = "uiLocomotionType", type = Db2Type.BYTE),
        @Db2Field(name = "missileTargetingID", type = Db2Type.INT, signed = true)
})
public class VehicleEntry implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Flags")
    private Integer flags;

    @Column("TurnSpeed")
    private Float turnSpeed;

    @Column("PitchSpeed")
    private Float pitchSpeed;

    @Column("PitchMin")
    private Float pitchMin;

    @Column("PitchMax")
    private Float pitchMax;

    @Column("MouseLookOffsetPitch")
    private Float mouseLookOffsetPitch;

    @Column("CameraFadeDistScalarMin")
    private Float cameraFadeDistScalarMin;

    @Column("CameraFadeDistScalarMax")
    private Float cameraFadeDistScalarMax;

    @Column("CameraPitchOffset")
    private Float cameraPitchOffset;

    @Column("FacingLimitRight")
    private Float facingLimitRight;

    @Column("FacingLimitLeft")
    private Float facingLimitLeft;

    @Column("CameraYawOffset")
    private Float cameraYawOffset;

    @Column("SeatID1")
    private Short seatID1;

    @Column("SeatID2")
    private Short seatID2;

    @Column("SeatID3")
    private Short seatID3;

    @Column("SeatID4")
    private Short seatID4;

    @Column("SeatID5")
    private Short seatID5;

    @Column("SeatID6")
    private Short seatID6;

    @Column("SeatID7")
    private Short seatID7;

    @Column("SeatID8")
    private Short seatID8;

    @Column("VehicleUIIndicatorID")
    private Short vehicleUIIndicatorID;

    @Column("PowerDisplayID1")
    private Short powerDisplayID1;

    @Column("PowerDisplayID2")
    private Short powerDisplayID2;

    @Column("PowerDisplayID3")
    private Short powerDisplayID3;

    @Column("FlagsB")
    private Byte flagsB;

    @Column("UiLocomotionType")
    private Byte uiLocomotionType;

    @Column("MissileTargetingID")
    private Integer missileTargetingID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
