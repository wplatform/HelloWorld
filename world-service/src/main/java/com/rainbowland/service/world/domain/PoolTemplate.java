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
@Table("pool_template")
public class PoolTemplate {

    @Column("entry")
    private Integer entry;
    @Column("max_limit")
    private Integer maxLimit;
    @Column("description")
    private String description;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PoolTemplate> {

        public PoolTemplate convert(Row row) {
            PoolTemplate domain = new PoolTemplate();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setMaxLimit(row.get("max_limit", Integer.class));
            domain.setDescription(row.get("description", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PoolTemplate, OutboundRow> {

        public OutboundRow convert(PoolTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLimit()).ifPresent(e -> row.put("max_limit", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("description", Parameter.from(e)));
            return row;
        }
    }

}
