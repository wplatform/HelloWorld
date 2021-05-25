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
@Table("scenarios")
public class Scenarios {

    @Column("map")
    private Integer map;
    @Column("difficulty")
    private Integer difficulty;
    @Column("scenario_A")
    private Integer scenarioA;
    @Column("scenario_H")
    private Integer scenarioH;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Scenarios> {

        public Scenarios convert(Row row) {
            Scenarios domain = new Scenarios();
            domain.setMap(row.get("map", Integer.class));
            domain.setDifficulty(row.get("difficulty", Integer.class));
            domain.setScenarioA(row.get("scenario_A", Integer.class));
            domain.setScenarioH(row.get("scenario_H", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Scenarios, OutboundRow> {

        public OutboundRow convert(Scenarios source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMap()).ifPresent(e -> row.put("map", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty()).ifPresent(e -> row.put("difficulty", Parameter.from(e)));
            Optional.ofNullable(source.getScenarioA()).ifPresent(e -> row.put("scenario_A", Parameter.from(e)));
            Optional.ofNullable(source.getScenarioH()).ifPresent(e -> row.put("scenario_H", Parameter.from(e)));
            return row;
        }
    }

}
