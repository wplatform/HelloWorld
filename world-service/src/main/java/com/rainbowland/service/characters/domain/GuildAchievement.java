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
@Table("guild_achievement")
public class GuildAchievement {

    @Column("guildId")
    private Long guildId;
    @Column("achievement")
    private Integer achievement;
    @Column("date")
    private Long date;
    @Column("guids")
    private String guids;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildAchievement> {

        public GuildAchievement convert(Row row) {
            GuildAchievement domain = new GuildAchievement();
            domain.setGuildId(row.get("guildId", Long.class));
            domain.setAchievement(row.get("achievement", Integer.class));
            domain.setDate(row.get("date", Long.class));
            domain.setGuids(row.get("guids", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildAchievement, OutboundRow> {

        public OutboundRow convert(GuildAchievement source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildId()).ifPresent(e -> row.put("guildId", Parameter.from(e)));
            Optional.ofNullable(source.getAchievement()).ifPresent(e -> row.put("achievement", Parameter.from(e)));
            Optional.ofNullable(source.getDate()).ifPresent(e -> row.put("date", Parameter.from(e)));
            Optional.ofNullable(source.getGuids()).ifPresent(e -> row.put("guids", Parameter.from(e)));
            return row;
        }
    }

}
