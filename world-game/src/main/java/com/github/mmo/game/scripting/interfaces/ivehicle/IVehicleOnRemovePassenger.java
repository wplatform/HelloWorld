package com.github.mmo.game.scripting.interfaces.ivehicle;

import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.*;public interface IVehicleOnRemovePassenger extends IScriptObject {
    void OnRemovePassenger(Vehicle veh, Unit passenger);
}
