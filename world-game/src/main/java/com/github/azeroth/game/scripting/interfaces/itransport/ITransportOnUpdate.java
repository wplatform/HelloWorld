package com.github.azeroth.game.scripting.interfaces.itransport;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface ITransportOnUpdate extends IScriptObject {
    void onUpdate(Transport obj, int diff);
}
