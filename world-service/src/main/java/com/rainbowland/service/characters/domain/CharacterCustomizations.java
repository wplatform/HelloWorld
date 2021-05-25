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
@Table("character_customizations")
public class CharacterCustomizations {

    @Column("guid")
    private Long guid;
    @Column("chrCustomizationOptionID")
    private Integer chrCustomizationOptionId;
    @Column("chrCustomizationChoiceID")
    private Integer chrCustomizationChoiceId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterCustomizations> {

        public CharacterCustomizations convert(Row row) {
            CharacterCustomizations domain = new CharacterCustomizations();
            domain.setGuid(row.get("guid", Long.class));
            domain.setChrCustomizationOptionId(row.get("chrCustomizationOptionID", Integer.class));
            domain.setChrCustomizationChoiceId(row.get("chrCustomizationChoiceID", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterCustomizations, OutboundRow> {

        public OutboundRow convert(CharacterCustomizations source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationOptionId()).ifPresent(e -> row.put("chrCustomizationOptionID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationChoiceId()).ifPresent(e -> row.put("chrCustomizationChoiceID", Parameter.from(e)));
            return row;
        }
    }

}
