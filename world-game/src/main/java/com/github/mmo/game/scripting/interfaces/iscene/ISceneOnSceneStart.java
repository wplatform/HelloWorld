package com.github.mmo.game.scripting.interfaces.iscene;

import com.github.mmo.game.SceneTemplate;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface ISceneOnSceneStart extends IScriptObject {
    void OnSceneStart(Player player, int sceneInstanceID, SceneTemplate sceneTemplate);
}
