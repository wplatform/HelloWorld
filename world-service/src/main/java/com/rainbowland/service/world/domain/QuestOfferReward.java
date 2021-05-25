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
@Table("quest_offer_reward")
public class QuestOfferReward {

    @Column("ID")
    private Integer id;
    @Column("Emote1")
    private Integer emote1;
    @Column("Emote2")
    private Integer emote2;
    @Column("Emote3")
    private Integer emote3;
    @Column("Emote4")
    private Integer emote4;
    @Column("EmoteDelay1")
    private Integer emoteDelay1;
    @Column("EmoteDelay2")
    private Integer emoteDelay2;
    @Column("EmoteDelay3")
    private Integer emoteDelay3;
    @Column("EmoteDelay4")
    private Integer emoteDelay4;
    @Column("RewardText")
    private String rewardText;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestOfferReward> {

        public QuestOfferReward convert(Row row) {
            QuestOfferReward domain = new QuestOfferReward();
            domain.setId(row.get("ID", Integer.class));
            domain.setEmote1(row.get("Emote1", Integer.class));
            domain.setEmote2(row.get("Emote2", Integer.class));
            domain.setEmote3(row.get("Emote3", Integer.class));
            domain.setEmote4(row.get("Emote4", Integer.class));
            domain.setEmoteDelay1(row.get("EmoteDelay1", Integer.class));
            domain.setEmoteDelay2(row.get("EmoteDelay2", Integer.class));
            domain.setEmoteDelay3(row.get("EmoteDelay3", Integer.class));
            domain.setEmoteDelay4(row.get("EmoteDelay4", Integer.class));
            domain.setRewardText(row.get("RewardText", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestOfferReward, OutboundRow> {

        public OutboundRow convert(QuestOfferReward source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getEmote1()).ifPresent(e -> row.put("Emote1", Parameter.from(e)));
            Optional.ofNullable(source.getEmote2()).ifPresent(e -> row.put("Emote2", Parameter.from(e)));
            Optional.ofNullable(source.getEmote3()).ifPresent(e -> row.put("Emote3", Parameter.from(e)));
            Optional.ofNullable(source.getEmote4()).ifPresent(e -> row.put("Emote4", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteDelay1()).ifPresent(e -> row.put("EmoteDelay1", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteDelay2()).ifPresent(e -> row.put("EmoteDelay2", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteDelay3()).ifPresent(e -> row.put("EmoteDelay3", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteDelay4()).ifPresent(e -> row.put("EmoteDelay4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardText()).ifPresent(e -> row.put("RewardText", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
