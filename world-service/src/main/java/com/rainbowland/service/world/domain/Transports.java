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
@Table("transports")
public class Transports {

    @Column("guid")
    private Long guid;
    @Column("entry")
    private Integer entry;
    @Column("name")
    private String name;
    @Column("phaseUseFlags")
    private Integer phaseUseFlags;
    @Column("phaseid")
    private Integer phaseid;
    @Column("phasegroup")
    private Integer phasegroup;
    @Column("ScriptName")
    private String scriptName;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Transports> {

        public Transports convert(Row row) {
            Transports domain = new Transports();
            domain.setGuid(row.get("guid", Long.class));
            domain.setEntry(row.get("entry", Integer.class));
            domain.setName(row.get("name", String.class));
            domain.setPhaseUseFlags(row.get("phaseUseFlags", Integer.class));
            domain.setPhaseid(row.get("phaseid", Integer.class));
            domain.setPhasegroup(row.get("phasegroup", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Transports, OutboundRow> {

        public OutboundRow convert(Transports source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseUseFlags()).ifPresent(e -> row.put("phaseUseFlags", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseid()).ifPresent(e -> row.put("phaseid", Parameter.from(e)));
            Optional.ofNullable(source.getPhasegroup()).ifPresent(e -> row.put("phasegroup", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            return row;
        }
    }

}
