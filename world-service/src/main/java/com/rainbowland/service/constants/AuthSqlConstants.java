package com.rainbowland.service.constants;

public interface AuthSqlConstants {
    String LOGIN_BATTLE_NET_ACCOUNT_BY_LOGIN_TICKET = """
            SELECT ba.id as ba_acc_id, 
                   LOWER(ba.email) ba_email,
                   ba.locked as ba_locked,
                   ba.lock_country as ba_lock_country,
                   ba.last_ip as ba_last_ip,
                   ba.LoginTicketExpiry as ba_login_ticket_expiry,
                   bab.unbandate > UNIX_TIMESTAMP() OR bab.unbandate = bab.bandate as ba_baned,
                   bab.unbandate = bab.bandate as ba_permanently_banned,
                   a.id as acc_id,
                   a.username acc_username,
                   ab.unbandate > UNIX_TIMESTAMP() OR ab.unbandate = ab.bandate as acc_banded,
                   ab.unbandate = ab.bandate as acc_permanently_banded,
                   aa.SecurityLevel as acc_security_level,
                   rc.numchars as rl_numchars,
                   r.id as rl_id,
                   r.Region as rl_region,
                   r.Battlegroup as rl_battlegroup,
                   lpc.accountId as lpc_account_id,
                   lpc.region as lpc_region,
                   lpc.battlegroup as lpc_battlegroup,
                   lpc.realmId as lpc_realm_id,
                   lpc.characterName as lpc_character_name,
                   lpc.characterGUID as lpc_character_guid,
                   lpc.lastPlayedTime as lpc_last_played_time
            FROM battlenet_accounts ba
            LEFT JOIN battlenet_account_bans bab ON ba.id = bab.id
            LEFT JOIN account a ON ba.id = a.battlenet_account
            LEFT JOIN account_banned ab ON a.id = ab.id AND ab.active = 1
            LEFT JOIN account_access aa ON a.id = aa.AccountID AND aa.RealmID = -1
            LEFT JOIN realmcharacters rc ON a.id = rc.acctid
            LEFT JOIN realmlist r ON rc.realmid = r.id
            LEFT JOIN account_last_played_character lpc on r.id = lpc.realmId
            WHERE ba.LoginTicket = :loginTicket
            ORDER BY a.id
            """;

    String LOGIN_SEL_ACCOUNT_INFO_BY_NAME = """
            SELECT a.id acc_id,
                a.session_key_bnet as acc_session_key_bnet,
                ba.last_ip as ba_last_ip,
                ba.locked as ba_locked,
                ba.lock_country as ba_lock_country,
                a.username as acc_username,
                a.expansion as acc_expansion,
                a.mutetime as acc_mutetime,
                ba.locale as ba_locale,
                a.recruiter as acc_recruiter,
                a.os as acc_os,
                ba.id as ba_id,
                aa.SecurityLevel as acc_security_level,
                bab.unbandate > UNIX_TIMESTAMP() OR bab.unbandate = bab.bandate as ba_baned,
                ab.unbandate > UNIX_TIMESTAMP() OR ab.unbandate = ab.bandate as acc_banded, 
                r.id as r_recruiter
            FROM account a LEFT JOIN account r ON a.id = r.recruiter
            LEFT JOIN battlenet_accounts ba ON a.battlenet_account = ba.id
            LEFT JOIN account_access aa ON a.id = aa.AccountID AND aa.RealmID IN (-1, :realmID)
            LEFT JOIN battlenet_account_bans bab ON ba.id = bab.id
            LEFT JOIN account_banned ab ON a.id = ab.id AND ab.active = 1
            WHERE a.username = :userName AND LENGTH(a.session_key_bnet) = 64 ORDER BY aa.RealmID DESC LIMIT 1
            """;
}
