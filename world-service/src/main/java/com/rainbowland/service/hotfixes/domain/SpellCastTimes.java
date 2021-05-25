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
@Table("spell_cast_times")
public class SpellCastTimes {

    @Column("ID")
    private Integer id;
    @Column("Base")
    private Integer base;
    @Column("Minimum")
    private Integer minimum;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellCastTimes> {

        public SpellCastTimes convert(Row row) {
            SpellCastTimes domain = new SpellCastTimes();
            domain.setId(row.get("ID", Integer.class));
            domain.setBase(row.get("Base", Integer.class));
            domain.setMinimum(row.get("Minimum", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellCastTimes, OutboundRow> {

        public OutboundRow convert(SpellCastTimes source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getBase()).ifPresent(e -> row.put("Base", Parameter.from(e)));
            Optional.ofNullable(source.getMinimum()).ifPresent(e -> row.put("Minimum", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
