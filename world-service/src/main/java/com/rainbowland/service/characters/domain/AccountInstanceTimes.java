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
@Table("account_instance_times")
public class AccountInstanceTimes {

    @Column("accountId")
    private Integer accountId;
    @Column("instanceId")
    private Integer instanceId;
    @Column("releaseTime")
    private Long releaseTime;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AccountInstanceTimes> {

        public AccountInstanceTimes convert(Row row) {
            AccountInstanceTimes domain = new AccountInstanceTimes();
            domain.setAccountId(row.get("accountId", Integer.class));
            domain.setInstanceId(row.get("instanceId", Integer.class));
            domain.setReleaseTime(row.get("releaseTime", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AccountInstanceTimes, OutboundRow> {

        public OutboundRow convert(AccountInstanceTimes source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAccountId()).ifPresent(e -> row.put("accountId", Parameter.from(e)));
            Optional.ofNullable(source.getInstanceId()).ifPresent(e -> row.put("instanceId", Parameter.from(e)));
            Optional.ofNullable(source.getReleaseTime()).ifPresent(e -> row.put("releaseTime", Parameter.from(e)));
            return row;
        }
    }

}
