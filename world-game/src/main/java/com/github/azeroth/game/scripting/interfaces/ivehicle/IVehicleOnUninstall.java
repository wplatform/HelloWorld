package com.github.azeroth.game.scripting.interfaces.ivehicle;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IVehicleOnUninstall extends IScriptObject {
    void OnUninstall(Vehicle veh);
}
