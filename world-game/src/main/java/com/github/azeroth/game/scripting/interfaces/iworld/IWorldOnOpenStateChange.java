package com.github.azeroth.game.scripting.interfaces.iworld;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IWorldOnOpenStateChange extends IScriptObject {
    void OnOpenStateChange(boolean open);
}
