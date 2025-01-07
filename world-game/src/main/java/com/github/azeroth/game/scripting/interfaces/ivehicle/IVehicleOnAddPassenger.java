package com.github.azeroth.game.scripting.interfaces.ivehicle;

import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IVehicleOnAddPassenger extends IScriptObject {
    void OnAddPassenger(Vehicle veh, Unit passenger, byte seatId);
}
