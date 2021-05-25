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
@Table("character_banned")
public class CharacterBanned {

    @Column("guid")
    private Long guid;
    @Column("bandate")
    private Long bandate;
    @Column("unbandate")
    private Long unbandate;
    @Column("bannedby")
    private String bannedby;
    @Column("banreason")
    private String banreason;
    @Column("active")
    private Integer active;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterBanned> {

        public CharacterBanned convert(Row row) {
            CharacterBanned domain = new CharacterBanned();
            domain.setGuid(row.get("guid", Long.class));
            domain.setBandate(row.get("bandate", Long.class));
            domain.setUnbandate(row.get("unbandate", Long.class));
            domain.setBannedby(row.get("bannedby", String.class));
            domain.setBanreason(row.get("banreason", String.class));
            domain.setActive(row.get("active", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterBanned, OutboundRow> {

        public OutboundRow convert(CharacterBanned source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getBandate()).ifPresent(e -> row.put("bandate", Parameter.from(e)));
            Optional.ofNullable(source.getUnbandate()).ifPresent(e -> row.put("unbandate", Parameter.from(e)));
            Optional.ofNullable(source.getBannedby()).ifPresent(e -> row.put("bannedby", Parameter.from(e)));
            Optional.ofNullable(source.getBanreason()).ifPresent(e -> row.put("banreason", Parameter.from(e)));
            Optional.ofNullable(source.getActive()).ifPresent(e -> row.put("active", Parameter.from(e)));
            return row;
        }
    }

}
