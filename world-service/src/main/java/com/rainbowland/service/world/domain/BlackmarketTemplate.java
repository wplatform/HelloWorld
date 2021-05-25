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
@Table("blackmarket_template")
public class BlackmarketTemplate {

    @Column("marketId")
    private Integer marketId;
    @Column("sellerNpc")
    private Integer sellerNpc;
    @Column("itemEntry")
    private Integer itemEntry;
    @Column("quantity")
    private Integer quantity;
    @Column("minBid")
    private Long minBid;
    @Column("duration")
    private Integer duration;
    @Column("chance")
    private Double chance;
    @Column("bonusListIDs")
    private String bonusListIDs;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BlackmarketTemplate> {

        public BlackmarketTemplate convert(Row row) {
            BlackmarketTemplate domain = new BlackmarketTemplate();
            domain.setMarketId(row.get("marketId", Integer.class));
            domain.setSellerNpc(row.get("sellerNpc", Integer.class));
            domain.setItemEntry(row.get("itemEntry", Integer.class));
            domain.setQuantity(row.get("quantity", Integer.class));
            domain.setMinBid(row.get("minBid", Long.class));
            domain.setDuration(row.get("duration", Integer.class));
            domain.setChance(row.get("chance", Double.class));
            domain.setBonusListIDs(row.get("bonusListIDs", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BlackmarketTemplate, OutboundRow> {

        public OutboundRow convert(BlackmarketTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMarketId()).ifPresent(e -> row.put("marketId", Parameter.from(e)));
            Optional.ofNullable(source.getSellerNpc()).ifPresent(e -> row.put("sellerNpc", Parameter.from(e)));
            Optional.ofNullable(source.getItemEntry()).ifPresent(e -> row.put("itemEntry", Parameter.from(e)));
            Optional.ofNullable(source.getQuantity()).ifPresent(e -> row.put("quantity", Parameter.from(e)));
            Optional.ofNullable(source.getMinBid()).ifPresent(e -> row.put("minBid", Parameter.from(e)));
            Optional.ofNullable(source.getDuration()).ifPresent(e -> row.put("duration", Parameter.from(e)));
            Optional.ofNullable(source.getChance()).ifPresent(e -> row.put("chance", Parameter.from(e)));
            Optional.ofNullable(source.getBonusListIDs()).ifPresent(e -> row.put("bonusListIDs", Parameter.from(e)));
            return row;
        }
    }

}
