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
@Table("character_garrison")
public class CharacterGarrison {

    @Column("guid")
    private Long guid;
    @Column("siteLevelId")
    private Integer siteLevelId;
    @Column("followerActivationsRemainingToday")
    private Integer followerActivationsRemainingToday;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterGarrison> {

        public CharacterGarrison convert(Row row) {
            CharacterGarrison domain = new CharacterGarrison();
            domain.setGuid(row.get("guid", Long.class));
            domain.setSiteLevelId(row.get("siteLevelId", Integer.class));
            domain.setFollowerActivationsRemainingToday(row.get("followerActivationsRemainingToday", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterGarrison, OutboundRow> {

        public OutboundRow convert(CharacterGarrison source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getSiteLevelId()).ifPresent(e -> row.put("siteLevelId", Parameter.from(e)));
            Optional.ofNullable(source.getFollowerActivationsRemainingToday()).ifPresent(e -> row.put("followerActivationsRemainingToday", Parameter.from(e)));
            return row;
        }
    }

}
