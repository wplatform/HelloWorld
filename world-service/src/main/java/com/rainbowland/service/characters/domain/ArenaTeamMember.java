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
@Table("arena_team_member")
public class ArenaTeamMember {

    @Column("arenaTeamId")
    private Integer arenaTeamId;
    @Column("guid")
    private Long guid;
    @Column("weekGames")
    private Integer weekGames;
    @Column("weekWins")
    private Integer weekWins;
    @Column("seasonGames")
    private Integer seasonGames;
    @Column("seasonWins")
    private Integer seasonWins;
    @Column("personalRating")
    private Integer personalRating;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArenaTeamMember> {

        public ArenaTeamMember convert(Row row) {
            ArenaTeamMember domain = new ArenaTeamMember();
            domain.setArenaTeamId(row.get("arenaTeamId", Integer.class));
            domain.setGuid(row.get("guid", Long.class));
            domain.setWeekGames(row.get("weekGames", Integer.class));
            domain.setWeekWins(row.get("weekWins", Integer.class));
            domain.setSeasonGames(row.get("seasonGames", Integer.class));
            domain.setSeasonWins(row.get("seasonWins", Integer.class));
            domain.setPersonalRating(row.get("personalRating", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArenaTeamMember, OutboundRow> {

        public OutboundRow convert(ArenaTeamMember source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getArenaTeamId()).ifPresent(e -> row.put("arenaTeamId", Parameter.from(e)));
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getWeekGames()).ifPresent(e -> row.put("weekGames", Parameter.from(e)));
            Optional.ofNullable(source.getWeekWins()).ifPresent(e -> row.put("weekWins", Parameter.from(e)));
            Optional.ofNullable(source.getSeasonGames()).ifPresent(e -> row.put("seasonGames", Parameter.from(e)));
            Optional.ofNullable(source.getSeasonWins()).ifPresent(e -> row.put("seasonWins", Parameter.from(e)));
            Optional.ofNullable(source.getPersonalRating()).ifPresent(e -> row.put("personalRating", Parameter.from(e)));
            return row;
        }
    }

}
