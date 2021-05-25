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
@Table("artifact_appearance")
public class ArtifactAppearance {

    @Column("Name")
    private String name;
    @Column("ID")
    private Integer id;
    @Column("ArtifactAppearanceSetID")
    private Integer artifactAppearanceSetId;
    @Column("DisplayIndex")
    private Integer displayIndex;
    @Column("UnlockPlayerConditionID")
    private Integer unlockPlayerConditionId;
    @Column("ItemAppearanceModifierID")
    private Integer itemAppearanceModifierId;
    @Column("UiSwatchColor")
    private Integer uiSwatchColor;
    @Column("UiModelSaturation")
    private Double uiModelSaturation;
    @Column("UiModelOpacity")
    private Double uiModelOpacity;
    @Column("OverrideShapeshiftFormID")
    private Integer overrideShapeshiftFormId;
    @Column("OverrideShapeshiftDisplayID")
    private Integer overrideShapeshiftDisplayId;
    @Column("UiItemAppearanceID")
    private Integer uiItemAppearanceId;
    @Column("UiAltItemAppearanceID")
    private Integer uiAltItemAppearanceId;
    @Column("Flags")
    private Integer flags;
    @Column("UiCameraID")
    private Integer uiCameraId;
    @Column("UsablePlayerConditionID")
    private Integer usablePlayerConditionId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArtifactAppearance> {

        public ArtifactAppearance convert(Row row) {
            ArtifactAppearance domain = new ArtifactAppearance();
            domain.setName(row.get("Name", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setArtifactAppearanceSetId(row.get("ArtifactAppearanceSetID", Integer.class));
            domain.setDisplayIndex(row.get("DisplayIndex", Integer.class));
            domain.setUnlockPlayerConditionId(row.get("UnlockPlayerConditionID", Integer.class));
            domain.setItemAppearanceModifierId(row.get("ItemAppearanceModifierID", Integer.class));
            domain.setUiSwatchColor(row.get("UiSwatchColor", Integer.class));
            domain.setUiModelSaturation(row.get("UiModelSaturation", Double.class));
            domain.setUiModelOpacity(row.get("UiModelOpacity", Double.class));
            domain.setOverrideShapeshiftFormId(row.get("OverrideShapeshiftFormID", Integer.class));
            domain.setOverrideShapeshiftDisplayId(row.get("OverrideShapeshiftDisplayID", Integer.class));
            domain.setUiItemAppearanceId(row.get("UiItemAppearanceID", Integer.class));
            domain.setUiAltItemAppearanceId(row.get("UiAltItemAppearanceID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setUiCameraId(row.get("UiCameraID", Integer.class));
            domain.setUsablePlayerConditionId(row.get("UsablePlayerConditionID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArtifactAppearance, OutboundRow> {

        public OutboundRow convert(ArtifactAppearance source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactAppearanceSetId()).ifPresent(e -> row.put("ArtifactAppearanceSetID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayIndex()).ifPresent(e -> row.put("DisplayIndex", Parameter.from(e)));
            Optional.ofNullable(source.getUnlockPlayerConditionId()).ifPresent(e -> row.put("UnlockPlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getItemAppearanceModifierId()).ifPresent(e -> row.put("ItemAppearanceModifierID", Parameter.from(e)));
            Optional.ofNullable(source.getUiSwatchColor()).ifPresent(e -> row.put("UiSwatchColor", Parameter.from(e)));
            Optional.ofNullable(source.getUiModelSaturation()).ifPresent(e -> row.put("UiModelSaturation", Parameter.from(e)));
            Optional.ofNullable(source.getUiModelOpacity()).ifPresent(e -> row.put("UiModelOpacity", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideShapeshiftFormId()).ifPresent(e -> row.put("OverrideShapeshiftFormID", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideShapeshiftDisplayId()).ifPresent(e -> row.put("OverrideShapeshiftDisplayID", Parameter.from(e)));
            Optional.ofNullable(source.getUiItemAppearanceId()).ifPresent(e -> row.put("UiItemAppearanceID", Parameter.from(e)));
            Optional.ofNullable(source.getUiAltItemAppearanceId()).ifPresent(e -> row.put("UiAltItemAppearanceID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getUiCameraId()).ifPresent(e -> row.put("UiCameraID", Parameter.from(e)));
            Optional.ofNullable(source.getUsablePlayerConditionId()).ifPresent(e -> row.put("UsablePlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
