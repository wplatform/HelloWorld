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
@Table("artifact_appearance_set")
public class ArtifactAppearanceSet {

    @Column("Name")
    private String name;
    @Column("Description")
    private String description;
    @Column("ID")
    private Integer id;
    @Column("DisplayIndex")
    private Integer displayIndex;
    @Column("UiCameraID")
    private Integer uiCameraId;
    @Column("AltHandUICameraID")
    private Integer altHandUiCameraId;
    @Column("ForgeAttachmentOverride")
    private Integer forgeAttachmentOverride;
    @Column("Flags")
    private Integer flags;
    @Column("ArtifactID")
    private Integer artifactId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArtifactAppearanceSet> {

        public ArtifactAppearanceSet convert(Row row) {
            ArtifactAppearanceSet domain = new ArtifactAppearanceSet();
            domain.setName(row.get("Name", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setDisplayIndex(row.get("DisplayIndex", Integer.class));
            domain.setUiCameraId(row.get("UiCameraID", Integer.class));
            domain.setAltHandUiCameraId(row.get("AltHandUICameraID", Integer.class));
            domain.setForgeAttachmentOverride(row.get("ForgeAttachmentOverride", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setArtifactId(row.get("ArtifactID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArtifactAppearanceSet, OutboundRow> {

        public OutboundRow convert(ArtifactAppearanceSet source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayIndex()).ifPresent(e -> row.put("DisplayIndex", Parameter.from(e)));
            Optional.ofNullable(source.getUiCameraId()).ifPresent(e -> row.put("UiCameraID", Parameter.from(e)));
            Optional.ofNullable(source.getAltHandUiCameraId()).ifPresent(e -> row.put("AltHandUICameraID", Parameter.from(e)));
            Optional.ofNullable(source.getForgeAttachmentOverride()).ifPresent(e -> row.put("ForgeAttachmentOverride", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactId()).ifPresent(e -> row.put("ArtifactID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
