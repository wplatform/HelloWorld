package com.github.azeroth.game.scripting.interfaces.ivehicle;

import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IVehicleOnInstallAccessory extends IScriptObject {
    void OnInstallAccessory(Vehicle veh, Creature accessory);
}
