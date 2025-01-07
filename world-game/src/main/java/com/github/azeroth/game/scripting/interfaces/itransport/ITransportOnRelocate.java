package com.github.azeroth.game.scripting.interfaces.itransport;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface ITransportOnRelocate extends IScriptObject {

    void OnRelocate(Transport transport, int mapId, double x, double y, double z);
}
