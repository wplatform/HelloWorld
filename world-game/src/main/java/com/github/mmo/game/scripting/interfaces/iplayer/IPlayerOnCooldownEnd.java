package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.spell.*;
import com.github.mmo.game.scripting.interfaces.*;public interface IPlayerOnCooldownEnd extends IScriptObject, IClassRescriction {

    void OnCooldownEnd(Player player, SpellInfo spellInfo, int itemId, int categoryId);
}
