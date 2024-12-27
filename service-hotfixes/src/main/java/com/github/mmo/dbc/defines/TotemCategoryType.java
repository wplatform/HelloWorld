package com.github.mmo.dbc.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TotemCategoryType {
    TOTEM_CATEGORY_TYPE_KNIFE(1),
    TOTEM_CATEGORY_TYPE_TOTEM(2),
    TOTEM_CATEGORY_TYPE_ROD(3),
    TOTEM_CATEGORY_TYPE_PICK(21),
    TOTEM_CATEGORY_TYPE_STONE(22),
    TOTEM_CATEGORY_TYPE_HAMMER(23),
    TOTEM_CATEGORY_TYPE_SPANNER(24);

    public final int value;
}
