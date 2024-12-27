package com.github.mmo.game.scripting.interfaces.iitem;

import com.github.mmo.game.entity.item.Item;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

public interface IItemOnRemove extends IScriptObject
{
	boolean onRemove(Player player, Item item);
}
