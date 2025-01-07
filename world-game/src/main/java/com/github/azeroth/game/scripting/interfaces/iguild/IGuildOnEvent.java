package com.github.azeroth.game.scripting.interfaces.iguild;

import com.github.azeroth.game.guild.Guild;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGuildOnEvent extends IScriptObject {
    void OnEvent(Guild guild, byte eventType, long playerGuid1, long playerGuid2, byte newRank);
}
