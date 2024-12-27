package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ItemQualities {
    ITEM_QUALITY_POOR(0), ITEM_QUALITY_NORMAL(1), ITEM_QUALITY_UNCOMMON(2), ITEM_QUALITY_RARE(3), ITEM_QUALITY_EPIC(4), ITEM_QUALITY_LEGENDARY(5), ITEM_QUALITY_ARTIFACT(6), ITEM_QUALITY_HEIRLOOM(7), ITEM_QUALITY_WOW_TOKEN(8);

    public final int value;

}
