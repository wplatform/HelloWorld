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
@Table("pool_quest")
public class PoolQuest {

    @Column("entry")
    private Integer entry;
    @Column("pool_entry")
    private Integer poolEntry;
    @Column("description")
    private String description;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PoolQuest> {

        public PoolQuest convert(Row row) {
            PoolQuest domain = new PoolQuest();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setPoolEntry(row.get("pool_entry", Integer.class));
            domain.setDescription(row.get("description", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PoolQuest, OutboundRow> {

        public OutboundRow convert(PoolQuest source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getPoolEntry()).ifPresent(e -> row.put("pool_entry", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("description", Parameter.from(e)));
            return row;
        }
    }

}
