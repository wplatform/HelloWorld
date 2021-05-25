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
@Table("spell_script_names")
public class SpellScriptNames {

    @Column("spell_id")
    private Integer spellId;
    @Column("ScriptName")
    private String scriptName;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellScriptNames> {

        public SpellScriptNames convert(Row row) {
            SpellScriptNames domain = new SpellScriptNames();
            domain.setSpellId(row.get("spell_id", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellScriptNames, OutboundRow> {

        public OutboundRow convert(SpellScriptNames source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("spell_id", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            return row;
        }
    }

}
