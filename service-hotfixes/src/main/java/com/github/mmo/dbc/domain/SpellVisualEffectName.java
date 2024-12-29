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


@Getter
@Setter
@ToString


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

    @Column("ID")
    private int id;

    @Column("EffectRadius")
    private Float effectRadius;

    @Column("BaseMissileSpeed")
    private Float baseMissileSpeed;

    @Column("Scale")
    private Float scale;

    @Column("MinAllowedScale")
    private Float minAllowedScale;

    @Column("MaxAllowedScale")
    private Float maxAllowedScale;

    @Column("Alpha")
    private Float alpha;

    @Column("Flags")
    private Integer flags;

    @Column("GenericID")
    private Integer genericID;

    @Column("TextureFileDataID")
    private Integer textureFileDataID;

    @Column("Type")
    private Byte type;

    @Column("ModelFileDataID")
    private Integer modelFileDataID;

    @Column("RibbonQualityID")
    private Integer ribbonQualityID;

    @Column("DissolveEffectID")
    private Integer dissolveEffectID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
