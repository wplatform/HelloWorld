package com.github.mmo.game.entity.unit.model;

import com.github.mmo.world.entities.object.ObjectGuid;
import com.github.mmo.world.entities.unit.unit;
import com.github.mmo.world.spell.spellInfo;
import lombok.AllArgsConstructor;
import lombok.data;

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
