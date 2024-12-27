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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "CastingTimeIndex")
    private Short castingTimeIndex;

    @Column(name = "DurationIndex")
    private Short durationIndex;

    @Column(name = "RangeIndex")
    private Short rangeIndex;

    @Column(name = "SchoolMask")
    private Byte schoolMask;

    @Column(name = "SpellIconFileDataID")
    private Integer spellIconFileDataID;

    @Column(name = "Speed")
    private Float speed;

    @Column(name = "ActiveIconFileDataID")
    private Integer activeIconFileDataID;

    @Column(name = "LaunchDelay")
    private Float launchDelay;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "Attributes1")
    private Integer attributes1;

    @Column(name = "Attributes2")
    private Integer attributes2;

    @Column(name = "Attributes3")
    private Integer attributes3;

    @Column(name = "Attributes4")
    private Integer attributes4;

    @Column(name = "Attributes5")
    private Integer attributes5;

    @Column(name = "Attributes6")
    private Integer attributes6;

    @Column(name = "Attributes7")
    private Integer attributes7;

    @Column(name = "Attributes8")
    private Integer attributes8;

    @Column(name = "Attributes9")
    private Integer attributes9;

    @Column(name = "Attributes10")
    private Integer attributes10;

    @Column(name = "Attributes11")
    private Integer attributes11;

    @Column(name = "Attributes12")
    private Integer attributes12;

    @Column(name = "Attributes13")
    private Integer attributes13;

    @Column(name = "Attributes14")
    private Integer attributes14;

    @Column(name = "SpellID")
    private Integer spellID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
