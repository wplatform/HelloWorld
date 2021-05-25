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
@Table("command")
public class Command {

    @Column("name")
    private String name;
    @Column("permission")
    private Integer permission;
    @Column("help")
    private String help;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Command> {

        public Command convert(Row row) {
            Command domain = new Command();
            domain.setName(row.get("name", String.class));
            domain.setPermission(row.get("permission", Integer.class));
            domain.setHelp(row.get("help", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Command, OutboundRow> {

        public OutboundRow convert(Command source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getPermission()).ifPresent(e -> row.put("permission", Parameter.from(e)));
            Optional.ofNullable(source.getHelp()).ifPresent(e -> row.put("help", Parameter.from(e)));
            return row;
        }
    }

}
