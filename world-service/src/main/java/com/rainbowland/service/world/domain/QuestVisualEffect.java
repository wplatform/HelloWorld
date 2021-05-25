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
@Table("quest_visual_effect")
public class QuestVisualEffect {

    @Column("ID")
    private Integer id;
    @Column("Index")
    private Integer index;
    @Column("VisualEffect")
    private Integer visualEffect;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestVisualEffect> {

        public QuestVisualEffect convert(Row row) {
            QuestVisualEffect domain = new QuestVisualEffect();
            domain.setId(row.get("ID", Integer.class));
            domain.setIndex(row.get("Index", Integer.class));
            domain.setVisualEffect(row.get("VisualEffect", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestVisualEffect, OutboundRow> {

        public OutboundRow convert(QuestVisualEffect source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getIndex()).ifPresent(e -> row.put("Index", Parameter.from(e)));
            Optional.ofNullable(source.getVisualEffect()).ifPresent(e -> row.put("VisualEffect", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
