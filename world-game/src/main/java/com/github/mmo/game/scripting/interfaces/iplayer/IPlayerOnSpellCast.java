package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.spell.*;
import com.github.mmo.game.scripting.interfaces.*;

/** 
  Called when the player casts a spell
*/
public interface IPlayerOnSpellCast extends IScriptObject, IClassRescriction
{
	void onSpellCast(Player player, Spell spell, boolean skipCheck);
}