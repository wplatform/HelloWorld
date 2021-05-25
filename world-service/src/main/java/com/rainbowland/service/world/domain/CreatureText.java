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
@Table("creature_text")
public class CreatureText {

    @Column("CreatureID")
    private Integer creatureId;
    @Column("GroupID")
    private Integer groupId;
    @Column("ID")
    private Integer id;
    @Column("Text")
    private String text;
    @Column("Type")
    private Integer type;
    @Column("Language")
    private Integer language;
    @Column("Probability")
    private Double probability;
    @Column("Emote")
    private Integer emote;
    @Column("Duration")
    private Integer duration;
    @Column("Sound")
    private Integer sound;
    @Column("BroadcastTextId")
    private Integer broadcastTextId;
    @Column("TextRange")
    private Integer textRange;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureText> {

        public CreatureText convert(Row row) {
            CreatureText domain = new CreatureText();
            domain.setCreatureId(row.get("CreatureID", Integer.class));
            domain.setGroupId(row.get("GroupID", Integer.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setText(row.get("Text", String.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setLanguage(row.get("Language", Integer.class));
            domain.setProbability(row.get("Probability", Double.class));
            domain.setEmote(row.get("Emote", Integer.class));
            domain.setDuration(row.get("Duration", Integer.class));
            domain.setSound(row.get("Sound", Integer.class));
            domain.setBroadcastTextId(row.get("BroadcastTextId", Integer.class));
            domain.setTextRange(row.get("TextRange", Integer.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureText, OutboundRow> {

        public OutboundRow convert(CreatureText source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCreatureId()).ifPresent(e -> row.put("CreatureID", Parameter.from(e)));
            Optional.ofNullable(source.getGroupId()).ifPresent(e -> row.put("GroupID", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getText()).ifPresent(e -> row.put("Text", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getLanguage()).ifPresent(e -> row.put("Language", Parameter.from(e)));
            Optional.ofNullable(source.getProbability()).ifPresent(e -> row.put("Probability", Parameter.from(e)));
            Optional.ofNullable(source.getEmote()).ifPresent(e -> row.put("Emote", Parameter.from(e)));
            Optional.ofNullable(source.getDuration()).ifPresent(e -> row.put("Duration", Parameter.from(e)));
            Optional.ofNullable(source.getSound()).ifPresent(e -> row.put("Sound", Parameter.from(e)));
            Optional.ofNullable(source.getBroadcastTextId()).ifPresent(e -> row.put("BroadcastTextId", Parameter.from(e)));
            Optional.ofNullable(source.getTextRange()).ifPresent(e -> row.put("TextRange", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
