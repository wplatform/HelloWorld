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
@Table("adventure_map_poi")
public class AdventureMapPoi {

    @Column("ID")
    private Integer id;
    @Column("Title")
    private String title;
    @Column("Description")
    private String description;
    @Column("WorldPositionX")
    private Double worldPositionX;
    @Column("WorldPositionY")
    private Double worldPositionY;
    @Column("Type")
    private Integer type;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("QuestID")
    private Integer questId;
    @Column("LfgDungeonID")
    private Integer lfgDungeonId;
    @Column("RewardItemID")
    private Integer rewardItemId;
    @Column("UiTextureAtlasMemberID")
    private Integer uiTextureAtlasMemberId;
    @Column("UiTextureKitID")
    private Integer uiTextureKitId;
    @Column("MapID")
    private Integer mapId;
    @Column("AreaTableID")
    private Integer areaTableId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AdventureMapPoi> {

        public AdventureMapPoi convert(Row row) {
            AdventureMapPoi domain = new AdventureMapPoi();
            domain.setId(row.get("ID", Integer.class));
            domain.setTitle(row.get("Title", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setWorldPositionX(row.get("WorldPositionX", Double.class));
            domain.setWorldPositionY(row.get("WorldPositionY", Double.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setQuestId(row.get("QuestID", Integer.class));
            domain.setLfgDungeonId(row.get("LfgDungeonID", Integer.class));
            domain.setRewardItemId(row.get("RewardItemID", Integer.class));
            domain.setUiTextureAtlasMemberId(row.get("UiTextureAtlasMemberID", Integer.class));
            domain.setUiTextureKitId(row.get("UiTextureKitID", Integer.class));
            domain.setMapId(row.get("MapID", Integer.class));
            domain.setAreaTableId(row.get("AreaTableID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AdventureMapPoi, OutboundRow> {

        public OutboundRow convert(AdventureMapPoi source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getTitle()).ifPresent(e -> row.put("Title", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getWorldPositionX()).ifPresent(e -> row.put("WorldPositionX", Parameter.from(e)));
            Optional.ofNullable(source.getWorldPositionY()).ifPresent(e -> row.put("WorldPositionY", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getQuestId()).ifPresent(e -> row.put("QuestID", Parameter.from(e)));
            Optional.ofNullable(source.getLfgDungeonId()).ifPresent(e -> row.put("LfgDungeonID", Parameter.from(e)));
            Optional.ofNullable(source.getRewardItemId()).ifPresent(e -> row.put("RewardItemID", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureAtlasMemberId()).ifPresent(e -> row.put("UiTextureAtlasMemberID", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureKitId()).ifPresent(e -> row.put("UiTextureKitID", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapID", Parameter.from(e)));
            Optional.ofNullable(source.getAreaTableId()).ifPresent(e -> row.put("AreaTableID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
