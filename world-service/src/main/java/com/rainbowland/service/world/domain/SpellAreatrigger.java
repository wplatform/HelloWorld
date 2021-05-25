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
@Table("spell_areatrigger")
public class SpellAreatrigger {

    @Column("SpellMiscId")
    private Integer spellMiscId;
    @Column("AreaTriggerId")
    private Integer areaTriggerId;
    @Column("MoveCurveId")
    private Integer moveCurveId;
    @Column("ScaleCurveId")
    private Integer scaleCurveId;
    @Column("MorphCurveId")
    private Integer morphCurveId;
    @Column("FacingCurveId")
    private Integer facingCurveId;
    @Column("AnimId")
    private Integer animId;
    @Column("AnimKitId")
    private Integer animKitId;
    @Column("DecalPropertiesId")
    private Integer decalPropertiesId;
    @Column("TimeToTarget")
    private Integer timeToTarget;
    @Column("TimeToTargetScale")
    private Integer timeToTargetScale;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellAreatrigger> {

        public SpellAreatrigger convert(Row row) {
            SpellAreatrigger domain = new SpellAreatrigger();
            domain.setSpellMiscId(row.get("SpellMiscId", Integer.class));
            domain.setAreaTriggerId(row.get("AreaTriggerId", Integer.class));
            domain.setMoveCurveId(row.get("MoveCurveId", Integer.class));
            domain.setScaleCurveId(row.get("ScaleCurveId", Integer.class));
            domain.setMorphCurveId(row.get("MorphCurveId", Integer.class));
            domain.setFacingCurveId(row.get("FacingCurveId", Integer.class));
            domain.setAnimId(row.get("AnimId", Integer.class));
            domain.setAnimKitId(row.get("AnimKitId", Integer.class));
            domain.setDecalPropertiesId(row.get("DecalPropertiesId", Integer.class));
            domain.setTimeToTarget(row.get("TimeToTarget", Integer.class));
            domain.setTimeToTargetScale(row.get("TimeToTargetScale", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellAreatrigger, OutboundRow> {

        public OutboundRow convert(SpellAreatrigger source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellMiscId()).ifPresent(e -> row.put("SpellMiscId", Parameter.from(e)));
            Optional.ofNullable(source.getAreaTriggerId()).ifPresent(e -> row.put("AreaTriggerId", Parameter.from(e)));
            Optional.ofNullable(source.getMoveCurveId()).ifPresent(e -> row.put("MoveCurveId", Parameter.from(e)));
            Optional.ofNullable(source.getScaleCurveId()).ifPresent(e -> row.put("ScaleCurveId", Parameter.from(e)));
            Optional.ofNullable(source.getMorphCurveId()).ifPresent(e -> row.put("MorphCurveId", Parameter.from(e)));
            Optional.ofNullable(source.getFacingCurveId()).ifPresent(e -> row.put("FacingCurveId", Parameter.from(e)));
            Optional.ofNullable(source.getAnimId()).ifPresent(e -> row.put("AnimId", Parameter.from(e)));
            Optional.ofNullable(source.getAnimKitId()).ifPresent(e -> row.put("AnimKitId", Parameter.from(e)));
            Optional.ofNullable(source.getDecalPropertiesId()).ifPresent(e -> row.put("DecalPropertiesId", Parameter.from(e)));
            Optional.ofNullable(source.getTimeToTarget()).ifPresent(e -> row.put("TimeToTarget", Parameter.from(e)));
            Optional.ofNullable(source.getTimeToTargetScale()).ifPresent(e -> row.put("TimeToTargetScale", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
