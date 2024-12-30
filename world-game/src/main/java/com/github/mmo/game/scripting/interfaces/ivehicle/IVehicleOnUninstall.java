package com.github.mmo.game.scripting.interfaces.ivehicle;

import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IVehicleOnUninstall extends IScriptObject {
    void OnUninstall(Vehicle veh);
}
