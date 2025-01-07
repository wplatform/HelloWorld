package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import com.github.azeroth.game.spell.Spell;

/**
 * Called when the player casts a spell
 */
public interface IPlayerOnSpellCast extends IScriptObject, IClassRescriction {
    void onSpellCast(Player player, Spell spell, boolean skipCheck);
}
