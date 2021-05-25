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
@Table("spell_range")
public class SpellRange {

    @Column("ID")
    private Integer id;
    @Column("DisplayName")
    private String displayName;
    @Column("DisplayNameShort")
    private String displayNameShort;
    @Column("Flags")
    private Integer flags;
    @Column("RangeMin1")
    private Double rangeMin1;
    @Column("RangeMin2")
    private Double rangeMin2;
    @Column("RangeMax1")
    private Double rangeMax1;
    @Column("RangeMax2")
    private Double rangeMax2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellRange> {

        public SpellRange convert(Row row) {
            SpellRange domain = new SpellRange();
            domain.setId(row.get("ID", Integer.class));
            domain.setDisplayName(row.get("DisplayName", String.class));
            domain.setDisplayNameShort(row.get("DisplayNameShort", String.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setRangeMin1(row.get("RangeMin1", Double.class));
            domain.setRangeMin2(row.get("RangeMin2", Double.class));
            domain.setRangeMax1(row.get("RangeMax1", Double.class));
            domain.setRangeMax2(row.get("RangeMax2", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellRange, OutboundRow> {

        public OutboundRow convert(SpellRange source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayName()).ifPresent(e -> row.put("DisplayName", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayNameShort()).ifPresent(e -> row.put("DisplayNameShort", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getRangeMin1()).ifPresent(e -> row.put("RangeMin1", Parameter.from(e)));
            Optional.ofNullable(source.getRangeMin2()).ifPresent(e -> row.put("RangeMin2", Parameter.from(e)));
            Optional.ofNullable(source.getRangeMax1()).ifPresent(e -> row.put("RangeMax1", Parameter.from(e)));
            Optional.ofNullable(source.getRangeMax2()).ifPresent(e -> row.put("RangeMax2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
