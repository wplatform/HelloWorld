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
@Table(name = "spell_levels")
@Db2DataBind(name = "SpellLevels.db2", layoutHash = 0x9E7D1CCD, parentIndexField = 5, fields = {
        @Db2Field(name = "baseLevel", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "maxLevel", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "spellLevel", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "maxPassiveAuraLevel", type = Db2Type.BYTE),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellLevel implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "BaseLevel")
    private Short baseLevel;

    @Column(name = "MaxLevel")
    private Short maxLevel;

    @Column(name = "SpellLevel")
    private Short spellLevel;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "MaxPassiveAuraLevel")
    private Byte maxPassiveAuraLevel;

    @Column(name = "SpellID")
    private Integer spellID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
