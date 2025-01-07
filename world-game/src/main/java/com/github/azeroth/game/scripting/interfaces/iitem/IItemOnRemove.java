package com.github.azeroth.game.scripting.interfaces.iitem;

import com.github.azeroth.game.entity.item.Item;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IItemOnRemove extends IScriptObject {
    boolean onRemove(Player player, Item item);
}
