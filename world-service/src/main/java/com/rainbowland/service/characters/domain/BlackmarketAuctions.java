package com.rainbowland.service.characters.domain;

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
@Table("blackmarket_auctions")
public class BlackmarketAuctions {

    @Column("marketId")
    private Integer marketId;
    @Column("currentBid")
    private Long currentBid;
    @Column("time")
    private Long time;
    @Column("numBids")
    private Integer numBids;
    @Column("bidder")
    private Long bidder;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BlackmarketAuctions> {

        public BlackmarketAuctions convert(Row row) {
            BlackmarketAuctions domain = new BlackmarketAuctions();
            domain.setMarketId(row.get("marketId", Integer.class));
            domain.setCurrentBid(row.get("currentBid", Long.class));
            domain.setTime(row.get("time", Long.class));
            domain.setNumBids(row.get("numBids", Integer.class));
            domain.setBidder(row.get("bidder", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BlackmarketAuctions, OutboundRow> {

        public OutboundRow convert(BlackmarketAuctions source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMarketId()).ifPresent(e -> row.put("marketId", Parameter.from(e)));
            Optional.ofNullable(source.getCurrentBid()).ifPresent(e -> row.put("currentBid", Parameter.from(e)));
            Optional.ofNullable(source.getTime()).ifPresent(e -> row.put("time", Parameter.from(e)));
            Optional.ofNullable(source.getNumBids()).ifPresent(e -> row.put("numBids", Parameter.from(e)));
            Optional.ofNullable(source.getBidder()).ifPresent(e -> row.put("bidder", Parameter.from(e)));
            return row;
        }
    }

}
