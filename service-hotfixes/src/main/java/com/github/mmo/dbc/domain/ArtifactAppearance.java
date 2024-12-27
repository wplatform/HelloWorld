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
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
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
    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "UiSwatchColor")
    private Integer uiSwatchColor;

    @Column(name = "UiModelSaturation")
    private Float uiModelSaturation;

    @Column(name = "UiModelOpacity")
    private Float uiModelOpacity;

    @Column(name = "OverrideShapeshiftDisplayID")
    private Integer overrideShapeshiftDisplayID;

    @Column(name = "ArtifactAppearanceSetID")
    private Short artifactAppearanceSetID;

    @Column(name = "UiCameraID")
    private Short uiCameraID;

    @Column(name = "DisplayIndex")
    private Byte displayIndex;

    @Column(name = "ItemAppearanceModifierID")
    private Byte itemAppearanceModifierID;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "OverrideShapeshiftFormID")
    private Byte overrideShapeshiftFormID;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "UnlockPlayerConditionID")
    private Integer unlockPlayerConditionID;

    @Column(name = "UiItemAppearanceID")
    private Integer uiItemAppearanceID;

    @Column(name = "UiAltItemAppearanceID")
    private Integer uiAltItemAppearanceID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
