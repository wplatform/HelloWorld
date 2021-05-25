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
@Table("pvpstats_players")
public class PvpstatsPlayers {

    @Column("battleground_id")
    private Long battlegroundId;
    @Column("character_guid")
    private Long characterGuid;
    @Column("winner")
    private String winner;
    @Column("score_killing_blows")
    private Integer scoreKillingBlows;
    @Column("score_deaths")
    private Integer scoreDeaths;
    @Column("score_honorable_kills")
    private Integer scoreHonorableKills;
    @Column("score_bonus_honor")
    private Integer scoreBonusHonor;
    @Column("score_damage_done")
    private Integer scoreDamageDone;
    @Column("score_healing_done")
    private Integer scoreHealingDone;
    @Column("attr_1")
    private Integer attr1;
    @Column("attr_2")
    private Integer attr2;
    @Column("attr_3")
    private Integer attr3;
    @Column("attr_4")
    private Integer attr4;
    @Column("attr_5")
    private Integer attr5;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PvpstatsPlayers> {

        public PvpstatsPlayers convert(Row row) {
            PvpstatsPlayers domain = new PvpstatsPlayers();
            domain.setBattlegroundId(row.get("battleground_id", Long.class));
            domain.setCharacterGuid(row.get("character_guid", Long.class));
            domain.setWinner(row.get("winner", String.class));
            domain.setScoreKillingBlows(row.get("score_killing_blows", Integer.class));
            domain.setScoreDeaths(row.get("score_deaths", Integer.class));
            domain.setScoreHonorableKills(row.get("score_honorable_kills", Integer.class));
            domain.setScoreBonusHonor(row.get("score_bonus_honor", Integer.class));
            domain.setScoreDamageDone(row.get("score_damage_done", Integer.class));
            domain.setScoreHealingDone(row.get("score_healing_done", Integer.class));
            domain.setAttr1(row.get("attr_1", Integer.class));
            domain.setAttr2(row.get("attr_2", Integer.class));
            domain.setAttr3(row.get("attr_3", Integer.class));
            domain.setAttr4(row.get("attr_4", Integer.class));
            domain.setAttr5(row.get("attr_5", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PvpstatsPlayers, OutboundRow> {

        public OutboundRow convert(PvpstatsPlayers source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getBattlegroundId()).ifPresent(e -> row.put("battleground_id", Parameter.from(e)));
            Optional.ofNullable(source.getCharacterGuid()).ifPresent(e -> row.put("character_guid", Parameter.from(e)));
            Optional.ofNullable(source.getWinner()).ifPresent(e -> row.put("winner", Parameter.from(e)));
            Optional.ofNullable(source.getScoreKillingBlows()).ifPresent(e -> row.put("score_killing_blows", Parameter.from(e)));
            Optional.ofNullable(source.getScoreDeaths()).ifPresent(e -> row.put("score_deaths", Parameter.from(e)));
            Optional.ofNullable(source.getScoreHonorableKills()).ifPresent(e -> row.put("score_honorable_kills", Parameter.from(e)));
            Optional.ofNullable(source.getScoreBonusHonor()).ifPresent(e -> row.put("score_bonus_honor", Parameter.from(e)));
            Optional.ofNullable(source.getScoreDamageDone()).ifPresent(e -> row.put("score_damage_done", Parameter.from(e)));
            Optional.ofNullable(source.getScoreHealingDone()).ifPresent(e -> row.put("score_healing_done", Parameter.from(e)));
            Optional.ofNullable(source.getAttr1()).ifPresent(e -> row.put("attr_1", Parameter.from(e)));
            Optional.ofNullable(source.getAttr2()).ifPresent(e -> row.put("attr_2", Parameter.from(e)));
            Optional.ofNullable(source.getAttr3()).ifPresent(e -> row.put("attr_3", Parameter.from(e)));
            Optional.ofNullable(source.getAttr4()).ifPresent(e -> row.put("attr_4", Parameter.from(e)));
            Optional.ofNullable(source.getAttr5()).ifPresent(e -> row.put("attr_5", Parameter.from(e)));
            return row;
        }
    }

}
