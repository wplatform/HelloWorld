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
@Table("phase_area")
public class PhaseArea {

    @Column("AreaId")
    private Integer areaId;
    @Column("PhaseId")
    private Integer phaseId;
    @Column("Comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PhaseArea> {

        public PhaseArea convert(Row row) {
            PhaseArea domain = new PhaseArea();
            domain.setAreaId(row.get("AreaId", Integer.class));
            domain.setPhaseId(row.get("PhaseId", Integer.class));
            domain.setComment(row.get("Comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PhaseArea, OutboundRow> {

        public OutboundRow convert(PhaseArea source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAreaId()).ifPresent(e -> row.put("AreaId", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseId()).ifPresent(e -> row.put("PhaseId", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("Comment", Parameter.from(e)));
            return row;
        }
    }

}
