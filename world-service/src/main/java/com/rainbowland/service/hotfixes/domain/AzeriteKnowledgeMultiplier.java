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
@Table("azerite_knowledge_multiplier")
public class AzeriteKnowledgeMultiplier {

    @Column("ID")
    private Integer id;
    @Column("Multiplier")
    private Double multiplier;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AzeriteKnowledgeMultiplier> {

        public AzeriteKnowledgeMultiplier convert(Row row) {
            AzeriteKnowledgeMultiplier domain = new AzeriteKnowledgeMultiplier();
            domain.setId(row.get("ID", Integer.class));
            domain.setMultiplier(row.get("Multiplier", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AzeriteKnowledgeMultiplier, OutboundRow> {

        public OutboundRow convert(AzeriteKnowledgeMultiplier source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getMultiplier()).ifPresent(e -> row.put("Multiplier", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
