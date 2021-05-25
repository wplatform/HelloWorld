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
@Table("guild_finder_applicant")
public class GuildFinderApplicant {

    @Column("guildId")
    private Long guildId;
    @Column("playerGuid")
    private Long playerGuid;
    @Column("availability")
    private Integer availability;
    @Column("classRole")
    private Integer classRole;
    @Column("interests")
    private Integer interests;
    @Column("comment")
    private String comment;
    @Column("submitTime")
    private Long submitTime;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildFinderApplicant> {

        public GuildFinderApplicant convert(Row row) {
            GuildFinderApplicant domain = new GuildFinderApplicant();
            domain.setGuildId(row.get("guildId", Long.class));
            domain.setPlayerGuid(row.get("playerGuid", Long.class));
            domain.setAvailability(row.get("availability", Integer.class));
            domain.setClassRole(row.get("classRole", Integer.class));
            domain.setInterests(row.get("interests", Integer.class));
            domain.setComment(row.get("comment", String.class));
            domain.setSubmitTime(row.get("submitTime", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildFinderApplicant, OutboundRow> {

        public OutboundRow convert(GuildFinderApplicant source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildId()).ifPresent(e -> row.put("guildId", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerGuid()).ifPresent(e -> row.put("playerGuid", Parameter.from(e)));
            Optional.ofNullable(source.getAvailability()).ifPresent(e -> row.put("availability", Parameter.from(e)));
            Optional.ofNullable(source.getClassRole()).ifPresent(e -> row.put("classRole", Parameter.from(e)));
            Optional.ofNullable(source.getInterests()).ifPresent(e -> row.put("interests", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            Optional.ofNullable(source.getSubmitTime()).ifPresent(e -> row.put("submitTime", Parameter.from(e)));
            return row;
        }
    }

}
