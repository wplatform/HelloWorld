package com.github.mmo.game.scripting.interfaces.iworld;

import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IWorldOnUpdate extends IScriptObject {
    void onUpdate(int diff);
}
