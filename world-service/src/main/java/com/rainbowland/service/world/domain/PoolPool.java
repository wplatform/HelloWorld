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
@Table("pool_pool")
public class PoolPool {

    @Column("pool_id")
    private Integer poolId;
    @Column("mother_pool")
    private Integer motherPool;
    @Column("chance")
    private Double chance;
    @Column("description")
    private String description;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PoolPool> {

        public PoolPool convert(Row row) {
            PoolPool domain = new PoolPool();
            domain.setPoolId(row.get("pool_id", Integer.class));
            domain.setMotherPool(row.get("mother_pool", Integer.class));
            domain.setChance(row.get("chance", Double.class));
            domain.setDescription(row.get("description", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PoolPool, OutboundRow> {

        public OutboundRow convert(PoolPool source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getPoolId()).ifPresent(e -> row.put("pool_id", Parameter.from(e)));
            Optional.ofNullable(source.getMotherPool()).ifPresent(e -> row.put("mother_pool", Parameter.from(e)));
            Optional.ofNullable(source.getChance()).ifPresent(e -> row.put("chance", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("description", Parameter.from(e)));
            return row;
        }
    }

}
