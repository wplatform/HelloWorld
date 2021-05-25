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
@Table("gameobject_template_addon")
public class GameobjectTemplateAddon {

    @Column("entry")
    private Integer entry;
    @Column("faction")
    private Integer faction;
    @Column("flags")
    private Integer flags;
    @Column("mingold")
    private Integer mingold;
    @Column("maxgold")
    private Integer maxgold;
    @Column("WorldEffectID")
    private Integer worldEffectId;
    @Column("AIAnimKitID")
    private Integer aiAnimKitId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameobjectTemplateAddon> {

        public GameobjectTemplateAddon convert(Row row) {
            GameobjectTemplateAddon domain = new GameobjectTemplateAddon();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setFaction(row.get("faction", Integer.class));
            domain.setFlags(row.get("flags", Integer.class));
            domain.setMingold(row.get("mingold", Integer.class));
            domain.setMaxgold(row.get("maxgold", Integer.class));
            domain.setWorldEffectId(row.get("WorldEffectID", Integer.class));
            domain.setAiAnimKitId(row.get("AIAnimKitID", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameobjectTemplateAddon, OutboundRow> {

        public OutboundRow convert(GameobjectTemplateAddon source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("faction", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            Optional.ofNullable(source.getMingold()).ifPresent(e -> row.put("mingold", Parameter.from(e)));
            Optional.ofNullable(source.getMaxgold()).ifPresent(e -> row.put("maxgold", Parameter.from(e)));
            Optional.ofNullable(source.getWorldEffectId()).ifPresent(e -> row.put("WorldEffectID", Parameter.from(e)));
            Optional.ofNullable(source.getAiAnimKitId()).ifPresent(e -> row.put("AIAnimKitID", Parameter.from(e)));
            return row;
        }
    }

}
