package com.rainbowland.enums;

public enum GuildLogs {
    GUILD_BANKLOG_MAX_RECORDS(25),
    GUILD_EVENTLOG_MAX_RECORDS(100),
    GUILD_NEWSLOG_MAX_RECORDS(250);
    private final int value;

    GuildLogs(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
