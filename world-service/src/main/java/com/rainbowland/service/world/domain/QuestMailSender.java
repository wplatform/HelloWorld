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
@Table("quest_mail_sender")
public class QuestMailSender {

    @Column("QuestId")
    private Integer questId;
    @Column("RewardMailSenderEntry")
    private Integer rewardMailSenderEntry;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestMailSender> {

        public QuestMailSender convert(Row row) {
            QuestMailSender domain = new QuestMailSender();
            domain.setQuestId(row.get("QuestId", Integer.class));
            domain.setRewardMailSenderEntry(row.get("RewardMailSenderEntry", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestMailSender, OutboundRow> {

        public OutboundRow convert(QuestMailSender source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getQuestId()).ifPresent(e -> row.put("QuestId", Parameter.from(e)));
            Optional.ofNullable(source.getRewardMailSenderEntry()).ifPresent(e -> row.put("RewardMailSenderEntry", Parameter.from(e)));
            return row;
        }
    }

}
