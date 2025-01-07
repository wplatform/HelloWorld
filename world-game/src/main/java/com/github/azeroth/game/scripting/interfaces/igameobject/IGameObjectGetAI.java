package com.github.azeroth.game.scripting.interfaces.igameobject;

import com.github.azeroth.game.ai.GameObjectAI;
import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGameObjectGetAI extends IScriptObject {
    GameObjectAI getAI(GameObject go);
}
