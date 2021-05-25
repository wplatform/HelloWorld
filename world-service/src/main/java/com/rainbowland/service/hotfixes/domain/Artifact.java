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
@Table("artifact")
public class Artifact {

    @Column("Name")
    private String name;
    @Column("ID")
    private Integer id;
    @Column("UiTextureKitID")
    private Integer uiTextureKitId;
    @Column("UiNameColor")
    private Integer uiNameColor;
    @Column("UiBarOverlayColor")
    private Integer uiBarOverlayColor;
    @Column("UiBarBackgroundColor")
    private Integer uiBarBackgroundColor;
    @Column("ChrSpecializationID")
    private Integer chrSpecializationId;
    @Column("Flags")
    private Integer flags;
    @Column("ArtifactCategoryID")
    private Integer artifactCategoryId;
    @Column("UiModelSceneID")
    private Integer uiModelSceneId;
    @Column("SpellVisualKitID")
    private Integer spellVisualKitId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Artifact> {

        public Artifact convert(Row row) {
            Artifact domain = new Artifact();
            domain.setName(row.get("Name", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setUiTextureKitId(row.get("UiTextureKitID", Integer.class));
            domain.setUiNameColor(row.get("UiNameColor", Integer.class));
            domain.setUiBarOverlayColor(row.get("UiBarOverlayColor", Integer.class));
            domain.setUiBarBackgroundColor(row.get("UiBarBackgroundColor", Integer.class));
            domain.setChrSpecializationId(row.get("ChrSpecializationID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setArtifactCategoryId(row.get("ArtifactCategoryID", Integer.class));
            domain.setUiModelSceneId(row.get("UiModelSceneID", Integer.class));
            domain.setSpellVisualKitId(row.get("SpellVisualKitID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Artifact, OutboundRow> {

        public OutboundRow convert(Artifact source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureKitId()).ifPresent(e -> row.put("UiTextureKitID", Parameter.from(e)));
            Optional.ofNullable(source.getUiNameColor()).ifPresent(e -> row.put("UiNameColor", Parameter.from(e)));
            Optional.ofNullable(source.getUiBarOverlayColor()).ifPresent(e -> row.put("UiBarOverlayColor", Parameter.from(e)));
            Optional.ofNullable(source.getUiBarBackgroundColor()).ifPresent(e -> row.put("UiBarBackgroundColor", Parameter.from(e)));
            Optional.ofNullable(source.getChrSpecializationId()).ifPresent(e -> row.put("ChrSpecializationID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactCategoryId()).ifPresent(e -> row.put("ArtifactCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getUiModelSceneId()).ifPresent(e -> row.put("UiModelSceneID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellVisualKitId()).ifPresent(e -> row.put("SpellVisualKitID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
