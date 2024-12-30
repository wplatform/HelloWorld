package com.github.mmo.game.map;


import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.spell.SpellInfo;
import com.github.mmo.game.spell.WorldObjectSpellTargetCheck;

public class AnyDeadUnitSpellTargetInRangeCheck<T extends WorldObject> extends AnyDeadUnitObjectInRangeCheck<T> {
    private final WorldObjectSpellTargetCheck check;

    public AnyDeadUnitSpellTargetInRangeCheck(WorldObject searchObj, float range, SpellInfo spellInfo, SpellTargetCheckTypes check, SpellTargetObjectTypes objectType) {
        super(searchObj, range);
        check = new WorldObjectSpellTargetCheck(searchObj, searchObj, spellInfo, check, null, objectType);
    }

    @Override
    public boolean invoke(T obj) {
        return super.invoke(obj) && check.invoke(obj);
    }
}
