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


@Table(name = "spell_aura_options")
@Db2DataBind(name = "SpellAuraOptions.db2", layoutHash = 0xE05BE94F, parentIndexField = 7, fields = {
        @Db2Field(name = "procCharges", type = Db2Type.INT, signed = true),
        @Db2Field(name = "procTypeMask", type = Db2Type.INT, signed = true),
        @Db2Field(name = "procCategoryRecovery", type = Db2Type.INT, signed = true),
        @Db2Field(name = "cumulativeAura", type = Db2Type.SHORT),
        @Db2Field(name = "spellProcsPerMinuteID", type = Db2Type.SHORT),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "procChance", type = Db2Type.BYTE),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellAuraOption implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("ProcCharges")
    private Integer procCharges;

    @Column("ProcTypeMask")
    private Integer procTypeMask;

    @Column("ProcCategoryRecovery")
    private Integer procCategoryRecovery;

    @Column("CumulativeAura")
    private Short cumulativeAura;

    @Column("SpellProcsPerMinuteID")
    private Short spellProcsPerMinuteID;

    @Column("DifficultyID")
    private Byte difficultyID;

    @Column("ProcChance")
    private Byte procChance;

    @Column("SpellID")
    private Integer spellID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
