package com.github.mmo.game.scripting.interfaces.igameobject;

import com.github.mmo.game.ai.*;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.scripting.interfaces.*;

public interface IGameObjectGetAI extends IScriptObject
{
	GameObjectAI getAI(GameObject go);
}
