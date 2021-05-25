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
@Table("spell_areatrigger_splines")
public class SpellAreatriggerSplines {

    @Column("SpellMiscId")
    private Integer spellMiscId;
    @Column("Idx")
    private Integer idx;
    @Column("X")
    private Double X;
    @Column("Y")
    private Double Y;
    @Column("Z")
    private Double Z;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellAreatriggerSplines> {

        public SpellAreatriggerSplines convert(Row row) {
            SpellAreatriggerSplines domain = new SpellAreatriggerSplines();
            domain.setSpellMiscId(row.get("SpellMiscId", Integer.class));
            domain.setIdx(row.get("Idx", Integer.class));
            domain.setX(row.get("X", Double.class));
            domain.setY(row.get("Y", Double.class));
            domain.setZ(row.get("Z", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellAreatriggerSplines, OutboundRow> {

        public OutboundRow convert(SpellAreatriggerSplines source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellMiscId()).ifPresent(e -> row.put("SpellMiscId", Parameter.from(e)));
            Optional.ofNullable(source.getIdx()).ifPresent(e -> row.put("Idx", Parameter.from(e)));
            Optional.ofNullable(source.getX()).ifPresent(e -> row.put("X", Parameter.from(e)));
            Optional.ofNullable(source.getY()).ifPresent(e -> row.put("Y", Parameter.from(e)));
            Optional.ofNullable(source.getZ()).ifPresent(e -> row.put("Z", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
