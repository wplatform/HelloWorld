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
@Table("account_tutorial")
public class AccountTutorial {

    @Column("accountId")
    private Integer accountId;
    @Column("tut0")
    private Integer tut0;
    @Column("tut1")
    private Integer tut1;
    @Column("tut2")
    private Integer tut2;
    @Column("tut3")
    private Integer tut3;
    @Column("tut4")
    private Integer tut4;
    @Column("tut5")
    private Integer tut5;
    @Column("tut6")
    private Integer tut6;
    @Column("tut7")
    private Integer tut7;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AccountTutorial> {

        public AccountTutorial convert(Row row) {
            AccountTutorial domain = new AccountTutorial();
            domain.setAccountId(row.get("accountId", Integer.class));
            domain.setTut0(row.get("tut0", Integer.class));
            domain.setTut1(row.get("tut1", Integer.class));
            domain.setTut2(row.get("tut2", Integer.class));
            domain.setTut3(row.get("tut3", Integer.class));
            domain.setTut4(row.get("tut4", Integer.class));
            domain.setTut5(row.get("tut5", Integer.class));
            domain.setTut6(row.get("tut6", Integer.class));
            domain.setTut7(row.get("tut7", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AccountTutorial, OutboundRow> {

        public OutboundRow convert(AccountTutorial source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAccountId()).ifPresent(e -> row.put("accountId", Parameter.from(e)));
            Optional.ofNullable(source.getTut0()).ifPresent(e -> row.put("tut0", Parameter.from(e)));
            Optional.ofNullable(source.getTut1()).ifPresent(e -> row.put("tut1", Parameter.from(e)));
            Optional.ofNullable(source.getTut2()).ifPresent(e -> row.put("tut2", Parameter.from(e)));
            Optional.ofNullable(source.getTut3()).ifPresent(e -> row.put("tut3", Parameter.from(e)));
            Optional.ofNullable(source.getTut4()).ifPresent(e -> row.put("tut4", Parameter.from(e)));
            Optional.ofNullable(source.getTut5()).ifPresent(e -> row.put("tut5", Parameter.from(e)));
            Optional.ofNullable(source.getTut6()).ifPresent(e -> row.put("tut6", Parameter.from(e)));
            Optional.ofNullable(source.getTut7()).ifPresent(e -> row.put("tut7", Parameter.from(e)));
            return row;
        }
    }

}
