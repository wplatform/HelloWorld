package com.rainbowland.enums;

public enum ItemQualities {
    ITEM_QUALITY_POOR(0xff9d9d9d), // GREY
    ITEM_QUALITY_NORMAL(0xffffffff), // WHITE
    ITEM_QUALITY_UNCOMMON(0xff1eff00), // GREEN
    ITEM_QUALITY_RARE(0xff0070dd), // BLUE
    ITEM_QUALITY_EPIC(0xffa335ee), // PURPLE
    ITEM_QUALITY_LEGENDARY(0xffff8000), // ORANGE
    ITEM_QUALITY_ARTIFACT(0xffe6cc80), // LIGHT YELLOW
    ITEM_QUALITY_HEIRLOOM(0xff00ccff), // LIGHT BLUE
    ITEM_QUALITY_WOW_TOKEN(0xff00ccff);              // LIGHT BLUE

    private final int color;

    ItemQualities(int color) {
        this.color = color;
    }

    public int color() {
        return this.color;
    }
}
