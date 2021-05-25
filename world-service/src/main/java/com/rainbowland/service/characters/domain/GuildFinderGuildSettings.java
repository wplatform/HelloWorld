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
@Table("guild_finder_guild_settings")
public class GuildFinderGuildSettings {

    @Column("guildId")
    private Long guildId;
    @Column("availability")
    private Integer availability;
    @Column("classRoles")
    private Integer classRoles;
    @Column("interests")
    private Integer interests;
    @Column("level")
    private Integer level;
    @Column("listed")
    private Integer listed;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildFinderGuildSettings> {

        public GuildFinderGuildSettings convert(Row row) {
            GuildFinderGuildSettings domain = new GuildFinderGuildSettings();
            domain.setGuildId(row.get("guildId", Long.class));
            domain.setAvailability(row.get("availability", Integer.class));
            domain.setClassRoles(row.get("classRoles", Integer.class));
            domain.setInterests(row.get("interests", Integer.class));
            domain.setLevel(row.get("level", Integer.class));
            domain.setListed(row.get("listed", Integer.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildFinderGuildSettings, OutboundRow> {

        public OutboundRow convert(GuildFinderGuildSettings source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildId()).ifPresent(e -> row.put("guildId", Parameter.from(e)));
            Optional.ofNullable(source.getAvailability()).ifPresent(e -> row.put("availability", Parameter.from(e)));
            Optional.ofNullable(source.getClassRoles()).ifPresent(e -> row.put("classRoles", Parameter.from(e)));
            Optional.ofNullable(source.getInterests()).ifPresent(e -> row.put("interests", Parameter.from(e)));
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getListed()).ifPresent(e -> row.put("listed", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
