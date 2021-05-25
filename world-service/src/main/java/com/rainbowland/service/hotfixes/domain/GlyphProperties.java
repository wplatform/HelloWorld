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
@Table("glyph_properties")
public class GlyphProperties {

    @Column("ID")
    private Integer id;
    @Column("SpellID")
    private Integer spellId;
    @Column("GlyphType")
    private Integer glyphType;
    @Column("GlyphExclusiveCategoryID")
    private Integer glyphExclusiveCategoryId;
    @Column("SpellIconFileDataID")
    private Integer spellIconFileDataId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GlyphProperties> {

        public GlyphProperties convert(Row row) {
            GlyphProperties domain = new GlyphProperties();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setGlyphType(row.get("GlyphType", Integer.class));
            domain.setGlyphExclusiveCategoryId(row.get("GlyphExclusiveCategoryID", Integer.class));
            domain.setSpellIconFileDataId(row.get("SpellIconFileDataID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GlyphProperties, OutboundRow> {

        public OutboundRow convert(GlyphProperties source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getGlyphType()).ifPresent(e -> row.put("GlyphType", Parameter.from(e)));
            Optional.ofNullable(source.getGlyphExclusiveCategoryId()).ifPresent(e -> row.put("GlyphExclusiveCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellIconFileDataId()).ifPresent(e -> row.put("SpellIconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
