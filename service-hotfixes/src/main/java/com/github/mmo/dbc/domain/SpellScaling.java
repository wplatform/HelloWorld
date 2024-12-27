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
@Table(name = "spell_scaling")
@Db2DataBind(name = "SpellScaling.db2", layoutHash = 0xF67A5719, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "scalesFromItemLevel", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "klass", type = Db2Type.INT, signed = true),
        @Db2Field(name = "minScalingLevel", type = Db2Type.INT),
        @Db2Field(name = "maxScalingLevel", type = Db2Type.INT)
})
public class SpellScaling implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "ScalesFromItemLevel")
    private Short scalesFromItemLevel;

    @Column(name = "Class")
    private Integer klass;

    @Column(name = "MinScalingLevel")
    private Integer minScalingLevel;

    @Column(name = "MaxScalingLevel")
    private Integer maxScalingLevel;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
