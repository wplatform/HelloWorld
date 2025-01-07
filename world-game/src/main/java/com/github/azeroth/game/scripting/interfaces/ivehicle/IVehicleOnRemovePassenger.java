package com.github.azeroth.game.scripting.interfaces.ivehicle;

import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IVehicleOnRemovePassenger extends IScriptObject {
    void OnRemovePassenger(Vehicle veh, Unit passenger);
}
