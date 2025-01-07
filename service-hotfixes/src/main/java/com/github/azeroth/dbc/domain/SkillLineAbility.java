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
    @Column("RaceMask")
    private Long raceMask;

    @Id

    @Column("ID")
    private int id;

    @Column("Spell")
    private Integer spell;

    @Column("SupercedesSpell")
    private Integer supercedesSpell;

    @Column("SkillLine")
    private Short skillLine;

    @Column("TrivialSkillLineRankHigh")
    private Short trivialSkillLineRankHigh;

    @Column("TrivialSkillLineRankLow")
    private Short trivialSkillLineRankLow;

    @Column("UniqueBit")
    private Short uniqueBit;

    @Column("TradeSkillCategoryID")
    private Short tradeSkillCategoryID;

    @Column("NumSkillUps")
    private Byte numSkillUps;

    @Column("ClassMask")
    private Integer classMask;

    @Column("MinSkillLineRank")
    private Short minSkillLineRank;

    @Column("AcquireMethod")
    private Byte acquireMethod;

    @Column("Flags")
    private Byte flags;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
