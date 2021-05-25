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
@Table("creature")
public class Creature {

    @Column("ID")
    private Integer id;
    @Column("ItemID1")
    private Integer itemId1;
    @Column("ItemID2")
    private Integer itemId2;
    @Column("ItemID3")
    private Integer itemId3;
    @Column("Mount")
    private Integer mount;
    @Column("DisplayID1")
    private Integer displayId1;
    @Column("DisplayID2")
    private Integer displayId2;
    @Column("DisplayID3")
    private Integer displayId3;
    @Column("DisplayID4")
    private Integer displayId4;
    @Column("DisplayIDProbability1")
    private Double displayIdProbability1;
    @Column("DisplayIDProbability2")
    private Double displayIdProbability2;
    @Column("DisplayIDProbability3")
    private Double displayIdProbability3;
    @Column("DisplayIDProbability4")
    private Double displayIdProbability4;
    @Column("Name")
    private String name;
    @Column("FemaleName")
    private String femaleName;
    @Column("SubName")
    private String subName;
    @Column("FemaleSubName")
    private String femaleSubName;
    @Column("Type")
    private Integer type;
    @Column("Family")
    private Integer family;
    @Column("Classification")
    private Integer classification;
    @Column("InhabitType")
    private Integer inhabitType;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Creature> {

        public Creature convert(Row row) {
            Creature domain = new Creature();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemId1(row.get("ItemID1", Integer.class));
            domain.setItemId2(row.get("ItemID2", Integer.class));
            domain.setItemId3(row.get("ItemID3", Integer.class));
            domain.setMount(row.get("Mount", Integer.class));
            domain.setDisplayId1(row.get("DisplayID1", Integer.class));
            domain.setDisplayId2(row.get("DisplayID2", Integer.class));
            domain.setDisplayId3(row.get("DisplayID3", Integer.class));
            domain.setDisplayId4(row.get("DisplayID4", Integer.class));
            domain.setDisplayIdProbability1(row.get("DisplayIDProbability1", Double.class));
            domain.setDisplayIdProbability2(row.get("DisplayIDProbability2", Double.class));
            domain.setDisplayIdProbability3(row.get("DisplayIDProbability3", Double.class));
            domain.setDisplayIdProbability4(row.get("DisplayIDProbability4", Double.class));
            domain.setName(row.get("Name", String.class));
            domain.setFemaleName(row.get("FemaleName", String.class));
            domain.setSubName(row.get("SubName", String.class));
            domain.setFemaleSubName(row.get("FemaleSubName", String.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setFamily(row.get("Family", Integer.class));
            domain.setClassification(row.get("Classification", Integer.class));
            domain.setInhabitType(row.get("InhabitType", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Creature, OutboundRow> {

        public OutboundRow convert(Creature source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId1()).ifPresent(e -> row.put("ItemID1", Parameter.from(e)));
            Optional.ofNullable(source.getItemId2()).ifPresent(e -> row.put("ItemID2", Parameter.from(e)));
            Optional.ofNullable(source.getItemId3()).ifPresent(e -> row.put("ItemID3", Parameter.from(e)));
            Optional.ofNullable(source.getMount()).ifPresent(e -> row.put("Mount", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayId1()).ifPresent(e -> row.put("DisplayID1", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayId2()).ifPresent(e -> row.put("DisplayID2", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayId3()).ifPresent(e -> row.put("DisplayID3", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayId4()).ifPresent(e -> row.put("DisplayID4", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayIdProbability1()).ifPresent(e -> row.put("DisplayIDProbability1", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayIdProbability2()).ifPresent(e -> row.put("DisplayIDProbability2", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayIdProbability3()).ifPresent(e -> row.put("DisplayIDProbability3", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayIdProbability4()).ifPresent(e -> row.put("DisplayIDProbability4", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getFemaleName()).ifPresent(e -> row.put("FemaleName", Parameter.from(e)));
            Optional.ofNullable(source.getSubName()).ifPresent(e -> row.put("SubName", Parameter.from(e)));
            Optional.ofNullable(source.getFemaleSubName()).ifPresent(e -> row.put("FemaleSubName", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getFamily()).ifPresent(e -> row.put("Family", Parameter.from(e)));
            Optional.ofNullable(source.getClassification()).ifPresent(e -> row.put("Classification", Parameter.from(e)));
            Optional.ofNullable(source.getInhabitType()).ifPresent(e -> row.put("InhabitType", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
