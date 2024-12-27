package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
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
@Table(name = "spell_visual_effect_name")
@Db2DataBind(name = "SpellVisualEffectName.db2", layoutHash = 0xB930A934, fields = {
        @Db2Field(name = "effectRadius", type = Db2Type.FLOAT),
        @Db2Field(name = "baseMissileSpeed", type = Db2Type.FLOAT),
        @Db2Field(name = "scale", type = Db2Type.FLOAT),
        @Db2Field(name = "minAllowedScale", type = Db2Type.FLOAT),
        @Db2Field(name = "maxAllowedScale", type = Db2Type.FLOAT),
        @Db2Field(name = "alpha", type = Db2Type.FLOAT),
        @Db2Field(name = "flags", type = Db2Type.INT),
        @Db2Field(name = "genericID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "textureFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "type", type = Db2Type.BYTE),
        @Db2Field(name = "modelFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "ribbonQualityID", type = Db2Type.INT),
        @Db2Field(name = "dissolveEffectID", type = Db2Type.INT, signed = true)
})
public class SpellVisualEffectName implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "EffectRadius")
    private Float effectRadius;

    @Column(name = "BaseMissileSpeed")
    private Float baseMissileSpeed;

    @Column(name = "Scale")
    private Float scale;

    @Column(name = "MinAllowedScale")
    private Float minAllowedScale;

    @Column(name = "MaxAllowedScale")
    private Float maxAllowedScale;

    @Column(name = "Alpha")
    private Float alpha;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "GenericID")
    private Integer genericID;

    @Column(name = "TextureFileDataID")
    private Integer textureFileDataID;

    @Column(name = "Type")
    private Byte type;

    @Column(name = "ModelFileDataID")
    private Integer modelFileDataID;

    @Column(name = "RibbonQualityID")
    private Integer ribbonQualityID;

    @Column(name = "DissolveEffectID")
    private Integer dissolveEffectID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
