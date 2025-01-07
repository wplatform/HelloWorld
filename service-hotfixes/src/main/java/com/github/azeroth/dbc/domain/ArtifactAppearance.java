package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.LocalizedString;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "artifact_appearance")
@Db2DataBind(name = "ArtifactAppearance.db2", layoutHash = 0xAEED7395, indexField = 11, parentIndexField = 5, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "uiSwatchColor", type = Db2Type.INT, signed = true),
        @Db2Field(name = "uiModelSaturation", type = Db2Type.FLOAT),
        @Db2Field(name = "uiModelOpacity", type = Db2Type.FLOAT),
        @Db2Field(name = "overrideShapeshiftDisplayID", type = Db2Type.INT),
        @Db2Field(name = "artifactAppearanceSetID", type = Db2Type.SHORT),
        @Db2Field(name = "uiCameraID", type = Db2Type.SHORT),
        @Db2Field(name = "displayIndex", type = Db2Type.BYTE),
        @Db2Field(name = "itemAppearanceModifierID", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "overrideShapeshiftFormID", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "unlockPlayerConditionID", type = Db2Type.INT),
        @Db2Field(name = "uiItemAppearanceID", type = Db2Type.INT),
        @Db2Field(name = "uiAltItemAppearanceID", type = Db2Type.INT)
})
public class ArtifactAppearance implements DbcEntity {
    @Column("Name")
    private LocalizedString name;

    @Column("UiSwatchColor")
    private Integer uiSwatchColor;

    @Column("UiModelSaturation")
    private Float uiModelSaturation;

    @Column("UiModelOpacity")
    private Float uiModelOpacity;

    @Column("OverrideShapeshiftDisplayID")
    private Integer overrideShapeshiftDisplayID;

    @Column("ArtifactAppearanceSetID")
    private Short artifactAppearanceSetID;

    @Column("UiCameraID")
    private Short uiCameraID;

    @Column("DisplayIndex")
    private Byte displayIndex;

    @Column("ItemAppearanceModifierID")
    private Byte itemAppearanceModifierID;

    @Column("Flags")
    private Byte flags;

    @Column("OverrideShapeshiftFormID")
    private Byte overrideShapeshiftFormID;

    @Id

    @Column("ID")
    private int id;

    @Column("UnlockPlayerConditionID")
    private Integer unlockPlayerConditionID;

    @Column("UiItemAppearanceID")
    private Integer uiItemAppearanceID;

    @Column("UiAltItemAppearanceID")
    private Integer uiAltItemAppearanceID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
