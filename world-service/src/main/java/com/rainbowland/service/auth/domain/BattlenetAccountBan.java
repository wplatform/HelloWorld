package com.rainbowland.service.auth.domain;

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
@Table("battlenet_account_bans")
public class BattlenetAccountBan {

    @Column("id")
    private Long id;
    @Column("bandate")
    private Long bandate;
    @Column("unbandate")
    private Long unbandate;
    @Column("bannedby")
    private String bannedby;
    @Column("banreason")
    private String banreason;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlenetAccountBan> {

        public BattlenetAccountBan convert(Row row) {
            BattlenetAccountBan domain = new BattlenetAccountBan();
            domain.setId(row.get("id", Long.class));
            domain.setBandate(row.get("bandate", Long.class));
            domain.setUnbandate(row.get("unbandate", Long.class));
            domain.setBannedby(row.get("bannedby", String.class));
            domain.setBanreason(row.get("banreason", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlenetAccountBan, OutboundRow> {

        public OutboundRow convert(BattlenetAccountBan source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getBandate()).ifPresent(e -> row.put("bandate", Parameter.from(e)));
            Optional.ofNullable(source.getUnbandate()).ifPresent(e -> row.put("unbandate", Parameter.from(e)));
            Optional.ofNullable(source.getBannedby()).ifPresent(e -> row.put("bannedby", Parameter.from(e)));
            Optional.ofNullable(source.getBanreason()).ifPresent(e -> row.put("banreason", Parameter.from(e)));
            return row;
        }
    }

}
