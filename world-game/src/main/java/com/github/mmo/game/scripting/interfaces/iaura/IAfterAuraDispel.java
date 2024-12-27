package com.github.mmo.game.scripting.interfaces.iaura;

import com.github.mmo.game.entity.unit.DispelInfo;
import com.github.mmo.game.scripting.interfaces.IAuraScript;

public interface IAfterAuraDispel extends IAuraScript
{
	void HandleDispel(DispelInfo dispelInfo);
}
