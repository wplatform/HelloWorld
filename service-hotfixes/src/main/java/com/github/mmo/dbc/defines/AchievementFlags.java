package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AchievementFlags implements EnumFlag.FlagValue {
    ACHIEVEMENT_FLAG_COUNTER(0x00000001),    // Just count statistic (never stop and complete)
    ACHIEVEMENT_FLAG_HIDDEN(0x00000002),    // Not sent to client - internal use only
    ACHIEVEMENT_FLAG_PLAY_NO_VISUAL(0x00000004),    // Client does not play achievement earned visual
    ACHIEVEMENT_FLAG_SUMM(0x00000008),    // Use summ criteria value from all requirements (and calculate max value)
    ACHIEVEMENT_FLAG_MAX_USED(0x00000010),    // Show max criteria (and calculate max value ??)
    ACHIEVEMENT_FLAG_REQ_COUNT(0x00000020),    // Use not zero req count (and calculate max value)
    ACHIEVEMENT_FLAG_AVERAGE(0x00000040),    // Show as average value (value / time_in_days) depend from other flag (by def use last criteria value)
    ACHIEVEMENT_FLAG_BAR(0x00000080),    // Show as progress bar (value / max vale) depend from other flag (by def use last criteria value)
    ACHIEVEMENT_FLAG_REALM_FIRST_REACH(0x00000100),    //
    ACHIEVEMENT_FLAG_REALM_FIRST_KILL(0x00000200),    //
    ACHIEVEMENT_FLAG_UNK3(0x00000400),    // ACHIEVEMENT_FLAG_HIDE_NAME_IN_TIE
    ACHIEVEMENT_FLAG_HIDE_INCOMPLETE(0x00000800),    // hide from UI if not completed
    ACHIEVEMENT_FLAG_SHOW_IN_GUILD_NEWS(0x00001000),    // Shows in guild news
    ACHIEVEMENT_FLAG_SHOW_IN_GUILD_HEADER(0x00002000),    // Shows in guild news header
    ACHIEVEMENT_FLAG_GUILD(0x00004000),    //
    ACHIEVEMENT_FLAG_SHOW_GUILD_MEMBERS(0x00008000),    //
    ACHIEVEMENT_FLAG_SHOW_CRITERIA_MEMBERS(0x00010000),    //
    ACHIEVEMENT_FLAG_ACCOUNT(0x00020000),
    ACHIEVEMENT_FLAG_UNK5(0x00040000),
    ACHIEVEMENT_FLAG_HIDE_ZERO_COUNTER(0x00080000),    // statistic is hidden from UI if no criteria value exists
    ACHIEVEMENT_FLAG_TRACKING_FLAG(0x00100000);    // hidden tracking flag, sent to client in all cases except completion announcements
    public final int value;
}
