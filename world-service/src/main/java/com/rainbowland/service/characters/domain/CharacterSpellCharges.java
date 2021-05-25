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
@Table("character_spell_charges")
public class CharacterSpellCharges {

    @Column("guid")
    private Long guid;
    @Column("categoryId")
    private Integer categoryId;
    @Column("rechargeStart")
    private Long rechargeStart;
    @Column("rechargeEnd")
    private Long rechargeEnd;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterSpellCharges> {

        public CharacterSpellCharges convert(Row row) {
            CharacterSpellCharges domain = new CharacterSpellCharges();
            domain.setGuid(row.get("guid", Long.class));
            domain.setCategoryId(row.get("categoryId", Integer.class));
            domain.setRechargeStart(row.get("rechargeStart", Long.class));
            domain.setRechargeEnd(row.get("rechargeEnd", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterSpellCharges, OutboundRow> {

        public OutboundRow convert(CharacterSpellCharges source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryId()).ifPresent(e -> row.put("categoryId", Parameter.from(e)));
            Optional.ofNullable(source.getRechargeStart()).ifPresent(e -> row.put("rechargeStart", Parameter.from(e)));
            Optional.ofNullable(source.getRechargeEnd()).ifPresent(e -> row.put("rechargeEnd", Parameter.from(e)));
            return row;
        }
    }

}
