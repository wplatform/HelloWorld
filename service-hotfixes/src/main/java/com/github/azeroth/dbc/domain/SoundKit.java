package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


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

    @Column("ID")
    private int id;

    @Column("VolumeFloat")
    private Float volumeFloat;

    @Column("MinDistance")
    private Float minDistance;

    @Column("DistanceCutoff")
    private Float distanceCutoff;

    @Column("Flags")
    private Short flags;

    @Column("SoundEntriesAdvancedID")
    private Integer soundEntriesAdvancedID;

    @Column("SoundType")
    private Byte soundType;

    @Column("DialogType")
    private Byte dialogType;

    @Column("EAXDef")
    private Byte eAXDef;

    @Column("VolumeVariationPlus")
    private Float volumeVariationPlus;

    @Column("VolumeVariationMinus")
    private Float volumeVariationMinus;

    @Column("PitchVariationPlus")
    private Float pitchVariationPlus;

    @Column("PitchVariationMinus")
    private Float pitchVariationMinus;

    @Column("PitchAdjust")
    private Float pitchAdjust;

    @Column("BusOverwriteID")
    private Short busOverwriteID;

    @Column("MaxInstances")
    private Byte maxInstances;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
