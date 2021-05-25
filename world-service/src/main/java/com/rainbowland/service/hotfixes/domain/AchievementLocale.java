package com.rainbowland.service.hotfixes.domain;

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
@Table("achievement_locale")
public class AchievementLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("Description_lang")
    private String descriptionLang;
    @Column("Title_lang")
    private String titleLang;
    @Column("Reward_lang")
    private String rewardLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AchievementLocale> {

        public AchievementLocale convert(Row row) {
            AchievementLocale domain = new AchievementLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setDescriptionLang(row.get("Description_lang", String.class));
            domain.setTitleLang(row.get("Title_lang", String.class));
            domain.setRewardLang(row.get("Reward_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AchievementLocale, OutboundRow> {

        public OutboundRow convert(AchievementLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getDescriptionLang()).ifPresent(e -> row.put("Description_lang", Parameter.from(e)));
            Optional.ofNullable(source.getTitleLang()).ifPresent(e -> row.put("Title_lang", Parameter.from(e)));
            Optional.ofNullable(source.getRewardLang()).ifPresent(e -> row.put("Reward_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
