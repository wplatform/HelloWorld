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
@Table("chr_specialization")
public class ChrSpecialization {

    @Column("Name")
    private String name;
    @Column("FemaleName")
    private String femaleName;
    @Column("Description")
    private String description;
    @Column("ID")
    private Integer id;
    @Column("ClassID")
    private Integer classId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("PetTalentType")
    private Integer petTalentType;
    @Column("Role")
    private Integer role;
    @Column("Flags")
    private Integer flags;
    @Column("SpellIconFileID")
    private Integer spellIconFileId;
    @Column("PrimaryStatPriority")
    private Integer primaryStatPriority;
    @Column("AnimReplacements")
    private Integer animReplacements;
    @Column("MasterySpellID1")
    private Integer masterySpellId1;
    @Column("MasterySpellID2")
    private Integer masterySpellId2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrSpecialization> {

        public ChrSpecialization convert(Row row) {
            ChrSpecialization domain = new ChrSpecialization();
            domain.setName(row.get("Name", String.class));
            domain.setFemaleName(row.get("FemaleName", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setClassId(row.get("ClassID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setPetTalentType(row.get("PetTalentType", Integer.class));
            domain.setRole(row.get("Role", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setSpellIconFileId(row.get("SpellIconFileID", Integer.class));
            domain.setPrimaryStatPriority(row.get("PrimaryStatPriority", Integer.class));
            domain.setAnimReplacements(row.get("AnimReplacements", Integer.class));
            domain.setMasterySpellId1(row.get("MasterySpellID1", Integer.class));
            domain.setMasterySpellId2(row.get("MasterySpellID2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrSpecialization, OutboundRow> {

        public OutboundRow convert(ChrSpecialization source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getFemaleName()).ifPresent(e -> row.put("FemaleName", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getClassId()).ifPresent(e -> row.put("ClassID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getPetTalentType()).ifPresent(e -> row.put("PetTalentType", Parameter.from(e)));
            Optional.ofNullable(source.getRole()).ifPresent(e -> row.put("Role", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getSpellIconFileId()).ifPresent(e -> row.put("SpellIconFileID", Parameter.from(e)));
            Optional.ofNullable(source.getPrimaryStatPriority()).ifPresent(e -> row.put("PrimaryStatPriority", Parameter.from(e)));
            Optional.ofNullable(source.getAnimReplacements()).ifPresent(e -> row.put("AnimReplacements", Parameter.from(e)));
            Optional.ofNullable(source.getMasterySpellId1()).ifPresent(e -> row.put("MasterySpellID1", Parameter.from(e)));
            Optional.ofNullable(source.getMasterySpellId2()).ifPresent(e -> row.put("MasterySpellID2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
