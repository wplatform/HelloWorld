package com.github.azeroth.game.scripting.interfaces.iitem;

import com.github.azeroth.game.entity.item.Item;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import com.github.azeroth.game.spell.SpellCastTargets;

public interface IItemOnUse extends IScriptObject {
    boolean OnUse(Player player, Item item, SpellCastTargets targets, ObjectGuid castId);
}
