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
@Table("pool_gameobject")
public class PoolGameobject {

    @Column("guid")
    private Long guid;
    @Column("pool_entry")
    private Integer poolEntry;
    @Column("chance")
    private Double chance;
    @Column("description")
    private String description;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PoolGameobject> {

        public PoolGameobject convert(Row row) {
            PoolGameobject domain = new PoolGameobject();
            domain.setGuid(row.get("guid", Long.class));
            domain.setPoolEntry(row.get("pool_entry", Integer.class));
            domain.setChance(row.get("chance", Double.class));
            domain.setDescription(row.get("description", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PoolGameobject, OutboundRow> {

        public OutboundRow convert(PoolGameobject source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getPoolEntry()).ifPresent(e -> row.put("pool_entry", Parameter.from(e)));
            Optional.ofNullable(source.getChance()).ifPresent(e -> row.put("chance", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("description", Parameter.from(e)));
            return row;
        }
    }

}
