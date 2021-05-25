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
@Table("instance_encounters")
public class InstanceEncounters {

    @Column("entry")
    private Integer entry;
    @Column("creditType")
    private Integer creditType;
    @Column("creditEntry")
    private Integer creditEntry;
    @Column("lastEncounterDungeon")
    private Integer lastEncounterDungeon;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, InstanceEncounters> {

        public InstanceEncounters convert(Row row) {
            InstanceEncounters domain = new InstanceEncounters();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setCreditType(row.get("creditType", Integer.class));
            domain.setCreditEntry(row.get("creditEntry", Integer.class));
            domain.setLastEncounterDungeon(row.get("lastEncounterDungeon", Integer.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<InstanceEncounters, OutboundRow> {

        public OutboundRow convert(InstanceEncounters source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getCreditType()).ifPresent(e -> row.put("creditType", Parameter.from(e)));
            Optional.ofNullable(source.getCreditEntry()).ifPresent(e -> row.put("creditEntry", Parameter.from(e)));
            Optional.ofNullable(source.getLastEncounterDungeon()).ifPresent(e -> row.put("lastEncounterDungeon", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
