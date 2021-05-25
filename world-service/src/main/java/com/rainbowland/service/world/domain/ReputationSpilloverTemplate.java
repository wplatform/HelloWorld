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
@Table("reputation_spillover_template")
public class ReputationSpilloverTemplate {

    @Column("faction")
    private Integer faction;
    @Column("faction1")
    private Integer faction1;
    @Column("rate_1")
    private Double rate1;
    @Column("rank_1")
    private Integer rank1;
    @Column("faction2")
    private Integer faction2;
    @Column("rate_2")
    private Double rate2;
    @Column("rank_2")
    private Integer rank2;
    @Column("faction3")
    private Integer faction3;
    @Column("rate_3")
    private Double rate3;
    @Column("rank_3")
    private Integer rank3;
    @Column("faction4")
    private Integer faction4;
    @Column("rate_4")
    private Double rate4;
    @Column("rank_4")
    private Integer rank4;
    @Column("faction5")
    private Integer faction5;
    @Column("rate_5")
    private Double rate5;
    @Column("rank_5")
    private Integer rank5;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ReputationSpilloverTemplate> {

        public ReputationSpilloverTemplate convert(Row row) {
            ReputationSpilloverTemplate domain = new ReputationSpilloverTemplate();
            domain.setFaction(row.get("faction", Integer.class));
            domain.setFaction1(row.get("faction1", Integer.class));
            domain.setRate1(row.get("rate_1", Double.class));
            domain.setRank1(row.get("rank_1", Integer.class));
            domain.setFaction2(row.get("faction2", Integer.class));
            domain.setRate2(row.get("rate_2", Double.class));
            domain.setRank2(row.get("rank_2", Integer.class));
            domain.setFaction3(row.get("faction3", Integer.class));
            domain.setRate3(row.get("rate_3", Double.class));
            domain.setRank3(row.get("rank_3", Integer.class));
            domain.setFaction4(row.get("faction4", Integer.class));
            domain.setRate4(row.get("rate_4", Double.class));
            domain.setRank4(row.get("rank_4", Integer.class));
            domain.setFaction5(row.get("faction5", Integer.class));
            domain.setRate5(row.get("rate_5", Double.class));
            domain.setRank5(row.get("rank_5", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ReputationSpilloverTemplate, OutboundRow> {

        public OutboundRow convert(ReputationSpilloverTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("faction", Parameter.from(e)));
            Optional.ofNullable(source.getFaction1()).ifPresent(e -> row.put("faction1", Parameter.from(e)));
            Optional.ofNullable(source.getRate1()).ifPresent(e -> row.put("rate_1", Parameter.from(e)));
            Optional.ofNullable(source.getRank1()).ifPresent(e -> row.put("rank_1", Parameter.from(e)));
            Optional.ofNullable(source.getFaction2()).ifPresent(e -> row.put("faction2", Parameter.from(e)));
            Optional.ofNullable(source.getRate2()).ifPresent(e -> row.put("rate_2", Parameter.from(e)));
            Optional.ofNullable(source.getRank2()).ifPresent(e -> row.put("rank_2", Parameter.from(e)));
            Optional.ofNullable(source.getFaction3()).ifPresent(e -> row.put("faction3", Parameter.from(e)));
            Optional.ofNullable(source.getRate3()).ifPresent(e -> row.put("rate_3", Parameter.from(e)));
            Optional.ofNullable(source.getRank3()).ifPresent(e -> row.put("rank_3", Parameter.from(e)));
            Optional.ofNullable(source.getFaction4()).ifPresent(e -> row.put("faction4", Parameter.from(e)));
            Optional.ofNullable(source.getRate4()).ifPresent(e -> row.put("rate_4", Parameter.from(e)));
            Optional.ofNullable(source.getRank4()).ifPresent(e -> row.put("rank_4", Parameter.from(e)));
            Optional.ofNullable(source.getFaction5()).ifPresent(e -> row.put("faction5", Parameter.from(e)));
            Optional.ofNullable(source.getRate5()).ifPresent(e -> row.put("rate_5", Parameter.from(e)));
            Optional.ofNullable(source.getRank5()).ifPresent(e -> row.put("rank_5", Parameter.from(e)));
            return row;
        }
    }

}
