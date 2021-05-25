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
@Table("guild_achievement_progress")
public class GuildAchievementProgress {

    @Column("guildId")
    private Long guildId;
    @Column("criteria")
    private Integer criteria;
    @Column("counter")
    private Long counter;
    @Column("date")
    private Long date;
    @Column("completedGuid")
    private Long completedGuid;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildAchievementProgress> {

        public GuildAchievementProgress convert(Row row) {
            GuildAchievementProgress domain = new GuildAchievementProgress();
            domain.setGuildId(row.get("guildId", Long.class));
            domain.setCriteria(row.get("criteria", Integer.class));
            domain.setCounter(row.get("counter", Long.class));
            domain.setDate(row.get("date", Long.class));
            domain.setCompletedGuid(row.get("completedGuid", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildAchievementProgress, OutboundRow> {

        public OutboundRow convert(GuildAchievementProgress source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildId()).ifPresent(e -> row.put("guildId", Parameter.from(e)));
            Optional.ofNullable(source.getCriteria()).ifPresent(e -> row.put("criteria", Parameter.from(e)));
            Optional.ofNullable(source.getCounter()).ifPresent(e -> row.put("counter", Parameter.from(e)));
            Optional.ofNullable(source.getDate()).ifPresent(e -> row.put("date", Parameter.from(e)));
            Optional.ofNullable(source.getCompletedGuid()).ifPresent(e -> row.put("completedGuid", Parameter.from(e)));
            return row;
        }
    }

}
