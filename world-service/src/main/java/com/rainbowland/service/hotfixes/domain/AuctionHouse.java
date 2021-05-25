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
@Table("auction_house")
public class AuctionHouse {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("FactionID")
    private Integer factionId;
    @Column("DepositRate")
    private Integer depositRate;
    @Column("ConsignmentRate")
    private Integer consignmentRate;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AuctionHouse> {

        public AuctionHouse convert(Row row) {
            AuctionHouse domain = new AuctionHouse();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setFactionId(row.get("FactionID", Integer.class));
            domain.setDepositRate(row.get("DepositRate", Integer.class));
            domain.setConsignmentRate(row.get("ConsignmentRate", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AuctionHouse, OutboundRow> {

        public OutboundRow convert(AuctionHouse source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getFactionId()).ifPresent(e -> row.put("FactionID", Parameter.from(e)));
            Optional.ofNullable(source.getDepositRate()).ifPresent(e -> row.put("DepositRate", Parameter.from(e)));
            Optional.ofNullable(source.getConsignmentRate()).ifPresent(e -> row.put("ConsignmentRate", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
