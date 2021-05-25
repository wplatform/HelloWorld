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
@Table("conversation_actors")
public class ConversationActors {

    @Column("ConversationId")
    private Integer conversationId;
    @Column("ConversationActorId")
    private Integer conversationActorId;
    @Column("ConversationActorGuid")
    private Long conversationActorGuid;
    @Column("Idx")
    private Integer idx;
    @Column("CreatureId")
    private Integer creatureId;
    @Column("CreatureDisplayInfoId")
    private Integer creatureDisplayInfoId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ConversationActors> {

        public ConversationActors convert(Row row) {
            ConversationActors domain = new ConversationActors();
            domain.setConversationId(row.get("ConversationId", Integer.class));
            domain.setConversationActorId(row.get("ConversationActorId", Integer.class));
            domain.setConversationActorGuid(row.get("ConversationActorGuid", Long.class));
            domain.setIdx(row.get("Idx", Integer.class));
            domain.setCreatureId(row.get("CreatureId", Integer.class));
            domain.setCreatureDisplayInfoId(row.get("CreatureDisplayInfoId", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ConversationActors, OutboundRow> {

        public OutboundRow convert(ConversationActors source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getConversationId()).ifPresent(e -> row.put("ConversationId", Parameter.from(e)));
            Optional.ofNullable(source.getConversationActorId()).ifPresent(e -> row.put("ConversationActorId", Parameter.from(e)));
            Optional.ofNullable(source.getConversationActorGuid()).ifPresent(e -> row.put("ConversationActorGuid", Parameter.from(e)));
            Optional.ofNullable(source.getIdx()).ifPresent(e -> row.put("Idx", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureId()).ifPresent(e -> row.put("CreatureId", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureDisplayInfoId()).ifPresent(e -> row.put("CreatureDisplayInfoId", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
