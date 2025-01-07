package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum GuildLogs {
    GUILD_BANKLOG_MAX_RECORDS(25),
    GUILD_EVENTLOG_MAX_RECORDS(100),
    GUILD_NEWSLOG_MAX_RECORDS(250);
    public final int value;
}
