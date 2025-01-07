package com.github.azeroth.game.scripting.interfaces.iworld;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IWorldOnMotdChange extends IScriptObject {
    void OnMotdChange(String newMotd);
}
