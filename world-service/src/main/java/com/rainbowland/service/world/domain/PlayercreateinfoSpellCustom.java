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
@Table("playercreateinfo_spell_custom")
public class PlayercreateinfoSpellCustom {

    @Column("racemask")
    private Long racemask;
    @Column("classmask")
    private Integer classmask;
    @Column("Spell")
    private Integer spell;
    @Column("Note")
    private String note;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayercreateinfoSpellCustom> {

        public PlayercreateinfoSpellCustom convert(Row row) {
            PlayercreateinfoSpellCustom domain = new PlayercreateinfoSpellCustom();
            domain.setRacemask(row.get("racemask", Long.class));
            domain.setClassmask(row.get("classmask", Integer.class));
            domain.setSpell(row.get("Spell", Integer.class));
            domain.setNote(row.get("Note", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayercreateinfoSpellCustom, OutboundRow> {

        public OutboundRow convert(PlayercreateinfoSpellCustom source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRacemask()).ifPresent(e -> row.put("racemask", Parameter.from(e)));
            Optional.ofNullable(source.getClassmask()).ifPresent(e -> row.put("classmask", Parameter.from(e)));
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("Spell", Parameter.from(e)));
            Optional.ofNullable(source.getNote()).ifPresent(e -> row.put("Note", Parameter.from(e)));
            return row;
        }
    }

}
