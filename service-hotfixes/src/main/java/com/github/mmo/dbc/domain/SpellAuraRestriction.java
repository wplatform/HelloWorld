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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "CasterAuraSpell")
    private Integer casterAuraSpell;

    @Column(name = "TargetAuraSpell")
    private Integer targetAuraSpell;

    @Column(name = "ExcludeCasterAuraSpell")
    private Integer excludeCasterAuraSpell;

    @Column(name = "ExcludeTargetAuraSpell")
    private Integer excludeTargetAuraSpell;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "CasterAuraState")
    private Byte casterAuraState;

    @Column(name = "TargetAuraState")
    private Byte targetAuraState;

    @Column(name = "ExcludeCasterAuraState")
    private Byte excludeCasterAuraState;

    @Column(name = "ExcludeTargetAuraState")
    private Byte excludeTargetAuraState;

    @Column(name = "SpellID")
    private Integer spellID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
