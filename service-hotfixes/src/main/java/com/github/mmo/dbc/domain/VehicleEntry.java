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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "TurnSpeed")
    private Float turnSpeed;

    @Column(name = "PitchSpeed")
    private Float pitchSpeed;

    @Column(name = "PitchMin")
    private Float pitchMin;

    @Column(name = "PitchMax")
    private Float pitchMax;

    @Column(name = "MouseLookOffsetPitch")
    private Float mouseLookOffsetPitch;

    @Column(name = "CameraFadeDistScalarMin")
    private Float cameraFadeDistScalarMin;

    @Column(name = "CameraFadeDistScalarMax")
    private Float cameraFadeDistScalarMax;

    @Column(name = "CameraPitchOffset")
    private Float cameraPitchOffset;

    @Column(name = "FacingLimitRight")
    private Float facingLimitRight;

    @Column(name = "FacingLimitLeft")
    private Float facingLimitLeft;

    @Column(name = "CameraYawOffset")
    private Float cameraYawOffset;

    @Column(name = "SeatID1")
    private Short seatID1;

    @Column(name = "SeatID2")
    private Short seatID2;

    @Column(name = "SeatID3")
    private Short seatID3;

    @Column(name = "SeatID4")
    private Short seatID4;

    @Column(name = "SeatID5")
    private Short seatID5;

    @Column(name = "SeatID6")
    private Short seatID6;

    @Column(name = "SeatID7")
    private Short seatID7;

    @Column(name = "SeatID8")
    private Short seatID8;

    @Column(name = "VehicleUIIndicatorID")
    private Short vehicleUIIndicatorID;

    @Column(name = "PowerDisplayID1")
    private Short powerDisplayID1;

    @Column(name = "PowerDisplayID2")
    private Short powerDisplayID2;

    @Column(name = "PowerDisplayID3")
    private Short powerDisplayID3;

    @Column(name = "FlagsB")
    private Byte flagsB;

    @Column(name = "UiLocomotionType")
    private Byte uiLocomotionType;

    @Column(name = "MissileTargetingID")
    private Integer missileTargetingID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
