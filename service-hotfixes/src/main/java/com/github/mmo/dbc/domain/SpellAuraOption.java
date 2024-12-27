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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ProcCharges")
    private Integer procCharges;

    @Column(name = "ProcTypeMask")
    private Integer procTypeMask;

    @Column(name = "ProcCategoryRecovery")
    private Integer procCategoryRecovery;

    @Column(name = "CumulativeAura")
    private Short cumulativeAura;

    @Column(name = "SpellProcsPerMinuteID")
    private Short spellProcsPerMinuteID;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "ProcChance")
    private Byte procChance;

    @Column(name = "SpellID")
    private Integer spellID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
