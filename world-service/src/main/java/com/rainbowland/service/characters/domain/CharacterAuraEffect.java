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
@Table("character_aura_effect")
public class CharacterAuraEffect {

    @Column("guid")
    private Long guid;
    @Column("casterGuid")
    private byte[] casterGuid;
    @Column("itemGuid")
    private byte[] itemGuid;
    @Column("spell")
    private Integer spell;
    @Column("effectMask")
    private Integer effectMask;
    @Column("effectIndex")
    private Integer effectIndex;
    @Column("amount")
    private Integer amount;
    @Column("baseAmount")
    private Integer baseAmount;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterAuraEffect> {

        public CharacterAuraEffect convert(Row row) {
            CharacterAuraEffect domain = new CharacterAuraEffect();
            domain.setGuid(row.get("guid", Long.class));
            domain.setCasterGuid(row.get("casterGuid", byte[].class));
            domain.setItemGuid(row.get("itemGuid", byte[].class));
            domain.setSpell(row.get("spell", Integer.class));
            domain.setEffectMask(row.get("effectMask", Integer.class));
            domain.setEffectIndex(row.get("effectIndex", Integer.class));
            domain.setAmount(row.get("amount", Integer.class));
            domain.setBaseAmount(row.get("baseAmount", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterAuraEffect, OutboundRow> {

        public OutboundRow convert(CharacterAuraEffect source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getCasterGuid()).ifPresent(e -> row.put("casterGuid", Parameter.from(e)));
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("spell", Parameter.from(e)));
            Optional.ofNullable(source.getEffectMask()).ifPresent(e -> row.put("effectMask", Parameter.from(e)));
            Optional.ofNullable(source.getEffectIndex()).ifPresent(e -> row.put("effectIndex", Parameter.from(e)));
            Optional.ofNullable(source.getAmount()).ifPresent(e -> row.put("amount", Parameter.from(e)));
            Optional.ofNullable(source.getBaseAmount()).ifPresent(e -> row.put("baseAmount", Parameter.from(e)));
            return row;
        }
    }

}
