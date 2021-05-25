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
@Table("spell_areatrigger_circular")
public class SpellAreatriggerCircular {

    @Column("SpellMiscId")
    private Integer spellMiscId;
    @Column("StartDelay")
    private Integer startDelay;
    @Column("CircleRadius")
    private Double circleRadius;
    @Column("BlendFromRadius")
    private Double blendFromRadius;
    @Column("InitialAngle")
    private Double initialAngle;
    @Column("ZOffset")
    private Double zOffset;
    @Column("CounterClockwise")
    private Integer counterClockwise;
    @Column("CanLoop")
    private Integer canLoop;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellAreatriggerCircular> {

        public SpellAreatriggerCircular convert(Row row) {
            SpellAreatriggerCircular domain = new SpellAreatriggerCircular();
            domain.setSpellMiscId(row.get("SpellMiscId", Integer.class));
            domain.setStartDelay(row.get("StartDelay", Integer.class));
            domain.setCircleRadius(row.get("CircleRadius", Double.class));
            domain.setBlendFromRadius(row.get("BlendFromRadius", Double.class));
            domain.setInitialAngle(row.get("InitialAngle", Double.class));
            domain.setZOffset(row.get("ZOffset", Double.class));
            domain.setCounterClockwise(row.get("CounterClockwise", Integer.class));
            domain.setCanLoop(row.get("CanLoop", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellAreatriggerCircular, OutboundRow> {

        public OutboundRow convert(SpellAreatriggerCircular source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellMiscId()).ifPresent(e -> row.put("SpellMiscId", Parameter.from(e)));
            Optional.ofNullable(source.getStartDelay()).ifPresent(e -> row.put("StartDelay", Parameter.from(e)));
            Optional.ofNullable(source.getCircleRadius()).ifPresent(e -> row.put("CircleRadius", Parameter.from(e)));
            Optional.ofNullable(source.getBlendFromRadius()).ifPresent(e -> row.put("BlendFromRadius", Parameter.from(e)));
            Optional.ofNullable(source.getInitialAngle()).ifPresent(e -> row.put("InitialAngle", Parameter.from(e)));
            Optional.ofNullable(source.getZOffset()).ifPresent(e -> row.put("ZOffset", Parameter.from(e)));
            Optional.ofNullable(source.getCounterClockwise()).ifPresent(e -> row.put("CounterClockwise", Parameter.from(e)));
            Optional.ofNullable(source.getCanLoop()).ifPresent(e -> row.put("CanLoop", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
