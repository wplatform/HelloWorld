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
@Table("updates_include")
public class UpdatesInclude {

    @Column("path")
    private String path;
    @Column("state")
    private String state;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, UpdatesInclude> {

        public UpdatesInclude convert(Row row) {
            UpdatesInclude domain = new UpdatesInclude();
            domain.setPath(row.get("path", String.class));
            domain.setState(row.get("state", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<UpdatesInclude, OutboundRow> {

        public OutboundRow convert(UpdatesInclude source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getPath()).ifPresent(e -> row.put("path", Parameter.from(e)));
            Optional.ofNullable(source.getState()).ifPresent(e -> row.put("state", Parameter.from(e)));
            return row;
        }
    }

}
