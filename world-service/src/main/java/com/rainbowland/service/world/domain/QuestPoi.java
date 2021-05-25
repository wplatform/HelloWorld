package com.rainbowland.service.world.domain;

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
@Table("quest_poi")
public class QuestPoi {

    @Column("QuestID")
    private Integer questId;
    @Column("BlobIndex")
    private Integer blobIndex;
    @Column("Idx1")
    private Integer idx1;
    @Column("ObjectiveIndex")
    private Integer objectiveIndex;
    @Column("QuestObjectiveID")
    private Integer questObjectiveId;
    @Column("QuestObjectID")
    private Integer questObjectId;
    @Column("MapID")
    private Integer mapId;
    @Column("UiMapID")
    private Integer uiMapId;
    @Column("Priority")
    private Integer priority;
    @Column("Flags")
    private Integer flags;
    @Column("WorldEffectID")
    private Integer worldEffectId;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("NavigationPlayerConditionID")
    private Integer navigationPlayerConditionId;
    @Column("SpawnTrackingID")
    private Integer spawnTrackingId;
    @Column("AlwaysAllowMergingBlobs")
    private Integer alwaysAllowMergingBlobs;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestPoi> {

        public QuestPoi convert(Row row) {
            QuestPoi domain = new QuestPoi();
            domain.setQuestId(row.get("QuestID", Integer.class));
            domain.setBlobIndex(row.get("BlobIndex", Integer.class));
            domain.setIdx1(row.get("Idx1", Integer.class));
            domain.setObjectiveIndex(row.get("ObjectiveIndex", Integer.class));
            domain.setQuestObjectiveId(row.get("QuestObjectiveID", Integer.class));
            domain.setQuestObjectId(row.get("QuestObjectID", Integer.class));
            domain.setMapId(row.get("MapID", Integer.class));
            domain.setUiMapId(row.get("UiMapID", Integer.class));
            domain.setPriority(row.get("Priority", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setWorldEffectId(row.get("WorldEffectID", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setNavigationPlayerConditionId(row.get("NavigationPlayerConditionID", Integer.class));
            domain.setSpawnTrackingId(row.get("SpawnTrackingID", Integer.class));
            domain.setAlwaysAllowMergingBlobs(row.get("AlwaysAllowMergingBlobs", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestPoi, OutboundRow> {

        public OutboundRow convert(QuestPoi source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getQuestId()).ifPresent(e -> row.put("QuestID", Parameter.from(e)));
            Optional.ofNullable(source.getBlobIndex()).ifPresent(e -> row.put("BlobIndex", Parameter.from(e)));
            Optional.ofNullable(source.getIdx1()).ifPresent(e -> row.put("Idx1", Parameter.from(e)));
            Optional.ofNullable(source.getObjectiveIndex()).ifPresent(e -> row.put("ObjectiveIndex", Parameter.from(e)));
            Optional.ofNullable(source.getQuestObjectiveId()).ifPresent(e -> row.put("QuestObjectiveID", Parameter.from(e)));
            Optional.ofNullable(source.getQuestObjectId()).ifPresent(e -> row.put("QuestObjectID", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapID", Parameter.from(e)));
            Optional.ofNullable(source.getUiMapId()).ifPresent(e -> row.put("UiMapID", Parameter.from(e)));
            Optional.ofNullable(source.getPriority()).ifPresent(e -> row.put("Priority", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getWorldEffectId()).ifPresent(e -> row.put("WorldEffectID", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getNavigationPlayerConditionId()).ifPresent(e -> row.put("NavigationPlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getSpawnTrackingId()).ifPresent(e -> row.put("SpawnTrackingID", Parameter.from(e)));
            Optional.ofNullable(source.getAlwaysAllowMergingBlobs()).ifPresent(e -> row.put("AlwaysAllowMergingBlobs", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
