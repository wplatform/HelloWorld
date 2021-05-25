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
@Table("spell_duration")
public class SpellDuration {

    @Column("ID")
    private Integer id;
    @Column("Duration")
    private Integer duration;
    @Column("MaxDuration")
    private Integer maxDuration;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellDuration> {

        public SpellDuration convert(Row row) {
            SpellDuration domain = new SpellDuration();
            domain.setId(row.get("ID", Integer.class));
            domain.setDuration(row.get("Duration", Integer.class));
            domain.setMaxDuration(row.get("MaxDuration", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellDuration, OutboundRow> {

        public OutboundRow convert(SpellDuration source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDuration()).ifPresent(e -> row.put("Duration", Parameter.from(e)));
            Optional.ofNullable(source.getMaxDuration()).ifPresent(e -> row.put("MaxDuration", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
