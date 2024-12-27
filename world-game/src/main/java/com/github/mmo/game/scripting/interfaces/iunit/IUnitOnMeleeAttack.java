package com.github.mmo.game.scripting.interfaces.iunit;


import com.github.mmo.game.entity.unit.CalcDamageInfo;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IUnitOnMeleeAttack extends IScriptObject
{
	void onMeleeAttack(CalcDamageInfo damageInfo, WeaponAttackType attType, boolean extra);
}
