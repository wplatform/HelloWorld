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
@Table("conversation_template")
public class ConversationTemplate {

    @Column("Id")
    private Integer id;
    @Column("FirstLineId")
    private Integer firstLineId;
    @Column("LastLineEndTime")
    private Integer lastLineEndTime;
    @Column("TextureKitId")
    private Integer textureKitId;
    @Column("ScriptName")
    private String scriptName;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ConversationTemplate> {

        public ConversationTemplate convert(Row row) {
            ConversationTemplate domain = new ConversationTemplate();
            domain.setId(row.get("Id", Integer.class));
            domain.setFirstLineId(row.get("FirstLineId", Integer.class));
            domain.setLastLineEndTime(row.get("LastLineEndTime", Integer.class));
            domain.setTextureKitId(row.get("TextureKitId", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ConversationTemplate, OutboundRow> {

        public OutboundRow convert(ConversationTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("Id", Parameter.from(e)));
            Optional.ofNullable(source.getFirstLineId()).ifPresent(e -> row.put("FirstLineId", Parameter.from(e)));
            Optional.ofNullable(source.getLastLineEndTime()).ifPresent(e -> row.put("LastLineEndTime", Parameter.from(e)));
            Optional.ofNullable(source.getTextureKitId()).ifPresent(e -> row.put("TextureKitId", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
