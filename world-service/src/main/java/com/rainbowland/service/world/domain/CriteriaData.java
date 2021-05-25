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
@Table("criteria_data")
public class CriteriaData {

    @Column("criteria_id")
    private Integer criteriaId;
    @Column("type")
    private Integer type;
    @Column("value1")
    private Integer value1;
    @Column("value2")
    private Integer value2;
    @Column("ScriptName")
    private String scriptName;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CriteriaData> {

        public CriteriaData convert(Row row) {
            CriteriaData domain = new CriteriaData();
            domain.setCriteriaId(row.get("criteria_id", Integer.class));
            domain.setType(row.get("type", Integer.class));
            domain.setValue1(row.get("value1", Integer.class));
            domain.setValue2(row.get("value2", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CriteriaData, OutboundRow> {

        public OutboundRow convert(CriteriaData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCriteriaId()).ifPresent(e -> row.put("criteria_id", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getValue1()).ifPresent(e -> row.put("value1", Parameter.from(e)));
            Optional.ofNullable(source.getValue2()).ifPresent(e -> row.put("value2", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            return row;
        }
    }

}
