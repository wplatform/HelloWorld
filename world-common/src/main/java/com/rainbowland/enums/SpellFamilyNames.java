package com.rainbowland.enums;

enum SpellFamilyNames {
   SPELLFAMILY_GENERIC(0),
   SPELLFAMILY_EVENTS(1),                            // events), holidays
   // 2 - unused
   SPELLFAMILY_MAGE(3),
   SPELLFAMILY_WARRIOR(4),
   SPELLFAMILY_WARLOCK(5),
   SPELLFAMILY_PRIEST(6),
   SPELLFAMILY_DRUID(7),
   SPELLFAMILY_ROGUE(8),
   SPELLFAMILY_HUNTER(9),
   SPELLFAMILY_PALADIN(10),
   SPELLFAMILY_SHAMAN(11),
   SPELLFAMILY_UNK12(12),                           // 2 spells (silence resistance)
   SPELLFAMILY_POTION(13),
   // 14 - unused
   SPELLFAMILY_DEATHKNIGHT(15),
   // 16 - unused
   SPELLFAMILY_PET(17),
   SPELLFAMILY_TOTEMS(50),
   SPELLFAMILY_MONK(53),
   SPELLFAMILY_WARLOCK_PET(57),
   SPELLFAMILY_UNK66(66),
   SPELLFAMILY_UNK71(71),
   SPELLFAMILY_UNK78(78),
   SPELLFAMILY_UNK91(91),
   SPELLFAMILY_UNK100(100),
   SPELLFAMILY_DEMON_HUNTER(107);

   private final int value;

   SpellFamilyNames(int value) {
      this.value = value;
   }

   public int val() {
      return this.value;
   }
}
