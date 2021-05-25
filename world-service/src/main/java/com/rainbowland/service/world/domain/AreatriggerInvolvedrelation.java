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
@Table("areatrigger_involvedrelation")
public class AreatriggerInvolvedrelation {

    @Column("id")
    private Integer id;
    @Column("quest")
    private Integer quest;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AreatriggerInvolvedrelation> {

        public AreatriggerInvolvedrelation convert(Row row) {
            AreatriggerInvolvedrelation domain = new AreatriggerInvolvedrelation();
            domain.setId(row.get("id", Integer.class));
            domain.setQuest(row.get("quest", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AreatriggerInvolvedrelation, OutboundRow> {

        public OutboundRow convert(AreatriggerInvolvedrelation source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getQuest()).ifPresent(e -> row.put("quest", Parameter.from(e)));
            return row;
        }
    }

}
