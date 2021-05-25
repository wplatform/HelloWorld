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
@Table("spell_threat")
public class SpellThreat {

    @Column("entry")
    private Integer entry;
    @Column("flatMod")
    private Integer flatMod;
    @Column("pctMod")
    private Double pctMod;
    @Column("apPctMod")
    private Double apPctMod;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellThreat> {

        public SpellThreat convert(Row row) {
            SpellThreat domain = new SpellThreat();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setFlatMod(row.get("flatMod", Integer.class));
            domain.setPctMod(row.get("pctMod", Double.class));
            domain.setApPctMod(row.get("apPctMod", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellThreat, OutboundRow> {

        public OutboundRow convert(SpellThreat source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getFlatMod()).ifPresent(e -> row.put("flatMod", Parameter.from(e)));
            Optional.ofNullable(source.getPctMod()).ifPresent(e -> row.put("pctMod", Parameter.from(e)));
            Optional.ofNullable(source.getApPctMod()).ifPresent(e -> row.put("apPctMod", Parameter.from(e)));
            return row;
        }
    }

}
