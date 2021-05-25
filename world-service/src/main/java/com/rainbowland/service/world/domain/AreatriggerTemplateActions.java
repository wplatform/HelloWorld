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
@Table("areatrigger_template_actions")
public class AreatriggerTemplateActions {

    @Column("AreaTriggerId")
    private Integer areaTriggerId;
    @Column("IsServerSide")
    private Integer isServerSide;
    @Column("ActionType")
    private Integer actionType;
    @Column("ActionParam")
    private Integer actionParam;
    @Column("TargetType")
    private Integer targetType;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AreatriggerTemplateActions> {

        public AreatriggerTemplateActions convert(Row row) {
            AreatriggerTemplateActions domain = new AreatriggerTemplateActions();
            domain.setAreaTriggerId(row.get("AreaTriggerId", Integer.class));
            domain.setIsServerSide(row.get("IsServerSide", Integer.class));
            domain.setActionType(row.get("ActionType", Integer.class));
            domain.setActionParam(row.get("ActionParam", Integer.class));
            domain.setTargetType(row.get("TargetType", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AreatriggerTemplateActions, OutboundRow> {

        public OutboundRow convert(AreatriggerTemplateActions source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAreaTriggerId()).ifPresent(e -> row.put("AreaTriggerId", Parameter.from(e)));
            Optional.ofNullable(source.getIsServerSide()).ifPresent(e -> row.put("IsServerSide", Parameter.from(e)));
            Optional.ofNullable(source.getActionType()).ifPresent(e -> row.put("ActionType", Parameter.from(e)));
            Optional.ofNullable(source.getActionParam()).ifPresent(e -> row.put("ActionParam", Parameter.from(e)));
            Optional.ofNullable(source.getTargetType()).ifPresent(e -> row.put("TargetType", Parameter.from(e)));
            return row;
        }
    }

}
