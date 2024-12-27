package com.github.mmo.game.scripting.interfaces.iachievement;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

public interface IAchievementOnCompleted extends IScriptObject
{
	void OnCompleted(Player player, AchievementRecord achievement);
}
