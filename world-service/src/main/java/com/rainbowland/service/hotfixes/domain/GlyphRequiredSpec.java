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
@Table("glyph_required_spec")
public class GlyphRequiredSpec {

    @Column("ID")
    private Integer id;
    @Column("ChrSpecializationID")
    private Integer chrSpecializationId;
    @Column("GlyphPropertiesID")
    private Integer glyphPropertiesId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GlyphRequiredSpec> {

        public GlyphRequiredSpec convert(Row row) {
            GlyphRequiredSpec domain = new GlyphRequiredSpec();
            domain.setId(row.get("ID", Integer.class));
            domain.setChrSpecializationId(row.get("ChrSpecializationID", Integer.class));
            domain.setGlyphPropertiesId(row.get("GlyphPropertiesID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GlyphRequiredSpec, OutboundRow> {

        public OutboundRow convert(GlyphRequiredSpec source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getChrSpecializationId()).ifPresent(e -> row.put("ChrSpecializationID", Parameter.from(e)));
            Optional.ofNullable(source.getGlyphPropertiesId()).ifPresent(e -> row.put("GlyphPropertiesID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
