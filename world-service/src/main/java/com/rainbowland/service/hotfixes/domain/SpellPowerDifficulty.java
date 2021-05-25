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
@Table("spell_power_difficulty")
public class SpellPowerDifficulty {

    @Column("ID")
    private Integer id;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellPowerDifficulty> {

        public SpellPowerDifficulty convert(Row row) {
            SpellPowerDifficulty domain = new SpellPowerDifficulty();
            domain.setId(row.get("ID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellPowerDifficulty, OutboundRow> {

        public OutboundRow convert(SpellPowerDifficulty source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
