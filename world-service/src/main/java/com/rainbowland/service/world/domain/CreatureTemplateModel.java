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
@Table("creature_template_model")
public class CreatureTemplateModel {

    @Column("CreatureID")
    private Integer creatureId;
    @Column("Idx")
    private Integer idx;
    @Column("CreatureDisplayID")
    private Integer creatureDisplayId;
    @Column("DisplayScale")
    private Double displayScale;
    @Column("Probability")
    private Double probability;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureTemplateModel> {

        public CreatureTemplateModel convert(Row row) {
            CreatureTemplateModel domain = new CreatureTemplateModel();
            domain.setCreatureId(row.get("CreatureID", Integer.class));
            domain.setIdx(row.get("Idx", Integer.class));
            domain.setCreatureDisplayId(row.get("CreatureDisplayID", Integer.class));
            domain.setDisplayScale(row.get("DisplayScale", Double.class));
            domain.setProbability(row.get("Probability", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureTemplateModel, OutboundRow> {

        public OutboundRow convert(CreatureTemplateModel source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCreatureId()).ifPresent(e -> row.put("CreatureID", Parameter.from(e)));
            Optional.ofNullable(source.getIdx()).ifPresent(e -> row.put("Idx", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureDisplayId()).ifPresent(e -> row.put("CreatureDisplayID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayScale()).ifPresent(e -> row.put("DisplayScale", Parameter.from(e)));
            Optional.ofNullable(source.getProbability()).ifPresent(e -> row.put("Probability", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
