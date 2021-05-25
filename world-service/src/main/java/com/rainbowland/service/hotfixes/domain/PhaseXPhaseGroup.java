package com.rainbowland.service.hotfixes.domain;

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
@Table("phase_x_phase_group")
public class PhaseXPhaseGroup {

    @Column("ID")
    private Integer id;
    @Column("PhaseID")
    private Integer phaseId;
    @Column("PhaseGroupID")
    private Integer phaseGroupId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PhaseXPhaseGroup> {

        public PhaseXPhaseGroup convert(Row row) {
            PhaseXPhaseGroup domain = new PhaseXPhaseGroup();
            domain.setId(row.get("ID", Integer.class));
            domain.setPhaseId(row.get("PhaseID", Integer.class));
            domain.setPhaseGroupId(row.get("PhaseGroupID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PhaseXPhaseGroup, OutboundRow> {

        public OutboundRow convert(PhaseXPhaseGroup source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseId()).ifPresent(e -> row.put("PhaseID", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseGroupId()).ifPresent(e -> row.put("PhaseGroupID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
