package com.rainbowland.enums;

public enum ChatLinkColors {
    CHAT_LINK_COLOR_TRADE(0xffffd000),   // orange
    CHAT_LINK_COLOR_TALENT(0xff4e96f7),   // blue
    CHAT_LINK_COLOR_SPELL(0xff71d5ff),   // bright blue
    CHAT_LINK_COLOR_ENCHANT(0xffffd000),   // orange
    CHAT_LINK_COLOR_ACHIEVEMENT(0xffffff00),
    CHAT_LINK_COLOR_GLYPH(0xff66bbff);
    private final int value;

    ChatLinkColors(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
