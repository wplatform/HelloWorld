package com.github.mmo.game.spell.auras.model;

import com.github.mmo.world.entities.object.ObjectGuid;
import lombok.data;

// Structure representing database aura primary key fields
@Data
public
class AuraKey {
    ObjectGuid caster;
    ObjectGuid item;
    int spellId;
    int effectMask;
}
