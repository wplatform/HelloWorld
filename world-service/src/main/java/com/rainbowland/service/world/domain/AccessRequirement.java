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
@Table("access_requirement")
public class AccessRequirement {

    @Column("mapId")
    private Integer mapId;
    @Column("difficulty")
    private Integer difficulty;
    @Column("level_min")
    private Integer levelMin;
    @Column("level_max")
    private Integer levelMax;
    @Column("item")
    private Integer item;
    @Column("item2")
    private Integer item2;
    @Column("quest_done_A")
    private Integer questDoneA;
    @Column("quest_done_H")
    private Integer questDoneH;
    @Column("completed_achievement")
    private Integer completedAchievement;
    @Column("quest_failed_text")
    private String questFailedText;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AccessRequirement> {

        public AccessRequirement convert(Row row) {
            AccessRequirement domain = new AccessRequirement();
            domain.setMapId(row.get("mapId", Integer.class));
            domain.setDifficulty(row.get("difficulty", Integer.class));
            domain.setLevelMin(row.get("level_min", Integer.class));
            domain.setLevelMax(row.get("level_max", Integer.class));
            domain.setItem(row.get("item", Integer.class));
            domain.setItem2(row.get("item2", Integer.class));
            domain.setQuestDoneA(row.get("quest_done_A", Integer.class));
            domain.setQuestDoneH(row.get("quest_done_H", Integer.class));
            domain.setCompletedAchievement(row.get("completed_achievement", Integer.class));
            domain.setQuestFailedText(row.get("quest_failed_text", String.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AccessRequirement, OutboundRow> {

        public OutboundRow convert(AccessRequirement source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("mapId", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty()).ifPresent(e -> row.put("difficulty", Parameter.from(e)));
            Optional.ofNullable(source.getLevelMin()).ifPresent(e -> row.put("level_min", Parameter.from(e)));
            Optional.ofNullable(source.getLevelMax()).ifPresent(e -> row.put("level_max", Parameter.from(e)));
            Optional.ofNullable(source.getItem()).ifPresent(e -> row.put("item", Parameter.from(e)));
            Optional.ofNullable(source.getItem2()).ifPresent(e -> row.put("item2", Parameter.from(e)));
            Optional.ofNullable(source.getQuestDoneA()).ifPresent(e -> row.put("quest_done_A", Parameter.from(e)));
            Optional.ofNullable(source.getQuestDoneH()).ifPresent(e -> row.put("quest_done_H", Parameter.from(e)));
            Optional.ofNullable(source.getCompletedAchievement()).ifPresent(e -> row.put("completed_achievement", Parameter.from(e)));
            Optional.ofNullable(source.getQuestFailedText()).ifPresent(e -> row.put("quest_failed_text", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
