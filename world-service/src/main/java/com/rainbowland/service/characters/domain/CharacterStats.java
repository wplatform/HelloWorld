package com.rainbowland.service.characters.domain;

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
@Table("character_stats")
public class CharacterStats {

    @Column("guid")
    private Long guid;
    @Column("maxhealth")
    private Integer maxhealth;
    @Column("maxpower1")
    private Integer maxpower1;
    @Column("maxpower2")
    private Integer maxpower2;
    @Column("maxpower3")
    private Integer maxpower3;
    @Column("maxpower4")
    private Integer maxpower4;
    @Column("maxpower5")
    private Integer maxpower5;
    @Column("maxpower6")
    private Integer maxpower6;
    @Column("strength")
    private Integer strength;
    @Column("agility")
    private Integer agility;
    @Column("stamina")
    private Integer stamina;
    @Column("intellect")
    private Integer intellect;
    @Column("armor")
    private Integer armor;
    @Column("resHoly")
    private Integer resHoly;
    @Column("resFire")
    private Integer resFire;
    @Column("resNature")
    private Integer resNature;
    @Column("resFrost")
    private Integer resFrost;
    @Column("resShadow")
    private Integer resShadow;
    @Column("resArcane")
    private Integer resArcane;
    @Column("blockPct")
    private Double blockPct;
    @Column("dodgePct")
    private Double dodgePct;
    @Column("parryPct")
    private Double parryPct;
    @Column("critPct")
    private Double critPct;
    @Column("rangedCritPct")
    private Double rangedCritPct;
    @Column("spellCritPct")
    private Double spellCritPct;
    @Column("attackPower")
    private Integer attackPower;
    @Column("rangedAttackPower")
    private Integer rangedAttackPower;
    @Column("spellPower")
    private Integer spellPower;
    @Column("resilience")
    private Integer resilience;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterStats> {

        public CharacterStats convert(Row row) {
            CharacterStats domain = new CharacterStats();
            domain.setGuid(row.get("guid", Long.class));
            domain.setMaxhealth(row.get("maxhealth", Integer.class));
            domain.setMaxpower1(row.get("maxpower1", Integer.class));
            domain.setMaxpower2(row.get("maxpower2", Integer.class));
            domain.setMaxpower3(row.get("maxpower3", Integer.class));
            domain.setMaxpower4(row.get("maxpower4", Integer.class));
            domain.setMaxpower5(row.get("maxpower5", Integer.class));
            domain.setMaxpower6(row.get("maxpower6", Integer.class));
            domain.setStrength(row.get("strength", Integer.class));
            domain.setAgility(row.get("agility", Integer.class));
            domain.setStamina(row.get("stamina", Integer.class));
            domain.setIntellect(row.get("intellect", Integer.class));
            domain.setArmor(row.get("armor", Integer.class));
            domain.setResHoly(row.get("resHoly", Integer.class));
            domain.setResFire(row.get("resFire", Integer.class));
            domain.setResNature(row.get("resNature", Integer.class));
            domain.setResFrost(row.get("resFrost", Integer.class));
            domain.setResShadow(row.get("resShadow", Integer.class));
            domain.setResArcane(row.get("resArcane", Integer.class));
            domain.setBlockPct(row.get("blockPct", Double.class));
            domain.setDodgePct(row.get("dodgePct", Double.class));
            domain.setParryPct(row.get("parryPct", Double.class));
            domain.setCritPct(row.get("critPct", Double.class));
            domain.setRangedCritPct(row.get("rangedCritPct", Double.class));
            domain.setSpellCritPct(row.get("spellCritPct", Double.class));
            domain.setAttackPower(row.get("attackPower", Integer.class));
            domain.setRangedAttackPower(row.get("rangedAttackPower", Integer.class));
            domain.setSpellPower(row.get("spellPower", Integer.class));
            domain.setResilience(row.get("resilience", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterStats, OutboundRow> {

        public OutboundRow convert(CharacterStats source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getMaxhealth()).ifPresent(e -> row.put("maxhealth", Parameter.from(e)));
            Optional.ofNullable(source.getMaxpower1()).ifPresent(e -> row.put("maxpower1", Parameter.from(e)));
            Optional.ofNullable(source.getMaxpower2()).ifPresent(e -> row.put("maxpower2", Parameter.from(e)));
            Optional.ofNullable(source.getMaxpower3()).ifPresent(e -> row.put("maxpower3", Parameter.from(e)));
            Optional.ofNullable(source.getMaxpower4()).ifPresent(e -> row.put("maxpower4", Parameter.from(e)));
            Optional.ofNullable(source.getMaxpower5()).ifPresent(e -> row.put("maxpower5", Parameter.from(e)));
            Optional.ofNullable(source.getMaxpower6()).ifPresent(e -> row.put("maxpower6", Parameter.from(e)));
            Optional.ofNullable(source.getStrength()).ifPresent(e -> row.put("strength", Parameter.from(e)));
            Optional.ofNullable(source.getAgility()).ifPresent(e -> row.put("agility", Parameter.from(e)));
            Optional.ofNullable(source.getStamina()).ifPresent(e -> row.put("stamina", Parameter.from(e)));
            Optional.ofNullable(source.getIntellect()).ifPresent(e -> row.put("intellect", Parameter.from(e)));
            Optional.ofNullable(source.getArmor()).ifPresent(e -> row.put("armor", Parameter.from(e)));
            Optional.ofNullable(source.getResHoly()).ifPresent(e -> row.put("resHoly", Parameter.from(e)));
            Optional.ofNullable(source.getResFire()).ifPresent(e -> row.put("resFire", Parameter.from(e)));
            Optional.ofNullable(source.getResNature()).ifPresent(e -> row.put("resNature", Parameter.from(e)));
            Optional.ofNullable(source.getResFrost()).ifPresent(e -> row.put("resFrost", Parameter.from(e)));
            Optional.ofNullable(source.getResShadow()).ifPresent(e -> row.put("resShadow", Parameter.from(e)));
            Optional.ofNullable(source.getResArcane()).ifPresent(e -> row.put("resArcane", Parameter.from(e)));
            Optional.ofNullable(source.getBlockPct()).ifPresent(e -> row.put("blockPct", Parameter.from(e)));
            Optional.ofNullable(source.getDodgePct()).ifPresent(e -> row.put("dodgePct", Parameter.from(e)));
            Optional.ofNullable(source.getParryPct()).ifPresent(e -> row.put("parryPct", Parameter.from(e)));
            Optional.ofNullable(source.getCritPct()).ifPresent(e -> row.put("critPct", Parameter.from(e)));
            Optional.ofNullable(source.getRangedCritPct()).ifPresent(e -> row.put("rangedCritPct", Parameter.from(e)));
            Optional.ofNullable(source.getSpellCritPct()).ifPresent(e -> row.put("spellCritPct", Parameter.from(e)));
            Optional.ofNullable(source.getAttackPower()).ifPresent(e -> row.put("attackPower", Parameter.from(e)));
            Optional.ofNullable(source.getRangedAttackPower()).ifPresent(e -> row.put("rangedAttackPower", Parameter.from(e)));
            Optional.ofNullable(source.getSpellPower()).ifPresent(e -> row.put("spellPower", Parameter.from(e)));
            Optional.ofNullable(source.getResilience()).ifPresent(e -> row.put("resilience", Parameter.from(e)));
            return row;
        }
    }

}
