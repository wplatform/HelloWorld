package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
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
    
    @Column("ID")
    private int id;

    @Column("Name")
    private String name;

    @Column("Texture1")
    private String texture1;

    @Column("Texture2")
    private String texture2;

    @Column("Texture3")
    private String texture3;

    @Column("Texture4")
    private String texture4;

    @Column("Texture5")
    private String texture5;

    @Column("Texture6")
    private String texture6;

    @Column("SpellID")
    private Integer spellID;

    @Column("MaxDarkenDepth")
    private Float maxDarkenDepth;

    @Column("FogDarkenIntensity")
    private Float fogDarkenIntensity;

    @Column("AmbDarkenIntensity")
    private Float ambDarkenIntensity;

    @Column("DirDarkenIntensity")
    private Float dirDarkenIntensity;

    @Column("ParticleScale")
    private Float particleScale;

    @Column("Color1")
    private Integer color1;

    @Column("Color2")
    private Integer color2;

    @Column("Float1")
    private Float float1;

    @Column("Float2")
    private Float float2;

    @Column("Float3")
    private Float float3;

    @Column("Float4")
    private Float float4;

    @Column("Float5")
    private Float float5;

    @Column("Float6")
    private Float float6;

    @Column("Float7")
    private Float float7;

    @Column("Float8")
    private Float float8;

    @Column("Float9")
    private Float float9;

    @Column("Float10")
    private Float float10;

    @Column("Float11")
    private Float float11;

    @Column("Float12")
    private Float float12;

    @Column("Float13")
    private Float float13;

    @Column("Float14")
    private Float float14;

    @Column("Float15")
    private Float float15;

    @Column("Float16")
    private Float float16;

    @Column("Float17")
    private Float float17;

    @Column("Float18")
    private Float float18;

    @Column("Int1")
    private Integer int1;

    @Column("Int2")
    private Integer int2;

    @Column("Int3")
    private Integer int3;

    @Column("Int4")
    private Integer int4;

    @Column("Flags")
    private Short flags;

    @Column("LightID")
    private Short lightID;

    @Column("SoundBank")
    private Byte soundBank;

    @Column("ParticleMovement")
    private Byte particleMovement;

    @Column("ParticleTexSlots")
    private Byte particleTexSlots;

    @Column("MaterialID")
    private Byte materialID;

    @Column("FrameCountTexture1")
    private Byte frameCountTexture1;

    @Column("FrameCountTexture2")
    private Byte frameCountTexture2;

    @Column("FrameCountTexture3")
    private Byte frameCountTexture3;

    @Column("FrameCountTexture4")
    private Byte frameCountTexture4;

    @Column("FrameCountTexture5")
    private Byte frameCountTexture5;

    @Column("FrameCountTexture6")
    private Byte frameCountTexture6;

    @Column("SoundID")
    private Integer soundID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
