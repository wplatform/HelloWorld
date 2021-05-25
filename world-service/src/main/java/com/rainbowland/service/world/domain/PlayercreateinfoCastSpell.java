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
@Table("playercreateinfo_cast_spell")
public class PlayercreateinfoCastSpell {

    @Column("raceMask")
    private Long raceMask;
    @Column("classMask")
    private Integer classMask;
    @Column("spell")
    private Integer spell;
    @Column("note")
    private String note;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayercreateinfoCastSpell> {

        public PlayercreateinfoCastSpell convert(Row row) {
            PlayercreateinfoCastSpell domain = new PlayercreateinfoCastSpell();
            domain.setRaceMask(row.get("raceMask", Long.class));
            domain.setClassMask(row.get("classMask", Integer.class));
            domain.setSpell(row.get("spell", Integer.class));
            domain.setNote(row.get("note", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayercreateinfoCastSpell, OutboundRow> {

        public OutboundRow convert(PlayercreateinfoCastSpell source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRaceMask()).ifPresent(e -> row.put("raceMask", Parameter.from(e)));
            Optional.ofNullable(source.getClassMask()).ifPresent(e -> row.put("classMask", Parameter.from(e)));
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("spell", Parameter.from(e)));
            Optional.ofNullable(source.getNote()).ifPresent(e -> row.put("note", Parameter.from(e)));
            return row;
        }
    }

}
