package com.github.mmo.game.scripting.interfaces.ivehicle;

import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IVehicleOnReset extends IScriptObject {
    void onReset(Vehicle veh);
}
