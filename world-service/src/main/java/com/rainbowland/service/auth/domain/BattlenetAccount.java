package com.rainbowland.service.auth.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Table("battlenet_accounts")
public class BattlenetAccount {

    @Id
    @Column("id")
    private Long id;
    @Column("email")
    private String email;
    @Column("mobile_phone")
    private String mobilePhone;
    @Column("sha_pass_hash")
    private String shaPassHash;
    @Column("joindate")
    private java.time.LocalDateTime joindate;
    @Column("last_ip")
    private String lastIp;
    @Column("failed_logins")
    private Integer failedLogins;
    @Column("locked")
    private Integer locked;
    @Column("lock_country")
    private String lockCountry;
    @Column("last_login")
    private java.time.LocalDateTime lastLogin;
    @Column("online")
    private Integer online;
    @Column("locale")
    private Integer locale;
    @Column("os")
    private String os;
    @Column("LastCharacterUndelete")
    private Long lastCharacterUndelete;
    @Column("LoginTicket")
    private String loginTicket;
    @Column("LoginTicketExpiry")
    private Long loginTicketExpiry;

    @Transient
    private Boolean banned;
    @Transient
    private Boolean permanentBanned;
    @Transient
    private List<Account> gameAccounts;

    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlenetAccount> {

        public BattlenetAccount convert(Row row) {
            BattlenetAccount domain = new BattlenetAccount();
            domain.setId(row.get("id", Long.class));
            domain.setEmail(row.get("email", String.class));
            domain.setMobilePhone(row.get("mobile_phone", String.class));
            domain.setShaPassHash(row.get("sha_pass_hash", String.class));
            domain.setJoindate(row.get("joindate", java.time.LocalDateTime.class));
            domain.setLastIp(row.get("last_ip", String.class));
            domain.setFailedLogins(row.get("failed_logins", Integer.class));
            domain.setLocked(row.get("locked", Integer.class));
            domain.setLockCountry(row.get("lock_country", String.class));
            domain.setLastLogin(row.get("last_login", java.time.LocalDateTime.class));
            domain.setOnline(row.get("online", Integer.class));
            domain.setLocale(row.get("locale", Integer.class));
            domain.setOs(row.get("os", String.class));
            domain.setLastCharacterUndelete(row.get("LastCharacterUndelete", Long.class));
            domain.setLoginTicket(row.get("LoginTicket", String.class));
            domain.setLoginTicketExpiry(row.get("LoginTicketExpiry", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlenetAccount, OutboundRow> {

        public OutboundRow convert(BattlenetAccount source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getEmail()).ifPresent(e -> row.put("email", Parameter.from(e)));
            Optional.ofNullable(source.getMobilePhone()).ifPresent(e -> row.put("mobile_phone", Parameter.from(e)));
            Optional.ofNullable(source.getShaPassHash()).ifPresent(e -> row.put("sha_pass_hash", Parameter.from(e)));
            Optional.ofNullable(source.getJoindate()).ifPresent(e -> row.put("joindate", Parameter.from(e)));
            Optional.ofNullable(source.getLastIp()).ifPresent(e -> row.put("last_ip", Parameter.from(e)));
            Optional.ofNullable(source.getFailedLogins()).ifPresent(e -> row.put("failed_logins", Parameter.from(e)));
            Optional.ofNullable(source.getLocked()).ifPresent(e -> row.put("locked", Parameter.from(e)));
            Optional.ofNullable(source.getLockCountry()).ifPresent(e -> row.put("lock_country", Parameter.from(e)));
            Optional.ofNullable(source.getLastLogin()).ifPresent(e -> row.put("last_login", Parameter.from(e)));
            Optional.ofNullable(source.getOnline()).ifPresent(e -> row.put("online", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getOs()).ifPresent(e -> row.put("os", Parameter.from(e)));
            Optional.ofNullable(source.getLastCharacterUndelete()).ifPresent(e -> row.put("LastCharacterUndelete", Parameter.from(e)));
            Optional.ofNullable(source.getLoginTicket()).ifPresent(e -> row.put("LoginTicket", Parameter.from(e)));
            Optional.ofNullable(source.getLoginTicketExpiry()).ifPresent(e -> row.put("LoginTicketExpiry", Parameter.from(e)));
            return row;
        }
    }

}
