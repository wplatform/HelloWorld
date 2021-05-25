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
@Table("spell_shapeshift")
public class SpellShapeshift {

    @Column("ID")
    private Integer id;
    @Column("SpellID")
    private Integer spellId;
    @Column("StanceBarOrder")
    private Integer stanceBarOrder;
    @Column("ShapeshiftExclude1")
    private Integer shapeshiftExclude1;
    @Column("ShapeshiftExclude2")
    private Integer shapeshiftExclude2;
    @Column("ShapeshiftMask1")
    private Integer shapeshiftMask1;
    @Column("ShapeshiftMask2")
    private Integer shapeshiftMask2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellShapeshift> {

        public SpellShapeshift convert(Row row) {
            SpellShapeshift domain = new SpellShapeshift();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setStanceBarOrder(row.get("StanceBarOrder", Integer.class));
            domain.setShapeshiftExclude1(row.get("ShapeshiftExclude1", Integer.class));
            domain.setShapeshiftExclude2(row.get("ShapeshiftExclude2", Integer.class));
            domain.setShapeshiftMask1(row.get("ShapeshiftMask1", Integer.class));
            domain.setShapeshiftMask2(row.get("ShapeshiftMask2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellShapeshift, OutboundRow> {

        public OutboundRow convert(SpellShapeshift source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getStanceBarOrder()).ifPresent(e -> row.put("StanceBarOrder", Parameter.from(e)));
            Optional.ofNullable(source.getShapeshiftExclude1()).ifPresent(e -> row.put("ShapeshiftExclude1", Parameter.from(e)));
            Optional.ofNullable(source.getShapeshiftExclude2()).ifPresent(e -> row.put("ShapeshiftExclude2", Parameter.from(e)));
            Optional.ofNullable(source.getShapeshiftMask1()).ifPresent(e -> row.put("ShapeshiftMask1", Parameter.from(e)));
            Optional.ofNullable(source.getShapeshiftMask2()).ifPresent(e -> row.put("ShapeshiftMask2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
