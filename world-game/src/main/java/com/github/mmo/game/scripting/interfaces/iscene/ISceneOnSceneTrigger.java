package com.github.mmo.game.scripting.interfaces.iscene;

import com.github.mmo.game.SceneTemplate;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

public interface ISceneOnSceneTrigger extends IScriptObject
{
	void OnSceneTriggerEvent(Player player, int sceneInstanceID, SceneTemplate sceneTemplate, String triggerName);
}
