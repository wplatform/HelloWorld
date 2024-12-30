package com.github.mmo.game.scripting.interfaces.iitem;

import com.github.mmo.game.entity.item.Item;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;
import com.github.mmo.game.spell.SpellCastTargets;

public interface IItemOnUse extends IScriptObject {
    boolean OnUse(Player player, Item item, SpellCastTargets targets, ObjectGuid castId);
}
