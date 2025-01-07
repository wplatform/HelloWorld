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

    @Column("ID")
    private int id;

    @Column("BaseLevel")
    private Short baseLevel;

    @Column("MaxLevel")
    private Short maxLevel;

    @Column("SpellLevel")
    private Short spellLevel;

    @Column("DifficultyID")
    private Byte difficultyID;

    @Column("MaxPassiveAuraLevel")
    private Byte maxPassiveAuraLevel;

    @Column("SpellID")
    private Integer spellID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
