package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ChatLinkColors {
    CHAT_LINK_COLOR_TRADE(0xffffd000),   // orange
    CHAT_LINK_COLOR_TALENT(0xff71d5ff),   // bright blue
    CHAT_LINK_COLOR_SPELL(0xff71d5ff),   // bright blue
    CHAT_LINK_COLOR_ENCHANT(0xffffd000),   // orange
    CHAT_LINK_COLOR_ACHIEVEMENT(0xffffff00),
    CHAT_LINK_COLOR_ARTIFACT_POWER(0xff71d5ff),
    CHAT_LINK_COLOR_BATTLE_PET_ABIL(0xff4e96f7),
    CHAT_LINK_COLOR_GARR_ABILITY(0xff4e96f7),
    CHAT_LINK_COLOR_INSTANCE_LOCK(0xffff8000),
    CHAT_LINK_COLOR_JOURNAL(0xff66bbff),
    CHAT_LINK_COLOR_TRANSMOG(0xffff80ff);
    public final int value;
}
