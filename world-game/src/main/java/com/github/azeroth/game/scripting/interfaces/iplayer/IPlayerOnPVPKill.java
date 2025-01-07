package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnPVPKill extends IScriptObject {
    void OnPVPKill(Player killer, Player killed);
}
