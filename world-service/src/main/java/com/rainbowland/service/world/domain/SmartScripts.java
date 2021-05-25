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
@Table("smart_scripts")
public class SmartScripts {

    @Column("entryorguid")
    private Long entryorguid;
    @Column("source_type")
    private Integer sourceType;
    @Column("id")
    private Integer id;
    @Column("link")
    private Integer link;
    @Column("event_type")
    private Integer eventType;
    @Column("event_phase_mask")
    private Integer eventPhaseMask;
    @Column("event_chance")
    private Integer eventChance;
    @Column("event_flags")
    private Integer eventFlags;
    @Column("event_param1")
    private Integer eventParam1;
    @Column("event_param2")
    private Integer eventParam2;
    @Column("event_param3")
    private Integer eventParam3;
    @Column("event_param4")
    private Integer eventParam4;
    @Column("event_param5")
    private Integer eventParam5;
    @Column("event_param_string")
    private String eventParamString;
    @Column("action_type")
    private Integer actionType;
    @Column("action_param1")
    private Integer actionParam1;
    @Column("action_param2")
    private Integer actionParam2;
    @Column("action_param3")
    private Integer actionParam3;
    @Column("action_param4")
    private Integer actionParam4;
    @Column("action_param5")
    private Integer actionParam5;
    @Column("action_param6")
    private Integer actionParam6;
    @Column("target_type")
    private Integer targetType;
    @Column("target_param1")
    private Integer targetParam1;
    @Column("target_param2")
    private Integer targetParam2;
    @Column("target_param3")
    private Integer targetParam3;
    @Column("target_x")
    private Double targetX;
    @Column("target_y")
    private Double targetY;
    @Column("target_z")
    private Double targetZ;
    @Column("target_o")
    private Double targetO;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SmartScripts> {

        public SmartScripts convert(Row row) {
            SmartScripts domain = new SmartScripts();
            domain.setEntryorguid(row.get("entryorguid", Long.class));
            domain.setSourceType(row.get("source_type", Integer.class));
            domain.setId(row.get("id", Integer.class));
            domain.setLink(row.get("link", Integer.class));
            domain.setEventType(row.get("event_type", Integer.class));
            domain.setEventPhaseMask(row.get("event_phase_mask", Integer.class));
            domain.setEventChance(row.get("event_chance", Integer.class));
            domain.setEventFlags(row.get("event_flags", Integer.class));
            domain.setEventParam1(row.get("event_param1", Integer.class));
            domain.setEventParam2(row.get("event_param2", Integer.class));
            domain.setEventParam3(row.get("event_param3", Integer.class));
            domain.setEventParam4(row.get("event_param4", Integer.class));
            domain.setEventParam5(row.get("event_param5", Integer.class));
            domain.setEventParamString(row.get("event_param_string", String.class));
            domain.setActionType(row.get("action_type", Integer.class));
            domain.setActionParam1(row.get("action_param1", Integer.class));
            domain.setActionParam2(row.get("action_param2", Integer.class));
            domain.setActionParam3(row.get("action_param3", Integer.class));
            domain.setActionParam4(row.get("action_param4", Integer.class));
            domain.setActionParam5(row.get("action_param5", Integer.class));
            domain.setActionParam6(row.get("action_param6", Integer.class));
            domain.setTargetType(row.get("target_type", Integer.class));
            domain.setTargetParam1(row.get("target_param1", Integer.class));
            domain.setTargetParam2(row.get("target_param2", Integer.class));
            domain.setTargetParam3(row.get("target_param3", Integer.class));
            domain.setTargetX(row.get("target_x", Double.class));
            domain.setTargetY(row.get("target_y", Double.class));
            domain.setTargetZ(row.get("target_z", Double.class));
            domain.setTargetO(row.get("target_o", Double.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SmartScripts, OutboundRow> {

        public OutboundRow convert(SmartScripts source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntryorguid()).ifPresent(e -> row.put("entryorguid", Parameter.from(e)));
            Optional.ofNullable(source.getSourceType()).ifPresent(e -> row.put("source_type", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getLink()).ifPresent(e -> row.put("link", Parameter.from(e)));
            Optional.ofNullable(source.getEventType()).ifPresent(e -> row.put("event_type", Parameter.from(e)));
            Optional.ofNullable(source.getEventPhaseMask()).ifPresent(e -> row.put("event_phase_mask", Parameter.from(e)));
            Optional.ofNullable(source.getEventChance()).ifPresent(e -> row.put("event_chance", Parameter.from(e)));
            Optional.ofNullable(source.getEventFlags()).ifPresent(e -> row.put("event_flags", Parameter.from(e)));
            Optional.ofNullable(source.getEventParam1()).ifPresent(e -> row.put("event_param1", Parameter.from(e)));
            Optional.ofNullable(source.getEventParam2()).ifPresent(e -> row.put("event_param2", Parameter.from(e)));
            Optional.ofNullable(source.getEventParam3()).ifPresent(e -> row.put("event_param3", Parameter.from(e)));
            Optional.ofNullable(source.getEventParam4()).ifPresent(e -> row.put("event_param4", Parameter.from(e)));
            Optional.ofNullable(source.getEventParam5()).ifPresent(e -> row.put("event_param5", Parameter.from(e)));
            Optional.ofNullable(source.getEventParamString()).ifPresent(e -> row.put("event_param_string", Parameter.from(e)));
            Optional.ofNullable(source.getActionType()).ifPresent(e -> row.put("action_type", Parameter.from(e)));
            Optional.ofNullable(source.getActionParam1()).ifPresent(e -> row.put("action_param1", Parameter.from(e)));
            Optional.ofNullable(source.getActionParam2()).ifPresent(e -> row.put("action_param2", Parameter.from(e)));
            Optional.ofNullable(source.getActionParam3()).ifPresent(e -> row.put("action_param3", Parameter.from(e)));
            Optional.ofNullable(source.getActionParam4()).ifPresent(e -> row.put("action_param4", Parameter.from(e)));
            Optional.ofNullable(source.getActionParam5()).ifPresent(e -> row.put("action_param5", Parameter.from(e)));
            Optional.ofNullable(source.getActionParam6()).ifPresent(e -> row.put("action_param6", Parameter.from(e)));
            Optional.ofNullable(source.getTargetType()).ifPresent(e -> row.put("target_type", Parameter.from(e)));
            Optional.ofNullable(source.getTargetParam1()).ifPresent(e -> row.put("target_param1", Parameter.from(e)));
            Optional.ofNullable(source.getTargetParam2()).ifPresent(e -> row.put("target_param2", Parameter.from(e)));
            Optional.ofNullable(source.getTargetParam3()).ifPresent(e -> row.put("target_param3", Parameter.from(e)));
            Optional.ofNullable(source.getTargetX()).ifPresent(e -> row.put("target_x", Parameter.from(e)));
            Optional.ofNullable(source.getTargetY()).ifPresent(e -> row.put("target_y", Parameter.from(e)));
            Optional.ofNullable(source.getTargetZ()).ifPresent(e -> row.put("target_z", Parameter.from(e)));
            Optional.ofNullable(source.getTargetO()).ifPresent(e -> row.put("target_o", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
