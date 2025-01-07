package com.github.azeroth.game.scripting.interfaces.iguild;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.guild.Guild;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGuildOnAddMember extends IScriptObject {
    void onAddMember(Guild guild, Player player, byte plRank);
}
