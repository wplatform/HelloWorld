package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ChatMsg {
    ADDON(-1),
    SYSTEM(0x00),
    SAY(0x01),
    PARTY(0x02),
    RAID(0x03),
    GUILD(0x04),
    OFFICER(0x05),
    YELL(0x06),
    WHISPER(0x07),
    WHISPER_FOREIGN(0x08),
    WHISPER_INFORM(0x09),
    EMOTE(0x0A),
    TEXT_EMOTE(0x0B),
    MONSTER_SAY(0x0C),
    MONSTER_PARTY(0x0D),
    MONSTER_YELL(0x0E),
    MONSTER_WHISPER(0x0F),
    MONSTER_EMOTE(0x10),
    CHANNEL(0x11),
    CHANNEL_JOIN(0x12),
    CHANNEL_LEAVE(0x13),
    CHANNEL_LIST(0x14),
    CHANNEL_NOTICE(0x15),
    CHANNEL_NOTICE_USER(0x16),
    AFK(0x17),
    DND(0x18),
    IGNORED(0x19),
    SKILL(0x1A),
    LOOT(0x1B),
    MONEY(0x1C),
    OPENING(0x1D),
    TRADESKILLS(0x1E),
    PET_INFO(0x1F),
    COMBAT_MISC_INFO(0x20),
    COMBAT_XP_GAIN(0x21),
    COMBAT_HONOR_GAIN(0x22),
    COMBAT_FACTION_CHANGE(0x23),
    BG_SYSTEM_NEUTRAL(0x24),
    BG_SYSTEM_ALLIANCE(0x25),
    BG_SYSTEM_HORDE(0x26),
    RAID_LEADER(0x27),
    RAID_WARNING(0x28),
    RAID_BOSS_EMOTE(0x29),
    RAID_BOSS_WHISPER(0x2A),
    FILTERED(0x2B),
    RESTRICTED(0x2C),
    BATTLENET(0x2D),
    ACHIEVEMENT(0x2E),
    GUILD_ACHIEVEMENT(0x2F),
    ARENA_POINTS(0x30),
    PARTY_LEADER(0x31),
    TARGETICONS(0x32),
    BN_WHISPER(0x33),
    BN_WHISPER_INFORM(0x34),
    BN_CONVERSATION(0x35),
    BN_CONVERSATION_NOTICE(0x36),
    BN_CONVERSATION_LIST(0x37),
    BN_INLINE_TOAST_ALERT(0x38),
    BN_INLINE_TOAST_BROADCAST(0x39),
    BN_INLINE_TOAST_BROADCAST_INFORM(0x3A),
    BN_INLINE_TOAST_CONVERSATION(0x3B),
    BN_WHISPER_PLAYER_OFFLINE(0x3C),
    COMBAT_GUILD_XP_GAIN(0x3D),
    CURRENCY(0x3E),
    QUEST_BOSS_EMOTE(0x3F),
    PET_BATTLE_COMBAT_LOG(0x40),
    PET_BATTLE_INFO(0x41),
    INSTANCE_CHAT(0x42),
    INSTANCE_CHAT_LEADER(0x43);

    public final int value;


    public static ChatMsg valueOf(int value) {
        return switch (value) {
            case -1 -> ADDON;
            case 0x00 -> SYSTEM;
            case 0x01 -> SAY;
            case 0x02 -> PARTY;
            case 0x03 -> RAID;
            case 0x04 -> GUILD;
            case 0x05 -> OFFICER;
            case 0x06 -> YELL;
            case 0x07 -> WHISPER;
            case 0x08 -> WHISPER_FOREIGN;
            case 0x09 -> WHISPER_INFORM;
            case 0x0A -> EMOTE;
            case 0x0B -> TEXT_EMOTE;
            case 0x0C -> MONSTER_SAY;
            case 0x0D -> MONSTER_PARTY;
            case 0x0E -> MONSTER_YELL;
            case 0x0F -> MONSTER_WHISPER;
            case 0x10 -> MONSTER_EMOTE;
            case 0x11 -> CHANNEL;
            case 0x12 -> CHANNEL_JOIN;
            case 0x13 -> CHANNEL_LEAVE;
            case 0x14 -> CHANNEL_LIST;
            case 0x15 -> CHANNEL_NOTICE;
            case 0x16 -> CHANNEL_NOTICE_USER;
            case 0x17 -> AFK;
            case 0x18 -> DND;
            case 0x19 -> IGNORED;
            case 0x1A -> SKILL;
            case 0x1B -> LOOT;
            case 0x1C -> MONEY;
            case 0x1D -> OPENING;
            case 0x1E -> TRADESKILLS;
            case 0x1F -> PET_INFO;
            case 0x20 -> COMBAT_MISC_INFO;
            case 0x21 -> COMBAT_XP_GAIN;
            case 0x22 -> COMBAT_HONOR_GAIN;
            case 0x23 -> COMBAT_FACTION_CHANGE;
            case 0x24 -> BG_SYSTEM_NEUTRAL;
            case 0x25 -> BG_SYSTEM_ALLIANCE;
            case 0x26 -> BG_SYSTEM_HORDE;
            case 0x27 -> RAID_LEADER;
            case 0x28 -> RAID_WARNING;
            case 0x29 -> RAID_BOSS_EMOTE;
            case 0x2A -> RAID_BOSS_WHISPER;
            case 0x2B -> FILTERED;
            case 0x2C -> RESTRICTED;
            case 0x2D -> BATTLENET;
            case 0x2E -> ACHIEVEMENT;
            case 0x2F -> GUILD_ACHIEVEMENT;
            case 0x30 -> ARENA_POINTS;
            case 0x31 -> PARTY_LEADER;
            case 0x32 -> TARGETICONS;
            case 0x33 -> BN_WHISPER;
            case 0x34 -> BN_WHISPER_INFORM;
            case 0x35 -> BN_CONVERSATION;
            case 0x36 -> BN_CONVERSATION_NOTICE;
            case 0x37 -> BN_CONVERSATION_LIST;
            case 0x38 -> BN_INLINE_TOAST_ALERT;
            case 0x39 -> BN_INLINE_TOAST_BROADCAST;
            case 0x3A -> BN_INLINE_TOAST_BROADCAST_INFORM;
            case 0x3B -> BN_INLINE_TOAST_CONVERSATION;
            case 0x3C -> BN_WHISPER_PLAYER_OFFLINE;
            case 0x3D -> COMBAT_GUILD_XP_GAIN;
            case 0x3E -> CURRENCY;
            case 0x3F -> QUEST_BOSS_EMOTE;
            case 0x40 -> PET_BATTLE_COMBAT_LOG;
            case 0x41 -> PET_BATTLE_INFO;
            case 0x42 -> INSTANCE_CHAT;
            case 0x43 -> INSTANCE_CHAT_LEADER;
            default -> throw new NoSuchElementException("Unexpected value: " + value);
        };
    }
}
