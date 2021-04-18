package com.rainbowland.enums;

enum UnitDynFlags {
   UNIT_DYNFLAG_NONE(0x0000),
   UNIT_DYNFLAG_HIDE_MODEL(0x0002), // Object model is not shown with this flag
   UNIT_DYNFLAG_LOOTABLE(0x0004),
   UNIT_DYNFLAG_TRACK_UNIT(0x0008),
   UNIT_DYNFLAG_TAPPED(0x0010), // Lua_UnitIsTapped
   UNIT_DYNFLAG_SPECIALINFO(0x0020),
   UNIT_DYNFLAG_DEAD(0x0040),
   UNIT_DYNFLAG_REFER_A_FRIEND(0x0080);

   private final int value;

   UnitDynFlags(int value) {
      this.value = value;
   }

   public int val() {
      return this.value;
   }
}
