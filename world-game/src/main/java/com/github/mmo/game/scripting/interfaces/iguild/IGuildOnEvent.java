package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.guild.Guild;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGuildOnEvent extends IScriptObject {
    void OnEvent(Guild guild, byte eventType, long playerGuid1, long playerGuid2, byte newRank);
}
