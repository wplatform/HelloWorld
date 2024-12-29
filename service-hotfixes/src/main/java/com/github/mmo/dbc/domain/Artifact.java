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
    
    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("UiBarOverlayColor")
    private Integer uiBarOverlayColor;

    @Column("UiBarBackgroundColor")
    private Integer uiBarBackgroundColor;

    @Column("UiNameColor")
    private Integer uiNameColor;

    @Column("UiTextureKitID")
    private Short uiTextureKitID;

    @Column("ChrSpecializationID")
    private Short chrSpecializationID;

    @Column("ArtifactCategoryID")
    private Byte artifactCategoryID;

    @Column("Flags")
    private Byte flags;

    @Column("UiModelSceneID")
    private Integer uiModelSceneID;

    @Column("SpellVisualKitID")
    private Integer spellVisualKitID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
