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
@Table("character_template_class")
public class CharacterTemplateClass {

    @Column("TemplateId")
    private Integer templateId;
    @Column("FactionGroup")
    private Integer factionGroup;
    @Column("Class")
    private Integer klass;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterTemplateClass> {

        public CharacterTemplateClass convert(Row row) {
            CharacterTemplateClass domain = new CharacterTemplateClass();
            domain.setTemplateId(row.get("TemplateId", Integer.class));
            domain.setFactionGroup(row.get("FactionGroup", Integer.class));
            domain.setKlass(row.get("Class", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterTemplateClass, OutboundRow> {

        public OutboundRow convert(CharacterTemplateClass source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getTemplateId()).ifPresent(e -> row.put("TemplateId", Parameter.from(e)));
            Optional.ofNullable(source.getFactionGroup()).ifPresent(e -> row.put("FactionGroup", Parameter.from(e)));
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("Class", Parameter.from(e)));
            return row;
        }
    }

}
