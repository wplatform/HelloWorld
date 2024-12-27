package com.github.mmo.game.scripting.interfaces.iitem;

import com.github.mmo.game.entity.item.Item;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.spell.*;
import com.github.mmo.game.scripting.interfaces.*;public interface IItemOnCastItemCombatSpell extends IScriptObject {
    boolean OnCastItemCombatSpell(Player player, Unit victim, SpellInfo spellInfo, Item item);
}
