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
@Table("instance")
public class Instance {

    @Column("id")
    private Integer id;
    @Column("map")
    private Integer map;
    @Column("resettime")
    private Long resettime;
    @Column("difficulty")
    private Integer difficulty;
    @Column("completedEncounters")
    private Integer completedEncounters;
    @Column("data")
    private String data;
    @Column("entranceId")
    private Integer entranceId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Instance> {

        public Instance convert(Row row) {
            Instance domain = new Instance();
            domain.setId(row.get("id", Integer.class));
            domain.setMap(row.get("map", Integer.class));
            domain.setResettime(row.get("resettime", Long.class));
            domain.setDifficulty(row.get("difficulty", Integer.class));
            domain.setCompletedEncounters(row.get("completedEncounters", Integer.class));
            domain.setData(row.get("data", String.class));
            domain.setEntranceId(row.get("entranceId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Instance, OutboundRow> {

        public OutboundRow convert(Instance source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getMap()).ifPresent(e -> row.put("map", Parameter.from(e)));
            Optional.ofNullable(source.getResettime()).ifPresent(e -> row.put("resettime", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty()).ifPresent(e -> row.put("difficulty", Parameter.from(e)));
            Optional.ofNullable(source.getCompletedEncounters()).ifPresent(e -> row.put("completedEncounters", Parameter.from(e)));
            Optional.ofNullable(source.getData()).ifPresent(e -> row.put("data", Parameter.from(e)));
            Optional.ofNullable(source.getEntranceId()).ifPresent(e -> row.put("entranceId", Parameter.from(e)));
            return row;
        }
    }

}
