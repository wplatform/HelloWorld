package com.github.mmo.game.scripting.interfaces.iscene;

import com.github.mmo.game.SceneTemplate;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface ISceneOnSceneChancel extends IScriptObject {
    void onSceneCancel(Player player, int sceneInstanceID, SceneTemplate sceneTemplate);
}
