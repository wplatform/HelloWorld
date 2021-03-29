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
@Table("account_last_played_character")
public class AccountLastPlayedCharacter {

    @Column("accountId")
    private Long accountId;
    @Column("region")
    private Integer region;
    @Column("battlegroup")
    private Integer battlegroup;
    @Column("realmId")
    private Integer realmId;
    @Column("characterName")
    private String characterName;
    @Column("characterGUID")
    private Long characterGuid;
    @Column("lastPlayedTime")
    private Long lastPlayedTime;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AccountLastPlayedCharacter> {

        public AccountLastPlayedCharacter convert(Row row) {
            AccountLastPlayedCharacter domain = new AccountLastPlayedCharacter();
            domain.setAccountId(row.get("accountId", Long.class));
            domain.setRegion(row.get("region", Integer.class));
            domain.setBattlegroup(row.get("battlegroup", Integer.class));
            domain.setRealmId(row.get("realmId", Integer.class));
            domain.setCharacterName(row.get("characterName", String.class));
            domain.setCharacterGuid(row.get("characterGUID", Long.class));
            domain.setLastPlayedTime(row.get("lastPlayedTime", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AccountLastPlayedCharacter, OutboundRow> {

        public OutboundRow convert(AccountLastPlayedCharacter source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAccountId()).ifPresent(e -> row.put("accountId", Parameter.from(e)));
            Optional.ofNullable(source.getRegion()).ifPresent(e -> row.put("region", Parameter.from(e)));
            Optional.ofNullable(source.getBattlegroup()).ifPresent(e -> row.put("battlegroup", Parameter.from(e)));
            Optional.ofNullable(source.getRealmId()).ifPresent(e -> row.put("realmId", Parameter.from(e)));
            Optional.ofNullable(source.getCharacterName()).ifPresent(e -> row.put("characterName", Parameter.from(e)));
            Optional.ofNullable(source.getCharacterGuid()).ifPresent(e -> row.put("characterGUID", Parameter.from(e)));
            Optional.ofNullable(source.getLastPlayedTime()).ifPresent(e -> row.put("lastPlayedTime", Parameter.from(e)));
            return row;
        }
    }

}
