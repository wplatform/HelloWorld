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


@Table(name = "spell_aura_restrictions")
@Db2DataBind(name = "SpellAuraRestrictions.db2", layoutHash = 0x7CDF3311, parentIndexField = 9, fields = {
        @Db2Field(name = "casterAuraSpell", type = Db2Type.INT, signed = true),
        @Db2Field(name = "targetAuraSpell", type = Db2Type.INT, signed = true),
        @Db2Field(name = "excludeCasterAuraSpell", type = Db2Type.INT, signed = true),
        @Db2Field(name = "excludeTargetAuraSpell", type = Db2Type.INT, signed = true),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "casterAuraState", type = Db2Type.BYTE),
        @Db2Field(name = "targetAuraState", type = Db2Type.BYTE),
        @Db2Field(name = "excludeCasterAuraState", type = Db2Type.BYTE),
        @Db2Field(name = "excludeTargetAuraState", type = Db2Type.BYTE),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellAuraRestriction implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("CasterAuraSpell")
    private Integer casterAuraSpell;

    @Column("TargetAuraSpell")
    private Integer targetAuraSpell;

    @Column("ExcludeCasterAuraSpell")
    private Integer excludeCasterAuraSpell;

    @Column("ExcludeTargetAuraSpell")
    private Integer excludeTargetAuraSpell;

    @Column("DifficultyID")
    private Byte difficultyID;

    @Column("CasterAuraState")
    private Byte casterAuraState;

    @Column("TargetAuraState")
    private Byte targetAuraState;

    @Column("ExcludeCasterAuraState")
    private Byte excludeCasterAuraState;

    @Column("ExcludeTargetAuraState")
    private Byte excludeTargetAuraState;

    @Column("SpellID")
    private Integer spellID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
