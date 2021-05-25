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
@Table("spell_scaling")
public class SpellScaling {

    @Column("ID")
    private Integer id;
    @Column("SpellID")
    private Integer spellId;
    @Column("Class")
    private Integer klass;
    @Column("MinScalingLevel")
    private Integer minScalingLevel;
    @Column("MaxScalingLevel")
    private Integer maxScalingLevel;
    @Column("ScalesFromItemLevel")
    private Integer scalesFromItemLevel;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellScaling> {

        public SpellScaling convert(Row row) {
            SpellScaling domain = new SpellScaling();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setKlass(row.get("Class", Integer.class));
            domain.setMinScalingLevel(row.get("MinScalingLevel", Integer.class));
            domain.setMaxScalingLevel(row.get("MaxScalingLevel", Integer.class));
            domain.setScalesFromItemLevel(row.get("ScalesFromItemLevel", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellScaling, OutboundRow> {

        public OutboundRow convert(SpellScaling source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("Class", Parameter.from(e)));
            Optional.ofNullable(source.getMinScalingLevel()).ifPresent(e -> row.put("MinScalingLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxScalingLevel()).ifPresent(e -> row.put("MaxScalingLevel", Parameter.from(e)));
            Optional.ofNullable(source.getScalesFromItemLevel()).ifPresent(e -> row.put("ScalesFromItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
