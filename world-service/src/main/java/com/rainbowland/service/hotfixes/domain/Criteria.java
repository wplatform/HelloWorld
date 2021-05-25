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
@Table("criteria")
public class Criteria {

    @Column("ID")
    private Integer id;
    @Column("Type")
    private Integer type;
    @Column("Asset")
    private Integer asset;
    @Column("ModifierTreeId")
    private Integer modifierTreeId;
    @Column("StartEvent")
    private Integer startEvent;
    @Column("StartAsset")
    private Integer startAsset;
    @Column("StartTimer")
    private Integer startTimer;
    @Column("FailEvent")
    private Integer failEvent;
    @Column("FailAsset")
    private Integer failAsset;
    @Column("Flags")
    private Integer flags;
    @Column("EligibilityWorldStateID")
    private Integer eligibilityWorldStateId;
    @Column("EligibilityWorldStateValue")
    private Integer eligibilityWorldStateValue;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Criteria> {

        public Criteria convert(Row row) {
            Criteria domain = new Criteria();
            domain.setId(row.get("ID", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setAsset(row.get("Asset", Integer.class));
            domain.setModifierTreeId(row.get("ModifierTreeId", Integer.class));
            domain.setStartEvent(row.get("StartEvent", Integer.class));
            domain.setStartAsset(row.get("StartAsset", Integer.class));
            domain.setStartTimer(row.get("StartTimer", Integer.class));
            domain.setFailEvent(row.get("FailEvent", Integer.class));
            domain.setFailAsset(row.get("FailAsset", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setEligibilityWorldStateId(row.get("EligibilityWorldStateID", Integer.class));
            domain.setEligibilityWorldStateValue(row.get("EligibilityWorldStateValue", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Criteria, OutboundRow> {

        public OutboundRow convert(Criteria source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getAsset()).ifPresent(e -> row.put("Asset", Parameter.from(e)));
            Optional.ofNullable(source.getModifierTreeId()).ifPresent(e -> row.put("ModifierTreeId", Parameter.from(e)));
            Optional.ofNullable(source.getStartEvent()).ifPresent(e -> row.put("StartEvent", Parameter.from(e)));
            Optional.ofNullable(source.getStartAsset()).ifPresent(e -> row.put("StartAsset", Parameter.from(e)));
            Optional.ofNullable(source.getStartTimer()).ifPresent(e -> row.put("StartTimer", Parameter.from(e)));
            Optional.ofNullable(source.getFailEvent()).ifPresent(e -> row.put("FailEvent", Parameter.from(e)));
            Optional.ofNullable(source.getFailAsset()).ifPresent(e -> row.put("FailAsset", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getEligibilityWorldStateId()).ifPresent(e -> row.put("EligibilityWorldStateID", Parameter.from(e)));
            Optional.ofNullable(source.getEligibilityWorldStateValue()).ifPresent(e -> row.put("EligibilityWorldStateValue", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
