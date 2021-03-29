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

import java.util.Optional;

@Data
@Table("account")
public class Account {

    @Id
    @Column("id")
    private Long id;
    @Column("username")
    private String username;
    @Column("salt")
    private byte[] salt;
    @Column("verifier")
    private byte[] verifier;
    @Column("session_key_auth")
    private byte[] sessionKeyAuth;
    @Column("session_key_bnet")
    private byte[] sessionKeyBnet;
    @Column("sha_pass_hash")
    private String shaPassHash;
    @Column("token_key")
    private String tokenKey;
    @Column("email")
    private String email;
    @Column("reg_mail")
    private String regMail;
    @Column("joindate")
    private java.time.LocalDateTime joindate;
    @Column("last_ip")
    private String lastIp;
    @Column("last_attempt_ip")
    private String lastAttemptIp;
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
    @Column("expansion")
    private Integer expansion;
    @Column("mutetime")
    private Long mutetime;
    @Column("mutereason")
    private String mutereason;
    @Column("muteby")
    private String muteby;
    @Column("locale")
    private Integer locale;
    @Column("os")
    private String os;
    @Column("recruiter")
    private Long recruiter;
    @Column("battlenet_account")
    private Long battlenetAccount;
    @Column("battlenet_index")
    private Integer battlenetIndex;



    @Transient
    private Boolean banned;
    @Transient
    private Boolean permanentBanned;
    @Transient
    private Integer securityLevel;
    @Transient
    private Realmcharacter realmcharacter;
    @Transient
    private Realmlist realmlist;
    @Transient
    private AccountLastPlayedCharacter accountLastPlayedCharacter;
    @Transient
    private BattlenetAccount bnetAcc;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Account> {

        public Account convert(Row row) {
            Account domain = new Account();
            domain.setId(row.get("id", Long.class));
            domain.setUsername(row.get("username", String.class));
            domain.setSalt(row.get("salt", byte[].class));
            domain.setVerifier(row.get("verifier", byte[].class));
            domain.setSessionKeyAuth(row.get("session_key_auth", byte[].class));
            domain.setSessionKeyBnet(row.get("session_key_bnet", byte[].class));
            domain.setShaPassHash(row.get("sha_pass_hash", String.class));
            domain.setTokenKey(row.get("token_key", String.class));
            domain.setEmail(row.get("email", String.class));
            domain.setRegMail(row.get("reg_mail", String.class));
            domain.setJoindate(row.get("joindate", java.time.LocalDateTime.class));
            domain.setLastIp(row.get("last_ip", String.class));
            domain.setLastAttemptIp(row.get("last_attempt_ip", String.class));
            domain.setFailedLogins(row.get("failed_logins", Integer.class));
            domain.setLocked(row.get("locked", Integer.class));
            domain.setLockCountry(row.get("lock_country", String.class));
            domain.setLastLogin(row.get("last_login", java.time.LocalDateTime.class));
            domain.setOnline(row.get("online", Integer.class));
            domain.setExpansion(row.get("expansion", Integer.class));
            domain.setMutetime(row.get("mutetime", Long.class));
            domain.setMutereason(row.get("mutereason", String.class));
            domain.setMuteby(row.get("muteby", String.class));
            domain.setLocale(row.get("locale", Integer.class));
            domain.setOs(row.get("os", String.class));
            domain.setRecruiter(row.get("recruiter", Long.class));
            domain.setBattlenetAccount(row.get("battlenet_account", Long.class));
            domain.setBattlenetIndex(row.get("battlenet_index", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Account, OutboundRow> {

        public OutboundRow convert(Account source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getUsername()).ifPresent(e -> row.put("username", Parameter.from(e)));
            Optional.ofNullable(source.getSalt()).ifPresent(e -> row.put("salt", Parameter.from(e)));
            Optional.ofNullable(source.getVerifier()).ifPresent(e -> row.put("verifier", Parameter.from(e)));
            Optional.ofNullable(source.getSessionKeyAuth()).ifPresent(e -> row.put("session_key_auth", Parameter.from(e)));
            Optional.ofNullable(source.getSessionKeyBnet()).ifPresent(e -> row.put("session_key_bnet", Parameter.from(e)));
            Optional.ofNullable(source.getShaPassHash()).ifPresent(e -> row.put("sha_pass_hash", Parameter.from(e)));
            Optional.ofNullable(source.getTokenKey()).ifPresent(e -> row.put("token_key", Parameter.from(e)));
            Optional.ofNullable(source.getEmail()).ifPresent(e -> row.put("email", Parameter.from(e)));
            Optional.ofNullable(source.getRegMail()).ifPresent(e -> row.put("reg_mail", Parameter.from(e)));
            Optional.ofNullable(source.getJoindate()).ifPresent(e -> row.put("joindate", Parameter.from(e)));
            Optional.ofNullable(source.getLastIp()).ifPresent(e -> row.put("last_ip", Parameter.from(e)));
            Optional.ofNullable(source.getLastAttemptIp()).ifPresent(e -> row.put("last_attempt_ip", Parameter.from(e)));
            Optional.ofNullable(source.getFailedLogins()).ifPresent(e -> row.put("failed_logins", Parameter.from(e)));
            Optional.ofNullable(source.getLocked()).ifPresent(e -> row.put("locked", Parameter.from(e)));
            Optional.ofNullable(source.getLockCountry()).ifPresent(e -> row.put("lock_country", Parameter.from(e)));
            Optional.ofNullable(source.getLastLogin()).ifPresent(e -> row.put("last_login", Parameter.from(e)));
            Optional.ofNullable(source.getOnline()).ifPresent(e -> row.put("online", Parameter.from(e)));
            Optional.ofNullable(source.getExpansion()).ifPresent(e -> row.put("expansion", Parameter.from(e)));
            Optional.ofNullable(source.getMutetime()).ifPresent(e -> row.put("mutetime", Parameter.from(e)));
            Optional.ofNullable(source.getMutereason()).ifPresent(e -> row.put("mutereason", Parameter.from(e)));
            Optional.ofNullable(source.getMuteby()).ifPresent(e -> row.put("muteby", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getOs()).ifPresent(e -> row.put("os", Parameter.from(e)));
            Optional.ofNullable(source.getRecruiter()).ifPresent(e -> row.put("recruiter", Parameter.from(e)));
            Optional.ofNullable(source.getBattlenetAccount()).ifPresent(e -> row.put("battlenet_account", Parameter.from(e)));
            Optional.ofNullable(source.getBattlenetIndex()).ifPresent(e -> row.put("battlenet_index", Parameter.from(e)));
            return row;
        }
    }

}
