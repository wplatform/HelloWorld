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
@Table(name = "liquid_type")
@Db2DataBind(name = "LiquidType.db2", layoutHash = 0x3313BBF3, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = {"texture1", "texture2", "texture3", "texture4", "texture5", "texture6"}, type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "spellID", type = Db2Type.INT),
        @Db2Field(name = "maxDarkenDepth", type = Db2Type.FLOAT),
        @Db2Field(name = "fogDarkenIntensity", type = Db2Type.FLOAT),
        @Db2Field(name = "ambDarkenIntensity", type = Db2Type.FLOAT),
        @Db2Field(name = "dirDarkenIntensity", type = Db2Type.FLOAT),
        @Db2Field(name = "particleScale", type = Db2Type.FLOAT),
        @Db2Field(name = {"color1", "color2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"float1", "float2", "float3", "float4", "float5", "float6", "float7", "float8", "float9", "float10", "float11", "float12", "float13", "float14", "float15", "float16", "float17", "float18"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"int1", "int2", "int3", "int4"}, type = Db2Type.INT),
        @Db2Field(name = "flags", type = Db2Type.SHORT),
        @Db2Field(name = "lightID", type = Db2Type.SHORT),
        @Db2Field(name = "soundBank", type = Db2Type.BYTE),
        @Db2Field(name = "particleMovement", type = Db2Type.BYTE),
        @Db2Field(name = "particleTexSlots", type = Db2Type.BYTE),
        @Db2Field(name = "materialID", type = Db2Type.BYTE),
        @Db2Field(name = {"frameCountTexture1", "frameCountTexture2", "frameCountTexture3", "frameCountTexture4", "frameCountTexture5", "frameCountTexture6"}, type = Db2Type.BYTE),
        @Db2Field(name = "soundID", type = Db2Type.INT)
})
public class LiquidType implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Texture1")
    private String texture1;

    @Column(name = "Texture2")
    private String texture2;

    @Column(name = "Texture3")
    private String texture3;

    @Column(name = "Texture4")
    private String texture4;

    @Column(name = "Texture5")
    private String texture5;

    @Column(name = "Texture6")
    private String texture6;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "MaxDarkenDepth")
    private Float maxDarkenDepth;

    @Column(name = "FogDarkenIntensity")
    private Float fogDarkenIntensity;

    @Column(name = "AmbDarkenIntensity")
    private Float ambDarkenIntensity;

    @Column(name = "DirDarkenIntensity")
    private Float dirDarkenIntensity;

    @Column(name = "ParticleScale")
    private Float particleScale;

    @Column(name = "Color1")
    private Integer color1;

    @Column(name = "Color2")
    private Integer color2;

    @Column(name = "Float1")
    private Float float1;

    @Column(name = "Float2")
    private Float float2;

    @Column(name = "Float3")
    private Float float3;

    @Column(name = "Float4")
    private Float float4;

    @Column(name = "Float5")
    private Float float5;

    @Column(name = "Float6")
    private Float float6;

    @Column(name = "Float7")
    private Float float7;

    @Column(name = "Float8")
    private Float float8;

    @Column(name = "Float9")
    private Float float9;

    @Column(name = "Float10")
    private Float float10;

    @Column(name = "Float11")
    private Float float11;

    @Column(name = "Float12")
    private Float float12;

    @Column(name = "Float13")
    private Float float13;

    @Column(name = "Float14")
    private Float float14;

    @Column(name = "Float15")
    private Float float15;

    @Column(name = "Float16")
    private Float float16;

    @Column(name = "Float17")
    private Float float17;

    @Column(name = "Float18")
    private Float float18;

    @Column(name = "Int1")
    private Integer int1;

    @Column(name = "Int2")
    private Integer int2;

    @Column(name = "Int3")
    private Integer int3;

    @Column(name = "Int4")
    private Integer int4;

    @Column(name = "Flags")
    private Short flags;

    @Column(name = "LightID")
    private Short lightID;

    @Column(name = "SoundBank")
    private Byte soundBank;

    @Column(name = "ParticleMovement")
    private Byte particleMovement;

    @Column(name = "ParticleTexSlots")
    private Byte particleTexSlots;

    @Column(name = "MaterialID")
    private Byte materialID;

    @Column(name = "FrameCountTexture1")
    private Byte frameCountTexture1;

    @Column(name = "FrameCountTexture2")
    private Byte frameCountTexture2;

    @Column(name = "FrameCountTexture3")
    private Byte frameCountTexture3;

    @Column(name = "FrameCountTexture4")
    private Byte frameCountTexture4;

    @Column(name = "FrameCountTexture5")
    private Byte frameCountTexture5;

    @Column(name = "FrameCountTexture6")
    private Byte frameCountTexture6;

    @Column(name = "SoundID")
    private Integer soundID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
