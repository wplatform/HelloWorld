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
@Table("mail_level_reward")
public class MailLevelReward {

    @Column("level")
    private Integer level;
    @Column("raceMask")
    private Long raceMask;
    @Column("mailTemplateId")
    private Integer mailTemplateId;
    @Column("senderEntry")
    private Integer senderEntry;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, MailLevelReward> {

        public MailLevelReward convert(Row row) {
            MailLevelReward domain = new MailLevelReward();
            domain.setLevel(row.get("level", Integer.class));
            domain.setRaceMask(row.get("raceMask", Long.class));
            domain.setMailTemplateId(row.get("mailTemplateId", Integer.class));
            domain.setSenderEntry(row.get("senderEntry", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<MailLevelReward, OutboundRow> {

        public OutboundRow convert(MailLevelReward source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getRaceMask()).ifPresent(e -> row.put("raceMask", Parameter.from(e)));
            Optional.ofNullable(source.getMailTemplateId()).ifPresent(e -> row.put("mailTemplateId", Parameter.from(e)));
            Optional.ofNullable(source.getSenderEntry()).ifPresent(e -> row.put("senderEntry", Parameter.from(e)));
            return row;
        }
    }

}
