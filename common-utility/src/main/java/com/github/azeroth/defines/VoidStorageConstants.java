package com.github.azeroth.defines;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum VoidStorageConstants {
    VOID_STORAGE_UNLOCK_COST(100 * MoneyConstants.GOLD.value),
    VOID_STORAGE_STORE_ITEM_COST(10 * MoneyConstants.GOLD.value),
    VOID_STORAGE_MAX_DEPOSIT(9),
    VOID_STORAGE_MAX_WITHDRAW(9),
    VOID_STORAGE_MAX_SLOT(160);

    public final int value;
}
