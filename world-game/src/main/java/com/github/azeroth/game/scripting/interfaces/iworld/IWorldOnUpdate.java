package com.github.azeroth.game.scripting.interfaces.iworld;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IWorldOnUpdate extends IScriptObject {
    void onUpdate(int diff);
}
