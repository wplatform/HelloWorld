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
@Table("chr_classes_x_power_types")
public class ChrClassesXPowerTypes {

    @Column("ID")
    private Integer id;
    @Column("PowerType")
    private Integer powerType;
    @Column("ClassID")
    private Integer classId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrClassesXPowerTypes> {

        public ChrClassesXPowerTypes convert(Row row) {
            ChrClassesXPowerTypes domain = new ChrClassesXPowerTypes();
            domain.setId(row.get("ID", Integer.class));
            domain.setPowerType(row.get("PowerType", Integer.class));
            domain.setClassId(row.get("ClassID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrClassesXPowerTypes, OutboundRow> {

        public OutboundRow convert(ChrClassesXPowerTypes source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPowerType()).ifPresent(e -> row.put("PowerType", Parameter.from(e)));
            Optional.ofNullable(source.getClassId()).ifPresent(e -> row.put("ClassID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
