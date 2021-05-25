package com.rainbowland.service.hotfixes.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("skill_line_ability")
public class SkillLineAbility {

    @Column("RaceMask")
    private Long raceMask;
    @Column("ID")
    private Integer id;
    @Column("SkillLine")
    private Integer skillLine;
    @Column("Spell")
    private Integer spell;
    @Column("MinSkillLineRank")
    private Integer minSkillLineRank;
    @Column("ClassMask")
    private Integer classMask;
    @Column("SupercedesSpell")
    private Integer supercedesSpell;
    @Column("AcquireMethod")
    private Integer acquireMethod;
    @Column("TrivialSkillLineRankHigh")
    private Integer trivialSkillLineRankHigh;
    @Column("TrivialSkillLineRankLow")
    private Integer trivialSkillLineRankLow;
    @Column("Flags")
    private Integer flags;
    @Column("NumSkillUps")
    private Integer numSkillUps;
    @Column("UniqueBit")
    private Integer uniqueBit;
    @Column("TradeSkillCategoryID")
    private Integer tradeSkillCategoryId;
    @Column("SkillupSkillLineID")
    private Integer skillupSkillLineId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SkillLineAbility> {

        public SkillLineAbility convert(Row row) {
            SkillLineAbility domain = new SkillLineAbility();
            domain.setRaceMask(row.get("RaceMask", Long.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setSkillLine(row.get("SkillLine", Integer.class));
            domain.setSpell(row.get("Spell", Integer.class));
            domain.setMinSkillLineRank(row.get("MinSkillLineRank", Integer.class));
            domain.setClassMask(row.get("ClassMask", Integer.class));
            domain.setSupercedesSpell(row.get("SupercedesSpell", Integer.class));
            domain.setAcquireMethod(row.get("AcquireMethod", Integer.class));
            domain.setTrivialSkillLineRankHigh(row.get("TrivialSkillLineRankHigh", Integer.class));
            domain.setTrivialSkillLineRankLow(row.get("TrivialSkillLineRankLow", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setNumSkillUps(row.get("NumSkillUps", Integer.class));
            domain.setUniqueBit(row.get("UniqueBit", Integer.class));
            domain.setTradeSkillCategoryId(row.get("TradeSkillCategoryID", Integer.class));
            domain.setSkillupSkillLineId(row.get("SkillupSkillLineID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SkillLineAbility, OutboundRow> {

        public OutboundRow convert(SkillLineAbility source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRaceMask()).ifPresent(e -> row.put("RaceMask", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSkillLine()).ifPresent(e -> row.put("SkillLine", Parameter.from(e)));
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("Spell", Parameter.from(e)));
            Optional.ofNullable(source.getMinSkillLineRank()).ifPresent(e -> row.put("MinSkillLineRank", Parameter.from(e)));
            Optional.ofNullable(source.getClassMask()).ifPresent(e -> row.put("ClassMask", Parameter.from(e)));
            Optional.ofNullable(source.getSupercedesSpell()).ifPresent(e -> row.put("SupercedesSpell", Parameter.from(e)));
            Optional.ofNullable(source.getAcquireMethod()).ifPresent(e -> row.put("AcquireMethod", Parameter.from(e)));
            Optional.ofNullable(source.getTrivialSkillLineRankHigh()).ifPresent(e -> row.put("TrivialSkillLineRankHigh", Parameter.from(e)));
            Optional.ofNullable(source.getTrivialSkillLineRankLow()).ifPresent(e -> row.put("TrivialSkillLineRankLow", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getNumSkillUps()).ifPresent(e -> row.put("NumSkillUps", Parameter.from(e)));
            Optional.ofNullable(source.getUniqueBit()).ifPresent(e -> row.put("UniqueBit", Parameter.from(e)));
            Optional.ofNullable(source.getTradeSkillCategoryId()).ifPresent(e -> row.put("TradeSkillCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getSkillupSkillLineId()).ifPresent(e -> row.put("SkillupSkillLineID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
