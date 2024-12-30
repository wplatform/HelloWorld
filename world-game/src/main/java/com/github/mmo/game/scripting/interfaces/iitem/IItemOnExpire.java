package com.github.mmo.game.scripting.interfaces.iitem;

import com.github.mmo.game.entity.item.ItemTemplate;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IItemOnExpire extends IScriptObject {
    boolean OnExpire(Player player, ItemTemplate proto);
}
