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
@Table("account_access")
public class AccountAccess {

    @Column("AccountID")
    private Long accountId;
    @Column("SecurityLevel")
    private Integer securityLevel;
    @Column("RealmID")
    private Integer realmId;
    @Column("Comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AccountAccess> {

        public AccountAccess convert(Row row) {
            AccountAccess domain = new AccountAccess();
            domain.setAccountId(row.get("AccountID", Long.class));
            domain.setSecurityLevel(row.get("SecurityLevel", Integer.class));
            domain.setRealmId(row.get("RealmID", Integer.class));
            domain.setComment(row.get("Comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AccountAccess, OutboundRow> {

        public OutboundRow convert(AccountAccess source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAccountId()).ifPresent(e -> row.put("AccountID", Parameter.from(e)));
            Optional.ofNullable(source.getSecurityLevel()).ifPresent(e -> row.put("SecurityLevel", Parameter.from(e)));
            Optional.ofNullable(source.getRealmId()).ifPresent(e -> row.put("RealmID", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("Comment", Parameter.from(e)));
            return row;
        }
    }

}
