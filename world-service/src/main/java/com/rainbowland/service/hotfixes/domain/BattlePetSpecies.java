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
@Table("battle_pet_species")
public class BattlePetSpecies {

    @Column("Description")
    private String description;
    @Column("SourceText")
    private String sourceText;
    @Column("ID")
    private Integer id;
    @Column("CreatureID")
    private Integer creatureId;
    @Column("SummonSpellID")
    private Integer summonSpellId;
    @Column("IconFileDataID")
    private Integer iconFileDataId;
    @Column("PetTypeEnum")
    private Integer petTypeEnum;
    @Column("Flags")
    private Integer flags;
    @Column("SourceTypeEnum")
    private Integer sourceTypeEnum;
    @Column("CardUIModelSceneID")
    private Integer cardUiModelSceneId;
    @Column("LoadoutUIModelSceneID")
    private Integer loadoutUiModelSceneId;
    @Column("CovenantID")
    private Integer covenantId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlePetSpecies> {

        public BattlePetSpecies convert(Row row) {
            BattlePetSpecies domain = new BattlePetSpecies();
            domain.setDescription(row.get("Description", String.class));
            domain.setSourceText(row.get("SourceText", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setCreatureId(row.get("CreatureID", Integer.class));
            domain.setSummonSpellId(row.get("SummonSpellID", Integer.class));
            domain.setIconFileDataId(row.get("IconFileDataID", Integer.class));
            domain.setPetTypeEnum(row.get("PetTypeEnum", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setSourceTypeEnum(row.get("SourceTypeEnum", Integer.class));
            domain.setCardUiModelSceneId(row.get("CardUIModelSceneID", Integer.class));
            domain.setLoadoutUiModelSceneId(row.get("LoadoutUIModelSceneID", Integer.class));
            domain.setCovenantId(row.get("CovenantID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlePetSpecies, OutboundRow> {

        public OutboundRow convert(BattlePetSpecies source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getSourceText()).ifPresent(e -> row.put("SourceText", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureId()).ifPresent(e -> row.put("CreatureID", Parameter.from(e)));
            Optional.ofNullable(source.getSummonSpellId()).ifPresent(e -> row.put("SummonSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getIconFileDataId()).ifPresent(e -> row.put("IconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getPetTypeEnum()).ifPresent(e -> row.put("PetTypeEnum", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getSourceTypeEnum()).ifPresent(e -> row.put("SourceTypeEnum", Parameter.from(e)));
            Optional.ofNullable(source.getCardUiModelSceneId()).ifPresent(e -> row.put("CardUIModelSceneID", Parameter.from(e)));
            Optional.ofNullable(source.getLoadoutUiModelSceneId()).ifPresent(e -> row.put("LoadoutUIModelSceneID", Parameter.from(e)));
            Optional.ofNullable(source.getCovenantId()).ifPresent(e -> row.put("CovenantID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
