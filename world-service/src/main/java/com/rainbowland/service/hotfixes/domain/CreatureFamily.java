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
@Table("creature_family")
public class CreatureFamily {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("MinScale")
    private Double minScale;
    @Column("MinScaleLevel")
    private Integer minScaleLevel;
    @Column("MaxScale")
    private Double maxScale;
    @Column("MaxScaleLevel")
    private Integer maxScaleLevel;
    @Column("PetFoodMask")
    private Integer petFoodMask;
    @Column("PetTalentType")
    private Integer petTalentType;
    @Column("IconFileID")
    private Integer iconFileId;
    @Column("SkillLine1")
    private Integer skillLine1;
    @Column("SkillLine2")
    private Integer skillLine2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureFamily> {

        public CreatureFamily convert(Row row) {
            CreatureFamily domain = new CreatureFamily();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setMinScale(row.get("MinScale", Double.class));
            domain.setMinScaleLevel(row.get("MinScaleLevel", Integer.class));
            domain.setMaxScale(row.get("MaxScale", Double.class));
            domain.setMaxScaleLevel(row.get("MaxScaleLevel", Integer.class));
            domain.setPetFoodMask(row.get("PetFoodMask", Integer.class));
            domain.setPetTalentType(row.get("PetTalentType", Integer.class));
            domain.setIconFileId(row.get("IconFileID", Integer.class));
            domain.setSkillLine1(row.get("SkillLine1", Integer.class));
            domain.setSkillLine2(row.get("SkillLine2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureFamily, OutboundRow> {

        public OutboundRow convert(CreatureFamily source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getMinScale()).ifPresent(e -> row.put("MinScale", Parameter.from(e)));
            Optional.ofNullable(source.getMinScaleLevel()).ifPresent(e -> row.put("MinScaleLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxScale()).ifPresent(e -> row.put("MaxScale", Parameter.from(e)));
            Optional.ofNullable(source.getMaxScaleLevel()).ifPresent(e -> row.put("MaxScaleLevel", Parameter.from(e)));
            Optional.ofNullable(source.getPetFoodMask()).ifPresent(e -> row.put("PetFoodMask", Parameter.from(e)));
            Optional.ofNullable(source.getPetTalentType()).ifPresent(e -> row.put("PetTalentType", Parameter.from(e)));
            Optional.ofNullable(source.getIconFileId()).ifPresent(e -> row.put("IconFileID", Parameter.from(e)));
            Optional.ofNullable(source.getSkillLine1()).ifPresent(e -> row.put("SkillLine1", Parameter.from(e)));
            Optional.ofNullable(source.getSkillLine2()).ifPresent(e -> row.put("SkillLine2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
