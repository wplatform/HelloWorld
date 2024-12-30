package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.guild.Guild;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGuildOnBankEvent extends IScriptObject {
    void OnBankEvent(Guild guild, byte eventType, byte tabId, long playerGuid, int itemOrMoney, short itemStackCount, byte destTabId);
}
