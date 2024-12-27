package com.github.mmo.game.scripting.interfaces.ivehicle;

import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.scripting.interfaces.*;

public interface IVehicleOnInstallAccessory extends IScriptObject
{
	void OnInstallAccessory(Vehicle veh, Creature accessory);
}
