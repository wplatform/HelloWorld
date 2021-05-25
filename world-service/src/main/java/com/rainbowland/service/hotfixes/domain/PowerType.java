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
@Table("power_type")
public class PowerType {

    @Column("NameGlobalStringTag")
    private String nameGlobalStringTag;
    @Column("CostGlobalStringTag")
    private String costGlobalStringTag;
    @Column("ID")
    private Integer id;
    @Column("PowerTypeEnum")
    private Integer powerTypeEnum;
    @Column("MinPower")
    private Integer minPower;
    @Column("MaxBasePower")
    private Integer maxBasePower;
    @Column("CenterPower")
    private Integer centerPower;
    @Column("DefaultPower")
    private Integer defaultPower;
    @Column("DisplayModifier")
    private Integer displayModifier;
    @Column("RegenInterruptTimeMS")
    private Integer regenInterruptTimeMs;
    @Column("RegenPeace")
    private Double regenPeace;
    @Column("RegenCombat")
    private Double regenCombat;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PowerType> {

        public PowerType convert(Row row) {
            PowerType domain = new PowerType();
            domain.setNameGlobalStringTag(row.get("NameGlobalStringTag", String.class));
            domain.setCostGlobalStringTag(row.get("CostGlobalStringTag", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setPowerTypeEnum(row.get("PowerTypeEnum", Integer.class));
            domain.setMinPower(row.get("MinPower", Integer.class));
            domain.setMaxBasePower(row.get("MaxBasePower", Integer.class));
            domain.setCenterPower(row.get("CenterPower", Integer.class));
            domain.setDefaultPower(row.get("DefaultPower", Integer.class));
            domain.setDisplayModifier(row.get("DisplayModifier", Integer.class));
            domain.setRegenInterruptTimeMs(row.get("RegenInterruptTimeMS", Integer.class));
            domain.setRegenPeace(row.get("RegenPeace", Double.class));
            domain.setRegenCombat(row.get("RegenCombat", Double.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PowerType, OutboundRow> {

        public OutboundRow convert(PowerType source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getNameGlobalStringTag()).ifPresent(e -> row.put("NameGlobalStringTag", Parameter.from(e)));
            Optional.ofNullable(source.getCostGlobalStringTag()).ifPresent(e -> row.put("CostGlobalStringTag", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPowerTypeEnum()).ifPresent(e -> row.put("PowerTypeEnum", Parameter.from(e)));
            Optional.ofNullable(source.getMinPower()).ifPresent(e -> row.put("MinPower", Parameter.from(e)));
            Optional.ofNullable(source.getMaxBasePower()).ifPresent(e -> row.put("MaxBasePower", Parameter.from(e)));
            Optional.ofNullable(source.getCenterPower()).ifPresent(e -> row.put("CenterPower", Parameter.from(e)));
            Optional.ofNullable(source.getDefaultPower()).ifPresent(e -> row.put("DefaultPower", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayModifier()).ifPresent(e -> row.put("DisplayModifier", Parameter.from(e)));
            Optional.ofNullable(source.getRegenInterruptTimeMs()).ifPresent(e -> row.put("RegenInterruptTimeMS", Parameter.from(e)));
            Optional.ofNullable(source.getRegenPeace()).ifPresent(e -> row.put("RegenPeace", Parameter.from(e)));
            Optional.ofNullable(source.getRegenCombat()).ifPresent(e -> row.put("RegenCombat", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
