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
@Table("achievement_reward")
public class AchievementReward {

    @Column("ID")
    private Integer id;
    @Column("TitleA")
    private Integer titleA;
    @Column("TitleH")
    private Integer titleH;
    @Column("ItemID")
    private Integer itemId;
    @Column("Sender")
    private Integer sender;
    @Column("Subject")
    private String subject;
    @Column("Body")
    private String body;
    @Column("MailTemplateID")
    private Integer mailTemplateId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AchievementReward> {

        public AchievementReward convert(Row row) {
            AchievementReward domain = new AchievementReward();
            domain.setId(row.get("ID", Integer.class));
            domain.setTitleA(row.get("TitleA", Integer.class));
            domain.setTitleH(row.get("TitleH", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setSender(row.get("Sender", Integer.class));
            domain.setSubject(row.get("Subject", String.class));
            domain.setBody(row.get("Body", String.class));
            domain.setMailTemplateId(row.get("MailTemplateID", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AchievementReward, OutboundRow> {

        public OutboundRow convert(AchievementReward source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getTitleA()).ifPresent(e -> row.put("TitleA", Parameter.from(e)));
            Optional.ofNullable(source.getTitleH()).ifPresent(e -> row.put("TitleH", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getSender()).ifPresent(e -> row.put("Sender", Parameter.from(e)));
            Optional.ofNullable(source.getSubject()).ifPresent(e -> row.put("Subject", Parameter.from(e)));
            Optional.ofNullable(source.getBody()).ifPresent(e -> row.put("Body", Parameter.from(e)));
            Optional.ofNullable(source.getMailTemplateId()).ifPresent(e -> row.put("MailTemplateID", Parameter.from(e)));
            return row;
        }
    }

}
