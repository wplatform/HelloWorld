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
@Table("battleground_template")
public class BattlegroundTemplate {

    @Column("ID")
    private Integer id;
    @Column("AllianceStartLoc")
    private Integer allianceStartLoc;
    @Column("HordeStartLoc")
    private Integer hordeStartLoc;
    @Column("StartMaxDist")
    private Double startMaxDist;
    @Column("Weight")
    private Integer weight;
    @Column("ScriptName")
    private String scriptName;
    @Column("Comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlegroundTemplate> {

        public BattlegroundTemplate convert(Row row) {
            BattlegroundTemplate domain = new BattlegroundTemplate();
            domain.setId(row.get("ID", Integer.class));
            domain.setAllianceStartLoc(row.get("AllianceStartLoc", Integer.class));
            domain.setHordeStartLoc(row.get("HordeStartLoc", Integer.class));
            domain.setStartMaxDist(row.get("StartMaxDist", Double.class));
            domain.setWeight(row.get("Weight", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            domain.setComment(row.get("Comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlegroundTemplate, OutboundRow> {

        public OutboundRow convert(BattlegroundTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceStartLoc()).ifPresent(e -> row.put("AllianceStartLoc", Parameter.from(e)));
            Optional.ofNullable(source.getHordeStartLoc()).ifPresent(e -> row.put("HordeStartLoc", Parameter.from(e)));
            Optional.ofNullable(source.getStartMaxDist()).ifPresent(e -> row.put("StartMaxDist", Parameter.from(e)));
            Optional.ofNullable(source.getWeight()).ifPresent(e -> row.put("Weight", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("Comment", Parameter.from(e)));
            return row;
        }
    }

}
