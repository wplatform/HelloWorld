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
@Table("achievement_reward_locale")
public class AchievementRewardLocale {

    @Column("ID")
    private Integer id;
    @Column("Locale")
    private String locale;
    @Column("Subject")
    private String subject;
    @Column("Body")
    private String body;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AchievementRewardLocale> {

        public AchievementRewardLocale convert(Row row) {
            AchievementRewardLocale domain = new AchievementRewardLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("Locale", String.class));
            domain.setSubject(row.get("Subject", String.class));
            domain.setBody(row.get("Body", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AchievementRewardLocale, OutboundRow> {

        public OutboundRow convert(AchievementRewardLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("Locale", Parameter.from(e)));
            Optional.ofNullable(source.getSubject()).ifPresent(e -> row.put("Subject", Parameter.from(e)));
            Optional.ofNullable(source.getBody()).ifPresent(e -> row.put("Body", Parameter.from(e)));
            return row;
        }
    }

}
