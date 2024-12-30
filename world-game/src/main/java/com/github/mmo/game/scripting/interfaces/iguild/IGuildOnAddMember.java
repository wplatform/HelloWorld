package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.guild.Guild;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGuildOnAddMember extends IScriptObject {
    void onAddMember(Guild guild, Player player, byte plRank);
}
