package com.github.azeroth.game.scripting.interfaces.iguild;

import com.github.azeroth.game.guild.Guild;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGuildOnBankEvent extends IScriptObject {
    void OnBankEvent(Guild guild, byte eventType, byte tabId, long playerGuid, int itemOrMoney, short itemStackCount, byte destTabId);
}
