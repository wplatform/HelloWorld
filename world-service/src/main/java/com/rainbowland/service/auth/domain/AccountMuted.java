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
@Table("account_muted")
public class AccountMuted {

    @Column("guid")
    private Long guid;
    @Column("mutedate")
    private Long mutedate;
    @Column("mutetime")
    private Long mutetime;
    @Column("mutedby")
    private String mutedby;
    @Column("mutereason")
    private String mutereason;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AccountMuted> {

        public AccountMuted convert(Row row) {
            AccountMuted domain = new AccountMuted();
            domain.setGuid(row.get("guid", Long.class));
            domain.setMutedate(row.get("mutedate", Long.class));
            domain.setMutetime(row.get("mutetime", Long.class));
            domain.setMutedby(row.get("mutedby", String.class));
            domain.setMutereason(row.get("mutereason", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AccountMuted, OutboundRow> {

        public OutboundRow convert(AccountMuted source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getMutedate()).ifPresent(e -> row.put("mutedate", Parameter.from(e)));
            Optional.ofNullable(source.getMutetime()).ifPresent(e -> row.put("mutetime", Parameter.from(e)));
            Optional.ofNullable(source.getMutedby()).ifPresent(e -> row.put("mutedby", Parameter.from(e)));
            Optional.ofNullable(source.getMutereason()).ifPresent(e -> row.put("mutereason", Parameter.from(e)));
            return row;
        }
    }

}
