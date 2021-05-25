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
@Table("spell_item_enchantment")
public class SpellItemEnchantment {

    @Column("Name")
    private String name;
    @Column("HordeName")
    private String hordeName;
    @Column("ID")
    private Integer id;
    @Column("EffectArg1")
    private Integer effectArg1;
    @Column("EffectArg2")
    private Integer effectArg2;
    @Column("EffectArg3")
    private Integer effectArg3;
    @Column("EffectScalingPoints1")
    private Double effectScalingPoints1;
    @Column("EffectScalingPoints2")
    private Double effectScalingPoints2;
    @Column("EffectScalingPoints3")
    private Double effectScalingPoints3;
    @Column("IconFileDataID")
    private Integer iconFileDataId;
    @Column("TransmogCost")
    private Integer transmogCost;
    @Column("MinItemLevel")
    private Integer minItemLevel;
    @Column("MaxItemLevel")
    private Integer maxItemLevel;
    @Column("TransmogUseConditionID")
    private Integer transmogUseConditionId;
    @Column("EffectPointsMin1")
    private Integer effectPointsMin1;
    @Column("EffectPointsMin2")
    private Integer effectPointsMin2;
    @Column("EffectPointsMin3")
    private Integer effectPointsMin3;
    @Column("ItemVisual")
    private Integer itemVisual;
    @Column("Flags")
    private Integer flags;
    @Column("RequiredSkillID")
    private Integer requiredSkillId;
    @Column("RequiredSkillRank")
    private Integer requiredSkillRank;
    @Column("ItemLevel")
    private Integer itemLevel;
    @Column("Charges")
    private Integer charges;
    @Column("Effect1")
    private Integer effect1;
    @Column("Effect2")
    private Integer effect2;
    @Column("Effect3")
    private Integer effect3;
    @Column("ScalingClass")
    private Integer scalingClass;
    @Column("ScalingClassRestricted")
    private Integer scalingClassRestricted;
    @Column("ConditionID")
    private Integer conditionId;
    @Column("MinLevel")
    private Integer minLevel;
    @Column("MaxLevel")
    private Integer maxLevel;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellItemEnchantment> {

        public SpellItemEnchantment convert(Row row) {
            SpellItemEnchantment domain = new SpellItemEnchantment();
            domain.setName(row.get("Name", String.class));
            domain.setHordeName(row.get("HordeName", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setEffectArg1(row.get("EffectArg1", Integer.class));
            domain.setEffectArg2(row.get("EffectArg2", Integer.class));
            domain.setEffectArg3(row.get("EffectArg3", Integer.class));
            domain.setEffectScalingPoints1(row.get("EffectScalingPoints1", Double.class));
            domain.setEffectScalingPoints2(row.get("EffectScalingPoints2", Double.class));
            domain.setEffectScalingPoints3(row.get("EffectScalingPoints3", Double.class));
            domain.setIconFileDataId(row.get("IconFileDataID", Integer.class));
            domain.setTransmogCost(row.get("TransmogCost", Integer.class));
            domain.setMinItemLevel(row.get("MinItemLevel", Integer.class));
            domain.setMaxItemLevel(row.get("MaxItemLevel", Integer.class));
            domain.setTransmogUseConditionId(row.get("TransmogUseConditionID", Integer.class));
            domain.setEffectPointsMin1(row.get("EffectPointsMin1", Integer.class));
            domain.setEffectPointsMin2(row.get("EffectPointsMin2", Integer.class));
            domain.setEffectPointsMin3(row.get("EffectPointsMin3", Integer.class));
            domain.setItemVisual(row.get("ItemVisual", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setRequiredSkillId(row.get("RequiredSkillID", Integer.class));
            domain.setRequiredSkillRank(row.get("RequiredSkillRank", Integer.class));
            domain.setItemLevel(row.get("ItemLevel", Integer.class));
            domain.setCharges(row.get("Charges", Integer.class));
            domain.setEffect1(row.get("Effect1", Integer.class));
            domain.setEffect2(row.get("Effect2", Integer.class));
            domain.setEffect3(row.get("Effect3", Integer.class));
            domain.setScalingClass(row.get("ScalingClass", Integer.class));
            domain.setScalingClassRestricted(row.get("ScalingClassRestricted", Integer.class));
            domain.setConditionId(row.get("ConditionID", Integer.class));
            domain.setMinLevel(row.get("MinLevel", Integer.class));
            domain.setMaxLevel(row.get("MaxLevel", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellItemEnchantment, OutboundRow> {

        public OutboundRow convert(SpellItemEnchantment source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getHordeName()).ifPresent(e -> row.put("HordeName", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getEffectArg1()).ifPresent(e -> row.put("EffectArg1", Parameter.from(e)));
            Optional.ofNullable(source.getEffectArg2()).ifPresent(e -> row.put("EffectArg2", Parameter.from(e)));
            Optional.ofNullable(source.getEffectArg3()).ifPresent(e -> row.put("EffectArg3", Parameter.from(e)));
            Optional.ofNullable(source.getEffectScalingPoints1()).ifPresent(e -> row.put("EffectScalingPoints1", Parameter.from(e)));
            Optional.ofNullable(source.getEffectScalingPoints2()).ifPresent(e -> row.put("EffectScalingPoints2", Parameter.from(e)));
            Optional.ofNullable(source.getEffectScalingPoints3()).ifPresent(e -> row.put("EffectScalingPoints3", Parameter.from(e)));
            Optional.ofNullable(source.getIconFileDataId()).ifPresent(e -> row.put("IconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getTransmogCost()).ifPresent(e -> row.put("TransmogCost", Parameter.from(e)));
            Optional.ofNullable(source.getMinItemLevel()).ifPresent(e -> row.put("MinItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxItemLevel()).ifPresent(e -> row.put("MaxItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getTransmogUseConditionId()).ifPresent(e -> row.put("TransmogUseConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getEffectPointsMin1()).ifPresent(e -> row.put("EffectPointsMin1", Parameter.from(e)));
            Optional.ofNullable(source.getEffectPointsMin2()).ifPresent(e -> row.put("EffectPointsMin2", Parameter.from(e)));
            Optional.ofNullable(source.getEffectPointsMin3()).ifPresent(e -> row.put("EffectPointsMin3", Parameter.from(e)));
            Optional.ofNullable(source.getItemVisual()).ifPresent(e -> row.put("ItemVisual", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSkillId()).ifPresent(e -> row.put("RequiredSkillID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSkillRank()).ifPresent(e -> row.put("RequiredSkillRank", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevel()).ifPresent(e -> row.put("ItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getCharges()).ifPresent(e -> row.put("Charges", Parameter.from(e)));
            Optional.ofNullable(source.getEffect1()).ifPresent(e -> row.put("Effect1", Parameter.from(e)));
            Optional.ofNullable(source.getEffect2()).ifPresent(e -> row.put("Effect2", Parameter.from(e)));
            Optional.ofNullable(source.getEffect3()).ifPresent(e -> row.put("Effect3", Parameter.from(e)));
            Optional.ofNullable(source.getScalingClass()).ifPresent(e -> row.put("ScalingClass", Parameter.from(e)));
            Optional.ofNullable(source.getScalingClassRestricted()).ifPresent(e -> row.put("ScalingClassRestricted", Parameter.from(e)));
            Optional.ofNullable(source.getConditionId()).ifPresent(e -> row.put("ConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getMinLevel()).ifPresent(e -> row.put("MinLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevel()).ifPresent(e -> row.put("MaxLevel", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
