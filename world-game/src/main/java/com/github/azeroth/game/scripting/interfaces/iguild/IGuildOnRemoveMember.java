package com.github.azeroth.game.scripting.interfaces.iguild;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGuildOnRemoveMember extends IScriptObject {
    void onRemoveMember(Guild guild, Player player, boolean isDisbanding, boolean isKicked);
}
