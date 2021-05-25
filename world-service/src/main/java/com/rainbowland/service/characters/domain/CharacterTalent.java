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
@Table("character_talent")
public class CharacterTalent {

    @Column("guid")
    private Long guid;
    @Column("talentId")
    private Integer talentId;
    @Column("talentGroup")
    private Integer talentGroup;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterTalent> {

        public CharacterTalent convert(Row row) {
            CharacterTalent domain = new CharacterTalent();
            domain.setGuid(row.get("guid", Long.class));
            domain.setTalentId(row.get("talentId", Integer.class));
            domain.setTalentGroup(row.get("talentGroup", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterTalent, OutboundRow> {

        public OutboundRow convert(CharacterTalent source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getTalentId()).ifPresent(e -> row.put("talentId", Parameter.from(e)));
            Optional.ofNullable(source.getTalentGroup()).ifPresent(e -> row.put("talentGroup", Parameter.from(e)));
            return row;
        }
    }

}
