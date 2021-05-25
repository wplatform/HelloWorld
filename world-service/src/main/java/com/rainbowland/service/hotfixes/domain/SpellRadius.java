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
@Table("spell_radius")
public class SpellRadius {

    @Column("ID")
    private Integer id;
    @Column("Radius")
    private Double radius;
    @Column("RadiusPerLevel")
    private Double radiusPerLevel;
    @Column("RadiusMin")
    private Double radiusMin;
    @Column("RadiusMax")
    private Double radiusMax;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellRadius> {

        public SpellRadius convert(Row row) {
            SpellRadius domain = new SpellRadius();
            domain.setId(row.get("ID", Integer.class));
            domain.setRadius(row.get("Radius", Double.class));
            domain.setRadiusPerLevel(row.get("RadiusPerLevel", Double.class));
            domain.setRadiusMin(row.get("RadiusMin", Double.class));
            domain.setRadiusMax(row.get("RadiusMax", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellRadius, OutboundRow> {

        public OutboundRow convert(SpellRadius source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRadius()).ifPresent(e -> row.put("Radius", Parameter.from(e)));
            Optional.ofNullable(source.getRadiusPerLevel()).ifPresent(e -> row.put("RadiusPerLevel", Parameter.from(e)));
            Optional.ofNullable(source.getRadiusMin()).ifPresent(e -> row.put("RadiusMin", Parameter.from(e)));
            Optional.ofNullable(source.getRadiusMax()).ifPresent(e -> row.put("RadiusMax", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
