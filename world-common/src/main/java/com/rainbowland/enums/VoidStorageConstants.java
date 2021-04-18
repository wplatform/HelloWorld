package com.rainbowland.enums;

enum VoidStorageConstants {
   VOID_STORAGE_UNLOCK_COST(100 * MoneyConstants.GOLD.val()),
   VOID_STORAGE_STORE_ITEM_COST(10 * MoneyConstants.GOLD.val()),
   VOID_STORAGE_MAX_DEPOSIT(9),
   VOID_STORAGE_MAX_WITHDRAW(9),
   VOID_STORAGE_MAX_SLOT(160);
   private final int value;

   VoidStorageConstants(int value) {
      this.value = value;
   }

   public int val() {
      return this.value;
   }
}
