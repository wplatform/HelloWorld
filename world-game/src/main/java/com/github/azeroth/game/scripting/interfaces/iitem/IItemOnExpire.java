package com.github.azeroth.game.scripting.interfaces.iitem;

import com.github.azeroth.game.entity.item.ItemTemplate;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IItemOnExpire extends IScriptObject {
    boolean OnExpire(Player player, ItemTemplate proto);
}
