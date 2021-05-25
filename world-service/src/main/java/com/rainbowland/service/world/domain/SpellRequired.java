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
@Table("spell_required")
public class SpellRequired {

    @Column("spell_id")
    private Integer spellId;
    @Column("req_spell")
    private Integer reqSpell;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellRequired> {

        public SpellRequired convert(Row row) {
            SpellRequired domain = new SpellRequired();
            domain.setSpellId(row.get("spell_id", Integer.class));
            domain.setReqSpell(row.get("req_spell", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellRequired, OutboundRow> {

        public OutboundRow convert(SpellRequired source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("spell_id", Parameter.from(e)));
            Optional.ofNullable(source.getReqSpell()).ifPresent(e -> row.put("req_spell", Parameter.from(e)));
            return row;
        }
    }

}
