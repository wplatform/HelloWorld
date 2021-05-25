package com.rainbowland.service.world.domain;

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
@Table("spell_enchant_proc_data")
public class SpellEnchantProcData {

    @Column("EnchantID")
    private Integer enchantId;
    @Column("Chance")
    private Double chance;
    @Column("ProcsPerMinute")
    private Double procsPerMinute;
    @Column("HitMask")
    private Integer hitMask;
    @Column("AttributesMask")
    private Integer attributesMask;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellEnchantProcData> {

        public SpellEnchantProcData convert(Row row) {
            SpellEnchantProcData domain = new SpellEnchantProcData();
            domain.setEnchantId(row.get("EnchantID", Integer.class));
            domain.setChance(row.get("Chance", Double.class));
            domain.setProcsPerMinute(row.get("ProcsPerMinute", Double.class));
            domain.setHitMask(row.get("HitMask", Integer.class));
            domain.setAttributesMask(row.get("AttributesMask", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellEnchantProcData, OutboundRow> {

        public OutboundRow convert(SpellEnchantProcData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEnchantId()).ifPresent(e -> row.put("EnchantID", Parameter.from(e)));
            Optional.ofNullable(source.getChance()).ifPresent(e -> row.put("Chance", Parameter.from(e)));
            Optional.ofNullable(source.getProcsPerMinute()).ifPresent(e -> row.put("ProcsPerMinute", Parameter.from(e)));
            Optional.ofNullable(source.getHitMask()).ifPresent(e -> row.put("HitMask", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesMask()).ifPresent(e -> row.put("AttributesMask", Parameter.from(e)));
            return row;
        }
    }

}
