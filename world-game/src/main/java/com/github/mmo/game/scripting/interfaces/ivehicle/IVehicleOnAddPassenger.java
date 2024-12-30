package com.github.mmo.game.scripting.interfaces.ivehicle;

import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IVehicleOnAddPassenger extends IScriptObject {
    void OnAddPassenger(Vehicle veh, Unit passenger, byte seatId);
}
