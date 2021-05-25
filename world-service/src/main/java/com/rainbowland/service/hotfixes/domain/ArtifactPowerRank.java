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
@Table("artifact_power_rank")
public class ArtifactPowerRank {

    @Column("ID")
    private Integer id;
    @Column("RankIndex")
    private Integer rankIndex;
    @Column("SpellID")
    private Integer spellId;
    @Column("ItemBonusListID")
    private Integer itemBonusListId;
    @Column("AuraPointsOverride")
    private Double auraPointsOverride;
    @Column("ArtifactPowerID")
    private Integer artifactPowerId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArtifactPowerRank> {

        public ArtifactPowerRank convert(Row row) {
            ArtifactPowerRank domain = new ArtifactPowerRank();
            domain.setId(row.get("ID", Integer.class));
            domain.setRankIndex(row.get("RankIndex", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setItemBonusListId(row.get("ItemBonusListID", Integer.class));
            domain.setAuraPointsOverride(row.get("AuraPointsOverride", Double.class));
            domain.setArtifactPowerId(row.get("ArtifactPowerID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArtifactPowerRank, OutboundRow> {

        public OutboundRow convert(ArtifactPowerRank source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRankIndex()).ifPresent(e -> row.put("RankIndex", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getItemBonusListId()).ifPresent(e -> row.put("ItemBonusListID", Parameter.from(e)));
            Optional.ofNullable(source.getAuraPointsOverride()).ifPresent(e -> row.put("AuraPointsOverride", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactPowerId()).ifPresent(e -> row.put("ArtifactPowerID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
