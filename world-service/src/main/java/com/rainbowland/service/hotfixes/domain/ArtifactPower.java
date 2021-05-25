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
@Table("artifact_power")
public class ArtifactPower {

    @Column("DisplayPosX")
    private Double displayPosX;
    @Column("DisplayPosY")
    private Double displayPosY;
    @Column("ID")
    private Integer id;
    @Column("ArtifactID")
    private Integer artifactId;
    @Column("MaxPurchasableRank")
    private Integer maxPurchasableRank;
    @Column("Label")
    private Integer label;
    @Column("Flags")
    private Integer flags;
    @Column("Tier")
    private Integer tier;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArtifactPower> {

        public ArtifactPower convert(Row row) {
            ArtifactPower domain = new ArtifactPower();
            domain.setDisplayPosX(row.get("DisplayPosX", Double.class));
            domain.setDisplayPosY(row.get("DisplayPosY", Double.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setArtifactId(row.get("ArtifactID", Integer.class));
            domain.setMaxPurchasableRank(row.get("MaxPurchasableRank", Integer.class));
            domain.setLabel(row.get("Label", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setTier(row.get("Tier", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArtifactPower, OutboundRow> {

        public OutboundRow convert(ArtifactPower source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDisplayPosX()).ifPresent(e -> row.put("DisplayPosX", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayPosY()).ifPresent(e -> row.put("DisplayPosY", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactId()).ifPresent(e -> row.put("ArtifactID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxPurchasableRank()).ifPresent(e -> row.put("MaxPurchasableRank", Parameter.from(e)));
            Optional.ofNullable(source.getLabel()).ifPresent(e -> row.put("Label", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getTier()).ifPresent(e -> row.put("Tier", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
