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
@Table("guild_rewards_req_achievements")
public class GuildRewardsReqAchievements {

    @Column("ItemID")
    private Integer itemId;
    @Column("AchievementRequired")
    private Integer achievementRequired;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildRewardsReqAchievements> {

        public GuildRewardsReqAchievements convert(Row row) {
            GuildRewardsReqAchievements domain = new GuildRewardsReqAchievements();
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setAchievementRequired(row.get("AchievementRequired", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildRewardsReqAchievements, OutboundRow> {

        public OutboundRow convert(GuildRewardsReqAchievements source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getAchievementRequired()).ifPresent(e -> row.put("AchievementRequired", Parameter.from(e)));
            return row;
        }
    }

}
