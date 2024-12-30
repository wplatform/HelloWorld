package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IClassRescriction;
import com.github.mmo.game.scripting.interfaces.IScriptObject;
import com.github.mmo.game.spell.SpellInfo;

public interface IPlayerOnCooldownEnd extends IScriptObject, IClassRescriction {

    void OnCooldownEnd(Player player, SpellInfo spellInfo, int itemId, int categoryId);
}
