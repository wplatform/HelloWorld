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
@Table("spell_group")
public class SpellGroup {

    @Column("id")
    private Integer id;
    @Column("spell_id")
    private Integer spellId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellGroup> {

        public SpellGroup convert(Row row) {
            SpellGroup domain = new SpellGroup();
            domain.setId(row.get("id", Integer.class));
            domain.setSpellId(row.get("spell_id", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellGroup, OutboundRow> {

        public OutboundRow convert(SpellGroup source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("spell_id", Parameter.from(e)));
            return row;
        }
    }

}
