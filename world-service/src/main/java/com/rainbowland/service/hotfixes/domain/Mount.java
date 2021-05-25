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
@Table("mount")
public class Mount {

    @Column("Name")
    private String name;
    @Column("SourceText")
    private String sourceText;
    @Column("Description")
    private String description;
    @Column("ID")
    private Integer id;
    @Column("MountTypeID")
    private Integer mountTypeId;
    @Column("Flags")
    private Integer flags;
    @Column("SourceTypeEnum")
    private Integer sourceTypeEnum;
    @Column("SourceSpellID")
    private Integer sourceSpellId;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("MountFlyRideHeight")
    private Double mountFlyRideHeight;
    @Column("UiModelSceneID")
    private Integer uiModelSceneId;
    @Column("MountSpecialRiderAnimKitID")
    private Integer mountSpecialRiderAnimKitId;
    @Column("MountSpecialSpellVisualKitID")
    private Integer mountSpecialSpellVisualKitId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Mount> {

        public Mount convert(Row row) {
            Mount domain = new Mount();
            domain.setName(row.get("Name", String.class));
            domain.setSourceText(row.get("SourceText", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setMountTypeId(row.get("MountTypeID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setSourceTypeEnum(row.get("SourceTypeEnum", Integer.class));
            domain.setSourceSpellId(row.get("SourceSpellID", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setMountFlyRideHeight(row.get("MountFlyRideHeight", Double.class));
            domain.setUiModelSceneId(row.get("UiModelSceneID", Integer.class));
            domain.setMountSpecialRiderAnimKitId(row.get("MountSpecialRiderAnimKitID", Integer.class));
            domain.setMountSpecialSpellVisualKitId(row.get("MountSpecialSpellVisualKitID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Mount, OutboundRow> {

        public OutboundRow convert(Mount source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getSourceText()).ifPresent(e -> row.put("SourceText", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getMountTypeId()).ifPresent(e -> row.put("MountTypeID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getSourceTypeEnum()).ifPresent(e -> row.put("SourceTypeEnum", Parameter.from(e)));
            Optional.ofNullable(source.getSourceSpellId()).ifPresent(e -> row.put("SourceSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getMountFlyRideHeight()).ifPresent(e -> row.put("MountFlyRideHeight", Parameter.from(e)));
            Optional.ofNullable(source.getUiModelSceneId()).ifPresent(e -> row.put("UiModelSceneID", Parameter.from(e)));
            Optional.ofNullable(source.getMountSpecialRiderAnimKitId()).ifPresent(e -> row.put("MountSpecialRiderAnimKitID", Parameter.from(e)));
            Optional.ofNullable(source.getMountSpecialSpellVisualKitId()).ifPresent(e -> row.put("MountSpecialSpellVisualKitID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
