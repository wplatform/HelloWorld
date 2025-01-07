package com.github.azeroth.game.scripting.interfaces.ivehicle;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IVehicleOnReset extends IScriptObject {
    void onReset(Vehicle veh);
}
