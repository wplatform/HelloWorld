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
@Table("instance_scenario_progress")
public class InstanceScenarioProgress {

    @Column("id")
    private Integer id;
    @Column("criteria")
    private Integer criteria;
    @Column("counter")
    private Long counter;
    @Column("date")
    private Long date;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, InstanceScenarioProgress> {

        public InstanceScenarioProgress convert(Row row) {
            InstanceScenarioProgress domain = new InstanceScenarioProgress();
            domain.setId(row.get("id", Integer.class));
            domain.setCriteria(row.get("criteria", Integer.class));
            domain.setCounter(row.get("counter", Long.class));
            domain.setDate(row.get("date", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<InstanceScenarioProgress, OutboundRow> {

        public OutboundRow convert(InstanceScenarioProgress source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getCriteria()).ifPresent(e -> row.put("criteria", Parameter.from(e)));
            Optional.ofNullable(source.getCounter()).ifPresent(e -> row.put("counter", Parameter.from(e)));
            Optional.ofNullable(source.getDate()).ifPresent(e -> row.put("date", Parameter.from(e)));
            return row;
        }
    }

}
