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
@Table("gameobject_addon")
public class GameobjectAddon {

    @Column("guid")
    private Long guid;
    @Column("parent_rotation0")
    private Double parentRotation0;
    @Column("parent_rotation1")
    private Double parentRotation1;
    @Column("parent_rotation2")
    private Double parentRotation2;
    @Column("parent_rotation3")
    private Double parentRotation3;
    @Column("invisibilityType")
    private Integer invisibilityType;
    @Column("invisibilityValue")
    private Integer invisibilityValue;
    @Column("WorldEffectID")
    private Integer worldEffectId;
    @Column("AIAnimKitID")
    private Integer aiAnimKitId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameobjectAddon> {

        public GameobjectAddon convert(Row row) {
            GameobjectAddon domain = new GameobjectAddon();
            domain.setGuid(row.get("guid", Long.class));
            domain.setParentRotation0(row.get("parent_rotation0", Double.class));
            domain.setParentRotation1(row.get("parent_rotation1", Double.class));
            domain.setParentRotation2(row.get("parent_rotation2", Double.class));
            domain.setParentRotation3(row.get("parent_rotation3", Double.class));
            domain.setInvisibilityType(row.get("invisibilityType", Integer.class));
            domain.setInvisibilityValue(row.get("invisibilityValue", Integer.class));
            domain.setWorldEffectId(row.get("WorldEffectID", Integer.class));
            domain.setAiAnimKitId(row.get("AIAnimKitID", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameobjectAddon, OutboundRow> {

        public OutboundRow convert(GameobjectAddon source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getParentRotation0()).ifPresent(e -> row.put("parent_rotation0", Parameter.from(e)));
            Optional.ofNullable(source.getParentRotation1()).ifPresent(e -> row.put("parent_rotation1", Parameter.from(e)));
            Optional.ofNullable(source.getParentRotation2()).ifPresent(e -> row.put("parent_rotation2", Parameter.from(e)));
            Optional.ofNullable(source.getParentRotation3()).ifPresent(e -> row.put("parent_rotation3", Parameter.from(e)));
            Optional.ofNullable(source.getInvisibilityType()).ifPresent(e -> row.put("invisibilityType", Parameter.from(e)));
            Optional.ofNullable(source.getInvisibilityValue()).ifPresent(e -> row.put("invisibilityValue", Parameter.from(e)));
            Optional.ofNullable(source.getWorldEffectId()).ifPresent(e -> row.put("WorldEffectID", Parameter.from(e)));
            Optional.ofNullable(source.getAiAnimKitId()).ifPresent(e -> row.put("AIAnimKitID", Parameter.from(e)));
            return row;
        }
    }

}
