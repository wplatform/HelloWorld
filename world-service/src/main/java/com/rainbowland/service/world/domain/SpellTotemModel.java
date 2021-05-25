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
@Table("spell_totem_model")
public class SpellTotemModel {

    @Column("SpellID")
    private Integer spellId;
    @Column("RaceID")
    private Integer raceId;
    @Column("DisplayID")
    private Integer displayId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellTotemModel> {

        public SpellTotemModel convert(Row row) {
            SpellTotemModel domain = new SpellTotemModel();
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setRaceId(row.get("RaceID", Integer.class));
            domain.setDisplayId(row.get("DisplayID", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellTotemModel, OutboundRow> {

        public OutboundRow convert(SpellTotemModel source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getRaceId()).ifPresent(e -> row.put("RaceID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayId()).ifPresent(e -> row.put("DisplayID", Parameter.from(e)));
            return row;
        }
    }

}
