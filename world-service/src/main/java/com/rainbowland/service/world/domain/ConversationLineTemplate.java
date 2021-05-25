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
@Table("conversation_line_template")
public class ConversationLineTemplate {

    @Column("Id")
    private Integer id;
    @Column("StartTime")
    private Integer startTime;
    @Column("UiCameraID")
    private Integer uiCameraId;
    @Column("ActorIdx")
    private Integer actorIdx;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ConversationLineTemplate> {

        public ConversationLineTemplate convert(Row row) {
            ConversationLineTemplate domain = new ConversationLineTemplate();
            domain.setId(row.get("Id", Integer.class));
            domain.setStartTime(row.get("StartTime", Integer.class));
            domain.setUiCameraId(row.get("UiCameraID", Integer.class));
            domain.setActorIdx(row.get("ActorIdx", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ConversationLineTemplate, OutboundRow> {

        public OutboundRow convert(ConversationLineTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("Id", Parameter.from(e)));
            Optional.ofNullable(source.getStartTime()).ifPresent(e -> row.put("StartTime", Parameter.from(e)));
            Optional.ofNullable(source.getUiCameraId()).ifPresent(e -> row.put("UiCameraID", Parameter.from(e)));
            Optional.ofNullable(source.getActorIdx()).ifPresent(e -> row.put("ActorIdx", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
