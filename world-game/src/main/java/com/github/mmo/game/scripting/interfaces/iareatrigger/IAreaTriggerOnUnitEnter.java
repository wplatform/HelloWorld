package com.github.mmo.game.scripting.interfaces.iareatrigger;

import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.*;

public interface IAreaTriggerOnUnitEnter extends IAreaTriggerScript
{
	void onUnitEnter(Unit unit);
}