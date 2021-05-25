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
@Table("character_currency")
public class CharacterCurrency {

    @Column("CharacterGuid")
    private Long characterGuid;
    @Column("Currency")
    private Integer currency;
    @Column("Quantity")
    private Integer quantity;
    @Column("WeeklyQuantity")
    private Integer weeklyQuantity;
    @Column("TrackedQuantity")
    private Integer trackedQuantity;
    @Column("Flags")
    private Integer flags;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterCurrency> {

        public CharacterCurrency convert(Row row) {
            CharacterCurrency domain = new CharacterCurrency();
            domain.setCharacterGuid(row.get("CharacterGuid", Long.class));
            domain.setCurrency(row.get("Currency", Integer.class));
            domain.setQuantity(row.get("Quantity", Integer.class));
            domain.setWeeklyQuantity(row.get("WeeklyQuantity", Integer.class));
            domain.setTrackedQuantity(row.get("TrackedQuantity", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterCurrency, OutboundRow> {

        public OutboundRow convert(CharacterCurrency source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCharacterGuid()).ifPresent(e -> row.put("CharacterGuid", Parameter.from(e)));
            Optional.ofNullable(source.getCurrency()).ifPresent(e -> row.put("Currency", Parameter.from(e)));
            Optional.ofNullable(source.getQuantity()).ifPresent(e -> row.put("Quantity", Parameter.from(e)));
            Optional.ofNullable(source.getWeeklyQuantity()).ifPresent(e -> row.put("WeeklyQuantity", Parameter.from(e)));
            Optional.ofNullable(source.getTrackedQuantity()).ifPresent(e -> row.put("TrackedQuantity", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            return row;
        }
    }

}
