package com.github.mmo.game.misc;


import com.github.mmo.common.LocalizedString;

public class PageTextLocale {
    private LocalizedString text = new LocalizedString();

    public final LocalizedString getText() {
        return text;
    }

    public final void setText(LocalizedString value) {
        text = value;
    }
}
