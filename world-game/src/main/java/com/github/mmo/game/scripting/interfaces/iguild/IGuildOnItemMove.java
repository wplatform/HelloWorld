package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.entity.item.Item;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.guild.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IGuildOnItemMove extends IScriptObject
{
	void OnItemMove(Guild guild, Player player, Item pItem, boolean isSrcBank, byte srcContainer, byte srcSlotId, boolean isDestBank, byte destContainer, byte destSlotId);
}
