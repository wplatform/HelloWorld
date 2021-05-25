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
@Table("num_talents_at_level")
public class NumTalentsAtLevel {

    @Column("ID")
    private Integer id;
    @Column("NumTalents")
    private Integer numTalents;
    @Column("NumTalentsDeathKnight")
    private Integer numTalentsDeathKnight;
    @Column("NumTalentsDemonHunter")
    private Integer numTalentsDemonHunter;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, NumTalentsAtLevel> {

        public NumTalentsAtLevel convert(Row row) {
            NumTalentsAtLevel domain = new NumTalentsAtLevel();
            domain.setId(row.get("ID", Integer.class));
            domain.setNumTalents(row.get("NumTalents", Integer.class));
            domain.setNumTalentsDeathKnight(row.get("NumTalentsDeathKnight", Integer.class));
            domain.setNumTalentsDemonHunter(row.get("NumTalentsDemonHunter", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<NumTalentsAtLevel, OutboundRow> {

        public OutboundRow convert(NumTalentsAtLevel source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getNumTalents()).ifPresent(e -> row.put("NumTalents", Parameter.from(e)));
            Optional.ofNullable(source.getNumTalentsDeathKnight()).ifPresent(e -> row.put("NumTalentsDeathKnight", Parameter.from(e)));
            Optional.ofNullable(source.getNumTalentsDemonHunter()).ifPresent(e -> row.put("NumTalentsDemonHunter", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
