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
@Table("character_template")
public class CharacterTemplate {

    @Column("Id")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("Description")
    private String description;
    @Column("Level")
    private Integer level;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterTemplate> {

        public CharacterTemplate convert(Row row) {
            CharacterTemplate domain = new CharacterTemplate();
            domain.setId(row.get("Id", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setLevel(row.get("Level", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterTemplate, OutboundRow> {

        public OutboundRow convert(CharacterTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("Id", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("Level", Parameter.from(e)));
            return row;
        }
    }

}
