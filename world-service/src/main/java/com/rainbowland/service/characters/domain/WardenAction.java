package com.rainbowland.service.characters.domain;

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
@Table("warden_action")
public class WardenAction {

    @Column("wardenId")
    private Integer wardenId;
    @Column("action")
    private Integer action;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, WardenAction> {

        public WardenAction convert(Row row) {
            WardenAction domain = new WardenAction();
            domain.setWardenId(row.get("wardenId", Integer.class));
            domain.setAction(row.get("action", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<WardenAction, OutboundRow> {

        public OutboundRow convert(WardenAction source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getWardenId()).ifPresent(e -> row.put("wardenId", Parameter.from(e)));
            Optional.ofNullable(source.getAction()).ifPresent(e -> row.put("action", Parameter.from(e)));
            return row;
        }
    }

}
