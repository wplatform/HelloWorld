package com.github.azeroth.game.scripting.interfaces.iworld;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IWorldOnConfigLoad extends IScriptObject {
    void OnConfigLoad(boolean reload);
}
