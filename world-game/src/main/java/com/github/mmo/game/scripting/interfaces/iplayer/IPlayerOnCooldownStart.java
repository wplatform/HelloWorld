package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.spell.*;
import com.github.mmo.game.scripting.interfaces.*;
import java.time.*;


public interface IPlayerOnCooldownStart extends IScriptObject, IClassRescriction
{
	void OnCooldownStart(Player player, SpellInfo spellInfo, int itemId, int categoryId, Duration cooldown, tangible.RefObject<LocalDateTime> cooldownEnd, tangible.RefObject<LocalDateTime> categoryEnd, tangible.RefObject<Boolean> onHold);
}
