package com.rainbowland.enums;

public enum ChatFlags {
    CHAT_FLAG_NONE(0x00),
    CHAT_FLAG_AFK(0x01),
    CHAT_FLAG_DND(0x02),
    CHAT_FLAG_GM(0x04),
    CHAT_FLAG_COM(0x08), // Commentator
    CHAT_FLAG_DEV(0x10),
    CHAT_FLAG_BOSS_SOUND(0x20), // Plays "RaidBossEmoteWarning" sound on raid boss emote/whisper
    CHAT_FLAG_MOBILE(0x40);

    private final int value;

    ChatFlags(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
