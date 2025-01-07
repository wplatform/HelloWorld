package com.github.azeroth.game.scripting.interfaces.iitem;

import com.github.azeroth.game.entity.item.Item;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import com.github.azeroth.game.spell.SpellInfo;

public interface IItemOnCastItemCombatSpell extends IScriptObject {
    boolean OnCastItemCombatSpell(Player player, Unit victim, SpellInfo spellInfo, Item item);
}
