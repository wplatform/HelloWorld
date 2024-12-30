package com.github.mmo.game.scripting.interfaces.idynamicobject;

import com.github.mmo.game.entity.dynamic.DynamicObject;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IDynamicObjectOnUpdate extends IScriptObject {
    void onUpdate(DynamicObject obj, int diff);
}
