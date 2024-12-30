package com.github.mmo.game.scripting.interfaces.iworld;

import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IWorldOnConfigLoad extends IScriptObject {
    void OnConfigLoad(boolean reload);
}
