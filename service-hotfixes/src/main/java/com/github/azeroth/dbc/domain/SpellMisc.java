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


@Table(name = "spell_misc")
@Db2DataBind(name = "SpellMisc.db2", layoutHash = 0xCDC114D5, parentIndexField = 10, fields = {
        @Db2Field(name = "castingTimeIndex", type = Db2Type.SHORT),
        @Db2Field(name = "durationIndex", type = Db2Type.SHORT),
        @Db2Field(name = "rangeIndex", type = Db2Type.SHORT),
        @Db2Field(name = "schoolMask", type = Db2Type.BYTE),
        @Db2Field(name = "spellIconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "speed", type = Db2Type.FLOAT),
        @Db2Field(name = "activeIconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "launchDelay", type = Db2Type.FLOAT),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = {"attributes1", "attributes2", "attributes3", "attributes4", "attributes5", "attributes6", "attributes7", "attributes8", "attributes9", "attributes10", "attributes11", "attributes12", "attributes13", "attributes14"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellMisc implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("CastingTimeIndex")
    private Short castingTimeIndex;

    @Column("DurationIndex")
    private Short durationIndex;

    @Column("RangeIndex")
    private Short rangeIndex;

    @Column("SchoolMask")
    private Byte schoolMask;

    @Column("SpellIconFileDataID")
    private Integer spellIconFileDataID;

    @Column("Speed")
    private Float speed;

    @Column("ActiveIconFileDataID")
    private Integer activeIconFileDataID;

    @Column("LaunchDelay")
    private Float launchDelay;

    @Column("DifficultyID")
    private Byte difficultyID;

    @Column("Attributes1")
    private Integer attributes1;

    @Column("Attributes2")
    private Integer attributes2;

    @Column("Attributes3")
    private Integer attributes3;

    @Column("Attributes4")
    private Integer attributes4;

    @Column("Attributes5")
    private Integer attributes5;

    @Column("Attributes6")
    private Integer attributes6;

    @Column("Attributes7")
    private Integer attributes7;

    @Column("Attributes8")
    private Integer attributes8;

    @Column("Attributes9")
    private Integer attributes9;

    @Column("Attributes10")
    private Integer attributes10;

    @Column("Attributes11")
    private Integer attributes11;

    @Column("Attributes12")
    private Integer attributes12;

    @Column("Attributes13")
    private Integer attributes13;

    @Column("Attributes14")
    private Integer attributes14;

    @Column("SpellID")
    private Integer spellID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
