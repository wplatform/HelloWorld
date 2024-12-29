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

    @Column("ID")
    private int id;

    @Column("SpellID")
    private Integer spellID;

    @Column("ScalesFromItemLevel")
    private Short scalesFromItemLevel;

    @Column("Class")
    private Integer klass;

    @Column("MinScalingLevel")
    private Integer minScalingLevel;

    @Column("MaxScalingLevel")
    private Integer maxScalingLevel;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
