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
@Table("battlemaster_entry")
public class BattlemasterEntry {

    @Column("entry")
    private Integer entry;
    @Column("bg_template")
    private Integer bgTemplate;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlemasterEntry> {

        public BattlemasterEntry convert(Row row) {
            BattlemasterEntry domain = new BattlemasterEntry();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setBgTemplate(row.get("bg_template", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlemasterEntry, OutboundRow> {

        public OutboundRow convert(BattlemasterEntry source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getBgTemplate()).ifPresent(e -> row.put("bg_template", Parameter.from(e)));
            return row;
        }
    }

}
