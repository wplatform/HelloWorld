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
@Table("spell_procs_per_minute_mod")
public class SpellProcsPerMinuteMod {

    @Column("ID")
    private Integer id;
    @Column("Type")
    private Integer type;
    @Column("Param")
    private Integer param;
    @Column("Coeff")
    private Double coeff;
    @Column("SpellProcsPerMinuteID")
    private Integer spellProcsPerMinuteId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellProcsPerMinuteMod> {

        public SpellProcsPerMinuteMod convert(Row row) {
            SpellProcsPerMinuteMod domain = new SpellProcsPerMinuteMod();
            domain.setId(row.get("ID", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setParam(row.get("Param", Integer.class));
            domain.setCoeff(row.get("Coeff", Double.class));
            domain.setSpellProcsPerMinuteId(row.get("SpellProcsPerMinuteID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellProcsPerMinuteMod, OutboundRow> {

        public OutboundRow convert(SpellProcsPerMinuteMod source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getParam()).ifPresent(e -> row.put("Param", Parameter.from(e)));
            Optional.ofNullable(source.getCoeff()).ifPresent(e -> row.put("Coeff", Parameter.from(e)));
            Optional.ofNullable(source.getSpellProcsPerMinuteId()).ifPresent(e -> row.put("SpellProcsPerMinuteID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
