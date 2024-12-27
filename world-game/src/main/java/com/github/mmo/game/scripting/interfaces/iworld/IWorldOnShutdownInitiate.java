package com.github.mmo.game.scripting.interfaces.iworld;

import com.github.mmo.game.scripting.interfaces.*;public interface IWorldOnShutdownInitiate extends IScriptObject {
    void OnShutdownInitiate(ShutdownExitCode code, ShutdownMask mask);
}
