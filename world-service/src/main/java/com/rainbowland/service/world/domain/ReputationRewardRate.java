package com.rainbowland.service.world.domain;

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
@Table("reputation_reward_rate")
public class ReputationRewardRate {

    @Column("faction")
    private Integer faction;
    @Column("quest_rate")
    private Double questRate;
    @Column("quest_daily_rate")
    private Double questDailyRate;
    @Column("quest_weekly_rate")
    private Double questWeeklyRate;
    @Column("quest_monthly_rate")
    private Double questMonthlyRate;
    @Column("quest_repeatable_rate")
    private Double questRepeatableRate;
    @Column("creature_rate")
    private Double creatureRate;
    @Column("spell_rate")
    private Double spellRate;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ReputationRewardRate> {

        public ReputationRewardRate convert(Row row) {
            ReputationRewardRate domain = new ReputationRewardRate();
            domain.setFaction(row.get("faction", Integer.class));
            domain.setQuestRate(row.get("quest_rate", Double.class));
            domain.setQuestDailyRate(row.get("quest_daily_rate", Double.class));
            domain.setQuestWeeklyRate(row.get("quest_weekly_rate", Double.class));
            domain.setQuestMonthlyRate(row.get("quest_monthly_rate", Double.class));
            domain.setQuestRepeatableRate(row.get("quest_repeatable_rate", Double.class));
            domain.setCreatureRate(row.get("creature_rate", Double.class));
            domain.setSpellRate(row.get("spell_rate", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ReputationRewardRate, OutboundRow> {

        public OutboundRow convert(ReputationRewardRate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("faction", Parameter.from(e)));
            Optional.ofNullable(source.getQuestRate()).ifPresent(e -> row.put("quest_rate", Parameter.from(e)));
            Optional.ofNullable(source.getQuestDailyRate()).ifPresent(e -> row.put("quest_daily_rate", Parameter.from(e)));
            Optional.ofNullable(source.getQuestWeeklyRate()).ifPresent(e -> row.put("quest_weekly_rate", Parameter.from(e)));
            Optional.ofNullable(source.getQuestMonthlyRate()).ifPresent(e -> row.put("quest_monthly_rate", Parameter.from(e)));
            Optional.ofNullable(source.getQuestRepeatableRate()).ifPresent(e -> row.put("quest_repeatable_rate", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureRate()).ifPresent(e -> row.put("creature_rate", Parameter.from(e)));
            Optional.ofNullable(source.getSpellRate()).ifPresent(e -> row.put("spell_rate", Parameter.from(e)));
            return row;
        }
    }

}
