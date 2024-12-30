package com.github.mmo.game.scripting.interfaces.itransport;

import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface ITransportOnRelocate extends IScriptObject {

    void OnRelocate(Transport transport, int mapId, double x, double y, double z);
}
