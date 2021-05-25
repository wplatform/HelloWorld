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
@Table("gameobjects")
public class Gameobjects {

    @Column("Name")
    private String name;
    @Column("PosX")
    private Double posX;
    @Column("PosY")
    private Double posY;
    @Column("PosZ")
    private Double posZ;
    @Column("Rot1")
    private Double rot1;
    @Column("Rot2")
    private Double rot2;
    @Column("Rot3")
    private Double rot3;
    @Column("Rot4")
    private Double rot4;
    @Column("ID")
    private Integer id;
    @Column("OwnerID")
    private Integer ownerId;
    @Column("DisplayID")
    private Integer displayId;
    @Column("Scale")
    private Double scale;
    @Column("TypeID")
    private Integer typeId;
    @Column("PhaseUseFlags")
    private Integer phaseUseFlags;
    @Column("PhaseID")
    private Integer phaseId;
    @Column("PhaseGroupID")
    private Integer phaseGroupId;
    @Column("PropValue1")
    private Integer propValue1;
    @Column("PropValue2")
    private Integer propValue2;
    @Column("PropValue3")
    private Integer propValue3;
    @Column("PropValue4")
    private Integer propValue4;
    @Column("PropValue5")
    private Integer propValue5;
    @Column("PropValue6")
    private Integer propValue6;
    @Column("PropValue7")
    private Integer propValue7;
    @Column("PropValue8")
    private Integer propValue8;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Gameobjects> {

        public Gameobjects convert(Row row) {
            Gameobjects domain = new Gameobjects();
            domain.setName(row.get("Name", String.class));
            domain.setPosX(row.get("PosX", Double.class));
            domain.setPosY(row.get("PosY", Double.class));
            domain.setPosZ(row.get("PosZ", Double.class));
            domain.setRot1(row.get("Rot1", Double.class));
            domain.setRot2(row.get("Rot2", Double.class));
            domain.setRot3(row.get("Rot3", Double.class));
            domain.setRot4(row.get("Rot4", Double.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setOwnerId(row.get("OwnerID", Integer.class));
            domain.setDisplayId(row.get("DisplayID", Integer.class));
            domain.setScale(row.get("Scale", Double.class));
            domain.setTypeId(row.get("TypeID", Integer.class));
            domain.setPhaseUseFlags(row.get("PhaseUseFlags", Integer.class));
            domain.setPhaseId(row.get("PhaseID", Integer.class));
            domain.setPhaseGroupId(row.get("PhaseGroupID", Integer.class));
            domain.setPropValue1(row.get("PropValue1", Integer.class));
            domain.setPropValue2(row.get("PropValue2", Integer.class));
            domain.setPropValue3(row.get("PropValue3", Integer.class));
            domain.setPropValue4(row.get("PropValue4", Integer.class));
            domain.setPropValue5(row.get("PropValue5", Integer.class));
            domain.setPropValue6(row.get("PropValue6", Integer.class));
            domain.setPropValue7(row.get("PropValue7", Integer.class));
            domain.setPropValue8(row.get("PropValue8", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Gameobjects, OutboundRow> {

        public OutboundRow convert(Gameobjects source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getPosX()).ifPresent(e -> row.put("PosX", Parameter.from(e)));
            Optional.ofNullable(source.getPosY()).ifPresent(e -> row.put("PosY", Parameter.from(e)));
            Optional.ofNullable(source.getPosZ()).ifPresent(e -> row.put("PosZ", Parameter.from(e)));
            Optional.ofNullable(source.getRot1()).ifPresent(e -> row.put("Rot1", Parameter.from(e)));
            Optional.ofNullable(source.getRot2()).ifPresent(e -> row.put("Rot2", Parameter.from(e)));
            Optional.ofNullable(source.getRot3()).ifPresent(e -> row.put("Rot3", Parameter.from(e)));
            Optional.ofNullable(source.getRot4()).ifPresent(e -> row.put("Rot4", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getOwnerId()).ifPresent(e -> row.put("OwnerID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayId()).ifPresent(e -> row.put("DisplayID", Parameter.from(e)));
            Optional.ofNullable(source.getScale()).ifPresent(e -> row.put("Scale", Parameter.from(e)));
            Optional.ofNullable(source.getTypeId()).ifPresent(e -> row.put("TypeID", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseUseFlags()).ifPresent(e -> row.put("PhaseUseFlags", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseId()).ifPresent(e -> row.put("PhaseID", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseGroupId()).ifPresent(e -> row.put("PhaseGroupID", Parameter.from(e)));
            Optional.ofNullable(source.getPropValue1()).ifPresent(e -> row.put("PropValue1", Parameter.from(e)));
            Optional.ofNullable(source.getPropValue2()).ifPresent(e -> row.put("PropValue2", Parameter.from(e)));
            Optional.ofNullable(source.getPropValue3()).ifPresent(e -> row.put("PropValue3", Parameter.from(e)));
            Optional.ofNullable(source.getPropValue4()).ifPresent(e -> row.put("PropValue4", Parameter.from(e)));
            Optional.ofNullable(source.getPropValue5()).ifPresent(e -> row.put("PropValue5", Parameter.from(e)));
            Optional.ofNullable(source.getPropValue6()).ifPresent(e -> row.put("PropValue6", Parameter.from(e)));
            Optional.ofNullable(source.getPropValue7()).ifPresent(e -> row.put("PropValue7", Parameter.from(e)));
            Optional.ofNullable(source.getPropValue8()).ifPresent(e -> row.put("PropValue8", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
