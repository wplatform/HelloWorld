package com.github.azeroth.game.scripting.interfaces.iunit;


import com.github.azeroth.game.entity.unit.CalcDamageInfo;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IUnitOnMeleeAttack extends IScriptObject {
    void onMeleeAttack(CalcDamageInfo damageInfo, WeaponAttackType attType, boolean extra);
}
