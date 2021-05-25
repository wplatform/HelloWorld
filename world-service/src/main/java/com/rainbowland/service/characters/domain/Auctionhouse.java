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
@Table("auctionhouse")
public class Auctionhouse {

    @Column("id")
    private Integer id;
    @Column("auctionHouseId")
    private Integer auctionHouseId;
    @Column("owner")
    private Long owner;
    @Column("bidder")
    private Long bidder;
    @Column("minBid")
    private Long minBid;
    @Column("buyoutOrUnitPrice")
    private Long buyoutOrUnitPrice;
    @Column("deposit")
    private Long deposit;
    @Column("bidAmount")
    private Long bidAmount;
    @Column("startTime")
    private Long startTime;
    @Column("endTime")
    private Long endTime;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Auctionhouse> {

        public Auctionhouse convert(Row row) {
            Auctionhouse domain = new Auctionhouse();
            domain.setId(row.get("id", Integer.class));
            domain.setAuctionHouseId(row.get("auctionHouseId", Integer.class));
            domain.setOwner(row.get("owner", Long.class));
            domain.setBidder(row.get("bidder", Long.class));
            domain.setMinBid(row.get("minBid", Long.class));
            domain.setBuyoutOrUnitPrice(row.get("buyoutOrUnitPrice", Long.class));
            domain.setDeposit(row.get("deposit", Long.class));
            domain.setBidAmount(row.get("bidAmount", Long.class));
            domain.setStartTime(row.get("startTime", Long.class));
            domain.setEndTime(row.get("endTime", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Auctionhouse, OutboundRow> {

        public OutboundRow convert(Auctionhouse source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getAuctionHouseId()).ifPresent(e -> row.put("auctionHouseId", Parameter.from(e)));
            Optional.ofNullable(source.getOwner()).ifPresent(e -> row.put("owner", Parameter.from(e)));
            Optional.ofNullable(source.getBidder()).ifPresent(e -> row.put("bidder", Parameter.from(e)));
            Optional.ofNullable(source.getMinBid()).ifPresent(e -> row.put("minBid", Parameter.from(e)));
            Optional.ofNullable(source.getBuyoutOrUnitPrice()).ifPresent(e -> row.put("buyoutOrUnitPrice", Parameter.from(e)));
            Optional.ofNullable(source.getDeposit()).ifPresent(e -> row.put("deposit", Parameter.from(e)));
            Optional.ofNullable(source.getBidAmount()).ifPresent(e -> row.put("bidAmount", Parameter.from(e)));
            Optional.ofNullable(source.getStartTime()).ifPresent(e -> row.put("startTime", Parameter.from(e)));
            Optional.ofNullable(source.getEndTime()).ifPresent(e -> row.put("endTime", Parameter.from(e)));
            return row;
        }
    }

}
