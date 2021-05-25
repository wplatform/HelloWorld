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
@Table("area_trigger")
public class AreaTrigger {

    @Column("PosX")
    private Double posX;
    @Column("PosY")
    private Double posY;
    @Column("PosZ")
    private Double posZ;
    @Column("ID")
    private Integer id;
    @Column("ContinentID")
    private Integer continentId;
    @Column("PhaseUseFlags")
    private Integer phaseUseFlags;
    @Column("PhaseID")
    private Integer phaseId;
    @Column("PhaseGroupID")
    private Integer phaseGroupId;
    @Column("Radius")
    private Double radius;
    @Column("BoxLength")
    private Double boxLength;
    @Column("BoxWidth")
    private Double boxWidth;
    @Column("BoxHeight")
    private Double boxHeight;
    @Column("BoxYaw")
    private Double boxYaw;
    @Column("ShapeType")
    private Integer shapeType;
    @Column("ShapeID")
    private Integer shapeId;
    @Column("AreaTriggerActionSetID")
    private Integer areaTriggerActionSetId;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AreaTrigger> {

        public AreaTrigger convert(Row row) {
            AreaTrigger domain = new AreaTrigger();
            domain.setPosX(row.get("PosX", Double.class));
            domain.setPosY(row.get("PosY", Double.class));
            domain.setPosZ(row.get("PosZ", Double.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setContinentId(row.get("ContinentID", Integer.class));
            domain.setPhaseUseFlags(row.get("PhaseUseFlags", Integer.class));
            domain.setPhaseId(row.get("PhaseID", Integer.class));
            domain.setPhaseGroupId(row.get("PhaseGroupID", Integer.class));
            domain.setRadius(row.get("Radius", Double.class));
            domain.setBoxLength(row.get("BoxLength", Double.class));
            domain.setBoxWidth(row.get("BoxWidth", Double.class));
            domain.setBoxHeight(row.get("BoxHeight", Double.class));
            domain.setBoxYaw(row.get("BoxYaw", Double.class));
            domain.setShapeType(row.get("ShapeType", Integer.class));
            domain.setShapeId(row.get("ShapeID", Integer.class));
            domain.setAreaTriggerActionSetId(row.get("AreaTriggerActionSetID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AreaTrigger, OutboundRow> {

        public OutboundRow convert(AreaTrigger source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getPosX()).ifPresent(e -> row.put("PosX", Parameter.from(e)));
            Optional.ofNullable(source.getPosY()).ifPresent(e -> row.put("PosY", Parameter.from(e)));
            Optional.ofNullable(source.getPosZ()).ifPresent(e -> row.put("PosZ", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getContinentId()).ifPresent(e -> row.put("ContinentID", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseUseFlags()).ifPresent(e -> row.put("PhaseUseFlags", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseId()).ifPresent(e -> row.put("PhaseID", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseGroupId()).ifPresent(e -> row.put("PhaseGroupID", Parameter.from(e)));
            Optional.ofNullable(source.getRadius()).ifPresent(e -> row.put("Radius", Parameter.from(e)));
            Optional.ofNullable(source.getBoxLength()).ifPresent(e -> row.put("BoxLength", Parameter.from(e)));
            Optional.ofNullable(source.getBoxWidth()).ifPresent(e -> row.put("BoxWidth", Parameter.from(e)));
            Optional.ofNullable(source.getBoxHeight()).ifPresent(e -> row.put("BoxHeight", Parameter.from(e)));
            Optional.ofNullable(source.getBoxYaw()).ifPresent(e -> row.put("BoxYaw", Parameter.from(e)));
            Optional.ofNullable(source.getShapeType()).ifPresent(e -> row.put("ShapeType", Parameter.from(e)));
            Optional.ofNullable(source.getShapeId()).ifPresent(e -> row.put("ShapeID", Parameter.from(e)));
            Optional.ofNullable(source.getAreaTriggerActionSetId()).ifPresent(e -> row.put("AreaTriggerActionSetID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
