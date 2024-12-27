package com.github.mmo.game.spell.auras.model;

import com.github.mmo.dbc.defines.Difficulty;
import com.github.mmo.world.entities.object.ObjectGuid;
import com.github.mmo.world.entities.object.WorldObject;
import com.github.mmo.world.entities.unit.unit;
import com.github.mmo.world.spell.spellInfo;
import lombok.data;

@Data
public
class AuraCreateInfo {


    ObjectGuid casterGUID;
    Unit caster;
    int baseAmount;
    ObjectGuid CastItemGUID;
    int castItemId = 0;
    int castItemLevel = -1;
    boolean isRefresh;
    boolean resetPeriodicTimer = true;

    ObjectGuid castId;
    SpellInfo spellInfo;
    Difficulty castDifficulty = Difficulty.DIFFICULTY_NONE;
    int _auraEffectMask = 0;
    WorldObject owner;

    int targetEffectMask = 0;
}
