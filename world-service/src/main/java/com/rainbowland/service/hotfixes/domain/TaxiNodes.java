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
@Table("taxi_nodes")
public class TaxiNodes {

    @Column("Name")
    private String name;
    @Column("PosX")
    private Double posX;
    @Column("PosY")
    private Double posY;
    @Column("PosZ")
    private Double posZ;
    @Column("MapOffsetX")
    private Double mapOffsetX;
    @Column("MapOffsetY")
    private Double mapOffsetY;
    @Column("FlightMapOffsetX")
    private Double flightMapOffsetX;
    @Column("FlightMapOffsetY")
    private Double flightMapOffsetY;
    @Column("ID")
    private Integer id;
    @Column("ContinentID")
    private Integer continentId;
    @Column("ConditionID")
    private Integer conditionId;
    @Column("CharacterBitNumber")
    private Integer characterBitNumber;
    @Column("Flags")
    private Integer flags;
    @Column("UiTextureKitID")
    private Integer uiTextureKitId;
    @Column("MinimapAtlasMemberID")
    private Integer minimapAtlasMemberId;
    @Column("Facing")
    private Double facing;
    @Column("SpecialIconConditionID")
    private Integer specialIconConditionId;
    @Column("VisibilityConditionID")
    private Integer visibilityConditionId;
    @Column("MountCreatureID1")
    private Integer mountCreatureId1;
    @Column("MountCreatureID2")
    private Integer mountCreatureId2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TaxiNodes> {

        public TaxiNodes convert(Row row) {
            TaxiNodes domain = new TaxiNodes();
            domain.setName(row.get("Name", String.class));
            domain.setPosX(row.get("PosX", Double.class));
            domain.setPosY(row.get("PosY", Double.class));
            domain.setPosZ(row.get("PosZ", Double.class));
            domain.setMapOffsetX(row.get("MapOffsetX", Double.class));
            domain.setMapOffsetY(row.get("MapOffsetY", Double.class));
            domain.setFlightMapOffsetX(row.get("FlightMapOffsetX", Double.class));
            domain.setFlightMapOffsetY(row.get("FlightMapOffsetY", Double.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setContinentId(row.get("ContinentID", Integer.class));
            domain.setConditionId(row.get("ConditionID", Integer.class));
            domain.setCharacterBitNumber(row.get("CharacterBitNumber", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setUiTextureKitId(row.get("UiTextureKitID", Integer.class));
            domain.setMinimapAtlasMemberId(row.get("MinimapAtlasMemberID", Integer.class));
            domain.setFacing(row.get("Facing", Double.class));
            domain.setSpecialIconConditionId(row.get("SpecialIconConditionID", Integer.class));
            domain.setVisibilityConditionId(row.get("VisibilityConditionID", Integer.class));
            domain.setMountCreatureId1(row.get("MountCreatureID1", Integer.class));
            domain.setMountCreatureId2(row.get("MountCreatureID2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TaxiNodes, OutboundRow> {

        public OutboundRow convert(TaxiNodes source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getPosX()).ifPresent(e -> row.put("PosX", Parameter.from(e)));
            Optional.ofNullable(source.getPosY()).ifPresent(e -> row.put("PosY", Parameter.from(e)));
            Optional.ofNullable(source.getPosZ()).ifPresent(e -> row.put("PosZ", Parameter.from(e)));
            Optional.ofNullable(source.getMapOffsetX()).ifPresent(e -> row.put("MapOffsetX", Parameter.from(e)));
            Optional.ofNullable(source.getMapOffsetY()).ifPresent(e -> row.put("MapOffsetY", Parameter.from(e)));
            Optional.ofNullable(source.getFlightMapOffsetX()).ifPresent(e -> row.put("FlightMapOffsetX", Parameter.from(e)));
            Optional.ofNullable(source.getFlightMapOffsetY()).ifPresent(e -> row.put("FlightMapOffsetY", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getContinentId()).ifPresent(e -> row.put("ContinentID", Parameter.from(e)));
            Optional.ofNullable(source.getConditionId()).ifPresent(e -> row.put("ConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getCharacterBitNumber()).ifPresent(e -> row.put("CharacterBitNumber", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureKitId()).ifPresent(e -> row.put("UiTextureKitID", Parameter.from(e)));
            Optional.ofNullable(source.getMinimapAtlasMemberId()).ifPresent(e -> row.put("MinimapAtlasMemberID", Parameter.from(e)));
            Optional.ofNullable(source.getFacing()).ifPresent(e -> row.put("Facing", Parameter.from(e)));
            Optional.ofNullable(source.getSpecialIconConditionId()).ifPresent(e -> row.put("SpecialIconConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getVisibilityConditionId()).ifPresent(e -> row.put("VisibilityConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getMountCreatureId1()).ifPresent(e -> row.put("MountCreatureID1", Parameter.from(e)));
            Optional.ofNullable(source.getMountCreatureId2()).ifPresent(e -> row.put("MountCreatureID2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
