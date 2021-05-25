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
@Table("reward_pack")
public class RewardPack {

    @Column("ID")
    private Integer id;
    @Column("CharTitleID")
    private Integer charTitleId;
    @Column("Money")
    private Integer money;
    @Column("ArtifactXPDifficulty")
    private Integer artifactXpDifficulty;
    @Column("ArtifactXPMultiplier")
    private Double artifactXpMultiplier;
    @Column("ArtifactXPCategoryID")
    private Integer artifactXpCategoryId;
    @Column("TreasurePickerID")
    private Integer treasurePickerId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, RewardPack> {

        public RewardPack convert(Row row) {
            RewardPack domain = new RewardPack();
            domain.setId(row.get("ID", Integer.class));
            domain.setCharTitleId(row.get("CharTitleID", Integer.class));
            domain.setMoney(row.get("Money", Integer.class));
            domain.setArtifactXpDifficulty(row.get("ArtifactXPDifficulty", Integer.class));
            domain.setArtifactXpMultiplier(row.get("ArtifactXPMultiplier", Double.class));
            domain.setArtifactXpCategoryId(row.get("ArtifactXPCategoryID", Integer.class));
            domain.setTreasurePickerId(row.get("TreasurePickerID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<RewardPack, OutboundRow> {

        public OutboundRow convert(RewardPack source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getCharTitleId()).ifPresent(e -> row.put("CharTitleID", Parameter.from(e)));
            Optional.ofNullable(source.getMoney()).ifPresent(e -> row.put("Money", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactXpDifficulty()).ifPresent(e -> row.put("ArtifactXPDifficulty", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactXpMultiplier()).ifPresent(e -> row.put("ArtifactXPMultiplier", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactXpCategoryId()).ifPresent(e -> row.put("ArtifactXPCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getTreasurePickerId()).ifPresent(e -> row.put("TreasurePickerID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
