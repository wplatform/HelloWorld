package com.github.azeroth.game.scripting.interfaces.iachievement;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IAchievementOnCompleted extends IScriptObject {
    void OnCompleted(Player player, AchievementRecord achievement);
}
