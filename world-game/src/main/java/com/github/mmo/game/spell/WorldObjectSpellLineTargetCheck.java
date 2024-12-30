package com.github.mmo.game.spell;


import com.github.mmo.game.condition.Condition;
import com.github.mmo.game.entity.object.WorldObject;

import java.util.ArrayList;


public class WorldObjectSpellLineTargetCheck extends WorldObjectSpellAreaTargetCheck {
    private final Position position;
    private final float lineWidth;

    public WorldObjectSpellLineTargetCheck(Position srcPosition, Position dstPosition, float lineWidth, float range, WorldObject caster, SpellInfo spellInfo, SpellTargetCheckTypes selectionType, ArrayList<Condition> condList, SpellTargetObjectTypes objectType) {
        super(range, caster.getLocation(), caster, caster, spellInfo, selectionType, condList, objectType);
        position = srcPosition;
        lineWidth = lineWidth;

        if (dstPosition != null && srcPosition != dstPosition) {
            position.setO(srcPosition.getAbsoluteAngle(dstPosition));
        }
    }

    @Override
    public boolean invoke(WorldObject target) {
        if (!position.hasInLine(target.getLocation(), target.getCombatReach(), lineWidth)) {
            return false;
        }

        return super.invoke(target);
    }
}
