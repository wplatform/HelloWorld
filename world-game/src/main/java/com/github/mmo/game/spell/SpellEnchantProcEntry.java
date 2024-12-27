package com.github.mmo.game.spell;

public class SpellEnchantProcEntry {
    public float chance; // if nonzero - overwrite SpellItemEnchantment value
    public float procsPerMinute; // if nonzero - chance to proc is equal to value * aura caster's weapon speed / 60

    public int hitMask; // if nonzero - bitmask for matching proc condition based on hit result, see enum ProcFlagsHit
    public EnchantProcAttributes attributesMask = EnchantProcAttributes.values()[0]; // bitmask, see EnchantProcAttributes
}
