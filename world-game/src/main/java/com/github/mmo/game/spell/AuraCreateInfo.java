package com.github.mmo.game.spell;


import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.unit.Unit;

import java.util.HashMap;
import java.util.HashSet;


public class AuraCreateInfo {
    public ObjectGuid casterGuid = ObjectGuid.EMPTY;
    public Unit caster;
    public HashMap<Integer, Double> baseAmount;
    public ObjectGuid castItemGuid = ObjectGuid.EMPTY;
    public int castItemId = 0;
    public int castItemLevel = -1;
    public boolean isRefresh;
    public boolean resetPeriodicTimer = true;
    public HashSet<Integer> auraEffectMask = new HashSet<Integer>();

    public ObjectGuid castId = ObjectGuid.EMPTY;
    public SpellInfo spellInfoInternal;
    public Difficulty castDifficulty = Difficulty.values()[0];
    public WorldObject ownerInternal;

    public HashSet<Integer> targetEffectMask = new HashSet<Integer>();


    public AuraCreateInfo(ObjectGuid castId, SpellInfo spellInfo, Difficulty castDifficulty, HashSet<Integer> auraEffMask, WorldObject owner) {
        castId = castId;
        spellInfoInternal = spellInfo;
        castDifficulty = castDifficulty;
        auraEffectMask = auraEffMask;
        ownerInternal = owner;
    }

    public final SpellInfo getSpellInfo() {
        return spellInfoInternal;
    }

    public final WorldObject getOwner() {
        return ownerInternal;
    }

    public final void setCasterGuid(ObjectGuid guid) {
        casterGuid = guid;
    }

    public final void setCaster(Unit caster) {
        caster = caster;
    }

    public final void setBaseAmount(HashMap<Integer, Double> bp) {
        baseAmount = bp;
    }

    public final void setCastItem(ObjectGuid guid, int itemId, int itemLevel) {
        castItemGuid = guid;
        castItemId = itemId;
        castItemLevel = itemLevel;
    }

    public final void setPeriodicReset(boolean reset) {
        resetPeriodicTimer = reset;
    }

    public final void setOwnerEffectMask(HashSet<Integer> effMask) {
        targetEffectMask = effMask;
    }
}
