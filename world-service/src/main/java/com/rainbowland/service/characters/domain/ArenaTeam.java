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
@Table("arena_team")
public class ArenaTeam {

    @Column("arenaTeamId")
    private Integer arenaTeamId;
    @Column("name")
    private String name;
    @Column("captainGuid")
    private Long captainGuid;
    @Column("type")
    private Integer type;
    @Column("rating")
    private Integer rating;
    @Column("seasonGames")
    private Integer seasonGames;
    @Column("seasonWins")
    private Integer seasonWins;
    @Column("weekGames")
    private Integer weekGames;
    @Column("weekWins")
    private Integer weekWins;
    @Column("rank")
    private Integer rank;
    @Column("backgroundColor")
    private Integer backgroundColor;
    @Column("emblemStyle")
    private Integer emblemStyle;
    @Column("emblemColor")
    private Integer emblemColor;
    @Column("borderStyle")
    private Integer borderStyle;
    @Column("borderColor")
    private Integer borderColor;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArenaTeam> {

        public ArenaTeam convert(Row row) {
            ArenaTeam domain = new ArenaTeam();
            domain.setArenaTeamId(row.get("arenaTeamId", Integer.class));
            domain.setName(row.get("name", String.class));
            domain.setCaptainGuid(row.get("captainGuid", Long.class));
            domain.setType(row.get("type", Integer.class));
            domain.setRating(row.get("rating", Integer.class));
            domain.setSeasonGames(row.get("seasonGames", Integer.class));
            domain.setSeasonWins(row.get("seasonWins", Integer.class));
            domain.setWeekGames(row.get("weekGames", Integer.class));
            domain.setWeekWins(row.get("weekWins", Integer.class));
            domain.setRank(row.get("rank", Integer.class));
            domain.setBackgroundColor(row.get("backgroundColor", Integer.class));
            domain.setEmblemStyle(row.get("emblemStyle", Integer.class));
            domain.setEmblemColor(row.get("emblemColor", Integer.class));
            domain.setBorderStyle(row.get("borderStyle", Integer.class));
            domain.setBorderColor(row.get("borderColor", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArenaTeam, OutboundRow> {

        public OutboundRow convert(ArenaTeam source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getArenaTeamId()).ifPresent(e -> row.put("arenaTeamId", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getCaptainGuid()).ifPresent(e -> row.put("captainGuid", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getRating()).ifPresent(e -> row.put("rating", Parameter.from(e)));
            Optional.ofNullable(source.getSeasonGames()).ifPresent(e -> row.put("seasonGames", Parameter.from(e)));
            Optional.ofNullable(source.getSeasonWins()).ifPresent(e -> row.put("seasonWins", Parameter.from(e)));
            Optional.ofNullable(source.getWeekGames()).ifPresent(e -> row.put("weekGames", Parameter.from(e)));
            Optional.ofNullable(source.getWeekWins()).ifPresent(e -> row.put("weekWins", Parameter.from(e)));
            Optional.ofNullable(source.getRank()).ifPresent(e -> row.put("rank", Parameter.from(e)));
            Optional.ofNullable(source.getBackgroundColor()).ifPresent(e -> row.put("backgroundColor", Parameter.from(e)));
            Optional.ofNullable(source.getEmblemStyle()).ifPresent(e -> row.put("emblemStyle", Parameter.from(e)));
            Optional.ofNullable(source.getEmblemColor()).ifPresent(e -> row.put("emblemColor", Parameter.from(e)));
            Optional.ofNullable(source.getBorderStyle()).ifPresent(e -> row.put("borderStyle", Parameter.from(e)));
            Optional.ofNullable(source.getBorderColor()).ifPresent(e -> row.put("borderColor", Parameter.from(e)));
            return row;
        }
    }

}
