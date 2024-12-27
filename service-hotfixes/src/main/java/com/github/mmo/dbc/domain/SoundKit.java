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
@Table(name = "sound_kit")
@Db2DataBind(name = "SoundKit.db2", layoutHash = 0x0E9CB7AE, indexField = 0, fields = {
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "volumeFloat", type = Db2Type.FLOAT),
        @Db2Field(name = "minDistance", type = Db2Type.FLOAT),
        @Db2Field(name = "distanceCutoff", type = Db2Type.FLOAT),
        @Db2Field(name = "flags", type = Db2Type.SHORT),
        @Db2Field(name = "soundEntriesAdvancedID", type = Db2Type.SHORT),
        @Db2Field(name = "soundType", type = Db2Type.BYTE),
        @Db2Field(name = "dialogType", type = Db2Type.BYTE),
        @Db2Field(name = "eAXDef", type = Db2Type.BYTE),
        @Db2Field(name = "volumeVariationPlus", type = Db2Type.FLOAT),
        @Db2Field(name = "volumeVariationMinus", type = Db2Type.FLOAT),
        @Db2Field(name = "pitchVariationPlus", type = Db2Type.FLOAT),
        @Db2Field(name = "pitchVariationMinus", type = Db2Type.FLOAT),
        @Db2Field(name = "pitchAdjust", type = Db2Type.FLOAT),
        @Db2Field(name = "busOverwriteID", type = Db2Type.SHORT),
        @Db2Field(name = "maxInstances", type = Db2Type.BYTE)
})
public class SoundKit implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "VolumeFloat")
    private Float volumeFloat;

    @Column(name = "MinDistance")
    private Float minDistance;

    @Column(name = "DistanceCutoff")
    private Float distanceCutoff;

    @Column(name = "Flags")
    private Short flags;

    @Column(name = "SoundEntriesAdvancedID")
    private Integer soundEntriesAdvancedID;

    @Column(name = "SoundType")
    private Byte soundType;

    @Column(name = "DialogType")
    private Byte dialogType;

    @Column(name = "EAXDef")
    private Byte eAXDef;

    @Column(name = "VolumeVariationPlus")
    private Float volumeVariationPlus;

    @Column(name = "VolumeVariationMinus")
    private Float volumeVariationMinus;

    @Column(name = "PitchVariationPlus")
    private Float pitchVariationPlus;

    @Column(name = "PitchVariationMinus")
    private Float pitchVariationMinus;

    @Column(name = "PitchAdjust")
    private Float pitchAdjust;

    @Column(name = "BusOverwriteID")
    private Short busOverwriteID;

    @Column(name = "MaxInstances")
    private Byte maxInstances;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
