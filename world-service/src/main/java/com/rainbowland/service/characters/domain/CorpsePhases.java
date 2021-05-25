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
@Table("corpse_phases")
public class CorpsePhases {

    @Column("OwnerGuid")
    private Long ownerGuid;
    @Column("PhaseId")
    private Integer phaseId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CorpsePhases> {

        public CorpsePhases convert(Row row) {
            CorpsePhases domain = new CorpsePhases();
            domain.setOwnerGuid(row.get("OwnerGuid", Long.class));
            domain.setPhaseId(row.get("PhaseId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CorpsePhases, OutboundRow> {

        public OutboundRow convert(CorpsePhases source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getOwnerGuid()).ifPresent(e -> row.put("OwnerGuid", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseId()).ifPresent(e -> row.put("PhaseId", Parameter.from(e)));
            return row;
        }
    }

}
