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
@Table("spell_target_position")
public class SpellTargetPosition {

    @Column("ID")
    private Integer id;
    @Column("EffectIndex")
    private Integer effectIndex;
    @Column("MapID")
    private Integer mapId;
    @Column("PositionX")
    private Double positionX;
    @Column("PositionY")
    private Double positionY;
    @Column("PositionZ")
    private Double positionZ;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellTargetPosition> {

        public SpellTargetPosition convert(Row row) {
            SpellTargetPosition domain = new SpellTargetPosition();
            domain.setId(row.get("ID", Integer.class));
            domain.setEffectIndex(row.get("EffectIndex", Integer.class));
            domain.setMapId(row.get("MapID", Integer.class));
            domain.setPositionX(row.get("PositionX", Double.class));
            domain.setPositionY(row.get("PositionY", Double.class));
            domain.setPositionZ(row.get("PositionZ", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellTargetPosition, OutboundRow> {

        public OutboundRow convert(SpellTargetPosition source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getEffectIndex()).ifPresent(e -> row.put("EffectIndex", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapID", Parameter.from(e)));
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("PositionX", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("PositionY", Parameter.from(e)));
            Optional.ofNullable(source.getPositionZ()).ifPresent(e -> row.put("PositionZ", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
