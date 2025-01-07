package com.github.azeroth.game.scripting.interfaces.idynamicobject;

import com.github.azeroth.game.entity.dynamic.DynamicObject;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IDynamicObjectOnUpdate extends IScriptObject {
    void onUpdate(DynamicObject obj, int diff);
}
