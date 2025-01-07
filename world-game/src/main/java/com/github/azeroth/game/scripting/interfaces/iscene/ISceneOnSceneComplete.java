package com.github.azeroth.game.scripting.interfaces.iscene;

import com.github.azeroth.game.domain.scene.SceneTemplate;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface ISceneOnSceneComplete extends IScriptObject {
    void onSceneComplete(Player player, int sceneInstanceID, SceneTemplate sceneTemplate);
}
