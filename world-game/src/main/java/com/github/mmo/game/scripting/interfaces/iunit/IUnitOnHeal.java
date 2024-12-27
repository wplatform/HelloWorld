package com.github.mmo.game.scripting.interfaces.iunit;

import com.github.mmo.game.entity.unit.HealInfo;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IUnitOnHeal extends IScriptObject
{
	void OnHeal(HealInfo healInfo, tangible.RefObject<Integer> gain);
}
