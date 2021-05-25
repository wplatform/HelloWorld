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
@Table("quest_template_locale")
public class QuestTemplateLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("LogTitle")
    private String logTitle;
    @Column("LogDescription")
    private String logDescription;
    @Column("QuestDescription")
    private String questDescription;
    @Column("AreaDescription")
    private String areaDescription;
    @Column("PortraitGiverText")
    private String portraitGiverText;
    @Column("PortraitGiverName")
    private String portraitGiverName;
    @Column("PortraitTurnInText")
    private String portraitTurnInText;
    @Column("PortraitTurnInName")
    private String portraitTurnInName;
    @Column("QuestCompletionLog")
    private String questCompletionLog;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestTemplateLocale> {

        public QuestTemplateLocale convert(Row row) {
            QuestTemplateLocale domain = new QuestTemplateLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setLogTitle(row.get("LogTitle", String.class));
            domain.setLogDescription(row.get("LogDescription", String.class));
            domain.setQuestDescription(row.get("QuestDescription", String.class));
            domain.setAreaDescription(row.get("AreaDescription", String.class));
            domain.setPortraitGiverText(row.get("PortraitGiverText", String.class));
            domain.setPortraitGiverName(row.get("PortraitGiverName", String.class));
            domain.setPortraitTurnInText(row.get("PortraitTurnInText", String.class));
            domain.setPortraitTurnInName(row.get("PortraitTurnInName", String.class));
            domain.setQuestCompletionLog(row.get("QuestCompletionLog", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestTemplateLocale, OutboundRow> {

        public OutboundRow convert(QuestTemplateLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getLogTitle()).ifPresent(e -> row.put("LogTitle", Parameter.from(e)));
            Optional.ofNullable(source.getLogDescription()).ifPresent(e -> row.put("LogDescription", Parameter.from(e)));
            Optional.ofNullable(source.getQuestDescription()).ifPresent(e -> row.put("QuestDescription", Parameter.from(e)));
            Optional.ofNullable(source.getAreaDescription()).ifPresent(e -> row.put("AreaDescription", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitGiverText()).ifPresent(e -> row.put("PortraitGiverText", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitGiverName()).ifPresent(e -> row.put("PortraitGiverName", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitTurnInText()).ifPresent(e -> row.put("PortraitTurnInText", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitTurnInName()).ifPresent(e -> row.put("PortraitTurnInName", Parameter.from(e)));
            Optional.ofNullable(source.getQuestCompletionLog()).ifPresent(e -> row.put("QuestCompletionLog", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
