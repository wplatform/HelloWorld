package com.github.mmo.game.scripting.interfaces.imap;

import com.github.mmo.game.map.*;
import com.github.mmo.game.scripting.interfaces.*;public interface IMapOnDestroy<T extends Map> extends IScriptObject {
    void OnDestroy(T map);
}
