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
@Table("outdoorpvp_template")
public class OutdoorpvpTemplate {

    @Column("TypeId")
    private Integer typeId;
    @Column("ScriptName")
    private String scriptName;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, OutdoorpvpTemplate> {

        public OutdoorpvpTemplate convert(Row row) {
            OutdoorpvpTemplate domain = new OutdoorpvpTemplate();
            domain.setTypeId(row.get("TypeId", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<OutdoorpvpTemplate, OutboundRow> {

        public OutboundRow convert(OutdoorpvpTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getTypeId()).ifPresent(e -> row.put("TypeId", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
