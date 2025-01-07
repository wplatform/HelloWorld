package com.github.azeroth.game.scripting.interfaces.iworld;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IWorldOnShutdownInitiate extends IScriptObject {
    void OnShutdownInitiate(ShutdownExitCode code, ShutdownMask mask);
}
