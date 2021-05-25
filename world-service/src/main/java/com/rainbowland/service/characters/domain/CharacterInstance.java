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
@Table("character_instance")
public class CharacterInstance {

    @Column("guid")
    private Long guid;
    @Column("instance")
    private Integer instance;
    @Column("permanent")
    private Integer permanent;
    @Column("extendState")
    private Integer extendState;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterInstance> {

        public CharacterInstance convert(Row row) {
            CharacterInstance domain = new CharacterInstance();
            domain.setGuid(row.get("guid", Long.class));
            domain.setInstance(row.get("instance", Integer.class));
            domain.setPermanent(row.get("permanent", Integer.class));
            domain.setExtendState(row.get("extendState", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterInstance, OutboundRow> {

        public OutboundRow convert(CharacterInstance source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getInstance()).ifPresent(e -> row.put("instance", Parameter.from(e)));
            Optional.ofNullable(source.getPermanent()).ifPresent(e -> row.put("permanent", Parameter.from(e)));
            Optional.ofNullable(source.getExtendState()).ifPresent(e -> row.put("extendState", Parameter.from(e)));
            return row;
        }
    }

}
