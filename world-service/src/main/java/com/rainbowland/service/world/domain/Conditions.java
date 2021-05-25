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
@Table("conditions")
public class Conditions {

    @Column("SourceTypeOrReferenceId")
    private Integer sourceTypeOrReferenceId;
    @Column("SourceGroup")
    private Integer sourceGroup;
    @Column("SourceEntry")
    private Integer sourceEntry;
    @Column("SourceId")
    private Integer sourceId;
    @Column("ElseGroup")
    private Integer elseGroup;
    @Column("ConditionTypeOrReference")
    private Integer conditionTypeOrReference;
    @Column("ConditionTarget")
    private Integer conditionTarget;
    @Column("ConditionValue1")
    private Integer conditionValue1;
    @Column("ConditionValue2")
    private Integer conditionValue2;
    @Column("ConditionValue3")
    private Integer conditionValue3;
    @Column("NegativeCondition")
    private Integer negativeCondition;
    @Column("ErrorType")
    private Integer errorType;
    @Column("ErrorTextId")
    private Integer errorTextId;
    @Column("ScriptName")
    private String scriptName;
    @Column("Comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Conditions> {

        public Conditions convert(Row row) {
            Conditions domain = new Conditions();
            domain.setSourceTypeOrReferenceId(row.get("SourceTypeOrReferenceId", Integer.class));
            domain.setSourceGroup(row.get("SourceGroup", Integer.class));
            domain.setSourceEntry(row.get("SourceEntry", Integer.class));
            domain.setSourceId(row.get("SourceId", Integer.class));
            domain.setElseGroup(row.get("ElseGroup", Integer.class));
            domain.setConditionTypeOrReference(row.get("ConditionTypeOrReference", Integer.class));
            domain.setConditionTarget(row.get("ConditionTarget", Integer.class));
            domain.setConditionValue1(row.get("ConditionValue1", Integer.class));
            domain.setConditionValue2(row.get("ConditionValue2", Integer.class));
            domain.setConditionValue3(row.get("ConditionValue3", Integer.class));
            domain.setNegativeCondition(row.get("NegativeCondition", Integer.class));
            domain.setErrorType(row.get("ErrorType", Integer.class));
            domain.setErrorTextId(row.get("ErrorTextId", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            domain.setComment(row.get("Comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Conditions, OutboundRow> {

        public OutboundRow convert(Conditions source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSourceTypeOrReferenceId()).ifPresent(e -> row.put("SourceTypeOrReferenceId", Parameter.from(e)));
            Optional.ofNullable(source.getSourceGroup()).ifPresent(e -> row.put("SourceGroup", Parameter.from(e)));
            Optional.ofNullable(source.getSourceEntry()).ifPresent(e -> row.put("SourceEntry", Parameter.from(e)));
            Optional.ofNullable(source.getSourceId()).ifPresent(e -> row.put("SourceId", Parameter.from(e)));
            Optional.ofNullable(source.getElseGroup()).ifPresent(e -> row.put("ElseGroup", Parameter.from(e)));
            Optional.ofNullable(source.getConditionTypeOrReference()).ifPresent(e -> row.put("ConditionTypeOrReference", Parameter.from(e)));
            Optional.ofNullable(source.getConditionTarget()).ifPresent(e -> row.put("ConditionTarget", Parameter.from(e)));
            Optional.ofNullable(source.getConditionValue1()).ifPresent(e -> row.put("ConditionValue1", Parameter.from(e)));
            Optional.ofNullable(source.getConditionValue2()).ifPresent(e -> row.put("ConditionValue2", Parameter.from(e)));
            Optional.ofNullable(source.getConditionValue3()).ifPresent(e -> row.put("ConditionValue3", Parameter.from(e)));
            Optional.ofNullable(source.getNegativeCondition()).ifPresent(e -> row.put("NegativeCondition", Parameter.from(e)));
            Optional.ofNullable(source.getErrorType()).ifPresent(e -> row.put("ErrorType", Parameter.from(e)));
            Optional.ofNullable(source.getErrorTextId()).ifPresent(e -> row.put("ErrorTextId", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("Comment", Parameter.from(e)));
            return row;
        }
    }

}
