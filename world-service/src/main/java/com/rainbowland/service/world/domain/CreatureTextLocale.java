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
@Table("creature_text_locale")
public class CreatureTextLocale {

    @Column("CreatureID")
    private Integer creatureId;
    @Column("GroupID")
    private Integer groupId;
    @Column("ID")
    private Integer id;
    @Column("Locale")
    private String locale;
    @Column("Text")
    private String text;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureTextLocale> {

        public CreatureTextLocale convert(Row row) {
            CreatureTextLocale domain = new CreatureTextLocale();
            domain.setCreatureId(row.get("CreatureID", Integer.class));
            domain.setGroupId(row.get("GroupID", Integer.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("Locale", String.class));
            domain.setText(row.get("Text", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureTextLocale, OutboundRow> {

        public OutboundRow convert(CreatureTextLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCreatureId()).ifPresent(e -> row.put("CreatureID", Parameter.from(e)));
            Optional.ofNullable(source.getGroupId()).ifPresent(e -> row.put("GroupID", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("Locale", Parameter.from(e)));
            Optional.ofNullable(source.getText()).ifPresent(e -> row.put("Text", Parameter.from(e)));
            return row;
        }
    }

}
