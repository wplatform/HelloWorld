package com.github.azeroth.game.domain.unit;

import com.github.azeroth.world.entities.object.ObjectGuid;
import lombok.AllArgsConstructor;

// Spell damage info structure based on structure sending in SMSG_SPELLNONMELEEDAMAGELOG opcode
@Data
@AllArgsConstructor
public
class SpellNonMeleeDamage {

    Unit target;
    Unit attacker;
    ObjectGuid castId;
    SpellInfo spell;
    int spellXSpellVisualID;
    int damage;
    int schoolMask;
    int absorb;
    int resist;
    boolean periodicLog;
    int blocked;
    int hitInfo;
    // Used for help
    int cleanDamage;
    boolean fullBlock;
    int preHitHealth;
}
