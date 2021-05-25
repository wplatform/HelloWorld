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
@Table("spec_set_member")
public class SpecSetMember {

    @Column("ID")
    private Integer id;
    @Column("ChrSpecializationID")
    private Integer chrSpecializationId;
    @Column("SpecSetID")
    private Integer specSetId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpecSetMember> {

        public SpecSetMember convert(Row row) {
            SpecSetMember domain = new SpecSetMember();
            domain.setId(row.get("ID", Integer.class));
            domain.setChrSpecializationId(row.get("ChrSpecializationID", Integer.class));
            domain.setSpecSetId(row.get("SpecSetID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpecSetMember, OutboundRow> {

        public OutboundRow convert(SpecSetMember source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getChrSpecializationId()).ifPresent(e -> row.put("ChrSpecializationID", Parameter.from(e)));
            Optional.ofNullable(source.getSpecSetId()).ifPresent(e -> row.put("SpecSetID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
