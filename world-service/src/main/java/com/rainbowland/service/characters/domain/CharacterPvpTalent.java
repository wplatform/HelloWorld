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
@Table("character_pvp_talent")
public class CharacterPvpTalent {

    @Column("guid")
    private Long guid;
    @Column("talentId0")
    private Integer talentId0;
    @Column("talentId1")
    private Integer talentId1;
    @Column("talentId2")
    private Integer talentId2;
    @Column("talentId3")
    private Integer talentId3;
    @Column("talentGroup")
    private Integer talentGroup;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterPvpTalent> {

        public CharacterPvpTalent convert(Row row) {
            CharacterPvpTalent domain = new CharacterPvpTalent();
            domain.setGuid(row.get("guid", Long.class));
            domain.setTalentId0(row.get("talentId0", Integer.class));
            domain.setTalentId1(row.get("talentId1", Integer.class));
            domain.setTalentId2(row.get("talentId2", Integer.class));
            domain.setTalentId3(row.get("talentId3", Integer.class));
            domain.setTalentGroup(row.get("talentGroup", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterPvpTalent, OutboundRow> {

        public OutboundRow convert(CharacterPvpTalent source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getTalentId0()).ifPresent(e -> row.put("talentId0", Parameter.from(e)));
            Optional.ofNullable(source.getTalentId1()).ifPresent(e -> row.put("talentId1", Parameter.from(e)));
            Optional.ofNullable(source.getTalentId2()).ifPresent(e -> row.put("talentId2", Parameter.from(e)));
            Optional.ofNullable(source.getTalentId3()).ifPresent(e -> row.put("talentId3", Parameter.from(e)));
            Optional.ofNullable(source.getTalentGroup()).ifPresent(e -> row.put("talentGroup", Parameter.from(e)));
            return row;
        }
    }

}
