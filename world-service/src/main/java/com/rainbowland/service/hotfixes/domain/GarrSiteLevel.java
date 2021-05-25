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
@Table("garr_site_level")
public class GarrSiteLevel {

    @Column("ID")
    private Integer id;
    @Column("TownHallUiPosX")
    private Double townHallUiPosX;
    @Column("TownHallUiPosY")
    private Double townHallUiPosY;
    @Column("GarrSiteID")
    private Integer garrSiteId;
    @Column("GarrLevel")
    private Integer garrLevel;
    @Column("MapID")
    private Integer mapId;
    @Column("UpgradeMovieID")
    private Integer upgradeMovieId;
    @Column("UiTextureKitID")
    private Integer uiTextureKitId;
    @Column("MaxBuildingLevel")
    private Integer maxBuildingLevel;
    @Column("UpgradeCost")
    private Integer upgradeCost;
    @Column("UpgradeGoldCost")
    private Integer upgradeGoldCost;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrSiteLevel> {

        public GarrSiteLevel convert(Row row) {
            GarrSiteLevel domain = new GarrSiteLevel();
            domain.setId(row.get("ID", Integer.class));
            domain.setTownHallUiPosX(row.get("TownHallUiPosX", Double.class));
            domain.setTownHallUiPosY(row.get("TownHallUiPosY", Double.class));
            domain.setGarrSiteId(row.get("GarrSiteID", Integer.class));
            domain.setGarrLevel(row.get("GarrLevel", Integer.class));
            domain.setMapId(row.get("MapID", Integer.class));
            domain.setUpgradeMovieId(row.get("UpgradeMovieID", Integer.class));
            domain.setUiTextureKitId(row.get("UiTextureKitID", Integer.class));
            domain.setMaxBuildingLevel(row.get("MaxBuildingLevel", Integer.class));
            domain.setUpgradeCost(row.get("UpgradeCost", Integer.class));
            domain.setUpgradeGoldCost(row.get("UpgradeGoldCost", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrSiteLevel, OutboundRow> {

        public OutboundRow convert(GarrSiteLevel source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getTownHallUiPosX()).ifPresent(e -> row.put("TownHallUiPosX", Parameter.from(e)));
            Optional.ofNullable(source.getTownHallUiPosY()).ifPresent(e -> row.put("TownHallUiPosY", Parameter.from(e)));
            Optional.ofNullable(source.getGarrSiteId()).ifPresent(e -> row.put("GarrSiteID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrLevel()).ifPresent(e -> row.put("GarrLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapID", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeMovieId()).ifPresent(e -> row.put("UpgradeMovieID", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureKitId()).ifPresent(e -> row.put("UiTextureKitID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxBuildingLevel()).ifPresent(e -> row.put("MaxBuildingLevel", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeCost()).ifPresent(e -> row.put("UpgradeCost", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeGoldCost()).ifPresent(e -> row.put("UpgradeGoldCost", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
