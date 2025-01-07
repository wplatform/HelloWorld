package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import com.github.azeroth.game.spell.SpellInfo;

public interface IPlayerOnCooldownEnd extends IScriptObject, IClassRescriction {

    void OnCooldownEnd(Player player, SpellInfo spellInfo, int itemId, int categoryId);
}
