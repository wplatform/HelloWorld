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
@Table("spell_power")
public class SpellPower {

    @Column("ID")
    private Integer id;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("ManaCost")
    private Integer manaCost;
    @Column("ManaCostPerLevel")
    private Integer manaCostPerLevel;
    @Column("ManaPerSecond")
    private Integer manaPerSecond;
    @Column("PowerDisplayID")
    private Integer powerDisplayId;
    @Column("AltPowerBarID")
    private Integer altPowerBarId;
    @Column("PowerCostPct")
    private Double powerCostPct;
    @Column("PowerCostMaxPct")
    private Double powerCostMaxPct;
    @Column("PowerPctPerSecond")
    private Double powerPctPerSecond;
    @Column("PowerType")
    private Integer powerType;
    @Column("RequiredAuraSpellID")
    private Integer requiredAuraSpellId;
    @Column("OptionalCost")
    private Integer optionalCost;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellPower> {

        public SpellPower convert(Row row) {
            SpellPower domain = new SpellPower();
            domain.setId(row.get("ID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setManaCost(row.get("ManaCost", Integer.class));
            domain.setManaCostPerLevel(row.get("ManaCostPerLevel", Integer.class));
            domain.setManaPerSecond(row.get("ManaPerSecond", Integer.class));
            domain.setPowerDisplayId(row.get("PowerDisplayID", Integer.class));
            domain.setAltPowerBarId(row.get("AltPowerBarID", Integer.class));
            domain.setPowerCostPct(row.get("PowerCostPct", Double.class));
            domain.setPowerCostMaxPct(row.get("PowerCostMaxPct", Double.class));
            domain.setPowerPctPerSecond(row.get("PowerPctPerSecond", Double.class));
            domain.setPowerType(row.get("PowerType", Integer.class));
            domain.setRequiredAuraSpellId(row.get("RequiredAuraSpellID", Integer.class));
            domain.setOptionalCost(row.get("OptionalCost", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellPower, OutboundRow> {

        public OutboundRow convert(SpellPower source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getManaCost()).ifPresent(e -> row.put("ManaCost", Parameter.from(e)));
            Optional.ofNullable(source.getManaCostPerLevel()).ifPresent(e -> row.put("ManaCostPerLevel", Parameter.from(e)));
            Optional.ofNullable(source.getManaPerSecond()).ifPresent(e -> row.put("ManaPerSecond", Parameter.from(e)));
            Optional.ofNullable(source.getPowerDisplayId()).ifPresent(e -> row.put("PowerDisplayID", Parameter.from(e)));
            Optional.ofNullable(source.getAltPowerBarId()).ifPresent(e -> row.put("AltPowerBarID", Parameter.from(e)));
            Optional.ofNullable(source.getPowerCostPct()).ifPresent(e -> row.put("PowerCostPct", Parameter.from(e)));
            Optional.ofNullable(source.getPowerCostMaxPct()).ifPresent(e -> row.put("PowerCostMaxPct", Parameter.from(e)));
            Optional.ofNullable(source.getPowerPctPerSecond()).ifPresent(e -> row.put("PowerPctPerSecond", Parameter.from(e)));
            Optional.ofNullable(source.getPowerType()).ifPresent(e -> row.put("PowerType", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredAuraSpellId()).ifPresent(e -> row.put("RequiredAuraSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getOptionalCost()).ifPresent(e -> row.put("OptionalCost", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
