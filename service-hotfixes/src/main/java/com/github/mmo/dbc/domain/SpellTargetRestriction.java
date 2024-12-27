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
@Table(name = "spell_target_restrictions")
@Db2DataBind(name = "SpellTargetRestrictions.db2", layoutHash = 0x7B330026, parentIndexField = 7, fields = {
        @Db2Field(name = "coneDegrees", type = Db2Type.FLOAT),
        @Db2Field(name = "width", type = Db2Type.FLOAT),
        @Db2Field(name = "targets", type = Db2Type.INT, signed = true),
        @Db2Field(name = "targetCreatureType", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "maxTargets", type = Db2Type.BYTE),
        @Db2Field(name = "maxTargetLevel", type = Db2Type.INT),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellTargetRestriction implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ConeDegrees")
    private Float coneDegrees;

    @Column(name = "Width")
    private Float width;

    @Column(name = "Targets")
    private Integer targets;

    @Column(name = "TargetCreatureType")
    private Short targetCreatureType;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "MaxTargets")
    private Short maxTargets;

    @Column(name = "MaxTargetLevel")
    private Integer maxTargetLevel;

    @Column(name = "SpellID")
    private Integer spellID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
