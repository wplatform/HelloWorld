package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player gains XP (before anything is given);
public interface IPlayerOnGiveXP extends IScriptObject {
    void OnGiveXP(Player player, tangible.RefObject<Integer> amount, Unit victim);
}
