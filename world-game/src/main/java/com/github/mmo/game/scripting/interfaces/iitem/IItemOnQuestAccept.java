package com.github.mmo.game.scripting.interfaces.iitem;

import com.github.mmo.game.entity.item.Item;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IItemOnQuestAccept extends IScriptObject {
    boolean onQuestAccept(Player player, Item item, Quest quest);
}
