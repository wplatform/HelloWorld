package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

public interface IPlayerOnPVPKill extends IScriptObject
{
	void OnPVPKill(Player killer, Player killed);
}
