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
@Table("liquid_type")
public class LiquidType {

    @Column("ID")
    private Integer id;
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
    @Column("Flags")
    private Integer flags;
    @Column("SoundBank")
    private Integer soundBank;
    @Column("SoundID")
    private Integer soundId;
    @Column("SpellID")
    private Integer spellId;
    @Column("MaxDarkenDepth")
    private Double maxDarkenDepth;
    @Column("FogDarkenIntensity")
    private Double fogDarkenIntensity;
    @Column("AmbDarkenIntensity")
    private Double ambDarkenIntensity;
    @Column("DirDarkenIntensity")
    private Double dirDarkenIntensity;
    @Column("LightID")
    private Integer lightId;
    @Column("ParticleScale")
    private Double particleScale;
    @Column("ParticleMovement")
    private Integer particleMovement;
    @Column("ParticleTexSlots")
    private Integer particleTexSlots;
    @Column("MaterialID")
    private Integer materialId;
    @Column("MinimapStaticCol")
    private Integer minimapStaticCol;
    @Column("FrameCountTexture1")
    private Integer frameCountTexture1;
    @Column("FrameCountTexture2")
    private Integer frameCountTexture2;
    @Column("FrameCountTexture3")
    private Integer frameCountTexture3;
    @Column("FrameCountTexture4")
    private Integer frameCountTexture4;
    @Column("FrameCountTexture5")
    private Integer frameCountTexture5;
    @Column("FrameCountTexture6")
    private Integer frameCountTexture6;
    @Column("Color1")
    private Integer color1;
    @Column("Color2")
    private Integer color2;
    @Column("Float1")
    private Double float1;
    @Column("Float2")
    private Double float2;
    @Column("Float3")
    private Double float3;
    @Column("Float4")
    private Double float4;
    @Column("Float5")
    private Double float5;
    @Column("Float6")
    private Double float6;
    @Column("Float7")
    private Double float7;
    @Column("Float8")
    private Double float8;
    @Column("Float9")
    private Double float9;
    @Column("Float10")
    private Double float10;
    @Column("Float11")
    private Double float11;
    @Column("Float12")
    private Double float12;
    @Column("Float13")
    private Double float13;
    @Column("Float14")
    private Double float14;
    @Column("Float15")
    private Double float15;
    @Column("Float16")
    private Double float16;
    @Column("Float17")
    private Double float17;
    @Column("Float18")
    private Double float18;
    @Column("Int1")
    private Integer int1;
    @Column("Int2")
    private Integer int2;
    @Column("Int3")
    private Integer int3;
    @Column("Int4")
    private Integer int4;
    @Column("Coefficient1")
    private Double coefficient1;
    @Column("Coefficient2")
    private Double coefficient2;
    @Column("Coefficient3")
    private Double coefficient3;
    @Column("Coefficient4")
    private Double coefficient4;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, LiquidType> {

        public LiquidType convert(Row row) {
            LiquidType domain = new LiquidType();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setTexture1(row.get("Texture1", String.class));
            domain.setTexture2(row.get("Texture2", String.class));
            domain.setTexture3(row.get("Texture3", String.class));
            domain.setTexture4(row.get("Texture4", String.class));
            domain.setTexture5(row.get("Texture5", String.class));
            domain.setTexture6(row.get("Texture6", String.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setSoundBank(row.get("SoundBank", Integer.class));
            domain.setSoundId(row.get("SoundID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setMaxDarkenDepth(row.get("MaxDarkenDepth", Double.class));
            domain.setFogDarkenIntensity(row.get("FogDarkenIntensity", Double.class));
            domain.setAmbDarkenIntensity(row.get("AmbDarkenIntensity", Double.class));
            domain.setDirDarkenIntensity(row.get("DirDarkenIntensity", Double.class));
            domain.setLightId(row.get("LightID", Integer.class));
            domain.setParticleScale(row.get("ParticleScale", Double.class));
            domain.setParticleMovement(row.get("ParticleMovement", Integer.class));
            domain.setParticleTexSlots(row.get("ParticleTexSlots", Integer.class));
            domain.setMaterialId(row.get("MaterialID", Integer.class));
            domain.setMinimapStaticCol(row.get("MinimapStaticCol", Integer.class));
            domain.setFrameCountTexture1(row.get("FrameCountTexture1", Integer.class));
            domain.setFrameCountTexture2(row.get("FrameCountTexture2", Integer.class));
            domain.setFrameCountTexture3(row.get("FrameCountTexture3", Integer.class));
            domain.setFrameCountTexture4(row.get("FrameCountTexture4", Integer.class));
            domain.setFrameCountTexture5(row.get("FrameCountTexture5", Integer.class));
            domain.setFrameCountTexture6(row.get("FrameCountTexture6", Integer.class));
            domain.setColor1(row.get("Color1", Integer.class));
            domain.setColor2(row.get("Color2", Integer.class));
            domain.setFloat1(row.get("Float1", Double.class));
            domain.setFloat2(row.get("Float2", Double.class));
            domain.setFloat3(row.get("Float3", Double.class));
            domain.setFloat4(row.get("Float4", Double.class));
            domain.setFloat5(row.get("Float5", Double.class));
            domain.setFloat6(row.get("Float6", Double.class));
            domain.setFloat7(row.get("Float7", Double.class));
            domain.setFloat8(row.get("Float8", Double.class));
            domain.setFloat9(row.get("Float9", Double.class));
            domain.setFloat10(row.get("Float10", Double.class));
            domain.setFloat11(row.get("Float11", Double.class));
            domain.setFloat12(row.get("Float12", Double.class));
            domain.setFloat13(row.get("Float13", Double.class));
            domain.setFloat14(row.get("Float14", Double.class));
            domain.setFloat15(row.get("Float15", Double.class));
            domain.setFloat16(row.get("Float16", Double.class));
            domain.setFloat17(row.get("Float17", Double.class));
            domain.setFloat18(row.get("Float18", Double.class));
            domain.setInt1(row.get("Int1", Integer.class));
            domain.setInt2(row.get("Int2", Integer.class));
            domain.setInt3(row.get("Int3", Integer.class));
            domain.setInt4(row.get("Int4", Integer.class));
            domain.setCoefficient1(row.get("Coefficient1", Double.class));
            domain.setCoefficient2(row.get("Coefficient2", Double.class));
            domain.setCoefficient3(row.get("Coefficient3", Double.class));
            domain.setCoefficient4(row.get("Coefficient4", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<LiquidType, OutboundRow> {

        public OutboundRow convert(LiquidType source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getTexture1()).ifPresent(e -> row.put("Texture1", Parameter.from(e)));
            Optional.ofNullable(source.getTexture2()).ifPresent(e -> row.put("Texture2", Parameter.from(e)));
            Optional.ofNullable(source.getTexture3()).ifPresent(e -> row.put("Texture3", Parameter.from(e)));
            Optional.ofNullable(source.getTexture4()).ifPresent(e -> row.put("Texture4", Parameter.from(e)));
            Optional.ofNullable(source.getTexture5()).ifPresent(e -> row.put("Texture5", Parameter.from(e)));
            Optional.ofNullable(source.getTexture6()).ifPresent(e -> row.put("Texture6", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getSoundBank()).ifPresent(e -> row.put("SoundBank", Parameter.from(e)));
            Optional.ofNullable(source.getSoundId()).ifPresent(e -> row.put("SoundID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxDarkenDepth()).ifPresent(e -> row.put("MaxDarkenDepth", Parameter.from(e)));
            Optional.ofNullable(source.getFogDarkenIntensity()).ifPresent(e -> row.put("FogDarkenIntensity", Parameter.from(e)));
            Optional.ofNullable(source.getAmbDarkenIntensity()).ifPresent(e -> row.put("AmbDarkenIntensity", Parameter.from(e)));
            Optional.ofNullable(source.getDirDarkenIntensity()).ifPresent(e -> row.put("DirDarkenIntensity", Parameter.from(e)));
            Optional.ofNullable(source.getLightId()).ifPresent(e -> row.put("LightID", Parameter.from(e)));
            Optional.ofNullable(source.getParticleScale()).ifPresent(e -> row.put("ParticleScale", Parameter.from(e)));
            Optional.ofNullable(source.getParticleMovement()).ifPresent(e -> row.put("ParticleMovement", Parameter.from(e)));
            Optional.ofNullable(source.getParticleTexSlots()).ifPresent(e -> row.put("ParticleTexSlots", Parameter.from(e)));
            Optional.ofNullable(source.getMaterialId()).ifPresent(e -> row.put("MaterialID", Parameter.from(e)));
            Optional.ofNullable(source.getMinimapStaticCol()).ifPresent(e -> row.put("MinimapStaticCol", Parameter.from(e)));
            Optional.ofNullable(source.getFrameCountTexture1()).ifPresent(e -> row.put("FrameCountTexture1", Parameter.from(e)));
            Optional.ofNullable(source.getFrameCountTexture2()).ifPresent(e -> row.put("FrameCountTexture2", Parameter.from(e)));
            Optional.ofNullable(source.getFrameCountTexture3()).ifPresent(e -> row.put("FrameCountTexture3", Parameter.from(e)));
            Optional.ofNullable(source.getFrameCountTexture4()).ifPresent(e -> row.put("FrameCountTexture4", Parameter.from(e)));
            Optional.ofNullable(source.getFrameCountTexture5()).ifPresent(e -> row.put("FrameCountTexture5", Parameter.from(e)));
            Optional.ofNullable(source.getFrameCountTexture6()).ifPresent(e -> row.put("FrameCountTexture6", Parameter.from(e)));
            Optional.ofNullable(source.getColor1()).ifPresent(e -> row.put("Color1", Parameter.from(e)));
            Optional.ofNullable(source.getColor2()).ifPresent(e -> row.put("Color2", Parameter.from(e)));
            Optional.ofNullable(source.getFloat1()).ifPresent(e -> row.put("Float1", Parameter.from(e)));
            Optional.ofNullable(source.getFloat2()).ifPresent(e -> row.put("Float2", Parameter.from(e)));
            Optional.ofNullable(source.getFloat3()).ifPresent(e -> row.put("Float3", Parameter.from(e)));
            Optional.ofNullable(source.getFloat4()).ifPresent(e -> row.put("Float4", Parameter.from(e)));
            Optional.ofNullable(source.getFloat5()).ifPresent(e -> row.put("Float5", Parameter.from(e)));
            Optional.ofNullable(source.getFloat6()).ifPresent(e -> row.put("Float6", Parameter.from(e)));
            Optional.ofNullable(source.getFloat7()).ifPresent(e -> row.put("Float7", Parameter.from(e)));
            Optional.ofNullable(source.getFloat8()).ifPresent(e -> row.put("Float8", Parameter.from(e)));
            Optional.ofNullable(source.getFloat9()).ifPresent(e -> row.put("Float9", Parameter.from(e)));
            Optional.ofNullable(source.getFloat10()).ifPresent(e -> row.put("Float10", Parameter.from(e)));
            Optional.ofNullable(source.getFloat11()).ifPresent(e -> row.put("Float11", Parameter.from(e)));
            Optional.ofNullable(source.getFloat12()).ifPresent(e -> row.put("Float12", Parameter.from(e)));
            Optional.ofNullable(source.getFloat13()).ifPresent(e -> row.put("Float13", Parameter.from(e)));
            Optional.ofNullable(source.getFloat14()).ifPresent(e -> row.put("Float14", Parameter.from(e)));
            Optional.ofNullable(source.getFloat15()).ifPresent(e -> row.put("Float15", Parameter.from(e)));
            Optional.ofNullable(source.getFloat16()).ifPresent(e -> row.put("Float16", Parameter.from(e)));
            Optional.ofNullable(source.getFloat17()).ifPresent(e -> row.put("Float17", Parameter.from(e)));
            Optional.ofNullable(source.getFloat18()).ifPresent(e -> row.put("Float18", Parameter.from(e)));
            Optional.ofNullable(source.getInt1()).ifPresent(e -> row.put("Int1", Parameter.from(e)));
            Optional.ofNullable(source.getInt2()).ifPresent(e -> row.put("Int2", Parameter.from(e)));
            Optional.ofNullable(source.getInt3()).ifPresent(e -> row.put("Int3", Parameter.from(e)));
            Optional.ofNullable(source.getInt4()).ifPresent(e -> row.put("Int4", Parameter.from(e)));
            Optional.ofNullable(source.getCoefficient1()).ifPresent(e -> row.put("Coefficient1", Parameter.from(e)));
            Optional.ofNullable(source.getCoefficient2()).ifPresent(e -> row.put("Coefficient2", Parameter.from(e)));
            Optional.ofNullable(source.getCoefficient3()).ifPresent(e -> row.put("Coefficient3", Parameter.from(e)));
            Optional.ofNullable(source.getCoefficient4()).ifPresent(e -> row.put("Coefficient4", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
