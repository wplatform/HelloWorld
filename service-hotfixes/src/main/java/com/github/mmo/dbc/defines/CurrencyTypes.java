package com.github.mmo.dbc.defines;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// CurrencyTypes.dbc
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CurrencyTypes {
    CURRENCY_TYPE_JUSTICE_POINTS(395),
    CURRENCY_TYPE_VALOR_POINTS(396),
    CURRENCY_TYPE_APEXIS_CRYSTALS(823);

    public final int value;
}
