package com.github.azeroth.game.scripting.interfaces.iguild;

import com.github.azeroth.game.entity.item.Item;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.guild.Guild;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGuildOnItemMove extends IScriptObject {
    void OnItemMove(Guild guild, Player player, Item pItem, boolean isSrcBank, byte srcContainer, byte srcSlotId, boolean isDestBank, byte destContainer, byte destSlotId);
}
