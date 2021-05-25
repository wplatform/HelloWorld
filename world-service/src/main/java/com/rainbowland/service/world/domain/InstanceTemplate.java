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
@Table("instance_template")
public class InstanceTemplate {

    @Column("map")
    private Integer map;
    @Column("parent")
    private Integer parent;
    @Column("script")
    private String script;
    @Column("allowMount")
    private Integer allowMount;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, InstanceTemplate> {

        public InstanceTemplate convert(Row row) {
            InstanceTemplate domain = new InstanceTemplate();
            domain.setMap(row.get("map", Integer.class));
            domain.setParent(row.get("parent", Integer.class));
            domain.setScript(row.get("script", String.class));
            domain.setAllowMount(row.get("allowMount", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<InstanceTemplate, OutboundRow> {

        public OutboundRow convert(InstanceTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMap()).ifPresent(e -> row.put("map", Parameter.from(e)));
            Optional.ofNullable(source.getParent()).ifPresent(e -> row.put("parent", Parameter.from(e)));
            Optional.ofNullable(source.getScript()).ifPresent(e -> row.put("script", Parameter.from(e)));
            Optional.ofNullable(source.getAllowMount()).ifPresent(e -> row.put("allowMount", Parameter.from(e)));
            return row;
        }
    }

}
