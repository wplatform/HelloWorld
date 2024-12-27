package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "artifact")
@Db2DataBind(name = "Artifact.db2", layoutHash = 0x76CF31A8, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "uiBarOverlayColor", type = Db2Type.INT, signed = true),
        @Db2Field(name = "uiBarBackgroundColor", type = Db2Type.INT, signed = true),
        @Db2Field(name = "uiNameColor", type = Db2Type.INT, signed = true),
        @Db2Field(name = "uiTextureKitID", type = Db2Type.SHORT),
        @Db2Field(name = "chrSpecializationID", type = Db2Type.SHORT),
        @Db2Field(name = "artifactCategoryID", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "uiModelSceneID", type = Db2Type.INT),
        @Db2Field(name = "spellVisualKitID", type = Db2Type.INT)
})
public class Artifact implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "UiBarOverlayColor")
    private Integer uiBarOverlayColor;

    @Column(name = "UiBarBackgroundColor")
    private Integer uiBarBackgroundColor;

    @Column(name = "UiNameColor")
    private Integer uiNameColor;

    @Column(name = "UiTextureKitID")
    private Short uiTextureKitID;

    @Column(name = "ChrSpecializationID")
    private Short chrSpecializationID;

    @Column(name = "ArtifactCategoryID")
    private Byte artifactCategoryID;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "UiModelSceneID")
    private Integer uiModelSceneID;

    @Column(name = "SpellVisualKitID")
    private Integer spellVisualKitID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
