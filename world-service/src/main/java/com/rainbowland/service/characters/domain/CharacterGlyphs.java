package com.rainbowland.service.characters.domain;

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
@Table("character_glyphs")
public class CharacterGlyphs {

    @Column("guid")
    private Long guid;
    @Column("talentGroup")
    private Integer talentGroup;
    @Column("glyphId")
    private Integer glyphId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterGlyphs> {

        public CharacterGlyphs convert(Row row) {
            CharacterGlyphs domain = new CharacterGlyphs();
            domain.setGuid(row.get("guid", Long.class));
            domain.setTalentGroup(row.get("talentGroup", Integer.class));
            domain.setGlyphId(row.get("glyphId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterGlyphs, OutboundRow> {

        public OutboundRow convert(CharacterGlyphs source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getTalentGroup()).ifPresent(e -> row.put("talentGroup", Parameter.from(e)));
            Optional.ofNullable(source.getGlyphId()).ifPresent(e -> row.put("glyphId", Parameter.from(e)));
            return row;
        }
    }

}
