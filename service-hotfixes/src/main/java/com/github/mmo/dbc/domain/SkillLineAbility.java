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
@Table(name = "skill_line_ability")
@Db2DataBind(name = "SkillLineAbility.db2", layoutHash = 0x97B5A653, indexField = 1, parentIndexField = 4, fields = {
        @Db2Field(name = "raceMask", type = Db2Type.LONG, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "spell", type = Db2Type.INT, signed = true),
        @Db2Field(name = "supercedesSpell", type = Db2Type.INT, signed = true),
        @Db2Field(name = "skillLine", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "trivialSkillLineRankHigh", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "trivialSkillLineRankLow", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "uniqueBit", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "tradeSkillCategoryID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "numSkillUps", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "classMask", type = Db2Type.INT, signed = true),
        @Db2Field(name = "minSkillLineRank", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "acquireMethod", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE, signed = true)
})
public class SkillLineAbility implements DbcEntity {
    @Column(name = "RaceMask")
    private Long raceMask;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Spell")
    private Integer spell;

    @Column(name = "SupercedesSpell")
    private Integer supercedesSpell;

    @Column(name = "SkillLine")
    private Short skillLine;

    @Column(name = "TrivialSkillLineRankHigh")
    private Short trivialSkillLineRankHigh;

    @Column(name = "TrivialSkillLineRankLow")
    private Short trivialSkillLineRankLow;

    @Column(name = "UniqueBit")
    private Short uniqueBit;

    @Column(name = "TradeSkillCategoryID")
    private Short tradeSkillCategoryID;

    @Column(name = "NumSkillUps")
    private Byte numSkillUps;

    @Column(name = "ClassMask")
    private Integer classMask;

    @Column(name = "MinSkillLineRank")
    private Short minSkillLineRank;

    @Column(name = "AcquireMethod")
    private Byte acquireMethod;

    @Column(name = "Flags")
    private Byte flags;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
